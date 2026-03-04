package model;

public abstract class Person {
    private static int last_id_number;
    private int id_number;
    private String first_name;
    private String last_name;
    private String adress;
    private Car vehicle = null;
    public Person(){
        last_id_number++;
        this.id_number = last_id_number;
        this.first_name = "John";
        this.last_name = "DOE";
        this.adress = "Zone 51";
    }

    public Person(String first_name,String last_name,String adress) {
        this();
        this.last_name = last_name;
        this.first_name = first_name;
        this.adress = adress;
    }


    public boolean isPedestrian() {
        if (vehicle == null) return true;
        return false;
    }

    public boolean assign(Car c) {
        if (c!=null && this!=null && c.isAvailable() && isPedestrian() && isCompatible(c)) {
            this.vehicle = c;
            c.setDriver(this);
            if(!this.isPedestrian() && !c.isAvailable()) return true;
        }
        return false;
    }

    public boolean returnCar() {
        if (!isPedestrian()) {
            Car c = getCar();
            this.vehicle=null;
            c.setAvailable(this);
            if(isPedestrian()) return true;
        }
        return false;
    }

    public abstract boolean isCompatible (Car c);

    public int getId_number() {
        return id_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getAdress() {
        return adress;
    }

    public Car getCar() {
        return vehicle;
    }

    public void setAdress(String adress) {
        if (adress!=null) this.adress = adress;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id_number=" + id_number +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", adress='" + adress + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }

    public static void main(String[] args) {
        /*Person P0 = new Person();
        Person P1 = new Person();
        Person P2 = new Person();
        Person P3 = new Person("Luka","STOUPY","Lille");
        Person P4 = new Person("Laure","DE BORTOLI","Lille");
        Person P5 = new Person();
        System.out.println(P0.toString());
        System.out.println(P1.toString());
        System.out.println(P2.toString());
        System.out.println(P3.toString());
        System.out.println(P4.toString());
        System.out.println(P5.toString());
        P0.setAdress("NYC");

        System.out.println(P0.toString());
        System.out.println(P1.toString());
        System.out.println(P1.getCar());
        System.out.println(P0.assign(new Car("Mc Laren")));
        System.out.println(P0.toString());
        System.out.println(P0.assign(new Car("lambo")));
        System.out.println(P1.assign(null));
        Car car_same = new Car("Mercedes");
        System.out.println(P3.assign(car_same));
        System.out.println(P4.assign(car_same));

        System.out.println("\n");


        System.out.println(P4.returnCar());
        System.out.println(P3.toString());
        System.out.println(P3.returnCar());
        System.out.println(P3.toString());
        System.out.println(P3.assign(car_same));
        System.out.println(P3.toString());

        System.out.println("\n");

        Driver D10 = new Driver();
        Formula1 F10 = new Formula1();
        Truck T10 = new Truck();
        System.out.println(D10.toString());
        System.out.println(D10.assign(F10));
        System.out.println(D10.toString());*/

        Driver D1 = new Driver();
        Technician T1 = new Technician();
        Formula1 F1 = new Formula1();
        Truck Truck1 = new Truck();
        System.out.println(D1.isCompatible(F1));
        System.out.println(D1.isCompatible(Truck1));
        System.out.println(T1.isCompatible(F1));
        System.out.println(T1.isCompatible(Truck1));


    }
}
