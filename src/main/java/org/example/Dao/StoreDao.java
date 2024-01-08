package org.example.Dao;

import org.example.Model.Store;

import java.util.List;

public interface StoreDao {
    Store getStoreById(long id);

    List<Store> getAllStores();

    void addStore(Store store);

    void updateStore(Store store);

    void deleteStore(long id);
}
