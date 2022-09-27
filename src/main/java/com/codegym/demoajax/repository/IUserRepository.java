package com.codegym.demoajax.repository;

import com.codegym.demoajax.model.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<AppUser, Long> {

}
