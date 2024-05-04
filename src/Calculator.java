import javax.swing.*;
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
        }
        // Handle Delete button ------------------------------------------
        else if (source == ui.getDeleteButton()) {
            ui.deleteLastDigit();
        }
        // Handle decimal "." button -------------------------------------
        else if (source == ui.getDecimalButton()) {
            ui.addDecimal();
        }
        // Handle Operator buttons ---------------------------------------
        else if (source == ui.getMultiplyButton() || source == ui.getDivideButton()
                || source == ui.getAddButton() || source == ui.getSubtractButton()) {

            expression = ui.getInputText();
            String operator = ((JButton) source).getText();

            // empty expression when only 0 is there
            if (expression.length() == 1 && expression.charAt(0) == '0') {
                expression = "";
            }

            // allow only (-)tive sign for null expression
            if (expression.length() == 0) {
                if (operator.equals("-")) {
                    ui.setInputText(((JButton) source).getText());
                }
            }
            // Handle when negative expression is present in beginning
            else if (expression.length() == 1) {
                char lastChar = expression.charAt(expression.length() - 1);
                if (lastChar != '-') {
                    ui.appendDigit(((JButton) source).getText());
                }
            }
            // Handle when more than one character is present
            else if (expression.length() > 1) {
                char lastChar = expression.charAt(expression.length() - 1);
                if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                    // allow only negative after '*' or '/'
                    if (operator == "-") {
                        if (lastChar == '*' || lastChar == '/') {
                            ui.appendDigit(((JButton) source).getText());
                            return;
                        }
                    }
                    // ignore case
                    else if (lastChar == '-' && expression.charAt(expression.length() - 2) == '*'
                            || expression.charAt(expression.length() - 2) == '/') {
                    }
                    // do not append if last character is already any operator
                    else {
                        expression = expression.substring(0, expression.length() - 1);
                        ui.setInputText(expression + ((JButton) source).getText());
                    }
                }
                // append when no operator found in the end of the expression
                else {
                    ui.appendDigit(((JButton) source).getText());
                    result = logic.calculate(expression);
                    ui.setDisplayText(result);
                }
            }
        }
        // Handle equals button ------------------------------------------
        else if (source == ui.getEqualsButton()) {
            expression = ui.getInputText();
            char lastChar = expression.charAt(expression.length() - 1);
            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                expression = expression.substring(0, expression.length() - 1);
            }
            result = logic.calculate(expression);
            ui.setDisplayText(expression);
            ui.setInputText(result);
            expression = result;
        }
        // Handle numeric buttons ----------------------------------------
        else if (source instanceof JButton) {
            ui.appendDigit(((JButton) source).getText());
            expression = ui.getInputText();
            result = logic.calculate(expression);
            ui.setDisplayText(result);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
