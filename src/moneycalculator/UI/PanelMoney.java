package moneycalculator.UI;

import moneycalculator.UI.MoneyDialog;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.Model.Money;

public class PanelMoney extends JPanel implements MoneyDialog{
    private String amount = "0";
    private CurrencyViewer currencyDialog;

    public PanelMoney() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }
    
    @Override
    public Money getMoney() {
        return new Money(Double.parseDouble(amount), currencyDialog.getCurrency());
    }

    private void createComponents() {
        this.add(createAmountWidget());
        this.add(createCurrencyDialogPanel());
    }

    private JTextField createAmountWidget() {
        final JTextField textField = new JTextField(amount, 10);
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = textField.getText();
            }
        });
        return textField;
    }

    private JPanel createCurrencyDialogPanel() {
        PanelCurrency panel = new PanelCurrency();
        this.currencyDialog = panel;
        return panel;
    }

}
