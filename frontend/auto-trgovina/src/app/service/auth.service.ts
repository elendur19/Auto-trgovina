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

    constructor(private http: HttpClient,
        private router: Router) {
            this.userUrl = 'http://localhost:8080/api/validateLogin';
    }

    public getUserInfo(): string {
        return btoa(localStorage.getItem("username") + ":" + localStorage.getItem("password"));
    }

    public authenticate(): Observable<Admin> {
        const credentials = this.getUserInfo();
        return this.http.get<Admin>(this.userUrl);
    }
}