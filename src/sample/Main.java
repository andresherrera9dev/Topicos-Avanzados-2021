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

    class Cuadro_magico_v2 {

        public void iniciar(int a) {

            int posicion_x = 0, posicion_y = 0;
            int save_posicion_x, save_posicion_y;
            int rotar=0;

            posicion_x = 0;
            posicion_y = (a - (a - 1) / 2) - 1;

            System.out.println("Posicion seleccionada al azar:(" + posicion_x + ", " + posicion_y + ")");
            int contador = 0;

            //0,1=3u=a-(a-1)/2=x
            //0,2=5u=a-(a-1)/2=x
            //0,3=7u=a-(a-1)/2=x

            int[][] matrix_cuadro_magico = new int[a][a];
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
        Containers contenedores = new Containers();
        primaryStage.setTitle("Cuadro Magico");
        Cuadro_magico_v2 juego = new Cuadro_magico_v2();
        juego.iniciar(15);

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