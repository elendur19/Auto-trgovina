import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../model/Vehicle';
import { VehicleService } from '../service/vehicle.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {

  vehicles: Vehicle[]
  selected: boolean = false;
  selectedVehicle: Vehicle = new Vehicle;

  constructor(private vehicleService: VehicleService,
    private router: Router) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  public getAll() {
    this.vehicleService.findAll().subscribe(data => {
      this.vehicles = data;
    })
  }

  vehicleClicked(vehicle: Vehicle) {
    this.selected = true;
    this.selectedVehicle = vehicle;
  }

  deleteVehicle(vehicleId: number) {
    console.log("pozvao sam fju. za brisanje, id: " + vehicleId);
    this.vehicleService.deleteVehicle(vehicleId).subscribe(data => {
      console.log("data brisanja --> " + data)
      this.getAll();
    })
  }

  newVehicle() {
    console.log("pozvana add");
    this.router.navigate(['new']);
  }

  editVehicle(vehicleId: number) {
      this.router.navigate(['edit'], { state: { id: vehicleId } })
  }
}