package ch.sushicutta.server.presentation.prototype.panel.product;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.vaadin.addon.JFreeChartWrapper;

import ch.sushicutta.server.layout.StruktiLayout;
import ch.sushicutta.server.layout.StruktiLayout.SliderValueChangedEvent;
import ch.sushicutta.server.layout.StruktiLayout.SliderValueChangedListener;

import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class Design extends Panel implements SliderValueChangedListener {
	
	private StruktiLayout struktiLayout;
	
	private XYSeriesCollection areaDataset;
	private XYSeriesCollection lineDataset;
	
	private double volaValue = 30.0;
	private double strikeValue = 100.0;
	
	public Design(StruktiLayout struktiLayout) {
		this.struktiLayout = struktiLayout;
		init();
	}
	
	private void init() {
		
		observe();
		
		addStyleName(Reindeer.PANEL_LIGHT);
		
		createLayout();
		
	}
	
	
	private void observe() {
		struktiLayout.addSliderValueChangedListener(this);
		
	}

	private JFreeChart createChart() {

		areaDataset = new XYSeriesCollection();
		lineDataset = new XYSeriesCollection();
		
		refreshDatasets();

		// Area renderer
		final XYItemRenderer areaRenderer = new XYAreaRenderer();
		areaRenderer.setSeriesPaint(0, new Color(0, 138, 203));
		areaRenderer.setSeriesPaint(1, new Color(255, 0, 0));
		
		areaRenderer.setSeriesVisibleInLegend(0, false);

		final NumberAxis xaxis = new NumberAxis("Basiswert in %");
		xaxis.setRange(0, 200);
		final NumberAxis yaxis = new NumberAxis("Wert des Produktes");
		yaxis.setRange(0, 200);
		
		yaxis.setVisible(false);
		

		final XYPlot plot = new XYPlot(areaDataset, xaxis, yaxis, areaRenderer);
		plot.setForegroundAlpha(1.0f);
		plot.setBackgroundPaint(new Color(255, 255, 255));

		// Line renderer
		final StandardXYItemRenderer lineRenderer = new StandardXYItemRenderer(StandardXYItemRenderer.LINES);
		lineRenderer.setSeriesPaint(0, new Color(96, 182, 222));
		lineRenderer.setSeriesStroke(0, new BasicStroke(2.0f));
		lineRenderer.setSeriesPaint(1, new Color(0, 0, 0));
		lineRenderer.setSeriesStroke(1, new BasicStroke(1.0f));

		// Add line renderer to area plot
		plot.setDataset(1, lineDataset);
		plot.setRenderer(1, lineRenderer);
		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

		final JFreeChart chart = new JFreeChart(null, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
		chart.setBackgroundPaint(new Color(255, 255, 255));
		chart.setBorderVisible(false);
		chart.setAntiAlias(true);
		
		return chart;
		
	}

	private void refreshDatasets() {
		// First remove all
		areaDataset.removeAllSeries();
		lineDataset.removeAllSeries();

		// Product series
		final XYSeries optionSeries = new XYSeries("Produkt");
		final XYSeries productSeries = new XYSeries("Produkt");

		// Default series
		final XYSeries linearSeries = new XYSeries("Basiswert");
		final XYSeries deficitSeries = new XYSeries("Verlustzone");

		optionSeries.add(0, Math.min((200 + (strikeValue - 100) - (volaValue/2)), 200));
		optionSeries.add(strikeValue, 100 - (volaValue/2));
		optionSeries.add(200, 100 - (volaValue/2));
		
		productSeries.add(0, Math.min((200 + (strikeValue - 100) - (volaValue/2)), 200));
		productSeries.add(strikeValue, 100 - (volaValue/2));
		productSeries.add(200, 100 - (volaValue/2));

		linearSeries.add(0, 0);
		linearSeries.add(0 + 200, 0 + 200);

		deficitSeries.add(0, 100);
		deficitSeries.add(200, 100);

		// Add it again
		areaDataset.addSeries(optionSeries);
		areaDataset.addSeries(deficitSeries);
		lineDataset.addSeries(productSeries);
		lineDataset.addSeries(linearSeries);

	}
	
	private void createLayout() {
		
		removeAllComponents();
		
		VerticalLayout layout = (VerticalLayout) getContent();
		layout.setMargin(false, false, false, false);
		layout.setSpacing(true);
		layout.setSizeFull();
		
		if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PUT_OPTION)) {
			JFreeChartWrapper wrapper = new JFreeChartWrapper(createChart());
			wrapper.setSizeFull();
			
			Label titleWarrant = new Label("<h2>Auszahlungsprofil eines PUT WARRANT</h2>" +
					"<p>Laufzeit ist ein Jahr. Der Zins wurde ignoriert.</p>");
			titleWarrant.setContentMode(Label.CONTENT_XHTML);
			
			addComponent(titleWarrant);
			
			addComponent(wrapper);
			
			layout.setExpandRatio(wrapper, 1);
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.SOFT_RUNNER)) {
			addComponent(new Label("Auszahlungsprofil für den Soft Runner."));
		} else if (struktiLayout.getSelectedProduct().equals(StruktiLayout.Product.PROTEIN)) {
			addComponent(new Label("Auszahlungsprofil für den Protein."));
		}

	}

	@Override
	public void onSliderValueChanged(SliderValueChangedEvent event) {
		
		if (event.getSlider().equals(StruktiLayout.SliderEnum.VOLA)) {
			volaValue = event.getValue();
		}
		
		if (event.getSlider().equals(StruktiLayout.SliderEnum.STRIKE)) {
			strikeValue = event.getValue();
		}
		
		createLayout();
		
	}
}
