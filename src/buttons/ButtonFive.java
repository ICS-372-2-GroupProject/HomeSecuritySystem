package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonFive extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 5
	 * 
	 * @param string
	 */
	public ButtonFive(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(5))
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
	}
}