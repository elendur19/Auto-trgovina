import { Component, Input, OnInit } from '@angular/core';
import { Vehicle } from '../model/Vehicle';
import { VehicleService } from '../service/vehicle.service';
import { Router } from '@angular/router';
import { Manufacturer } from '../model/Manufacturer';

@Component({
  selector: 'app-vehicle-list-user',
  templateUrl: './vehicle-list-user.component.html',
  styleUrls: ['./vehicle-list-user.component.css']
})
export class VehicleListUserComponent implements OnInit {

  vehicles: Vehicle[]
  selected: boolean = false;
  selectedVehicle: Vehicle = new Vehicle;
  private _vehicleManufacturer: Manufacturer;
  
  get vehicleManufacturer(): Manufacturer {
    return this._vehicleManufacturer;
  }
  @Input()
  set vehicleManufacturer(val: Manufacturer) {
    this._vehicleManufacturer = val;
    this.filterVehicles();
  }
  noVehicles:boolean = false;

  constructor(private vehicleService: VehicleService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.filterVehicles();
  }

  public getAll() {
    this.vehicleService.findAll().subscribe(data => {
      this.vehicles = data;
    })
  }

  vehicleClicked(vehicle: Vehicle) {
    this.selected = true;
    this.selectedVehicle = vehicle;
    this.router.navigate(['vehicle'], { state: { id: this.selectedVehicle.id } })
  }

  filterVehicles() {
    this.vehicleService.filterVehicles(this.vehicleManufacturer.id).subscribe(filteredVehicles => {
      this.vehicles = filteredVehicles;
      if (this.vehicles.length == 0) {
        console.log("there are no cars with manufacturer ---> " + this.vehicleManufacturer);
        this.noVehicles = true;
      }
    })
  }

  dropFilter() {
    this.vehicleService.findAll().subscribe(data => {
      this.vehicles = data;
      this.vehicleManufacturer = new Manufacturer;
      this.noVehicles = false;
    })
  }

}
