package dao;



import model.ParkingSlot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ParkingSlotDAO {

    public ParkingSlot getAvailableSlot(Connection con, String size)
            throws Exception {

        String sql =
                "SELECT slot_id, level_id, slot_number " +
                        "FROM parking_slot " +
                        "WHERE vehicle_size = ? AND is_occupied = FALSE " +
                        "ORDER BY level_id, slot_number " +
                        "LIMIT 1";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, size);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new ParkingSlot(
                    rs.getInt("slot_id"),
                    rs.getInt("level_id"),
                    rs.getInt("slot_number")
            );
        }
        return null;
    }

    public void markOccupied(Connection con, int slotId, boolean status)
            throws Exception {

        String sql =
                "UPDATE parking_slot SET is_occupied=? WHERE slot_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setBoolean(1, status);
        ps.setInt(2, slotId);
        ps.executeUpdate();
    }
}
