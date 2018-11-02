package kh.com.c.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.c.dao.KhMemberDao;
import kh.com.c.dao.impl.KhMemberDaoImpl;
import kh.com.c.model.MemberDto;
import kh.com.c.service.KhMemberService;

@Service
public class KhMemberServiceImpl implements KhMemberService {
	
	@Autowired	// <- DI(의존성) : spring framework
	KhMemberDao khMemberDao; // = new KhMemberDaoImpl();

	@Override
	public boolean addmember(MemberDto mem) throws Exception {		
		return khMemberDao.addmember(mem);		
	}

	@Override
	public MemberDto login(MemberDto mem) throws Exception {		
		return khMemberDao.login(mem);		
	}

	
}







