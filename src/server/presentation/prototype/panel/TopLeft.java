package server.presentation.prototype.panel;

import server.layout.StruktiLayout;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Link;

public class TopLeft {
	
	private StruktiLayout struktiLayout;
	
	private static final ThemeResource ICON = new ThemeResource("../poc/img/logo.png");
	
    private static final String TOOLTIP = 		"Open Proof Of Concept";
    private static final String DESTINATION = 	"http://localhost:8080/Diplomarbeit?" +
    											"debug" +
    											"&restartApplication";
	
	public TopLeft(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		Link iconLink = new Link();
		iconLink.setResource(new ExternalResource(DESTINATION));
		iconLink.setDescription(TOOLTIP);
		iconLink.setIcon(ICON);
		struktiLayout.setTopLeft(iconLink);
	}

}
