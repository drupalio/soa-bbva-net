package com.bbva.czic.checkbooks.dao.impl;

import java.io.IOException;
import java.util.List;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.ICheckbooksDAO;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;

// @Repository(value = "accounts-dao")
@Profile(value = "dev")
public class CheckbooksDAOMock implements ICheckbooksDAO {

    private CheckbooksDAOMock mock;

    public CheckbooksDAOMock() throws JsonParseException, JsonMappingException, IOException {

        DTOIntCheck check = null;

        check = new ObjectMapper().readValue(
                this.getClass().getClassLoader().getResourceAsStream("mock/DTOListCheck.json"), DTOIntCheck.class);


        mock = Mockito.mock(CheckbooksDAOMock.class);
        Mockito.when(getChecks(Mockito.any(DTOIntCheck.class))).thenReturn(check);

    }


    @Override
    public DTOIntCheck getChecks(DTOIntCheck intCheck) {
        return null;
    }
}
