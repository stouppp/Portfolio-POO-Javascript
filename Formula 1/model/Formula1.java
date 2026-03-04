package model;

public class Formula1 extends Car{
    private String sponsor;

    public Formula1() {
        super();
        this.sponsor = null;
    }

    public Formula1(String brand, String sponsor) {
        super(brand);
        this.sponsor = sponsor;
    }

    public Formula1(int reg_number, String brand, Engine engine) {
        super(reg_number, brand, engine);
    }

    public Formula1(int reg_number, String brand, Engine engine, String sponsor) {
        super(reg_number, brand, engine);
        this.sponsor = sponsor;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        if(sponsor!=null) this.sponsor = sponsor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", sponsor=" + sponsor +
                '}';
    }

    public static void main(String[] args) {
        /*Formula1 F1 = new Formula1();
        Formula1 F2 = new Formula1("Ferrari","lambo");
        Formula1 F5 = new Formula1(5,"lambo", new Engine('D',1000));
        Formula1 F10 = new Formula1(10,"Ferrari", new Engine('D',1500), "lambo");
        System.out.println(F1.toString());
        System.out.println(F2.toString());
        System.out.println(F5.toString());
        System.out.println(F10.toString());
        System.out.println(F5.getReg_number());
        F1.setSponsor("lambo");
        System.out.println(F1.toString());
        */


    }
}
