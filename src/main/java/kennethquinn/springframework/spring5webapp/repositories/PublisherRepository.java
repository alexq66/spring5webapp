package kennethquinn.springframework.spring5webapp.repositories;

import kennethquinn.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kenneth Quinn 2/5/2024
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
