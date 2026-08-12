package com.peccio.pokemon.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    private Pokemon creerSalameche() {
        Stat stats = new Stat(39, 52, 43, 60, 50, 65);
        return new Pokemon("Salamèche", List.of(Type.FEU), stats);
    }

    @Test
    void unPokemonCommenceAvecSesPvMax() {
            assertEquals(39, creerSalameche().getPvCourants());
    }

    @Test
    void subirDegatsReduitLesPv() {
        Pokemon p = creerSalameche();
        p.subirDegats(15);
        assertEquals(24, p.getPvCourants());
    }

    @Test
    void lesPvNeDescendentJamaisSousZero() {
        Pokemon p = creerSalameche();
        p.subirDegats(1000);
        assertTrue(p.estKO());
        assertEquals(0, p.getPvCourants());
    }

}