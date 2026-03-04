package model;

public class Engine {
    private char fuel;
    private int power;
    private static final int POWER_MIN = 600;
    private static final char PETROL = 'P';
    private static final char DIESEL = 'D';

    public Engine() {
        this.fuel = PETROL;
        this.power = POWER_MIN;
    }

    /*public Engine(char fuel, int power) {
        this.fuel = fuel;
        if (power > POWER_MIN) this.power = power;
        else this.power = POWER_MIN;
    }*/


    public Engine(char fuel, int power) { // mieux que la précédente
        this(); // constructor by default
        if (fuel == DIESEL) this.fuel = fuel;
        if (power > POWER_MIN) this.power = power;
    }

    public Engine(Engine m){
        this();
        if (m!=null) {
            this.power = m.power;
            this.fuel = m.fuel;
        }
    }


    public char getFuel() {
        return fuel;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power>POWER_MIN) this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "fuel=" + fuel +
                ", power=" + power +
                '}';
    }



    public static void main (String[] args){
        /*Engine M0 = new Engine();
        Engine M1 = new Engine('D',1000);
        Engine M2 = new Engine(M1);
        System.out.println(M0.toString());
        System.out.println(M1.toString());
        System.out.println(M2.toString());
        System.out.println(M0.getFuel());
        M1.setPower(700);
        System.out.println(M1.getPower());
        System.out.println(M2.getPower());*/
    }
}
