package network;

import java.util.Objects;
import java.util.List;

public class Route {
    private Point origin;
    private Point destination;
    private float distance;

    public Route() {
        origin = new Client();
        destination = new Client();
        distance = 0;
    }

    public Route(Point origin, Point destination) {
        this();
        this.origin = origin;
        this.destination = destination;
        distance = (float) Math.sqrt(Math.pow((origin.getAbs()-destination.getAbs()),2) + Math.pow((origin.getOrd()-destination.getOrd()),2));
    }

    public Point getOrigin() {
        return origin;
    }

    public Point getDestination() {
        return destination;
    }

    public float getDistance() {
        return distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigin(), getDestination(), getDistance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Route)) return false;
        Route r = (Route) obj;
        if(getOrigin()!=null && getDestination()!=null && this!=null) return getOrigin().equals(r.getOrigin()) && getDestination().equals(r.getDestination()) && getDistance() == r.getDistance();
        return false;
    }


    @Override
    public String toString() {
        return "Route{" +
                "origin=" + getOrigin().getId() +
                ", destination=" + getDestination().getId() +
                ", distance=" + getDistance() +
                '}';
    }

    public static void main(String[] args) {
        /*Point Pa = new Point();
        Point Pb = new Point(3,4);
        Route R0 = new Route();
        Route R1 = new Route(Pa, Pb);
        Route R2 = new Route(Pa, Pb);

        System.out.println(R0.toString());
        System.out.println(R1.toString());
        System.out.println(R0.equals(R1));
        System.out.println(R0.equals(R2));
        System.out.println(R1.equals(R2));
        System.out.println(R0.hashCode());
        System.out.println(R1.hashCode());
        System.out.println(R2.hashCode());*/
    }
}
