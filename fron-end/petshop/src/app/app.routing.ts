import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { ProductComponent } from './product/product.component';

const routes: Routes = [
    {path: 'product/list-all', component:ProductComponent}
]

@NgModule({
    imports: [ RouterModule.forRoot( routes ) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}