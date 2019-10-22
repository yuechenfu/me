package com.admin.service;


import java.util.List;

import com.admin.entity.LoginRecord;
import com.admin.model.SearchCondition;

public interface LoginRecordService {

    int save(LoginRecord e)  ;

    int delete(LoginRecord e) ;

    Integer count(SearchCondition searchCondition);

    List<LoginRecord> find(SearchCondition searchCondition);

    Integer countByPersionId(SearchCondition searchCondition, LoginRecord e);

    List<LoginRecord> findByPersionId(SearchCondition searchCondition,LoginRecord e);
}
