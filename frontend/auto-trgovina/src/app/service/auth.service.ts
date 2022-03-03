import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Admin } from "../model/Admin";
import { User } from "../model/User";


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

    authenticate(username: string, password: string): boolean {

        let body: HttpParams = new HttpParams();
        body = body.append('username', username);
        body = body.append('password', password);
        
        console.log("Username --> " + username);

        this.http.post<any>('http://localhost:8080/api/login', body).subscribe(response => {
            console.log("Successfull login.");
            localStorage.setItem('tokenID', response.access_token);
            this.authenticated = true;
            this.router.navigateByUrl('/manufacturers');
        }, 
        (error: HttpErrorResponse) => {
            this.authenticated = false;
            console.log("Unsuccessfull login attempt.");
        });      
        return this.authenticated;
    }

    register(user: User) {
        const requestBody = { 'firstName': user.firstName,
                              'lastName': user.lastName, 
                              'username': user.username, 
                              'password': user.password
                            }

        this.http.post('http://localhost:8080/api/register', requestBody).subscribe(response => {
            console.log("User registered.");
            this.router.navigateByUrl('/login');      
            },
            (error: HttpErrorResponse) => {
                console.log("Error during user registration.");
            });
        }
}