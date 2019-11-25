package Controllers;

import Main.Main;
import Main.Supplier;
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
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class supplierController extends Main implements Initializable {

    @FXML
    private JFXComboBox<String> cboSuppliers;
    @FXML
    private JFXTextArea txtAreaSuppliers;
    @FXML
    private JFXButton btnSearchSuppliers;
    @FXML
    private JFXButton exitButton;
    @FXML
    private JFXTextField txtSupName;
    @FXML
    private JFXButton btnAddSupplier;
    @FXML
    private JFXTextField txtSupEmail;

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

    public void btnAddSupplierAction(javafx.event.ActionEvent actionEvent) {

        String supName = txtSupName.getText();
        String supEmail = txtSupEmail.getText();

        Supplier newSupplier = new Supplier(supName, supEmail);
        suppliers.add(newSupplier);
        SuppliersList.add(supName);

        cboSuppliers.setItems(FXCollections.observableArrayList(SuppliersList));

        txtSupName.clear();
        txtSupEmail.clear();

    }

    public void btnSearchSuppliers(javafx.event.ActionEvent actionEvent) {
        String list ="";
        String selectedSupplier = cboSuppliers.getValue();

        if(selectedSupplier.equals("All Suppliers")){

            for(Supplier s: suppliers){

                list += s.toString();

            }
            System.out.println(list);
            txtAreaSuppliers.appendText(list);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        SuppliersList.add("All Suppliers");
        cboSuppliers.setItems(FXCollections.observableArrayList(SuppliersList));

    }
}
