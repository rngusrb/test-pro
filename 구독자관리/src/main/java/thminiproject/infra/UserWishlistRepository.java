package thminiproject.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thminiproject.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "userWishlists",
    path = "userWishlists"
)
public interface UserWishlistRepository
    extends PagingAndSortingRepository<UserWishlist, Long> {}
