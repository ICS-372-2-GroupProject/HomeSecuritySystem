package checkboxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

/**
 * The abstract GUI CheckBox object.
 *
 */
public abstract class GUICheckbox extends CheckBox
        implements EventHandler<ActionEvent> {
    /**
     * Create the checkbox with the proper text. Makes the checkbox a listener
     * to clicks on itself.
     * 
     * @param string the text
     */

    public GUICheckbox(String string) {
        super(string);
        setOnAction(this);
    }

}