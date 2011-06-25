package ch.sushicutta.server.presentation.prototype.panel;

import ch.sushicutta.server.layout.StruktiLayout;
import ch.sushicutta.server.layout.StruktiLayout.MenuChangedEvent;
import ch.sushicutta.server.layout.StruktiLayout.MenuItem;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class BottomLeft extends Panel implements Button.ClickListener, StruktiLayout.MenuChangedListener {
	
	private StruktiLayout struktiLayout;
	
	private Button buttonIntroduction;
	private Button buttonProducts;
	private Button buttonDescription;
	private Button buttonDesign;
	
	private MenuItem menuItem = MenuItem.NONE;
	
	public BottomLeft(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		VerticalLayout layout = (VerticalLayout)getContent();
		layout.setSpacing(true);
		layout.setMargin(true);
		
		createLayout();

        observeMenu();
	}
	
	private void observeMenu() {
		struktiLayout.addMenuChangedListener(this);
	}
	
	private void doMenu() {
		removeAllComponents();
		
		buttonIntroduction = new Button("Einführung", this);
		if (menuItem.equals(StruktiLayout.MenuItem.INTRODUCTION)) {
			buttonIntroduction.addStyleName("menuButtonClicked");
		}
		
		addComponent(buttonIntroduction);
		
		addComponent(new Label("<hr />",Label.CONTENT_XHTML));
		
		buttonProducts = new Button("Produktauswahl", this);
		if (menuItem.equals(StruktiLayout.MenuItem.PRODUCTS)) {
			buttonProducts.addStyleName("menuButtonClicked");
		}
		addComponent(buttonProducts);
		
		if (menuItem.equals(StruktiLayout.MenuItem.PRODUCTS) ||
					menuItem.equals(StruktiLayout.MenuItem.SUB_DESCRIPTION) ||
					menuItem.equals(StruktiLayout.MenuItem.SUB_DESIGN)) {
			doSubMenu();
		}
		
		addComponent(new Label("<hr />",Label.CONTENT_XHTML));
		
		Button extras = new Button("Notification", this);
		addComponent(extras);
		
	}
	
	private void doSubMenu() {
		
		Panel subMenuPanel = new Panel("");
		subMenuPanel.addStyleName(Reindeer.PANEL_LIGHT);
		VerticalLayout verticalLayout = (VerticalLayout) subMenuPanel.getContent();
		verticalLayout.setSpacing(true);
		verticalLayout.setMargin(false, false, false, true);
		
		buttonDescription = new Button("Produktbeschreibung", this);
		if (menuItem.equals(StruktiLayout.MenuItem.SUB_DESCRIPTION)) {
			buttonDescription.addStyleName("menuButtonClicked");
		}
		
		subMenuPanel.addComponent(buttonDescription);

		buttonDesign = new Button("Produktdesign", this);
		if (menuItem.equals(StruktiLayout.MenuItem.SUB_DESIGN)) {
			buttonDesign.addStyleName("menuButtonClicked");
		}
		subMenuPanel.addComponent(buttonDesign);
		
		if (menuItem.equals(StruktiLayout.MenuItem.PRODUCTS)) {
			buttonDescription.setEnabled(false);
			buttonDesign.setEnabled(false);
		}
		
		if (menuItem.equals(StruktiLayout.MenuItem.SUB_DESCRIPTION) ||
					menuItem.equals(StruktiLayout.MenuItem.SUB_DESIGN)) {
			buttonDescription.setEnabled(true);
			buttonDesign.setEnabled(true);
		}
		
		addComponent(subMenuPanel);
		
	}
	
	private void createLayout() {
		doMenu();
		struktiLayout.setBottomLeft(this);
	}
	
	@Override
	public void onMenuChanged(MenuChangedEvent event) {
		if (event.getMenuItem().equals(StruktiLayout.MenuItem.INTRODUCTION)) {
			menuItem = StruktiLayout.MenuItem.INTRODUCTION;
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.PRODUCTS)) {
			menuItem = StruktiLayout.MenuItem.PRODUCTS;
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.SUB_DESCRIPTION)) {
			menuItem = StruktiLayout.MenuItem.SUB_DESCRIPTION;
		} else if (event.getMenuItem().equals(StruktiLayout.MenuItem.SUB_DESIGN)) {
			menuItem = StruktiLayout.MenuItem.SUB_DESIGN;
		} else {
			getWindow().showNotification(
					"MenuChangedListener",
                    "Ein unbekanntes Menu wurde geladen.",
                    Notification.TYPE_ERROR_MESSAGE);
		}
		createLayout();
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getButton().equals(buttonIntroduction)) {
			struktiLayout.fireMenuChanged(this, StruktiLayout.MenuItem.INTRODUCTION);
		} else if (event.getButton().equals(buttonProducts)) {
			struktiLayout.fireMenuChanged(this, StruktiLayout.MenuItem.PRODUCTS);
		} else if (event.getButton().equals(buttonDescription)) {
			struktiLayout.fireMenuChanged(this, StruktiLayout.MenuItem.SUB_DESCRIPTION);
		} else if (event.getButton().equals(buttonDesign)) {
			struktiLayout.fireMenuChanged(this, StruktiLayout.MenuItem.SUB_DESIGN);
		} else {
			getWindow().showNotification(
					"ClickListener",
                    "Ein unbekannter Knopf wurde gedrückt.",
                    Notification.TYPE_ERROR_MESSAGE);
		}
	}
}
