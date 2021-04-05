package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

	}
}