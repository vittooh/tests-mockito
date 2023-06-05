package com.digital.bricklayer.mockitowithjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface JornalRepository  extends JpaRepository<Jornal,Long> {

    @Query("select J from Jornal J where id in :ids")
    List<Jornal> findByids(@Param("ids") List<Long> ids);
}
