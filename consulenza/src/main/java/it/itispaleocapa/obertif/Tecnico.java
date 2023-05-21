package it.itispaleocapa.obertif;

import java.time.LocalDate;

public class Tecnico extends Personale{

    String specializazzione, stato;
    public Tecnico(String nome, String cognome, String codice, int annoAssunzione, String specializzazione, String stato) throws YearNotValidException, StatusNotValidException, SpecializationNotValidException {
        super(nome, cognome, codice, annoAssunzione);
        if(specializzazione != "info_tele" && specializzazione != "elett_auto"){
            throw new SpecializationNotValidException();
        }
        if(stato != "interno" && stato != "esterno"){
            throw new StatusNotValidException();
        }
        this.specializazzione = specializzazione; 
        this.stato = stato;
    }
    
    @Override
    public int calcolaStipendio(int oreLavoro){
        int soldi = 0;
        if(stato == "interno"){
            int anniTrascorsi = LocalDate.now().getYear() - annoAssunzione;
            soldi += anniTrascorsi;
        }
        if(specializazzione == "info_tele"){
            soldi += 40;
        }
        else if (specializazzione == "elett_auto"){
            soldi += 50;
        }
        soldi *= oreLavoro;
        return soldi;
    }

    public int calcolaStipendio(int oreLavoro, int compensoInfo, int compensoElett, int bonusInfo, int bonusElett){
        int soldi = 0;
        if(specializazzione == "info_tele"){
            soldi += compensoInfo;
            if(stato == "interno"){
                int anniTrascorsi = LocalDate.now().getYear() - annoAssunzione;
                soldi += bonusInfo*anniTrascorsi;
            }
        }
        else if (specializazzione == "elett_auto"){
            soldi += compensoElett;
            if(stato == "interno"){
                int anniTrascorsi = LocalDate.now().getYear() - annoAssunzione;
                soldi += bonusElett*anniTrascorsi;
            }
        }
        soldi *= oreLavoro;
        return soldi;
    }
    public class SpecializationNotValidException extends Exception{};
    public class StatusNotValidException extends Exception{};
}
