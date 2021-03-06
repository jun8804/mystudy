package kh.com.c.service;

import java.util.List;

import kh.com.c.model.BbsDto;

public interface KhBbsService {

	public List<BbsDto> getBbsList();
	
	public boolean writeBbs(BbsDto bbs) throws Exception;
		
	public BbsDto getBbs(int seq) throws Exception;	
	
	public void updateBbs(BbsDto bbs);
	
	public void deleteBbs(int seq) throws Exception;
	
	public void reply(BbsDto bbs) throws Exception;
	
	
}
