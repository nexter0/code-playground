import java.lang.Math;
public class Triangle {
    private float a, b, c;
    private float alpha, beta, gamma;
    private float hypotenuse;
    private boolean isRight;
    Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.hypotenuse = this.findHypotenuse();
        this.isRight = checkRight();
        if (isRight) {
            this.alpha = (float) Math.round((Math.asin(a / hypotenuse) * 180 / Math.PI) * 100) / 100;
            this.beta = (float) Math.round((Math.asin(b / hypotenuse) * 180 / Math.PI) * 100) / 100;
            this.gamma = 90.0F;
        }
    }

    private float findHypotenuse() {
        float ht = this.c;
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

    public void setAlpha(float alpha) {
        if ((alpha <= 0) || (alpha >= 180))
            throw new IllegalArgumentException();
        this.alpha = alpha;
    }

    public void setBeta(float beta) {
        if ((beta <= 0) || (beta >= 180))
            throw new IllegalArgumentException();
        this.beta = beta;
    }

    public void setGamma(float gamma) {
        if ((gamma <= 0) || (gamma >= 180))
            throw new IllegalArgumentException();
        this.gamma = gamma;
    }

    public void setHypotenuse(float hypotenuse) {
        if (hypotenuse <= 0)
            throw new IllegalArgumentException();
        this.hypotenuse = hypotenuse;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public float getHypotenuse() {
        return hypotenuse;
    }

    public boolean isRight() {
        return isRight;
    }

    public float getAlpha() {
        return alpha;
    }

    public float getBeta() {
        return beta;
    }

    public float getGamma() {
        return gamma;
    }
}
