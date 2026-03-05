//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import service.ParkingService;

public class Main {
    public static void main(String[] args) throws Exception {

        ParkingService service = new ParkingService();

        service.parkVehicle("DL01AB4923", "CAR");
        service.parkVehicle("DL02XY4344", "BIKE");

        service.showAvailableSlots();
        service.exitVehicle("DL01AB1234");
        service.parkVehicle("DL01AA7575", "BIKE");
        service.parkVehicle("DL01BB9078", "CAR");
        service.parkVehicle("DL01CC4577", "TRUCK");

        service.showAvailableSlots();
    }
}
