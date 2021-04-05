package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

	}
}