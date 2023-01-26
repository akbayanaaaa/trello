package kz.baibalaeva.demo.repositories;

import kz.baibalaeva.demo.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppRepository extends JpaRepository<ApplicationRequest, Long> {

   List<ApplicationRequest> findAllByHandledFalse();
   List<ApplicationRequest> findAllByHandledTrue();


}
