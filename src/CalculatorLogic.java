import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorLogic {

    public String calculate(String expression) {
        int index;
        double firstOperand, secondOperand, minusValues = 0, plusValues = 0;

        // Spliting expression in operator and operands list
        List<String> operands = new ArrayList<>();
        List<Character> extractedOperators = new ArrayList<>();
        int i, j = 0;
        for (i = 0; i < expression.length(); i++) {

            if (expression.charAt(i) == '-' && i == 0) {
            } else if (expression.charAt(i) == '*' || expression.charAt(i) == '/' && expression.charAt(i + 1) == '-') {
                operands.add(expression.substring(j, i));
                extractedOperators.add(expression.charAt(i));
                j = ++i;
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
                    || expression.charAt(i) == '/') {
                operands.add(expression.substring(j, i));
                extractedOperators.add(expression.charAt(i));
                j = i + 1;
            }
        }
        operands.add(expression.substring(j, i));

        // System.out.println("================================================");
        // for (String op : operands) {
        // System.out.print(op + " , ");
        // }
        // System.out.println();
        // for (char op : extractedOperators) {
        // System.out.print(op + " , ");
        // }
        // System.out.println();
        // System.out.println("================================================");

        // solving Division and multiplication first ...
        char[] multiply_divide = { '/', '*' };
        for (char ch : multiply_divide) {
            for (index = extractedOperators.indexOf(ch); index != -1; index = extractedOperators.indexOf(ch)) {
                firstOperand = Double.parseDouble(operands.get(index));
                secondOperand = Double.parseDouble(operands.get(index + 1));
                // System.out.println("firstOperand: " + firstOperand);
                // System.out.println("secondOperand: " + secondOperand);

                switch (ch) {
                    case '*':
                        operands.set(index, String.valueOf(firstOperand * secondOperand));
                        break;
                    case '/':
                        operands.set(index, String.valueOf(firstOperand / secondOperand));
                        break;
                }

                extractedOperators.remove(index);
                // System.out.println("new Operators list: " + extractedOperators);
                operands.remove(index + 1);
                // System.out.println("new OperandsList: " + operands);
            }
        }
        // System.out.println("old operandsList: " + operands);

        // updating operands's sign according to operation (addition/Subtraction)
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
        // System.out.println("new operandList: " + operands);

        // solving addition and subtraction ....
        for (i = 0; i < operands.size(); i++) {
            if (operands.get(i).charAt(0) == '-') {
                minusValues += Double.parseDouble(operands.get(i));
            } else {
                plusValues += Double.parseDouble(operands.get(i));
            }
        }

        return String.valueOf(plusValues + minusValues);
    }
}
