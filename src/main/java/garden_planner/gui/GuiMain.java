package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        // Button root = new Button("TODO: design garden planner GUI");

        BorderPane root = new BorderPane();

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #007700;");

        root.setCenter(pane);

        Rectangle rec = new Rectangle(100, 100);
        pane.getChildren().add(rec);
        rec.setX(150);
        rec.setY(550);


        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
