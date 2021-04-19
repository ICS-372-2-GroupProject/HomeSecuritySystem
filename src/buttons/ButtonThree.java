package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonThree extends GUIButton
		implements
			EventHandler<ActionEvent> {
	/**
	 * The button for the digit 3
	 * 
	 * @param string
	 */
	public ButtonThree(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(3)) {
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
		}
	}
}