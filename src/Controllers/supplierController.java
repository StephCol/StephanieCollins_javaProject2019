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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class supplierController extends Main implements Initializable {

    @FXML
    private JFXComboBox<String> cboSuppliers;
    @FXML
    private JFXTextArea txtAreaSuppliers;
    @FXML
    private JFXButton exitButton;
    @FXML
    private JFXTextField txtSupName;
    @FXML
    private JFXTextField txtSupEmail;

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
        String details ="";
        String selectedSupplier = cboSuppliers.getValue();

            for(Supplier s: suppliers){

                if(s.getSupplierName().equals(selectedSupplier)) {
                    details = s.toString();
                }
            }
            txtAreaSuppliers.setText(details);
    }

    //-------------------------- IMPLEMENT INTERFACE --------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Set list of suppliers on startup
        cboSuppliers.setItems(FXCollections.observableArrayList(SuppliersList));
        //Set font for text area
        txtAreaSuppliers.setFont(new javafx.scene.text.Font(Font.MONOSPACED, 13 ));

    }

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

}
