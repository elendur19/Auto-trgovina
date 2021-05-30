import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleListUserComponent } from './vehicle-list-user.component';

describe('VehicleListUserComponent', () => {
  let component: VehicleListUserComponent;
  let fixture: ComponentFixture<VehicleListUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehicleListUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleListUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
