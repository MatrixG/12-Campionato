package pkgCampionato;

public class Giocatore {
	
	private String nome;
	private String cognome;
	private String CF;
	private String ruolo;
	private int stipendio;
	private int età;
	private int ammonizione;
	private int reti;
	private int assist;
	private int espulsione;
	
	
	public Giocatore(String nome, String cognome, String cF, String ruolo, 
						int stipendio, int età) {
		
		this.nome = nome;
		this.cognome = cognome;
		CF = cF;
		this.ruolo = ruolo;
		this.stipendio = stipendio;
		this.età = età;
		this.ammonizione = 0;
		this.reti = 0;
		this.assist = 0;
		this.espulsione = 0;
	}
	
	public Giocatore(String nome, String cognome, String cF, String ruolo, 
			int età) {

		this.nome = nome;
		this.cognome = cognome;
		CF = cF;
		this.ruolo = ruolo;
		this.stipendio = 0;
		this.età = età;
		this.ammonizione = 0;
		this.reti = 0;
		this.assist = 0;
		this.espulsione = 0;
	}


	public int getAmmonizione() {
		return ammonizione;
	}


	public void setAmmonizione(){
		this.ammonizione++;
	}


	public int getReti() {
		return reti;
	}


	public void setReti() {
		this.reti++;
	}


	public int getAssist() {
		return assist;
	}


	public void setAssist(int assist) {
		this.assist = assist;
	}


	public int getEspulsione() {
		return espulsione;
	}


	public void setEspulsione() {
		this.espulsione++;
	}


	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	public String getCF() {
		return CF;
	}


	public String getRuolo() {
		return ruolo;
	}


	public int getStipendio() {
		return stipendio;
	}


	public int getEtà() {
		return età;
	}
	
	
	
}
