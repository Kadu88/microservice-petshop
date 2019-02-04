import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RestService } from '../rest.service';
import { Product } from '../model/product';


const URL = 'http://localhost:8086/';
const PATH = 'product';
const URL_PATH = URL + PATH;

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private rest: RestService) { }

  list(): Observable<any> {
    return this.rest.get(URL_PATH + '/get-all-product');
  }

  count(): Observable<any> {
    return this.rest.get(URL_PATH + '/count');
  }

  addProduct(product: Product): Observable<any> {
    return this.rest.post(URL_PATH + '/add-product', product);
  }

  deletar(product: Product): Observable<any> {
    return this.rest.delete(URL_PATH, product.idProduct);
  }
}
