package com.qiuhen.blog.service;

import com.qiuhen.blog.dao.BlogRepository;
import com.qiuhen.blog.dao.TypeRepository;
import com.qiuhen.blog.handler.NotFoundException;
import com.qiuhen.blog.po.Blog;
import com.qiuhen.blog.po.Type;
import com.qiuhen.blog.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.service
 * @ClassName: TypeService
 * @Author: qiuhen
 * @Description: 分类
 * @Date: 2020/7/1 9:20
 * @Version: 1.0
 */
@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog getBlog(Long id){
        return null;
    }

    @Transactional
    public Blog saveBlog(Blog blog) {
        blog.setCreatTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogRepository.save(blog);
    }

    @Transactional
    public Blog getType(Long id) {
        return blogRepository.findById(id).get();
    }

    @Transactional
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {

        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(!"".equals(blog.getTitle()) && blog.getTitle() != null){
                    predicates.add(cb.like(root.<String>get("title"),"%"+blog.getTitle()+"%"));
                }
                if(blog.getTypeId() != null){
                    predicates.add(cb.equal(root.<Type>get("typs").get("id"),blog.getTypeId()));
                }
                if(blog.isRecommend()){
                    predicates.add(cb.equal(root.<Boolean>get("recommend"),blog.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Transactional
    public Blog updateBlog(Long id,  Blog blog) {
        Blog blog1 = blogRepository.findById(id).get();
        if(blog1 == null){
            throw new NotFoundException("该博客不存在！");
        }
        BeanUtils.copyProperties(blog, blog1);
        return blogRepository.save(blog1);
    }

    @Transactional
    public void delBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
