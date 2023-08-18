package DataBase;

public class Expense {
    private int id;
    private double amount;
    private String date;
    private String currency;
    private String paymentMethod;
    
    public Expense(int id, double amount, String date, String currency, String paymentMethod) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
    }
    
    public int getId() {
        return id;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
}

