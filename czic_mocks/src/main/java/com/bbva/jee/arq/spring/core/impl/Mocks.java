package com.bbva.jee.arq.spring.core.impl;

import com.bbva.jee.arq.spring.core.IMocks;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Mocks{

    public Mocks() {
        System.out.println("Hola Mundo.");
    }

//    @AfterReturning("execution(* com.bbva.jee.arq.spring.core.host.CuerpoMultiparte.getPartes(*))")
    @Before("execution(* com.bbva.czic.globalposition.business.impl.SrvIntGlobalPosition.getExtractGlobalBalance(*))")
	public void returnMockedBean() {
        System.out.println("Hola Mundo.");
    }
	
}

