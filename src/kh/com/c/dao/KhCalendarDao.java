package kh.com.c.dao;

import java.util.List;

import kh.com.c.model.CalendarDto;

public interface KhCalendarDao {
	
	List<CalendarDto> getCalendatList(CalendarDto fcal) throws Exception;

	boolean writeCalendar(CalendarDto cal) throws Exception;
	
	CalendarDto getDay(CalendarDto fcal) throws Exception;	
	
}
