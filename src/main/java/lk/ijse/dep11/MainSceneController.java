package lk.ijse.dep11;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainSceneController {
    public AnchorPane root;
    public Button btnFadeIn;
    public Button btnFadeOut;
    public Circle shpFade;
    public Button btnRotate;
    public Rectangle shpRotate;
    public Spinner<Integer> txtRotate;

    //FadeIn    hidden --> show
    //FadeOut   shown --> hide

    public void initialize(){
        txtRotate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-360, 360));
    }

    public void btnFadeInOnAction(ActionEvent e) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500),shpFade);
        fadeOut.setFromValue(0);
        fadeOut.setFromValue(1);
        fadeOut.playFromStart();
    }

    public void btnFadeOutOnAction(ActionEvent e) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500),shpFade);
        fadeOut.setFromValue(1);
        fadeOut.setFromValue(0);
        fadeOut.playFromStart();
    }

    public void btnRotateOnAction(ActionEvent e) {
        RotateTransition rotate = new RotateTransition(Duration.millis(500), shpRotate);
        rotate.setFromAngle(0);
        rotate.setToAngle(txtRotate.getValue());
        rotate.playFromStart();


    }


}
