package animali;

public abstract class Animale {

	private String nome;
	private int matricola;
	private static int matricolaProgressiva = 0;
	private String dataNascita;
	private int numeroZampe;
	@SuppressWarnings("unused")
	private String verso;

	/**
	 * Metodo costruttore
	 * @param nome
	 * @param dataNascita
	 * @param numeroZampe
	 * @param verso
	 */
	public Animale(String nome, String dataNascita, int numeroZampe,String verso) {
		this.setNome(nome);
		this.setMatricola(++matricolaProgressiva);
		this.setDataNascita(dataNascita);
		this.setNumeroZampe(numeroZampe);
		this.setVerso(verso);
	}

	/**
	 * Restituisce il nome dell'animale
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome dell'animale
	 * @param nome
	 */
	private void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Imposta la matricola dell'animale
	 * @param matricola
	 */
	private void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	/**
	 * Imposta la data di nascita dell'animale
	 * @param dataNascita
	 */
	private void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * Imposta il numero di zampe dell'animale
	 * @param numeroZampe
	 */
	private void setNumeroZampe(int numeroZampe) {
		this.numeroZampe = numeroZampe;
	}
	
	/**
	 * Imposta il verso dell'animale
	 * @param verso
	 */
	private void setVerso(String verso){
		this.verso = verso;
	}
	
	/**
	 * Restituisce le informazioni sotto forma di stringa
	 */
	public String toString(){
		return "Nome: "+nome+" Matricola: "+matricola+" Data di nascita:"+dataNascita+" Numero di zampe: "+numeroZampe;
	}

	@Override
	/**
	 * Genera l'Hashcode
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricola;
		return result;
	}

}