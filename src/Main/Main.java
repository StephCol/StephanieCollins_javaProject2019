

package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application implements Serializable {

//Arrays all had to be made static so they would maintain the data stored within them when switching GUIs
    public static ArrayList<Department> departments = new ArrayList<>();

    public static List<String> DepartmentList = new ArrayList<>();

    public static List<String> SuppliersList = new ArrayList<>();

    public static ArrayList<Supplier> suppliers = new ArrayList<>();

    public static ArrayList<Product> products = new ArrayList<>();

    //--REFERENCE--Michal Kubiak, showed me how to use scene builder and how to get set up
    //This launches the start of the application
    @Override
    public void start(Stage primaryStage) throws Exception {

        File supInFile = new File("supplierArrays.data");
        FileInputStream supInFileStream = new FileInputStream(supInFile);
        ObjectInputStream sos = new ObjectInputStream(supInFileStream);
        SuppliersList = (List<String>) sos.readObject();
        suppliers = (ArrayList<Supplier>) sos.readObject();
        sos.close();

        File depAndProdInFile = new File("depAndProdArrays.data");
        FileInputStream depAndProdInFileStream = new FileInputStream(depAndProdInFile);
        ObjectInputStream dos = new ObjectInputStream(depAndProdInFileStream);
        DepartmentList = (List<String>) dos.readObject();
        departments = (ArrayList<Department>) dos.readObject();
        products = (ArrayList<Product>) dos.readObject();
        dos.close();

        //Load Welcome Page
        Parent root = FXMLLoader.load(getClass().getResource("../GUIFiles/index.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        //Non Resizable Window
        primaryStage.setResizable(false);
    }


//Launch the program
    public static void main(String[] args) {
        launch(args);
    }
}

