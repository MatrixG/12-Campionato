package pkgCampionato;

import java.util.Date;

public class Partita {
	
	private Squadra squadraOspite;
	private Squadra squadraCasa;
	private Date data;
	private int retiCasa;
	private int retiOspite;
	private char risultato;
	
	
	public Partita(Squadra squadraCasa, Squadra squadraOspite, Date data, int retiCasa, int retiOspite) {
		
		this.squadraOspite = squadraOspite;
		this.squadraCasa = squadraCasa;
		this.data = data;
		this.retiCasa = retiCasa;
		this.retiOspite = retiOspite;
		
		int tmp = retiCasa - retiOspite;
		if (tmp == 0){
			this.risultato = 'x';
		}
		else if(tmp > 0){
			this.risultato = '1';
		}
		else{
			this.risultato = '2';
		}
	}

	public Squadra getSquadraOspite() {
		return squadraOspite;
	}

	public Squadra getSquadraCasa() {
		return squadraCasa;
	}

	public Date getData() {
		return data;
	}

	public int getRetiCasa() {
		return retiCasa;
	}

	public int getRetiOspite() {
		return retiOspite;
	}

	public char getRisultato() {
		return risultato;
	}
}
