package DataBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		DOConnection dbObj = new DOConnection();
        dbObj.doConnectDB();
        
        List<Expense> expenses = dbObj.getExpenses();

        Set<String> paymentMethods = new HashSet<>();

        for (Expense expense : expenses) {
            System.out.println("ID: " + expense.getId());
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("Date: " + expense.getDate());
            System.out.println("Currency: " + expense.getCurrency());
            System.out.println("Payment Method: " + expense.getPaymentMethod());
            System.out.println("-----------------------------");

            // Add payment method to the set
            paymentMethods.add(expense.getPaymentMethod());
        }

        System.out.println("Payment Methods used:");
        for (String paymentMethod : paymentMethods) {
            System.out.println(paymentMethod);
        }
        
        double totalAmountForAll = dbObj.getTotalAmountForAllExpenses();
        System.out.println("Total Amount for all expenses: " + totalAmountForAll);

       
	}

}
