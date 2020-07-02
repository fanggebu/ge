package com.qiuhen.blog.service;

import com.qiuhen.blog.dao.TypeRepository;
import com.qiuhen.blog.handler.NotFoundException;
import com.qiuhen.blog.po.Type;
import org.hibernate.type.ListType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public List<Type> findAll(){
        return typeRepository.findAll();
    }

    @Transactional
    public Type saveType(Type type) {

        return typeRepository.save(type);
    }

    @Transactional
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Transactional
    public Page<Type> listType(Pageable pageable) {

        return typeRepository.findAll(pageable);
    }

    @Transactional
    public Type updateType(Long id,  Type type) {
        Type type1 = typeRepository.findById(id).get();
        if(type1 == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type, type1);
        return typeRepository.save(type1);
    }

    @Transactional
    public void delType(Long id) {
        typeRepository.deleteById(id);
    }
}
