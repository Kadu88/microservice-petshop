import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/Http';
import { CommonModule } from '@angular/common';

import { ProductComponent } from './product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { CategoryComponent } from './category/category.component';


@NgModule({
    declarations: [ 
        ProductComponent,
        ProductListComponent,
        CategoryComponent
    ],
    imports: [
        HttpClientModule,
        CommonModule
    ],
    exports: [
        CategoryComponent
    ]
})
export class ProductModule {}