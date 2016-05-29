package fr.languor.model;

/**
 * r = distance
 * v = true anomaly
 * xh = planet's position on x
 * yh = planet's position on y
 * zh = planet's position on z
 * w = argument of perihelion
 * lonecl = ecliptic longitude
 * latecl = ecliptic latitude
 */
public class Position {

    private double r;
    private double v;
    private double xh;
    private double yh;
    private double w;
    private double lonecl;
    private double latecl;

    public Position(double r, double v, double xh, double yh, double w, double lonecl, double latecl) {
        this.r = r;
        this.v = v;
        this.xh = xh;
        this.yh = yh;
        this.w = w;
        this.lonecl = lonecl;
        this.latecl = latecl;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getXh() {
        return xh;
    }

    public void setXh(double xh) {
        this.xh = xh;
    }

    public double getYh() {
        return yh;
    }

    public void setYh(double yh) {
        this.yh = yh;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getLonecl() {
        return lonecl;
    }

    public void setLonecl(double lonecl) {
        this.lonecl = lonecl;
    }

    public double getLatecl() {
        return latecl;
    }

    public void setLatecl(double latecl) {
        this.latecl = latecl;
    }

    @Override
    public String toString() {
        return "Position{" +
                "r=" + r +
                ", v=" + v +
                ", xh=" + xh +
                ", yh=" + yh +
                ", w=" + w +
                ", lonecl=" + lonecl +
                ", latecl=" + latecl +
                '}';
    }
}
