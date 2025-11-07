package org.example;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class Earth extends Group {

    public Earth() {
        Sphere sph = new Sphere(300);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        sph.setMaterial(material);

        this.getChildren().add(sph);
    }
}
