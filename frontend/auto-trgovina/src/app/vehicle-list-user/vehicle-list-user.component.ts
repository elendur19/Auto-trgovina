import { Component, Input, OnInit } from '@angular/core';
import { VehicleModel } from '../model/VehicleModel';
import { VehicleService } from '../service/vehicle.service';
import { Router } from '@angular/router';
import { Manufacturer } from '../model/Manufacturer';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-vehicle-list-user',
  templateUrl: './vehicle-list-user.component.html',
  styleUrls: ['./vehicle-list-user.component.css']
})
export class VehicleListUserComponent implements OnInit {

  vehicles: VehicleModel[]
  selected: boolean = false;
  selectedVehicle: VehicleModel = new VehicleModel;
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
    const params = new HttpParams()
      .set('page', 0)
      .set('size', 0)
    this.vehicleService.findAll(params).subscribe(data => {
      this.vehicles = data.content;
    })
  }

  vehicleClicked(vehicle: VehicleModel) {
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
    const params = new HttpParams()
      .set('page', 0)
      .set('size', 10)
  
    this.vehicleService.findAll(params).subscribe(data => {
      this.vehicles = data.content;
      this.vehicleManufacturer = new Manufacturer;
      this.noVehicles = false;
    })
  }

}
