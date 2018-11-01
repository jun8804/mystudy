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
	
	

}
