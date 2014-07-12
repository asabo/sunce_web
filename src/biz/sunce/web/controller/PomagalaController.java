package biz.sunce.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	private List<PomagaloVO> pomagalaCache = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@RequestMapping(value = "/rest/v1/pomagala", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<PomagaloVO> getPomagala(
			@RequestParam(value = "timestamp", defaultValue = "") String vrijemeStr) {

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
			rezultat = new ArrayList<PomagaloVO>();
			PomagaloVO p= new PomagaloVO();
			p.setSifra(-1);
			p.setNaziv("(nema)");
			rezultat.add(p);			
		}

		return rezultat;
	}
}
