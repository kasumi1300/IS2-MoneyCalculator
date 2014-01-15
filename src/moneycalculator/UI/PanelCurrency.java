package moneycalculator.UI;

import moneycalculator.UI.CurrencyViewer;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import moneycalculator.Model.Currency;

public class PanelCurrency extends JPanel implements CurrencyViewer{
    
    private String currency;

    public PanelCurrency() {
        this("EUR");
    }

    public PanelCurrency(String currency) {
        super(new FlowLayout(FlowLayout.LEFT));
        this.currency = currency;
        this.createComponents();
    }
    
    @Override
    public Currency getCurrency() {
        return new Currency(currency);
    }

    private void createComponents() {
        this.add(createCurrencyDisplay());
    }

    private JComboBox createCurrencyDisplay() {
        JComboBox comboBox = new JComboBox(new String[] {"EUR","USD", "CAD", "GBP"});
        comboBox.setSelectedItem(currency);
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange() != ItemEvent.SELECTED) return;
                currency = (String) event.getItem();
            }
        });
        return comboBox;
    }

}
