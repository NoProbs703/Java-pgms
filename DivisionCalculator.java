import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivisionCalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Integer Division Calculator");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNum1 = new JLabel("Num1:");
        JLabel labelNum2 = new JLabel("Num2:");
        JLabel labelResult = new JLabel("Result:");

        JTextField textNum1 = new JTextField(10);
        JTextField textNum2 = new JTextField(10);
        JTextField textResult = new JTextField(10);
        textResult.setEditable(false);

        JButton buttonDivide = new JButton("Divide");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.add(labelNum1);
        panel.add(textNum1);
        panel.add(labelNum2);
        panel.add(textNum2);
        panel.add(labelResult);
        panel.add(textResult);
        panel.add(buttonDivide);

        frame.add(panel);
        frame.setVisible(true);

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(textNum1.getText());
                    int num2 = Integer.parseInt(textNum2.getText());

                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    int result = num1 / num2;

                    textResult.setText(String.valueOf(result));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid integers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Arithmetic Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
