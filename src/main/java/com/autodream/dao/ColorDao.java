package com.autodream.dao;

import com.autodream.domain.Auto;
import com.autodream.domain.Color;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yagoa
 */
public interface ColorDao extends JpaRepository<Color, Long> {


}
