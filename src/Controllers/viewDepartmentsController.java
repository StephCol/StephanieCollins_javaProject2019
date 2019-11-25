package Controllers;

import Main.Department;
import Main.Main;
import Main.Product;
import Main.Supplier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class viewDepartmentsController extends Main implements Initializable {

    //-------------------------------VIEW DEPARTMENTS GUI ATTRIBUTES------------------------------

    @FXML
    private JFXTextArea txtAreaProducts;
    @FXML
    private JFXButton btnSearchDepartments;
    @FXML
    private JFXTextField txtRemoveDepartment;
    @FXML
    private JFXButton btnRemoveDepartment;
    @FXML
    private JFXTextField txtAddDepartment;
    @FXML
    private JFXButton btnAddDepartment;
    @FXML
    public JFXComboBox<String> cboDepartments;
    @FXML
    private JFXButton exitButton;

    //-------------------------- EXIT TO DASHBOARD --------------------------------

    public void exitButton(javafx.event.ActionEvent actionEvent) throws IOException {

        //hides add Department
        exitButton.getScene().getWindow().hide();

        //return to Dashboard
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/dashboard.fxml"));
        Parent root = fxmlLoader.load();
        Stage dash = new Stage();
        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(new Scene(root));
        dash.show();
        dash.setResizable(false);
    }

    //---------------------------ADD AND REMOVE DEPARTMENTS--------------------------------------

    public void btnAddDepartmentAction(javafx.event.ActionEvent actionEvent) throws IOException {

        String depart = "" ;
        Department newDepart = new Department(txtAddDepartment.getText());
        departments.add(newDepart);
        DepartmentList.add(txtAddDepartment.getText());

        for(Department d:departments){
            depart += d.getDepName() + " " ;
        }

        System.out.println(depart);
        System.out.println(DepartmentList.toString());

        cboDepartments.setItems(FXCollections.observableArrayList(DepartmentList));
        txtAddDepartment.clear();

    }

    public void btnRemoveDepartmentAction(javafx.event.ActionEvent actionEvent) {

        String remove = txtRemoveDepartment.getText();

        for (int i = 0; i < DepartmentList.size(); i++) {

            if (remove.equals(DepartmentList.get(i))) {
                DepartmentList.remove(i);
                departments.remove(i);
                cboDepartments.setItems(FXCollections.observableArrayList(DepartmentList));
            }

        }

        txtRemoveDepartment.clear();
    }

    //---------------------SEARCH DEPARTMENTS & LOAD PRODUCTS TO TEXT AREA--------------------

    public void btnSearchDepartments(javafx.event.ActionEvent actionEvent) {

        String selectedDepart = cboDepartments.getValue();

        String prodList = "";

        for (Department d : departments){

            if(d.getDepName().equals(selectedDepart)){
                prodList = d.getProductList();
            }
            txtAreaProducts.appendText(prodList);
        }

    }

    //----------------------------------------IMPLEMENT INTERFACE--------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cboDepartments.setItems(FXCollections.observableArrayList(DepartmentList));
        txtAreaProducts.setFont(new javafx.scene.text.Font(Font.MONOSPACED, 13 ));

    }

}//END OF CONTROLLER
