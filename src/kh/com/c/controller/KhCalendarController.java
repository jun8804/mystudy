package kh.com.c.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.c.model.CalendarDto;
import kh.com.c.model.CalendarParam;
import kh.com.c.model.MemberDto;
import kh.com.c.service.KhCalendarService;
import kh.com.c.util.CalendarUtil;
import kh.com.c.util.myCal;

@Controller
public class KhCalendarController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(KhCalendarController.class);
	
	@Autowired
	KhCalendarService khCalendarService;
	
	@RequestMapping(value="calendar.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calendar(Model model, myCal jcal, HttpServletRequest req) throws Exception{
		logger.info("KhCalendarController calendar " + new Date());
		
		model.addAttribute("doc_title", "일정");
		
		jcal.calculate();
		
		// id 취득
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		
		String yyyymm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> flist = khCalendarService.getCalendatList(fcal);
		
		model.addAttribute("flist", flist);
		model.addAttribute("jcal", jcal);
		
		return "calendar.tiles";
	}
	
	@RequestMapping(value="calwrite.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calwrite(Model model, myCal jcal) {
		logger.info("KhCalendarController calwrite " + new Date());
		
		model.addAttribute("doc_title", "일정쓰기");
		
		jcal.calculate();
		model.addAttribute("jcal", jcal);
		
		return "calwrite.tiles";		
	}
	
	@RequestMapping(value="calwriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calwriteAf(Model model, CalendarParam calparam)throws Exception {
		logger.info("KhCalendarController calwriteAf " + new Date());
		
		String yyyymmdd = "" + calparam.getYear() + calparam.getMonth() +
					calparam.getDay();
		
		CalendarDto dto = new CalendarDto(calparam.getId(), 
										calparam.getTitle(), 
										calparam.getContent(), 
										yyyymmdd);
		
		khCalendarService.writeCalendar(dto);
		
		model.addAttribute("year", calparam.getYear());
		model.addAttribute("month", calparam.getMonth());
		
		return "forward:/calendar.do";		
	}
	
	@RequestMapping(value="caldetail.do", method={RequestMethod.GET, RequestMethod.POST})
	public String caldetail(CalendarDto fcal, Model model) throws Exception{
		logger.info("KhCalendarController caldetail " + new Date());
		model.addAttribute("doc_title", "일정");
		
		CalendarDto dto = khCalendarService.getDay(fcal);
		String wdate = dto.getWdate();
		
		logger.info("dto:" + dto.toString());
		
		String year = wdate.substring(0, 4);	// year
		String month = CalendarUtil.toOne(wdate.substring(4, 6)) + "";	// month
		String urls = String.format("%s?year=%s&month=%s", 
								"calendar.do", year, month);		
				
		model.addAttribute("cal", dto);
		model.addAttribute("urls", urls);
		
		return "caldetail.tiles";		
	}
	
	@RequestMapping(value="calendarMonth.do", method={RequestMethod.GET, RequestMethod.POST})
	public String calendarMonth(myCal jcal, Model model, HttpServletRequest req)throws Exception{
		logger.info("KhCalendarController calendarMonth " + new Date());		
		model.addAttribute("doc_title", "월별일정");
		
		jcal.calculate();
		// id
		String id = ((MemberDto)req.getSession().getAttribute("login")).getId();
		String yyyymm = CalendarUtil.yyyymm(jcal.getYear(), jcal.getMonth());
		
		CalendarDto fcal = new CalendarDto();
		fcal.setId(id);
		fcal.setRdate(yyyymm);
		
		List<CalendarDto> clist = khCalendarService.getCalendatList(fcal);
		
		model.addAttribute("callist", clist);
		model.addAttribute("year", jcal.getYear());
		model.addAttribute("month", jcal.getMonth());
		
		return "calendarMonth.tiles";		
	}
			
	
}














