package com.ban;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    ObservableList<Motocicleta> lista;
    @FXML
    RadioButton marcaButton, modeloButton, ccButton, anioButton, precioButton, desButton, ascButton;
    
    ToggleGroup oredenamiento, orden;

    @FXML
    TableColumn<Motocicleta, String> marcaCol;
    @FXML
    TableColumn<Motocicleta, String> modeloCol;
    @FXML
    TableColumn<Motocicleta, Integer> ccCol;
    @FXML
    TableColumn<Motocicleta, Integer> anioCol;
    @FXML
    TableColumn<Motocicleta, Double> precioCol;

    @FXML
    TableView<Motocicleta> table;
    @FXML
    TextField howmany;
    @FXML
    private void exitApp() throws IOException {
        System.exit(0);
    }
    @FXML
     private void initialize() {
        
        oredenamiento = new ToggleGroup();
        orden = new ToggleGroup();
        marcaButton.setToggleGroup(oredenamiento);
        marcaButton.setSelected(true);
        modeloButton.setToggleGroup(oredenamiento);
        ccButton.setToggleGroup(oredenamiento);
        anioButton.setToggleGroup(oredenamiento);
        precioButton.setToggleGroup(oredenamiento);
        ascButton.setToggleGroup(orden);
        ascButton.setSelected(true);
        desButton.setToggleGroup(orden);

        marcaCol.setCellValueFactory(new PropertyValueFactory<Motocicleta, String>("marca"));
        modeloCol.setCellValueFactory(new PropertyValueFactory<Motocicleta, String>("modelo"));
        ccCol.setCellValueFactory(new PropertyValueFactory<Motocicleta, Integer>("centimetrosCubicos"));
        anioCol.setCellValueFactory(new PropertyValueFactory<Motocicleta, Integer>("anio"));
        precioCol.setCellValueFactory(new PropertyValueFactory<Motocicleta, Double>("precio"));
        lista = FXCollections.observableArrayList();
    }
    @FXML
    private void generarMoto() throws IOException {
        if (howmany.getText().length() > 0) {   
            int cantidad = Integer.parseInt(howmany.getText());
            lista = FXCollections.observableArrayList();
            for (int i = 0; i < cantidad; i++) {
                lista.add(new Motocicleta());
            }
            table.setItems(lista);
        }
    }
    @FXML
    private void ordenar() {
        ordenarMarca();
        ordenarModelo();
        ordenarCc();
        ordenarAnio();
        ordenarPrecio();
    }
    @FXML
    private void ordenarMarca() {
        if (marcaButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarMarca());
            } else {
                lista.sort(new OrdenarMarca().reversed());
            }
        }
    }
    @FXML
    private void ordenarModelo() {
        if (modeloButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarModelo());
            } else {
                lista.sort(new OrdenarModelo().reversed());
            }
        }
    }
    @FXML
    private void ordenarCc() {
        if (ccButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarCC());
            } else {
                lista.sort(new OrdenarCC().reversed());
            }
        }
    }
    @FXML
    private void ordenarAnio() {
        if (anioButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarAnio());
            } else {
                lista.sort(new OrdenarAnio().reversed());
            }
        }
    }
    @FXML
    private void ordenarPrecio() {
        if (precioButton.isSelected()) {
            if (ascButton.isSelected()) {
                lista.sort(new OrdenarPrecio());
            } else {
                lista.sort(new OrdenarPrecio().reversed());
            }
        }
    }

}
