package model;

public class Technician extends Person{
    private String speciality;

    public Technician() {
        super();
        this.speciality = null;
    }

    public Technician(String speciality) {
        super();
        this.speciality = speciality;
    }

    public Technician(String first_name, String last_name, String adress, String speciality) {
        super(first_name, last_name, adress);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        if (speciality!=null) this.speciality = speciality;
    }

    @Override
    public boolean isCompatible(Car c) {
        return c instanceof Truck;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", speciality=" + speciality +
                '}';
    }

    public static void main(String[] args) {
        /*Technician T1 = new Technician();
        Technician T2 = new Technician("roue");
        Technician T3 = new Technician("Fabrice", "STOUPY","Annecy", "essence");
        System.out.println(T1.toString());
        System.out.println(T2.toString());
        System.out.println(T3.toString());
        T1.setSpeciality("moteur");
        System.out.println(T1.toString());
        System.out.println((T2.getSpeciality()));
        Car C3 = new Car();
        Formula1 F3 = new Formula1();
        Truck t3 = new Truck();
        System.out.println(T3.isCompatible(C3));
        System.out.println(T3.isCompatible(F3));
        System.out.println(T3.isCompatible(t3));*/

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
