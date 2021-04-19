package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonEight extends GUIButton
		implements
			EventHandler<ActionEvent> {
	/**
	 * The button for the digit 8
	 * 
	 * @param string
	 */
	public ButtonEight(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(8))
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
	}
}