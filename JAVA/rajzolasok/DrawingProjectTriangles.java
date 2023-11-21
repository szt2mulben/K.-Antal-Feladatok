import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class DrawingProjectTriangles {
    public static void draw(Graphics g) {

        Point2D p1 = new Point(0,400);
        Point2D p2 = new Point(20,400);
        Point2D p3 = new Point(10,380);

        Polygon triangle = Triangle( p1, p2, p3);
        drawPyramid(triangle, 21, g);
    }

    public static Polygon Triangle(Point2D p1,Point2D p2,Point2D p3) {
        int[] xPoints = {(int)p1.getX(),(int)p2.getX(),(int)p3.getX()};
        int[] yPoints = {(int)p1.getY(),(int)p2.getY(),(int)p3.getY()};

        Polygon triangle = new Polygon(xPoints, yPoints, xPoints.length);
        return triangle;
    }

    public static void TriangleRow(Polygon polygon,int rowSize,Graphics g) {
        g.drawPolygon(polygon);
        double distance = DistanceOfTwoPoints(new Point(polygon.xpoints[0],polygon.ypoints[0]),
                                            new Point(polygon.xpoints[1],polygon.ypoints[1]));

        Polygon translatePolygon = polygon;
        for (int i = 1; i < rowSize; i++) {
            for (int j = 0; j < translatePolygon.npoints; j++) {
                translatePolygon.xpoints[j] += distance;
            }
            g.drawPolygon(translatePolygon);
        }
    }

    public static double DistanceOfTwoPoints(Point2D p1,Point2D p2) {
        double k1 = Math.pow((p1.getX() - p2.getX()),2);
        double k2 = Math.pow((p1.getY() - p2.getY()),2);
        return Math.sqrt(k1 + k2);
    }

    public static Point2D MidPoint(Point2D p1,Point2D p2) {
        return new Point((int)(p1.getX() + p2.getX())/ 2,(int)(p1.getY() + p2.getY())/2);
    }

    public static void drawPyramid(Polygon polygon,int initialRowSize,Graphics g) {
        Polygon translatePolygon = polygon;
        int[] originalXPoints = new int[polygon.npoints];

        for (int i = 0; i < originalXPoints.length; i++) {
            originalXPoints[i] = polygon.xpoints[i];
        }
        Point2D midPoint = MidPoint(new Point(polygon.xpoints[0],polygon.ypoints[0]),
                                        new Point(polygon.xpoints[1],polygon.ypoints[1]));
        double heightDistance = DistanceOfTwoPoints(midPoint, new Point(translatePolygon.xpoints[2],translatePolygon.ypoints[2]));

        double distance = DistanceOfTwoPoints(new Point(polygon.xpoints[0],polygon.ypoints[0]),
                                            new Point(polygon.xpoints[1],polygon.ypoints[1]));


        for (int i = 1; i < initialRowSize; i++) {
            TriangleRow(translatePolygon,initialRowSize-i,g);
            for (int j = 0; j < translatePolygon.npoints; j++) {
                translatePolygon.ypoints[j] -= heightDistance;
                translatePolygon.xpoints[j] = originalXPoints[j] + (int)(distance/2)*i;
            }
        }
    }

    public static void main(String[] args) {  
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(400, 400));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }  

    static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }
}

}