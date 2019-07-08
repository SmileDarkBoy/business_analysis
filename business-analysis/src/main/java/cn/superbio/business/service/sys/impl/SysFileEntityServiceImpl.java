package cn.superbio.business.service.sys.impl;

import cn.superbio.business.DO.sys.SysFileEntity;
import cn.superbio.business.mapper.sys.SysFileEntityMapper;
import cn.superbio.business.service.sys.SysFileEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

@Service
public class SysFileEntityServiceImpl extends ServiceImpl<SysFileEntityMapper, SysFileEntity> implements SysFileEntityService {
}
