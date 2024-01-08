package org.example.Service;

import org.example.Dao.CustomerDao;
import org.example.Model.Customer;
import org.example.DBUtil.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService  extends Util implements CustomerDao {
    Connection connection=getConnection();

    @Override
    public Customer getCustomerById(long id) {
        String query = "SELECT * FROM customers WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    double wallet = resultSet.getDouble("wallet");

                    return new Customer(id, name, wallet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Возвращаем null, если запись не найдена
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double wallet = resultSet.getDouble("wallet");

                Customer customer = new Customer(id, name, wallet);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }


    @Override
    public void addCustomer(Customer customer) {
        String query = "INSERT INTO customers (id, name, wallet) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setDouble(3, customer.getWallet());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customers SET name=?, wallet=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setDouble(2, customer.getWallet());
            preparedStatement.setLong(3, customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteCustomer(long id) {
        String query = "DELETE FROM customers WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

