package org.example.Dao;

import org.example.Model.Donut;

import java.util.List;

public interface DonutDao {
    Donut getDonutById(long id);

    List<Donut> getAllDonuts();

    void addDonut(Donut donut);

    void updateDonut(Donut donut);

    void deleteDonut(long id);
}
