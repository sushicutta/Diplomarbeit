package server.presentation.prototype.panel.product;

import server.layout.StruktiLayout;
import server.layout.StruktiLayout.MenuChangedEvent;

import com.vaadin.ui.Label;
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

		layout.setSizeFull();
		
		createLayout();
		
        observeMenu();
	}
	
	private void observeMenu() {
		struktiLayout.addMenuChangedListener(this);
	}
	
	private void createLayout() {
		struktiLayout.setBottomRight(this);
	}
	
	@Override
	public void onMenuChanged(MenuChangedEvent event) {
		if (event.getMenuItem().equals(StruktiLayout.MenuItem.INTRODUCTION)) {
			onIntroduction();
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
	}

	private void onIntroduction() {
		removeAllComponents();
        Label bla = new Label("Panel Bottom Right");
        addComponent(bla);
	}

	private void onProducts() {
		removeAllComponents();
		Filter filter = new Filter(struktiLayout);
		filter.setSizeFull();
		addComponent(filter);
	}

	private void onDescription() {
		removeAllComponents();
        Label bla = new Label("Panel Bottom Right");
        addComponent(bla);
	}

	private void onDesign() {
		removeAllComponents();
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			Properties properties = new Properties(struktiLayout);
			properties.setSizeFull();
	        addComponent(properties);
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			addComponent(new Label("Panel Bottom Right"));
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			addComponent(new Label("Panel Bottom Right"));
		}
	}
}
