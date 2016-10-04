import java.util.Random;

import pkgCampionato.*;

public class MainClass {
	
	public final static String[] ruoli = {"Portiere", "Difensore", "Centrocampista", "Attaccante"};
	public final static String[] nomi = {"Alessandro", "Lorenzo", "Mattia", "Andrea", "Francesco", "Leonardo", "Matteo", "Marco", "Luca", "Gabriele", "Riccardo", "Diego", "Tommaso", "Davide", "Federico", "Enea", "Edoardo", "Alessio", "Filippo", "Simone", "Cristian", "Jacopo", "Stefano", "Christian", "Michele", "Thomas", "Giuseppe"};
	public final static char[] consonanti = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z'};
	public final static char[] vocali = {'a', 'e', 'i', 'o', 'u'};
	public final static String[] squadre = {"Atalanta", "Bologna", "Cagliari", "Chievo", "Crotone", "Empoli", "Fiorentina", "Genoa", "Sampdoria", "Inter", "Milan", "Juventus", "Torino", "Lazio", "Roma", "Napoli", "Palermo", "Pescara", "Sassuolo", "Udinese"}; 
	public final static int stipendioMax = 10000;
	public final static int et‡Max = 45;
	public final static int et‡Min = 18;
	public final static int maxGiocatori = 11;
	public final static int nSquadre = 20;
	public final static int nPortieri = 1;
	public final static int nDifensori = 4;
	public final static int nCentrocampisti = 4;
	public final static int nAttaccanti = 3;
	
	public static void main(String[] args) {
		
		
		ServizioCampionato service = new ServizioCampionato();
		Campionato campionato = new Campionato("Serie A");
		
		
		for (int i = 0; i < nSquadre * nPortieri; i++){
			Giocatore g1 = service.registraGiocatore(campionato, randonNome(), randomCognome(), randomCodiceF(), ruoli[0], randomStipendio(), randomEt‡());
			if (g1 != null)
				System.out.println("Aggiunto il giocatore -> " + g1.getNome() + " " + g1.getCognome() + " " + g1.getRuolo());
		}
		for (int i = 0; i < nSquadre * nDifensori; i++){
			Giocatore g1 = service.registraGiocatore(campionato, randonNome(), randomCognome(), randomCodiceF(), ruoli[1], randomStipendio(), randomEt‡());
			if (g1 != null)
				System.out.println("Aggiunto il giocatore -> " + g1.getNome() + " " + g1.getCognome() + " " + g1.getRuolo());
		}
		for (int i = 0; i < nSquadre * nCentrocampisti; i++){
			Giocatore g1 = service.registraGiocatore(campionato, randonNome(), randomCognome(), randomCodiceF(), ruoli[2], randomStipendio(), randomEt‡());
			if (g1 != null)
				System.out.println("Aggiunto il giocatore -> " + g1.getNome() + " " + g1.getCognome() + " " + g1.getRuolo());
		}
		for (int i = 0; i < nSquadre * nAttaccanti; i++){
			Giocatore g1 = service.registraGiocatore(campionato, randonNome(), randomCognome(), randomCodiceF(), ruoli[3], randomStipendio(), randomEt‡());
			if (g1 != null)
				System.out.println("Aggiunto il giocatore -> " + g1.getNome() + " " + g1.getCognome() + " " + g1.getRuolo());
		}
		
		
		//Crea le squadre
		for (int i = 0; i < nSquadre; i++){
			
			Squadra s = service.registraSquadra(campionato, squadre[i]);
			if (s != null){
				System.out.println("Aggiunta la squadra -> " + s.getNome());
			}
			
//			if (service.assegnaGiocatoreSquadra(campionato, g, s))
//				System.out.println("Aggiunto -> " + g.getCognome() + "alla squadra -> " + s.getNome());
//			
		}
		
	}
	
	
	@SuppressWarnings("unused")
	private static String randomRuolo(){
		
		Random random = new Random();
		int miavar = random.nextInt(ruoli.length);
	
		return ruoli[miavar];
	}
	
	private static int randomStipendio(){
		
		Random random = new Random();
		int miavar = random.nextInt(stipendioMax) + 1;
		
		return miavar;
	}
	
	private static int randomEt‡(){
		
		Random random = new Random();
		int miavar = random.nextInt(et‡Max - et‡Min) + et‡Min;
		
		return miavar;
	}
	
	private static String randonNome(){
		Random random = new Random();
		int i = random.nextInt(nomi.length);
		
		return nomi[i];
	}
	
	private static String randomCognome(){
		
		String tmp= "";
		Random random = new Random();
		int lungh = random.nextInt(5) + 3;
		for (; lungh >= 0; lungh--){
			if (random.nextInt() % 2 != 0){
				int lettera = random.nextInt(consonanti.length);
				tmp += consonanti[lettera];
			}
			else{
				int vocale = random.nextInt(vocali.length);
				tmp += vocali[vocale];
			}
		}
		return tmp;
	}
	
	private static String randomCodiceF(){
	
		String tmp= "";
		Random random = new Random();
		for (int i = 0, j; i < 6; i++){
			j = random.nextInt(consonanti.length);
			tmp += consonanti[j];
		}
		for(int i = 0; i < 2; i++){
			tmp += random.nextInt(9);
		}
		for (int i = 0, j; i < 1; i++){
			j = random.nextInt(consonanti.length);
			tmp += consonanti[j];
		}
		for(int i = 0; i < 2; i++){
			tmp += random.nextInt(9);
		}
		for (int i = 0, j; i < 1; i++){
			j = random.nextInt(consonanti.length);
			tmp += consonanti[j];
		}
		for(int i = 0; i < 3; i++){
			tmp += random.nextInt(9);
		}
		for (int i = 0, j; i < 1; i++){
			j = random.nextInt(consonanti.length);
			tmp += consonanti[j];
		}
		return tmp;
	}
	
}


