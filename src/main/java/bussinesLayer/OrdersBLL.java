package bussinesLayer;

import dao.OrdersDAO;
import dataAccesLayes.ConnectionFactory;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdersBLL {
    private OrdersDAO ordersDAO = new OrdersDAO();
    /**
     * Inserează o comandă nouă în sursa de date.
     *
     * @param product Comanda care urmează să fie inserată.
     * @return Comanda inserată.
     */
   public Orders insertOrders(Orders product) {
        return ordersDAO.insert(product);
    }
    /**
     * Șterge comenzile pentru un anumit client din sursa de date.
     *
     * @param clientName Numele clientului pentru care se șterg comenzile.
     */
    public void deleteOrdersByClient(String clientName) {
        Connection connection = null;
        PreparedStatement deleteStatement = null;
        String query = "DELETE FROM orders WHERE nume_client = ?";

        try {
            connection = ConnectionFactory.getConnection();
            deleteStatement = connection.prepareStatement(query);
            deleteStatement.setString(1, clientName);
            deleteStatement.executeUpdate();
            System.out.println("Orders deleted successfully for client: " + clientName);
        } catch (SQLException e) {
            System.out.println("Error deleting orders for client: " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(connection);
        }
    }
    /**
     * Șterge o comandă din sursa de date după numele produsului.
     *
     * @param productName Numele produsului din comandă care urmează să fie șters.
     */
    public void deleteOrder(String productName) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            String query = "DELETE FROM orders WHERE nume_produs = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, productName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }



}
