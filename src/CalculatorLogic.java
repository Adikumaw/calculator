
public class CalculatorLogic {

    public double calculate(double input1, double input2, String operation) {
        switch (operation) {
            case "+":
                return input1 + input2;
            case "-":
                return input1 - input2;
            case "*":
                return input1 * input2;
            case "/":
                return input1 / input2;
            default:
                return input1; // Return the first input if no operation is specified
        }
    }
}
