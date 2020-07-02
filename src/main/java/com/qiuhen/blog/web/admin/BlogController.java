package com.qiuhen.blog.web.admin;

import com.qiuhen.blog.po.Blog;
import com.qiuhen.blog.po.Type;
import com.qiuhen.blog.po.User;
import com.qiuhen.blog.service.BlogService;
import com.qiuhen.blog.service.TypeService;
import com.qiuhen.blog.service.UserService;
import com.qiuhen.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.web.admin
 * @ClassName: UserController
 * @Author: qiuhen
 * @Description: 用户
 * @Date: 2020/6/29 21:22
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    private static  final String INPUT = "admin/blog-input";
    private static  final String LIST = "admin/blogs";
    private static  final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 3, sort = {"updateTime"}
    , direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        Page<Blog> bl;
        model.addAttribute("page",bl = blogService.listBlog(pageable,blog));
        List<Type> t;
        model.addAttribute("types",t=typeService.findAll());
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 3, sort = {"updateTime"}
            , direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("page",blogService.listBlog(pageable,blog));

        return "admin/blogs :: blogList";
    }



    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes redirectAttributes){

        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        Blog blog1 = blogService.saveBlog(blog);
        if (blog1 == null) {
            redirectAttributes.addFlashAttribute("message", "新增失败！");
            return "redirect:admin/type-input";
        } else {
            redirectAttributes.addFlashAttribute("message", "新增成功！");
        }
        return REDIRECT_LIST;
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("types",typeService.findAll());
        return INPUT;
    }





    @GetMapping("/del/{id}")
    public String delete(){
        return "admin/login";
    }

    @GetMapping("/edit/{id}")
    public String edit(){
        return "admin/login";
    }





}
