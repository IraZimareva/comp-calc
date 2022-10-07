package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.UserCompetition;
import zimareva.model.ids.UserCompetitionId;

@Repository
public interface UserCompetitionRepository extends CrudRepository<UserCompetition, UserCompetitionId> {
}
