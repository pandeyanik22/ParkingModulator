package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VehicleDAO {

    public boolean exists(Connection con, String number)
            throws Exception {

        PreparedStatement ps =
                con.prepareStatement(
                        "SELECT 1 FROM vehicle WHERE vehicle_number=?");
        ps.setString(1, number);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public void insert(Connection con, String number,
                       String type, int slotId) throws Exception {

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO vehicle VALUES (?,?,?,NOW())");
        ps.setString(1, number);
        ps.setString(2, type);
        ps.setInt(3, slotId);
        ps.executeUpdate();
    }

    public int getSlotId(Connection con, String number)
            throws Exception {

        PreparedStatement ps = con.prepareStatement(
                "SELECT slot_id FROM vehicle WHERE vehicle_number=?");
        ps.setString(1, number);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void updateSlot(Connection con, String number, int newSlot)
            throws Exception {

        PreparedStatement ps = con.prepareStatement(
                "UPDATE vehicle SET slot_id=? WHERE vehicle_number=?");
        ps.setInt(1, newSlot);
        ps.setString(2, number);
        ps.executeUpdate();
    }
    
    public void deleteVehicle(Connection con, String vehicleNumber)
            throws Exception {

        String sql = "DELETE FROM vehicle WHERE vehicle_number=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, vehicleNumber);
        ps.executeUpdate();
    }

}

