package com.example.tools.repository;

import com.example.tools.domain.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long> {

    @Query(value = "select * from tools where tags like %:tags%", nativeQuery = true)
    List<Tools> findByTags(String tags);

}
