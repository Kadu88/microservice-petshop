import { Injectable } from '@angular/core';
import { RestService } from '../rest.service';
import { Observable } from 'rxjs';


const URL = 'http://localhost:8087';
const PATH = 'user';
const URL_PATH = URL + PATH;

@Injectable({
    providedIn: 'root'
})
export class CartService {

    constructor(private rest: RestService) {
        //if has user, take user
        //else create user

        //with user, check if exist cart,
        //check if there is other cart in memory

        //if exist cart in memory or exclusive a cart for user, take it
        //if exist the two options, ask user what he want bring back

        //if don't have any cart, create a new cart
    }

    createCart(): Observable<any> {
        return this.rest.get(URL_PATH + '/create-cart');
    }
}
