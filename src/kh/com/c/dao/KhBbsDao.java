package kh.com.c.dao;

import java.util.List;

import kh.com.c.model.BbsDto;

public interface KhBbsDao {

	List<BbsDto> getBbsList();
	
	boolean writeBbs(BbsDto bbs) throws Exception;
	
	boolean replyBbsUpdate(BbsDto bbs) throws Exception;
	boolean replyBbsInsert(BbsDto bbs) throws Exception;
	
	BbsDto getBbs(int seq) throws Exception;
	
	void updateBbs(BbsDto bbs);
	
	void deleteBbs(int seq) throws Exception;
}
