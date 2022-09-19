package controller;

import helper.AppointmentsCRUD;
import helper.ContactsCRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TypeReports implements Initializable {
    public TableView appointmentTable;
    public TableColumn customerIdColumn;
    public TableColumn appointmentIdColumn;
    public TableColumn titleColumn;
    public TableColumn typeColumn;
    public TableColumn descriptionColumn;
    public TableColumn startDateTimeColumn;
    public TableColumn endDateTimeColumn;
    public Button backToAppointmentsButton;
    public ComboBox<Appointments> typeComboBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(AppointmentsCRUD.getAllTypes().size());

        typeComboBox.setItems(AppointmentsCRUD.getAllTypes());

        appointmentTable.setItems(AppointmentsCRUD.getAllAppointments());

        appointmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        startDateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startDateTime"));
        endDateTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endDateTime"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));

    }

    public void typeComboBoxClick(ActionEvent actionEvent) {
        appointmentTable.setItems(AppointmentsCRUD.getTypeAppointments(typeComboBox.getValue().getType()));

    }

    public void backToAppointmentsButtonClick(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/reportsMenu.fxml"));
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Reports Menu");
        stage.setScene(scene);
        stage.show();
    }


}
