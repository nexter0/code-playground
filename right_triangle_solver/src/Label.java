import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

    Label(String text, int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setText(text);
        this.setFont(new Font("Courier New", Font.BOLD, 16));
    }
}
