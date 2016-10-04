package pkgComparator;

import java.util.Comparator;
import pkgCampionato.*;

public class PlayerComparator implements Comparator<Giocatore>{

	
	public int compare(Giocatore o2, Giocatore o1) {
		
		int resReti = o1.getReti() - o2.getReti();
		if (resReti == 0){
			int resCognome = o1.getCognome().compareToIgnoreCase(o2.getCognome());
			if (resCognome == 0){
			 int  resNome = o1.getNome().compareToIgnoreCase(o2.getNome());
				return resNome;
			}else{
				return resCognome;
			}
		}
		return resReti;
	}
}
