public class DistanceAndLine {

    public static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[] { m, b };
    }

    public static void demo() {
        double d = euclideanDistance(0,0,3,4);
        System.out.println("Distance between (0,0) and (3,4): " + d);
        double[] mb = lineEquation(1,2,3,6);
        System.out.printf("Line slope=%.2f intercept=%.2f => y = %.2fx + %.2f%n", mb[0], mb[1], mb[0], mb[1]);
    }
}
