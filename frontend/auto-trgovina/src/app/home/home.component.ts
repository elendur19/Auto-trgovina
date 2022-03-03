import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  public user = new User();

  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
  }

  registerUser() {
    console.log("user with username about to register -> " + this.user.username);
    this.authService.register(this.user);
    
  }

  loginPage() {
    this.router.navigate(['/login']);
  }

}
