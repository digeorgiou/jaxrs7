package gr.aueb.cf.schoolapp.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IGenericDAO<T> {

    //σημαντικο να επιστρεφει το DAO optionals για πιο ευκολο
    //χειρισμο στο service.
    Optional<T> insert(T t);
    Optional<T> update(T t);
    void delete(Object id);
    long count();
    long getCountByCriteria(Map<String, Object> criteria);
    Optional<T> getById(Object id);
    Optional<T> findByField(String fieldname, Object value);
    List<T> getAll();
    List<T> getByCriteria(Map<String, Object> criteria);
    List<T> getByCriteria(Class<T> clazz, Map<String, Object> criteria);
    List<T> getByCriteriaPaginated(Class<T> clazz,
                                   Map<String, Object> criteria, Integer page
            , Integer size );

}
