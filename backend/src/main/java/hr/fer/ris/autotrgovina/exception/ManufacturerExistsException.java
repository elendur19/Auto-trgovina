package hr.fer.ris.autotrgovina.exception;

public class ManufacturerExistsException extends RuntimeException {
    public ManufacturerExistsException(String manufacturerName) {
        super(manufacturerName + " is already present.");
    }
}
