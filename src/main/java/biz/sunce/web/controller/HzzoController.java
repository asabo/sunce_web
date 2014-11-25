package biz.sunce.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import biz.sunce.dao.PomagalaDAO;
import biz.sunce.db.ConnectionFactory;
import biz.sunce.web.app.AppConfig;
import biz.sunce.web.dto.PomagaloVO;
import biz.sunce.web.mail.SendMail;


@Path("/v1/")
public final class HzzoController  {

	private final static Logger LOG = Logger.getLogger(HzzoController.class);
	
	@Context  UriInfo uriInfo;  
	@Context  HttpServletRequest request; 
	
	private final static int uc=64738;
	private final static int uc2=1235;
	
	private static String p2="M";
	private static final String hash = "#";

	private PomagalaDAO pomagalaDao;

	public HzzoController() {
		ConnectionFactory.inject(AppConfig.getCnf());
		this.pomagalaDao = new PomagalaDAO(ConnectionFactory.getDbConnection());
	}

	@POST
	@Path(value="registracija.do")
    public String registracija(
    		@QueryParam(value="naziv") String naziv,
    		@QueryParam(value="adresa") String adresa,
    		@QueryParam(value="mjesto") String mjesto,
    		@QueryParam(value="oib") String oib,
    		@QueryParam(value="hzzo") String hzzo,
    		@QueryParam(value="email") String email,
    		@QueryParam(value="telefon") String telefon
    		) 
	{
    	
    	System.out.println("Došao "+naziv+" adresa: "+adresa);
    	
    	String from = "asabo64738@gmail.com";
    	p2="Ma";
		String to = "ante@sunce.biz";
		String subject = "zahtjev za licencom";
		String message = "Došao od: "+naziv+","+adresa+","+mjesto+"\n";
		message+="OIB: "+oib+" hzzo:"+hzzo+" email:"+email+" tel:"+telefon;
		
		Properties props = new Properties();
		final String p1="nga";
		String as="asabo";
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("kor", as+uc);
		props.setProperty( "mail.smtp.port", "995" );
		props.put("mail.smtp.starttls.enable", "true");
		props.put("loza",p2.trim()+p1+uc2+hash);
 
		SendMail sendMail = new SendMail(from, to, subject, message, props);
		
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
    
    @GET
    @Path(value="/pomagala.do")
	@Produces(MediaType.APPLICATION_JSON)
    public String pomagala(
    		@QueryParam(value="timestamp") String timestamp
    		) {
    	
    	List<PomagaloVO> rez=null;
    	
    	if (pomagalaCache!=null)
    	{
    		rez = pomagalaCache;
    	}
    	else    	
    	try {
			 rez = pomagalaDao.findAll(null);
			 pomagalaCache = rez;
    	} catch (SQLException e) {
    		rez = new ArrayList<PomagaloVO>();
			PomagaloVO p= new PomagaloVO();
			p.setSifra(-1);
			p.setNaziv(e.toString());
			p.setCijenaSPDVom(0);
			
			rez.add(p);
		  pomagalaCache=null;
		}
	 
		request.setAttribute("pomagala", rez);
        return "pomagala";
    }

}
