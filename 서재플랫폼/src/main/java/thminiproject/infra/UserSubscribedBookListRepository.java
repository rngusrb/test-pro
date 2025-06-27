package thminiproject.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thminiproject.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "userSubscribedBookLists",
    path = "userSubscribedBookLists"
)
public interface UserSubscribedBookListRepository
    extends PagingAndSortingRepository<UserSubscribedBookList, Long> {}
