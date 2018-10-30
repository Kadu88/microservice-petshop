import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';


const URL = environment.URL;

@Injectable({
  providedIn: 'root'
})
export class RestService {
  private headers: HttpHeaders;

  constructor(private http: HttpClient) {
     this.headers = new HttpHeaders().set(
       'Content-Type',
       'application/json; charset-UTF-8'
     );
  }

  public get(path: string, params?: HttpParams): Observable<any> {
    let dataObserver;
    let data = new Observable(observer => (dataObserver = observer));

    this.http
      .get(URL + path, {
        headers: this.headers,
        params: params,
        reportProgress: true
      })
      .subscribe(dados => {
        if (dataObserver != null) {
          dataObserver.next(dados);
        }
      });

    return data;
  }

  public post(path: string, body?: any): Observable<any> {
    let dataObserver;
    let data = new Observable(observer => (dataObserver = observer));
    let bodyJson = JSON.stringify(body);
    this.http
      .post(URL + path, bodyJson, { headers: this.headers })
      .subscribe(dados => {
        if (dataObserver != null) {
          dataObserver.next(dados);
        }
      });

    return data;
  }

  public put(path: string, body?: any): Observable<any> {
    let dataObserver;
    let data = new Observable(observer => (dataObserver = observer));

    let bodyJson = JSON.stringify(body);
    this.http
      .put(URL + path, bodyJson, { headers: this.headers })
      .subscribe(dados => {
        if (dataObserver != null) {
          dataObserver.next(dados);
        }
      });

    return data;
  }

  public delete(path: string, variable: any): Observable<any> {
    let dataObserver;
    let data = new Observable(observer => (dataObserver = observer));
    this.http.delete(URL + path + '/' + variable).subscribe(dados => {
      if (dataObserver != null) {
        dataObserver.next(dados);
      }
    });

    return data;
  }
}
