package com.example.demo.repository;

import com.example.demo.data.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//クエリの作成
@Repository
public interface UserRepository extends JpaRepository<LoginUser, Integer> {
}
