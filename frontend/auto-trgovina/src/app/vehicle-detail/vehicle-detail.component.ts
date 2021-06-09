import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Vehicle } from '../model/Vehicle';
import { Router } from '@angular/router';
import { VehicleService } from '../service/vehicle.service';

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {

  vehicle: Vehicle;

  constructor(private router: Router,
    private vehicleService: VehicleService) { 
    let id = this.router.getCurrentNavigation()?.extras.state?.id
    vehicleService.getVehicleById(id).subscribe(vehicle => {
      this.vehicle = vehicle;
    })
  }

  ngOnInit(): void {
  }

  routeToMainPage() {
    this.router.navigate(['manufacturers']);
  }
}
