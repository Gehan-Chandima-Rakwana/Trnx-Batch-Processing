package com.redowl.batch_processing.daos.reference;


import com.redowl.batch_processing.models.reference.RStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RStatusDao extends JpaRepository<RStatus, Integer> {

    List<RStatus> findByIsActive(boolean b);

    Optional<RStatus> findByStatusCodeAndIsActive(String statusCode, boolean b);

    Optional<RStatus> findByStatusIdAndIsActive(Integer id, boolean b);

    boolean existsByStatusCodeAndIsActiveAndStatusIdNot(String statusCode, boolean b, Integer id);
}
