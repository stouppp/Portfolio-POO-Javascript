package model;

public class Driver extends Person {
    private int nb_prizes;
    private int nb_withdrawals;

    public Driver() {
        super();
        this.nb_prizes =0;
        this.nb_withdrawals = 0;
    }

    public Driver(int nb_prizes, int nb_withdrawals) {
        super();
        this.nb_prizes = nb_prizes;
        this.nb_withdrawals = nb_withdrawals;
    }

    public Driver(String first_name, String last_name, String adress) {
        super(first_name,last_name,adress);
        this.nb_prizes =0;
        this.nb_withdrawals = 0;
    }

    public Driver(String first_name, String last_name, String adress, int nb_prizes, int nb_withdrawals) {
        super(first_name,last_name,adress);
        this.nb_prizes = nb_prizes;
        this.nb_withdrawals = nb_withdrawals;
    }

    public int getNb_prizes() {
        return nb_prizes;
    }

    public int getNb_withdrawals() {
        return nb_withdrawals;
    }

    public void incNb_prizes() {
        this.nb_prizes ++;
    }

    public void decNb_prizes() {
        if (this.nb_prizes >=1)this.nb_prizes --;
    }

    public void incNb_withdrawals(){
        this.nb_withdrawals ++;
    }

    public void setNb_withdrawals(int nb_withdrawals) {
        this.nb_withdrawals = nb_withdrawals;
    }

    @Override
    public boolean isCompatible(Car c) {
        return c instanceof Formula1;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", nb_prizes='" + nb_prizes + '\'' +
                ", nb_withdrawals=" + nb_withdrawals +
                '}';
    }

    public static void main(String[] args) {
        /*Driver D1 = new Driver();
        Driver D2 = new Driver(5,2);
        Driver D3 = new Driver("Luka", "STOUPY", "Lille");
        Driver D4 = new Driver("Laure", "DE BORTOLI", "Lille", 3,3);
        System.out.println(D1.toString());
        System.out.println(D2.toString());
        System.out.println(D3.toString());
        System.out.println(D4.toString());
        Car C3 = new Car("Lambo");
        System.out.println(D3.assign(C3));
        System.out.println(D3.toString());
        D3.incNb_prizes();
        System.out.println(D3.toString());
        D3.decNb_prizes();
        System.out.println(D3.toString());
        D3.decNb_prizes();
        System.out.println(D3.toString());
        System.out.println(D3.isCompatible(C3));
        Formula1 F3 = new Formula1();
        Truck T3 = new Truck();
        System.out.println(D3.isCompatible(F3));
        System.out.println(D3.isCompatible(T3));

        System.out.println("\n");

        Driver D10 = new Driver();
        Driver D11 = new Driver();;
        Formula1 F10 = new Formula1();
        Truck T11 = new Truck();
        System.out.println(D10.toString());
        System.out.println(D10.assign(F10));
        System.out.println(D10.toString());

        System.out.println("\n");

        System.out.println(D11.toString());
        System.out.println(D11.assign(T11));
        System.out.println(D11.toString());*/

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
