package com.example.enkelknapudenfxml;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXHello extends Application {
    private Button hejKnap;

    @Override
    public void start(Stage primaryStage) {
        // Lav knap og tilknyt event
        hejKnap = new Button();
        hejKnap.setText("Sig Hej");
        hejKnap.setOnAction(evt -> ændreKnap());

        // Sæt scene og vindue (stage)
        StackPane rod = new StackPane();   // roden af scenegrafen holder layoutet for scenen
        rod.getChildren().add(hejKnap);    // hejKnappen tilknyttes roden

        Scene scene = new Scene(rod, 300, 100);  // Scenen sættes
        primaryStage.setScene(scene);    // Scenen placeres i et vindue
        primaryStage.setTitle("Hej med dig");
        primaryStage.show();             // Vis vinduet
    }

    // Lav en smart transition der fader en knap ud og skifter titel, før den fader ind igen
    public void ændreKnap() {
        // Lav fade ud
        FadeTransition ft1 = new FadeTransition(Duration.millis(3000), hejKnap);
        ft1.setFromValue(1.0);
        ft1.setToValue(0.0);
        // Når den er færdig, så skift tekst på knap
        ft1.setOnFinished(e -> {
            hejKnap.setText("HEJ");
        });
        // Lav fade ind
        FadeTransition ft2 = new FadeTransition(Duration.millis(3000), hejKnap);
        ft2.setFromValue(0.0);
        ft2.setToValue(1.0);
        ft2.play();
        // Sæt dem til at blive afspillet efter hinanden
        SequentialTransition st = new SequentialTransition();
        st.getChildren().addAll(ft1, ft2);
        st.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}