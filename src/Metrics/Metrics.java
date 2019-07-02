package Metrics;

public class Metrics {

    public static double chooseMetric(int x1, int y1, int x2, int y2, boolean metric){
        if(metric) {

            return euclid(x1, y1, x2, y2);
        }
        else {
            return manhattan(x1, y1, x2, y2);
        }
    }

    public static double manhattan(int x1, int y1, int x2, int y2){
        double a = Math.abs(x1-x2)+Math.abs(y1-y2);
        System.out.println("we in manhattan, " + a);
        return a;
    }
    public static double euclid(int x1, int y1, int x2, int y2){

        double sqrt = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
        System.out.println("we in euclid, " + sqrt);
        return sqrt;
    }
}
