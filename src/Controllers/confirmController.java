package Controllers;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.*;

public class confirmController extends Main {

    @FXML
    private Button btnOK;

    public void btnOKAction(javafx.event.ActionEvent actionEvent) {
        btnOK.getScene().getWindow().hide();
    }


    public void btnShutdownAction(ActionEvent actionEvent) throws IOException {

        File supOutFile = new File("supplierArrays.data");
        FileOutputStream supOutFileStream = new FileOutputStream(supOutFile);
        ObjectOutputStream sos = new ObjectOutputStream(supOutFileStream);
        sos.writeObject(SuppliersList);
        sos.writeObject(suppliers);
        sos.close();

        File depAndProdOutFile = new File("depAndProdArrays.data");
        FileOutputStream depAndProdOutFileStream = new FileOutputStream(depAndProdOutFile);
        ObjectOutputStream dos = new ObjectOutputStream(depAndProdOutFileStream);
        dos.writeObject(DepartmentList);
        dos.writeObject(departments);
        dos.writeObject(products);
        dos.close();


        System.exit(0);

    }
}
