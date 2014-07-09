package biz.sunce.web.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import biz.sunce.dao.PomagalaDAO;
import biz.sunce.db.ConnectionFactory;
import biz.sunce.web.dto.PomagaloVO;
import biz.sunce.web.mail.SendMail;


@Controller
public final class HzzoController  {
	
	private PomagalaDAO pomagalaDao;

	public HzzoController() {
		this.pomagalaDao = new PomagalaDAO(ConnectionFactory.getDbConnection());
	}

    @RequestMapping(value="/registracija.do", method = RequestMethod.POST)
    public String registracija(
    		@RequestParam(value="naziv") String naziv,
    		@RequestParam(value="adresa") String adresa,
    		@RequestParam(value="mjesto") String mjesto,
    		@RequestParam(value="oib") String oib,
    		@RequestParam(value="hzzo") String hzzo,
    		@RequestParam(value="email") String email,
    		@RequestParam(value="telefon") String telefon,
    		HttpServletRequest request) {
    	
    	System.out.println("Došao "+naziv+" adresa: "+adresa);
    	
    	String from = "asabo64738@gmail.com";
		String to = "ante@sunce.biz";
		String subject = "zahtjev za licencom";
		String message = "Došao od: "+naziv+","+adresa+","+mjesto+"\n";
		message+="OIB: "+oib+" hzzo:"+hzzo+" email:"+email+" tel:"+telefon;
 
		SendMail sendMail = new SendMail(from, to, subject, message);
		
		try{
		sendMail.send();
		}
		catch(Exception e){
			System.err.println("iznimka kod slanja maila: "+e);
			return "registracija_neuspjesna";
		}
		
        return "registracija_uspjesna";
    }

    List<PomagaloVO> pomagalaCache=null;
    
    @RequestMapping(value="/pomagala.do", method = RequestMethod.GET)
    public String pomagala(
    		@RequestParam(value="timestamp", defaultValue="") String timestamp,
    		HttpServletRequest request) {
    	
    	List<PomagaloVO> rez=null;

    	
    	if (pomagalaCache!=null)
    	{
    		rez = pomagalaCache;
    	}
    	else    	
    	try {
			 rez = pomagalaDao.findAll(timestamp);
			 pomagalaCache = rez;
    	} catch (SQLException e) {
		  rez=null;
		  pomagalaCache=null;
		}
	 
		request.setAttribute("pomagala", rez);
        return "pomagala";
    }



}
