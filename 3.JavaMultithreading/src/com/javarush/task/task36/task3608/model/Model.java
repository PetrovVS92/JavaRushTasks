package com.javarush.task.task36.task3608.model;

/**
 * Created by user on 25.05.2017.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();

}
