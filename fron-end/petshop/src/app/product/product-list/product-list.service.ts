import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RestService } from '../../rest.service';
import { Product } from '../../model/product';


const URL = 'http://localhost:8086/'
const PATH = 'product';
const URL_PATH = URL + PATH;

@Injectable({
  providedIn: 'root'
})
export class ProductListService {

  constructor(private rest: RestService) { }

  list(): Observable<any> {
    return this.rest.get(URL_PATH + '/get-all-product');
  }

}
