package kennethquinn.springframework.spring5webapp.repositories;

import kennethquinn.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kenneth Quinn on 2/5/2024
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
