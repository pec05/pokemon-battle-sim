package com.peccio.pokemon.domain.engine;

import com.peccio.pokemon.domain.model.Move;
import com.peccio.pokemon.domain.model.Pokemon;

public record ResultatAction(Pokemon attaquant,
                             Pokemon defenseur,
                             Move move,
                             int degatsInfliges,
                             boolean cibleKO) {
}
