package exceptions;

public class ExceptionQuantity extends Exception{
    private int quantity;



    public ExceptionQuantity(int quantity, String s) {
        super(s);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ExceptionQuantity{" +
                "quantity=" + quantity +
                '}';
    }
}
