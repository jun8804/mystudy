package kh.com.c.service;

import kh.com.c.model.MemberDto;

public interface KhMemberService {

	public boolean addmember(MemberDto mem) throws Exception;
	
	public MemberDto login(MemberDto mem) throws Exception;
}
