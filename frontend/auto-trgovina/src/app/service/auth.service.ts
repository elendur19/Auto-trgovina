import { HttpClient, HttpHeaders } from "@angular/common/http";
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

    authenticate(credentials: any) {

        const headers = new HttpHeaders(credentials ? {
            'Authorization' : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});

        this.http.get('http://localhost:8080/api/authorize', {headers: headers}).subscribe(response => {
            if (response) {
                this.authenticated = true;
            } else {
                this.authenticated = false;
            }
            this.router.navigateByUrl('/');
            return false;
        });

    }
}