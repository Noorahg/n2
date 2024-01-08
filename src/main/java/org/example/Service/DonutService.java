package org.example.Service;

import org.example.Dao.DonutDao;
import org.example.Model.Donut;
import org.example.DBUtil.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonutService extends Util implements DonutDao {
    Connection connection=getConnection();
    @Override
    public Donut getDonutById(long id) {
        return null;
    }

    @Override
    public List<Donut> getAllDonuts() {
        List<Donut> donuts = new ArrayList<>();
        String query = "SELECT * FROM donuts";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String flavor = resultSet.getString("flavor");
                double price = resultSet.getDouble("price");

                Donut donut = new Donut(id, flavor, price);
                donuts.add(donut);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donuts;
    }


    @Override
    public void addDonut(Donut donut) {
        String query = "INSERT INTO donuts (id, flavor, price) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, donut.getId());
            preparedStatement.setDouble(3, donut.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDonut(Donut donut) {
        String query = "UPDATE donuts SET flavor=?, price=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, donut.getPrice());
            preparedStatement.setLong(2, donut.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void deleteDonut(long id) {
        String query = "DELETE FROM donuts WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

