package network;

import java.util.*;

public abstract class Point {
    private static int last_id = 0;
    private int id;
    private float abs;
    private float ord;
    private Map<Point,Float> routes_leaving;

    public Point() {
        last_id++;
        id = last_id;
        abs = 0;
        ord = 0;
        routes_leaving = new HashMap<>();
    }

    public Point(float abs, float ord) {
        this();
        this.abs = abs;
        this.ord = ord;
    }

    public int getId() {
        return id;
    }

    public double getAbs() {
        return abs;
    }

    public double getOrd() {
        return ord;
    }

    public Map<Point,Float> getRoutes_leaving() {
        return routes_leaving;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAbs(), getOrd());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        if (this !=null) return getAbs() == p.getAbs() && getOrd() == p.getOrd();
        return false;
    }


    public void addRoutes(Collection<Point> myDestinations){
        if (myDestinations!=null) {
            for (Point p : myDestinations) {
                getRoutes_leaving().put(p,(float) Math.sqrt(Math.pow((getAbs()-p.getAbs()),2) + Math.pow((getOrd()-p.getOrd()),2)));
            }
        }
    }

    public float getDistance(Point p){
        if(getRoutes_leaving().get(p)!=null) return getRoutes_leaving().get(p);
        return (float) Double.POSITIVE_INFINITY;
    }


    public int getNbRoutes(){
        return getRoutes_leaving().size();
    }


    @Override
    public String toString() {
        String s = "Point{" +
                "id=" + id +
                ", abs=" + abs +
                ", ord=" + ord +
                ", routes_leaving= \n[" ;
        for(Point p : getRoutes_leaving().keySet()){
            s+= p.getId() + ",";
        }
        s+= "] \n}";
        return s;
    }

    public static void main(String[] args) {
        /*Point Pa = new Point();
        Point Pb = new Point(3,4);
        Point Pc = new Point(4,5);
        Point Pd = new Point(5,6);
        Point Pe = new Point(6,7);
        Collection<Point> myDestinations = new ArrayList<>();
        myDestinations.add(Pb);
        myDestinations.add(Pc);
        myDestinations.add(Pd);
        myDestinations.add(Pe);
        Pa.addRoutes(myDestinations);
        System.out.println(Pa.toString());
        System.out.println(Pa.getNbRoutes());*/


    }
}
