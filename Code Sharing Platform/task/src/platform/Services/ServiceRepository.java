package platform.Services;

import org.springframework.data.repository.CrudRepository;
import platform.Models.Code;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Code, Long> {
    List<Code> findFirst10ByOrderByLocalDateTimeDesc();
}
