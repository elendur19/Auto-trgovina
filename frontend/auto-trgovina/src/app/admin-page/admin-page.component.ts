import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['./admin-page.component.css']
})
export class AdminPageComponent implements OnInit {

   username: string;
   password: string;
   badCredentials: boolean = false;

  constructor(private userService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
  }

  validateUser() {
    console.log("username -> " + this.username + " and password -> " + this.password);
    localStorage.setItem('username', this.username);
    localStorage.setItem('password', this.password);
    this.userService.authenticate().subscribe(user => {
      console.log("trying to validate user");
    },(error => {
      // error ocurred, user entered invalid credentials
      this.badCredentials = true;
    }) );
    
  }

  routeToMainPage() {
    this.router.navigate(['manufacturers']);``
  }
}
