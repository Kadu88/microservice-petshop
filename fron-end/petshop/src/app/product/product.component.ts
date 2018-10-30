import { Component, OnInit, ViewChild } from '@angular/core';

import { Product } from '../model/product';
import { ProductService } from './product.service';
import { NgForm, FormControl } from '@angular/forms';

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

  constructor(private service: ProductService) { }

  ngOnInit() {
    this.processDataSource();
  }

  processDataSource() {
    this.service.list().subscribe(response => {
      this.products = response
    })
  }

}
