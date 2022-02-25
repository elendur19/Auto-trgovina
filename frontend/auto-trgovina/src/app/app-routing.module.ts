import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';
import { VehicleListUserComponent } from './vehicle-list-user/vehicle-list-user.component';
import { ManufacturersListComponent } from './manufacturers-list/manufacturers-list.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'manufacturers', component: ManufacturersListComponent },
  { path: 'vehicle', component: VehicleDetailComponent },
  { path: 'login', component: LoginComponent},
  { path: 'new', component: NewVehicleComponent },
  { path: 'edit', component: NewVehicleComponent },
  { path: 'manage', component: VehicleListComponent },
  { path: "**", redirectTo: "login"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
