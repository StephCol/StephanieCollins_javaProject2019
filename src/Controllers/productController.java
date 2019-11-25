package Controllers;

import Main.Department;
import Main.Main;
import Main.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import java.util.ResourceBundle;

public class productController extends Main implements Initializable {

    //-------------------ADD PRODUCT GUI ATTRIBUTES-------------------------
    @FXML
    private JFXTextField txtBrand;
    @FXML
    private JFXTextField txtRefNo;
    @FXML
    private JFXTextField txtStockNo;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtCostP;
    @FXML
    private JFXTextField txtSaleP;
    @FXML
    private JFXComboBox<String> cboSupplier;
    @FXML
    private JFXTextField txtProductResult;
    @FXML
    public JFXComboBox<String> cboDepartments;
    @FXML
    private JFXButton exitButton;

    //-------------------------- EXIT TO DASHBOARD --------------------------------

    public void exitButton(javafx.event.ActionEvent actionEvent) throws IOException {

        //hides add Department
        exitButton.getScene().getWindow().hide();

        //departmentsPane.setVisible(false);
        //dashboardPane.setVisible(true);
        //return to Dashboard
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/dashboard.fxml"));
        Parent root = fxmlLoader.load();
        Stage dash = new Stage();
        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(new Scene(root));
        dash.show();
        dash.setResizable(false);
    }


    //--------------------------------------ADD PRODUCTS---------------------------------------

    public void btnAddProductAction(ActionEvent actionEvent) {

        String refNoAsString = txtRefNo.getText();
        String stockAsString = txtStockNo.getText();
        String name = txtName.getText();
        String brand = txtBrand.getText();
        String department = cboDepartments.getValue();
        String supplier = cboSupplier.getValue();
        String costPriceAsString = txtCostP.getText();
        String salePriceAsString = txtSaleP.getText();

        if(!refNoAsString.equals("") || !stockAsString.equals("") || !name.equals("") || !brand.equals("") || !department.equals("")
                && !supplier.equals("") || !costPriceAsString.equals("") || !salePriceAsString.equals("") ){

            txtProductResult.setVisible(false);

            int refNo = Integer.parseInt(refNoAsString);
            int stock = Integer.parseInt(stockAsString);
            Double costPrice = Double.parseDouble(costPriceAsString);
            Double salePrice = Double.parseDouble(salePriceAsString);

            if(salePrice > costPrice){


                Product newProduct = new Product(refNo, name, brand, stock,supplier, department, costPrice,salePrice);

                System.out.println(newProduct.toString());

                for(Department d : departments){

                    if(d.getDepName().equals(department)){

                        d.addProduct(newProduct);
                        System.out.println(d.getProductList());

                    }
                }//for

                txtRefNo.clear();
                txtStockNo.clear();
                txtName.clear();
                txtBrand.clear();
                txtCostP.clear();
                txtSaleP.clear();

            }//if
            else{
                txtProductResult.setText("Sale Price must be more than cost price");
                txtProductResult.setVisible(true);
            }
        }//if (blank fields)
        else{
            txtProductResult.setText("Please provide all product details");
            txtProductResult.setVisible(true);
        }
    }

    //----------------------------------------IMPLEMENT INTERFACE--------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Load list of Departments and Suppliers on load
        cboDepartments.setItems(FXCollections.observableArrayList(DepartmentList));
        cboSupplier.setItems(FXCollections.observableArrayList(SuppliersList));

    }


}//END OF CONTROLLER
