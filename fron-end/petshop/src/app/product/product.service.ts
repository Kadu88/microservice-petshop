import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';
import { RestService } from '../rest.service';
import { Product } from '../model/product';


const PATH = 'product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private rest: RestService) { }

  list(): Observable<any> {
    return this.rest.get(PATH + '/get-all-product');
  }

  count(): Observable<any> {
    return this.rest.get(PATH + '/count');
  }

  addProduct(product: Product): Observable<any> {
    console.log('produto-service' + product);
    return this.rest.post(PATH + '/add-product', product);
  }

  deletar(product: Product): Observable<any> {
    return this.rest.delete(PATH, product.idProduct);
  }
}
