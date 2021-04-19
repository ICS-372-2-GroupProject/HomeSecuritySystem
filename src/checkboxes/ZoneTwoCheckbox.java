package checkboxes;

import events.ZonesReadyEvent;
import events.ZonesUnreadyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ZoneTwoCheckbox extends GUICheckbox implements EventHandler<ActionEvent> {
	/**
	 * The checkbox for zone 2
	 * 
	 * @param string
	 */
	public ZoneTwoCheckbox(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		if (AlarmContext.instance().getZoneReadiness()) {
			AlarmContext.instance().handleEvent(ZonesReadyEvent.instance());
		} else {
			AlarmContext.instance().handleEvent(ZonesUnreadyEvent.instance());
		}
	}
}