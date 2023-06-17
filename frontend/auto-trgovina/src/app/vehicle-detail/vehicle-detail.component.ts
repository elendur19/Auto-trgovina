import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { VehicleModel } from '../model/VehicleModel';
import { Router } from '@angular/router';
import { VehicleService } from '../service/vehicle.service';

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {

  vehicle: VehicleModel;

  constructor(private router: Router,
    private vehicleService: VehicleService) { 
    let id = this.router.getCurrentNavigation()?.extras.state?.id;
    vehicleService.getVehicleById(id).subscribe(vehicleData => {
      this.vehicle = vehicleData;
      //console.log("dobiveno vozilo ime -> " + vehicleData.manufacturer.name);
      console.log("vozilo -> " + vehicleData);
      console.log("moje vozilo --> " + this.vehicle);
    });
  }

  ngOnInit(): void {
  }

  routeToMainPage() {
    this.router.navigate(['manufacturers']);
  }
}
