import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductComponent } from './product/product.component';
import { UserComponent } from './user/user.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import {DashboardComponent} from './dashboard/dashboard.component';

const routes: Routes = [
    {path: '', component: ProductComponent},
    {path: 'product/list-all', component: ProductComponent},
    {path: 'product/list-item', component: ProductListComponent},
    {path: 'product/adm', component: ProductComponent},
    {path: 'user/add', component: UserComponent},
    {path: 'dashboard', component: DashboardComponent}

]

@NgModule({
    imports: [ RouterModule.forRoot( routes ) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
