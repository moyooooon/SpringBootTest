package com.example.demo.dao;

import javax.persistence.EntityManager;

import com.example.demo.data.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginUserDao {

    @Autowired
    EntityManager em;

    /**
     * フォームの入力値から該当するユーザを検索する.
     * @param userName
     * @return UserEntity、存在しないとき:Null
     */
    public LoginUser findUser(String userName) {
        String query = "";
        query += "SELECT * ";
        query += "FROM user ";
        query += "WHERE user_name = :userName "; //setParameterで引数の値を代入できるようにNamedParameterを利用

        //EntityManagerで取得された結果はオブジェクトとなるので、LoginUser型へキャストが必要となる
        return (LoginUser)em.createNativeQuery(query, LoginUser.class).setParameter("userName", userName)
                .getSingleResult();
    }

}