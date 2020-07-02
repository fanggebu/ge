package com.qiuhen.blog.service;

import com.qiuhen.blog.dao.UserRepository;
import com.qiuhen.blog.po.User;
import com.qiuhen.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.service
 * @ClassName: UserService
 * @Author: qiuhen
 * @Description: 用户
 * @Date: 2020/6/29 21:14
 * @Version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 检查用户
     * @param suername
     * @param password
     * @return
     */
    public User checkUser(String suername, String password){
        User user = userRepository.findBySuernameAndPassword(suername, MD5Utils.code(password));
        return  user;
    }


}
