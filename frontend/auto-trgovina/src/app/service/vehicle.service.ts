import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Router } from '@angular/router';
import { VehicleModel } from '../model/VehicleModel';
import { VehicleResponse } from '../model/VehicleResponse';


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

   public findAll(params: HttpParams): Observable<VehicleResponse> {
    const options = { params: params };
     return this.http.get<VehicleResponse>(this.vehiclesUrl + '/sort', options);
   }

   public filterVehicles(manufacturerId: number): Observable<VehicleModel[]> {
     return this.http.get<VehicleModel[]>(this.vehiclesUrl + '/filter', {
       params: {
         manufacturer: manufacturerId
       }});
   }

   public getVehicleById(vehicleId: number): Observable<VehicleModel> {
      return this.http.get<VehicleModel>(this.vehiclesUrl + '/' + vehicleId);
  }

  public deleteVehicle(vehicleId: number): Observable<any> {
    console.log("zahtjev za brisanje auta sa id: " + vehicleId);
    return this.http.delete<any>(this.vehiclesUrl + '/' + vehicleId );
  }

  public save(vehicle: VehicleModel) {
    return this.http.post<VehicleModel>(this.vehiclesUrl, vehicle);
  }

  public update(vehicle: VehicleModel) {
    return this.http.put<VehicleModel>(this.vehiclesUrl + '/' + vehicle.id, vehicle);
  }
}