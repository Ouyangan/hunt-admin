package com.hunt.service.impl;

import com.hunt.dao.SysLogMapper;
import com.hunt.model.entity.SysLog;
import com.hunt.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ouyangan
 * @Date : 2016/10/15
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void insertSysControllerLog(SysLog runningLog) {
        sysLogMapper.insert(runningLog);
    }
}
