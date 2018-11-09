package kh.com.c.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.c.dao.KhCalendarDao;
import kh.com.c.model.CalendarDto;

@Repository
public class KhCalendarDaoImpl implements KhCalendarDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String ns = "KhCalendar.";

	@Override
	public List<CalendarDto> getCalendatList(CalendarDto fcal) throws Exception {
		List<CalendarDto> callist = sqlSession.selectList(ns+"getCalendarList", fcal);
		return callist;
	}

	@Override
	public boolean writeCalendar(CalendarDto cal) throws Exception {
		int n = sqlSession.insert(ns + "writeCalendar", cal); 
		return n>0?true:false;
	}

	@Override
	public CalendarDto getDay(CalendarDto fcal) throws Exception {		
		return sqlSession.selectOne(ns + "getDay", fcal);
	}
	
	

}













