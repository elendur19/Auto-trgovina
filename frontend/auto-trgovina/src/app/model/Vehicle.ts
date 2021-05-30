import { ManufacturerService } from "../service/manufacturer.service";
import { Manufacturer } from "./Manufacturer";

export class Vehicle {
    public id: number;
    public dateCreated: Date;
    public dateUpdated: Date;
    public dateDeleted: Date;
    public deleted: boolean;
    public description: string;
    public millage: number;
    public location: string;
    public contact: string;
    public variant: string;
    public firstRegistration: Date;
    public power: number;
    public price: number;
    public manufacturer: Manufacturer;
    public model: string;
}