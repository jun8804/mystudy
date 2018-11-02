package kh.com.c.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.c.dao.KhBbsDao;
import kh.com.c.model.BbsDto;
import kh.com.c.service.KhBbsService;

@Service
public class KhBbsServiceImpl implements KhBbsService {
	
	@Autowired
	KhBbsDao khBbsDao;

	@Override
	public List<BbsDto> getBbsList() {		
		return khBbsDao.getBbsList();
	}
	
	@Override
	public boolean writeBbs(BbsDto bbs) throws Exception {		
		return khBbsDao.writeBbs(bbs);		
	}

	

	@Override	
	public BbsDto getBbs(int seq) throws Exception {		
		return khBbsDao.getBbs(seq);		
	}
	
	@Override
	public void updateBbs(BbsDto bbs) {
		khBbsDao.updateBbs(bbs);
	}

	
	@Override
	public void reply(BbsDto bbs) throws Exception {
		khBbsDao.replyBbsUpdate(bbs);
		khBbsDao.replyBbsInsert(bbs);	
	}
	
	
	
	@Override
	public void deleteBbs(int seq) throws Exception {
		khBbsDao.deleteBbs(seq);		
	}
	

}
