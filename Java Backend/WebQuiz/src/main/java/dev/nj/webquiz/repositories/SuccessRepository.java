package dev.nj.webquiz.repositories;

import dev.nj.webquiz.entities.Success;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessRepository extends CrudRepository<Success, Long>, PagingAndSortingRepository<Success, Long> {
    Page<Success> findByUsername(String username, Pageable pageable);
}
