package thminiproject.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thminiproject.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "플랫폼관리",
    path = "플랫폼관리"
)
public interface 플랫폼관리Repository
    extends PagingAndSortingRepository<플랫폼관리, Long> {}
