package it.itispaleocapa.obertif;

public class Partecipante {
    Personale p;
    int oreLavoro;
    public Partecipante (Personale p, int oreLavoro){
        this.p = p;
        this.oreLavoro = oreLavoro;
    }

    public int calcolaStipendio(){
        return p.calcolaStipendio(oreLavoro);
    }
}
