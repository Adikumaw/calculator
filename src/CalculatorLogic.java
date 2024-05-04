import java.util.ArrayList;
import java.util.List;

public class CalculatorLogic {

    public String calculate(String expression) {
        int index;
        double firstOperand, secondOperand, minusValues = 0, plusValues = 0;

        List<String> operands = new ArrayList<>();
        List<Character> extractedOperators = new ArrayList<>();
        int i, j = 0;

        // ------------------------------------------------------------------------------
        // Spliting expression in operator and operands list
        // ------------------------------------------------------------------------------
        for (i = 0; i < expression.length(); i++) {
            // Handle first character (-)tive expression
            if (expression.charAt(i) == '-' && i == 0) {
            }
            // Handle when negative expression is present after '*' or '/'
            else if (expression.charAt(i) == '*' || expression.charAt(i) == '/' && expression.charAt(i + 1) == '-') {
                operands.add(expression.substring(j, i));
                extractedOperators.add(expression.charAt(i));
                j = ++i; // increment before assignment
            }
            // Handle when any operator is encountered
            else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
                    || expression.charAt(i) == '/') {
                operands.add(expression.substring(j, i));
                extractedOperators.add(expression.charAt(i));
                j = i + 1;
            }
        }
        operands.add(expression.substring(j, i)); // extract last operand

        // ------------------------------------------------------------------------------
        // solving Division and multiplication first
        // ------------------------------------------------------------------------------
        char[] multiply_divide = { '/', '*' };
        for (char ch : multiply_divide) {
            for (index = extractedOperators.indexOf(ch); index != -1; index = extractedOperators.indexOf(ch)) {
                firstOperand = Double.parseDouble(operands.get(index));
                secondOperand = Double.parseDouble(operands.get(index + 1));

                switch (ch) {
                    case '*':
                        operands.set(index, String.valueOf(firstOperand * secondOperand));
                        break;
                    case '/':
                        operands.set(index, String.valueOf(firstOperand / secondOperand));
                        break;
                }

                extractedOperators.remove(index);
                operands.remove(index + 1);
            }
        }

        // ------------------------------------------------------------------------------
        // updating operands's sign according to operation (addition/Subtraction)
        // ------------------------------------------------------------------------------
        for (i = 0; i < extractedOperators.size(); i++) {
            if (operands.get(i + 1).charAt(0) == '-') {
                if (extractedOperators.get(i) == '-') {
                    operands.set(i + 1, '+' + operands.get(i + 1).substring(1));
                }
            } else {
                if (extractedOperators.get(i) == '-') {
                    operands.set(i + 1, '-' + operands.get(i + 1));
                }
            }
        }

        // ------------------------------------------------------------------------------
        // solving addition and subtraction
        // ------------------------------------------------------------------------------
        for (i = 0; i < operands.size(); i++) {
            if (operands.get(i).charAt(0) == '-') {
                minusValues += Double.parseDouble(operands.get(i));
            } else {
                plusValues += Double.parseDouble(operands.get(i));
            }
        }

        // RETURN FINAL RESULT
        return String.valueOf(plusValues + minusValues);
    }
}
