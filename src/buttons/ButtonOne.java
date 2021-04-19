package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ButtonOne extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 1
	 * 
	 * @param string
	 */
	public ButtonOne(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().enterPassword(1)) {
			AlarmContext.instance().handleEvent(PasswordEvent.instance());
		}
	}
}