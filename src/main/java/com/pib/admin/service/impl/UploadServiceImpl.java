package com.pib.admin.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.admin.dao.PersonDao;
import com.pib.admin.entity.Account;
import com.pib.admin.entity.Person;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;
import com.pib.admin.service.AccountService;
import com.pib.admin.service.UploadService;

import java.util.List;


@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private PersonDao dao;

	@Override
	public boolean updateHeadImage(Person e) {
		dao.update(e);
		return false;
	}

    

}
