module app.animes {
    requires java.dotenv;
    requires java.sql;
    requires javafx.graphics;
    requires jbcrypt;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.app.anime.controller to javafx.fxml;
    exports com.app.anime;
}