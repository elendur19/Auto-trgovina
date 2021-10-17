package hr.fer.ris.autotrgovina.exception;

public class ManufacturerNotFoundException extends RuntimeException {
    public ManufacturerNotFoundException(String manufacturerName) {
        super("Manufacturer " + manufacturerName + " not found.");
    }
}
