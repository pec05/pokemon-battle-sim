package com.peccio.pokemon.cli;

import com.peccio.pokemon.domain.engine.BattleEngine;
import com.peccio.pokemon.domain.engine.IAAdversaire;
import com.peccio.pokemon.domain.engine.ResultatAction;
import com.peccio.pokemon.domain.engine.TourDeCombat;
import com.peccio.pokemon.domain.model.Move;
import com.peccio.pokemon.domain.model.Pokemon;
import com.peccio.pokemon.domain.model.Stat;
import com.peccio.pokemon.domain.model.Type;

import java.util.List;
import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        BattleEngine battleEngine = new BattleEngine();
        TourDeCombat  tourDeCombat = new TourDeCombat(battleEngine);
        IAAdversaire ia =  new IAAdversaire(battleEngine);
        Scanner scanner = new Scanner(System.in);

        Pokemon joueur = new Pokemon("Salamèche", List.of(Type.FEU), new Stat(39, 52, 43, 60, 50, 65));
        Pokemon adversaire = new Pokemon("Bulbizarre", List.of(Type.PLANTE), new Stat(45, 49, 49, 65, 65, 45));

        List<Move> movesJoueur = List.of(
                new Move.Physique("Griffe", Type.NORMAL, 40, 100),
                new Move.Speciale("Flammèche", Type.FEU, 40, 100)
        );
        List<Move> movesAdversaire = List.of(
                new Move.Physique("Charge", Type.NORMAL, 40, 100),
                new Move.Speciale("Tranch'Herbe", Type.PLANTE, 45, 100)
        );

        System.out.println("Combat : " + joueur.getNom() + " VS " + adversaire.getNom());

        while (!joueur.estKO() && !adversaire.estKO()) {
            System.out.println("\n" + joueur.getNom() + " (" + joueur.getPvCourants() + " PV) VS " + adversaire.getNom() + " (" + adversaire.getPvCourants() + " PV)");
            for (int i = 0; i < movesJoueur.size(); i++) {
                System.out.println((i + 1) + " - " + movesJoueur.get(i).nom());
            }
            System.out.print("Choix : ");
            int choix = Integer.parseInt(scanner.nextLine().trim()) - 1;
            Move moveJoueur = movesJoueur.get(choix);
            Move moveAdversaire = ia.choisirMove(adversaire, movesAdversaire, joueur);

            List<ResultatAction> resultats = tourDeCombat.jouer(joueur, moveJoueur, adversaire, moveAdversaire);
            for (ResultatAction r : resultats) {
                System.out.println(r.attaquant().getNom() + " utilise " + r.move().nom() + " -> " + r.degatsInfliges() + " dégâts");
                if (r.cibleKO()) {
                    System.out.println(r.defenseur().getNom() + " est KO !");
                }
            }
        }

        System.out.println("\nVainqueur : " + (joueur.estKO() ? adversaire.getNom() : joueur.getNom()));
    }

}
