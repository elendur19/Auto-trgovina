package hr.fer.ris.autotrgovina.security;

public enum UserPermission {
    VEHICLE_READ("vehicle:read"),
    VEHICLE_WRITE("vehicle:write"),
    MANUFACTURER_WRITE("manufacturer:write"),
    MANUFACTURER_READ("manufacturer:read");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
