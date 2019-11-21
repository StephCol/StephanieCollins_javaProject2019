package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class viewDepartmentsController {

    @FXML
    public JFXComboBox<String> cboDepartments = new JFXComboBox<>();



    @FXML
    public ComboBox<String> cboNew;


    @FXML
    private JFXTextArea txtAreaProducts;

    @FXML
    private JFXButton btnSearchDepartments;

    @FXML
    private JFXButton exitButton;

    @FXML
    void btnSearchDepartments(ActionEvent event) {

    }

    @FXML
    void cboDepartments(ActionEvent event) {

    }

    @FXML
    void exitButton(ActionEvent event) {

    }

    @FXML
    void exitToDash(MouseEvent event) {

    }

    public void cboDepartments(javafx.event.ActionEvent actionEvent) {


    }

    public void btnSearchDepartments(javafx.event.ActionEvent actionEvent) {
    }

    public void exitToDash(javafx.scene.input.MouseEvent mouseEvent) {
    }

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
