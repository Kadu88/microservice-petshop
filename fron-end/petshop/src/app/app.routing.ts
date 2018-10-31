import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductComponent } from './product/product.component';
import { ProdutoComponent } from './produto/produto.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
    {path: 'product/list-all', component:ProductComponent},
    {path: 'product/adm', component:ProdutoComponent},
    {path: 'user/add', component:UserComponent}

]

@NgModule({
    imports: [ RouterModule.forRoot( routes ) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}