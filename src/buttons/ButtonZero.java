package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonZero extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 0
	 * 
	 * @param string
	 */
	public ButtonZero(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(0)) {
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
		}
	}
}