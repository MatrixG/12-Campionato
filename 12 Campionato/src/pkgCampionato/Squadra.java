package pkgCampionato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Squadra {
	
	private String nome;
	private int punti;
	private int retiSubite;
	private int retiSegnate;
	private Map<String, Giocatore> listaGiocatori;

	
	public Squadra(String nome) {

		this.nome = nome;
		punti = 0;
		retiSegnate = 0;
		retiSubite = 0;
		listaGiocatori = new HashMap<String, Giocatore>();
	}


	public int getPunti() {
		return punti;
	}


	public void setPunti(int punti) {
		this.punti += punti;
	}


	public int getRetiSubite() {
		return retiSubite;
	}


	public void setRetiSubite(int retiSubite) {
		this.retiSubite += retiSubite;
	}


	public int getRetiSegnate() {
		return retiSegnate;
	}


	public void setRetiSegnate(int retiSegnate) {
		this.retiSegnate += retiSegnate;
	}


	public String getNome() {
		return nome;
	}


	public boolean aggiungiGiocatore(Giocatore g) {
		
		if (!listaGiocatori.containsKey(g.getCF())){
			listaGiocatori.put(g.getCF(), g);
			return true;
		}
		return false;
	}


	public List<Giocatore> getRosa() {
		
		return new ArrayList<Giocatore>(listaGiocatori.values());
	}


	public int getDiffReti() {
		
		return retiSegnate - retiSubite;
	}
}
