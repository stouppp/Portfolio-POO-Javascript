package model;

public class Truck extends Car{
    private int tonnage;

    public Truck() {
        super();
        this.tonnage = 0;
    }

    public Truck(int tonnage) {
        this.tonnage = tonnage;
    }

    public Truck(String brand, Engine engine, int tonnage) {
        super(brand, engine);
        this.tonnage = tonnage;
    }

    public Truck(int reg_number, String brand, Engine engine, int tonnage) {
        super(reg_number, brand, engine);
        this.tonnage = tonnage;
    }

    public int getTonnage() {
        return tonnage;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tonnage=" + tonnage +
                '}';
    }

    public static void main(String[] args) {
        /*Truck T1 = new Truck();
        Truck T2 = new Truck(15);
        Truck T3 = new Truck("Volvo", new Engine(), 10);
        Truck T8 = new Truck(8, "Veco", new Engine('D', 1500), 20);
        System.out.println(T1.toString());
        System.out.println(T2.toString());
        System.out.println(T3.toString());
        System.out.println(T8.toString());*/
    }
}
