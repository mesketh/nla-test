package au.gov.nla;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by mark on 22/1/17.
 */
@RepositoryRestResource(collectionResourceRel = "lenders", path = "lenders")
public interface LenderRepository extends PagingAndSortingRepository<Lender, Long> {

    public List<Lender> findAll();


}
