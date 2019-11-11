package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.data.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginUserDao;


@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    LoginUserDao loginUserDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        LoginUser user = loginUserDao.findUser(userName);

        if (user == null) {
            throw new UsernameNotFoundException("userName" + userName + "was not found in the database");
        }

        // 権限のリスト DB上で権限テーブル、ユーザ権限テーブルを作成し管理が必要
        // USERのみ今回作成
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantList.add(authority);

        // BCryptアルゴリズムで暗号化
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // UserDetailsインターフェースにUserオブジェクト代入
        // どちらもSpringのライブラリ
        UserDetails userDetails = (UserDetails) new User(user.getUserName(), encoder.encode(user.getPassword()),
                grantList);
        return userDetails;
    }
}
