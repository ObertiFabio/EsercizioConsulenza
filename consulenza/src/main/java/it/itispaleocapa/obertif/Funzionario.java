package it.itispaleocapa.obertif;

import java.time.LocalDate;

public class Funzionario extends Personale{

    public Funzionario(String nome, String cognome, String codice, int annoAssunzione) throws YearNotValidException {
        super(nome, cognome, codice, annoAssunzione);
    }
    
    @Override
    public int calcolaStipendio(int oreLavoro){
        int soldi = 0;
        int anniTrascorsi = LocalDate.now().getYear() - annoAssunzione;
        if(anniTrascorsi < 10){
            soldi += 70;
        }
        else{
            soldi += 80;
        }
        soldi *= oreLavoro;
        return soldi;
    }

    public int calcolaStipendio(int oreLavoro, int compensoJunior, int compensoSenior){
        int soldi = 0;
        int anniTrascorsi = LocalDate.now().getYear() - annoAssunzione;
        if(anniTrascorsi < 10){
            soldi += compensoJunior;
        }
        else{
            soldi += compensoSenior;
        }
        soldi *= oreLavoro;
        return soldi;
    }
}
