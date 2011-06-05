package server.presentation.prototype.panel;

import server.layout.StruktiLayout;
import server.layout.StruktiLayout.MenuChangedEvent;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;

@SuppressWarnings("serial")
public class TopCenter extends Panel implements StruktiLayout.MenuChangedListener {
	
	private StruktiLayout struktiLayout;
	
	private Label titleLabel;
	
	public TopCenter(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
        addStyleName("topCenter");

        observeMenu();

        setTitle("Welcome to Proof of Concept");
        
		struktiLayout.setTopCenter(this);
	}
	
	private void observeMenu() {
		struktiLayout.addMenuChangedListener(this);
	}
	
	public void setTitle(String titleString) {
		removeAllComponents();
		
		titleLabel = new Label("<b>" + titleString + "</b>");
		titleLabel.setContentMode(Label.CONTENT_XHTML);
		titleLabel.addStyleName("topCenter");
        addComponent(titleLabel);
        VerticalLayout layout = (VerticalLayout)getContent();
        layout.setSizeFull();
        layout.setComponentAlignment(titleLabel, Alignment.BOTTOM_LEFT);
	}
	
	private void onMenuIntroduction() {
		setTitle("Einführung");
	}
	
	private void onMenuProducts() {
		setTitle("Produktauswahl");
	}
	
	private void onMenuDescription() {
		setTitle("Produktauswahl.Produktbeschreibung");
	}
	
	private void onMenuDesign() {
		setTitle("Produktauswahl.Produktdesign");
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
