package com.filadacreche.demo.repositories;

import com.filadacreche.demo.models.Child;
import com.filadacreche.demo.models.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GuardianRepository extends JpaRepository<Guardian, UUID> {

//    @Query(
//            value = "SELECT DISTINCT " +
//                    "guardians.guardian_id, " +
//                    "guardians.cpf, " +
//                    "guardians.name " +
//                    "FROM guardians " +
//                    "JOIN children_guardians ON children_guardians.child_id = :childId",
//            nativeQuery = true)
    List<Guardian> findByChildId(UUID childId);



}
