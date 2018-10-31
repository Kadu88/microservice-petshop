import { Component, OnInit, Input } from '@angular/core';
import {MatSelectModule} from '@angular/material/select';
import { Category } from 'src/app/model/category';

@Component({
  selector: 'app-category',
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

  @Input() selectedValue='';
  
}