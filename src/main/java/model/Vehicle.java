package model;


public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private int slotId;

    public Vehicle(String vehicleNumber, String vehicleType, int slotId) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.slotId = slotId;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getVehicleType() { return vehicleType; }
    public int getSlotId() { return slotId; }
}

