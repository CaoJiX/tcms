package com.ke.service.impl;

import com.ke.entity.Patient;
import com.ke.mapper.PatientMapper;
import com.ke.service.IPatientService;
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
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

}
