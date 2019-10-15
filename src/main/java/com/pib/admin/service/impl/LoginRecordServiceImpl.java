package com.pib.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pib.admin.dao.LoginRecordDao;
import com.pib.admin.entity.LoginRecord;
import com.pib.admin.model.SearchCondition;
import com.pib.admin.service.LoginRecordService;

import java.util.List;

@Service
public class LoginRecordServiceImpl implements LoginRecordService {
    @Autowired
    private LoginRecordDao dao;

    @Override
    public int save(LoginRecord e) {
        e.fillNotRequire();
        e.updateAt();
        return dao.save(e);
    }

    @Override
    public int delete(LoginRecord e) {
        return dao.delete(e);
    }

    @Override
    public Integer count(SearchCondition searchCondition) {
        return dao.count(searchCondition);
    }

    @Override
    public List<LoginRecord> find(SearchCondition searchCondition) {
        searchCondition.setDefaultSortBy("updateAt");
        return dao.find(searchCondition);
    }

    @Override
    public Integer countByPersionId(SearchCondition searchCondition, LoginRecord e) {
        return dao.countByPersonId(searchCondition, e);
    }

    @Override
    public List<LoginRecord> findByPersionId(SearchCondition searchCondition, LoginRecord e) {
        searchCondition.setDefaultSortBy("updateAt");
        return dao.findByPersonId(searchCondition, e);
    }
}