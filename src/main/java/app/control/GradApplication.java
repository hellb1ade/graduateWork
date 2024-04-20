package app.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GradApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gradProj.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 1000);
        stage.setTitle("GraduateWork");
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }
}