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
	
	@Override
	public boolean writeBbs(BbsDto bbs) throws Exception {	
		sqlSession.insert(ns+"writeBbs",bbs);		
		return true;
	}

	@Override
	public void updateBbs(BbsDto bbs) {
		sqlSession.update(ns+"updateBbs",bbs);
	}

	@Override
	public BbsDto getBbs(int seq) throws Exception {		
		return sqlSession.selectOne(ns+"getBbs", seq);
	}
	
	
	@Override
	public boolean replyBbsUpdate(BbsDto bbs) throws Exception {		
		sqlSession.update(ns+"replyBbsUpdate", bbs);
		return true; 
	}

	@Override
	public boolean replyBbsInsert(BbsDto bbs) throws Exception {
		sqlSession.insert(ns+"replyBbsInsert", bbs);
		return true;
	}
	

	@Override
	public void deleteBbs(int seq) throws Exception {
		sqlSession.update(ns+"deleteBbs", seq);
	}
	
	
}








