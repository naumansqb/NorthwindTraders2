package com.pluralsight;

import java.sql.*;

public class NorthwindMain {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind",
                    args[0], args[1]
            );
            String query = """
                    SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                    FROM products 
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet results= preparedStatement.executeQuery();
            while(results.next()){
                int productID= results.getInt(1);
                String productName = results.getString(2);
                double unitPrice = results.getDouble(3);
                int unitsInStock = results.getInt(4);
                System.out.println("Product ID : "+productID);
                System.out.println("Name : "+productName);
                System.out.println("Price: "+unitPrice);
                System.out.println("Stock : "+unitsInStock);
                System.out.println("================================");
            }
        } catch (Exception e) {
            System.out.println("An error has occured " + e);
            e.printStackTrace();
        }

    }
}
