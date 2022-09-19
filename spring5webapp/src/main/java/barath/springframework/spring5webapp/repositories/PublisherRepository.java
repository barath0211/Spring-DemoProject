package barath.springframework.spring5webapp.repositories;

import barath.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository {
    public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    }
}
