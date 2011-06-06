package server.presentation.prototype.panel.product;

import java.util.ArrayList;
import java.util.List;

import server.layout.StruktiLayout;
import server.layout.StruktiLayout.FilterChangedEvent;
import server.layout.StruktiLayout.FilterChangedListener;
import server.layout.StruktiLayout.ProductMarketFilter;
import server.layout.StruktiLayout.ProductProtectionFilter;

import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class ButtonMatrix extends Panel implements FilterChangedListener {
	
	private final GridLayout grid = new GridLayout(3, 3);
	
	private StruktiLayout struktiLayout;
	
	private Panel topRight;
	private Panel center;
	private Panel bottomLeft;
	
	public ButtonMatrix(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		addStyleName(Reindeer.PANEL_LIGHT);
		createLayout();
		observe();
	}
	
	private void observe() {
		struktiLayout.addFilterChangedListener(this);
	}
	
	private void createLayout() {
		
		VerticalLayout layout = (VerticalLayout) getContent();
		layout.setMargin(false, false, false, false);
		layout.setSizeFull();
		
		grid.setSpacing(true);
        
        grid.setRowExpandRatio(0, 1);
        grid.setRowExpandRatio(1, 1);
        grid.setRowExpandRatio(2, 1);

        grid.setColumnExpandRatio(0, 1);
        grid.setColumnExpandRatio(1, 1);
        grid.setColumnExpandRatio(2, 1);
        
        grid.setSizeFull();
		
		addTopRight();
		addCenter();
		addBottomLeft();
		
		addComponent(grid);
	}
	
	private void addTopRight() {
		
		topRight = new Panel("");
		topRight.setHeight(150, Sizeable.UNITS_PIXELS);
		topRight.setWidth(150, Sizeable.UNITS_PIXELS);
		topRight.addStyleName("product");
		topRight.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) topRight.getContent();
		layout.setMargin(false, false, false, false);
		layout.setSizeFull();
		
		Label name = new Label("Put Option");
		name.addStyleName("product");
		name.setWidth(null);
		
		topRight.addComponent(name);
		layout.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
		
		topRight.addListener(new ClickListener() {

			public void click(ClickEvent event) {
				onPutOption();
			}
			
		});
		
        grid.addComponent(topRight, 2, 0);
        grid.setComponentAlignment(topRight, Alignment.MIDDLE_CENTER);
        
        FilterContainer filterContainer = new FilterContainer();
        filterContainer.addProductMarketFilter(ProductMarketFilter.RISING);
        filterContainer.addProductProtectionFilter(ProductProtectionFilter.NO_PROTECTION);
        
        topRight.setData(filterContainer);
        
	}
	
	private void addCenter() {
		
		center = new Panel("");
		center.setHeight(150, Sizeable.UNITS_PIXELS);
		center.setWidth(150, Sizeable.UNITS_PIXELS);
		center.addStyleName("product");
		
		VerticalLayout layout = (VerticalLayout) center.getContent();
		layout.setMargin(false, false, false, false);
		layout.setSizeFull();
		
		Label name = new Label("Soft Runner");
		name.addStyleName("product");
		name.setWidth(null);
		
		center.addComponent(name);
		layout.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
		
		center.addListener(new ClickListener() {

			public void click(ClickEvent event) {
				onSoftRunner();
			}
			
		});
		
        grid.addComponent(center, 1, 1);
        grid.setComponentAlignment(center, Alignment.MIDDLE_CENTER);
        
        FilterContainer filterContainer = new FilterContainer();
        filterContainer.addProductMarketFilter(ProductMarketFilter.RISING);
        filterContainer.addProductMarketFilter(ProductMarketFilter.SIDEWAYS);
        filterContainer.addProductProtectionFilter(ProductProtectionFilter.LIMITED_PROTECTION);
        
        center.setData(filterContainer);
		
	}
	
	private void addBottomLeft() {
		
		bottomLeft = new Panel("");
		bottomLeft.setHeight(150, Sizeable.UNITS_PIXELS);
		bottomLeft.setWidth(150, Sizeable.UNITS_PIXELS);
		bottomLeft.addStyleName("product");
		
		VerticalLayout layout = (VerticalLayout) bottomLeft.getContent();
		layout.setMargin(false, false, false, false);
		layout.setSizeFull();
		
		Label name = new Label("Protein");
		name.addStyleName("product");
		name.setWidth(null);
		
		bottomLeft.addComponent(name);
		layout.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
		
		bottomLeft.addListener(new ClickListener() {

			public void click(ClickEvent event) {
				onProtein();
			}
			
		});
		
        grid.addComponent(bottomLeft, 0, 2);
        grid.setComponentAlignment(bottomLeft, Alignment.MIDDLE_CENTER);
        
        FilterContainer filterContainer = new FilterContainer();
        filterContainer.addProductMarketFilter(ProductMarketFilter.RISING);
        filterContainer.addProductProtectionFilter(ProductProtectionFilter.PROTECTION);
        
        bottomLeft.setData(filterContainer);
		
	}
	
	private void onPutOption() {
		struktiLayout.setSelectedProduct(StruktiLayout.Product.PUT_OPTION);
		struktiLayout.fireMenuChanged(this, StruktiLayout.MenuItem.SUB_DESCRIPTION);
	}
	
	private void onSoftRunner() {
		struktiLayout.setSelectedProduct(StruktiLayout.Product.SOFT_RUNNER);
		struktiLayout.fireMenuChanged(this, StruktiLayout.MenuItem.SUB_DESCRIPTION);
	}
	
	private void onProtein() {
		struktiLayout.setSelectedProduct(StruktiLayout.Product.PROTEIN);
		struktiLayout.fireMenuChanged(this, StruktiLayout.MenuItem.SUB_DESCRIPTION);
	}
	
	private class FilterContainer {
		
		List<ProductMarketFilter> productMarketFilters = new ArrayList<ProductMarketFilter>();
		
		List<ProductProtectionFilter> productProtectionFilters = new ArrayList<ProductProtectionFilter>();
	
		private void addProductMarketFilter(ProductMarketFilter productMarketFilter) {
			if (!productMarketFilters.contains(productMarketFilter)) {
				productMarketFilters.add(productMarketFilter);
			}
		}
		
		private void addProductProtectionFilter(ProductProtectionFilter productProtectionFilter) {
			if (!productProtectionFilters.contains(productProtectionFilter)) {
				productProtectionFilters.add(productProtectionFilter);
			}
		}
		
	}

	@Override
	public void onFilterChanged(FilterChangedEvent event) {
		checkEnabled(topRight, event);
		checkEnabled(center, event);
		checkEnabled(bottomLeft, event);
	}
	
	private void checkEnabled(Panel panel, FilterChangedEvent event) {
		
		boolean enabled = true;
		
		FilterContainer filterContainer = (FilterContainer) panel.getData();
		
		if (event.getChangedProductMarketFilters().size() > 0) {
			
			for (ProductMarketFilter productMarketFilter : event.getChangedProductMarketFilters()) {
				if (!filterContainer.productMarketFilters.contains(productMarketFilter)) {
					enabled = false;
					break;
				}
			}
			
		}
		
		if (event.getChangedProductProtectionFilters().size() > 0) {
			
			for (ProductProtectionFilter productProtectionFilter : event.getChangedProductProtectionFilters()) {
				if (!filterContainer.productProtectionFilters.contains(productProtectionFilter)) {
					enabled = false;
					break;
				}
			}
			
		}
		
		if (enabled) {
			panel.removeStyleName("productDeactivated");
			panel.addStyleName("product");
			panel.setEnabled(true);
		} else {
			panel.removeStyleName("product");
			panel.addStyleName("productDeactivated");
			panel.setEnabled(false);
		}
		
	}
	
}
