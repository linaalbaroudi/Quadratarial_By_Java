package com.company;

public class Quadrilateral {
    private Point[] points;
    private Side[] sides;
    private double[] angles = new double[4];

    public Quadrilateral(Point[] points, Side[] sides) {
        this.points = points;
        this.sides = sides;
        setAngles();
    }

    public void setAngles() {
        for(int i=0; i<4; i++){
            Angle angle;
            if(i==3){
               angle  = new Angle(sides[i], sides[0]);
            }else{
                angle = new Angle(sides[i], sides[i+1]);
            }
            angles[i] = angle.getAngle();
        }
    }

    public Double perimeter(){
        double perimeter = 0;
        for(Side side : sides){
            perimeter += side.distance();
        }
        return perimeter;
    }

    public Double area(){
        double ab = sides[0].distance();
        double bc = sides[1].distance();
        double cd = sides[2].distance();
        double ad = sides[3].distance();
        Angle a1 = new Angle(sides[0], sides[3]);
        System.out.println("a1 ==> "+a1.getAngle());
        Angle a2 = new Angle(sides[1], sides[2]);
        System.out.println("a2 ==> "+a2.getAngle());
        return ((ab * ad * Math.sin(a1.getAngle()))/2) + ((bc * cd * Math.sin(a2.getAngle()) )/2) ;
    }

    public double maxQuadAngle(){
        double max = angles[0] ;
        for(int i=1; i<angles.length; i++){
            if(angles[i] > max){
                max = angles[i];
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "Quadrilateral{\n- sides: [ " + sides[0].distance() + ", " + sides[1].distance() + ", " + sides[2].distance() + ", " + sides[3].distance() + ", "
                + "]\n- angles: [ " + angles[0] + ", " + angles[1] + ", " + angles[2] + ", " + angles[3] + "]\n- perimeter: " + perimeter() +
                "\n- area: " + area() +
                '}';
    }}
