package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class AwayButton extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for away
	 * 
	 * @param string
	 */
	public AwayButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		AlarmContext.instance().showAway();
		// AlarmContext.instance().handleEvent(AwayEvent.instance());

	}
}