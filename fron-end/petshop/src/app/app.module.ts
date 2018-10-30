import { LayoutModule } from '@angular/cdk/layout';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProdutoComponent } from './produto/produto.component';
import { HttpInterceptorService } from './service/http-interceptor.service';
import { MaterialModule } from './utils/material/material.module';
import { ProductComponent } from './product/product.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { AppRoutingModule } from './app.routing';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    ProdutoComponent,
    ProductComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    ProductComponent,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    LayoutModule,
    AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
