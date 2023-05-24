package com.ke.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ke.entity.Doctor;
import org.springframework.web.bind.annotation.*;

import com.ke.common.Result;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ke.service.IOrderService;
import com.ke.entity.Order;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ke
 * @since 2022-04-21
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Order order) {
        orderService.saveOrUpdate(order);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        orderService.removeById(id);
        return Result.success();
    }

    @GetMapping("/doctorId/{doctorId}")
    public Result findByDoctorId(@PathVariable Integer doctorId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doctor_id", doctorId);
        return Result.success(orderService.getOne(queryWrapper));
    }

    @GetMapping("/patientId/{patientId}")
    public Result findByPatientId(@PathVariable Integer patientId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId);
        return Result.success(orderService.getOne(queryWrapper));
    }

    @GetMapping("/patientIds/{patientId}")
    public List<Order> findAllByPatientId(@PathVariable Integer patientId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("patient_id", patientId);
        List orders = orderService.list(queryWrapper);

        return orders;
    }



    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        orderService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(orderService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(orderService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String patientName,
                           @RequestParam(defaultValue = "") String doctorName,
                           @RequestParam(defaultValue = "") String state) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        if (!"".equals(patientName)) {
            queryWrapper.like("patient_name", patientName);
        }
        if (!"".equals(doctorName)) {
            queryWrapper.like("doctor_name", doctorName);
        }
        if (!"".equals(state)) {
            queryWrapper.like("state", state);
        }
        return Result.success(orderService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @GetMapping("/page/patient")
    public Result findPage2(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                            @RequestParam(defaultValue = "") String patientId,
                            @RequestParam(defaultValue = "") String doctorName,
                            @RequestParam(defaultValue = "") String state) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        if (!"".equals(patientId)) {
            queryWrapper.eq("patient_id", patientId);
        }
        if (!"".equals(doctorName)) {
            queryWrapper.like("doctor_name", doctorName);
        }
        if (!"".equals(state)) {
            queryWrapper.like("state", state);
        }
        return Result.success(orderService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @GetMapping("/page/doctor")
    public Result findPage3(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                            @RequestParam(defaultValue = "") String doctorId,
                            @RequestParam(defaultValue = "") String patientName,
                            @RequestParam(defaultValue = "") String state) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        if (!"".equals(doctorId)) {
            queryWrapper.eq("doctor_id", doctorId);
        }
        if (!"".equals(patientName)) {
            queryWrapper.like("patient_name", patientName);
        }
        if (!"".equals(state)) {
            queryWrapper.like("state", state);
        }
        return Result.success(orderService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Order> list = orderService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
//        //自定义标题别名
//        writer.addHeaderAlias("username", "用户名");
//        writer.addHeaderAlias("password", "密码");
//        writer.addHeaderAlias("nickname", "昵称");
//        writer.addHeaderAlias("email", "邮箱");
//        writer.addHeaderAlias("phone", "电话");
//        writer.addHeaderAlias("address", "地址");

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("订单信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

}

