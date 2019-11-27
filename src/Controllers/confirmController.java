package Controllers;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;

public class confirmController {

    @FXML
    private Button btnOK;

    public void btnOKAction(javafx.event.ActionEvent actionEvent) {

        btnOK.getScene().getWindow().hide();

    }


    public void btnShutdownAction(ActionEvent actionEvent) throws IOException {

        File supOutFile = new File("supplierArrays.data");
        FileOutputStream supOutFileStream = new FileOutputStream(supOutFile);
        ObjectOutputStream sos = new ObjectOutputStream(supOutFileStream);
        sos.writeObject(Main.SuppliersList);
        sos.writeObject(Main.suppliers);
        sos.close();

        File depAndProdOutFile = new File("depAndProdArrays.data");
        FileOutputStream depAndProdOutFileStream = new FileOutputStream(depAndProdOutFile);
        ObjectOutputStream dos = new ObjectOutputStream(depAndProdOutFileStream);
        dos.writeObject(Main.DepartmentList);
        dos.writeObject(Main.departments);
        dos.writeObject(Main.products);
        dos.close();


        System.exit(0);

    }
}
