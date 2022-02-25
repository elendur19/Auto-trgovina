import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {username: '', password: ''};
  badCredentials: boolean = false;

  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
  }

  validateUser() {
    console.log("username -> " + this.credentials.username + " and password -> " + this.credentials.password);
    //localStorage.setItem('username', this.username);
    //localStorage.setItem('password', this.password);
    this.authService.authenticate(this.credentials);
    
    console.log("trying to validate user");
  }

  routeToMainPage() {
    this.router.navigate(['manufacturers']);``
  }
}
