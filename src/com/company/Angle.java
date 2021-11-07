package com.company;

public record Angle(Side s1, Side s2) {

    public double getDiameter() {
        Side diameter = new Side(s1.getP1(), s2.getP2());
        return diameter.distance();
    }

    public double getAngle() {
        double ab = Math.abs(Math.pow(s1.distance(), 2));
        double ad = Math.abs(Math.pow(s2.distance(), 2));
        double bd = Math.abs(Math.pow(getDiameter(), 2));
        return Math.pow(Math.cos((ab + ad - bd) / (2 * ab * ad)), -1);
    }

    @Override
    public String toString() {
        return "Angle{" +
                "s1=" + s1.toString() +
                ", s2=" + s2.toString() +
                '}';
    }
}
