package server.presentation.prototype.panel.product;

import server.layout.StruktiLayout;

import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class Description extends Panel {
	
	private TabSheet tabSheet = new TabSheet();
	
	private StruktiLayout struktiLayout;
	
	private Panel properties;
	private Panel chances;
	private Panel payback;
	private Panel example;
	private Panel taxes;
	private Panel classified;
	
	public Description(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		addStyleName(Reindeer.PANEL_LIGHT);
		createLayout();
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			struktiLayout.window.showNotification("Put Option ausgewählt");
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			struktiLayout.window.showNotification("Soft Runner ausgewählt");
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			struktiLayout.window.showNotification("Protein ausgewählt");
		}
		

	}
	
	private void createLayout() {
		
		VerticalLayout layout = (VerticalLayout) getContent();
		layout.setMargin(false, false, false, false);
		layout.setSpacing(true);
		layout.setSizeFull();
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			addComponent(createPanelPutWarrant());
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			addComponent(createPanelSoftRunner());
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			addComponent(createPanelProtection());
		}
		
        tabSheet.addTab(createPanelProperties(), "Eigenschaften", null);
        tabSheet.addTab(createPanelChances(), "Chancen & Risiken", null);
        tabSheet.addTab(createPanelPaybak(), "Rückzahlungsmodus", null);
        tabSheet.addTab(createPanelExample(), "Beispiele", null);
        tabSheet.addTab(createPanelTaxes(), "Steuern", null);
        tabSheet.addTab(createPanelClassified(), "Klassifizierung", null);
        tabSheet.setSizeFull();
		
		addComponent(tabSheet);
		
		layout.setExpandRatio(tabSheet, 1);
	}
	
	private Panel createPanelProtection() {
		
		Panel protection = new Panel("");
		protection.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) protection.getContent();
		layout.setMargin(false);
		layout.setSizeFull();
		
		String xHtmlText = "<h2>KAPITALSCHUTZ MIT/OHNE CAP</H2>" +
				"<p>Sie erwarten steigende Kurse des Basiswertes, schliessen " +
				"aber eine Kurskorrektur nicht aus.</p>";
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		protection.addComponent(xhmtlLabel);
		
		return protection;
		
	}
	
	private Panel createPanelSoftRunner() {
		
		Panel softRunner = new Panel("");
		softRunner.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) softRunner.getContent();
		layout.setMargin(false);
		layout.setSizeFull();
		
		String xHtmlText = "<h2>SOFT RUNNER</H2>" +
		"<p>Sie erwarten stagnierende, leicht steigende oder leicht fallende Kurse " +
		"des Basiswertes. Zudem glauben Sie nicht, dass der Basiswert eine " +
		"bestimmte Barriere (Knock-In Niveau) während der Laufzeit berührt " +
		"oder unterschreitet.</p>";
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		softRunner.addComponent(xhmtlLabel);
		
		return softRunner;
		
	}
	
	private Panel createPanelPutWarrant() {
		
		Panel putWarrent = new Panel("");
		putWarrent.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) putWarrent.getContent();
		layout.setMargin(false);
		layout.setSizeFull();
		
		String xHtmlText = "<h2>PUT WARRANT</H2>" +
		"<p>Sie erwarten sinkende Kurse des Basiswertes und/oder steigende Volatilität.</p>";
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		putWarrent.addComponent(xhmtlLabel);
		
		return putWarrent;
		
	}
	
	private Panel createPanelProperties() {
		
		String xHtmlText = "";
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			
			xHtmlText = "<ul>" +
			"<li>Der PUT WARRENT git Ihnen das Recht - keine Verpflichtung - den " +
			"Basiswert zu einem fest vereinbarten Preis (Strike) bei Verfall " +
			"(European Style) oder währen der Laufzeit (American Style) zu verkaufen.</li>" +
			"<li>Verglichen mit einer Direktanlage ist der Kapitaleinsatz wesentlich " +
			"geringer. Dies erzeugt eine Hebelwirkung gegenüber dem Basiswert.</li>" +
			"<li>PUT WARRENTS besitzen eine beschränkte Laufzeit</li>" +
			"</ul>";
			
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			
			xHtmlText = "<ul>" +
			"<li>Der Softrunner bezahlt einen deutlich über dem Marktzins liegeneden Coupon.</li>" +
			"<li>Zudem besitzt er einen bedingten Kapitalschutz, der die Rückzahlung des " +
			"Nominalbetrages garantiert, solange das Knock-In Niveau währen der " +
			"Laufzeit weder berührt noch unterschritten wird.</li>" +
			"<li>Im gegenzug ist das Renditepotential auf die Maximalrendite beschränkt</li>" +
			"</ul>";		
		
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
		
			xHtmlText = "<ul>" +
			"<li>Bietet Ihnen bei Verfall einen zu Beginn festgelegten Kapitalschutz.</li>" +
			"<li>Sie partizipieren bei steigenden Kursen des Basiswertes in einem " +
			"zu Beginn definierten Verhältnis (Partizipationsrate).</li>" +
			"<li>Die Rendite des Kapitalschutz ohne Cap besitzt keine Obergrenze.</li>" +
			"<li>Der Kapitalschutz mit Cap besitzt eine Maximalrendite.</li>" +
			"</ul>";
		
		}
		
		
		properties = new Panel("");
		properties.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) properties.getContent();
		layout.setMargin(true);
		layout.setSizeFull();
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		properties.addComponent(xhmtlLabel);
		
		return properties;
        
	}
	
	private Panel createPanelChances() {
		
		String xHtmlText = "";
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			
			xHtmlText = "<h3>Chancen</h3>" +
					"<ul>" +
			"<li>Die Rendite des PUT WARRANT ist überproportional gegenüber einer " +
			"direkten Investition in den Basiswert. PUT WARRANTS eignen sich " +
			"zur Spekulation oder zur Absicherung.</li> " +
			"</ul>" +
			"<h3>Risiken</h3>" +
			"<ul>" +
			"<li>Liegt der Basiswert bei Verfall über dem Strike, ist der " +
			"PUT WARRANT wertlos.</li>" +
			"<li>Das Verlustpotential beschränkt sich auf den Kaufpreis.</li>" +
			"</ul>";
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			xHtmlText = "xhtml 1";			
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			xHtmlText = "xhtml 1";
		}
		
		
		chances = new Panel("");
		chances.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) chances.getContent();
		layout.setMargin(true);
		layout.setSizeFull();
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		chances.addComponent(xhmtlLabel);
		
		return chances;
		
	}
	
	private Panel createPanelPaybak() {

		payback = new Panel("");
		payback.addStyleName(Reindeer.PANEL_LIGHT);
		
		Embedded embedded = null;
		
		String xHtmlText = "";
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			xHtmlText = "<ul>" +
				"<li>Liegt der Kurs des Basiswertes bei Verfall tiefer als der Strike, " +
				"so haben Sie das Recht, den Basiswert zum Ausübungspreis zu " +
				"verkaufen.</li> " +
				"<li>Die Anzal Basiswerte, die durch den Optionsvertrag veräussert " +
				"werden können, ist durch das Ratio gegeben. Ein Ration von 20 " +
				"bedeutet, dass 20 PUT WARRANTS zum Verkauf eines Basiswertes " +
				"berechtigen.</li>" +
				"<li>Wenn Sie den Basiswert bei Verfall nicht verkaufen möchten, " +
				"können Sie den PUT WARRANT auch über die Börse veräussern.</li>" +
				"<li>Liegt der Basiswert bei Verfall über dem Strike, ist der " +
				"PUT WARRANT wertlos.</li>" +
				"</ul>" +
				"<br>";			
			embedded = new Embedded(null, new ThemeResource("../poc/img/putWarrant.png"));
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			xHtmlText = "xhtml 1";			
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			xHtmlText = "xhtml 1";
		}

		
		VerticalLayout layout = (VerticalLayout) payback.getContent();
		layout.setMargin(true);
		layout.setSizeFull();
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		payback.addComponent(xhmtlLabel);
		
		if (embedded != null) {
			payback.addComponent(embedded);
		}
		
		return payback;
		
	}
	
	private Panel createPanelExample() {
		
		boolean withImage = false;
		
		String xHtmlText = "";
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			xHtmlText = "<h3>Ausgangslage</h3>" +
					"<img src=\"VAADIN/themes/poc/img/example1.png\" alt=\"Beispiel 1\"/>" +
					"<br>" +
					"<img src=\"VAADIN/themes/poc/img/example2.png\" alt=\"Beispiel 2\"/>";
			withImage = true;
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			xHtmlText = "xhtml 1";			
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			xHtmlText = "xhtml 1";
		}
		
		
		example = new Panel("");
		example.addStyleName(Reindeer.PANEL_LIGHT);
		example.setScrollable(true);
		
		VerticalLayout layout = (VerticalLayout) example.getContent();
		layout.setMargin(true);
		
		if (withImage) {
			layout.setHeight("100%");
			layout.setWidth(670, Sizeable.UNITS_PIXELS);			
		} else {
			layout.setSizeFull();
		}
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		example.addComponent(xhmtlLabel);
		
		return example;
		
	}
	
	private Panel createPanelTaxes() {
		
		String xHtmlText = "";
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			xHtmlText = "<ul>" +
				"<li>PUT WARRANTS sind von der Einkommens- und Verrechnungssteuer befreit.</li> " +
				"<li>Bei physischer Lieferung fällt die Umsatzangabe an.</li>" +
				"</ul>";
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			xHtmlText = "xhtml 1";			
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			xHtmlText = "xhtml 1";
		}
		
		
		taxes = new Panel("");
		taxes.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) taxes.getContent();
		layout.setMargin(true);
		layout.setSizeFull();
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		taxes.addComponent(xhmtlLabel);
		
		return taxes;
		
	}
	
	private Panel createPanelClassified() {
		
		String xHtmlText = "";
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
				xHtmlText = "<ul>" +
					"<li><a href=\"http://www.svsp-verband.ch/home/produkttypen.aspx?lang=de&pc1=21&pc2=2100\">" +
					"PUT WARRANTS</a> gehören zur Kategorie der Hebel-Produkte. " +
					"Die gemäss dem Schweizerischen Verband für Strukturierte Produkte " +
					"(SVSP) verwendete Produktetyp-Nummer ist 2100.</li>" +
					"</ul>";
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			xHtmlText = "xhtml 1";			
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			xHtmlText = "xhtml 1";
		}
		
		
		classified = new Panel("");
		classified.addStyleName(Reindeer.PANEL_LIGHT);
		
		VerticalLayout layout = (VerticalLayout) classified.getContent();
		layout.setMargin(true);
		layout.setSizeFull();
		
		Label xhmtlLabel = new Label(xHtmlText, Label.CONTENT_XHTML);
		
		classified.addComponent(xhmtlLabel);
		
		return classified;
		
	}
	
}
