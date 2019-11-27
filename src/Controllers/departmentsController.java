package Controllers;

import Main.Department;
import Main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class departmentsController implements Initializable {

    //-------------------------------VIEW DEPARTMENTS GUI ATTRIBUTES------------------------------

    @FXML
    private JFXTextArea txtAreaProducts;
    @FXML
    private JFXTextField txtRemoveDepartment;
    @FXML
    private JFXTextField txtAddDepartment;
    @FXML
    public JFXComboBox<String> cboDepartments;
    @FXML
    private JFXButton exitButton;

    //-------------------------- EXIT TO DASHBOARD --------------------------------

    public void exitButton()  {

        //hides add Department
        exitButton.getScene().getWindow().hide();

    }

    //---------------------------ADD AND REMOVE DEPARTMENTS--------------------------------------

    public void btnAddDepartmentAction()  {


        Department newDepart = new Department(txtAddDepartment.getText());
        Main.departments.add(newDepart);
        Main.DepartmentList.add(txtAddDepartment.getText());

        //--REFERENCE-- GeeksforGeeks.org, I figured out how to populate the JFXCombo Box through this website.
        cboDepartments.setItems(FXCollections.observableArrayList(Main.DepartmentList));
        txtAddDepartment.clear();

    }

    public void btnRemoveDepartmentAction() {

        String remove = txtRemoveDepartment.getText();

        for (int i = 0; i < Main.DepartmentList.size(); i++) {
            if (remove.equals(Main.DepartmentList.get(i))) {
                Main.DepartmentList.remove(i);
                Main.departments.remove(i);
                cboDepartments.setItems(FXCollections.observableArrayList(Main.DepartmentList));
            }
        }
        txtRemoveDepartment.clear();
    }

    //---------------------SEARCH DEPARTMENTS & LOAD PRODUCTS TO TEXT AREA--------------------

    public void btnSearchDepartments() {

        String selectedDepart = cboDepartments.getValue();

        String prodList = "";

        for (Department d : Main.departments){

            if(d.getDepName().equals(selectedDepart)){
                prodList = d.getProductList();
            }
            txtAreaProducts.setText(prodList);
        }
    }

    //----------------------------------------IMPLEMENT INTERFACE--------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cboDepartments.setItems(FXCollections.observableArrayList(Main.DepartmentList));
        txtAreaProducts.setFont(new javafx.scene.text.Font(Font.MONOSPACED, 13 ));

    }

}//END OF CONTROLLER
