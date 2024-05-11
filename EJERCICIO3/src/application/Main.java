package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        root.setPadding(new Insets(10));

        ListView<String> listView = new ListView<>();
        listView.setItems(FXCollections.observableArrayList());
        root.getChildren().add(listView);
        AnchorPane.setTopAnchor(listView, 20.0);
        AnchorPane.setLeftAnchor(listView, 300.0);
        AnchorPane.setBottomAnchor(listView, 50.0);
        AnchorPane.setRightAnchor(listView, 20.0);

        TextField textField = new TextField();
        textField.setPromptText("Ingrese....");
        root.getChildren().add(textField);
        AnchorPane.setBottomAnchor(textField, 20.0);
        AnchorPane.setLeftAnchor(textField, 300.0);
        AnchorPane.setRightAnchor(textField, 20.0);
        textField.setPrefWidth(180);

        String[] nombres = {
            "Marco Pepe Perez Torres",
            "Ana Cristel Vargas Suarez",
            "Alejandro Dennis Martinez Velez",
            "Laura Julieta Vite Zambrano"
        };

        for (int i = 1; i <= 4; i++) {
            try {
                String imagePath = "/IMAGENES/imagen" + i + ".jpg";
                InputStream inputStream = getClass().getResourceAsStream(imagePath);
                if (inputStream != null) {
                    Image imagen = new Image(inputStream);
                    ImageView imageView = new ImageView(imagen);
                    imageView.setFitWidth(50);
                    imageView.setFitHeight(50);
                    root.getChildren().add(imageView);
                    AnchorPane.setTopAnchor(imageView, 10.0 + i * 60);
                    AnchorPane.setLeftAnchor(imageView, 10.0);

                    Label label = new Label(nombres[i - 1]);
                    root.getChildren().add(label);
                    AnchorPane.setTopAnchor(label, 20.0 + i * 60);
                    AnchorPane.setLeftAnchor(label, 70.0);
                } else {
                    System.out.println("No se pudo cargar la imagen: " + imagePath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Listado de Clientes Ingresados");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
