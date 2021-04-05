package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonZero extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 0
	 * 
	 * @param string
	 */
	public ButtonZero(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {

	}
}