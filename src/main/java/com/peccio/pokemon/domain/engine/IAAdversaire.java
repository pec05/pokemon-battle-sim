package com.peccio.pokemon.domain.engine;

import com.peccio.pokemon.domain.model.Move;
import com.peccio.pokemon.domain.model.Pokemon;

import java.util.Comparator;
import java.util.List;

public final class IAAdversaire {

    private final BattleEngine battleEngine;

    public IAAdversaire(BattleEngine battleEngine) {
        this.battleEngine = battleEngine;
    }

    public Move choisirMove(Pokemon soi, List<Move> movesDisponibles, Pokemon cible) {
        return movesDisponibles.stream()
                .max(Comparator.comparing(move -> battleEngine.calculerDegats(soi, cible, move)))
                .orElseThrow(() -> new IllegalArgumentException("Aucun move disponible"));
    }
}
