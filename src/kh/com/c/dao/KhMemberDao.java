package kh.com.c.dao;

import kh.com.c.model.MemberDto;

public interface KhMemberDao {
	
	boolean addmember(MemberDto mem) throws Exception;
	
	MemberDto login(MemberDto mem) throws Exception;

	MemberDto logout(MemberDto mem) throws Exception;
}
