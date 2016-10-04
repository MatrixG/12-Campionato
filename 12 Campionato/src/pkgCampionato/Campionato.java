package pkgCampionato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pkgComparator.PlayerComparator;
import pkgComparator.TeamComparator;

public class Campionato {
	
	private final int vittoria = 3;
	private final int pareggio = 1;
	
	private String nome;
	private Map<String, Giocatore> giocatori;
	private Map<String, Partita> partite;
	private Map<String, Squadra> squadre;
	

	public Campionato(String nome) {

		this.nome = nome;
		partite = new HashMap<String, Partita>();
		squadre = new HashMap<String, Squadra>();
		giocatori = new HashMap<String, Giocatore>();
	}

	public String getNome() {
		return nome;
	}

	public boolean giocatorepresente(String cF) {
		
		if (giocatori.containsKey(cF))
			return true;
		
		return false;
	}

	public Giocatore aggiungiGiocatore(Giocatore giocatore) {
		giocatori.put(giocatore.getCF(), giocatore);
		return giocatori.get(giocatore.getCF());
	}

	public boolean squadraPresente(String nome2) {
		
		return squadre.containsKey(nome2);
	}

	public Squadra aggiungiSquadra(String nome2) {
		
		squadre.put(nome2, new Squadra(nome2));
		
		return squadre.get(nome2);
	}

	public boolean aggiungiGiocatoreASquadra(Giocatore g, Squadra s) {
		
		if ((g != null) && (s != null) && (squadre.get(s.getNome()) != null)){
			return s.aggiungiGiocatore(g);
		}
		
		return false;
	}

	public void aggiungiPartita(Partita p, List<Giocatore> retiFatte, List<Giocatore> espulsi,
			List<Giocatore> ammoniti) {
		
		partite.put(p.getSquadraCasa().getNome() + p.getSquadraOspite().getNome(), p);
		
		for (Giocatore g : retiFatte){
			giocatori.get(g.getCF()).setReti();
		}
		for (Giocatore g : espulsi){
			giocatori.get(g.getCF()).setEspulsione();
		}
		for (Giocatore g : ammoniti){
			giocatori.get(g.getCF()).setAmmonizione();
		}
		aggiornaClassifica(p);
	}

	private void aggiornaClassifica(Partita p) {
		
		char res = p.getRisultato();
		if (res == '1'){
			p.getSquadraCasa().setPunti(vittoria);
		}
		else if (res == 'x'){
			p.getSquadraCasa().setPunti(pareggio);
			p.getSquadraOspite().setPunti(pareggio);
		}
		else {
			p.getSquadraOspite().setPunti(vittoria);
		}
		
		p.getSquadraCasa().setRetiSegnate(p.getRetiCasa());
		p.getSquadraOspite().setRetiSegnate(p.getRetiOspite());
		
		p.getSquadraCasa().setRetiSubite(p.getRetiOspite());
		p.getSquadraOspite().setRetiSubite(p.getRetiCasa());
	}

	public Giocatore classificaMarcatori() {
		
		List<Giocatore> temp = new ArrayList<Giocatore>(giocatori.values());
		Collections.sort(temp, new PlayerComparator());
		
		return temp.get(0);
	}

	public Squadra trovaVincitore(Campionato c) {
		
		List<Squadra> temp = new ArrayList<Squadra>(squadre.values());
		Collections.sort(temp, new TeamComparator(c));
		
		return temp.get(0);
	}

	public Map<String, Partita> getPartite() {
		return partite;
	}
	
	public Map<String, Giocatore> getCalciatori() {
		
		return giocatori;
	}

	public List<Giocatore> getCalciatoriL() {
		
		return new ArrayList<Giocatore>(giocatori.values());
	}

	public Map<String, Squadra> getPartecipanti() {
		
		return squadre;
	}
	
	

}
