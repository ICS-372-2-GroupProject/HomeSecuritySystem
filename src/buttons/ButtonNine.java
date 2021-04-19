package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonNine extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 9
	 * 
	 * @param string
	 */
	public ButtonNine(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(9))
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
	}
}