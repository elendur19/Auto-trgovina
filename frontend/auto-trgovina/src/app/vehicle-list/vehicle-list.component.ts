import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { VehicleModel } from '../model/VehicleModel';
import { VehicleService } from '../service/vehicle.service';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { HttpParams } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap'; // Import the NgbModal service
import { VehicleDetailComponent } from '../vehicle-detail/vehicle-detail.component';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {

  vehicles: VehicleModel[]
  pageSize = 10; // Number of items per page
  currentPage = 0; // Current page number
  totalItems = 0; // Total number of items
  selected: boolean = false;
  selectedVehicle: VehicleModel = new VehicleModel;

  constructor(private vehicleService: VehicleService,
    private router: Router,
    private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  public getAll() {
    const params = new HttpParams()
      .set('page', this.currentPage.toString())
      .set('size', this.pageSize.toString());

    this.vehicleService.findAll(params).subscribe(data => {
      this.vehicles = data.content;
      this.totalItems = data.totalElements;
    })
  }

  pageChanged(event: PageEvent) {
    console.log(event)
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.getAll();
  }

  vehicleClicked(vehicle: VehicleModel) {
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

  openCarDetails(vehicle: any) {
    const modalRef = this.modalService.open(VehicleDetailComponent); // Open the modal
    modalRef.componentInstance.vehicle = vehicle; // Pass the vehicle details to the component
  }

  newVehicle() {
    console.log("pozvana add");
    this.router.navigate(['new']);
  }

  editVehicle(vehicleId: number) {
      this.router.navigate(['edit'], { state: { id: vehicleId } })
  }

  logoutAdmin() {
    localStorage.clear();
    this.router.navigate(['/manufacturers']);
  }
}