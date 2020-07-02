package com.qiuhen.blog.web.admin;


import com.qiuhen.blog.po.Type;
import com.qiuhen.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.web.admin
 * @ClassName: TypeController
 * @Author: qiuhen
 * @Description: 分类
 * @Date: 2020/7/1 9:34
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
            , Model model) {

        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model) {

        model.addAttribute("type", new Type());
        return "admin/type-input";
    }

    @PostMapping("/types")
    public String save(@Valid Type type, BindingResult result, RedirectAttributes redirectAttributes) {
//        System.out.println("fa");
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
            }
            return "admin/type-input";
        }
        Type type1 = typeService.saveType(type);
        if (type1 == null) {
            redirectAttributes.addFlashAttribute("message", "新增失败！");
            return "redirect:admin/type-input";
        } else {
            redirectAttributes.addFlashAttribute("message", "新增成功！");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/type-input";
    }

    @PostMapping("/types/{id}")
    public String eidt(@Valid Type type, BindingResult result,
                       @PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/type-input";
        }
        Type type1 = typeService.updateType(id, type);
        if (type1 == null) {
            redirectAttributes.addFlashAttribute("message", "修改失败！");
            return "redirect:admin/type-input";
        } else {
            redirectAttributes.addFlashAttribute("message", "修改成功！");
        }
        return "redirect:/admin/types";
    }


    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        typeService.delType(id);
        redirectAttributes.addFlashAttribute("message", "删除成功！");
        return "redirect:/admin/types";
    }

}
