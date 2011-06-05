package server.presentation.prototype.panel;

import server.layout.StruktiLayout;
import server.layout.StruktiLayout.MenuChangedEvent;
import server.presentation.prototype.panel.introduction.Introduction;
import server.presentation.prototype.panel.product.ButtonMatrix;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;

@SuppressWarnings("serial")
public class BottomCenter extends Panel implements StruktiLayout.MenuChangedListener {
	
	private StruktiLayout struktiLayout;
	
	public BottomCenter(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		VerticalLayout layout = (VerticalLayout)getContent();
		layout.setSpacing(true);
		layout.setMargin(true);

		layout.setSizeFull();
		
		struktiLayout.setBottomCenter(this);
		
		observeMenu();
	}
	
	private void observeMenu() {
		struktiLayout.addMenuChangedListener(this);
	}
	
	private void onMenuIntroduction() {
		removeAllComponents();
        Label introductionText = new Introduction();
        addComponent(introductionText);
	}
	
	private void onMenuProducts() {
		removeAllComponents();
		Panel buttonMatrix = new ButtonMatrix(struktiLayout);
		buttonMatrix.setSizeFull();
		addComponent(buttonMatrix);
	}

	private void onMenuDesign() {
		
	}
	
	private void onMenuDescription() {
		
	}
	
	@Override
	public void onMenuChanged(MenuChangedEvent event) {
		if (event.getMenuItem().equals(StruktiLayout.MenuItem.INTRODUCTION)) {
			onMenuIntroduction();
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.PRODUCTS)) {
			onMenuProducts();
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.SUB_DESCRIPTION)) {
			onMenuDescription();
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.SUB_DESIGN)) {
			onMenuDesign();
		} else {
			getWindow().showNotification(
					"MenuChangedListener",
                    "Ein unbekanntes Menu wurde geladen.",
                    Notification.TYPE_ERROR_MESSAGE);
		}
		
	}


}
