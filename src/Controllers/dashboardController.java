package Controllers;

import Main.Main;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class dashboardController {

    @FXML
    public AnchorPane dashboardPane;


    //------------------------------LOAD ADD/VIEW SUPPLIERS GUI--------------------------------
    public void addSupplierAction(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/suppliers.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);

    }

    public void viewSuppliersAction(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/suppliers.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);
    }

    //----------------------------LOAD IN STOCK/ OUT OF STOCK GUI--------------------------------

    public void inStockAction(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/stockOrder.fxml"));
        Parent root = fxmlLoader.load();
        Stage prods = new Stage();
        prods.initStyle(StageStyle.UNDECORATED);
        prods.setScene(new Scene(root));
        prods.show();
        prods.setResizable(false);
    }
    public void outStockAction(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/stockOrder.fxml"));
        Parent root = fxmlLoader.load();
        Stage prods = new Stage();
        prods.initStyle(StageStyle.UNDECORATED);
        prods.setScene(new Scene(root));
        prods.show();
        prods.setResizable(false);
    }

    //------------------------------LOAD ADD/VIEW DEPARTMENTS GUI--------------------------------

    public void viewDepartmentsAction(javafx.event.ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/departments.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);
    }

    public void addDepartmentAction(javafx.event.ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/departments.fxml"));
        Parent root = fxmlLoader.load();
        Stage depart = new Stage();
        depart.initStyle(StageStyle.UNDECORATED);
        depart.setScene(new Scene(root));
        depart.show();
        depart.setResizable(false);
    }

    //------------------------------------LOAD ADD PRODUCTS GUI----------------------------------

    public void addProductAction(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/products.fxml"));
        Parent root = fxmlLoader.load();
        Stage prods = new Stage();
        prods.initStyle(StageStyle.UNDECORATED);
        prods.setScene(new Scene(root));
        prods.show();
        prods.setResizable(false);

    }
    //----------------------------------------CLOSE PROGRAM--------------------------------------

    public void exitMessage(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/confirmExit.fxml"));
        Parent root = fxmlLoader.load();
        Stage dash = new Stage();
        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(new Scene(root));
        dash.show();
        dash.setResizable(false);
    }

}
