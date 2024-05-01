import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorUI {

    private final JFrame frame;
    private final JLabel displayLabel;
    private final JTextField inputField;

    private final JButton clearButton;
    private final JButton deleteButton;
    private final JButton multiplyButton;
    private final JButton divideButton;

    private final JButton sevenButton;
    private final JButton eightButton;
    private final JButton nineButton;
    private final JButton subtractButton;

    private final JButton fourButton;
    private final JButton fiveButton;
    private final JButton sixButton;
    private final JButton addButton;

    private final JButton oneButton;
    private final JButton twoButton;
    private final JButton threeButton;
    private final JButton equalsButton;

    private final JButton zeroButton;
    private final JButton decimalButton;
    private final JButton doubleZeroButton;

    private final Calculator calculator;

    public CalculatorUI(Calculator calculator) {
        this.calculator = calculator;

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(6, 4, 5, 5));
        frame.setSize(320, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        displayLabel = new JLabel("");
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(displayLabel);

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(inputField);

        clearButton = new JButton("C");
        clearButton.addActionListener(calculator);
        frame.add(clearButton);

        deleteButton = new JButton("DEL");
        deleteButton.addActionListener(calculator);
        frame.add(deleteButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(calculator);
        frame.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(calculator);
        frame.add(divideButton);

        sevenButton = new JButton("7");
        sevenButton.addActionListener(calculator);
        frame.add(sevenButton);

        eightButton = new JButton("8");
        eightButton.addActionListener(calculator);
        frame.add(eightButton);

        nineButton = new JButton("9");
        nineButton.addActionListener(calculator);
        frame.add(nineButton);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(calculator);
        frame.add(subtractButton);

        fourButton = new JButton("4");
        fourButton.addActionListener(calculator);
        frame.add(fourButton);

        fiveButton = new JButton("5");
        fiveButton.addActionListener(calculator);
        frame.add(fiveButton);

        sixButton = new JButton("6");
        sixButton.addActionListener(calculator);
        frame.add(sixButton);

        addButton = new JButton("+");
        addButton.addActionListener(calculator);
        frame.add(addButton);

        oneButton = new JButton("1");
        oneButton.addActionListener(calculator);
        frame.add(oneButton);

        twoButton = new JButton("2");
        twoButton.addActionListener(calculator);
        frame.add(twoButton);

        threeButton = new JButton("3");
        threeButton.addActionListener(calculator);
        frame.add(threeButton);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(calculator);
        frame.add(equalsButton);

        zeroButton = new JButton("0");
        zeroButton.addActionListener(calculator);
        frame.add(zeroButton);

        decimalButton = new JButton(".");
        decimalButton.addActionListener(calculator);
        frame.add(decimalButton);

        doubleZeroButton = new JButton("00");
        doubleZeroButton.addActionListener(calculator);
        frame.add(doubleZeroButton);

    }

    public void addInterfaceEventListeners(ActionListener listener) {
        // Add event listeners to all buttons using the provided listener
        clearButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        sevenButton.addActionListener(listener);
        eightButton.addActionListener(listener);
        nineButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        fourButton.addActionListener(listener);
        fiveButton.addActionListener(listener);
        sixButton.addActionListener(listener);
        addButton.addActionListener(listener);
        oneButton.addActionListener(listener);
        twoButton.addActionListener(listener);
        threeButton.addActionListener(listener);
        equalsButton.addActionListener(listener);
        zeroButton.addActionListener(listener);
        decimalButton.addActionListener(listener);
        doubleZeroButton.addActionListener(listener);
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getDecimalButton() {
        return decimalButton;
    }

    public JButton getEqualsButton() {
        return equalsButton;
    }

    public String getInputText() {
        return inputField.getText();
    }

    public void setInputText(String text) {
        inputField.setText(text);
    }

    public void clearInput() {
        setInputText("");
    }

    public void appendDigit(String digit) {
        setInputText((getInputText().equals("0") || getInputText().equals("00")) ? digit : getInputText() + digit);
    }

    public void deleteLastDigit() {
        if (getInputText().length() > 0)
            setInputText(getInputText().substring(0, getInputText().length() - 1));
    }

    public void addDecimal() {
        if (!getInputText().contains(".")) {
            setInputText(getInputText() + ".");
        }
    }

    public void setDisplayText(String text) {
        displayLabel.setText(text);
    }
}
