module dev.legol4.moustacheshop {
    requires java.desktop;
    requires java.net.http;
    requires java.prefs;


    requires com.fasterxml.jackson.databind;
    requires com.google.zxing.javase;
    requires com.google.zxing;
    requires com.jfoenix;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires org.burningwave.core;
    requires org.controlsfx.controls;
    requires static lombok;


    exports dev.legol4.moustacheshop.application;
    opens dev.legol4.moustacheshop.application to javafx.fxml;
    exports dev.legol4.moustacheshop.controllers;
    opens dev.legol4.moustacheshop.controllers to javafx.fxml;


    exports dev.legol4.moustacheshop.models to com.fasterxml.jackson.databind;
    opens dev.legol4.moustacheshop.dto to com.fasterxml.jackson.databind;


    exports dev.legol4.moustacheshop.components;
    opens dev.legol4.moustacheshop.components to javafx.fxml, com.fasterxml.jackson.databind;
}