import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductComponent } from './product/product.component';
import { UserComponent } from './user/user.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { CartComponent } from './cart/cart.component';
import { HomeModule } from './home/home.module';
import { SigninComponent } from './home/signin/signin.component';

const routes: Routes = [
    {path: 'product/list-all', component: ProductComponent},
    {path: 'product/list-item', component: ProductListComponent},
    {path: 'product/adm', component: ProductComponent},
    {path: 'user/add', component: UserComponent},
    {path: 'cart/open', component: CartComponent},
    {path: '', component: SigninComponent }

]

@NgModule({
    imports: [ RouterModule.forRoot( routes ) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule { }
