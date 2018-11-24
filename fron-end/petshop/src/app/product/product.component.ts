import { Component, OnInit, ViewChild, Input } from '@angular/core';

import { Product } from '../model/product';
import { ProductService } from './product.service';
import { NgForm, FormControl } from '@angular/forms';
import { CategoryComponent } from './category/category.component';
import { Category } from '../model/category';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  @ViewChild('form') form: NgForm;
  selected = new FormControl(0);
  
  products = [] as Product[];
  product = {} as Product;

  category: CategoryComponent;

  categorys: Category[] = [
    {value: 'Accessories', viewValue: 'Accessories'},
    {value: 'Bath and Tosa', viewValue: 'Bath and Tosa'},
    {value: 'Clothing', viewValue: 'Clothing'},
    {value: 'Food', viewValue: 'Food'},
    {value: 'Medication', viewValue: 'Medication'},
    {value: 'Toys', viewValue: 'Toys'}
  ];

  @Input() selectedValue='';

  constructor(private service: ProductService) { }

  ngOnInit() {
    this.processDataSource();
  }

  processDataSource() {
    this.service.list().subscribe(response => {
      this.products = response
    })
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
      console.log(this.product);
      console.log('selected' + this.selectedValue);
      console.log('selected' + this.category);
      this.product.category = this.selectedValue;
      //console.log(this.category);
      //this.product.category = this.category.selectedValue;
      this.service.addProduct(this.product).subscribe(value => this.product);
      console.log(this.product.idProduct);
    }
  }

  onEdit(product: Product) {
    this.product = product;
    this.openCadastro();
  }

  onDelete(product: Product) {
    this.service.deletar(product).subscribe(value => this.processDataSource());
  }

}
