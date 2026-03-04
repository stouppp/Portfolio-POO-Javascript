package network;

import exceptions.ExceptionQuantity;

import java.util.*;



public class Client extends Point{
    private int nbBoxes;

    public Client() {
        super();
        nbBoxes=0;
    }

    public Client(float abs, float ord) {
        super(abs, ord);
        nbBoxes=0;
    }

    public Client(float abs, float ord, int nbBoxes) throws ExceptionQuantity {
        super(abs, ord);
        if(nbBoxes<1) {
            ExceptionQuantity ex = new ExceptionQuantity(nbBoxes, "Error: Exception quantity");
            throw ex;
        } else{
            this.nbBoxes=nbBoxes;
        }

    }

    public int getNbBoxes() {
        return nbBoxes;
    }

    public void setNbBoxes(int nbBoxes) {
        this.nbBoxes = nbBoxes;
    }

    @Override
    public String toString() {
        String s = "Point{" +
                "id=" + getId() +
                ", abs=" + getAbs() +
                ", ord=" + getOrd() +
                ", nbBoxes=" + getNbBoxes() +
                ", routes_leaving= \n[" ;
        for(Point p : getRoutes_leaving().keySet()){
            s+= p.getId() + ",";
        }
        s+= "] \n}";
        return s;
    }

    public static void main(String[] args) {
        try {
            Client c1 = new Client(5, 5, 1);
            System.out.println("Creation ok");
            Client c2 = new Client(5, -5, 0);
            System.out.println("Creation ok");

        } catch (ExceptionQuantity ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());

            if(ex.getQuantity()==0) System.out.println("Quantity = 0 so the program continues");
            else {
                System.out.println("Error : Quantity negative --> The program will terminates");
                System.exit(-1);
            }
        }
        System.out.println("lala");


    }
}

