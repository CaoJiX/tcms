package com.ke.service.impl;

import com.ke.entity.Files;
import com.ke.mapper.FileMapper;
import com.ke.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ke
 * @since 2022-02-13
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements IFileService {

}
