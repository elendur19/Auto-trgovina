import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';
import { VehicleListUserComponent } from './vehicle-list-user/vehicle-list-user.component';
import { ManufacturersListComponent } from './manufacturers-list/manufacturers-list.component';
import { AdminPageComponent } from './admin-page/admin-page.component';

const routes: Routes = [
  { path: '', redirectTo: 'manufacturers', pathMatch: 'full' },
  { path: 'manufacturers', component: ManufacturersListComponent },
  { path: 'vehicle', component: VehicleDetailComponent },
  { path: 'admin', component: AdminPageComponent},
  { path: 'new', component: NewVehicleComponent },
  { path: 'edit', component: NewVehicleComponent },
  { path: 'manage', component: VehicleListComponent },
  { path: "**", redirectTo: "manufacturers"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
