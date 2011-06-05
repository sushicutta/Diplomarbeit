package server.presentation.prototype.panel.product;

import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class ButtonMatrix extends Panel {
	
	public ButtonMatrix() {
		init();
	}
	
	private void init() {
		addStyleName(Reindeer.PANEL_LIGHT);
	}

}
