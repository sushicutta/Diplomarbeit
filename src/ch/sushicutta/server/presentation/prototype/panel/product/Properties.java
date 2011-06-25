package ch.sushicutta.server.presentation.prototype.panel.product;

import ch.sushicutta.server.layout.StruktiLayout;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Slider;
import com.vaadin.ui.Slider.ValueOutOfBoundsException;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
public class Properties extends Panel {
	
	private StruktiLayout struktiLayout;
	
	private Slider strike = new Slider("30 % - 200 %");
	private Slider vola = new Slider("0 % - 60 %");
	
	private double strikeValue = 100.0d;
	private double volaValue = 30.0d;
	
	public Properties(StruktiLayout struktiLayout) {
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
		Panel panelStrike = new Panel("Strike");
		
		final Label strikeLabel = new Label("100.0");
		
		strike.setWidth("100%");
		strike.setMin(30);
		strike.setMax(200);
		try {
			strike.setValue(strikeValue);
		} catch (ValueOutOfBoundsException e) {
			// do Something
		}
		strike.setImmediate(true);
		strike.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				strikeValue = Double.valueOf(event.getProperty().getValue().toString()).doubleValue();
				strikeLabel.setValue(event.getProperty().getValue());
				
				struktiLayout.fireSliderValueChanged(strike, StruktiLayout.SliderEnum.STRIKE, strikeValue);

			}
			
		});
				
		panelStrike.addComponent(strike);
		panelStrike.addComponent(strikeLabel);
		
		Panel panelVola = new Panel("Volatilität");
		
		final Label volaLabel = new Label("30.0");
		
		vola.setWidth("100%");
		vola.setMin(0);
		vola.setMax(60);
		try {
			vola.setValue(volaValue);
		} catch (ValueOutOfBoundsException e) {
			// do Something
		}
		vola.setImmediate(true);
		vola.addListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				volaValue = Double.valueOf(event.getProperty().getValue().toString()).doubleValue();
				volaLabel.setValue(event.getProperty().getValue());
				
				struktiLayout.fireSliderValueChanged(vola, StruktiLayout.SliderEnum.VOLA, volaValue);
			}
			
		});
				
		panelVola.addComponent(vola);
		panelVola.addComponent(volaLabel);
		
		addComponent(panelStrike);
		addComponent(panelVola);
		
	}
}
