package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonTwo extends GUIButton implements EventHandler<ActionEvent> {
	/**
	 * The button for the digit 2
	 * 
	 * @param string
	 */
	public ButtonTwo(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {

	}
}