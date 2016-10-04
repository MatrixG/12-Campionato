import pkgCampionato.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CampionatoTest {
		
@SuppressWarnings("unused")
public static void main(String[] args) throws ParseException {

	Campionato c = new Campionato("Serie A");
	ServizioCampionato s = new ServizioCampionato();
	
	List<Giocatore> marcatori = new ArrayList<Giocatore>();
	List<Giocatore> espulsi = new ArrayList<Giocatore>();
	List<Giocatore> ammoniti = new ArrayList<Giocatore>();
	List<Giocatore> marcatori1 = new ArrayList<Giocatore>();
	List<Giocatore> espulsi1 = new ArrayList<Giocatore>();
	List<Giocatore> ammoniti1 = new ArrayList<Giocatore>();
	
	Giocatore g1 = s.registraGiocatore(c, "A", "A", "Att", "1", 28);
	Giocatore g2 = s.registraGiocatore(c, "B", "B", "Att", "2", 28);
	Giocatore g3 = s.registraGiocatore(c, "C", "C", "Att", "3", 28);
	Giocatore g4 = s.registraGiocatore(c, "D", "D", "Att", "4", 28);
	Giocatore g5 = s.registraGiocatore(c, "E", "E", "Cent", "5", 28);
	Giocatore g6 = s.registraGiocatore(c, "F", "F", "Cent", "6", 28);
	Giocatore g7 = s.registraGiocatore(c, "G", "G", "Cent", "7", 28);
	Giocatore g8 = s.registraGiocatore(c, "H", "H", "Cent", "8", 28);
	Giocatore g9 = s.registraGiocatore(c, "I", "I", "Dif", "9", 28);
	Giocatore g10 = s.registraGiocatore(c, "L", "L", "Dif", "10", 28);
	Giocatore g11 = s.registraGiocatore(c, "M", "M", "Dif", "11", 28);
	Giocatore g12 = s.registraGiocatore(c, "N", "N", "Dif", "12", 28);
	Giocatore g13 = s.registraGiocatore(c, "O", "O", "Dif", "13", 28);
	Giocatore g14 = s.registraGiocatore(c, "P", "P", "Dif", "14", 28);
	Giocatore g15 = s.registraGiocatore(c, "Q", "Q", "Dif", "15", 28);
	Giocatore g16 = s.registraGiocatore(c, "R", "R", "Dif", "16", 28);
	

//	for(Giocatore m : c.getCalciatoriL()){
//				
//		System.out.println(m.getCF()+"\t"+m.getNome()
//							+"\t"+m.getReti()+"\t"+m.getAmmonizione()
//							+"\t"+m.getEspulsione());
//		}
	
	for(Map.Entry<String, Giocatore> m : c.getCalciatori().entrySet()){
				
		System.out.println(m.getKey()+"\t"+m.getValue().getNome()
							+"\t"+m.getValue().getReti()+"\t"+m.getValue().getAmmonizione()
							+"\t"+m.getValue().getEspulsione());
		}
	
	System.out.println();
	
	Squadra s1 = s.registraSquadra(c, "Juve");
	Squadra s2 = s.registraSquadra(c, "Milan");
	// Squadra s1 = s.registraSquadra(c, "Inter");
	// Squadra s2 = s.registraSquadra(c, "Torino");
	
	for(Map.Entry<String, Squadra> S : c.getPartecipanti().entrySet()){
		
		System.out.println(S.getValue().getNome());
	}
	
	System.out.println();
	System.out.println(s.assegnaGiocatoreSquadra(c, g1, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g2, s2));
	System.out.println(s.assegnaGiocatoreSquadra(c, g3, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g4, s2));
	System.out.println(s.assegnaGiocatoreSquadra(c, g5, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g6, s2));
	System.out.println(s.assegnaGiocatoreSquadra(c, g7, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g8, s2));
	System.out.println(s.assegnaGiocatoreSquadra(c, g9, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g10, s2));
	System.out.println(s.assegnaGiocatoreSquadra(c, g11, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g12, s2));
	System.out.println(s.assegnaGiocatoreSquadra(c, g13, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g14, s2));
	System.out.println(s.assegnaGiocatoreSquadra(c, g15, s1));
	System.out.println(s.assegnaGiocatoreSquadra(c, g16, s2));
	
	System.out.println();
	
	for(Giocatore g: s1.getRosa()){
		System.out.print(g.getNome() + " ");
	}
	System.out.println("\n");
	
	for(Giocatore g: s2.getRosa()){
		System.out.print(g.getNome() + " ");
	}
	System.out.println("\n");
	
//	for(Giocatore g: s1.getRosa()){
//		System.out.println(g.getNome());
//	}
//	System.out.println();
//	
//	for(Giocatore g: s2.getRosa()){
//		System.out.println(g.getNome());
//	}
//	System.out.println();
	
	marcatori.add(g1);
	marcatori.add(g1);
	marcatori.add(g1);
	marcatori.add(g1);
	marcatori.add(g2);
	ammoniti.add(g5);
	ammoniti.add(g6);
	espulsi.add(g10);
	marcatori1.add(g1);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	String dateInString = "27-09-2016";
	Date date = sdf.parse(dateInString);
	
	Partita p = s.registraPartita(c, s1, s2, 4, 1, date, marcatori, ammoniti, espulsi);
	

	sdf = new SimpleDateFormat("dd-M-yyyy");
	dateInString = "29-05-2017";
	date = sdf.parse(dateInString);
	
	Partita p2 = s.registraPartita(c, s2, s1, 0, 1, date, marcatori1, ammoniti1, espulsi1);
	
	for(Map.Entry<String, Giocatore> m : c.getCalciatori().entrySet()){
		System.out.println(m.getKey()+"\t"+m.getValue().getNome()
					+"\t"+m.getValue().getReti()+"\t"+m.getValue().getAmmonizione()
					+"\t"+m.getValue().getEspulsione());
	} 
	System.out.println();
	
	for(Map.Entry<String, Squadra> S : c.getPartecipanti().entrySet()){
		System.out.println(S.getValue().getNome()+"\t"+S.getValue().getPunti()
					+"\t"+S.getValue().getRetiSegnate()+"\t"+S.getValue().getRetiSubite()
					+"\t"+S.getValue().getDiffReti());
	}
	System.out.println();
	
	Giocatore G = s.getCapoCannoniere(c);
	Squadra S = s.getCampione(c);
	
	
	System.out.println(G.getNome()+" "+G.getCognome());
	System.out.println(S.getNome());
	}
}