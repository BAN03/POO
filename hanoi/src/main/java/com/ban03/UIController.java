package com.ban03;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;

public class UIController {
    private int cantidad = 0;
    Torres torres;
    Rectangle torreA;
    Rectangle torreB;
    Rectangle torreC;
    Rectangle[] discos;

    @FXML
    TextField cantidadTexto;
    @FXML
    Pane container;
    // 600, 300

    @FXML
    public void initialize() {
        ponerTorres();
    }

    @FXML
    public void order() {
        if (this.torres != null) {
            if (this.torres.getC()) {
                this.torres.torres();
            }
        }
    }

    @FXML
    public void borrar() {
        container.getChildren().clear();
        this.torres = null;
        this.discos = null;
        ponerTorres();
    }

    @FXML
    public void generarDiscos() {
        String inputLabel = this.cantidadTexto.getText();
        if (inputLabel.length() > 0 && this.discos == null && inputLabel.compareToIgnoreCase("0") > 0
                && inputLabel.compareToIgnoreCase(":") < 0) {
            this.cantidad = Integer.parseInt(inputLabel);
            if (this.cantidad > 0) {
                this.discos = new Rectangle[this.cantidad];
                for (int i = 0; i < this.cantidad; i++) {
                    this.discos[i] = new Rectangle((200 - (i * (200 / this.cantidad))),
                            ((this.torreA.getHeight() - 25) / this.discos.length));
                    this.discos[i].setLayoutX((200 - (this.discos[i].getWidth())) / 2);
                    this.discos[i].setLayoutY(300 - (this.discos[i].getHeight() * (i + 1)));
                    this.discos[i].setFill(Color.DODGERBLUE);
                    this.discos[i].setStroke(Color.BLACK);
                }
                container.getChildren().addAll(this.discos);
                this.torres = new Torres(this.cantidad, this.discos);
            }
        }
    }

    @FXML
    public void salir() {
        System.exit(0);
    }

    private void ponerTorres() {
        this.torreA = new Rectangle(20, 250);
        this.torreB = new Rectangle(20, 250);
        this.torreC = new Rectangle(20, 250);
        // (container.width / positions * position) - (rectangle.width / 2)
        // (600 / 6 * 1) - (20 / 2)
        this.torreA.setLayoutX(90);
        this.torreA.setLayoutY(300 - torreA.getHeight());
        // (600 / 6 * 3) - (20 / 2)
        this.torreB.setLayoutX(290);
        this.torreB.setLayoutY(300 - torreB.getHeight());
        // (600 / 6 * 5) - (20 / 2)
        this.torreC.setLayoutX(490);
        this.torreC.setLayoutY(300 - torreC.getHeight());

        container.getChildren().addAll(this.torreA, this.torreB, this.torreC);
    }
}
