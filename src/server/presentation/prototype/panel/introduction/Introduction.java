package server.presentation.prototype.panel.introduction;

import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class Introduction extends Label {
	
	private static final String XHMTL_CONTENT = "<h1>Willkommen beim Proof of Concept</h1>" +
			"<p>Das ist ein Proof of Concept der Diplomarbeit von Roman Würsch</p>" +
			"<p>Der Proof of Concept ist in <a href=\"http://www.vaadin.com\">Vaadin</a> " +
			"implementiert. Als Applikationsserver dient ein GlassFish. " +
			"Das Layout und alle Funktionalitäten sollten auf allen verschiednen Browsern" +
			"jeweils gleich aussehen und reagieren.</p>" +
			"<p>Für mehr Informationen senden Sie bitte eine Email an " +
			"<a href=\"mailto:sushicutta@gmail.com\">Roman Würsch</a></p>";
	
	public Introduction() {
		super(XHMTL_CONTENT);
		init();
	}
	
	private void init() {
		setContentMode(Label.CONTENT_XHTML);
	}

}
