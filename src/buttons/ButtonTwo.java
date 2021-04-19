package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonTwo extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 2
	 * 
	 * @param string
	 */
	public ButtonTwo(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(2)) {
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
		}
	}
}