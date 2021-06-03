package mediaViewpackage;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class mediaview_contr implements Initializable {
   @FXML
   private MediaView mediaView;
   @FXML
   private Button RunButton, StopButton, ResetButton;

   private File file;
   private Media media;
   private MediaPlayer mediaPlayer;

    int check;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    int pauseplay;
    public void RunButton(ActionEvent event) {
        pauseplay++;
        if (file!=null){
            if (pauseplay%2!=0){
                mediaPlayer.play();
            }
            else if (pauseplay%2==0){
                mediaPlayer.pause();
            }
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please First Play then Reset");
            alert.show();
        }

    }


    public void ResetButton(ActionEvent event) {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            if (file!=null){
                mediaPlayer.seek(Duration.ZERO);
            }
        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please First Play then Reset");
            alert.show();
        }
    }


int checkingfile;
    public void fileButton() {
       if (mediaView.getMediaPlayer()!=null){
           mediaPlayer.stop();
       }

        try {
                JFileChooser chooser=new JFileChooser();
                chooser.setCurrentDirectory(new File("D://"));
                int ok=chooser.showOpenDialog(null);

            if (ok==1){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.CANCEL){
                    System.exit(0);
                }

            }
                file =new File(chooser.getSelectedFile().getAbsolutePath());
                media =new Media(file.toURI().toString());
                mediaPlayer =new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
            }
        catch (Exception e){
            System.out.println("hi checking");
        }

    }

    public void cancelled(){
        System.out.println("cancelled");
        mediaPlayer.stop();
    }
}
