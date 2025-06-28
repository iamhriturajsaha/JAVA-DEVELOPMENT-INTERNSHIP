package com.calculator.icon;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StageIconLoader {
    public static void loadIcon(Application source, Stage stage)
    {
        String iconPath = source.getClass().getResource("/assets/images/calculator.png").toString();
        stage.getIcons().add(new Image(iconPath));
    }
}
