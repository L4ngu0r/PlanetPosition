package fr.languor.model;

/**
 * Primary orbitale elements
 * <p>
 * N = longitude of the ascending node
 * i = inclination to the ecliptic (plane of the Earth's orbit)
 * w = argument of perihelion
 * a = semi-major axis, or mean distance from Sun
 * e = eccentricity (0=circle, 0-1=ellipse, 1=parabola)
 * M = mean anomaly (0 at perihelion; increases uniformly with time)
 * <p>
 * <p>
 * Related orbital elements
 * <p>
 * w1 = N + w   = longitude of perihelion
 * L  = M + w1  = mean longitude
 * q  = a*(1-e) = perihelion distance
 * Q  = a*(1+e) = aphelion distance
 * P  = a ^ 1.5 = orbital period (years if a is in AU, astronomical units)
 * T  = Epoch_of_M - (M(deg)/360_deg) / P  = time of perihelion
 * v  = true anomaly (angle between position and perihelion)
 * E  = eccentric anomaly
 */
public class Element {

    private double N;
    private double i;
    private double w;
    private double a;
    private double e;
    private double M;

    public Element(double n, double i, double w, double a, double e, double m) {
        N = Math.toRadians(n);
        this.i = Math.toRadians(i);
        this.w = Math.toRadians(w);
        this.a = a;
        this.e = e;
        M = Math.toRadians(m);
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getM() {
        return M;
    }

    public void setM(double m) {
        M = m;
    }

    @Override
    public String toString() {
        return "Element{" +
                "N=" + N +
                ", i=" + i +
                ", w=" + w +
                ", a=" + a +
                ", e=" + e +
                ", M=" + M +
                '}';
    }
}
