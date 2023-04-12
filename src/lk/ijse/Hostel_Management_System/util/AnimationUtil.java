package lk.ijse.Hostel_Management_System.util;

import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AnimationUtil {
    public static void windowAnimation(AnchorPane anchorPane){
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), anchorPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}
