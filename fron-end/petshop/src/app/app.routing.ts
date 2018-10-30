import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductComponent } from './product/product.component';
import { ProdutoComponent } from './produto/produto.component';

const routes: Routes = [
    {path: 'product/list-all', component:ProductComponent},
    {path: 'product/adm', component:ProdutoComponent}
]

@NgModule({
    imports: [ RouterModule.forRoot( routes ) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}