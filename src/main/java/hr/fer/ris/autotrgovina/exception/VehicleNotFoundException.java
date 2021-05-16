package hr.fer.ris.autotrgovina.exception;

public class VehicleNotFoundException extends BusinessException {

    public VehicleNotFoundException() {
        super(ExceptionMessageUtil.VEHICLE_NOT_FOUND_MESSAGE);
    }
}
