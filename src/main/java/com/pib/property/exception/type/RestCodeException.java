package com.pib.property.exception.type;

import com.pib.property.model.rest.RestCode;

public interface RestCodeException {
	<T extends RestCode> T getCode();
}
