package server.presentation.prototype;

import server.layout.StruktiLayout;
import server.presentation.prototype.panel.BottomCenter;
import server.presentation.prototype.panel.BottomLeft;
import server.presentation.prototype.panel.BottomRight;
import server.presentation.prototype.panel.TopCenter;
import server.presentation.prototype.panel.TopLeft;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class Prototype extends com.vaadin.Application {
	
	private StruktiLayout struktiLayout;

	@Override
    public void init() {
    	
    	setTheme("poc");

        // Main window is the primary browser window
        final Window main = new Window("Proof of Concept");
        
        struktiLayout = new StruktiLayout(main);
        
        setMainWindow(main);
        main.addComponent(struktiLayout);
        
        main.setSizeUndefined();
        
        main.getContent().setHeight(842, Sizeable.UNITS_PIXELS);
        
        struktiLayout.setScrollable(true);
        
        new TopLeft(struktiLayout);
        
        new TopCenter(struktiLayout);
        
        new BottomLeft(struktiLayout);
        
        new BottomCenter(struktiLayout);
        
        new BottomRight(struktiLayout);
        
    }

}
