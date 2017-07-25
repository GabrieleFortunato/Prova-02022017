package animali;

public abstract class Mammifero extends Animale {

	/**
	 * Metodo costruttore
	 * @param nome
	 * @param dataNascita
	 * @param numeroZampe
	 * @param verso
	 */
	public Mammifero(String nome, String dataNascita, int numeroZampe, String verso) {
		super(nome, dataNascita, numeroZampe,verso);
	}

}
