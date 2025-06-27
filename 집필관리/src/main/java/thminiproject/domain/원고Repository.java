package thminiproject.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thminiproject.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "원고", path = "원고")
public interface 원고Repository
    extends PagingAndSortingRepository<원고, Long> {}
