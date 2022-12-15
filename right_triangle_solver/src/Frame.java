import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame implements ActionListener {
    Font defaultFont = new Font("Courier New", Font.BOLD, 16);
    JLabel label1, label2, label3;
    JTextField[] lengthPromptFields = new JTextField[] {new JTextField(), new JTextField(), new JTextField()};
    JButton submitButton;

    public float a, b, c;
    Frame() {
        this.setTitle("Right Triangle Solver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(512, 512);
        this.getContentPane().setBackground(new Color(0xFFFFFF));
        this.setVisible(true);
        this.setLayout(null);
        this.labels();
        this.textFields();
        this.buttons();
    }

    private void labels() {
        label1 = new Label("Enter length a", 20, 20, 200, 20);
        label2 = new Label("Enter length b", 20, 90, 200, 20);
        label3 = new Label("Enter length c", 20, 160, 200, 20);
        this.add(label1);
        this.add(label2);
        this.add(label3);
    }

    private void textFields() {

        int i = 0;
        for (JTextField field : lengthPromptFields) {
            field.setBounds(20, 50 + i, 100, 30);
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

        this.add(submitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                a = Float.parseFloat(lengthPromptFields[0].getText());
                b = Float.parseFloat(lengthPromptFields[1].getText());
                c = Float.parseFloat(lengthPromptFields[2].getText());
                System.out.print(Math.atan(a/b)*180/Math.PI + "\n");
            } catch (NumberFormatException ex) {
                System.out.println("bad");
                JOptionPane.showMessageDialog(null, "Invalid number. Please enter positive real values.\n" +
                        "Use dot as the decimal separator.", "Invalid number", JOptionPane.ERROR_MESSAGE);
                for (JTextField field : lengthPromptFields) {
                    field.setText("0");
                }
            }
        }
    }
}
