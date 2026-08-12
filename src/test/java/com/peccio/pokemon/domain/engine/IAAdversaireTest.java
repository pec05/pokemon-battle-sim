package com.peccio.pokemon.domain.engine;

import com.peccio.pokemon.domain.model.Move;
import com.peccio.pokemon.domain.model.Pokemon;
import com.peccio.pokemon.domain.model.Stat;
import com.peccio.pokemon.domain.model.Type;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IAAdversaireTest {

    @Test
    void IAChoisitLeMoveLePlusPuissantContreLaCible() {
        Pokemon soi = new Pokemon("Salamèche", List.of(Type.FEU), new Stat(39, 52, 43, 60, 50, 65));
        Pokemon cible = new Pokemon("Bulbizarre", List.of(Type.PLANTE), new Stat(45, 49, 49, 65, 65, 45));

        Move faible = new Move.Physique("Griffe", Type.NORMAL, 20, 100);
        Move fort = new Move.Speciale("Flammèche", Type.FEU, 40, 100);

        Move choisi = new IAAdversaire(new BattleEngine()).choisirMove(soi, List.of(faible, fort), cible);

        assertEquals(fort, choisi);
    }

}