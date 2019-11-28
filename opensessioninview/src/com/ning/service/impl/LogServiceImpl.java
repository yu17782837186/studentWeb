package com.ning.service.impl;

import com.ning.mapper.LogMapper;
import com.ning.pojo.Log;
import com.ning.service.LogService;
import com.ning.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class LogServiceImpl implements LogService {
    @Override
    public int ins(Log log) {
        SqlSession session = MyBatisUtil.getSession();
        LogMapper mapper = session.getMapper(LogMapper.class);
        return mapper.ins(log);
    }
}
