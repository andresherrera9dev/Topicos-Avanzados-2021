package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    static Scene scene;

    Button btn1;
    Button btn2;
    Button btn3;

    HBox hbx;
    VBox vbx;
    BorderPane pane;

    public class Containers {

        public VBox init_Vbox(){
            btn1=new Button("Boton 1");
            btn2=new Button("Boton 2");
            btn3=new Button("Boton 3");
            vbx = new VBox();
            vbx.setSpacing(10);
            vbx.setPadding(new Insets(20));
            hbx.getChildren().addAll(btn1, btn2, btn3);
            return vbx;
        }
        public HBox init_Hbox(){
            btn1=new Button("Boton 1");
            btn2=new Button("Boton 2");
            btn3=new Button("Boton 3");
            hbx = new HBox();
            hbx.setSpacing(10);
            hbx.setPadding(new Insets(20));
            vbx.getChildren().addAll(btn1, btn2, btn3);
            return hbx;
        }
        public BorderPane init_BorderPane(Label lbl, FlowPane flowPane, GridPane gridPane){
            BorderPane pane = new BorderPane();
            pane.setTop(lbl);
            pane.setBottom(flowPane);
            pane.setPadding(new Insets(5,5,5,5));
            pane.setLeft(gridPane);
            pane.setRight(gridPane);
            Scene scene=new Scene(pane,170,170);
            return pane;
        }
        public Label label(String text){
            Label lbl = new Label(text);
            return lbl;
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Containers contenedores=new Containers();
        primaryStage.setTitle("Hello World");


        Scene scene=new Scene(contenedores.init_Hbox(),125,70);;
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
//git commit -a -m ""
//git push -u origin main