package checkboxes;

import events.ZonesReadyEvent;
import events.ZonesUnreadyEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.AlarmContext;

public class ZoneThreeCheckbox extends GUICheckbox implements EventHandler<ActionEvent> {
	/**
	 * The checkbox for zone 3
	 * 
	 * @param string
	 */
	public ZoneThreeCheckbox(String string) {
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