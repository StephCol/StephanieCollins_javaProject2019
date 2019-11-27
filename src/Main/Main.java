

package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.Serializable;
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

