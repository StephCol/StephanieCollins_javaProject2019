package Controllers;

import Main.Main;
import Main.Product;
import Main.Supplier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class stockController implements Initializable {

    @FXML
    private JFXComboBox<String> cboStock;
    @FXML
    private JFXTextArea txtAreaProducts;
    @FXML
    private JFXButton exitButton;
    @FXML
    private JFXTextField txtRefNo;
    @FXML
    private JFXTextField txtAmt;
    @FXML
    private JFXTextArea txtAreaOrder;

    @FXML
    private JFXTextField txtTotal;

    private Double orderTotal = 0.0;


    public void exitButton() {
        //hides Stock GUI
        exitButton.getScene().getWindow().hide();

    }

    public void btnAddToOrderAction() {

        String refNoAsString = txtRefNo.getText();
        int refNo = Integer.parseInt(refNoAsString);
        String amtAsString = txtAmt.getText();
        int amt = Integer.parseInt(amtAsString);
        String supplierName;
        String email = "";
        Double price, itemTotal = 0.0;

        for(Product p: Main.products){                               //Search through products array

            if(p.getRefNo() == refNo){                          //Find the one with the entered refNo

                supplierName = p.getSupplier();                 //get the supplier of that product
                price = p.getCostPrice();                       //get cost price of the product
                itemTotal = amt*price;
                p.setStock(p.getStock()+amt);

                for(Supplier s: Main.suppliers){
                    if(s.getSupplierName().equals(supplierName)){
                        email = s.getEmail();
                    }
                }
                String item = String.format("%-11d%-27s%-8d€%-10.2f\n", refNo, email, amt, itemTotal);
                txtAreaOrder.appendText(item);
            }

        }

        orderTotal += itemTotal;
        txtTotal.setText("€" + orderTotal);

        txtRefNo.clear();
        txtAmt.clear();

    }

    @FXML
    public void btnPlaceOrderAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/confirmOrder.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);

    }

    public void btnSearchStockAction() {

        String option = cboStock.getValue();
        String productlist="";

        if(option.equals("In Stock")){
            for(Product p: Main.products){
                if(p.getStock()>0){
                    productlist += p.toString();
                }
            }
        }
        else if(option.equals("Out of Stock")){
            for(Product p: Main.products){
                if(p.getStock()==0){
                    productlist += p.toString();
                }
            }
        }

        txtAreaProducts.setText(productlist);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> options = new ArrayList<String>();
        options.add("In Stock");
        options.add("Out of Stock");
        cboStock.setItems(FXCollections.observableArrayList(options));
    }


}
