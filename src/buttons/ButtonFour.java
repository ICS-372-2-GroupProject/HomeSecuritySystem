package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonFour extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 4
	 * 
	 * @param string
	 */
	public ButtonFour(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(4)) {
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
		}
	}
}