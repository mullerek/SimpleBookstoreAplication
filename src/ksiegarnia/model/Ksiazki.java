package ksiegarnia.model;

public class Ksiazki {
	
	private int id_ksiazki;
	private String tytul;
	private String autor;
	private Double cena;
	private int ilosc;
	private int id_kat;
	private int id_wyd;
	private int ilosc_w_koszyku=1;
	
	private String error_id_ksiazki;
	private String error_tytul;
	private String error_autor;
	private String error_cena;
	private String error_ilosc;
	
	public Ksiazki(int id_ksiazki, String tytul, String autor, Double cena, int ilosc, int id_kat, int id_wyd, String error_id_ksiazki,
			String error_tytul, String error_autor, String error_cena, String error_ilosc) {
		super();
		this.id_ksiazki = id_ksiazki;
		this.tytul = tytul;
		this.autor = autor;
		this.cena = cena;
		this.ilosc = ilosc;
		this.id_kat = id_kat;
		this.id_wyd=id_wyd;
		this.error_id_ksiazki = error_id_ksiazki;
		this.error_tytul = error_tytul;
		this.error_autor = error_autor;
		this.error_cena = error_cena;
		this.error_ilosc = error_ilosc;
	}
	public Ksiazki(int id_ksiazki, String tytul, String autor, Double cena, int ilosc, int id_kat, int id_wyd) {
		super();
		this.id_ksiazki = id_ksiazki;
		this.tytul = tytul;
		this.autor = autor;
		this.cena = cena;
		this.ilosc = ilosc;
		this.id_kat = id_kat;
		this.id_wyd=id_wyd;
	}
	public Ksiazki(String tytul, String autor, Double cena, int ilosc, int id_kat, int id_wyd) {
		super();
		this.tytul = tytul;
		this.autor = autor;
		this.cena = cena;
		this.ilosc = ilosc;
		this.id_kat = id_kat;
		this.id_wyd=id_wyd;
	}
	
	public Ksiazki() {
		// TODO Auto-generated constructor stub
	}
	public int getId_ksiazki() {
		return id_ksiazki;
	}
	public void setId_ksiazki(int id_ksiazki) {
		this.id_ksiazki = id_ksiazki;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
	public int getIlosc() {
		return ilosc;
	}
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}
	public int getId_kat() {
		return id_kat;
	}
	public void setId_kat(int id_kat) {
		this.id_kat = id_kat;
	}
	public int getId_wyd() {
		return id_wyd;
	}
	public void setId_wyd(int id_wyd) {
		this.id_wyd = id_wyd;
	}
	public String getError_id_ksiazki() {
		return error_id_ksiazki;
	}
	public void setError_id_ksiazki(String error_id_ksiazki) {
		this.error_id_ksiazki = error_id_ksiazki;
	}
	public String getError_tytul() {
		return error_tytul;
	}
	public void setError_tytul(String error_tytul) {
		this.error_tytul = error_tytul;
	}
	public String getError_autor() {
		return error_autor;
	}
	public void setError_autor(String error_autor) {
		this.error_autor = error_autor;
	}
	public String getError_cena() {
		return error_cena;
	}
	public void setError_cena(String error_cena) {
		this.error_cena = error_cena;
	}
	public String getError_ilosc() {
		return error_ilosc;
	}
	public void setError_ilosc(String error_ilosc) {
		this.error_ilosc = error_ilosc;
	}
	public int getIlosc_w_koszyku() {
		return ilosc_w_koszyku;
	}
	public void setIlosc_w_koszyku(int ilosc_w_koszyku) {
		this.ilosc_w_koszyku = ilosc_w_koszyku;
	}
	
}
