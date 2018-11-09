package kh.com.c.service;

import java.util.List;

import kh.com.c.model.CalendarDto;

public interface KhCalendarService {

	public List<CalendarDto> getCalendatList(CalendarDto fcal) throws Exception;
	
	public boolean writeCalendar(CalendarDto cal) throws Exception;
	
	public CalendarDto getDay(CalendarDto fcal) throws Exception;
}
