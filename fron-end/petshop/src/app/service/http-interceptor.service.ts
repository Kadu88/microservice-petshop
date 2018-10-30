import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, finalize, map } from 'rxjs/operators';

import { LoadingService } from './loading.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {
  constructor(private loadingService: LoadingService) { }

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      map(event => {
        console.log(req)
        this.loadingService.onStarted(req);
        return event
      }),
      catchError(error => { return Observable.throw(error) }),
      finalize(() => { this.loadingService.onFinished(req) })
    );
  }
}
