import {Injectable} from '@angular/core';
import {RestService} from '../rest.service';
import {Observable} from 'rxjs';

const URL = 'http://localhost:8087/';
const PATH = 'cart';
const URL_PATH = URL + PATH;

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private rest: RestService) { }

  list(): Observable<any> {
    return this.rest.get(URL_PATH + '/create-cart');
  }


}
