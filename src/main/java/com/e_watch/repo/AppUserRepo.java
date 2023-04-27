package com.e_watch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_watch.entity.AppUser;
@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String> {

}
