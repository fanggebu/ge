package com.qiuhen.blog.vo;

import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.vo
 * @ClassName: BlogQuery
 * @Author: qiuhen
 * @Description: 日志vo
 * @Date: 2020/7/1 20:51
 * @Version: 1.0
 */
public class BlogQuery {

    private String title;
    private Long typeId;
    private boolean recommend;


    public BlogQuery() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", recommend=" + recommend +
                '}';
    }
}
