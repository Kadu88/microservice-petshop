import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/Http';
import { CommonModule } from '@angular/common';
import { ProdutoComponent } from './produto.component';



@NgModule({
    declarations: [ 
        ProdutoComponent,
        ],
    imports: [
        HttpClientModule,
        CommonModule
    ]
})
export class ProdutoModule {}