package planning;
import network.*;
import java.util.*;

public class Tour {
    private Depot depot;
    private List<Client> sequence;
    private int capacity;
    private float distanceTot;
    private int nbBoxesDelivered;

    public Tour() {
        depot = new Depot();
        sequence = new LinkedList<>();
        capacity = 0;
        distanceTot = 0;
        nbBoxesDelivered = 0;
    }

    public Tour(Depot depot) {
        this();
        if(depot!=null) this.depot = depot;
    }

    public Tour(Depot depot, int capacity) {
        this(depot);
        this.capacity = capacity;
    }

    public Tour(List<Client> sequence) {
        if (sequence !=null) this.sequence = sequence;
    }

    public Tour(Depot depot, List<Client> sequence) {
        this(depot);
        if (sequence !=null) this.sequence = sequence;
    }

    public Tour(Depot depot, List<Client> sequence, int capacity, float distanceTot, int nbBoxesDelivered) {
        this(depot, sequence);
        this.capacity = capacity;
        this.distanceTot = distanceTot;
        this.nbBoxesDelivered = nbBoxesDelivered;
    }

    public Depot getDepot() {
        return depot;
    }

    public List<Client> getSequence() {
        return sequence;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getDistanceTot() {
        return distanceTot;
    }

    public int getNbBoxesDelivered() {
        return nbBoxesDelivered;
    }

    public void setSequence(List<Client> sequence) {
        this.sequence = sequence;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean addClient(Client client){
        if(sequence!=null && client !=null){
            if(client.getNbBoxes() <= capacity){
                sequence.add(client);
                capacity-= client.getNbBoxes();
                nbBoxesDelivered+= client.getNbBoxes();
                if(sequence.size()==1) distanceTot = 2* client.getDistance(depot);
                else distanceTot = distanceTot - sequence.get(sequence.size() -2).getDistance(depot) + sequence.get(sequence.size() -2).getDistance(client) + client.getDistance(depot);
                return true;
            }
        }
        return false;

    }

    public boolean addClient(List<Client> clients){
        for (Client c : clients){
            if (!addClient(c)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "depot=" + depot +
                ", sequence=" + sequence +
                ", capacity=" + capacity +
                ", distanceTot=" + distanceTot +
                ", nbBoxesDelivered=" + nbBoxesDelivered +
                '}';
    }

    public static void main(String[] args) {
        /*Depot d = new Depot(0, 0);
        Client c1 = new Client(5, 5, 10);
        Client c2 = new Client(-5, 5, 10);
        Client c3 = new Client(-5, -5, 10);
        Client c4 = new Client(5, -5, 10);
        Set<Point> setPoint = new HashSet<>();
        setPoint.add(c1);
        setPoint.add(c2);
        setPoint.add(c3);
        setPoint.add(c4);
        d.addRoutes(setPoint);
        setPoint.add(d);
        c1.addRoutes(setPoint);
        c2.addRoutes(setPoint);
        c3.addRoutes(setPoint);
        c4.addRoutes(setPoint);
        List<Client> clients = new ArrayList<>();
        clients.add(c1);
        clients.add(c2);
        clients.add(c3);
        clients.add(c4);
        Tour t = new Tour(d, 40);
        System.out.println(t.addClient(clients));
        System.out.println(t);*/
    }
}
