package biz.sunce.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import biz.sunce.dao.PomagalaDAO;
import biz.sunce.db.ConnectionFactory;
import biz.sunce.web.dto.PomagaloVO;

@Controller
public final class PomagalaController {

	private PomagalaDAO pomagalaDao;

	public PomagalaController() {
		ConnectionFactory.inject(PomagalaDAO.getCnf());
		this.pomagalaDao = new PomagalaDAO(ConnectionFactory.getDbConnection());
	}

	private List<PomagaloVO> pomagalaCache=null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	
	@RequestMapping(value = "/rest/v1/pomagala", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<PomagaloVO> getPomagala(
			@RequestParam(value = "timestamp", defaultValue = "") String vrijemeStr) {

		if (vrijemeStr==null && pomagalaCache!=null)
			return pomagalaCache;
		
		
		Date vrijeme = null;
		
		try {
			vrijeme = sdf.parse(vrijemeStr);
		} catch (ParseException e1) {
			return null;
		}
		
		Object kljuc = null;
		List<PomagaloVO> rezultat = null;
		
		try {
			kljuc = vrijeme;
			rezultat = this.pomagalaDao.findAll(kljuc);
			
			if (kljuc==null && pomagalaCache==null)
				pomagalaCache = rezultat;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rezultat;
	}
}
