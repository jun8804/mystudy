package kh.com.c.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.c.dao.KhBbsDao;
import kh.com.c.model.BbsDto;

@Repository
public class KhBbsDaoImpl implements KhBbsDao {

	@Autowired
	SqlSession sqlSession; 
	
	String ns = "KhBbs.";

	@Override
	public List<BbsDto> getBbsList() {		
		List<BbsDto> list = sqlSession.selectList(ns + "getBbsList");		
		return list;
	}
	
	
	
	
}








