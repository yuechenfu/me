package com.pib.property.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.property.dao.PersonDao;
import com.pib.property.entity.Account;
import com.pib.property.entity.Person;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;
import com.pib.property.service.AccountService;
import com.pib.property.service.UploadService;

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
