module com.ban03 {
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.controls;

    opens com.ban03 to javafx.fxml;
    exports com.ban03;
}
