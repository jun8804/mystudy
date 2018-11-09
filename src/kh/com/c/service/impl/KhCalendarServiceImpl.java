package kh.com.c.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.c.dao.KhCalendarDao;
import kh.com.c.model.CalendarDto;
import kh.com.c.service.KhCalendarService;

@Service
public class KhCalendarServiceImpl implements KhCalendarService {
	
	@Autowired
	KhCalendarDao khCalendarDao;

	@Override
	public List<CalendarDto> getCalendatList(CalendarDto fcal) throws Exception {	
		return khCalendarDao.getCalendatList(fcal);		
	}

	@Override
	public boolean writeCalendar(CalendarDto cal) throws Exception {		
		return khCalendarDao.writeCalendar(cal);		
	}

	@Override
	public CalendarDto getDay(CalendarDto fcal) throws Exception {		
		return khCalendarDao.getDay(fcal);		
	} 
	
	
	
	

}









