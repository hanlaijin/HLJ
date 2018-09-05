package com.hlj.dao;

import com.hlj.entity.TI;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-9.
 */
public interface TIRepository extends JpaRepository<TI, Long> {

    @Transactional(timeout = 10)
    @Query("select ti from TI ti")
    List<TI> findByPage(Pageable pageable);
}
