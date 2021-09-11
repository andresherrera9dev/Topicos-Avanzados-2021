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

    public class Containers {

        public VBox init_Vbox() {
            VBox vbx;
            Button btn1;
            Button btn2;
            Button btn3;
            btn1 = new Button("Boton 1");
            btn2 = new Button("Boton 2");
            btn3 = new Button("Boton 3");
            vbx = new VBox();
            vbx.setSpacing(10);
            vbx.setPadding(new Insets(20));
            vbx.getChildren().addAll(btn1, btn2, btn3);
            return vbx;
        }

        public HBox init_Hbox() {
            Button btn1;
            Button btn2;
            Button btn3;
            HBox hbx;
            btn1 = new Button("Boton 1");
            btn2 = new Button("Boton 2");
            btn3 = new Button("Boton 3");
            hbx = new HBox();
            hbx.setSpacing(10);
            hbx.setPadding(new Insets(20));
            hbx.getChildren().addAll(btn1, btn2, btn3);
            return hbx;
        }

        public BorderPane init_BorderPane() {
            BorderPane pane = new BorderPane();
            pane.setTop(init_Label("This text"));
            pane.setBottom(init_Flowpane(false));
            pane.setPadding(new Insets(5, 5, 5, 5));
            pane.setRight(init_Flowpane(true));
            return pane;
        }

        public Label init_Label(String text) {
            Label lbl = new Label(text);

            lbl.setAlignment(Pos.TOP_RIGHT);
            return lbl;
        }

        public FlowPane init_Flowpane(boolean vertical) {
            FlowPane flow;
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

    }

    class Cuadro_magico_v2 {
        int[][] matrix_cuadro_magico;

        public void iniciar(int a) {
            matrix_cuadro_magico = new int[a][a];
            int posicion_x = 0, posicion_y = 0;
            int save_posicion_x, save_posicion_y;

            posicion_x = 0;
            posicion_y = (a - (a - 1) / 2) - 1;

            System.out.println("Posicion seleccionada al azar:(" + posicion_x + ", " + posicion_y + ")");
            int contador = 0;

            //0,1=3u=a-(a-1)/2=x
            //0,2=5u=a-(a-1)/2=x
            //0,3=7u=a-(a-1)/2=x

            for (int i = 0; i < matrix_cuadro_magico.length; i++) {
                for (int ii = 0; ii < matrix_cuadro_magico.length; ii++) {
                    matrix_cuadro_magico[i][ii] = 0;
                    System.out.print(matrix_cuadro_magico[i][ii] + " (" + i + ", " + ii + ") ");
                }
                System.out.println();
            }
            System.out.println();

            System.out.println("Posicion:(" + posicion_x + ", " + posicion_y + ")");
            //arriba, derecha
            for (int i = 0; i < matrix_cuadro_magico.length; i++) {
                for (int ii = 0; ii < matrix_cuadro_magico.length; ii++) {
                    contador++;
                    if (i == 0 && ii == 0) {
                        matrix_cuadro_magico[posicion_x][posicion_y] = contador;
                        System.out.println("1.Contador:," + contador + ", Direccion: (" + posicion_x + ", " + posicion_y + "), Valor matrix: " + matrix_cuadro_magico[posicion_x][posicion_y]);

                    } else {
                        save_posicion_x = posicion_x;
                        save_posicion_y = posicion_y;

                        if (posicion_x == 0) posicion_x = (matrix_cuadro_magico.length - 1);
                        else posicion_x--;
                        if (posicion_y > matrix_cuadro_magico.length - 2) posicion_y = 0;
                        else posicion_y++;

                        if (matrix_cuadro_magico[posicion_x][posicion_y] != 0) {
                            posicion_x = save_posicion_x;
                            posicion_y = save_posicion_y;

                            if (posicion_x > matrix_cuadro_magico.length) posicion_x = 0;
                            else posicion_x++;
                            matrix_cuadro_magico[posicion_x][posicion_y] = contador;
                        }

                        //reparar mecananismo
                        else {
                            matrix_cuadro_magico[posicion_x][posicion_y] = contador;
                            System.out.println("3.Contador:," + contador + ", Direccion: (" + posicion_x + ", " + posicion_y + "), Valor matrix: " + matrix_cuadro_magico[posicion_x][posicion_y]);
                        }


                    }
                }
                System.out.println();
            }
            for (int i = 0; i < matrix_cuadro_magico.length; i++) {
                for (int ii = 0; ii < matrix_cuadro_magico.length; ii++) {
                    System.out.print(matrix_cuadro_magico[i][ii]);
                }
                System.out.println();
            }
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Cuadro_magico_v2 jugar = new Cuadro_magico_v2();
        GridPane grid = new GridPane();
        BorderPane pane = new BorderPane();
        Label lbl = new Label("Cuadro Magico");

        HBox hbx = new HBox();
        Button btn1 = new Button("Cuadro Magico");
        hbx.setSpacing(10);
        hbx.setPadding(new Insets(20));
        hbx.getChildren().addAll(btn1);
        hbx.setAlignment(Pos.CENTER);

        HBox hbx2 = new HBox();
        Button btn2 = new Button("-Reducir");
        Button btn3 = new Button("+Aumentar");
        hbx2.setSpacing(10);
        hbx2.setPadding(new Insets(20));
        hbx2.getChildren().addAll(btn3,btn2);
        hbx2.setAlignment(Pos.CENTER);

        int dimension = 3;
        jugar.iniciar(dimension);
        primaryStage.setTitle("Cuadro Magico");

        grid = new GridPane();

        for (int i = 0; i < dimension; i++) {
            for (int ii = 0; ii < dimension; ii++) {
                grid.add(new Button(Integer.toString(jugar.matrix_cuadro_magico[i][ii])), i, ii);
            }
        }
        grid.setPrefSize(500, 300);
        grid.setPadding(new Insets(15, 15, 15, 15));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPrefWidth(800);
        grid.setAlignment(Pos.CENTER);

        pane.setTop(hbx);
        pane.setCenter(grid);
        pane.setBottom(hbx2);
        pane.setPadding(new Insets(5, 5, 5, 5));

        Scene scene = new Scene(pane, 200, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
//git commit -a -m ""
//git push -u origin main