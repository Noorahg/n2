package org.example.Service;

import org.example.Dao.StoreDao;
import org.example.Model.Store;
import org.example.DBUtil.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreService extends Util implements StoreDao {
    Connection connection=getConnection();
    @Override
    public Store getStoreById(long id) {
        String query = "SELECT * FROM stores WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    double revenue = resultSet.getDouble("revenue");

                    return new Store(id, revenue);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Возвращаем null, если запись не найдена
    }


    @Override
    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        String query = "SELECT * FROM stores";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                double revenue = resultSet.getDouble("revenue");

                Store store = new Store(id, revenue);
                stores.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stores;
    }

    @Override
    public void addStore(Store store) {
        String query = "INSERT INTO stores (id, revenue) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, store.getId());
            preparedStatement.setDouble(2, store.getRevenue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStore(Store store) {
        String query = "UPDATE stores SET revenue=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, store.getRevenue());
            preparedStatement.setLong(2, store.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStore(long id) {
        String query = "DELETE FROM stores WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
