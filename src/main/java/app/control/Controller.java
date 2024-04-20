package app.control;

import java.net.URL;
import java.util.ResourceBundle;

import app.tables.Clients;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import static app.hibernateMain.HibernateMethods.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBut;

    @FXML
    private TextField clientAdress;

    @FXML
    private TextField clientEmployee;

    @FXML
    private TextField clientName;

    @FXML
    private TextField clientOrder;

    @FXML
    private TextField clientPhone;

    @FXML
    private Button deleteBut;

    @FXML
    private TextField orderDate;

    @FXML
    private Button refBut;

    @FXML
    private TableColumn<Clients, String> tableAdress;

    @FXML
    private TableColumn<Clients, String> tableDate;

    @FXML
    private TableColumn<Clients, String> tableEmployee;

    @FXML
    private TableColumn<Clients, String> tableName;

    @FXML
    private TableColumn<Clients, String> tableOrder;

    @FXML
    private TableColumn<Clients, String> tablePhone;

    @FXML
    private TableView<Clients> clientsView;

    @FXML
    private void addClient() {
        addRow(clientAdress.getText(), clientOrder.getText(), clientEmployee.getText(), clientName.getText(), orderDate.getText(), clientPhone.getText());
        showClients();
    }

    @FXML
    private void updateClient() {
        updateClients(clientName.getText(), clientName.getText(), clientAdress.getText(), clientOrder.getText(), clientEmployee.getText(), orderDate.getText(), clientPhone.getText());
        showClients();
    }

    @FXML
    private void deleteClient() {
        deleteClients(clientName.getText());
        showClients();
    }

    @FXML
    public void mouseClicked () {
        Clients client = clientsView.getSelectionModel().getSelectedItem();

        clientAdress.setText(client.getAdress());
        orderDate.setText(client.getOrderDate());
        clientEmployee.setText(client.getEmployee());
        clientName.setText(client.getName());
        clientPhone.setText(client.getPhone());
        clientOrder.setText(client.getOrder());

        refBut.setDisable(false);
        deleteBut.setDisable(false);
    }

    @FXML
    private void showClients() {
        ObservableList<Clients> list = getClientsList();
        tableAdress.setCellValueFactory(new PropertyValueFactory<Clients, String>("adress"));
        tableDate.setCellValueFactory(new PropertyValueFactory<Clients, String>("orderDate"));
        tableEmployee.setCellValueFactory(new PropertyValueFactory<Clients, String>("employee"));
        tableName.setCellValueFactory(new PropertyValueFactory<Clients, String>("name"));
        tableOrder.setCellValueFactory(new PropertyValueFactory<Clients, String>("order"));
        tablePhone.setCellValueFactory(new PropertyValueFactory<Clients, String>("phone"));
        clientsView.setItems(list);
    }

    @FXML
    void initialize() {
        showClients();
        refBut.setDisable(true);
        deleteBut.setDisable(true);
        assert addBut != null : "fx:id=\"addBut\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert clientAdress != null : "fx:id=\"clientAdress\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert clientEmployee != null : "fx:id=\"clientEmployee\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert clientName != null : "fx:id=\"clientName\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert clientOrder != null : "fx:id=\"clientOrder\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert clientPhone != null : "fx:id=\"clientPhone\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert deleteBut != null : "fx:id=\"deleteBut\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert orderDate != null : "fx:id=\"orderDate\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert refBut != null : "fx:id=\"refBut\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert tableAdress != null : "fx:id=\"tableAdress\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert tableDate != null : "fx:id=\"tableDate\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert tableEmployee != null : "fx:id=\"tableEmployee\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert tableName != null : "fx:id=\"tableName\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert tableOrder != null : "fx:id=\"tableOrder\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert tablePhone != null : "fx:id=\"tablePhone\" was not injected: check your FXML file 'gradProj.fxml'.";
        assert clientsView != null : "fx:id=\"clientsView\" was not injected: check your FXML file 'gradProj.fxml'.";

    }
}


