package com.peccio.pokemon.domain.engine;

import com.peccio.pokemon.domain.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BattleEngineTest {

    @Test
    void uneAttaqueSpecialeInfligeDesDegatsSuperEfficace() {
        Pokemon salameche = new Pokemon("Salamèche", List.of(Type.FEU), new Stat(39, 52, 43, 60, 50, 65));
        Pokemon bulbizarre = new Pokemon("Bulbizarre", List.of(Type.PLANTE), new Stat(45, 49, 49, 65, 65, 45));
        Move flammeche = new Move.Speciale("Flammèche", Type.FEU, 40, 100);

        int degats = new BattleEngine().calculerDegats(salameche, bulbizarre, flammeche);

        assertTrue(degats > 0);
    }

    @Test
    void uneAttaqueDeStatutInfligeAucunDegat() {
        Pokemon salameche = new Pokemon("Salamèche", List.of(Type.FEU), new Stat(39, 52, 43, 60, 50, 65));
        Pokemon bulbizarre = new Pokemon("Bulbizarre", List.of(Type.PLANTE), new Stat(45, 49, 49, 65, 65, 45));
        Move rugissement = new Move.Statut("Rugissement", Type.NORMAL, 100, EffetStatut.CONFUSION);

        assertEquals(0, new BattleEngine().calculerDegats(salameche, bulbizarre, rugissement));
    }

}