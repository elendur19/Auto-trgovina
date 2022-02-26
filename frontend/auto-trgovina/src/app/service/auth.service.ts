import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Admin } from "../model/Admin";


@Injectable({
    providedIn: 'root'
  })
export class AuthService {
    private userUrl: string;
    authenticated = false;

    constructor(private http: HttpClient,
        private router: Router) {
            //this.userUrl = ;
    }

    public getUserInfo(): string {
        return btoa(localStorage.getItem("username") + ":" + localStorage.getItem("password"));
    }

    authenticate(credentials: any): boolean {

        const headers = new HttpHeaders(credentials ? {
            'Authorization' : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});

        this.http.get('http://localhost:8080/api/authorize', {headers: headers}).subscribe(response => {
            console.log("Successfull login.");
            this.authenticated = true;
            this.router.navigateByUrl('/manufacturers');
        },
        (error: HttpErrorResponse) => {
            this.authenticated = false;
            console.log("Unsuccessfull login attempt.");
        });      
        return this.authenticated;
    }
}