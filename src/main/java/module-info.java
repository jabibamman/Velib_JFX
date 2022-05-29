module com.velib.velib_jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.json;
    requires reverseGeocoding;

    opens com.velib.velib_jfx to javafx.fxml;
    exports com.velib.velib_jfx;
}