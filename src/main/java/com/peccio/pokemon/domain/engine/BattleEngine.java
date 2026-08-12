package com.peccio.pokemon.domain.engine;

import com.peccio.pokemon.domain.model.Move;
import com.peccio.pokemon.domain.model.Pokemon;
import com.peccio.pokemon.domain.model.Type;

public class BattleEngine {

    public int calculerDegats(Pokemon attaquant, Pokemon defenseur, Move move) {
        return switch (move) {
            case Move.Physique p -> degatsBrut(attaquant.getStatBase().attaque(), defenseur.getStatBase().defense(), p.puissance(), p.type(), defenseur);
            case Move.Speciale s -> degatsBrut(attaquant.getStatBase().attaqueSpeciale(), defenseur.getStatBase().defenseSpeciale(), s.puissance(), s.type(), defenseur);
            case Move.Statut m -> 0; 
        };
    }

    private int degatsBrut(int attaque, int defense, int puissance, Type typeAttaque, Pokemon defenseur) {
        double multiplicateur = defenseur.getTypes().stream()
                .mapToDouble(typeAttaque::multiplicateurContre)
                        .reduce(1.0, (a, b) -> a * b);

        double base = ((2.0 * 50 / 5 + 2) * puissance * attaque / defense) / 50 + 2;

        return (int) Math.round(base * multiplicateur);
    }

}
