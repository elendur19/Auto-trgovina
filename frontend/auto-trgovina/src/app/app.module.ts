import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleService } from './service/vehicle.service';
import { VehicleContainerComponent } from './vehicle-container/vehicle-container.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';
import { FormsModule } from '@angular/forms';

//import { MatSidenavModule } from '@angular/';

@NgModule({
  declarations: [
    AppComponent,
    VehicleListComponent,
    VehicleContainerComponent,
    VehicleDetailComponent,
    NewVehicleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule
  ],
  providers: [VehicleService,],
  bootstrap: [AppComponent]
})
export class AppModule { }
