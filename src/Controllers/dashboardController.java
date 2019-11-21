package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class dashboardController {

    @FXML
    private JFXButton addSupplier;
    @FXML
    private JFXButton viewSuppliers;
    @FXML
    private JFXButton inStock;
    @FXML
    private JFXButton outStock;
    @FXML
    private JFXButton viewDepartments;
    @FXML
    private JFXButton addDepartment;
    @FXML
    private JFXButton addProduct;


    void addDepartmentAction(ActionEvent event) throws IOException {


    }


    void addProductAction(ActionEvent event) {

    }


    void addSupplierAction(ActionEvent event) {

    }


    void exitMessage(MouseEvent event) {

    }


    void inStockAction(ActionEvent event) {

    }


    void outStockAction(ActionEvent event) {

    }

    @FXML
    void viewDepartmentsAction(ActionEvent event) {

    }

    @FXML
    void viewSuppliersAction(ActionEvent event) {

    }

    public void addSupplierAction(javafx.event.ActionEvent actionEvent) {
    }

    public void viewSuppliersAction(javafx.event.ActionEvent actionEvent) {
    }

    public void inStockAction(javafx.event.ActionEvent actionEvent) {
    }

    public void outStockAction(javafx.event.ActionEvent actionEvent) {
    }

    public void viewDepartmentsAction(javafx.event.ActionEvent actionEvent) throws IOException {
        //hides dashboard
        viewDepartments.getScene().getWindow().hide();

        //change to addDepartment
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/viewDepartments.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);

    }

    public void addDepartmentAction(javafx.event.ActionEvent actionEvent) throws IOException {


        //hides dashboard
        addDepartment.getScene().getWindow().hide();

        //change to addDepartment
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/addDepartment.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);
    }

    public void addProductAction(javafx.event.ActionEvent actionEvent) {
    }

    public void exitMessage(javafx.scene.input.MouseEvent mouseEvent) {

        //hides dashboard
        addDepartment.getScene().getWindow().hide();

        System.exit(0);

    }
}
