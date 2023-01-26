package kz.baibalaeva.demo.repositories;

import kz.baibalaeva.demo.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
