package it.itispaleocapa.obertif;

public class Dirigente extends Personale{

    public Dirigente(String nome, String cognome, String codice, int annoAssunzione) throws YearNotValidException {
        super(nome, cognome, codice, annoAssunzione);
    }
    
}
