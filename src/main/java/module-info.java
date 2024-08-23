module com.ban {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ban to javafx.fxml;

    exports com.ban;
}
