package myscientificcalc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScientificCalc extends JFrame implements ActionListener {

	JButton[] numButton;
	JButton clearBtn, deleteBtn;
	JPanel numPanel, inputPanel, displayPanel;
	JTextField inputTxt, dplTxt;
	JLabel inptLbl, dplLbl, messLbl;
	JButton addBtn, subBtn, mulBtn, divBtn, equalBtn, logBtn, sinBtn, cosBtn, tanBtn, exponBtn, radianBtn, sqrtBtn,
			powBtn;

	Double num1;
	Double num2;
	String operator;
	Double result;
	boolean isValid;

	public ScientificCalc() {
		super("Scientific Calculator");

		setLayout(new BorderLayout());

		messLbl = new JLabel();

		inptLbl = new JLabel("Enter Number: ");
		inputTxt = new JTextField(15);

		inputPanel = new JPanel();
		inputPanel.add(inptLbl);
		inputPanel.add(inputTxt);
		inputPanel.add(messLbl);

		dplLbl = new JLabel("Result: ");
		dplTxt = new JTextField(15);
		dplTxt.setEditable(false);
		displayPanel = new JPanel();
		displayPanel.add(dplLbl);
		displayPanel.add(dplTxt);
		displayPanel.setBackground(new Color(255, 255, 26));

		numPanel = new JPanel();
		numPanel.setLayout(new GridLayout(6, 5));

		clearBtn = new JButton("clear");
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/");
		logBtn = new JButton("log");
		sinBtn = new JButton("sin");
		cosBtn = new JButton("cos");
		tanBtn = new JButton("tan");
		exponBtn = new JButton("e^x");
		radianBtn = new JButton("radian");
		sqrtBtn = new JButton("squre root");
		powBtn = new JButton("power");

		equalBtn = new JButton("=");

		clearBtn.addActionListener(this);
		addBtn.addActionListener(this);
		subBtn.addActionListener(this);
		mulBtn.addActionListener(this);
		divBtn.addActionListener(this);
		logBtn.addActionListener(this);
		sinBtn.addActionListener(this);
		cosBtn.addActionListener(this);
		tanBtn.addActionListener(this);
		exponBtn.addActionListener(this);
		equalBtn.addActionListener(this);
		radianBtn.addActionListener(this);
		sqrtBtn.addActionListener(this);
		powBtn.addActionListener(this);

		numPanel.add(clearBtn);

		numButton = new JButton[10]; // Initialize button 0 to 9

		for (int i = 0; i < numButton.length; i++) {
			numButton[i] = new JButton("" + (i));
			numButton[i].addActionListener(this);
		}
		// add button in frame.
		for (JButton jButton : numButton) {
			numPanel.add(jButton);
		}

		numPanel.add(addBtn);
		numPanel.add(subBtn);
		numPanel.add(mulBtn);
		numPanel.add(divBtn);
		numPanel.add(logBtn);
		numPanel.add(sinBtn);
		numPanel.add(cosBtn);
		numPanel.add(tanBtn);
		numPanel.add(exponBtn);
		numPanel.add(radianBtn);
		numPanel.add(sqrtBtn);
		numPanel.add(powBtn);
		numPanel.add(equalBtn);

		add(inputPanel, BorderLayout.NORTH);
		add(numPanel, BorderLayout.CENTER);
		add(displayPanel, BorderLayout.SOUTH);
	}

	public Double getNum2() {
		Double num2 = 0.0;
		if (!inputTxt.getText().isEmpty()) {
			num2 = Double.parseDouble(inputTxt.getText());
			return num2;
		}
		return -1.0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton clicked = (JButton) e.getSource();
		String txt = clicked.getText();

		try {

			if (e.getSource() == equalBtn) {
				if (inputTxt.getText().equals("")) {
					messLbl.setText("Please! enter number.");
					return;
				}
			}

			if (txt.matches("[0-9]")) {
				inputTxt.setText(inputTxt.getText() + txt);
			}

			if (e.getSource() == clearBtn) {
				inputTxt.setText("");
				dplTxt.setText("");
			}

			if (e.getSource() == addBtn) {
				num1 = Double.parseDouble(inputTxt.getText());
				inputTxt.setText("");
				operator = "+";
			}

			if (e.getSource() == subBtn) {
				num1 = Double.parseDouble(inputTxt.getText());
				inputTxt.setText("");
				operator = "-";
			}

			if (e.getSource() == mulBtn) {
				num1 = Double.parseDouble(inputTxt.getText());
				inputTxt.setText("");
				operator = "*";
			}

			if (e.getSource() == divBtn) {
				num1 = Double.parseDouble(inputTxt.getText());
				inputTxt.setText("");
				operator = "/";
			}

			if (e.getSource() == sinBtn) {
				String input = inputTxt.getText();
				if (!input.isEmpty()) {
					num1 = Double.parseDouble(input);
					double radiansVal = Math.toRadians(num1);
					result = Math.sin(radiansVal);
					dplTxt.setText(String.valueOf(result));
				} else {
					messLbl.setText("Please enter a number before calculating sine.");
				}
			}

			if (e.getSource() == cosBtn) {
				String input = inputTxt.getText();
				if (!input.isEmpty()) {
					num1 = Double.parseDouble(input);
					double radiansVal = Math.toRadians(num1);
					result = Math.cos(radiansVal);
					dplTxt.setText(String.valueOf(result));
				} else {
					messLbl.setText("Please enter a number before calculating sine.");
				}
			}

			if (e.getSource() == logBtn) {
				String input = inputTxt.getText();
				if (!input.isEmpty()) {
					num1 = Double.parseDouble(input);
					result = Math.log(num1);
					dplTxt.setText(String.valueOf(result));
				} else {
					messLbl.setText("Please enter a number before calculating sine.");
				}
			}

			if (e.getSource() == exponBtn) {
				String input = inputTxt.getText();
				if (!input.isEmpty()) {
					num1 = Double.parseDouble(input);
					result = Math.exp(num1);
					dplTxt.setText(String.valueOf(result));
				} else {
					messLbl.setText("Please enter a number before calculating sine.");
				}
			}
			
			if (e.getSource() == radianBtn) {
				String input = inputTxt.getText();
				if (!input.isEmpty()) {
					num1 = Double.parseDouble(input);
					result = Math.toRadians(num1);
					dplTxt.setText(String.valueOf(result));
				} else {
					messLbl.setText("Please enter a number before calculating sine.");
				}
			}
			
			if (e.getSource() == sqrtBtn) {
				String input = inputTxt.getText();
				if (!input.isEmpty()) {
					num1 = Double.parseDouble(input);
					result = Math.sqrt(num1);
					dplTxt.setText(String.valueOf(result));
				} else {
					messLbl.setText("Please enter a number before calculating sine.");
				}
			}
			
			if (e.getSource() == powBtn) {
				num1 = Double.parseDouble(inputTxt.getText());
				inputTxt.setText("");
				operator = "pow";
			}

			isValid = false;

			if (e.getSource() == equalBtn) {

				if (getNum2() != -1.0) {
					num2 = getNum2();
					isValid = true;
				} else {
					isValid = false;
				}

				switch (operator) {
				case "+":
					if (isValid) {
						result = num1 + num2;
					} else {
						messLbl.setText("Please! enter number.");
						break;
					}
					break;
				case "-":
					if (isValid) {
						result = num1 - num2;
					} else {
						messLbl.setText("Please! enter number.");
						break;
					}
					break;
				case "*":
					if (isValid) {
						result = num1 * num2;
					} else {
						messLbl.setText("Please! enter number.");
						break;
					}
					break;
				case "/":

					if (isValid) {
						if (num2 != 0) {
							result = num1 / num2;
							result = (double) Math.round(result);
						} else {
							messLbl.setText("Can't perform division");
						}
					} else {
						messLbl.setText("Please! enter number.");
						break;
					}
					break;
				
				case "pow" :
					if(isValid) {
						result = Math.pow(num1, num2);
					}else {
						messLbl.setText("Please! enter number.");
						break;
					}
					break;
				
				default:
					messLbl.setText("Invalid input");
				}
				dplTxt.setText(String.valueOf(result));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
