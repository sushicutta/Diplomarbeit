package ch.sushicutta.server.layout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class StruktiLayout extends Panel {
	
	public Window window;
	
	final GridLayout grid = new GridLayout(3, 2);
	
	Panel topLeft;
	Panel topCenter;
	Panel topRight;
	Panel bottomLeft;
	Panel bottomCenter;
	Panel bottomRight;
	
	private Product selectedProduct = null;
	
	private List<ProductMarketFilter> productMarketFilters = new ArrayList<ProductMarketFilter>();
	
	private List<ProductProtectionFilter> productProtectionFilters = new ArrayList<ProductProtectionFilter>();

	public StruktiLayout(Window window) {
		
		this.window = window;
    	
    	init();
    	initTopLeft();
    	initTopCenter();
    	initTopRight();
    	initBottomLeft();
    	initBottomCenter();
    	initBottomRight();
    	
    	initTest();

    }
    
    private void init() {
    	
        getContent().setSizeFull();
    	
    	setWidth(1062, Sizeable.UNITS_PIXELS);
    	setHeight("100%");
    	
    	setScrollable(true);
    	
        // Create a grid layout
        grid.setSpacing(true);
        
        // Force Row 2 to Expand
        grid.setRowExpandRatio(1, 1);

        // The style allows us to visualize the cell borders in this example.
        grid.addStyleName("struktigrid");

        grid.setWidth(1024, Sizeable.UNITS_PIXELS);
        grid.setHeight(768, Sizeable.UNITS_PIXELS);

        // Add the layout to the containing layout.
        addComponent(grid);


    }
    
    private void initTopLeft() {
        topLeft = new Panel("Top Left");
        topLeft.setCaption(null);
        topLeft.setHeight(150, Sizeable.UNITS_PIXELS);
        topLeft.setWidth(220, Sizeable.UNITS_PIXELS);
        grid.addComponent(topLeft, 0, 0);
        grid.setComponentAlignment(topLeft, Alignment.MIDDLE_CENTER);
    }
    
    private void initTopCenter() {
        topCenter = new Panel("Top Center");
        topCenter.setCaption(null);
        topCenter.setHeight(150, Sizeable.UNITS_PIXELS);
        topCenter.setWidth(552, Sizeable.UNITS_PIXELS);
        topCenter.addStyleName("topCenter");
        grid.addComponent(topCenter, 1, 0);
        grid.setComponentAlignment(topCenter, Alignment.BOTTOM_LEFT);
    }
    
    private void initTopRight() {
        topRight = new Panel("Top Right");
        topRight.setCaption(null);
        topRight.setHeight(150, Sizeable.UNITS_PIXELS);
        topRight.setWidth(220, Sizeable.UNITS_PIXELS);
        topRight.addStyleName("topRight");
        grid.addComponent(topRight, 2, 0);
        grid.setComponentAlignment(topRight, Alignment.MIDDLE_CENTER);
    }
    
    private void initBottomLeft() {
        bottomLeft = new Panel("Bottom Left");
        bottomLeft.setCaption(null);
        bottomLeft.setHeight("100%");
        bottomLeft.setWidth(220, Sizeable.UNITS_PIXELS);
        grid.addComponent(bottomLeft, 0, 1);
        grid.setComponentAlignment(bottomLeft, Alignment.MIDDLE_CENTER);
    }
    
    private void initBottomCenter() {
        bottomCenter = new Panel("Bottom Center");
        bottomCenter.setCaption(null);
        bottomCenter.setHeight("100%");
        bottomCenter.setWidth(552, Sizeable.UNITS_PIXELS);
        grid.addComponent(bottomCenter, 1, 1);
        grid.setComponentAlignment(bottomCenter, Alignment.MIDDLE_CENTER);
    }
    
    private void initBottomRight() {
        bottomRight = new Panel("Bottom Right");
        bottomRight.setCaption(null);
        bottomRight.setHeight("100%");
        bottomRight.setWidth(220, Sizeable.UNITS_PIXELS);
        grid.addComponent(bottomRight, 2, 1);
        grid.setComponentAlignment(bottomRight, Alignment.MIDDLE_CENTER);
    }
    
    private void initTest() {
        Label labelTopLeft = new Label("Panel Top Left");
        topLeft.addComponent(labelTopLeft);

        Label labelTopCenter = new Label("Panel Top Center");
        topCenter.addComponent(labelTopCenter);

        Label labelTopRight = new Label("Panel Top Right");
        topRight.addComponent(labelTopRight);

        Label labelBottomLeft = new Label("Panel Bottom Left");
        bottomLeft.addComponent(labelBottomLeft);
        
        Label labelBottomCenter = new Label("Panel Bottom Center");
        bottomCenter.addComponent(labelBottomCenter);
        
        Label labelBottomRight = new Label("Panel Bottom Right");
        bottomRight.addComponent(labelBottomRight);
    }
    
    public void setTopLeft(Component component) {
    	topLeft.removeAllComponents();
    	
    	GridLayout topLeftGrid = new GridLayout(1, 1);
    	topLeftGrid.setSizeFull();
    	topLeftGrid.setSpacing(true);
    	topLeftGrid.setMargin(true);
    	topLeftGrid.addComponent(component, 0, 0);
    	topLeftGrid.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
    	
    	topLeft.setContent(topLeftGrid);

    }
    
    public void setTopCenter(Panel panelTopCenter) {
    	
    	panelTopCenter.setCaption(null);
    	panelTopCenter.setHeight(150, Sizeable.UNITS_PIXELS);
    	panelTopCenter.setWidth(552, Sizeable.UNITS_PIXELS);
    	panelTopCenter.addStyleName("topCenter");
    	
    	topCenter = panelTopCenter;
    	
    	grid.removeComponent(1, 0);
        grid.addComponent(topCenter, 1, 0);
        grid.setComponentAlignment(topCenter, Alignment.BOTTOM_LEFT);
    
    }
    
    public void setTopRight(Component component) {
    	topRight.removeAllComponents();
    	topRight.addComponent(component);
    }
    
    public void setBottomLeft(Panel panelBottomLeft) {
    	
    	panelBottomLeft.setCaption(null);
    	panelBottomLeft.setHeight("100%");
    	panelBottomLeft.setWidth(220, Sizeable.UNITS_PIXELS);
    	
    	bottomLeft = panelBottomLeft;
    	
    	grid.removeComponent(0, 1);
        grid.addComponent(bottomLeft, 0, 1);
        grid.setComponentAlignment(bottomLeft, Alignment.MIDDLE_CENTER);
    }
    
    public void setBottomCenter(Panel panelBottomCenter) {
    	
    	panelBottomCenter.setCaption(null);
    	panelBottomCenter.setHeight("100%");
    	panelBottomCenter.setWidth(552, Sizeable.UNITS_PIXELS);
    	
    	bottomCenter = panelBottomCenter;
    	
    	grid.removeComponent(1, 1);
        grid.addComponent(bottomCenter, 1, 1);
        grid.setComponentAlignment(bottomCenter, Alignment.MIDDLE_CENTER);
    }
    
    public void setBottomRight(Panel panelBottomRight) {
    	
    	panelBottomRight.setCaption(null);
    	panelBottomRight.setHeight("100%");
    	panelBottomRight.setWidth(220, Sizeable.UNITS_PIXELS);
    	
    	bottomRight = panelBottomRight;
    	
    	grid.removeComponent(2, 1);
        grid.addComponent(bottomRight, 2, 1);
        grid.setComponentAlignment(bottomRight, Alignment.MIDDLE_CENTER);
        
    }
    
    public enum MenuItem {
    	NONE,
    	INTRODUCTION,
    	PRODUCTS,
    	SUB_DESCRIPTION,
    	SUB_DESIGN
    }
	
    public enum Product {
    	PUT_OPTION,
    	SOFT_RUNNER,
    	PROTEIN
    }
    
    public enum ProductMarketFilter {
    	RISING,
    	SIDEWAYS,
    	DECREASING
    }
    
    public enum ProductProtectionFilter {
    	PROTECTION,
    	LIMITED_PROTECTION,
    	NO_PROTECTION
    }
    
    public enum SliderEnum {
    	STRIKE,
    	VOLA
    }
    
	public class MenuChangedEvent extends Event {
		
		final MenuItem menuItem;

        public MenuChangedEvent(Component source, MenuItem menuItem) {
            super(source);
            this.menuItem = menuItem;
        }
        
        public MenuItem getMenuItem() {
        	return menuItem;
        }
	}
	
	public interface MenuChangedListener extends Serializable {
		
		public void onMenuChanged(MenuChangedEvent event);
		
	}
	
	List<MenuChangedListener> menuChangedListeners = new ArrayList<MenuChangedListener>();
	
    public void addMenuChangedListener(MenuChangedListener listener) {
    	menuChangedListeners.add(listener);
    }

    public void removeMenuChangedListener(MenuChangedListener listener) {
    	menuChangedListeners.remove(listener);
    }
    
    public void fireMenuChanged(Component source, MenuItem menuItem) {
    	for (MenuChangedListener menuChangedListener : menuChangedListeners) {
    		menuChangedListener.onMenuChanged(new MenuChangedEvent(source, menuItem));
    	}
    }
    
    public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	public void addProductMarketFilter(Component source, ProductMarketFilter productMarketFilter) {
		if (!productMarketFilters.contains(productMarketFilter)) {
			productMarketFilters.add(productMarketFilter);
		} else {
			productMarketFilters.remove(productMarketFilter);
		}
		fireFilterChanged(source);
	}
	
	public void addProductProtectionFilter(Component source, ProductProtectionFilter productProtectionFilter) {
		if (!productProtectionFilters.contains(productProtectionFilter)) {
			productProtectionFilters.add(productProtectionFilter);
		} else {
			productProtectionFilters.remove(productProtectionFilter);
		}
		fireFilterChanged(source);
	}
	
	public class FilterChangedEvent extends Event {

		final private List<ProductMarketFilter> changedProductMarketFilters;

		final private List<ProductProtectionFilter> changedProductProtectionFilters;
		
		public FilterChangedEvent(Component source) {
			super(source);
			changedProductMarketFilters = new ArrayList<ProductMarketFilter>(productMarketFilters);
			changedProductProtectionFilters = new ArrayList<ProductProtectionFilter>(productProtectionFilters);
		}

		public List<ProductMarketFilter> getChangedProductMarketFilters() {
			return changedProductMarketFilters;
		}

		public List<ProductProtectionFilter> getChangedProductProtectionFilters() {
			return changedProductProtectionFilters;
		}
		
	}
	
	
	public interface FilterChangedListener extends Serializable {
		public void onFilterChanged(FilterChangedEvent event);
	}
	
	List<FilterChangedListener> filterChangedListeners = new ArrayList<FilterChangedListener>();
	
    public void addFilterChangedListener(FilterChangedListener listener) {
    	filterChangedListeners.add(listener);
    }

    public void removeFilterChangedListener(FilterChangedListener listener) {
    	filterChangedListeners.remove(listener);
    }
    
    public void fireFilterChanged(Component source) {
    	for (FilterChangedListener filterChangedListener : filterChangedListeners) {
    		filterChangedListener.onFilterChanged(new FilterChangedEvent(source));
    	}
    }
    
    public void addProductFilterChangedListener(FilterChangedListener listener) {
    	filterChangedListeners.add(listener);
    }
    
	public class SliderValueChangedEvent extends Event {

		final private SliderEnum slider;

		final private double value;
		
		public SliderValueChangedEvent(Component source, SliderEnum slider, double value) {
			super(source);
			this.slider = slider;
			this.value = value;
		}

		public SliderEnum getSlider() {
			return slider;
		}

		public double getValue() {
			return value;
		}
		
	}
    
	
	public interface SliderValueChangedListener extends Serializable {
		public void onSliderValueChanged(SliderValueChangedEvent event);
	}
    
	List<SliderValueChangedListener> sliderValueChangedListeners = new ArrayList<SliderValueChangedListener>();
	
    public void addSliderValueChangedListener(SliderValueChangedListener listener) {
    	sliderValueChangedListeners.add(listener);
    }

    public void removeSliderValueChangedListener(SliderValueChangedListener listener) {
    	sliderValueChangedListeners.remove(listener);
    }
    
    public void fireSliderValueChanged(Component source, SliderEnum slider, double value) {
    	for (SliderValueChangedListener sliderValueChangedListener : sliderValueChangedListeners) {
    		sliderValueChangedListener.onSliderValueChanged(new SliderValueChangedEvent(source, slider, value));
    	}
    }

	
	
}