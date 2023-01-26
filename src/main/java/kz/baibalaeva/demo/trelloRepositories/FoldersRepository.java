package kz.baibalaeva.demo.trelloRepositories;

import kz.baibalaeva.demo.trelloModels.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface FoldersRepository extends JpaRepository<Folders, Long> {
}
