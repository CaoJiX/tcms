package com.ke.service.impl;

import com.ke.entity.Doctor;
import com.ke.mapper.DoctorMapper;
import com.ke.service.IDoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ke
 * @since 2022-02-18
 */
@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

}
