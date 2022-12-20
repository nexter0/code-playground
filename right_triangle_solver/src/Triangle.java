import javax.swing.*;
import java.awt.*;
import java.lang.Math;
public class Triangle {
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.hypotenuse = this.findHypotenuse();
        this.isRight = checkRight();
        if (isRight) {
            alpha = Math.round(Math.toDegrees(Math.asin(a / hypotenuse)) * 100) / 100.0;
            beta =  Math.round(Math.toDegrees(Math.asin(b / hypotenuse)) * 100) / 100.0;
            gamma = 90.0;
        }
    }

    private double findHypotenuse() {
        double ht = c;
        if (a > c)
            ht = a;
        if ((b > a) && (b > c))
            ht = b;
        return ht;
    }

    private boolean checkRight() {
        if (hypotenuse == a)
            return Math.round(Math.pow(b, 2) * 100) / 100.0  + Math.round(Math.pow(c, 2) * 100) / 100.0 == Math.round(Math.pow(hypotenuse, 2) * 100) / 100.0;
        if (hypotenuse == b)
            return Math.round(Math.pow(a, 2) * 100) / 100.0  + Math.round(Math.pow(c, 2) * 100) / 100.0 == Math.round(Math.pow(hypotenuse, 2) * 100) / 100.0;
        if (hypotenuse == c) {
            System.out.println(Math.round(Math.pow(a, 2) * 100) / 100.0);
            System.out.println(Math.round(Math.pow(b, 2) * 100) / 100.0);
            System.out.println(Math.round(Math.pow(hypotenuse, 2) * 100) / 100.0);
            return Math.round(Math.pow(a, 2) * 100) / 100.0 + Math.round(Math.pow(b, 2) * 100) / 100.0 == Math.round(Math.pow(hypotenuse, 2) * 100) / 100.0;
        }
        return false;
    }

    public static class TriangleImage extends JPanel {

        TriangleImage(Triangle t) {
            setBounds(170, 250, 200, 200);
            setBackground(Color.white);
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            setVisible(true);
            repaint();
            triangle = t;
        }
        private static void drawRightTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
            Graphics2D g2 = (Graphics2D) g;
            int WIDTH = 200;
            int HEIGHT = 200;
            int step = 10;
            g2.setColor(Color.lightGray);
            for (int i = 0; i < WIDTH; i += step) {
                g2.drawLine(i, 0, i, HEIGHT);
            }
            for (int i = 0; i < HEIGHT; i += step) {
                g2.drawLine(0, i, WIDTH, i);
            }
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(x1, y1, x2, y2);
            g2.drawLine(x2, y2, x3, y3);
            g2.drawLine(x3, y3, x1, y1);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x1 = 50;
            int y1 = 50;
            int x2 = 50 + 10 * (int) triangle.getA();
            int y2 = 50;
            int x3 = 50;
            int y3 = 50 + 10 * (int) triangle.getB();
            drawRightTriangle(g, x1, y1, x2, y2, x3, y3);
        }
            Triangle triangle;
    }

    public void setA(double a) {
        if (a <= 0)
            throw new IllegalArgumentException();
        this.a = a;
    }

    public void setB(double b) {
        if (b <= 0)
            throw new IllegalArgumentException();
        this.b = b;
    }

    public void setC(double c) {
        if (c <= 0)
            throw new IllegalArgumentException();
        this.c = c;
    }

    public void setAlpha(double alpha) {
        if ((alpha <= 0) || (alpha >= 180))
            throw new IllegalArgumentException();
        this.alpha = alpha;
    }

    public void setBeta(double beta) {
        if ((beta <= 0) || (beta >= 180))
            throw new IllegalArgumentException();
        this.beta = beta;
    }

    public void setGamma(double gamma) {
        if ((gamma <= 0) || (gamma >= 180))
            throw new IllegalArgumentException();
        this.gamma = gamma;
    }

    public void setHypotenuse(double hypotenuse) {
        if (hypotenuse <= 0)
            throw new IllegalArgumentException();
        this.hypotenuse = hypotenuse;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    public boolean isRight() {
        return isRight;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public double getGamma() {
        return gamma;
    }

    private double a, b, c;
    private double alpha, beta, gamma;
    private double hypotenuse;
    private boolean isRight;
}
