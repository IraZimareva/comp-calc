package zimareva.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zimareva.model.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
}
