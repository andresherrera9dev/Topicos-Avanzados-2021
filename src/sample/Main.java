package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    static Scene scene;

    Button btn1;
    Button btn2;
    Button btn3;

    HBox hbx;
    VBox vbx;
    BorderPane pane;
    FlowPane flow;
    GridPane grid;

    public class Containers {

        public VBox init_Vbox() {
            btn1 = new Button("Boton 1");
            btn2 = new Button("Boton 2");
            btn3 = new Button("Boton 3");
            vbx = new VBox();
            vbx.setSpacing(10);
            vbx.setPadding(new Insets(20));
            hbx.getChildren().addAll(btn1, btn2, btn3);
            return vbx;
        }

        public HBox init_Hbox() {
            btn1 = new Button("Boton 1");
            btn2 = new Button("Boton 2");
            btn3 = new Button("Boton 3");
            hbx = new HBox();
            hbx.setSpacing(10);
            hbx.setPadding(new Insets(20));
            vbx.getChildren().addAll(btn1, btn2, btn3);
            return hbx;
        }

        public BorderPane init_BorderPane() {
            BorderPane pane = new BorderPane();
            pane.setTop(init_Label("This text"));
            pane.setBottom(init_Flowpane(false));
            pane.setPadding(new Insets(5, 5, 5, 5));
            pane.setLeft(init_Gridpane());
            pane.setRight(init_Flowpane(true));
            return pane;
        }

        public Label init_Label(String text) {
            Label lbl = new Label(text);

            lbl.setAlignment(Pos.TOP_RIGHT);
            return lbl;
        }

        public FlowPane init_Flowpane(boolean vertical) {
            if (vertical) {
                flow = new FlowPane(Orientation.VERTICAL);
                flow.setVgap(10);
            } else {
                flow = new FlowPane();
                flow.setHgap(10);
            }
            flow.getChildren().addAll(new Button("Boton 1"), new Button("Boton 2"), new Button("Boton 3"));
            flow.setPadding(new Insets(5, 5, 5, 5));

            flow.setAlignment(Pos.CENTER);
            return flow;
        }

        public GridPane init_Gridpane() {
            grid = new GridPane();
            grid.add(new Button("Posicion 0, 0"), 0, 0);
            grid.add(new Button("Posicion 0, 0"), 1, 0);
            grid.add(new Button("Posicion 0, 0"), 2, 0);
            grid.add(new Button("Posicion 0, 0"), 0, 1);
            grid.add(new Button("Posicion 0, 0"), 1, 1);
            grid.add(new Button("Posicion 0, 0"), 2, 1);
            grid.add(new Button("Posicion 0, 0"), 0, 2);
            grid.add(new Button("Posicion 0, 0"), 1, 2);
            grid.add(new Button("Posicion 0, 0"), 2, 2);


            grid.setPadding(new Insets(5, 5, 5, 5));
            grid.setPrefSize(500, 300);
            grid.setHgap(10);
            grid.setVgap(10);

            grid.setAlignment(Pos.CENTER);
            return grid;
        }

    }

    class Cuadro_magico {
        public void iniciar(int area) {
            int[][] matrix_cuadro_magico = new int[area][area];
            int[] control_matrix = new int[area];
            Random variable_random = new Random();
            int valor_sumatoria_random = variable_random.nextInt(20) + area + 20;
            int resta_sum = valor_sumatoria_random;

            for (int i = 0; i < area; i++) {
                control_matrix[i] = valor_sumatoria_random;
                System.out.println(control_matrix[i]);
            }

            System.out.println(valor_sumatoria_random);
            int valor_rand;
            System.out.println();
            int valor_max = valor_sumatoria_random;



            for (int i = 0; i < area; i++) {
                for (int ii = 0; ii < matrix_cuadro_magico.length; ii++) {
                    if (i == 0) {
                        if (ii + 1 < matrix_cuadro_magico.length) {//primer ultimo caso

                            matrix_cuadro_magico[i][ii] = resta_sum;
                            valor_rand = variable_random.nextInt(resta_sum);
                            if (valor_rand == 0) valor_rand++;
                            if (valor_rand == valor_sumatoria_random) valor_rand--;
                            while (valor_rand >= valor_sumatoria_random) valor_rand--;
                            resta_sum -= valor_rand;
                            matrix_cuadro_magico[i][ii] = valor_rand;
                            System.out.print(matrix_cuadro_magico[i][ii] + " (" + resta_sum + ") ");
                        } else {//caso normal
                            matrix_cuadro_magico[i][ii] = resta_sum;
                            valor_rand = variable_random.nextInt(resta_sum);
                            if (valor_rand == 0) valor_rand++;
                            if (valor_rand == valor_sumatoria_random) valor_rand--;
                            while (valor_rand >= valor_sumatoria_random) valor_rand--;
                            resta_sum -= valor_rand;
                            matrix_cuadro_magico[i][ii] = valor_rand+resta_sum; //primer caso normal

                            System.out.print(matrix_cuadro_magico[i][ii] + " (" + resta_sum + ") ");
                        }
                    } else {
                        if (ii + 1 < matrix_cuadro_magico.length) {//ultimo caso de siguientes arreglos
                            matrix_cuadro_magico[i][ii] = resta_sum;

                            valor_rand = variable_random.nextInt(resta_sum);

                            if (valor_rand == 0) valor_rand++;
                            if (valor_rand == valor_sumatoria_random) valor_rand--;
                            while (valor_rand >= valor_sumatoria_random) valor_rand--;
                            resta_sum -= valor_rand;
                            matrix_cuadro_magico[i][ii] = valor_rand;
                            System.out.print(matrix_cuadro_magico[i][ii] + " (" + resta_sum + ") ");
                        } else {// caso normal
                            matrix_cuadro_magico[i][ii] = resta_sum;
                            valor_rand = variable_random.nextInt(resta_sum);
                            if (valor_rand > valor_max) ;
                            if (valor_rand == 0) valor_rand++;
                            if (valor_rand == valor_sumatoria_random) valor_rand--;
                            while (valor_rand >= valor_sumatoria_random) valor_rand--;
                            resta_sum -= valor_rand;
                            matrix_cuadro_magico[i][ii] = valor_rand + resta_sum;
                            System.out.print(matrix_cuadro_magico[i][ii] + " (" + resta_sum + ") ");
                        }
                    }
                }
                resta_sum = valor_sumatoria_random;
                System.out.println();
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Containers contenedores = new Containers();
        primaryStage.setTitle("Cuadro Magico");
        Cuadro_magico juego = new Cuadro_magico();
        juego.iniciar(3);

        Scene scene = new Scene(contenedores.init_Gridpane(), 300, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
//git commit -a -m ""
//git push -u origin main