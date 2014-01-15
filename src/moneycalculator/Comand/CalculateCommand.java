package moneycalculator.Comand;

import moneycalculator.Comand.Command;
import moneycalculator.Model.Money;
import moneycalculator.UI.CurrencyViewer;
import moneycalculator.UI.MoneyViewer;
import moneycalculator.UI.MoneyDialog;

public class CalculateCommand extends Command{

    private final MoneyDialog moneyDialog;
    private final CurrencyViewer currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyViewer currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }

    private double getExchangeRate() {
        return 0.9;
    }

    private double calculateAmount() {
        return moneyDialog.getMoney().getAmount() * getExchangeRate();
    }

}
