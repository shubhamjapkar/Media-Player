package mediaViewpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class mediaView__class extends Application {

    public static void main(String[] args) {
        launch(args);
    }

/////// path for media view
    ////--module-path "D:\Java IntellijId programs files\JavaFX\javafx-sdk-16\lib" --add-modules javafx.controls,javafx.fxml,javafx.media
    @Override
    public void start(Stage stage) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("mediaViewediting.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);

        String css= Objects.requireNonNull(this.getClass().getResource("mediaplayer.css")).toExternalForm();
        scene.getStylesheets().add(css);

        Image image=new Image(new FileInputStream("src/mediaViewpackage/VideoRecorder Logo.png"));
        stage.getIcons().add(image);

        stage.setResizable(false);

        stage.show();

    }
}
