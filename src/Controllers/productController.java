package Controllers;

import Main.Department;
import Main.Main;
import Main.Product;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class productController implements Initializable {

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

    public void exitButton()  {
        //hides Product GUI
        exitButton.getScene().getWindow().hide();
    }


    //--------------------------------------ADD PRODUCTS---------------------------------------

    public void btnAddProductAction() {

        String refNoAsString = txtRefNo.getText();
        String stockAsString = txtStockNo.getText();
        String name = txtName.getText();
        String brand = txtBrand.getText();
        String department = cboDepartments.getValue();
        String supplier = cboSupplier.getValue();
        String costPriceAsString = txtCostP.getText();
        String salePriceAsString = txtSaleP.getText();

        Boolean exists = false;

        if(!refNoAsString.equals("") || !stockAsString.equals("") || !name.equals("") || !brand.equals("") || !department.equals("")
                && !supplier.equals("") || !costPriceAsString.equals("") || !salePriceAsString.equals("") ){

            txtProductResult.setVisible(false);

            int refNo = Integer.parseInt(refNoAsString);
            int stock = Integer.parseInt(stockAsString);
            Double costPrice = Double.parseDouble(costPriceAsString);
            Double salePrice = Double.parseDouble(salePriceAsString);


            if(salePrice > costPrice){

                Product newProduct = new Product(refNo, name, brand, stock,supplier, department, costPrice,salePrice);

                //Make sure the reference number does not already exist
                for(Product p: Main.products){
                    if(p.getRefNo()==refNo){
                        exists = true;
                    }
                }

                if(!exists) {
                    Main.products.add(newProduct);

                    for (Department d : Main.departments) {

                        if (d.getDepName().equals(department)) {
                            d.addProduct(newProduct);
                        }
                    }//for

                    //Reset text boxes
                    txtRefNo.clear();
                    txtStockNo.clear();
                    txtName.clear();
                    txtBrand.clear();
                    txtCostP.clear();
                    txtSaleP.clear();
                }
                else{
                    txtProductResult.setText("Reference already exists");
                    txtProductResult.setVisible(true);
                }
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
        cboDepartments.setItems(FXCollections.observableArrayList(Main.DepartmentList));
        cboSupplier.setItems(FXCollections.observableArrayList(Main.SuppliersList));
    }
}//END OF CONTROLLER
