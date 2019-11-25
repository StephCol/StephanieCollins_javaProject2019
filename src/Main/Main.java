

package Main;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;
        import javafx.stage.StageStyle;

        import java.util.ArrayList;
        import java.util.List;

public class Main extends Application {


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

    public static void main(String[] args) {
        launch(args);
    }
}

