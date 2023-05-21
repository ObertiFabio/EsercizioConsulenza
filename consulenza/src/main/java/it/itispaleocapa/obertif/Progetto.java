package it.itispaleocapa.obertif;

import java.util.LinkedList;

public class Progetto {
    LinkedList<Partecipante> p;
    public Progetto(){
        p = new LinkedList<Partecipante>();
    }

    public void aggiungiPartecipante(Personale personale, int oreLavoro){
        p.add(new Partecipante(personale, oreLavoro));
    }

    public int calcolaSpeseTot(){
        int spesa = 0;
        spesa = p.stream().reduce(0, (partial, actual) -> partial += actual.calcolaStipendio(), Integer::sum);
        return spesa;
    }
}

