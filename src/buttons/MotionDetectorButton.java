package buttons;

import events.MovementEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class MotionDetectorButton extends GUIButton
		implements
			EventHandler<ActionEvent> {
	/**
	 * The button for motion detection
	 * 
	 * @param string
	 */
	public MotionDetectorButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		AlarmContext.instance().handleEvent(MovementEvent.instance());

	}
}