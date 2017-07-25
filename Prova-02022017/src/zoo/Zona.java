package zoo;

public class Zona implements Comparable<Zona>{

	private int codice;
	private static int codiceProgressivo = 0;
	
	/**
	 * Metodo costruttore
	 */
	public Zona() {
		this.setCodice(++codiceProgressivo);
	}

	/**
	 * Imposta il codice della zona
	 * @param codice
	 */
	private void setCodice(int codice) {
		this.codice = codice;
	}

	/**
	 * Restituisce il codice della zona
	 * @return
	 */
	public int getCodice() {
		return codice;
	}

	@Override
	/**
	 * Confronta con un altra zona in base al codice numerico
	 */
	public int compareTo(Zona z) {
		// TODO Auto-generated method stub
		if (this.codice<z.getCodice()){
			return -1;
		} else if (this.codice>z.getCodice()){
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	/**
	 * Verifica l'uguaglianza con un'altra zona 
	 * in base al codice numerico 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zona other = (Zona) obj;
		if (codice != other.codice)
			return false;
		return true;
	}

	/**
	 * Restituisce le informazioni sotto forma di stringa
	 */
	public String toString(){
		return "Codice zona: "+codice;
	}

}