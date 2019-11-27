package Controllers;

import Main.Main;
import Main.Supplier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class supplierController implements Initializable {

    @FXML
    public JFXButton btnAddSupplier;
    @FXML
    public JFXButton btnRemoveSupplier;
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

    public void btnAddSupplierAction() {

        String supName = txtSupName.getText();
        String supEmail = txtSupEmail.getText();

        Supplier newSupplier = new Supplier(supName, supEmail);
        Main.suppliers.add(newSupplier);
        Main.SuppliersList.add(supName);

        cboSuppliers.setItems(FXCollections.observableArrayList(Main.SuppliersList));

        txtSupName.clear();
        txtSupEmail.clear();

    }

    public void btnRemoveSupplierAction(ActionEvent actionEvent) {

        String remove = txtSupName.getText();

        for (int i = 0; i < Main.SuppliersList.size(); i++) {
            if (remove.equals(Main.SuppliersList.get(i))) {
                Main.SuppliersList.remove(i);
                Main.suppliers.remove(i);
                cboSuppliers.setItems(FXCollections.observableArrayList(Main.SuppliersList));
            }
        }
        txtSupName.clear();
        txtSupEmail.clear();

    }

    public void btnSearchSuppliers() {
        String details ="";
        String selectedSupplier = cboSuppliers.getValue();

            for(Supplier s: Main.suppliers){

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
        cboSuppliers.setItems(FXCollections.observableArrayList(Main.SuppliersList));
        //Set font for text area
        txtAreaSuppliers.setFont(new javafx.scene.text.Font(Font.MONOSPACED, 13 ));

    }


    //-------------------------- EXIT TO DASHBOARD --------------------------------

    public void exitButton() {
         //hides Supplier GUI
        exitButton.getScene().getWindow().hide();
    }


}
