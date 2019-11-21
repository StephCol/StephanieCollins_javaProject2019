package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class addDepartmentController {

    @FXML
    private JFXTextField txtAddDepartment;

    @FXML
    private JFXButton btnAddDepartment;

    @FXML
    private JFXButton exitButton;

    @FXML
    void btnAddDepartmentAction(ActionEvent event) {

    }

    @FXML
    void exitButton(ActionEvent event) {

    }

    @FXML
    void exitToDash(MouseEvent event) {

    }

    @FXML
    void txtAddDepartment(ActionEvent event) {

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

    public void exitToDash(javafx.scene.input.MouseEvent mouseEvent) {
    }

    public void btnAddDepartmentAction(javafx.event.ActionEvent actionEvent) {
    }

    public void txtAddDepartment(javafx.event.ActionEvent actionEvent) {
    }
}
