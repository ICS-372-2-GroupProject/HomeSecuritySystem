package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonSeven extends GUIButton
		implements
			EventHandler<ActionEvent> {
	/**
	 * The button for the digit 7
	 * 
	 * @param string
	 */
	public ButtonSeven(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(7))
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
	}
}