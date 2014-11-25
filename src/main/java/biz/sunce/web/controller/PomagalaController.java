package biz.sunce.web.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import biz.sunce.dao.PomagalaDAO;
import biz.sunce.db.ConnectionFactory;
import biz.sunce.web.app.AppConfig;
import biz.sunce.web.dto.PomagaloVO;

@Path("/v1/pomagala/")
public final class PomagalaController 
{

	private final static Logger LOG = Logger.getLogger(PomagalaController.class);
	
	@Context  UriInfo uriInfo;  
	@Context  HttpServletRequest request; 
	
	private PomagalaDAO pomagalaDao;

	public PomagalaController() {
		System.out.println("PomagalaController start");
		ConnectionFactory.inject(AppConfig.getCnf());
		this.pomagalaDao = new PomagalaDAO(ConnectionFactory.getDbConnection());
		LOG.info("Podigli smo PomagalaController");
		 
	}

	private List<PomagaloVO> pomagalaCache = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@GET
	@Produces(MediaType.APPLICATION_JSON+"; Content-Encoding=UTF-8")
	@Path(value = "" ) 
	public  
	List<PomagaloVO> getPomagala(
			@QueryParam(value = "timestamp") String vrijemeStr) {

		boolean vrijemeStrEmpty = StringUtils.isEmpty( vrijemeStr );
		
		if (pomagalaCache != null && vrijemeStrEmpty)
			return pomagalaCache;

		Date vrijeme = null;
		Object kljuc = null;
		List<PomagaloVO> rezultat = null;

		if ( !vrijemeStrEmpty )
			try {
				vrijeme = sdf.parse(vrijemeStr);
			} catch (ParseException e1) {
				rezultat = new ArrayList<PomagaloVO>();
				PomagaloVO p= new PomagaloVO();
				p.setSifra(-1);
				p.setNaziv(e1.toString());
				p.setCijenaSPDVom(0);
				
				rezultat.add(p);
				return rezultat;	
			}


		try {
			kljuc = vrijeme;
			rezultat = this.pomagalaDao.findAll(kljuc);

			if (kljuc == null && pomagalaCache == null)
				pomagalaCache = rezultat;

		} catch (Exception e) {
			rezultat = new ArrayList<PomagaloVO>();
			PomagaloVO p= new PomagaloVO();
			p.setSifra(-1);
			p.setNaziv(e.toString());
			p.setCijenaSPDVom(0);
			
			rezultat.add(p);
			return rezultat;			
		}
		
		if (rezultat==null || rezultat.size()==0)
		{
			rezultat = new ArrayList<PomagaloVO>(1);
			PomagaloVO p= new PomagaloVO();
			p.setSifra(-1);
			p.setNaziv("(nema)");
			rezultat.add(p);			
		}

		return rezultat;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "{id}")
	public
	PomagaloVO getPomagaloPoIdu(
			@PathParam("id") String idStr) {
		try {
			
			
			PomagaloVO rezultat = this.pomagalaDao.read(idStr);

			return rezultat;

		} catch (Exception e) {
			PomagaloVO p= new PomagaloVO();
			p.setSifra(-1);
			p.setNaziv(e.toString());
			p.setCijenaSPDVom(0);
			
			return p;			
		}
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path(value = "{id}")
	public boolean updatePomagalo(
			 PomagaloVO pomagalo) {
		try {
			
			
			 boolean rez = this.pomagalaDao.update(pomagalo);

			return rez;

		} catch (Exception e) {
			
			return false;			
		}
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	@Path(value = "{id}")	 
	public 
	boolean updatePomagaloPUT(
			 PomagaloVO pomagalo) throws SQLException  {
	 
			
			 boolean rez = this.pomagalaDao.update(pomagalo);
			 
			 if (rez)
				 this.pomagalaCache = null;

			return true;
	}
	
}
