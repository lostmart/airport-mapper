package org.example;

import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Interface extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("World Airports");

        Earth earth = new Earth();  // Changed from Group
        Pane pane = new Pane(earth);

        Scene scene = new Scene(pane, 800, 600, true);  // true = enable 3D

        // Add camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-1000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);
        scene.setCamera(camera);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}