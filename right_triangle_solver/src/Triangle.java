import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.lang.Math;
public class Triangle {
    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.hypotenuse = this.findHypotenuse();
        this.isRight = checkRight();
        if (isRight) {
            this.alpha = Math.round(Math.toDegrees(Math.asin(a / hypotenuse)) * 100) / 100.0;
            this.beta =  Math.round(Math.toDegrees(Math.asin(b / hypotenuse)) * 100) / 100.0;
            this.gamma = 90.0;
        }
    }

    private double findHypotenuse() {
        double ht = this.c;
        if (this.a > this.c)
            ht = this.a;
        if ((this.b > this.a) && (this.b > this.c))
            ht = this.b;
        return ht;
    }

    private boolean checkRight() {
        if (hypotenuse == a)
            return Math.round(Math.pow(this.b, 2) * 100) / 100.0  + Math.round(Math.pow(this.c, 2) * 100) / 100.0 == Math.round(Math.pow(this.hypotenuse, 2) * 100) / 100.0;
        if (hypotenuse == b)
            return Math.round(Math.pow(this.a, 2) * 100) / 100.0  + Math.round(Math.pow(this.c, 2) * 100) / 100.0 == Math.round(Math.pow(this.hypotenuse, 2) * 100) / 100.0;
        if (hypotenuse == c) {
            System.out.println(Math.round(Math.pow(this.a, 2) * 100) / 100.0);
            System.out.println(Math.round(Math.pow(this.b, 2) * 100) / 100.0);
            System.out.println(Math.round(Math.pow(this.hypotenuse, 2) * 100) / 100.0);
            return Math.round(Math.pow(this.a, 2) * 100) / 100.0 + Math.round(Math.pow(this.b, 2) * 100) / 100.0 == Math.round(Math.pow(this.hypotenuse, 2) * 100) / 100.0;
        }
        return false;
    }

    public static class TriangleImage extends JPanel {

        TriangleImage() {
            setSize(new Dimension(200,200));
            setVisible(true);
            repaint();
        }
        private static void drawRightTriangle(Graphics g, double x1, double y1, double x2, double y2, double x3, double y3) {
            Graphics2D g2 = (Graphics2D) g;
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
            g2.draw(new Line2D.Double(x2, y2, x3, y3));
            g2.draw(new Line2D.Double(x3, y3, x1, y1));
        }

        public void paintComponent(Graphics g, Triangle triangle) {
            super.paintComponent(g);
            double x1 = 300;
            double y1 = 20;
            double x2 = 300 + (triangle.getA() * 20);
            double y2 = 20;
            double x3 = 300;
            double y3 = 20  + (triangle.getB() * 20);
            drawRightTriangle(g, x1, y1, x2, y2, x3, y3);
        }

    }

    public void setA(float a) {
        if (a <= 0)
            throw new IllegalArgumentException();
        this.a = a;
    }

    public void setB(float b) {
        if (b <= 0)
            throw new IllegalArgumentException();
        this.b = b;
    }

    public void setC(float c) {
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
