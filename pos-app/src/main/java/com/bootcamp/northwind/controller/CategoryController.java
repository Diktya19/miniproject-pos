package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.request.CategoryRequest;
import com.bootcamp.northwind.model.request.ProductRequest;
import com.bootcamp.northwind.model.request.SupplierModel;
import com.bootcamp.northwind.service.CategoryService;
import com.bootcamp.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/category/index");
        List<CategoryRequest> categories = this.categoryService.getAll();

        view.addObject("listCategory", categories);
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/category/_addPartial");
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("listSupplier", supplier);
        return view;
    }

    @GetMapping("/add-product/{index}")
    public ModelAndView addProduct(@PathVariable("index") int index){
        ModelAndView view = new ModelAndView("pages/category/_addProduct");
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("listSupplier", supplier);
        view.addObject("index", index);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute CategoryRequest request){
        this.categoryService.save(request);
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView("pages/category/edit");
        CategoryRequest data = this.categoryService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/category");
        }

        List<SupplierModel> supplier = this.supplierService.getAll();
        // data kirim  ke view
        view.addObject("dataCategory", data);
        view.addObject("dataSupplier", supplier);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView updateCategory(@ModelAttribute CategoryRequest request){
        this.categoryService.update(request, request.getId());
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView("pages/category/detail");
        CategoryRequest category = this.categoryService.getById(id).orElse(null);
        if (category == null){
            return new ModelAndView("redirect:/category");
        }
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("dataSupplier", supplier);
        view.addObject("dataCategory", category);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDelete(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView("pages/category/delete");
        // get data from service
        CategoryRequest data = this.categoryService.getById(id).orElse(null);
        if (data == null){
            return new ModelAndView("redirect:/category");
        }
        List<SupplierModel> supplier = this.supplierService.getAll();

        view.addObject("dataSupplier", supplier);
        view.addObject("dataCategory", data);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute CategoryRequest request){
        this.categoryService.delete(request.getId());
        return "redirect:/category";
    }
}
