import { Injectable } from '@angular/core';
import { RestService } from '../rest.service';
import { Observable } from 'rxjs';
import { User } from '../model/user';



const URL = 'http://localhost:8085/';
const PATH = 'user';
const URL_PATH = URL + PATH;

@Injectable({
  providedIn: 'root'
})
export class UserService {

    constructor(private rest: RestService) { }

    addUser(user: User): Observable<any> {
        console.log(URL_PATH);
        console.log(user);
        return this.rest.post(URL_PATH + '/add-user', user);
    }


    list(): Observable<any> {
        return this.rest.get(URL_PATH + '/add');

    }
}
