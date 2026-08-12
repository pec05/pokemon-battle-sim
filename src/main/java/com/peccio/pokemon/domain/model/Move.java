package com.peccio.pokemon.domain.model;

public sealed interface Move permits Move.Physique, Move.Speciale, Move.Statut {

    String nom();
    Type type();
    int precision();

    record Physique(String nom, Type type, int puissance, int precision) implements Move { }

    record Speciale(String nom, Type type, int puissance, int precision) implements Move {}

    record Statut(String nom, Type type, int precision, EffetStatut effet) implements Move {}


}
