package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class confirmController {

    @FXML
    private Button btnOK;

    @FXML
    void btnOKAction(ActionEvent event) {



    }

    public void btnOKAction(javafx.event.ActionEvent actionEvent) {

        btnOK.getScene().getWindow().hide();
    }
}
