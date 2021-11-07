package com.company;

public class Side {
    private Point p1;
    private Point p2;

    public Side(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double distance(){
        return Math.abs(Math.sqrt(Math.pow((p1.getX()-p2.getX()), 2) + Math.pow((p1.getY()- p2.getY()), 2)));
    }

    @Override
    public String toString() {
        return "Side{" +
                "p1=" + p1.toString() +
                ", p2=" + p2.toString() +
                '}';
    }
}
