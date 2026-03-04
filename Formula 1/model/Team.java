package model;

import java.util.Arrays;

public class Team {
    private String name;
    private Person [] staff = new Person[5];
    private Car [] fleet = new Car[5];


    public Team(String name) {
        this.name = name;
    }

    public boolean isPresent(Person p){
        Person[] tab = getStaff();
        for(int i=0;i<5;i++){
            if(tab[i]!=null){
                if(tab[i].getId_number() == p.getId_number()) return true;
            }
        }
        return false;
    }

    public boolean isPresent(Car c){
        Car[] tab = getFleet();
        for(int i=0;i<5;i++){
            if(tab[i]!=null){
                if(tab[i].getReg_number() == c.getReg_number()) return true;
            }
        }
        return false;
    }

    public boolean hire(Person p){
        if(isPresent(p)) return false;
        Person[] tab = getStaff();
        for(int i =0;i<5;i++){
            if(tab[i]==null){
                tab[i] = p;
                return true;
            }
        }
        return false;
    }

    public boolean buy(Car c){
        if(isPresent(c)) return false;
        Car[] tab = getFleet();
        for(int i =0;i<5;i++){
            if(tab[i]==null){
                tab[i] = c;
                return true;
            }
        }
        return false;
    }

    private Person findPerson(int id){
        Person[] tab = getStaff();
        for(int i=0;i<5;i++){
            if(tab[i]!=null){
                if(tab[i].getId_number() == id) return tab[i];
            }
        }
        return null;
    }

    private Car findCar(int id){
        Car[] tab = getFleet();
        for(int i=0;i<5;i++){
            if(tab[i]!=null){
                if(tab[i].getReg_number() == id) return tab[i];
            }
        }
        return null;
    }

    public boolean assign(int id, int reg){
        Person p = findPerson(id);
        Car c = findCar(reg);
        if (p!=null && c!=null){
            return (p.assign(c));
        }
        return false;
    }

    public boolean returnCar(int id){
        Person p =findPerson(id);
        if (p!=null && !p.isPedestrian()){
            return p.returnCar();
        }
        return false;
    }


    public String getName() {
        return name;
    }

    public Person[] getStaff() {
        return staff;
    }

    public Car[] getFleet() {
        return fleet;
    }

    public void setName(String name) {
        if (name!=null) this.name = name;
    }



    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", staff=" + Arrays.toString(staff) +
                ", fleet=" + Arrays.toString(fleet) +
                '}';
    }

    public static void main(String[] args) {
        Team T1 = new Team("PSG");
        System.out.println(T1.toString());
        T1.setName("OM");
        System.out.println(T1.toString());
        Driver D1 = new Driver();
        Driver D2 = new Driver();
        Driver D3 = new Driver();
        Driver D4 = new Driver();
        Driver D5 = new Driver();
        Driver D6 = new Driver();
        T1.hire(D1);
        T1.hire(D2);
        T1.hire(D3);
        T1.hire(D4);
        T1.hire(D5);
        System.out.println(T1.toString());
        System.out.println(T1.hire(D1));
        System.out.println(T1.hire(D6));


        Formula1 F1 = new Formula1();
        Formula1 F2 = new Formula1();
        Formula1 F3 = new Formula1();
        Formula1 F4 = new Formula1();
        Formula1 F5 = new Formula1();
        Formula1 F6 = new Formula1();
        T1.buy(F1);
        T1.buy(F2);
        T1.buy(F3);
        T1.buy(F4);
        T1.buy(F5);
        System.out.println(T1.toString());
        System.out.println(T1.buy(F1));
        System.out.println(T1.buy(F6));
        System.out.println(T1.findPerson(1));
        System.out.println(T1.findPerson(6));
        System.out.println(T1.findCar(1));
        System.out.println(T1.findCar(6));


        System.out.println(T1.getFleet()[0].getDriver());
        System.out.println(T1.assign(1,1));
        System.out.println(T1.toString());
        System.out.println(T1.getFleet()[0].getDriver());

        System.out.println(T1.getFleet()[1].getDriver());
        System.out.println(T1.assign(1,2));
        System.out.println(T1.toString());
        System.out.println(T1.getFleet()[1].getDriver());


        System.out.println(T1.assign(2,6));
        System.out.println(T1.assign(6,2));


        System.out.println(T1.getStaff()[0].toString());
        System.out.println(T1.returnCar(1));
        System.out.println(T1.getStaff()[0].toString());

        System.out.println(T1.getStaff()[1].toString());
        System.out.println(T1.returnCar(1));
        System.out.println(T1.getStaff()[1].toString());


    }
}
