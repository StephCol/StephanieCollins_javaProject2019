package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController  implements Initializable{

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

    @FXML
    public AnchorPane dashboardPane;



    public void addSupplierAction(javafx.event.ActionEvent actionEvent) {
    }

    public void viewSuppliersAction(javafx.event.ActionEvent actionEvent) {
    }

    public void inStockAction(javafx.event.ActionEvent actionEvent) {
    }

    public void outStockAction(javafx.event.ActionEvent actionEvent) {
    }

    //------------------------------LOAD ADD/VIEW DEPARTMENTS GUI--------------------------------

    public void viewDepartmentsAction(javafx.event.ActionEvent actionEvent) throws IOException {
        viewDepartments.getScene().getWindow().hide();

        //dashboardPane.setVisible(false);
       //departmentsPane.setVisible();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/viewDepartments.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);
    }

    public void addDepartmentAction(javafx.event.ActionEvent actionEvent) throws IOException {
        //addDepartment.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/viewDepartments.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);
    }

    //------------------------------LOAD ADD PRODUCTS GUI--------------------------------

    public void addProductAction(javafx.event.ActionEvent actionEvent) throws IOException {
        addProduct.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/addProducts.fxml"));
        Parent root = fxmlLoader.load();
        Stage prods = new Stage();
        prods.initStyle(StageStyle.UNDECORATED);
        prods.setScene(new Scene(root));
        prods.show();
        prods.setResizable(false);


    }

    //------------------------------CLOSE PROGRAM--------------------------------

    public void exitMessage(javafx.scene.input.MouseEvent mouseEvent) {
        //hides dashboard
        addDepartment.getScene().getWindow().hide();
        System.exit(0);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
