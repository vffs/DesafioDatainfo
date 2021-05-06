
package com.vffs.persistencia;

import java.util.List;

/**
 *
 * @author valeria
 */
public interface Dao<T> {
    
    public boolean insert(final T t); 
    public List<T> findAll();
    public void update(final Integer id, final T t);
    public void delete(final Integer id);
    
}
