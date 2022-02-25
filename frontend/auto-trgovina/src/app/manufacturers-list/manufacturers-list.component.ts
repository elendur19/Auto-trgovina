import { Component, OnInit } from '@angular/core';
import { Manufacturer } from '../model/Manufacturer';
import { VehicleService } from '../service/vehicle.service';
import { Router } from '@angular/router';
import { ManufacturerService } from '../service/manufacturer.service';

@Component({
  selector: 'app-manufacturers-list',
  templateUrl: './manufacturers-list.component.html',
  styleUrls: ['./manufacturers-list.component.css']
})
export class ManufacturersListComponent implements OnInit {

  manufacturers: Manufacturer[]
  selected: boolean = false;
  selectedManufacturer: Manufacturer = new Manufacturer;
  vehicleManufacturer: string;
  noManufacturers:boolean = false;

  constructor(private manufacturerService: ManufacturerService,
    private router: Router) {
  }


  ngOnInit(): void {
    this.getAll();
  }

  public getAll() {
    this.manufacturerService.findAll().subscribe(data => {
      this.manufacturers = data;
    })
  }

  manufacturerClicked(manufacturer: Manufacturer) {
    this.selected = true;
    this.selectedManufacturer = manufacturer;
  }

  toLoginPage() {
    this.router.navigate(['login']);
  }

}
