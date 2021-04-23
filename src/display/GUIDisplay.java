package display;

import buttons.AwayButton;
import buttons.ButtonEight;
import buttons.ButtonFive;
import buttons.ButtonFour;
import buttons.ButtonNine;
import buttons.ButtonOne;
import buttons.ButtonSeven;
import buttons.ButtonSix;
import buttons.ButtonThree;
import buttons.ButtonTwo;
import buttons.ButtonZero;
import buttons.CancelButton;
import buttons.GUIButton;
import buttons.MotionDetectorButton;
import buttons.StayButton;
import checkboxes.GUICheckbox;
import checkboxes.ZoneOneCheckbox;
import checkboxes.ZoneThreeCheckbox;
import checkboxes.ZoneTwoCheckbox;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.AlarmContext;

public class GUIDisplay extends Application implements AlarmDisplay {
	private GUIButton buttonOne;
	private GUIButton buttonTwo;
	private GUIButton buttonThree;
	private GUIButton buttonFour;
	private GUIButton buttonFive;
	private GUIButton buttonSix;
	private GUIButton buttonSeven;
	private GUIButton buttonEight;
	private GUIButton buttonNine;
	private GUIButton buttonZero;
	private GUIButton awayButton;
	private GUIButton cancelButton;
	private GUIButton motionDetectorButton;
	private GUIButton stayButton;
	private GUICheckbox zoneOneCheckbox;
	private GUICheckbox zoneTwoCheckbox;
	private GUICheckbox zoneThreeCheckbox;
	private Label readyStatusLabel;
	private TextField statusScreen;
	private static AlarmDisplay display;
	private AlarmContext alarmContext;
	private String password = "";

	public static AlarmDisplay getInstance() {
		return display;
	}

	public void start(Stage primaryStage) throws Exception {
		alarmContext = AlarmContext.instance();
		alarmContext.setDisplay(this);
		display = this;

		buttonOne = new ButtonOne("1");
		buttonTwo = new ButtonTwo("2");
		buttonThree = new ButtonThree("3");
		buttonFour = new ButtonFour("4");
		buttonFive = new ButtonFive("5");
		buttonSix = new ButtonSix("6");
		buttonSeven = new ButtonSeven("7");
		buttonEight = new ButtonEight("8");
		buttonNine = new ButtonNine("9");
		buttonZero = new ButtonZero("0");
		awayButton = new AwayButton("Away");
		cancelButton = new CancelButton("Cancel");
		motionDetectorButton = new MotionDetectorButton("Motion Detector");
		stayButton = new StayButton("Stay");
		zoneOneCheckbox = new ZoneOneCheckbox("Zone 1");
		zoneTwoCheckbox = new ZoneTwoCheckbox("Zone 2");
		zoneThreeCheckbox = new ZoneThreeCheckbox("Zone 3");
		readyStatusLabel = new Label("Ready Status");
		statusScreen = new TextField("Not Ready! Please, Close all doors first.");
		statusScreen.setPrefWidth(290);
		statusScreen.setPrefHeight(150);
		GridPane mainPane = new GridPane();
		GridPane numberPane = new GridPane();
		GridPane statusPane = new GridPane();
		GridPane zonePane = new GridPane();
		GridPane buttonPane = new GridPane();
		mainPane.add(numberPane, 0, 0);
		mainPane.setPadding(new Insets(10, 10, 10, 10));
		numberPane.setPadding(new Insets(10, 10, 10, 10));
		statusPane.setPadding(new Insets(10, 10, 10, 10));
		zonePane.setPadding(new Insets(10, 10, 10, 10));
		buttonPane.setPadding(new Insets(10, 10, 10, 10));
		numberPane.setHgap(10);
		numberPane.setVgap(10);
		zonePane.setHgap(10);
		zonePane.setVgap(10);
		buttonPane.setHgap(10);
		numberPane.add(buttonOne, 0, 0);
		numberPane.add(buttonTwo, 1, 0);
		numberPane.add(buttonThree, 2, 0);
		numberPane.add(buttonFour, 0, 1);
		numberPane.add(buttonFive, 1, 1);
		numberPane.add(buttonSix, 2, 1);
		numberPane.add(buttonSeven, 0, 2);
		numberPane.add(buttonEight, 1, 2);
		numberPane.add(buttonNine, 2, 2);
		numberPane.add(buttonZero, 1, 3);
		mainPane.add(statusPane, 1, 0);
		statusPane.add(statusScreen, 0, 0);
		mainPane.add(zonePane, 0, 1);
		zonePane.add(zoneOneCheckbox, 0, 0);
		zonePane.add(zoneTwoCheckbox, 0, 1);
		zonePane.add(zoneThreeCheckbox, 0, 2);
		mainPane.add(buttonPane, 1, 1);
		buttonPane.add(readyStatusLabel, 0, 0);
		buttonPane.add(motionDetectorButton, 0, 1);
		buttonPane.add(stayButton, 3, 1);
		buttonPane.add(awayButton, 4, 1);
		buttonPane.add(cancelButton, 5, 1);
		Scene scene = new Scene(mainPane);
		primaryStage.setTitle("Security System");
		primaryStage.setScene(scene);
//		unarmedOfButton();

		try {
			while (alarmContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}

		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});

	}

	/**
	 * display the remaining time
	 * 
	 * @param the value remaining
	 */
	@Override
	public void showTimeLeft(int value) {
		statusScreen.setText("Please Enter Password " + value);
	}

	@Override
	public void showNotReady() {
		statusScreen.setText("Not Ready");
	}

	@Override
	public void showReady() {
		statusScreen.setText("Ready");
	}

	/**
	 * Indicate that the light is on
	 */
	@Override
	public void showAway() {
		statusScreen.setText("Away");
	}

	@Override
	public boolean checkZones() {
		if (zoneOneCheckbox.isSelected() && zoneTwoCheckbox.isSelected() && zoneThreeCheckbox.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Password is 1234
	 */
	@Override
	public boolean enterPassword(int number) {
		password = password + Integer.toString(number);
		if (password.length() == 4) {
			if (password.equals("1234")) {
				password = "";
				return true;
			} else {
				return false;
			}
		} else if (password.length() > 4) {
			statusScreen.setText("password failed");
			password = "";
			return false;
		} else
			return false;
	}

	@Override
	public void showSecurityBreached() {
		statusScreen.setText("Security breached");
	}

	@Override
	public void showTimeAway(int time) {
		statusScreen.setText("" + time + " seconds for away");

	}

	@Override
	public void showTimeStay(int time) {
		statusScreen.setText("" + time + " seconds for stay");

	}

	@Override
	public void showStay() {
		statusScreen.setText("Stay");
	}

	@Override
	public void showEnterPwdDisarm() {
		statusScreen.setText("Enter Passwors to Cancel");
	}

	@Override
	public void readyOfButton() {
		awayButton.setDisable(false);
		stayButton.setDisable(false);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(false);
		zoneTwoCheckbox.setDisable(false);
		zoneThreeCheckbox.setDisable(false);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(true);
		buttonTwo.setDisable(true);
		buttonThree.setDisable(true);
		buttonFour.setDisable(true);
		buttonFive.setDisable(true);
		buttonSix.setDisable(true);
		buttonSeven.setDisable(true);
		buttonEight.setDisable(true);
		buttonNine.setDisable(true);
		buttonZero.setDisable(true);

	}

	@Override
	public void armingAwayOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(false);
		zoneTwoCheckbox.setDisable(false);
		zoneThreeCheckbox.setDisable(false);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(true);
		buttonTwo.setDisable(true);
		buttonThree.setDisable(true);
		buttonFour.setDisable(true);
		buttonFive.setDisable(true);
		buttonSix.setDisable(true);
		buttonSeven.setDisable(true);
		buttonEight.setDisable(true);
		buttonNine.setDisable(true);
		buttonZero.setDisable(true);

	}

	@Override
	public void armingStayOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(false);
		zoneTwoCheckbox.setDisable(false);
		zoneThreeCheckbox.setDisable(false);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(true);
		buttonTwo.setDisable(true);
		buttonThree.setDisable(true);
		buttonFour.setDisable(true);
		buttonFive.setDisable(true);
		buttonSix.setDisable(true);
		buttonSeven.setDisable(true);
		buttonEight.setDisable(true);
		buttonNine.setDisable(true);
		buttonZero.setDisable(true);

	}

	@Override
	public void armedStayOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(false);
		zoneOneCheckbox.setDisable(false);
		zoneTwoCheckbox.setDisable(false);
		zoneThreeCheckbox.setDisable(false);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(true);
		buttonTwo.setDisable(true);
		buttonThree.setDisable(true);
		buttonFour.setDisable(true);
		buttonFive.setDisable(true);
		buttonSix.setDisable(true);
		buttonSeven.setDisable(true);
		buttonEight.setDisable(true);
		buttonNine.setDisable(true);
		buttonZero.setDisable(true);
	}

	@Override
	public void armedAwayOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(false);
		zoneOneCheckbox.setDisable(false);
		zoneTwoCheckbox.setDisable(false);
		zoneThreeCheckbox.setDisable(false);
		motionDetectorButton.setDisable(false);

		buttonOne.setDisable(true);
		buttonTwo.setDisable(true);
		buttonThree.setDisable(true);
		buttonFour.setDisable(true);
		buttonFive.setDisable(true);
		buttonSix.setDisable(true);
		buttonSeven.setDisable(true);
		buttonEight.setDisable(true);
		buttonNine.setDisable(true);
		buttonZero.setDisable(true);

	}

	@Override
	public void disarmAwayOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(true);
		zoneTwoCheckbox.setDisable(true);
		zoneThreeCheckbox.setDisable(true);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(false);
		buttonTwo.setDisable(false);
		buttonThree.setDisable(false);
		buttonFour.setDisable(false);
		buttonFive.setDisable(false);
		buttonSix.setDisable(false);
		buttonSeven.setDisable(false);
		buttonEight.setDisable(false);
		buttonNine.setDisable(false);
		buttonZero.setDisable(false);

	}

	@Override
	public void disarmStayOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(true);
		zoneTwoCheckbox.setDisable(true);
		zoneThreeCheckbox.setDisable(true);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(false);
		buttonTwo.setDisable(false);
		buttonThree.setDisable(false);
		buttonFour.setDisable(false);
		buttonFive.setDisable(false);
		buttonSix.setDisable(false);
		buttonSeven.setDisable(false);
		buttonEight.setDisable(false);
		buttonNine.setDisable(false);
		buttonZero.setDisable(false);

	}

	@Override
	public void warningOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(true);
		zoneTwoCheckbox.setDisable(true);
		zoneThreeCheckbox.setDisable(true);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(false);
		buttonTwo.setDisable(false);
		buttonThree.setDisable(false);
		buttonFour.setDisable(false);
		buttonFive.setDisable(false);
		buttonSix.setDisable(false);
		buttonSeven.setDisable(false);
		buttonEight.setDisable(false);
		buttonNine.setDisable(false);
		buttonZero.setDisable(false);

	}

	@Override
	public void breachedOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(true);
		zoneTwoCheckbox.setDisable(true);
		zoneThreeCheckbox.setDisable(true);
		motionDetectorButton.setDisable(true);

		buttonOne.setDisable(false);
		buttonTwo.setDisable(false);
		buttonThree.setDisable(false);
		buttonFour.setDisable(false);
		buttonFive.setDisable(false);
		buttonSix.setDisable(false);
		buttonSeven.setDisable(false);
		buttonEight.setDisable(false);
		buttonNine.setDisable(false);
		buttonZero.setDisable(false);

	}

	@Override
	public void unarmedOfButton() {
		awayButton.setDisable(true);
		stayButton.setDisable(true);
		cancelButton.setDisable(true);
		zoneOneCheckbox.setDisable(false);
		zoneTwoCheckbox.setDisable(false);
		zoneThreeCheckbox.setDisable(false);
		motionDetectorButton.setDisable(true);
		buttonOne.setDisable(true);
		buttonTwo.setDisable(true);
		buttonThree.setDisable(true);
		buttonFour.setDisable(true);
		buttonFive.setDisable(true);
		buttonSix.setDisable(true);
		buttonSeven.setDisable(true);
		buttonEight.setDisable(true);
		buttonNine.setDisable(true);
		buttonZero.setDisable(true);

	}
}
