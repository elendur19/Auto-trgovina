import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HttpHeaders, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleService } from './service/vehicle.service';
import { VehicleContainerComponent } from './vehicle-container/vehicle-container.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';
import { FormsModule } from '@angular/forms';
import { VehicleListUserComponent } from './vehicle-list-user/vehicle-list-user.component';
import { ManufacturersListComponent } from './manufacturers-list/manufacturers-list.component';
import { LoginComponent } from './login/login.component';
import { ManufacturerService } from './service/manufacturer.service';
import { AuthService } from './service/auth.service';
//import { AuthInterceptor } from './auth.interceptor';
import { ResponseInterceptor } from './response.interceptor';
import { HomeComponent } from './home/home.component';

//import { MatSidenavModule } from '@angular/';

@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    VehicleContainerComponent,
    VehicleDetailComponent,
    NewVehicleComponent,
    VehicleListUserComponent,
    ManufacturersListComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ResponseInterceptor,
      multi: true
    },
    VehicleService,
    ManufacturerService,
    AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
