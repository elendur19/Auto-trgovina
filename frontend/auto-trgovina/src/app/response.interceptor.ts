import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
  HttpResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AuthService } from './service/auth.service';
import { catchError, map, tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable()
export class ResponseInterceptor implements HttpInterceptor {

  constructor(public authService: AuthService,
    private router: Router) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request).pipe(map((event: HttpEvent<any>) => {
      if (event instanceof HttpResponse && event.status === 200) {
        // credentials are valid
        if (event.url?.includes("/api/validateLogin")) {
          this.router.navigate(['manage'])
        }
      }
      return event;
    })).pipe(catchError((error: HttpErrorResponse) => {
      // credentials are not valid
      let errorMsg = 'not authenticated';
      if (error instanceof HttpErrorResponse) {
        console.log('HttpErrorResponse');
        if (error.status === 401) {
          console.log("not authenticated");
        }
      }
      return throwError(errorMsg);
    })
    )
  }

}
