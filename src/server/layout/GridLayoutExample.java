package server.layout;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class GridLayoutExample extends VerticalLayout {

    public GridLayoutExample() {
        // Create a grid layout
        final GridLayout grid = new GridLayout(3, 2);
        grid.setSpacing(true);

        // The style allows us to visualize the cell borders in this example.
        grid.addStyleName("gridexample");

        grid.setWidth("100%");
        grid.setHeight(1000, Sizeable.UNITS_PIXELS);
        
        grid.setColumnExpandRatio(1, 5);
        
        grid.setRowExpandRatio(1, 5);

        Panel topleft = new Panel("");
        topleft.setHeight(150, Sizeable.UNITS_PIXELS);
        topleft.setWidth(250, Sizeable.UNITS_PIXELS);
        grid.addComponent(topleft, 0, 0);
        grid.setComponentAlignment(topleft, Alignment.MIDDLE_CENTER);

        Panel topcenter = new Panel("");
        topcenter.setHeight(150, Sizeable.UNITS_PIXELS);
        topcenter.setWidth("100%");
        grid.addComponent(topcenter, 1, 0);
        grid.setComponentAlignment(topcenter, Alignment.MIDDLE_CENTER);
        
        Panel topright = new Panel("");
        topright.setHeight(150, Sizeable.UNITS_PIXELS);
        topright.setWidth(400, Sizeable.UNITS_PIXELS);
        grid.addComponent(topright, 2, 0);
        grid.setComponentAlignment(topright, Alignment.MIDDLE_CENTER);
        
        Panel bottomleft = new Panel("");
        bottomleft.setHeight("100%");
        bottomleft.setWidth(250, Sizeable.UNITS_PIXELS);
        grid.addComponent(bottomleft, 0, 1);
        grid.setComponentAlignment(bottomleft, Alignment.MIDDLE_CENTER);
        
        Panel bottomcenter = new Panel("");
        bottomcenter.setHeight("100%");
        bottomcenter.setWidth(300, Sizeable.UNITS_PIXELS);
        grid.addComponent(bottomcenter, 1, 1);
        grid.setComponentAlignment(bottomcenter, Alignment.MIDDLE_CENTER);
        
        Panel bottomright = new Panel("");
        bottomright.setHeight("100%");
        bottomright.setWidth(400, Sizeable.UNITS_PIXELS);
        grid.addComponent(bottomright, 2, 1);
        grid.setComponentAlignment(bottomright, Alignment.MIDDLE_CENTER);

        // Add the layout to the containing layout.
        addComponent(grid);

        // Align the grid itself within its container layout.
        setComponentAlignment(grid, Alignment.MIDDLE_CENTER);
    }
}