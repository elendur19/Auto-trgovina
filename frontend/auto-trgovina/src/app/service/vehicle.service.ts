import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Router } from '@angular/router';
import { Vehicle } from '../model/Vehicle';


@Injectable({
  providedIn: 'root'
})
export class VehicleService {
 
  private vehiclesUrl: string;
  public vehicleId: string;
  private vehicleIdChange: Subject<string> = new Subject<string>();

  constructor(private http: HttpClient,
              private router: Router) {
      this.vehiclesUrl = 'http://localhost:8080/api/vehicle';
      
      this.vehicleIdChange.subscribe(vehicleId => {
        this.vehicleId = vehicleId;
      })
   }

   public findAll(): Observable<Vehicle[]> {
     return this.http.get<Vehicle[]>(this.vehiclesUrl);
   }

   public getVehicleById(vehicleId: number): Observable<Vehicle> {
      return this.http.get<Vehicle>(this.vehiclesUrl + '/' + vehicleId);
  }

  public deleteVehicle(vehicleId: number): Observable<any> {
    console.log("zahtjev za brisanje auta sa id: " + vehicleId);
    return this.http.delete<any>(this.vehiclesUrl + '/' + vehicleId );
  }

  public save(vehicle: Vehicle) {
    return this.http.post<Vehicle>(this.vehiclesUrl, vehicle);
  }

  public update(vehicle: Vehicle) {
    return this.http.put<Vehicle>(this.vehiclesUrl + '/' + vehicle.id, vehicle);
  }
}