package server.presentation.prototype.panel.product;

import server.layout.StruktiLayout;
import server.layout.StruktiLayout.ProductMarketFilter;
import server.layout.StruktiLayout.ProductProtectionFilter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class Filter extends Panel implements ClickListener {
	
	private StruktiLayout struktiLayout;
	
	private CheckBox raise = new CheckBox("Steigt", this);
	private CheckBox sideway = new CheckBox("Seitwärts", this);
	private CheckBox decrease = new CheckBox("Sinkt", this);

	private CheckBox protection = new CheckBox("Kapitalschutz", this);
	private CheckBox limitedProtection = new CheckBox("bedingter Kapitalschutz", this);
	private CheckBox noProtection = new CheckBox("kein Kapitalschutz", this);
	
	public Filter(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		VerticalLayout layout = (VerticalLayout)getContent();
		layout.setSpacing(true);
		layout.setMargin(false);
		
		addStyleName(Reindeer.PANEL_LIGHT);
		
		createLayout();
	}

	private void createLayout() {
		Panel panelMarket = new Panel("Markterwartung");
		
		raise.setImmediate(true);
		panelMarket.addComponent(raise);
		sideway.setImmediate(true);
		panelMarket.addComponent(sideway);
		decrease.setImmediate(true);
		panelMarket.addComponent(decrease);
		
		Panel panelProtection = new Panel("Kapitalschutz");
		
		protection.setImmediate(true);
		panelProtection.addComponent(protection);
		limitedProtection.setImmediate(true);
		panelProtection.addComponent(limitedProtection);
		noProtection.setImmediate(true);
		panelProtection.addComponent(noProtection);
		
		addComponent(panelMarket);
		addComponent(panelProtection);
		
	}

	@Override
	public void buttonClick(ClickEvent event) {
		CheckBox checkBox = (CheckBox) event.getButton();
		
		if (checkBox.equals(raise)) {
			struktiLayout.addProductMarketFilter(checkBox, ProductMarketFilter.RISING);
		} else if (checkBox.equals(sideway)) {
			struktiLayout.addProductMarketFilter(checkBox, ProductMarketFilter.SIDEWAYS);
		} else if (checkBox.equals(decrease)) {
			struktiLayout.addProductMarketFilter(checkBox, ProductMarketFilter.DECREASING);
		} else if (checkBox.equals(protection)) {
			struktiLayout.addProductProtectionFilter(checkBox, ProductProtectionFilter.PROTECTION);
		} else if (checkBox.equals(limitedProtection)) {
			struktiLayout.addProductProtectionFilter(checkBox, ProductProtectionFilter.LIMITED_PROTECTION);
		} else if (checkBox.equals(noProtection)) {
			struktiLayout.addProductProtectionFilter(checkBox, ProductProtectionFilter.NO_PROTECTION);
		} else {
			getWindow().showNotification(
					"ButtonClickListener",
                    "Ein unbekannter Filter wurde gewählt.",
                    Notification.TYPE_ERROR_MESSAGE);
		}
	}
	
}
