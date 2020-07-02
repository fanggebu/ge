package com.qiuhen.blog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.po
 * @ClassName: type
 * @Author: qiuhen
 * @Description: 标签
 * @Date: 2020/6/29 11:37
 * @Version: 1.0
 */
@Entity
@Table(name = "t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

    public Tag() {
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
