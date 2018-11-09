package kh.com.c.dao;

import java.util.List;

import kh.com.c.model.BbsDto;
import kh.com.c.model.BbsParam;


public interface KhBbsDao {

	List<BbsDto> getBbsList();
	
	List<BbsDto> getBbsPagingList(BbsParam param);
	
	int getBbsCount(BbsParam param);
	
		
	boolean writeBbs(BbsDto bbs) throws Exception;
	
	BbsDto getBbs(int seq) throws Exception;
	
	boolean replyBbsUpdate(BbsDto bbs) throws Exception;
	boolean replyBbsInsert(BbsDto bbs) throws Exception;
		
	
	void updateBbs(BbsDto bbs);
	
	void deleteBbs(int seq) throws Exception;
}
