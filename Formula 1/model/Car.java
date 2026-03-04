package model;

public abstract class Car {

    private static int last_reg_number = 0;
    private int reg_number;
    private String brand;
    private Engine engine = new Engine();
    private Person driver = null;


    public Car() {
        last_reg_number++;
        this.reg_number = last_reg_number;
        this.brand = "brand";
    }

    public Car(String brand) {
        this();
        if (brand!=null) this.brand = brand;
    }

    public Car(int reg_number, String brand, Engine engine) {
        this();
        if (reg_number >= last_reg_number) this.reg_number = reg_number;
        last_reg_number = reg_number;
        this.brand = brand;
        if (engine != null) this.engine = engine;
    }

    public Car(String brand, Engine engine) {
        this(brand);
        if (engine != null) this.engine = engine;
    }

    public boolean isAvailable() {
        if (driver ==null) return true;
        return false;
    }

    public int getReg_number() {
        return reg_number;
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public Person getDriver() {
        return driver;
    }



    public void setEngine(Engine engine) {
        if (engine != null) this.engine = engine;
    }

    public void setDriver(Person driver) {
        if (driver!=null && isAvailable() && driver.getCar().getReg_number() == this.reg_number) {
            this.driver = driver;
        }
    }

    public void setAvailable(Person driver) {
        if (!isAvailable() && driver.isPedestrian())
            this.driver = null;
    }

    @Override
    public String toString() {
        return "Car{" +
                "reg_number=" + reg_number +
                ", brand='" + brand + '\'' +
                ", engine=" + engine +
                '}';
    }

    public static void main(String[] args) {
        /*Car C0 = new Car();
        Car C1 = new Car();
        Car C2 = new Car("Mc Laren");
        Car C3 = new Car(6,"Mc Laren", new Engine());
        Car C4 = new Car();
        Car C5 = new Car("Mc Laren", new Engine());
        System.out.println(C0.toString());
        System.out.println(C1.toString());
        System.out.println(C2.toString());
        System.out.println(C3.toString());
        System.out.println(C4.toString());
        System.out.println(C5.toString());

        Engine e1 = new Engine(null);
        Engine e2 = new Engine('P', 1000);
        Car c1 = new Car(null, e1);
        Car c2 = new Car("Ferrari", e2);
        Car c3 = new Car("Ferrari", e2);
        System.out.println("c1 : " + c1.toString());
        System.out.println("c2 : " + c2.toString());
        System.out.println("c3 : " + c3.toString());
        e2.setPower(1200);
        System.out.println("c2 : " + c2.toString());
        System.out.println("c3 : " + c3.toString());*/

    }
}
