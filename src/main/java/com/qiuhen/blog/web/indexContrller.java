package com.qiuhen.blog.web;

import com.qiuhen.blog.handler.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.web
 * @ClassName: indexContrller
 * @Author: qiuhen
 * @Description: 页面控制
 * @Date: 2020/6/28 9:21
 * @Version: 1.0
 */
@Controller
public class indexContrller {

    @GetMapping("/")
    public String index(){
////        int i = 9/0;
//        String blog = null;
//        if(blog == null){
//            throw new NotFoundException("博客不存在");
//        }
        System.out.println("---------index------------");
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){

        System.out.println("---------blog------------");
        return "blog";
    }

    @GetMapping("/type")
    public String type(){

        System.out.println("---------type------------");
        return "types";
    }

    @GetMapping("/about")
    public String about(){

        System.out.println("---------about------------");
        return "about";
    }

    @GetMapping("/tags")
    public String tags(){

        System.out.println("---------tags------------");
        return "tags";
    }

    @GetMapping("/archives")
    public String archives(){

        System.out.println("---------archives------------");
        return "archives";
    }
    @GetMapping("/login")
    public String login(){

        System.out.println("---------login------------");
        return "admin/login";
    }

    @GetMapping("/index")
    public String admingIndex(){

        System.out.println("---------adming/index------------");
        return "admin/index";
    }

    @GetMapping("/blogs")
    public String blogs(){

        System.out.println("---------blogs------------");
        return "admin/blogs";
    }

    @GetMapping("/blog-input")
    public String blogInput(){

        System.out.println("---------blog-input------------");
        return "admin/blog-input";
    }

}
