package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;
import animali.Animale;
import animali.Cane;
import animali.Gatto;
import eccezioni.AnimalePresenteEccezione;
import eccezioni.ZonaPresenteEccezione;
import zoo.Zona;
import zoo.Zoo;

public class Test {

	private final static int animali = 300;
	private final static int zone = 20; 
	private final static int zero = 0;
	private final static double probGatto = 0.40;
	private final static String nomeFile = new String("zoo.csv");
	private final static String dataNascita = new String("01/09/2010");
	private final static String nomeGatto = new String("gatto");
	private final static String nomeCane = new String("cane");
	private final static String cane = new String("Cane di nome");
	private final static String gatto = new String("Gatto di nome");
	private final static String zonaGatti = new String("\nZona con più gatti---> ");
	private final static String nomeZoo = new String("Zoo comunale");
	private final static String indirizzoZoo = new String("via Napoli");
	private final static String cittàZoo = new String("Bari");
	private final static String zonaPresenteEccezione = new String("Zona già presente");
	private final static String animalePresenteEccezione = new String("Animale già presente");
	
	/**
	 * Metodo main
	 * @param args
	 */
	public static void main(String[] args) {
		Animale[] animali = animali();
		Zona[] zone = zone();
		Zoo zoo = zoo(zone,animali);
		stampaZonaConPiùGatti(zoo);
		stampaSuFile(zoo);
	}

	/**
	 * Stampa le zone dello zoo su file
	 * @param zoo
	 */
	private static void stampaSuFile(Zoo zoo){
		try {
			PrintStream output = new PrintStream(new File(nomeFile));
			Iterator<Zona> iter = zoo.iterator();
			while (iter.hasNext()){
				Zona z = iter.next();
				output.println();
				output.println(z);
				for (Animale a:zoo.getAnimali().get(z)){
					if (a instanceof Cane){
						output.println(cane+a.getNome());
					} else {
						output.println(gatto+a.getNome());
					}
				}
			}
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Stampa a video la zona con più gatti
	 * @param zoo
	 */
	private static void stampaZonaConPiùGatti(Zoo zoo){
		System.out.println(zonaGatti+zoo.conPiùGatti());
	}
	
	/**
	 * Crea lo zoo
	 * @param zona
	 * @param animale
	 * @return
	 */
	private static Zoo zoo(Zona[] zona, Animale[] animale){
		Zoo zoo = new Zoo(nomeZoo,indirizzoZoo,cittàZoo);
		Random random = new Random();
		for (Zona z:zona){
			try {
				zoo.aggiungiZona(z);
			} catch (ZonaPresenteEccezione e) {
				e.printMessage(zonaPresenteEccezione);
			}
		}
		for (Animale a:animale){
			int z = random.nextInt(zona.length);
			try {
				zoo.aggiungiAnimale(zona[z], a);
			} catch (AnimalePresenteEccezione e) {
				e.printMessage(animalePresenteEccezione);
			}
		}
		return zoo;
	}
	
	/**
	 * Crea 20 zone
	 * @return
	 */
	private static Zona[] zone(){
		Zona[] zona = new Zona[zone];
		for (int i=zero;i<zona.length;i++){
			zona[i] = new Zona();
		}
		return zona;
	}

	/**
	 * Crea 100 animali
	 * @return
	 */
	private static Animale[] animali(){
		Animale[] animale = new Animale[animali];
		Random random = new Random();
		for (int i=zero;i<animale.length;i++){
			double prob = random.nextDouble();
			if (prob>probGatto){
				animale[i] = new Gatto(nomeGatto+i,dataNascita);
			} else {
				animale[i] = new Cane(nomeCane+i,dataNascita);
			}
		}
		return animale;
	}

}