import { Component, OnInit } from '@angular/core';
import { VehicleModel } from '../model/VehicleModel';
import { FormsModule } from '@angular/forms';
import { VehicleService } from '../service/vehicle.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-vehicle',
  templateUrl: './new-vehicle.component.html',
  styleUrls: ['./new-vehicle.component.css']
})
export class NewVehicleComponent implements OnInit {

  public vehicle = new VehicleModel();
  action: string = "New";

  constructor(private vehicleService: VehicleService,
        private router: Router) {
          //console.log(this.router.getCurrentNavigation()?.extras.state?.id);
          let id = this.router.getCurrentNavigation()?.extras.state?.id
          if (id) {
            this.action = "Edit";
            this.vehicleService.getVehicleById(id).subscribe(data => {
              this.vehicle = data;
            })

          }
    }

  ngOnInit(): void {
  }

  onSubmit() {
     // console.log(this.vehicle);
     if (this.action == "New") {
      this.vehicleService.save(this.vehicle).subscribe(result => {
          console.log(result);
          this.router.navigate(['/vehicles']);
      })
     } else {
       this.vehicleService.update(this.vehicle).subscribe(result => {
          console.log(result);
          this.router.navigate(['/vehicles']);
      })
     }
  }

}
