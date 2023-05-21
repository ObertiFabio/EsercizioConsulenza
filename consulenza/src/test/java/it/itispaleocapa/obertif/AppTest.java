package it.itispaleocapa.obertif;

import org.junit.jupiter.api.Test;

import it.itispaleocapa.obertif.Personale.YearNotValidException;
import it.itispaleocapa.obertif.Tecnico.SpecializationNotValidException;
import it.itispaleocapa.obertif.Tecnico.StatusNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    Progetto p = new Progetto();

    @Test
    public void calcolaSpeseTotali() throws YearNotValidException, StatusNotValidException, SpecializationNotValidException{
        Tecnico pers1 = new Tecnico("Marco", "Cavangna", "cvg", 2005, "info_tele", "interno");
        p.aggiungiPartecipante(pers1, 5);
        Tecnico pers2 = new Tecnico("Luca", "Redondi", "rdn", 2005, "info_tele", "esterno");
        p.aggiungiPartecipante(pers2, 5);
        Funzionario pers3 = new Funzionario("Luca", "Cigarini", "cgr", 2005);
        p.aggiungiPartecipante(pers3, 2);
        Tecnico pers4 = new Tecnico("Andrea", "Milesi", "mls", 2010, "elett_auto", "interno");
        p.aggiungiPartecipante(pers4, 1);
        Tecnico pers5 = new Tecnico("Giacomo", "Verdi", "vrd", 2005, "elett_auto", "esterno");
        p.aggiungiPartecipante(pers5, 3);
        Funzionario pers6 = new Funzionario("Lucia", "Bagini", "bgn", 2022);
        p.aggiungiPartecipante(pers6, 4);
        Dirigente pers7 = new Dirigente("Giuseppe", "Manzoni", "Leo", 1989);
        p.aggiungiPartecipante(pers7, 1);
        assertEquals(1243, p.calcolaSpeseTot());
    }
}
