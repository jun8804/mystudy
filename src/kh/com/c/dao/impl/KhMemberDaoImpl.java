package kh.com.c.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.c.dao.KhMemberDao;
import kh.com.c.model.MemberDto;

@Repository	// =저장소
public class KhMemberDaoImpl implements KhMemberDao{
	
	@Autowired	// Dependency Injection(의존성) I	
	SqlSession sqlSession;
	
	String namespace = "KhMember.";

	@Override
	public boolean addmember(MemberDto mem) throws Exception {		
		int n = sqlSession.insert(namespace + "addmember", mem);
		
		return n>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto mem) throws Exception {		
		return sqlSession.selectOne(namespace + "login", mem);
	}

	@Override
	public int getID(MemberDto mem) {		
		return sqlSession.selectOne(namespace + "getID", mem);
	}
	
	
	

}






