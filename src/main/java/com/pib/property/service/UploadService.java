package com.pib.property.service;



import java.util.List;

import com.pib.property.entity.Account;
import com.pib.property.entity.Person;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;

public interface UploadService {

    boolean updateHeadImage(Person e);
}
