import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorLogic {

    public String calculate(String expression) {
        int index;
        double firstOperand, secondOperand;
        // Converting split array to List
        // (NOTE: used new ArrayList to avoid static list problems caused by asList()
        // method)
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split("[-+*/]")));
        String operators = "/*+-"; // String containing the desired operators

        // Extract the operators
        List<Character> extractedOperators = new ArrayList<>();
        for (char c : expression.toCharArray()) {
            if (operators.indexOf(c) != -1) {
                extractedOperators.add(c);
            }
        }

        // System.out.println("================================================");
        // for (String token : operands) {
        // System.out.println(token);
        // }
        // System.out.println("================================================");

        for (char ch : operators.toCharArray()) {
            for (index = extractedOperators.indexOf(ch); index != -1; index = extractedOperators.indexOf(ch)) {
                firstOperand = Double.parseDouble(operands.get(index));
                secondOperand = Double.parseDouble(operands.get(index + 1));
                System.out.println("firstOperand: " + firstOperand);
                System.out.println("secondOperand: " + secondOperand);

                switch (ch) {
                    case '+':
                        operands.set(index, String.valueOf(firstOperand + secondOperand));
                        break;
                    case '-':
                        operands.set(index, String.valueOf(firstOperand - secondOperand));
                        break;
                    case '*':
                        operands.set(index, String.valueOf(firstOperand * secondOperand));
                        break;
                    case '/':
                        operands.set(index, String.valueOf(firstOperand / secondOperand));
                        break;
                }

                extractedOperators.remove(index);
                System.out.println("new Operators list: " + extractedOperators);
                operands.remove(index + 1);
                System.out.println("new OperandsList: " + operands);
            }
        }
        return operands.getFirst();
    }
}
