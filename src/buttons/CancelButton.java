package buttons;

import events.CancelButtonEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class CancelButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for cancel
	 * 
	 * @param string
	 */
	public CancelButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		AlarmContext.instance().handleEvent(CancelButtonEvent.instance());
	}
}