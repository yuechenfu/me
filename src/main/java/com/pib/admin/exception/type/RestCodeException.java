package com.pib.admin.exception.type;

import com.pib.admin.model.rest.RestCode;

public interface RestCodeException {
	<T extends RestCode> T getCode();
}
