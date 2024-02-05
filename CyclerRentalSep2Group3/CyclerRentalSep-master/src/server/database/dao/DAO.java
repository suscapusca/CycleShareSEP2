package src.server.database.dao;

import java.util.ArrayList;

public interface DAO<T>{

    T get(int id);
    ArrayList<T> getAll();
    boolean save(T t);
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);


}
