import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorUI {

    private final JFrame frame;
    private final JLabel displayLabel;
    private final JTextField inputField;
    private final Font myFont = new Font("Roboto", Font.PLAIN, 20);
    public final Color WHITE = new Color(252, 252, 252);
    public final Color DARKBLACK = new Color(27, 30, 32);
    public final Color GRAY = new Color(42, 46, 50);
    public final Color LIGHTGRAY = new Color(49, 54, 59);
    public final Color BLUE = new Color(57, 135, 176);

    private final JButton[] numericButtons = new JButton[10];
    private final JButton[] symbolicButtons = new JButton[8];

    private final JButton clearButton, deleteButton, multiplyButton, divideButton;
    private final JButton subtractButton, addButton, equalsButton, decimalButton;

    private final Calculator calculator;

    public CalculatorUI(Calculator calculator) {
        this.calculator = calculator;

        // ----------------------------------------------------------------
        // CREATE FRAME
        // ----------------------------------------------------------------
        frame = new JFrame("Calculator");
        frame.getContentPane().setBackground(GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        frame.setSize(350, 510);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // ----------------------------------------------------------------
        // CREATE LABLE
        // ----------------------------------------------------------------
        displayLabel = new JLabel("");
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setFont(myFont);
        displayLabel.setForeground(WHITE);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.gridy = 0;
        constraint.weightx = 1.0;
        constraint.weighty = 0.05;
        constraint.gridwidth = 2;
        // ADD TO FRAME +++++++++++++++++++
        frame.add(displayLabel, constraint);
        // ADD TO FRAME +++++++++++++++++++

        // ----------------------------------------------------------------
        // CREATE TEXT FIELD
        // ----------------------------------------------------------------
        inputField = new JTextField("0");
        inputField.setEditable(false);
        inputField.setFont(myFont);
        inputField.setBackground(DARKBLACK);
        inputField.setForeground(WHITE);
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        constraint.gridy = 1;
        constraint.weighty = 0.2;
        // ADD TO FRAME +++++++++++++++++++
        frame.add(inputField, constraint);
        // ADD TO FRAME +++++++++++++++++++

        // Buttons Initialization --------------------------------------------------
        symbolicButtons[0] = clearButton = new JButton("C");
        symbolicButtons[1] = deleteButton = new JButton("Del");
        symbolicButtons[2] = multiplyButton = new JButton("*");
        symbolicButtons[3] = decimalButton = new JButton(".");
        symbolicButtons[4] = divideButton = new JButton("/");
        symbolicButtons[5] = subtractButton = new JButton("-");
        symbolicButtons[6] = addButton = new JButton("+");
        symbolicButtons[7] = equalsButton = new JButton("=");

        for (Integer i = 0; i < numericButtons.length; i++) {
            numericButtons[i] = new JButton(i.toString());
            numericButtons[i].addActionListener(calculator);
            numericButtons[i].setFont(myFont);
            numericButtons[i].setFocusable(false);
            numericButtons[i].setBackground(LIGHTGRAY);
            numericButtons[i].setForeground(WHITE);
        }
        for (int i = 0; i < symbolicButtons.length; i++) {
            symbolicButtons[i].addActionListener(calculator);
            symbolicButtons[i].setFont(myFont);
            symbolicButtons[i].setFocusable(false);
            symbolicButtons[i].setBackground(LIGHTGRAY);
            symbolicButtons[i].setForeground(WHITE);
        }
        // Buttons Initialization end --------------------------------------------------

        // -------------------------------------------------------------------------
        // CREATE MAIN PANEL
        // -------------------------------------------------------------------------
        JPanel panel = new JPanel();
        panel.setBackground(GRAY);
        panel.setLayout(new GridBagLayout());
        constraint.insets = new Insets(5, 5, 5, 0);
        constraint.gridy = 2;
        constraint.weightx = 0.75;
        constraint.weighty = 0.75;
        constraint.gridwidth = 1;
        GridBagConstraints MainPanelConstraint = new GridBagConstraints();

        // Universal constraint -------------------------------->>>>>>>>
        MainPanelConstraint.fill = GridBagConstraints.BOTH;
        MainPanelConstraint.insets = new Insets(3, 3, 3, 3);
        MainPanelConstraint.weightx = 1.0;
        MainPanelConstraint.weighty = 1.0;
        // Universal constraint -------------------------------->>>>>>>>

        // first row of main panel -------------------------------->>>>>>>
        MainPanelConstraint.gridy = 0;
        MainPanelConstraint.ipadx = 20; // to give it same width as the delete button
        panel.add(clearButton, MainPanelConstraint);
        MainPanelConstraint.ipadx = 0;
        panel.add(deleteButton, MainPanelConstraint);
        MainPanelConstraint.ipadx = 20; // to give it same width as the delete button
        panel.add(multiplyButton, MainPanelConstraint);
        // Second row of main panel -------------------------------->>>>>>>
        MainPanelConstraint.gridy = 1;
        panel.add(numericButtons[7], MainPanelConstraint);
        panel.add(numericButtons[8], MainPanelConstraint);
        panel.add(numericButtons[9], MainPanelConstraint);
        // Third row of main panel -------------------------------->>>>>>>
        MainPanelConstraint.gridy = 2;
        panel.add(numericButtons[4], MainPanelConstraint);
        panel.add(numericButtons[5], MainPanelConstraint);
        panel.add(numericButtons[6], MainPanelConstraint);
        // Fourth row of main panel -------------------------------->>>>>>>
        MainPanelConstraint.gridy = 3;
        panel.add(numericButtons[1], MainPanelConstraint);
        panel.add(numericButtons[2], MainPanelConstraint);
        panel.add(numericButtons[3], MainPanelConstraint);
        // Fifth row of main panel -------------------------------->>>>>>>
        MainPanelConstraint.gridy = 4;
        MainPanelConstraint.gridwidth = 2;
        panel.add(numericButtons[0], MainPanelConstraint);
        MainPanelConstraint.gridwidth = 1;
        panel.add(decimalButton, MainPanelConstraint);
        // ADD TO FRAME +++++++++++++++++++
        frame.add(panel, constraint);
        // ADD TO FRAME +++++++++++++++++++

        // -------------------------------------------------------------------------
        // CREATE SIDE PANEL
        // -------------------------------------------------------------------------
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(GRAY);
        sidePanel.setLayout(new GridBagLayout());
        GridBagConstraints sidePanelConstraint = new GridBagConstraints();
        constraint.insets = new Insets(5, 0, 5, 5);
        constraint.weightx = 0.25;

        // Universal constraint -------------------------------->>>>>>>>
        sidePanelConstraint.fill = GridBagConstraints.BOTH;
        sidePanelConstraint.insets = new Insets(3, 3, 3, 3);
        sidePanelConstraint.weightx = 1.0;
        sidePanelConstraint.weighty = 1.0;
        // Universal constraint -------------------------------->>>>>>>>

        // First row of side panel -------------------------------->>>>>>>
        sidePanelConstraint.gridy = 0;
        sidePanel.add(divideButton, sidePanelConstraint);
        // Second row of side panel -------------------------------->>>>>>>
        sidePanelConstraint.gridy = 1;
        sidePanelConstraint.ipady = 1;
        sidePanel.add(subtractButton, sidePanelConstraint);
        // Third row of side panel -------------------------------->>>>>>>
        sidePanelConstraint.gridy = 2;
        sidePanelConstraint.ipady = 0;
        sidePanel.add(addButton, sidePanelConstraint);
        // Fourth row of side panel -------------------------------->>>>>>>
        sidePanelConstraint.gridy = 3;
        sidePanelConstraint.weighty = 2.0;
        sidePanelConstraint.ipady = 45;
        sidePanel.add(equalsButton, sidePanelConstraint);

        // ADD TO FRAME +++++++++++++++++++
        frame.add(sidePanel, constraint);
        // ADD TO FRAME +++++++++++++++++++
    }

    public void addInterfaceEventListeners(ActionListener listener) {
        // Add event listeners to all buttons using the provided listener
        for (int i = 0; i < symbolicButtons.length; i++) {
            symbolicButtons[i].addActionListener(listener);
        }
        for (int i = 0; i < numericButtons.length; i++) {
            numericButtons[i].addActionListener(listener);
        }
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
        setInputText(getInputText().equals("0") ? digit : getInputText() + digit);
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
