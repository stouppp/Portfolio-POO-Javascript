package routing;

import exceptions.ExceptionQuantity;
import planning.*;
import network.*;

import java.io.*;
import java.util.*;

public class Routing {
    private Depot depot;
    private Set<Client> myClients;
    private Planning planning;
    private int vehiclesCapacity;

    public Routing(int vehiclesCapacity) {
        this.vehiclesCapacity = vehiclesCapacity;
        depot = new Depot();
        myClients = new HashSet<>();
        planning = new Planning(vehiclesCapacity);
    }

    public Routing(Depot depot, int vehiclesCapacity) {
        this(vehiclesCapacity);
        this.depot = depot;
    }

    public Depot getDepot() {
        return depot;
    }

    public Set<Client> getMyClients() {
        return myClients;
    }

    public Planning getPlanning() {
        return planning;
    }

    public int getVehiclesCapacity() {
        return vehiclesCapacity;
    }

    private void creationClientsTest1() {
        try {
            Client c0 = new Client((float) -99.7497, (float) 12.7171, 4);
            Client c1 = new Client((float) 61.7481, (float) 17.0019, 10);
            Client c2 = new Client((float) -29.9417, (float) 79.1925, 17);
            Client c3 = new Client((float) 49.321, (float) -65.1784, 18);
            Client c4 = new Client((float) 42.1003, (float) 2.70699, 7);
            Client c5 = new Client((float) -97.0031, (float) -81.7194, 8);
            Client c6 = new Client((float) -70.5374, (float) -66.8203, 20);
            Client c7 = new Client((float) -10.8615, (float) -76.1834, 1);
            Client c8 = new Client((float) -98.2177, (float) -24.424, 11);
            Client c9 = new Client((float) 14.2369, (float) 20.3528, 13);
            myClients.clear();
            myClients.add(c0);
            myClients.add(c1);
            myClients.add(c2);
            myClients.add(c3);
            myClients.add(c4);
            myClients.add(c5);
            myClients.add(c6);
            myClients.add(c7);
            myClients.add(c8);
            myClients.add(c9);
        } catch (ExceptionQuantity ex) {

        }
    }

    private void initialiseRoutes() {
        Set<Point> myDestinations = new HashSet<>();
        for (Client client : myClients) {
            myDestinations.add(client);
        }
        depot.addRoutes(myDestinations);

        myDestinations.add(depot);
        for (Point p : myDestinations) {
            p.addRoutes(myDestinations);
        }
    }

    private void basicPlanning(){
        planning.basicPlanning(depot, myClients);
    }

    public static void test(){
        Routing routing = new Routing(50);
        routing.creationClientsTest1();
        routing.initialiseRoutes();
        routing.basicPlanning();
        System.out.println(routing.getPlanning().getNbBoxesDeliveredTotal());
        try {
            routing.printPlanning("test.txt");
            routing.readInstance("test.txt");
        } catch (FileNotFoundException ex){

        }catch (IOException e) {

        }
    }

    public void printPlanning(String outputFile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(outputFile);
        pw.print(getPlanning().getTours().size() + "," + getPlanning().getDistanceTotal() + "," + getPlanning().getNbBoxesDeliveredTotal());
        pw.close();
    }

    public void readInstance(String inputFile) throws IOException {
        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line!=null){
            System.out.println(line);
            line = br.readLine();

        }
    }


    public static void main(String[] args) {
        test();

    }

}
