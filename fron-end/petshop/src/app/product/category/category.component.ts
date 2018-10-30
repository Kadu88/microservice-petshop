import { Component, OnInit } from '@angular/core';
import {MatSelectModule} from '@angular/material/select';

@Component({
  selector: 'category-component',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {
  categorys: Category[] = [
    {value: 'Accessories', viewValue: 'Accessories'},
    {value: 'Bath and Tosa', viewValue: 'Bath and Tosa'},
    {value: 'Clothing', viewValue: 'Clothing'},
    {value: 'Food', viewValue: 'Food'},
    {value: 'Medication', viewValue: 'Medication'},
    {value: 'Toys', viewValue: 'Toys'}
  ];
  selectedValue:string;
}

export interface Category {
  value: string;
  viewValue: string;
}