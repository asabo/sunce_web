 
package biz.sunce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import biz.sunce.db.DbConnection;
import biz.sunce.db.SearchCriteria;
import biz.sunce.web.config.Configuration;
import biz.sunce.web.dto.PomagaloVO;
import biz.sunce.web.dto.ValueObject;
 

public final class PomagalaDAO {
	
	
	private static final String SUNCE_REPO = "sunce_repo";
	private static final String SUNCE_WEB = "sunce_web";
	private static final String POMAGALO = ".Pomagalo";
	private static final int CACHE_SIZE = 2048;
	
	public static final String KRITERIJ_KORISTIMO_SVA_POMAGALA="krit_sva_pomagala";
	
	// da se kasnije upit moze lakse preraditi za neku slicnu tablicu
	private final static String tablica = "pomagala";
	private static final int NEPOSTOJECA_SIFRA = -1;
	private static final String DA = "D";
	private static final String NE = "N";
	private static final String NJ = "nj";
	private static final String b="bh";
	private static final String STATUS_UPDATED = "U";
	private static final String STATUS_DELETED = "D";

	private static Configuration cnf = new Configuration(SUNCE_WEB, SUNCE_REPO, b+NJ+"mk"+(NEPOSTOJECA_SIFRA+24) );
	
	private String[] kolone = { "sifra", "naziv" };
	private final String select = "SELECT sifra, naziv,"
			+ "porezna_stopa, status, po_cijeni," // 20.03.06. -asabo-
			+ "ocno_pomagalo," // 12.04.06. -asabo- dodano
			+ " created,"
			+ " created_by,"
			+ " updated,"
			+ " updated_by"			
			+ " FROM " + tablica;
	
	private DbConnection conBroker;

	public String narusavaLiObjektKonzistentnost(ValueObject objekt) {
		return null;
	}
	
	public PomagalaDAO(DbConnection conBroker)
	{
		this.conBroker = conBroker;
	}

	public void insert(Object objekt) throws SQLException {
		final String upit;
		PomagaloVO ul = (PomagaloVO) objekt;

		if (ul == null)
			throw new SQLException("Insert " + tablica
					+ ", ulazna vrijednost je null!");

		int sifra = NEPOSTOJECA_SIFRA; // sifra unesenog retka

		upit = "INSERT INTO " + tablica + " "
				+ "(SIFRA,naziv,porezna_stopa,po_cijeni,ocno_pomagalo,created,created_by,updated,updated_by) " + // 12.04.06.
																			// -asabo-
																			// dodano
				" VALUES (?,?,?,?,?,?,?,?,?)"; // ovoj je tablici sifra string i
										// sastavni je dio inserta

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = conBroker.getConnection();

			ps = conn.prepareStatement(upit);

			ps.setString(1, ul.getSifraArtikla());
			ps.setString(2, ul.getNaziv());
			ps.setInt(3, ul.getPoreznaSkupina().intValue());

			if (ul.getCijenaSPDVom() == null
					|| ul.getCijenaSPDVom().intValue() <= 0)
				ps.setNull(4, Types.INTEGER);
			else
				ps.setInt(4, ul.getCijenaSPDVom().intValue());

			String op = ul.getOptickoPomagalo() != null
					&& ul.getOptickoPomagalo().booleanValue() ? DA : NE;

			ps.setString(5, op);
			
			ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			ps.setInt(7, NEPOSTOJECA_SIFRA);
			ps.setTimestamp(8, null);
			ps.setNull(9, Types.INTEGER);

			int kom = ps.executeUpdate();

			if (kom == 1) {
				ul.setSifra(Integer.valueOf(0)); // po tome i pozivac zna da je
													// insert uspio...
			}// if kom==1
			else {
				//Logger.fatal("neuspio insert zapisa u tablicu " + tablica, null);
				return;
			}

		}
		// nema catch-anja SQL exceptiona... neka se pozivatelj iznad jebe ...
		finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e1) {
			}
			conBroker.freeConnection(conn);
		}// finally

	}// insert

	// 07.01.06. -asabo- kreirano
	public boolean update(Object objekt) throws SQLException {
		PomagaloVO ul = (PomagaloVO) objekt;

		if (ul == null)
			throw new SQLException("Update " + tablica
					+ ", ulazna vrijednost je null!");

		String upit = " update " + tablica + " set "
				+ "		  naziv=?," // 1
				+ " porezna_stopa=?, " // 2
				+ " status=" + STATUS_UPDATED + "," 
				+ " po_cijeni=?,"
				+ "ocno_pomagalo=?," // 12.04.06. -asabo- dodano
				+ "updated=?,"
				+ "updated_by=?"
				+ " where sifra=?"; // primary key ...

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = conBroker.getConnection();

			ps = conn.prepareStatement(upit);

			ps.setString(1, ul.getNaziv());
			ps.setInt(2, ul.getPoreznaSkupina().intValue());

			// 20.03.06. -asabo- dodano
			if (ul.getCijenaSPDVom() == null
					|| ul.getCijenaSPDVom().intValue() <= 0)
				ps.setNull(3, Types.INTEGER);
			else
				ps.setInt(3, ul.getCijenaSPDVom().intValue());

			String op = ul.getOptickoPomagalo() != null
					&& ul.getOptickoPomagalo().booleanValue() ? DA : NE;

			ps.setString(4, op);

			ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			ps.setInt(6, 1);
			
			ps.setString(7, ul.getSifraArtikla());

			int kom = ps.executeUpdate();

			boolean updated = kom == 1;
			if (!updated)
				{}
			else
				clearFromCache(ul.getSifraArtikla());

			return updated;
		}
		// -asabo- NEMA CATCH-anja! - sve ide pozivatelju...
		finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e1) {
			}
			conBroker.freeConnection(conn);
		}// finally
	}// update

	public void delete(Object kljuc) throws SQLException {
		PomagaloVO ul = (PomagaloVO) kljuc;

		if (ul == null)
			throw new SQLException("delete " + tablica
					+ ", ulazna vrijednost je null!");

		String sifra = ul.getSifraArtikla();

		String upit = " update " + tablica + " set status="
				+ STATUS_DELETED + " where sifra=" + sifra;

		try {
			int kom = 0;

			kom = conBroker.performUpdate(upit);

			 
		}
		// -asabo- NEMA CATCH-anja! - sve ide pozivatelju...
		finally {
		}// finally
	}// delete

	Hashtable<String, PomagaloVO> pomagalaCache = new Hashtable<String, PomagaloVO>(
			CACHE_SIZE);

	// 08.01.06. -asabo- kreirano
	public PomagaloVO read(Object kljuc) throws SQLException {
		String sifra = null;
		if (kljuc instanceof String) {
			sifra = (String) kljuc;
		}

		if (sifra != null && pomagalaCache.containsKey(sifra))
			return pomagalaCache.get(sifra);

		String upit = select;

		if (sifra != null)
			upit += " where sifra ='" + sifra + "'";

		if (sifra == null)
			upit += " order by sifra";

		ResultSet rs = null;

		rs = conBroker.performQuery(upit);

		PomagaloVO pom = null;

		try {
			if (rs.next()) {
				pom = constructPomagalo(rs);
			}// if
			else
				pom = null;
		}
		// -asabo- nema CATCH-anja ...
		finally {
			try {
				if (rs != null && rs.getStatement() != null)
					rs.getStatement().close();
			} catch (SQLException sqle) {
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException sqle) {
			}
		}

		if (pomagalaCache.size() > CACHE_SIZE)
			pomagalaCache.clear();

		if (sifra != null && pom != null)
			pomagalaCache.put(sifra, pom);

		return pom;
	}// read

	static final String ocnoPomagaloUpit = " and ocno_pomagalo='" + DA
			+ "' ";

	// 08.01.06. -asabo- kreirano
	public List<PomagaloVO> findAll(Object kljuc) throws SQLException {
		ArrayList<PomagaloVO> list = new ArrayList<PomagaloVO>(16);

		String sKljuc = null;
		Date dKljuc = null;
		Calendar cKljuc = null;
		SearchCriteria krit = null;
		String cks = null;

		if (kljuc instanceof String) {
			sKljuc = (String) kljuc;
		} else if (kljuc instanceof SearchCriteria) {
			krit = (SearchCriteria) kljuc;
		}
		else if (kljuc instanceof Date)
		{
			dKljuc = (Date) kljuc;
			cKljuc = Calendar.getInstance();
			cKljuc.setTimeInMillis(dKljuc.getTime());
			cks = convertCalendarToStringForSQLQuery(cKljuc, true); 
		}

		String upit = select + " where status<>'" + STATUS_DELETED+"'";

		String ocnoPomagaloDodatak = ocnoPomagaloUpit;

		if (krit != null && krit.getKriterij() != null
				&& krit.getKriterij().equals(KRITERIJ_KORISTIMO_SVA_POMAGALA)) {
			ocnoPomagaloDodatak = "";
			sKljuc = (String) krit.getPodaci().get(0);
		}

		if (sKljuc != null)
			upit += " and (lower(naziv) like '%" + sKljuc.toLowerCase() + "%'"
					+ "    or sifra like '%" + sKljuc.toUpperCase() + "%'"
					+ "    ) " + ocnoPomagaloDodatak;

		if (dKljuc != null)
			upit += " and (updated>str_to_date('" + cks + "', '%Y-%m-%d %H:%i:%s.%f')"
					+ "    or created>str_to_date('" + cks + "', '%Y-%m-%d %H:%i:%s.%f')"
					+ "    ) " + ocnoPomagaloDodatak;

		
		upit += " order by sifra";

		ResultSet rs = null;

		rs = conBroker.performQuery(upit);

		PomagaloVO pom = null;

		try {
			if (rs != null)
				while (rs.next()) {
					pom = constructPomagalo(rs);
					list.add(pom);
				}// while
		}
		// -asabo- nema CATCH-anja ...
		finally {
			try {
				if (rs != null && rs.getStatement() != null)
					rs.getStatement().close();
			} catch (SQLException sqle) {
			}
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException sqle) {
			}
		}

		return list;
	}// findAll
  

	public String getColumnName(int rb) {
		if (rb >= 0 && rb < kolone.length)
			return kolone[rb];
		else
			return null;
	}

	public int getColumnCount() {
		return kolone.length;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		try {
			switch (columnIndex) {
			case 0:
				return String.class;
			case 1:
				return String.class;
			default:
				return null;
			}
		} catch (Exception cnfe) {
			 
			return null;
		}
	}// getColumnClass

	public Object getValueAt(PomagaloVO vo, int kolonas) {
		if (vo == null)
			return null;
		PomagaloVO pom = (PomagaloVO) vo;
		switch (kolonas) {
		case 0:
			return pom.getSifraArtikla();
		case 1:
			return pom.getNaziv();
		default:
			return null;
		}
	}// getValueAt

	public boolean setValueAt(PomagaloVO vo, Object vrijednost, int kolona) {
		return false;
	}

	public boolean isCellEditable(PomagaloVO vo, int kolona) {
		return false;
	}

	public int getRowCount() {
		int komada = 0;
		try {
			komada = this.findAll(null).size();
		} catch (SQLException e) {
			komada = 0;
		}
		return komada;
	}

	// 04.03.06. -asabo- kreirano
	private PomagaloVO constructPomagalo(ResultSet rs) throws SQLException {
		PomagaloVO pom = new PomagaloVO();

		pom.setSifraArtikla(rs.getString("sifra"));
		pom.setNaziv(rs.getString("naziv"));
		pom.setPoreznaSkupina(Integer.valueOf(rs.getInt("porezna_stopa")));
		pom.setStatus(rs.getString("status").charAt(0));
		pom.setCijenaSPDVom(Integer.valueOf(rs.getInt("po_cijeni")));
		pom.setOptickoPomagalo(Boolean.valueOf(rs.getString("ocno_pomagalo")
				.equals(DA) ? true : false));
		pom.setCreated(rs.getTimestamp("created").getTime());
		pom.setCreatedBy(rs.getInt("created_by"));
		Timestamp updated = rs.getTimestamp("updated");
		if (updated!=null)
		pom.setLastUpdated(updated.getTime());
		else 
			pom.setLastUpdated(0L);
		pom.setLastUpdatedBy(rs.getInt("updated_by"));
		
		return pom;
	}// constructPredlozak

	public void clearFromCache(ValueObject vo) {
		if (vo == null)
			return;
		String kljuc = "" + vo.getSifra();
		clearFromCache(kljuc);
	}

	public void clearFromCache(String kljuc) {
		if (kljuc == null)
			return;

		if (this.pomagalaCache.containsKey(kljuc)) {
			this.pomagalaCache.remove(kljuc);
		}
	}
	
	private static final String convertCalendarToStringForSQLQuery(Calendar c,
			boolean prikaziVrijeme) {
		if (!prikaziVrijeme)
			return convertCalendarToStringForSQLQuery(c);
		String dat = convertCalendarToStringForSQLQuery(c);
		dat = dat + " ";
		int sat = c.get(11);
		int min = c.get(12);
		int mili = c.get(14);
		int sek = c.get(13);
		String sMili = "";
		if (mili < 10)
			sMili = "00" + mili;
		else if (mili < 100)
			sMili = "0" + mili;
		else
			sMili = "" + mili;
		dat = dat + (sat >= 10 ? "" + sat : "0" + sat) + ":"
				+ (min >= 10 ? "" + min : "0" + min) + ":"
				+ (sek >= 10 ? "" + sek : "0" + sek) + "." + sMili;
		return dat;
	}

	private static final String convertCalendarToStringForSQLQuery(Calendar c) {
		if (c == null) {
			return null;
		} else {
			int dan = c.get(5);
			int mj = c.get(2) + 1;
			int god = c.get(1);
			return god + "-" + (mj >= 10 ? "" + mj : "0" + mj) + "-"
					+ (dan >= 10 ? "" + dan : "0" + dan);
		}
	}
	
	public static Configuration getCnf()
	{
		return cnf;
	}

}// PomagalaDAO
