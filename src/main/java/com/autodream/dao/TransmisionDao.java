package com.autodream.dao;

import com.autodream.domain.Auto;
import com.autodream.domain.Transmision;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yagoa
 */
public interface TransmisionDao extends JpaRepository<Transmision, Long> {

  
}
