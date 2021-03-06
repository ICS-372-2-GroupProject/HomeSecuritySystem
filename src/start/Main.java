package start;

import display.GUIDisplay;
import display.AlarmDisplay;
import javafx.application.Application;
import states.AlarmContext;
import timer.Clock;

public class Main {
	public static void main(String[] args) {
		Clock.instance();
		new Thread() {

			@Override
			public void run() {
				Application.launch(GUIDisplay.class, args);
			}
		}.start();
		try {
			while (GUIDisplay.getInstance() == null) {
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
		}

		AlarmDisplay display = GUIDisplay.getInstance();
		AlarmContext.instance().setDisplay(display);
	}
}