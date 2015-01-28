package com.bbva.czic.checkbooks.facade.v01;

import com.bbva.czic.dto.net.Check;



public interface ISrvCheckbooksV01 {

	Check getCheck(String checkId,String accountId);

}