package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.Result;
import zimareva.model.ids.ResultId;

@Repository
public interface ResultRepository extends CrudRepository<Result, ResultId> {
}
