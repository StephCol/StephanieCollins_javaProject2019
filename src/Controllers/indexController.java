package Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class indexController {

    @FXML
    private JFXButton enter;

    @FXML
    public void enterAction(javafx.event.ActionEvent actionEvent) throws IOException {

        //hides welcome page
        enter.getScene().getWindow().hide();

        //change to dashboard
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUIFiles/dashboard.fxml"));
        Parent root = fxmlLoader.load();
        Stage dashboard = new Stage();
        dashboard.initStyle(StageStyle.UNDECORATED);
        dashboard.setScene(new Scene(root));
        dashboard.show();
        dashboard.setResizable(false);


    }
}
