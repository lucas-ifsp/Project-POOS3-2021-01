package br.edu.pratico02;

import java.util.List;
import java.util.Optional;

public interface DAO <T, K> {
    boolean insert(T type);
    Optional<T> readOne(K key);
    List<T> readAll();
    boolean update(T type);
    boolean removeByKey(K key);
    boolean remove(T type);
}
