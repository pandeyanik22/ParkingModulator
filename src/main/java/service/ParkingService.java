package service;

import dao.ParkingSlotDAO;
import dao.VehicleDAO;
import db.DBConnection;
import model.ParkingSlot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ParkingService {

    private final ParkingSlotDAO slotDAO = new ParkingSlotDAO();
    private final VehicleDAO vehicleDAO = new VehicleDAO();

    public void parkVehicle(String number, String type) throws Exception {
        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            if (vehicleDAO.exists(con, number))
                throw new RuntimeException("Vehicle already parked");

            String size = getVehicleSize(type);
            ParkingSlot slot = slotDAO.getAvailableSlot(con, size);

            if (slot == null)
                throw new RuntimeException("No slot available");

            vehicleDAO.insert(con, number, type, slot.getSlotId());
            slotDAO.markOccupied(con, slot.getSlotId(), true);

            con.commit();
            System.out.println("Parked at Level "
                    + slot.getLevelId() + " Slot " + slot.getSlotNumber());

        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.close();
        }
    }

    public void showAvailableSlots() throws Exception {
        Connection con = DBConnection.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
                "SELECT level_id, vehicle_size, COUNT(*) AS available " +
                        "FROM parking_slot " +
                        "WHERE is_occupied = FALSE " +
                        "GROUP BY level_id, vehicle_size"
        );


        while (rs.next()) {
            System.out.println(
                    "Level " + rs.getInt("level_id") +
                            " " + rs.getString("vehicle_size") +
                            " Available: " + rs.getInt("available")
            );
        }
        con.close();
    }
    public void exitVehicle(String vehicleNumber) throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            // 1. Get occupied slot
            int slotId = vehicleDAO.getSlotId(con, vehicleNumber);

            // 2. Free the parking slot
            slotDAO.markOccupied(con, slotId, false);

            // 3. Remove vehicle entry
            vehicleDAO.deleteVehicle(con, vehicleNumber);

            con.commit();
            System.out.println("Vehicle exited successfully. Slot freed.");

        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.close();
        }
    }
    private String getVehicleSize(String vehicleType) {

        switch (vehicleType.toUpperCase()) {
            case "BIKE":
                return "SMALL";
            case "CAR":
                return "MEDIUM";
            case "TRUCK":
                return "LARGE";
            default:
                throw new RuntimeException("Invalid vehicle type");
        }
    }


}
