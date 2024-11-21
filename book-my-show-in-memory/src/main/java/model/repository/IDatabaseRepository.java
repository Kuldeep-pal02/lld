package model.repository;

import java.util.List;
import java.util.function.Predicate;

public interface IDatabaseRepository<T,ID> {
    public void save( T entity);
    public T update( T entity);
    public T findById( ID id);
    public boolean delete( T entity);

    public List<T> findAll();

    List<T> findByCondition(Predicate<T> condition);
}
