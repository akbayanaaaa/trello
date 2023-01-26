package kz.baibalaeva.demo.repositories;

import kz.baibalaeva.demo.models.Operators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface OperatorsRepository extends JpaRepository<Operators, Long> {
}
