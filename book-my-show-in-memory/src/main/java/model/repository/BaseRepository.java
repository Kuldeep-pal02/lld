package model.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseRepository<T, ID> implements IDatabaseRepository<T, ID>{

    protected final Map<ID, T> table = new ConcurrentHashMap<>();


    @Override
    public void save(T entity) {
        ID id = getId( entity );
        if( id == null ){
            throw new RuntimeException( " Id cannot be null");
        }
        table.put( id, entity);
    }

    @Override
    public void saveBulk(List<T> entities) {
        for( T t : entities ){
            save( t );
        }
    }

    @Override
    public T update(T entity) {
        save( entity );
        return entity;
    }

    @Override
    public T findById(ID id) {
        return table.get( id );
    }

    @Override
    public boolean delete(T entity) {
        ID id = getId(entity);
        table.remove( id );
        return true;
    }

    @Override
    public List<T> findAll() {
        return table.values().stream().toList();
    }

    @Override
    public List<T> findByCondition(Predicate<T> condition) {
        return table.values().stream().filter(condition).collect(Collectors.toList());
    }

    abstract ID getId( T entity) ;
}
