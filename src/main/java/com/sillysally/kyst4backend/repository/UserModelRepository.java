package com.sillysally.kyst4backend.repository;

import com.sillysally.kyst4backend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Long> {
    UserModel findByUsername(String username);
}
