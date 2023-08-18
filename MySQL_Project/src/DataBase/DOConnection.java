package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DOConnection {
	Connection conn;
	
	public void doConnectDB() {
        String connectionStr = "jdbc:mysql://localhost:3306/expense tracker";
        String userName = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(connectionStr, userName, password);
            System.out.println("DB Connection is successful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	public List<Expense> getExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT id, amount, date, currency, payment_method FROM expense";
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                String currency = resultSet.getString("currency");
                String paymentMethod = resultSet.getString("payment_method");
                
                Expense expense = new Expense(id, amount, date, currency, paymentMethod);
                expenses.add(expense);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return expenses;
    }


	public double getTotalAmountForAllExpenses() {
        double totalAmount = 0.0;
        String query = "SELECT SUM(amount) AS total_amount FROM expense";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                totalAmount = resultSet.getDouble("total_amount");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return totalAmount;
    }

}
