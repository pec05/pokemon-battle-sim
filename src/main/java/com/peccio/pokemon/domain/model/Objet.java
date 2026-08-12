package com.peccio.pokemon.domain.model;

public sealed interface Objet permits Objet.Soin, Objet.ObjetTenu{

    String nom();

    record Soin(String nom, int pvRestaures) implements Objet {}

    record ObjetTenu(String nom, Type typeBooste, double multiplicateur) implements Objet {}
}
