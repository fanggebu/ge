package com.qiuhen.blog.dao;

import com.qiuhen.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.dao
 * @ClassName: UserRepository
 * @Author: qiuhen
 * @Description:
 * @Date: 2020/6/29 21:17
 * @Version: 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findBySuernameAndPassword(String suername, String password);
}
