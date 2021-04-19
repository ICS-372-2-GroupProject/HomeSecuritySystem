package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonSix extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 6
	 * 
	 * @param string
	 */
	public ButtonSix(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(6))
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
	}
}