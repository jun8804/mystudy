package kh.com.c.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.c.model.BbsDto;
import kh.com.c.service.KhBbsService;

@Controller
public class KhBbsController {

	private static final Logger logger 
		= LoggerFactory.getLogger(KhBbsController.class);
	
	@Autowired
	KhBbsService khBbsService;
	
	@RequestMapping(value="bbslist.do", method={RequestMethod.GET, RequestMethod.POST})
	public String bbslist(Model model) {		
		logger.info("KhBbsController bbslist " + new Date());
		
		List<BbsDto> bbslist = khBbsService.getBbsList();
		
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist";
	}
	
	
}













