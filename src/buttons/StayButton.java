package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

	}
}