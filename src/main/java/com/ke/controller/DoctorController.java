package com.ke.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ke.common.Result;
import com.ke.entity.User;
import com.ke.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ke.service.IDoctorService;
import com.ke.entity.Doctor;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ke
 * @since 2022-02-18
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    private IDoctorService doctorService;

    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Doctor doctor) {
        doctorService.saveOrUpdate(doctor);
        return Result.success();
    }

    @GetMapping("/userId/{userId}")
    public Result findByUserId(@PathVariable Integer userId) {
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return Result.success(doctorService.getOne(queryWrapper));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        doctorService.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        doctorService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        return Result.success(doctorService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(doctorService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "")String userId,
                           @RequestParam(defaultValue = "")String doctorName,
                           @RequestParam(defaultValue = "") String hospital,
                           @RequestParam(defaultValue = "") String department,
                           @RequestParam(defaultValue = "") String position) {
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        if (!"".equals(userId)) {
            queryWrapper.like("user_id", userId);
        }
        if (!"".equals(doctorName)) {
            queryWrapper.like("doctor_name", doctorName);
        }
        if (!"".equals(hospital)) {
            queryWrapper.like("hospital", hospital);
        }
        if (!"".equals(department)) {
            queryWrapper.like("department", department);
        }
        if (!"".equals(position)) {
            queryWrapper.like("position",position);
        }
        return Result.success(doctorService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Doctor> list = doctorService.list();
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
        String fileName = URLEncoder.encode("医生信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

}

