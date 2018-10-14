import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { MatPaginator, MatSort } from '@angular/material';
import { merge, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';
import { Produto } from '../model/produto';
import { ProdutoService } from '../service/produto.service';


@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {
  @ViewChild('form') form: NgForm;
  selected = new FormControl(0);
  produtos = [] as Produto[];
  produto = {} as Produto;

  size: number = 10;
  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;
  displayedColumns = ['nome', 'ativo', 'action'];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: ProdutoService) { }

  ngOnInit() {
    this.sort.direction = 'asc';
    this.processDataSource();
  }

  processDataSource() {
    this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);
    merge(this.sort.sortChange, this.paginator.page).pipe(startWith({}), switchMap(() => {
      this.isLoadingResults = true;
      return this.service.listar(this.sort.direction, this.paginator.pageIndex, this.size);
    }), map((produtos: Produto[]) => {
      this.isLoadingResults = false;
      this.isRateLimitReached = false;
      this.service.count().subscribe(count => this.resultsLength = count);
      return produtos;
    }), catchError(() => {
      this.isLoadingResults = false;
      this.isRateLimitReached = true;
      return observableOf([]);
    })).subscribe(data => this.produtos = data);
  }

  openCadastro() {
    this.selected.setValue(1);
  }

  openListar() {
    this.form.resetForm();
    this.selected.setValue(0);
    this.processDataSource();
  }

  onSubmit() {
    if (this.form.submitted && this.form.valid) {
      this.service.salvar(this.produto).subscribe(value => this.openListar());
    }
  }

  onEdit(produto: Produto) {
    this.produto = produto;
    this.openCadastro();
  }

  onDelete(produto: Produto) {
    this.service.deletar(produto).subscribe(value => this.processDataSource());
  }
}
