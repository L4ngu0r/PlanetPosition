package fr.languor.factory;

import fr.languor.model.Element;
import fr.languor.model.ElementEnum;

public class FactoryElement {

    public Element getElement(ElementEnum elementEnum, double day) {
        Element element = null;
        switch (elementEnum) {
            case Sun:
                element = new Element(
                        0.0,
                        0.0,
                        282.9404 + 4.70935E-5 * day,
                        1.000000,
                        0.016709 - 1.151E-9 * day,
                        356.0470 + 0.9856002585 * day);
                break;
            case Mercury:
                element =  new Element(
                        48.3313 + 3.24587E-5 * day,
                        7.0047 + 5.00E-8 * day,
                        29.1241 + 1.01444E-5 * day,
                        0.387098,
                        0.205635 + 5.59E-10 * day,
                        168.6562 + 4.0923344368 * day);
                break;
            case Moon:
                element = new Element(
                        125.1228 - 0.0529538083 * day,
                        5.1454,
                        318.0634 + 0.1643573223 * day,
                        60.2666,
                        0.054900,
                        115.3654 + 13.0649929509 * day);
                break;
            case Venus:
                element =  new Element(
                        76.6799 + 2.46590E-5 * day,
                        3.3946 + 2.75E-8 * day,
                        54.8910 + 1.38374E-5 * day,
                        0.723330,
                        0.006773 - 1.302E-9 * day,
                        48.0052 + 1.6021302244 * day);
                break;
            case Mars:
                element =  new Element(
                        49.5574 + 2.11081E-5 * day,
                        1.8497 - 1.78E-8 * day,
                        286.5016 + 2.92961E-5 * day,
                        1.523688,
                        0.093405 + 2.516E-9 * day,
                        18.6021 + 0.5240207766 * day);
                break;
            case Jupiter:
                element =  new Element(
                        100.4542 + 2.76854E-5 * day,
                        1.3030 - 1.557E-7 * day,
                        273.8777 + 1.64505E-5 * day,
                        5.20256,
                        0.048498 + 4.469E-9 * day,
                        19.8950 + 0.0830853001 * day);
                break;
            case Saturn:
                element =  new Element(
                        113.6634 + 2.38980E-5 * day,
                        2.4886 - 1.081E-7 * day,
                        339.3939 + 2.97661E-5 * day,
                        9.55475,
                        0.055546 - 9.499E-9 * day,
                        316.9670 + 0.0334442282 * day);
                break;
            case Uranus:
                element =  new Element(
                        74.0005 + 1.3978E-5 * day,
                        0.7733 + 1.9E-8 * day,
                        96.6612 + 3.0565E-5 * day,
                        19.18171 - 1.55E-8 * day,
                        0.047318 + 7.45E-9 * day,
                        142.5905 + 0.011725806 * day);
                break;
            case Neptune:
                element =  new Element(
                        131.7806 + 3.0173E-5 * day,
                        1.7700 - 2.55E-7 * day,
                        272.8461 - 6.027E-6 * day,
                        30.05826 + 3.313E-8 * day,
                        0.008606 + 2.15E-9 * day,
                        260.2471 + 0.005995147 * day);
                break;
        }
        return element;
    }

}
