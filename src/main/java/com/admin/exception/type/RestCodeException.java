package com.admin.exception.type;

import com.admin.model.rest.RestCode;

public interface RestCodeException {
	<T extends RestCode> T getCode();
}
