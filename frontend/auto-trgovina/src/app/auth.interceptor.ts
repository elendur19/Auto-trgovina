import { Injectable } from '@angular/core';
import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor,
    HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AuthService } from './service/auth.service';
import { catchError } from 'rxjs/operators';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor(public authService: AuthService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (request.url.includes("/validateLogin")) {
            const encodedValue = this.authService.getUserInfo();
            request = request.clone({
                setHeaders: {
                    Authorization: 'Basic ' + encodedValue
                }
            });
        }

        return next.handle(request);
    }
}