module marino.david_snake_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens marino.david_snake_javafx to javafx.fxml;
    exports marino.david_snake_javafx;
    exports marino.david_snake_javafx.fruits;
    opens marino.david_snake_javafx.fruits to javafx.fxml;
}