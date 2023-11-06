package SpringBootApplication;

public class Deltager {

	
	private String fornavn;
	
	private String etternavn;
	
	private int mobil;
	
	private String passord;
	private Kjonn kjonn;
	
	public Deltager(String fornavn, String etternavn, int mobil,  String passord, Kjonn kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = passord;
		this.kjonn = kjonn;
	}
	
	public Deltager(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public Deltager() {
		
	}

	public int getMobil() {
		return mobil;
	}
	public void setMobil(int mobil) {
		this.mobil = mobil;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public String getPassord() {
		return passord;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}
	public Kjonn getKjonn() {
		return kjonn;
	}
	public void setKjonn(Kjonn kjonn) {
		this.kjonn = kjonn;
	}
	
	@Override
	public String toString() {
		return "Deltager [fornavn=" + fornavn + ", etternavn=" + etternavn + ", mobil=" + mobil + ", passord=" + passord
				+ ", kjonn=" + kjonn + "]";
	}
	
}
