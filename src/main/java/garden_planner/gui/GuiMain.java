package garden_planner.gui;

import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


/**
 * NOTE: Do NOT run this class in IntelliJ.  Run 'RunGui' instead.
 */
public class GuiMain extends Application {

//    GardenPlanner planner;
//    TextField widthField;
//    TextField heightField;
//
//    public GuiMain() {
//        planner = new GardenPlanner();
//        planner.createBasicDesign();
//    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        // Button root = new Button("TODO: design garden planner GUI");

//        BorderPane root = new BorderPane(); //creates the root
//
//        Pane pane = new Pane(); //creates a pane to place on the root
//        pane.setStyle("-fx-background-color: #007700;");
//        root.setCenter(pane);
//
//        //creates all beds from the .createBasicDesign()
//        for (GardenBed bed : planner.getBeds()) {
//            javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(bed.getWidth() * 100, bed.getHeight() * 100);
//            rec.setX(bed.getLeft() * 100);
//            rec.setY(bed.getTop() * 100);
//            pane.getChildren().add(rec);
//        }
//
//        //creates a static rectangle to place on the pane
////        Rectangle rec = new Rectangle(100, 100);
////        pane.getChildren().add(rec);
////        rec.setX(600);
////        rec.setY(400);
//
//        // Display the width and height of the first bed
//        Pane leftPane = new VBox(10);
//        leftPane.setPadding(new Insets(5, 5, 5, 5));
//        leftPane.setStyle("-fx-background-color: #107700;");
//        root.setLeft(leftPane);
//
//        widthField = new TextField();
//        double width = planner.getBeds().get(0).getWidth();
//        String str = Double.toString(width);
//        widthField.setText(str);
//        leftPane.getChildren().add(widthField);
//
//        heightField = new TextField();
//        double height = planner.getBeds().get(0).getWidth();
//        str = Double.toString(height);
//        heightField.setText(str);
//        leftPane.getChildren().add(heightField);

        //creates the window and loads the root and children
        primaryStage.setTitle("Garden Planner");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
