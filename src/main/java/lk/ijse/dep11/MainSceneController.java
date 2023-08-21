package lk.ijse.dep11;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
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
    public Spinner<Double> txtScale;
    public Button btnScale;
    public Circle shpScale;
    public ComboBox<String> cbTranslate;
    public Button btnTranslate;
    public Rectangle shpTranslate;
    public ColorPicker clrFrom;
    public ColorPicker clrTo;
    public Circle shpFill;
    public Button btnFill;
    public ColorPicker clrFromStroke;
    public ColorPicker clrToStroke;
    public Button btnStroke;
    public Rectangle shpStroke;
    public Button btnReset;

    //FadeIn    hidden --> show
    //FadeOut   shown --> hide

    public void initialize(){
        //min=-360, max=360, start=45, increment=10
        txtRotate.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-360, 360, 45, 10));
//        txtRotate.getValueFactory().setValue(45);

        //min=-0.5, max=2.5, start=1, increment=0.1
        txtScale.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-0.5, 2.5, 1, 0.1));
        txtScale.getValueFactory().setValue(2.0);

        cbTranslate.getItems().add("SlideInLeft");
        cbTranslate.getItems().add("SlideInRight");
        cbTranslate.getItems().add("SlideInUp");
        cbTranslate.getItems().add("SlideInDown");
        cbTranslate.getItems().add("SlideOutLeft");
        cbTranslate.getItems().add("SlideOutRight");
        cbTranslate.getItems().add("SlideOutUp");
        cbTranslate.getItems().add("SlideOutDown");
        cbTranslate.setValue(cbTranslate.getItems().get(0));

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

    public void btnScaleOnAction(ActionEvent e) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(500), shpScale);
        scale.setFromX(0);
        scale.setFromY(0);

        scale.setToX(txtScale.getValue());
        scale.setToY(txtScale.getValue());
        scale.playFromStart();


    }

    public void btnTranslateOnAction(ActionEvent e) {
        //x=64, y=86
        TranslateTransition translate = new TranslateTransition(Duration.millis(500), shpTranslate);
        switch (cbTranslate.getValue()){
            case "SlideInLeft":
                translate.setFromX(64);
                translate.setToX(0);
                break;
            case "SlideInRight":
                translate.setFromX(-64);
                translate.setToX(0);
                break;
            case "SlideInUp":
                translate.setFromX(86);
                translate.setToY(0);
                break;
            case "SlideInDown":
                translate.setFromX(0);
                translate.setToY(86);
                break;
            case "SlideOutLeft":
                translate.setFromX(0);
                translate.setToX(-250);
                break;
            case "SlideOutRight":
                translate.setFromX(0);
                translate.setToX(250);
                break;
            case "SlideOutUp":
                translate.setFromY(250);
                translate.setToY(0);
                break;
            case "SlideOutDown":
                translate.setFromY(0);
                translate.setToY(250);
                break;
        }

        translate.playFromStart();

    }

    public void btnFillOnAction(ActionEvent e) {
        FillTransition fill = new FillTransition(Duration.millis(500), shpFill);
        fill.setFromValue(clrFrom.getValue());
        fill.setToValue(clrTo.getValue());
        fill.playFromStart();
    }

    public void btnStrokeOnAction(ActionEvent e) {
        StrokeTransition stroke = new StrokeTransition(Duration.millis(2500), shpStroke);
        stroke.setFromValue(clrFromStroke.getValue());
        stroke.setToValue(clrToStroke.getValue());
        stroke.playFromStart();

    }

    public void btnRestOnAction(ActionEvent e) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(500), shpScale);
        scale.setToX(1);
        scale.setToY(1);
        scale.playFromStart();

    }
}
