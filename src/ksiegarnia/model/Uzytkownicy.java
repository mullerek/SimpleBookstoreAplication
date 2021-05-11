package ksiegarnia.model;

public class Uzytkownicy {

	private int idklienta;
	private String imie;
	private String nazwisko;
	private String miejscowosc;
	private String ulica;
	private String kod_pocztowy;
	private String email;
	private String login;
	private String haslo;


	private String error_id_klienta;
	private String error_imie;
	private String error_nazwisko;
	private String error_miejscowosc;
	private String error_ulica;
	private String error_kod_pocztowy;
	private String error_email;
	private String error_login;
	private String error_haslo;
	
	public Uzytkownicy(int idklienta, String imie, String nazwisko, String miejscowosc, String ulica,
			String kod_pocztowy, String email, String login, String haslo, String error_id_klienta, String error_imie,
			String error_nazwisko, String error_miejscowosc, String error_ulica, String error_kod_pocztowy,
			String error_email, String error_login, String error_haslo) {
		super();
		this.idklienta = idklienta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miejscowosc = miejscowosc;
		this.ulica = ulica;
		this.kod_pocztowy = kod_pocztowy;
		this.email = email;
		this.login = login;
		this.haslo = haslo;
		this.error_id_klienta = error_id_klienta;
		this.error_imie = error_imie;
		this.error_nazwisko = error_nazwisko;
		this.error_miejscowosc = error_miejscowosc;
		this.error_ulica = error_ulica;
		this.error_kod_pocztowy = error_kod_pocztowy;
		this.error_email = error_email;
		this.error_login = error_login;
		this.error_haslo = error_haslo;
	}
	
	public Uzytkownicy(String imie, String nazwisko, String miejscowosc, String ulica,
			String kod_pocztowy, String email) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miejscowosc = miejscowosc;
		this.ulica = ulica;
		this.kod_pocztowy = kod_pocztowy;
		this.email = email;
	}
	
	public Uzytkownicy(int idklienta, String imie, String nazwisko, String miejscowosc, String ulica,
			String kod_pocztowy, String email) {
		super();
		this.idklienta = idklienta;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.miejscowosc = miejscowosc;
		this.ulica = ulica;
		this.kod_pocztowy = kod_pocztowy;
		this.email = email;
	}
	
	public Uzytkownicy(String login, String haslo) {
		super();
		this.login = login;
		this.haslo = haslo;
	}
	
	public Uzytkownicy(int idklienta, String login, String haslo) {
		super();
		this.idklienta = idklienta;
		this.login = login;
		this.haslo = haslo;
	}

	public Uzytkownicy() {
		// TODO Auto-generated constructor stub
	}

	public int getIdklienta() {
		return idklienta;
	}

	public void setIdklienta(int idklienta) {
		this.idklienta = idklienta;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getKod_pocztowy() {
		return kod_pocztowy;
	}

	public void setKod_pocztowy(String kod_pocztowy) {
		this.kod_pocztowy = kod_pocztowy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getError_id_klienta() {
		return error_id_klienta;
	}

	public void setError_id_klienta(String error_id_klienta) {
		this.error_id_klienta = error_id_klienta;
	}

	public String getError_imie() {
		return error_imie;
	}

	public void setError_imie(String error_imie) {
		this.error_imie = error_imie;
	}

	public String getError_nazwisko() {
		return error_nazwisko;
	}

	public void setError_nazwisko(String error_nazwisko) {
		this.error_nazwisko = error_nazwisko;
	}

	public String getError_miejscowosc() {
		return error_miejscowosc;
	}

	public void setError_miejscowosc(String error_miejscowosc) {
		this.error_miejscowosc = error_miejscowosc;
	}

	public String getError_ulica() {
		return error_ulica;
	}

	public void setError_ulica(String error_ulica) {
		this.error_ulica = error_ulica;
	}

	public String getError_kod_pocztowy() {
		return error_kod_pocztowy;
	}

	public void setError_kod_pocztowy(String error_kod_pocztowy) {
		this.error_kod_pocztowy = error_kod_pocztowy;
	}

	public String getError_email() {
		return error_email;
	}

	public void setError_email(String error_email) {
		this.error_email = error_email;
	}

	public String getError_login() {
		return error_login;
	}

	public void setError_login(String error_login) {
		this.error_login = error_login;
	}

	public String getError_haslo() {
		return error_haslo;
	}

	public void setError_haslo(String error_haslo) {
		this.error_haslo = error_haslo;
	}
	
	
}
