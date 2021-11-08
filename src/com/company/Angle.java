package com.company;

public record Angle(Side s1, Side s2) {

    public double getDiameter() {
        Side diameter = new Side(s1.getP1(), s2.getP2());
        return diameter.distance();
    }

    public double getAngle() {
        double ab = s1.distance();
        double ad = s2.distance();
        double bd = getDiameter();
        double angle = Math.acos( ( Math.abs(Math.pow(ab,2)) + Math.abs(Math.pow(ad,2)) - Math.abs(Math.pow(bd,2)) ) / (2*ab*ad) );
        return angle;
    }

    @Override
    public String toString() {
        return "Angle{" +
                "s1=" + s1.toString() +
                ", s2=" + s2.toString() +
                '}';
    }
}
