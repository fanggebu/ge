package com.qiuhen.blog.dao;

import com.qiuhen.blog.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.dao
 * @ClassName: BlogRepository
 * @Author: qiuhen
 * @Description:
 * @Date: 2020/7/1 16:14
 * @Version: 1.0
 */
public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor {


}
