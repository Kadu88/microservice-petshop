import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/Http';
import { CommonModule } from '@angular/common';

import { ProductComponent } from './product.component';
import { ProductListComponent } from './product-list/product-list.component';


@NgModule({
    declarations: [ 
        ProductComponent,
        ProductListComponent
    ],
    imports: [
        HttpClientModule,
        CommonModule
    ]
})
export class ProductModule {}