import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { Produto } from '../model/produto';
import { ProdutoService } from './produto.service';
import { merge, of } from 'rxjs';
import { switchMap, map, catchError } from 'rxjs/operators';


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

  constructor(private service: ProdutoService) { }

  ngOnInit() {
    this.processDataSource();
  }

  processDataSource() {
    this.service.listar().subscribe(response => {
      this.produtos = response
    });
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
      console.log(this.produto);
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
