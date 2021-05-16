import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';

const routes: Routes = [
  { path: '', redirectTo: 'vehicles', pathMatch: 'full' },
  { path: 'vehicles', component: VehicleListComponent },
  { path: 'new', component: NewVehicleComponent },
  { path: 'edit', component: NewVehicleComponent },
  { path: "**", redirectTo: "vehicles"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
