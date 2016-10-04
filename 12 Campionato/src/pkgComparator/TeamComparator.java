package pkgComparator;

import java.util.Comparator;
import java.util.Map;

import pkgCampionato.*;

public class TeamComparator implements Comparator<Squadra> {
	
	private Campionato c; 
	
	public TeamComparator (Campionato c){
		
		this.c = c;
	}

	
	public int compare(Squadra arg1, Squadra arg0) {
	
		int res = arg0.getPunti() - arg1.getPunti();
		if (res == 0){
			res = (arg0.getRetiSegnate() - arg0.getRetiSubite()) - (arg1.getRetiSegnate() - arg1.getRetiSubite());
			if (res == 0){
				Map<String, Partita> partite = c.getPartite();
				int retiDiArg0 = partite.get(arg0.getNome() + arg1.getNome()).getRetiCasa() +
								 partite.get(arg1.getNome() + arg0.getNome()).getRetiOspite();
				
				int retiDiArg1 = partite.get(arg0.getNome() + arg1.getNome()).getRetiOspite() +
						 		 partite.get(arg1.getNome() + arg0.getNome()).getRetiCasa();
				
				return retiDiArg0 - retiDiArg1;  
			}
		}
		return res;
	}

}
