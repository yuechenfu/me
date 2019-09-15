package com.pib.admin.service;



import java.util.List;

import com.pib.admin.entity.Account;
import com.pib.admin.entity.Person;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;

public interface UploadService {

    boolean updateHeadImage(Person e);
}
