package zoo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import animali.Animale;
import animali.Cane;
import animali.Gatto;
import eccezioni.AnimaleNonPresenteEccezione;
import eccezioni.AnimalePresenteEccezione;
import eccezioni.ZonaNonVuotaEccezione;
import eccezioni.ZonaPresenteEccezione;

public class Zoo implements Iterable<Zona>{

	@SuppressWarnings("unused")
	private String nome;
	@SuppressWarnings("unused")
	private String indirizzo;
	@SuppressWarnings("unused")
	private String città;
	private TreeMap<Zona,HashSet<Animale>> zo;
	
	/**
	 * Metodo costruttore
	 * @param nome
	 * @param indirizzo
	 * @param città
	 */
	public Zoo(String nome, String indirizzo, String città) {
		this.setNome(nome);
		this.setIndirizzo(indirizzo);
		this.setCittà(città);
		this.setAnimali(new TreeMap<>());
	}

	/**
	 * Imposta il nome dello zoo
	 * @param nome
	 */
	private void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Imposta l'indirizzo dello zoo
	 * @param indirizzo
	 */
	private void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Imposta la città dello zoo
	 * @param città
	 */
	private void setCittà(String città) {
		this.città = città;
	}

	/**
	 * Imposta la TreeMap
	 * @param animali
	 */
	private void setAnimali(TreeMap<Zona, HashSet<Animale>> animali) {
		this.zoo = animali;
	}
	
	/**
	 * Restituisce la TreeMap
	 * @return
	 */
	public TreeMap<Zona, HashSet<Animale>> getAnimali() {
		return zoo;
	}

	/**
	 * Rimuovi una zona dallo zoo
	 * @param zona
	 * @throws ZonaPresenteEccezione
	 */
	public void aggiungiZona(Zona zona) throws ZonaPresenteEccezione{
		if (zoo.containsKey(zona)){
			throw new ZonaPresenteEccezione();
		} else {
			zoo.put(zona, new HashSet<>());
		}
	}

	/**
	 * Rimuovi una zona dallo zoo
	 * @param zona
	 * @throws ZonaNonVuotaEccezione
	 */
	public void rimuoviZona(Zona zona) throws ZonaNonVuotaEccezione{
		if (zoo.get(zona).isEmpty()){
			zoo.remove(zona,zoo.get(zona));
		} else {
			throw new ZonaNonVuotaEccezione();
		}
	}
	
	/**
	 * Aggiungi un animale allo zoo
	 * @param zona
	 * @param animale
	 * @throws AnimalePresenteEccezione
	 */
	public void aggiungiAnimale(Zona zona, Animale animale) throws AnimalePresenteEccezione{
		if (zoo.values().contains(animale)){
			throw new AnimalePresenteEccezione();
		} else {
			zoo.get(zona).add(animale);
		}
	}
	
	/**
	 * Restituisce tutti gli animali presenti nello zoo
	 * @return
	 */
	public HashSet<HashSet<Animale>> animali(){
		HashSet<HashSet<Animale>> lista = new HashSet<>(zoo.values());
		return lista;
	}
	
	/**
	 * Rimuovi un animale dallo zoo
	 * @param animale
	 * @throws AnimaleNonPresenteEccezione
	 */
	public void rimuoviAnimale(Animale animale) throws AnimaleNonPresenteEccezione{
		if (zoo.values().contains(animale)){
			zoo.values().remove(animale);
		} else {
			throw new AnimaleNonPresenteEccezione();
		}
	}
	
	/**
	 * Restituisce il numero di cani presenti nello zoo
	 * @return 
	 */
	public int numeroCani(){
		int numero = 0;
		for (Zona z:zoo.keySet()){
			for (Animale a: zoo.get(z)){
				if (a instanceof Cane){
					numero++;
				}
			}
		}
		return numero;
	}
	
	/**
	 * Conta i gatti presenti in una zona
	 * @param animali
	 * @return
	 */
	private int numeroGatti(HashSet<Animale> animali){
		int numero = 0;
		for (Animale a:animali){
			if (a instanceof Gatto){
				numero++;
			}
		}
		return numero;
	}
	
	/**
	 * Restituisce la zona con più gatti
	 * @return
	 */
	public Zona conPiùGatti(){
		Zona zona=null;
		int gatti = 0;
		for (Zona z:zoo.keySet()){
			if (numeroGatti(zoo.get(z))>gatti){
				zona = z;
				gatti = numeroGatti(zoo.get(z));
			}
		}
		return zona;
	}

	@Override
	/**
	 * Implementa l'iteratore
	 */
	public Iterator<Zona> iterator() {
		return zoo.keySet().iterator();
	}	
	
}