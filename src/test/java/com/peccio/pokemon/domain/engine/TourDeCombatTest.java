package com.peccio.pokemon.domain.engine;

import com.peccio.pokemon.domain.model.Move;
import com.peccio.pokemon.domain.model.Pokemon;
import com.peccio.pokemon.domain.model.Stat;
import com.peccio.pokemon.domain.model.Type;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TourDeCombatTest {

    @Test
    void lePokemonLePlusRapideAttaqueEnPremier() {
        Pokemon rapide = new Pokemon("Rapide", List.of(Type.NORMAL), new Stat(50, 50, 50, 50, 50, 100));
        Pokemon lent = new Pokemon("Lent", List.of(Type.NORMAL), new Stat(50, 50, 50, 50, 50, 10));
        Move charge = new Move.Physique("Charge", Type.NORMAL, 40, 100);

        List<ResultatAction> resultats = new TourDeCombat(new BattleEngine()).jouer(lent, charge, rapide, charge);

        assertEquals(rapide, resultats.get(0).attaquant());
    }

    @Test
    void siLeDefenseurEstKOLeSecondNAttaquePas() {
        Pokemon puissant = new Pokemon("Puissant", List.of(Type.NORMAL), new Stat(50, 200, 10, 50, 50, 100));
        Pokemon fragile = new Pokemon("Fragile", List.of(Type.NORMAL), new Stat(5, 10, 10, 10, 10, 10));
        Move charge = new Move.Physique("Charge", Type.NORMAL, 40, 100);

        List<ResultatAction> resultats = new TourDeCombat(new BattleEngine()).jouer(fragile, charge, puissant, charge);

        assertEquals(1, resultats.size());
        assertTrue(fragile.estKO());
    }

}