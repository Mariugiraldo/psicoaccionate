package com.psicologia.repository;

import com.psicologia.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpertRepository extends JpaRepository<Expert, Long> {

}
