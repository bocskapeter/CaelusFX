module eu.bopet.caelus.fx.caelusfx {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires com.dlsc.gmapsfx;

    requires jdk.jsobject;
    requires java.logging;
    requires java.desktop;
    requires org.slf4j;

    opens eu.bopet.caelus.fx.caelusfx to javafx.fxml;
    exports eu.bopet.caelus.fx.caelusfx;

}