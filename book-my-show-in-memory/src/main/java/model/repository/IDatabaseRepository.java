package model.repository;

public interface IDatabaseRepository<T> {
    public void save( T entity);
    public T update( T entity);
    public T findById();
    public boolean delete( T entity);
}
