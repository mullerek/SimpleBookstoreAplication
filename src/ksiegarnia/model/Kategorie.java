package ksiegarnia.model;

public class Kategorie {

	private int id_kat;
	private String nazwa;
	
	private String error_id_kat;
	private String error_nazwa;
	
	public Kategorie(int id_kat, String nazwa) {
		super();
		this.id_kat = id_kat;
		this.nazwa = nazwa;
	}
	
	public Kategorie(String nazwa) {
		super();
		this.nazwa = nazwa;
	}
	
	public Kategorie(int id_kat, String nazwa, String error_id_kat, String error_nazwa) {
		super();
		this.id_kat = id_kat;
		this.nazwa = nazwa;
		this.error_id_kat = error_id_kat;
		this.error_nazwa = error_nazwa;
	}
	
	public int getId_kat() {
		return id_kat;
	}
	public void setId_kat(int id_kat) {
		this.id_kat = id_kat;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getError_id_kat() {
		return error_id_kat;
	}
	public void setError_id_kat(String error_id_kat) {
		this.error_id_kat = error_id_kat;
	}
	public String getError_nazwa() {
		return error_nazwa;
	}
	public void setError_nazwa(String error_nazwa) {
		this.error_nazwa = error_nazwa;
	}

}
