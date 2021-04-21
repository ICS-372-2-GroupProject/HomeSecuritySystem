package buttons;

import events.StayButtonEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class StayButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for stay
	 * 
	 * @param string
	 */
	public StayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		AlarmContext.instance().handleEvent(StayButtonEvent.instance());
	}
}