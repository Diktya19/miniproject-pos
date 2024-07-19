package com.bootcamp.northwind.controller;

import com.bootcamp.northwind.model.request.SupplierModel;
import com.bootcamp.northwind.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("pages/supplier/index");
        List<SupplierModel> data  = this.supplierService.getAll();
        view.addObject("listSupplier", data);

        return view;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView("pages/supplier/add");
        return view;
    }

    @GetMapping("/add-modal")
    public ModelAndView addModal(){
        ModelAndView view = new ModelAndView("pages/supplier/_addSupplier");
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SupplierModel request){
        // call save dari service
        this.supplierService.save(request);
        // kirim ke index
        return new ModelAndView("redirect:/supplier");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView("pages/supplier/edit");
        SupplierModel data = this.supplierService.getById(id);
        if (data == null){
            return new ModelAndView("redirect:/supplier");
        }
        // data kirim ke view
        view.addObject("dataSupplier", data);
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute SupplierModel request){
        // memanggil save dari service
        this.supplierService.update(request, request.getId());
        // redirect ke index
        return new ModelAndView("redirect:/supplier");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView("pages/supplier/detail");
        // ambil data dari service
        SupplierModel data = this.supplierService.getById(id);
        if ( data == null){
            return new ModelAndView("redirect:/supplier");
        }

        // kirim data to view
        view.addObject("dataSupplier", data);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDelete(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView("pages/supplier/delete");
        // get data from service
        SupplierModel data = this.supplierService.getById(id);
        if(data == null){
            return new ModelAndView("redirect:/supplier");
        }

        // send data to view
        view.addObject("dataSupplier",data);
        return view;
    }

    @PostMapping("/delete-save")
    public String delete(@ModelAttribute SupplierModel request){
        this.supplierService.delete(request.getId());
        return "redirect:/supplier";
    }
}
