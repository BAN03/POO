package com.ban03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Random;

public class GUIController {
    private String[] nombres = { "Ana", "Luis", "María", "Carlos", "Elena", "Jorge", "Sofía", "Pedro", "Lucía",
            "Miguel", "Isabel", "Fernando", "Carmen", "Raúl", "Patricia", "Diego", "Laura", "Andrés", "Marta",
            "Ricardo", "Julia", "Antonio", "Clara", "Roberto", "Gabriela", "Daniel", "Sara", "Francisco", "Paula",
            "Alberto", "Cristina", "Manuel", "Rosa", "Alejandro", "Teresa", "Juan", "Beatriz", "José", "Natalia",
            "Víctor", "Adriana", "Hugo", "Alicia", "Sergio", "Mónica", "Iván", "Verónica", "Eduardo", "Silvia" };
    private ArrayList<String> nombresA = new ArrayList<String>();
    private boolean isFirst = true;
    private TextArea[] textos;
    private Alumnos[] alumnos;
    private Juego juego;
    @FXML
    TextArea allAlumnos, linguistica, musica, mates, espacial, kinestesica, ganadores;
    @FXML
    TextField textCantidad;
    @FXML
    Button generarButton;

    @FXML
    public void initialize() {
        for (String string : nombres) {
            nombresA.add(string);
        }
        this.textos = new TextArea[] { linguistica, musica, mates, espacial, kinestesica, allAlumnos, ganadores };
    }

    @FXML
    public void generar() {
        String texto = textCantidad.getText();
        if (!textCantidad.getText().isEmpty() && texto.compareTo("0") > 0
                && texto.compareTo(":") < 0) {
            int cantidad = Integer.parseInt(textCantidad.getText());
            this.alumnos = new Alumnos[cantidad];
            for (int i = 0; i < cantidad; i++) {
                String randomName = nombresA.get(new Random().nextInt(nombresA.size()));
                this.alumnos[i] = new Alumnos(randomName);
                nombresA.remove(nombresA.indexOf(randomName));
                this.textos[5].appendText(this.alumnos[i].toString());
            }
            generarButton.setDisable(true);
        }
    }

    @FXML
    public void etapa() {
        if (this.alumnos != null && this.isFirst) {
            this.juego = new Juego(this.alumnos, this.textos);
            this.isFirst = false;
        }
        this.juego.etapas();
    }

    @FXML
    public void borrar() {
        this.isFirst = true;
        for (TextArea texto : this.textos) {
            texto.clear();
        }
        this.generarButton.setDisable(false);
    }

    @FXML
    public void salir() {
        System.exit(0);
    }
}
