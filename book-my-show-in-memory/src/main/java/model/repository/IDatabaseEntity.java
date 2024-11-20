package model.repository;

public interface IDatabaseEntity<T> {
    public void add( T entity);
    public T update( T entity);
    public boolean delete( T entity);

}
