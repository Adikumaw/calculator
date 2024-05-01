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
        frame.setLayout(new GridLayout(7, 4, 5, 5));
        frame.setSize(320, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        displayLabel = new JLabel("hello world");
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridwidth = 3;
        frame.add(displayLabel, constraint);

        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.gridwidth = 3;
        frame.add(inputField, constraint);

        clearButton = new JButton("C");
        clearButton.addActionListener(calculator);
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 0;
        frame.add(clearButton, constraint);

        deleteButton = new JButton("DEL");
        deleteButton.addActionListener(calculator);
        constraint.gridx = 1;
        constraint.gridy = 2;
        constraint.gridwidth = 0;
        frame.add(deleteButton, constraint);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(calculator);
        constraint.gridx = 2;
        constraint.gridy = 2;
        constraint.gridwidth = 0;
        frame.add(multiplyButton, constraint);

        divideButton = new JButton("/");
        divideButton.addActionListener(calculator);
        constraint.gridx = 3;
        constraint.gridy = 2;
        constraint.gridwidth = 0;
        frame.add(divideButton, constraint);

        sevenButton = new JButton("7");
        sevenButton.addActionListener(calculator);
        constraint.gridx = 0;
        constraint.gridy = 3;
        constraint.gridwidth = 0;
        frame.add(sevenButton, constraint);

        eightButton = new JButton("8");
        eightButton.addActionListener(calculator);
        constraint.gridx = 1;
        constraint.gridy = 3;
        constraint.gridwidth = 0;
        frame.add(eightButton, constraint);

        nineButton = new JButton("9");
        nineButton.addActionListener(calculator);
        constraint.gridx = 2;
        constraint.gridy = 3;
        constraint.gridwidth = 0;
        frame.add(nineButton, constraint);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(calculator);
        constraint.gridx = 3;
        constraint.gridy = 3;
        constraint.gridwidth = 0;
        frame.add(subtractButton, constraint);

        fourButton = new JButton("4");
        fourButton.addActionListener(calculator);
        constraint.gridx = 0;
        constraint.gridy = 4;
        constraint.gridwidth = 0;
        frame.add(fourButton, constraint);

        fiveButton = new JButton("5");
        fiveButton.addActionListener(calculator);
        constraint.gridx = 1;
        constraint.gridy = 4;
        constraint.gridwidth = 0;
        frame.add(fiveButton, constraint);

        sixButton = new JButton("6");
        sixButton.addActionListener(calculator);
        constraint.gridx = 2;
        constraint.gridy = 4;
        constraint.gridwidth = 0;
        frame.add(sixButton, constraint);

        addButton = new JButton("+");
        addButton.addActionListener(calculator);
        constraint.gridx = 3;
        constraint.gridy = 4;
        constraint.gridwidth = 0;
        frame.add(addButton, constraint);

        oneButton = new JButton("1");
        oneButton.addActionListener(calculator);
        constraint.gridx = 0;
        constraint.gridy = 5;
        constraint.gridwidth = 0;
        frame.add(oneButton, constraint);

        twoButton = new JButton("2");
        twoButton.addActionListener(calculator);
        constraint.gridx = 1;
        constraint.gridy = 5;
        constraint.gridwidth = 0;
        frame.add(twoButton, constraint);

        threeButton = new JButton("3");
        threeButton.addActionListener(calculator);
        constraint.gridx = 2;
        constraint.gridy = 5;
        constraint.gridwidth = 0;
        frame.add(threeButton, constraint);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(calculator);
        constraint.gridx = 3;
        constraint.gridy = 5;
        constraint.gridwidth = 0;
        frame.add(equalsButton, constraint);

        zeroButton = new JButton("0");
        zeroButton.addActionListener(calculator);
        constraint.gridx = 0;
        constraint.gridy = 6;
        constraint.gridwidth = 0;
        frame.add(zeroButton, constraint);

        decimalButton = new JButton(".");
        decimalButton.addActionListener(calculator);
        constraint.gridx = 1;
        constraint.gridy = 6;
        constraint.gridwidth = 0;
        frame.add(decimalButton, constraint);

        doubleZeroButton = new JButton("00");
        doubleZeroButton.addActionListener(calculator);
        constraint.gridx = 2;
        constraint.gridy = 6;
        constraint.gridwidth = 0;
        frame.add(doubleZeroButton, constraint);

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
