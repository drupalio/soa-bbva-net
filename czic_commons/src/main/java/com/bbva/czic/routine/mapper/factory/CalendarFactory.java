package com.bbva.czic.routine.mapper.factory;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.bbva.czic.routine.mapper.MappingContext;
import com.bbva.czic.routine.mapper.ObjectFactory;
/**
 * Created by Entelgy on 27/01/2015.
 */
public class CalendarFactory implements ObjectFactory<Calendar> {

    /**
     *
     */
    @Override
    public Calendar create(Object source, MappingContext mappingContext) {

        final Calendar sourceCalendar = (Calendar)source;
        final Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(sourceCalendar.getTime());
        return calendar;
    }
}
