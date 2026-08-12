package com.peccio.pokemon.domain.engine;

import com.peccio.pokemon.domain.model.Move;
import com.peccio.pokemon.domain.model.Pokemon;

import java.util.List;

public final class TourDeCombat {

    private final BattleEngine battleEngine;

    public TourDeCombat(BattleEngine battleEngine) {
        this.battleEngine = battleEngine;
    }

    public List<ResultatAction> jouer(Pokemon joueur, Move moveJoueur, Pokemon adversaire, Move moveAdversaire) {
        Pokemon premier = determinerPremierAttaquant(joueur, moveJoueur, adversaire, moveAdversaire);

        if (premier == joueur) {
            return jouerdansLOrdre(joueur, moveJoueur, adversaire, moveAdversaire);
        } else {
            return jouerdansLOrdre(adversaire, moveAdversaire, joueur, moveJoueur);
        }
    }

    private List<ResultatAction> jouerdansLOrdre(Pokemon premier, Move moveDuPremier, Pokemon second, Move moveDuSecond) {
        ResultatAction actionPremier = executerAction(premier, second, moveDuPremier);

        if (second.estKO()) {
            return List.of(actionPremier);
        }

        ResultatAction actionSecond = executerAction(second, premier, moveDuSecond);
        return List.of(actionPremier, actionSecond);
    }

    private ResultatAction executerAction(Pokemon attanquant, Pokemon defenseur, Move move) {
        int degats = battleEngine.calculerDegats(attanquant, defenseur, move);
        defenseur.subirDegats(degats);
        return new ResultatAction(attanquant, defenseur, move, degats, defenseur.estKO());
    }

    private Pokemon determinerPremierAttaquant(Pokemon joueur, Move moveJoueur, Pokemon adversaire, Move moveAdversaire) {
        if (moveJoueur.priorite() != moveAdversaire.priorite()) {
            return moveJoueur.priorite() > moveAdversaire.priorite() ? joueur : adversaire;
        }

        if (joueur.getStatBase().vitesse() != adversaire.getStatBase().vitesse()) {
            return joueur.getStatBase().vitesse() > adversaire.getStatBase().vitesse() ? joueur : adversaire;
        }

        return joueur; // égalité parfaite : le joueur commence par defaut
    }




}
