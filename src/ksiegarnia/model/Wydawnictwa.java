package ksiegarnia.model;

public class Wydawnictwa {

	private int id_wyd;
	private String nazwa;
	
	private String error_id_wyd;
	private String error_nazwa;
	
	public Wydawnictwa(int id_wyd, String nazwa, String error_id_wyd, String error_nazwa) {
		super();
		this.id_wyd = id_wyd;
		this.nazwa = nazwa;
		this.error_id_wyd = error_id_wyd;
		this.error_nazwa = error_nazwa;
	}
	public Wydawnictwa(int id_wyd, String nazwa) {
		super();
		this.id_wyd = id_wyd;
		this.nazwa = nazwa;
	}
	public Wydawnictwa(String nazwa) {
		super();
		this.nazwa = nazwa;
	}
	
	public int getId_wyd() {
		return id_wyd;
	}
	public void setId_wyd(int id_wyd) {
		this.id_wyd = id_wyd;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getError_id_wyd() {
		return error_id_wyd;
	}
	public void setError_id_wyd(String error_id_wyd) {
		this.error_id_wyd = error_id_wyd;
	}
	public String getError_nazwa() {
		return error_nazwa;
	}
	public void setError_nazwa(String error_nazwa) {
		this.error_nazwa = error_nazwa;
	}
}
