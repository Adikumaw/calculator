import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    private String expression, result;

    private CalculatorUI ui;
    private CalculatorLogic logic;

    public Calculator() {
        ui = new CalculatorUI();
        logic = new CalculatorLogic();
        addInterfaceEventListeners();
    }

    private void addInterfaceEventListeners() {
        ui.addInterfaceEventListeners(this); // Delegate event handling to the UI
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Extract action event source from the event
        Object source = e.getSource();

        // Handle clear button ---------------------------------------------
        if (source == ui.getClearButton()) {
            ui.clearInput();
        } // Handle Delete button ------------------------------------------
        else if (source == ui.getDeleteButton()) {
            ui.deleteLastDigit();
        } // Handle decimal "." button -------------------------------------
        else if (source == ui.getDecimalButton()) {
            ui.addDecimal();
        } // Handle clear button -------------------------------------------
        else if (source == ui.getMultiplyButton() || source == ui.getDivideButton()
                || source == ui.getAddButton() || source == ui.getSubtractButton()) {
            expression = ui.getInputText();
            char lastChar = expression.charAt(expression.length() - 1);
            // do not append if last character is already any operator
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                expression = expression.substring(0, expression.length() - 1) + ((JButton) source).getText();
                ui.setInputText(expression);
            } else {
                ui.appendDigit(((JButton) source).getText());
            }
            result = logic.calculate(expression);
            ui.setDisplayText(result);
        } // Handle equals button ------------------------------------------
        else if (source == ui.getEqualsButton()) {
            result = logic.calculate(expression);
            ui.clearInput();
            ui.setDisplayText(expression);
            ui.setInputText(result);
            expression = result;
        } // Handle numeric buttons ----------------------------------------
        else if (source instanceof JButton) {
            ui.appendDigit(((JButton) source).getText());
        }
        System.out.println(expression);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
