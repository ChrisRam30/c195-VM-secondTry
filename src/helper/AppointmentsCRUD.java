package helper;

import java.sql.*;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;

public class AppointmentsCRUD {
    public static ObservableList<Appointments> getAllAppointments() {
        ObservableList<Appointments> aList = FXCollections.observableArrayList();
        try {
            String SQL = "SELECT * FROM APPOINTMENTS;";
            PreparedStatement ps = JDBC.connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery(SQL);

            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                int contact = rs.getInt("Contact_ID");
                String type = rs.getString("Type");
                Timestamp startDateTime = rs.getTimestamp("Start");
                Timestamp endDateTime = rs.getTimestamp("End");
                int customerId = rs.getInt("Customer_ID");
                int UserId = rs.getInt("User_ID");

                Appointments a = new Appointments(appointmentId, title, description, location, contact, type, startDateTime,
                        endDateTime, customerId, UserId);
                aList.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return aList;
    }
}
