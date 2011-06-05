package server.presentation.prototype.panel.product;

import server.layout.StruktiLayout;
import server.layout.StruktiLayout.MenuChangedEvent;

import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;

@SuppressWarnings("serial")
public class BottomRight extends Panel implements StruktiLayout.MenuChangedListener {
	
	private StruktiLayout struktiLayout;
	
	public BottomRight(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		VerticalLayout layout = (VerticalLayout)getContent();
		layout.setSpacing(true);
		layout.setMargin(true);

        observeMenu();
	}
	
	private void observeMenu() {
		struktiLayout.addMenuChangedListener(this);
	}
	
	private void createLayout() {
		struktiLayout.setBottomLeft(this);
	}
	
	@Override
	public void onMenuChanged(MenuChangedEvent event) {
		if (event.getMenuItem().equals(StruktiLayout.MenuItem.INTRODUCTION)) {
			
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.PRODUCTS)) {
			onProducts();
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.SUB_DESCRIPTION)) {
			onDescription();
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.SUB_DESIGN)) {
			onDesign();
		} else {
			getWindow().showNotification(
					"MenuChangedListener",
                    "Ein unbekanntes Menu wurde geladen.",
                    Notification.TYPE_ERROR_MESSAGE);
		}
		createLayout();
	}

	private void onDesign() {
		
	}

	private void onDescription() {
		
	}

	private void onProducts() {
		
	}
}
