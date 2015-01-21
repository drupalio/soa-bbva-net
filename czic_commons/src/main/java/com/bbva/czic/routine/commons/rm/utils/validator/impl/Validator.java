package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import com.bbva.czic.routine.commons.rm.utils.validator.IValidator;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Entelgy Colombia.
 */
public abstract class Validator implements IValidator {

    protected List<BusinessServiceException> exceptions;

    protected Validator() {
        exceptions = new ArrayList<BusinessServiceException>();
    }

    public boolean hasException() {
        return !exceptions.isEmpty();
    }

    public List<BusinessServiceException> getAllExceptions() {
        return exceptions;
    }

    public void throwFirstExceptionIfAny() throws BusinessServiceException {
        if (!exceptions.isEmpty()) {
            throw exceptions.get(0);
        }
    }

    @Override
    public IValidator validate() {
        throwFirstExceptionIfAny();
        return this;
    }
}
