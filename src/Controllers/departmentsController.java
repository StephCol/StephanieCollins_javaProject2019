package Controllers;

import Main.Department;
import Main.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class departmentsController extends Main implements Initializable {

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
    @FXML
    private JFXTextField txtAddDepartResult;
    @FXML
    private JFXTextField txtRemoveDepartResult;

    //-------------------------- EXIT TO DASHBOARD --------------------------------

    public void exitButton(javafx.event.ActionEvent actionEvent) throws IOException {

        //hides add Department
        exitButton.getScene().getWindow().hide();

    }

    //---------------------------ADD AND REMOVE DEPARTMENTS--------------------------------------

    public void btnAddDepartmentAction()  {

        String result = "";
        Department newDepart = new Department(txtAddDepartment.getText());


        for(Department d:departments){
            if(d.getDepName().toLowerCase().equals(newDepart.getDepName().toLowerCase())){
                txtAddDepartResult.setText("Department already exists");
                txtAddDepartResult.setVisible(true);
            }
            else{
                departments.add(newDepart);
                DepartmentList.add(txtAddDepartment.getText());
                txtAddDepartResult.setText("Department added");
                txtAddDepartResult.setVisible(true);
            }
        }

        //--REFERENCE-- GeeksforGeeks.org, I figured out how to populate the JFXCombo Box through this website.
        cboDepartments.setItems(FXCollections.observableArrayList(DepartmentList));
        txtAddDepartment.clear();

    }

    public void btnRemoveDepartmentAction() {

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

    public void btnSearchDepartments() {

        String selectedDepart = cboDepartments.getValue();

        String prodList = "";

        for (Department d : departments){

            if(d.getDepName().equals(selectedDepart)){
                prodList = d.getProductList();
            }
            txtAreaProducts.setText(prodList);
        }
    }

    //----------------------------------------IMPLEMENT INTERFACE--------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cboDepartments.setItems(FXCollections.observableArrayList(DepartmentList));
        txtAreaProducts.setFont(new javafx.scene.text.Font(Font.MONOSPACED, 13 ));

    }

}//END OF CONTROLLER
