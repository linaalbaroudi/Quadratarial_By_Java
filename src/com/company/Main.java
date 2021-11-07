package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int count = 1;
        Quadrilateral[] quads = new Quadrilateral[15];

        //Read 5 quadrilaterals from the user
        print("Enter 5 quadrilaterals");
        while(count<=15){

            //Read from the user 8 integer values representing the x and y coordinates of the quadrilateral 4 points.
            print("Enter 4 points for Quadrilateral number - " + count);
            Point[] points= new Point[4];

            for(int i=0; i<4; i++){
                print("Enter the point " + i + " (x and y values separated by a line): ");
                int x = input.nextInt();
                int y = input.nextInt();
                Point point = new Point(x,y);
                points[i] = point;
            }

            //Compute the lengths of the 4 sides.
            Side[] sides = new Side[4];
            for(int i=0; i<4; i++){
                Side side = new Side( points[i], points[ (i+1)%points.length ]);
                sides[i] = side;
            }

            Quadrilateral quadrilateral = new Quadrilateral(points, sides);

            //Print the quadrilateral 4 sides, 4 interior angles, perimeter and area
            print("Quadrilateral " + count + " : \n" + quadrilateral);

            quads[count-1] = quadrilateral;
            count++;
        }

        //Print the average perimeter of the entered quadrilaterals.
        double average_perimeter = averagePerimeter(quads);
        print("Average Perimeter = " + average_perimeter);

        //Print the average area of the entered quadrilaterals.
        double average_area = averageArea(quads);
        print("Average area = " + average_area);

        //Determine the quadrilateral with the maximum perimeter.
        double max_perimeter = maxPerimeter(quads);
        print("Max Perimeter = " + max_perimeter);

        //Determine the quadrilateral with the maximum area.
        double max_area = maxArea(quads);
        print("Max area = " + max_area);

        //Determine the quadrilateral with the maximum interior angle.
        double max_angle = maxAngle(quads);
        print("Max angle = " + max_angle);
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static double averagePerimeter(Quadrilateral[] quads){
        double sum = 0;
        for (Quadrilateral quad : quads) {
            sum += quad.perimeter();
        }
        return sum / quads.length;
    }

    public static double averageArea(Quadrilateral[] quads){
        double sum = 0;
        for (Quadrilateral quad : quads) {
            sum += quad.area();
        }
        return sum / quads.length;
    }

    public static double maxPerimeter(Quadrilateral[] quads){
        double max = quads[0].perimeter() ;
        for(int i=1; i<quads.length; i++){
            if(quads[i].perimeter() > max){
                max = quads[i].perimeter();
            }
        }
        return max;
    }

    public static double maxArea(Quadrilateral[] quads){
        double max = quads[0].area() ;
        for(int i=1; i<quads.length; i++){
            if(quads[i].area() > max){
                max = quads[i].area();
            }
        }
        return max;
    }

    public static double maxAngle(Quadrilateral[] quads){
        double max_angle = quads[0].maxQuadAngle() ;
        for(int i=1; i<quads.length; i++){
            if(quads[i].maxQuadAngle() > max_angle){
                max_angle = quads[i].maxQuadAngle();
            }
        }
        return max_angle;
    }
}
