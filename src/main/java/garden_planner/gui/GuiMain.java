package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

    GardenPlanner planner;

    public GuiMain() {
        planner = new GardenPlanner();
        planner.createBasicDesign();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        // Button root = new Button("TODO: design garden planner GUI");

        BorderPane root = new BorderPane(); //creates the root

        Pane pane = new Pane(); //creates a pane to place on the root
        pane.setStyle("-fx-background-color: #007700;");
        root.setCenter(pane);

        //creates all beds from the .createBasicDesign()
        for (RectBed bed : planner.getBeds()) {
            javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(bed.getWidth() * 100, bed.getHeight() * 100);
            rec.setX(bed.getLeft() * 100);
            rec.setY(bed.getTop() * 100);
            pane.getChildren().add(rec);
        }

        //creates a static rectangle to place on the pane
        Rectangle rec = new Rectangle(100, 100);
        pane.getChildren().add(rec);
        rec.setX(600);
        rec.setY(400);

        //creates the window and loads the root and children
        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
