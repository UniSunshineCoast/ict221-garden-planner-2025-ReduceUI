package garden_planner.gui;

import garden_planner.model.CircleBed;
import garden_planner.model.GardenBed;
import garden_planner.model.GardenPlanner;
import garden_planner.model.RectBed;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Controller {

    GardenPlanner planner;

    @FXML
    private Pane garden;

    @FXML
    private TextField width;

    @FXML
    private TextField height;

    @FXML
    private TextField area;

    @FXML
    private TextField perimeter;

    @FXML
    private Label areaTotal;

    @FXML
    private Label lengthTotal;

    @FXML
    private Label soilTotal;

    @FXML
    private Label costTotal;

    @FXML
    private Button addRect;

    @FXML
    private Button addCir;

    @FXML
    private Button addTri;

    private RectBed selectedRect; //stores current rect data

    @FXML
    public void initialize() {
        planner = new GardenPlanner();
        planner.createBasicDesign();
        garden.setStyle("-fx-background-color: #007700");
        //Image bgimage = new Image("grass.jpg");
        garden.setStyle("-fx-background-image: url(\"grass.jpg\")");
        updateGUI();

        RectBed firstRect = (RectBed) planner.getBeds().get(0);
        width.setText(String.valueOf(firstRect.getWidth()));
        height.setText(String.valueOf(firstRect.getHeight()));
        updateTextFields(firstRect); // Initial update of the text fields


        //listen for changes in width & height
        width.textProperty().addListener(e -> {
            double widthValue = Double.parseDouble(width.getText());
            firstRect.setWidth(widthValue);
            updateGUI();
            updateTextFields(firstRect);
        });
        height.textProperty().addListener(e -> {
            double heightValue = Double.parseDouble(height.getText());
            firstRect.setHeight(heightValue);
            updateGUI();
            //updateTextFields(firstRect);
        });

        //listen for add buttons
        addRect.setOnAction(e -> {
            planner.getBeds().add(new RectBed());
            updateGUI();
        });
        addCir.setOnAction(e -> {
            planner.getBeds().add(new CircleBed());
            updateGUI();
        });

    }

    //update data in text fields
    private void updateTextFields(RectBed rect) {
        area.setText(String.valueOf(rect.getArea()));
        perimeter.setText(String.valueOf(rect.getPerimeter()));
    }

    public void updateGUI() {
        garden.getChildren().clear();
        for (GardenBed bed : planner.getBeds()) {

            if (bed instanceof RectBed) {
                Rectangle rect = new Rectangle(bed.getWidth() * 100, bed.getHeight() * 100);
                rect.setX(bed.getLeft() * 100);
                rect.setY(bed.getTop() * 100);

                Image map = new Image("vege.jpg");
                ImagePattern pattern = new ImagePattern(map, 20, 20, 40, 40, false);
                rect.setFill(pattern);

                rect.setOnMouseDragged(ev -> {
                    rect.setX(ev.getX());
                    rect.setY(ev.getY());
                    bed.setLeft(ev.getX() / 100);
                    bed.setTop(ev.getY() / 100);
                });

                garden.getChildren().add(rect);
            } else if (bed instanceof CircleBed) {
                double radius = ((CircleBed) bed).getRadius();
                Circle cir = new Circle(radius * 100);
                cir.setCenterX((bed.getLeft() + radius) * 100);
                cir.setCenterY((bed.getTop() + radius) * 100);

                Image map = new Image("flowers.jpg");
                ImagePattern pattern = new ImagePattern(map, 20, 20, 40, 40, false);
                cir.setFill(pattern);

                cir.setOnMouseDragged(ev -> {
                    cir.setCenterX(ev.getX());
                    cir.setCenterY(ev.getY());
                    bed.setLeft(ev.getX() / 100);
                    bed.setTop(ev.getY() / 100);
                });

                garden.getChildren().add(cir);
            }


            //refresh Summary Data
            planner.recalculateTotals();
            areaTotal.setText(String.format("%.2f m2", planner.getTotalGardenArea()));
            lengthTotal.setText(String.format("%.2f m2", planner.getTotalWallLength()));
            soilTotal.setText(String.format("%.3f m3", planner.getTotalGardenArea() * GardenPlanner.SOIL_DEPTH));
            costTotal.setText(String.format("$ %.2f", planner.getTotalCost()));
        }
    }

}