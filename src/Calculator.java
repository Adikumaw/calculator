import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    private double input, result;
    private String operation;

    private CalculatorUI ui;
    private CalculatorLogic logic;

    public Calculator() {
        ui = new CalculatorUI(this);
        logic = new CalculatorLogic();
    }

    private void addInterfaceEventListeners() {
        ui.addInterfaceEventListeners(this); // Delegate event handling to the UI
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == ui.getClearButton()) {
            ui.clearInput();
        } else if (source == ui.getDeleteButton()) {
            ui.deleteLastDigit();
        } else if (source instanceof JButton digitButton) {
            ui.appendDigit(((JButton) source).getText());
        } else if (source == ui.getDecimalButton()) {
            ui.addDecimal();
        } else if (source instanceof JButton operatorButton) {
            String operator = ((JButton) source).getText();
            operation = operator;
            input = Double.parseDouble(ui.getInputText());
            ui.clearInput();
            ui.setDisplayText(ui.getInputText() + operator);
        } else if (source == ui.getEqualsButton()) {
            double secondNumber = Double.parseDouble(ui.getInputText());
            result = logic.calculate(input, secondNumber, operation);
            ui.clearInput();
            ui.setDisplayText(String.valueOf(result));
            operation = "";
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
