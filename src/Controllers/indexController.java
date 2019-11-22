package Controllers;

import com.jfoenix.controls.JFXButton;
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

public class indexController implements Initializable {

    @FXML
    private JFXButton enter;

    //---------------------------LOAD DASHBOARD---------------------------------------
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

    //---------------------------IMPLEMENT INTERFACE METHODS---------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
