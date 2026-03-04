package planning;

import network.*;

import java.util.HashSet;
import java.util.Set;

public class Planning {
    private Set<Tour> tours;
    private float distanceTotal;
    private int nbBoxesDeliveredTotal;
    private int capacityVehicles;

    public Planning(int capacityVehicles) {
        this.capacityVehicles = capacityVehicles;
        tours = new HashSet<>();
        distanceTotal=0;
        nbBoxesDeliveredTotal=0;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public float getDistanceTotal() {
        return distanceTotal;
    }

    public int getNbBoxesDeliveredTotal() {
        return nbBoxesDeliveredTotal;
    }

    public int getCapacityVehicles() {
        return capacityVehicles;
    }

    private boolean addTour (Tour t){
        if(t !=null){
            tours.add(t);
            distanceTotal+=t.getDistanceTot();
            nbBoxesDeliveredTotal += t.getNbBoxesDelivered();
            return true;
        }
        return false;
    }

    public void basicPlanning(Depot depot, Set <Client> clients){
        Tour currentTour = new Tour(depot, capacityVehicles);
        for (Client client : clients){
            if(!currentTour.addClient(client)){
                addTour(currentTour);
                currentTour = new Tour(depot, capacityVehicles);
                currentTour.addClient(client);
            }
        }
        addTour(currentTour);
        System.out.println(getTours().size());
    }

    @Override
    public String toString() {
        return "Planning{" +
                "tours=" + tours +
                ", distanceTotal=" + distanceTotal +
                ", nbBoxesDeliveredTotal=" + nbBoxesDeliveredTotal +
                ", capacityVehicles=" + capacityVehicles +
                '}';
    }

    public static void main(String[] args) {
    }
}
