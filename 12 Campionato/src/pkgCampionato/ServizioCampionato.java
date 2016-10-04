package pkgCampionato;


import java.util.Date;
import java.util.List;

public class ServizioCampionato {
	

	
	public ServizioCampionato(){
	}
	
	
	public Giocatore registraGiocatore (Campionato c, String nome, String cognome, String cF,
										String ruolo, int stipendio, int età){
		
		if (c != null && !c.giocatorepresente(cF)){
			return c.aggiungiGiocatore (new Giocatore(nome, cognome, cF, ruolo, stipendio, età));
		}
		
		return null;
	}
	
	public Giocatore registraGiocatore (Campionato c, String nome, String cognome, String ruolo,
			String cF, int età){

		if (c != null && !c.giocatorepresente(cF)){
			return c.aggiungiGiocatore (new Giocatore(nome, cognome, cF, ruolo, età));
		}

		return null;
	}
	
	public Squadra registraSquadra (Campionato c, String nome){
		
		if (c != null && !c.squadraPresente(nome))
		 	return c.aggiungiSquadra(nome);
		
		return null;
	}
	
	public boolean assegnaGiocatoreSquadra(Campionato c, Giocatore g, Squadra s){
		
		if (c != null)
			return c.aggiungiGiocatoreASquadra(g, s);
		return false;
	}
	
	public Partita registraPartita (Campionato c , Squadra sCasa, Squadra sOspite,
									int rCasa, int rOspiti, Date dataP, 
									List<Giocatore> retiFatte,
									List<Giocatore> espulsi,
									List<Giocatore> ammoniti){
		
		if ((c != null) && (sCasa != null) && (sOspite != null)){
			
			for (Giocatore g : retiFatte){
				if (!c.giocatorepresente(g.getCF())){
					return null;
				}
			}
			for (Giocatore g : espulsi){
				if (!c.giocatorepresente(g.getCF())){
					return null;
				}
			}
			for (Giocatore g : ammoniti){
				if (!c.giocatorepresente(g.getCF())){
					return null;
				}
			}
		}	
		Partita p = new Partita(sCasa, sOspite, dataP, rCasa, rOspiti);
		c.aggiungiPartita(p, retiFatte, espulsi, ammoniti);
		
		return p;
	}
	
	public Giocatore getCapoCannoniere(Campionato c){
		
		if (c != null){
			return c.classificaMarcatori();
		}
		
		return null;
	}
	
	public Squadra getCampione (Campionato c){
		
		if (c != null){
			return c.trovaVincitore(c);
		}
		
		return null;
	}
	
	
	

}
