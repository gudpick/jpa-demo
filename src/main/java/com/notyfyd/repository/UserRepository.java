package com.notyfyd.repository;

import com.notyfyd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
//    @Query(value = "delete  from t_user_roles where users_id= :user_id", nativeQuery = true)
//    void deleteRelation(@Param("user_id") Long user_id);
//    @Query("from User where id= :id")
//   User  findByUserId(@Param("id") Long id);
    @Query(value = "select * from t_user", nativeQuery = true)
    List<User> findAllByUserId();
}