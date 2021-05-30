import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Router } from '@angular/router';
import { Manufacturer } from '../model/Manufacturer';


@Injectable({
  providedIn: 'root'
})
export class ManufacturerService {
 
  private manufacturersUrl: string;
  public manufacturerId: string;
  private manufacturerIdChange: Subject<string> = new Subject<string>();

  constructor(private http: HttpClient,
              private router: Router) {
      this.manufacturersUrl = 'http://localhost:8080/api/manufacturer';
      
      this.manufacturerIdChange.subscribe(manufacturerId => {
        this.manufacturerId = manufacturerId;
      })
   }

   public findAll(): Observable<Manufacturer[]> {
     return this.http.get<Manufacturer[]>(this.manufacturersUrl);
   }

}