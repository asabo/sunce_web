package biz.sunce.web.dto;

public final class Registracija {

	private String naziv;
	private String adresa;
	private String mjesto;
	private String oib;
	private String hzzoBroj;	
	private String email;
	private String telefon;	
		
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getMjesto() {
		return mjesto;
	}
	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}
	public String getOib() {
		return oib;
	}
	public void setOib(String oib) {
		this.oib = oib;
	}
	public String getHzzoBroj() {
		return hzzoBroj;
	}
	public void setHzzoBroj(String hzzoBroj) {
		this.hzzoBroj = hzzoBroj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
}
