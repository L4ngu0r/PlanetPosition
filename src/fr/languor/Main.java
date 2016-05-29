package fr.languor;

import fr.languor.factory.FactoryElement;
import fr.languor.model.Element;
import fr.languor.model.ElementEnum;
import fr.languor.model.Position;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.stjarnhimlen.se/comp/ppcomp.html
 * <p>
 * System solar geocentric position
 */
public class Main {
    public static double getDay(int year, int month, int day, int hour) {
        return 367 * year - 7 * (year + (month + 9) / 12) / 4 + 275 * month / 9 + day - 730530 + hour / 24.0;
    }

    public static Position computePosition(Element element) {
        double N = element.getN();
        double i = element.getI();
        double w = element.getW();
        double a = element.getW();
        double e = element.getE();
        double M = element.getM();

        // Eccentric anomaly from the Mean anomaly
        double E = M + e * Math.sin(M) * (1.0 + e * Math.cos(M));

        // Compute the planet's distance and true anomaly
        double xv = a * (Math.cos(E) - e);
        double yv = a * (Math.sqrt(1.0 - e * e) * Math.sin(E));

        double v = Math.atan2(yv, xv);
        double r = Math.sqrt(xv * xv + yv * yv);

        // Compute the planet's position in 3-dimensional space
        double xh = r * (Math.cos(N) * Math.cos(v + w) - Math.sin(N) * Math.sin(v + w) * Math.cos(i));
        double yh = r * (Math.sin(N) * Math.cos(v + w) + Math.cos(N) * Math.sin(v + w) * Math.cos(i));
        double zh = r * (Math.sin(v + w) * Math.sin(i));

        // Compute the ecliptic longitude and latitude
        double lonecl = Math.atan2(yh, xh);
        double latecl = Math.atan2(zh, Math.sqrt(xh * xh + yh * yh));

        return new Position(r, v, xh, yh, w, lonecl, latecl);
    }

    public static double computeGeocentricAlign(Element element, double day) {
        Position sunPosition = Main.computePosition(new FactoryElement().getElement(ElementEnum.Sun, day));
        Position planetPosition = Main.computePosition(element);

        // Compute the Sun's true longitude
        double lonsun = sunPosition.getV() + sunPosition.getW();

        // Convert lonsun,r to ecliptic rectangular geocentric coordinates xs,ys
        double xs = sunPosition.getR() * Math.cos(lonsun);
        double ys = sunPosition.getR() * Math.sin(lonsun);

        double xh = planetPosition.getXh();
        double yh = planetPosition.getYh();

        // Convert from heliocentric to geocentric position
        double xg = xh + xs;
        double yg = yh + ys;

        double helio_degree = Math.toDegrees(Math.atan2(xh, yh));
        double geo_degree = Math.toDegrees(Math.atan2(xg, yg));

        helio_degree = 90 - helio_degree;
        geo_degree = 90 - geo_degree;

        if (helio_degree < 0) {
            helio_degree = helio_degree + 360;
        }

        if (geo_degree < 0) {
            geo_degree = geo_degree + 360;
        }

        return geo_degree;

    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);

        System.out.println(calendar.getTime());

        // get day
        double d = Main.getDay(year, month + 1, day, hour);
        System.out.println("getDay = " + d);

        FactoryElement factoryElement = new FactoryElement();
        ArrayList<Element> arrayElement = new ArrayList<>();
        Map<Integer, Double> alignments = new HashMap<>();

        // create element
        for (ElementEnum elementEnum : ElementEnum.values()) {
            arrayElement.add(factoryElement.getElement(elementEnum, d));
        }

        //compute alignments
        for (int i = 0; i < arrayElement.size(); i++) {
            Element tempE = arrayElement.get(i);
            alignments.put(i, Main.computeGeocentricAlign(tempE, d));
        }

        // print results
        for (Map.Entry<Integer, Double> entry : alignments.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}
