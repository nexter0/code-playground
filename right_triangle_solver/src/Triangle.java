import java.lang.Math;
public class Triangle {
    float a, b, c;
    float hypotenuse;

    Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.hypotenuse = this.findHypotenuse();
    }

    private float findHypotenuse() {
        float hypotenuse = this.c;
        if (this.a > this.c)
            hypotenuse = this.a;
        if ((this.b > this.a) && (this.b > this.c))
                hypotenuse = this.b;
        return hypotenuse;
    }
}
