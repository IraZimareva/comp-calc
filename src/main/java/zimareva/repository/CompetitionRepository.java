package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.Competition;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long> {
}
