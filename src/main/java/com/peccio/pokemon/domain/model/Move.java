package com.peccio.pokemon.domain.model;

public sealed interface Move permits Move.Physique, Move.Speciale, Move.Statut {

    String nom();
    Type type();
    int precision();
    int priorite();

    record Physique(String nom, Type type, int puissance, int precision, int priorite) implements Move {
        public Physique(String nom, Type type, int puissance, int precision) {
            this(nom, type, puissance, precision, 0);
        }
    }

    record Speciale(String nom, Type type, int puissance, int precision, int priorite) implements Move {
        public Speciale(String nom, Type type, int puissance, int precision) {
            this(nom, type, puissance, precision, 0);
        }
    }

    record Statut(String nom, Type type, int precision, EffetStatut effet , int priorite) implements Move {
        public Statut(String nom, Type type, int precision, EffetStatut effet) {
            this(nom, type, precision, effet, 0);
        }
    }


}
