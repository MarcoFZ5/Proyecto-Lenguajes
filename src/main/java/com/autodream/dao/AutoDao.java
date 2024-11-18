package com.autodream.dao;

import com.autodream.domain.Auto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author yagoa
 */
public interface AutoDao extends JpaRepository<Auto, Long> {
    @Query("SELECT a FROM Auto a JOIN FETCH a.categoria JOIN FETCH a.color JOIN FETCH a.transmision")
    List<Auto> findAllWithRelations();

    public List<Auto> findByPrecioBetweenOrderByMarca(
            double precioInf,
            double precioSup);

    public List<Auto> findByAñoBetweenOrderByMarca(
            double AñoInf,
            double AñoISup);
    
    List<Auto> findByMarcaContainingIgnoreCaseOrModeloContainingIgnoreCase(String marca, String modelo);
    
    
}
