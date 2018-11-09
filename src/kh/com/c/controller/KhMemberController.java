package kh.com.c.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.c.model.MemberDto;
import kh.com.c.model.YesMember;
import kh.com.c.service.KhMemberService;

@Controller
public class KhMemberController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(KhMemberController.class);
	
	@Autowired	// DI
	KhMemberService khMemberService;	// Inversion Of Control
	
	@RequestMapping(value="login.do", method={RequestMethod.GET, RequestMethod.POST})
	public String login() {
		logger.info("KhMemberController login " + new Date());
		
		return "login.tiles";
	}
	
	
	@RequestMapping(value="regi.do", method=RequestMethod.GET)
	public String regi() {
		logger.info("KhMemberController regi " + new Date());
		
		return "regi.tiles";
	}
	
	@RequestMapping(value="regiAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String regiAf(MemberDto mem) throws Exception {
		logger.info("KhMemberController regiAf " + new Date());
		
		logger.info(mem.toString());
				
		boolean b = khMemberService.addmember(mem);
		if(b) {
			return "login.tiles";
		}else {
			return "regi.tiles";
		}
	}
	
	@RequestMapping(value="loginAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String loginAf(HttpServletRequest req, MemberDto mem)throws Exception {
		logger.info("KhMemberController loginAf " + new Date());
		
		MemberDto login = khMemberService.login(mem);
		
		if(login != null && !login.getId().equals("")) {			
			req.getSession().setAttribute("login", login);
			// bbslist로 이동	
			return "redirect:/bbslist.do";
		}else {
			return "login.tiles";
		}				
	}
	
	@ResponseBody
	@RequestMapping(value="getID.do", method={RequestMethod.GET, RequestMethod.POST})
	public YesMember getID(MemberDto mem) {
		logger.info("KhMemberController getID " + new Date());
		
		int count = khMemberService.getID(mem);
		
		YesMember yes = new YesMember();
		if(count > 0) {
			yes.setMessage("YES");
		}else {
			yes.setMessage("NO");
		}
		return yes;		
	}

}






