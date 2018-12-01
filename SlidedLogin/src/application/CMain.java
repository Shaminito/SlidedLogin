package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class CMain implements Initializable{

	@FXML
	AnchorPane pane2;
	
	@FXML
	AnchorPane pane3;
	
	@FXML
	AnchorPane pane4;
	
	FadeTransition ftPane2;
	FadeTransition ftPane3;
	FadeTransition ftPane4;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		backgroundAnimation();
	}

	private void backgroundAnimation() {
		ftPane4 = new FadeTransition(Duration.seconds(4), pane4);
		ftPane3 = new FadeTransition(Duration.seconds(4), pane3);
		ftPane2 = new FadeTransition(Duration.seconds(4), pane2);

		ftPane4.setFromValue(1);
		ftPane4.setToValue(0);
		ftPane4.play();

		ftPane4.setOnFinished(event -> {
	
			ftPane3.setFromValue(1);
			ftPane3.setToValue(0);
			ftPane3.play();
					
			ftPane3.setOnFinished(event1 -> {
				ftPane2.setFromValue(1);
				ftPane2.setToValue(0);
				ftPane2.play();

				ftPane2.setOnFinished(event2 -> {

					ftPane2.setFromValue(0);
					ftPane2.setToValue(1);
					ftPane2.play();

					ftPane2.setOnFinished(event3 -> {

						ftPane3.setFromValue(0);
						ftPane3.setToValue(1);
						ftPane3.play();

						ftPane3.setOnFinished(event4 -> {

							ftPane4.setFromValue(0);
							ftPane4.setToValue(1);
							ftPane4.play();

							ftPane4.setOnFinished(event5 -> {

								backgroundAnimation();
							});
						});

					});

				});
				
			});
		});
	}
}
