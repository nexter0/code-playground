import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame implements ActionListener {
    Font defaultFont = new Font("Courier New", Font.PLAIN, 20);
    Font buttonFont = new Font("Courier New", Font.BOLD, 16);
    JLabel labelLength1, labelLength2, labelLength3, labelAngle1, labelAngle2, labelAngle3;
    JTextField[] lengthFields = new JTextField[] {new JTextField(), new JTextField(), new JTextField()};
    JTextField[] angleFields = new JTextField[] {new JTextField(), new JTextField(), new JTextField()};
    JButton submitButton;

    public float a, b, c;
    Frame() {
        this.setTitle("Right Triangle Solver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(512, 512);
        this.getContentPane().setBackground(new Color(0xF0F0F0));
        this.setVisible(true);
        this.setLayout(null);
        this.labels();
        this.textFields();
        this.buttons();
    }

    private void labels() {
        labelLength1 = new Label("Length a", 20, 25, 200, 20);
        labelLength2 = new Label("Length b", 20, 95, 200, 20);
        labelLength3 = new Label("Length c", 20, 165, 200, 20);
        labelAngle1 = new Label("Angle α", 200, 25, 200, 20);
        labelAngle2 = new Label("Angle β", 200, 95, 200, 20);
        labelAngle3 = new Label("Angle γ", 200, 165, 200, 20);
        this.add(labelLength1);
        this.add(labelLength2);
        this.add(labelLength3);
        this.add(labelAngle1);
        this.add(labelAngle2);
        this.add(labelAngle3);
    }

    private void textFields() {

        int i = 0;
        for (JTextField field : lengthFields) {
            field.setBounds(20, 50 + i, 100, 25);
            field.setFont(defaultFont);
            field.setText("0");
            this.add(field);
            i += 70;
        }
        i = 0;
        for (JTextField field : angleFields) {
            field.setBounds(200, 50 + i, 100, 25);
            field.setFont(defaultFont);
            field.setText("0");
            this.add(field);
            i += 70;
        }
    }

    private void buttons() {
        submitButton = new JButton();
        submitButton.setBounds(20, 250, 100, 40);
        submitButton.setText("Submit");
        submitButton.addActionListener(this);
        submitButton.setFocusable(false);
        submitButton.setBackground(Color.lightGray);
        submitButton.setFont(buttonFont);
        this.add(submitButton);
    }

    private void validateNumbers(float a, float b, float c) throws IllegalArgumentException {
        if ((a <= 0) || (b <= 0)  || (c <= 0))
            throw new IllegalArgumentException("Non-positive number.");
    }

    private void getLengths() {
        a = Float.parseFloat(lengthFields[0].getText());
        b = Float.parseFloat(lengthFields[1].getText());
        c = Float.parseFloat(lengthFields[2].getText());
        validateNumbers(a, b ,c);
    }

    private void handleInvalidValues() {
        JOptionPane.showMessageDialog(null, "Invalid number. Please enter positive real values.\n" +
                "Use dot as the decimal separator.", "Invalid number", JOptionPane.ERROR_MESSAGE);
        for (JTextField field : lengthFields) {
            field.setText("0");
        }
    }

    private void updateAngleFields(Triangle triangle) {
        angleFields[0].setText(Float.toString(triangle.getAlpha()));
        angleFields[1].setText(Float.toString(triangle.getBeta()));
        angleFields[2].setText(Float.toString(triangle.getGamma()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                getLengths();
                Triangle triangle = new Triangle(a, b, c);
                updateAngleFields(triangle);
                System.out.println(triangle.isRight());
            } catch (Exception ex) {
                handleInvalidValues();
            }
        }
    }
}
