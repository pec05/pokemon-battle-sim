package com.peccio.pokemon.domain.model;

import java.util.List;
import java.util.Optional;

public class Pokemon {

    private final String nom;
    private final List<Type> types;
    private final Stat statBase;
    private int pvCourants;
    private Objet.ObjetTenu objetTenu;

    public Pokemon(String nom, List<Type> types, Stat statBase) {
        if (types.isEmpty() || types.size() > 2) {
            throw new IllegalArgumentException("Un Pokémon doit avoir un ou deux types.");
        }
        this.nom = nom;
        this.types = List.copyOf(types);
        this.statBase = statBase;
        this.pvCourants = statBase.pvMax();
    }

    public void subirDegats(int montant) {
        this.pvCourants = Math.max(0, this.pvCourants - montant);
    }

    public void soigner(int montant) {
        this.pvCourants = Math.min(statBase.pvMax(), this.pvCourants + montant);
    }

    public boolean estKO() {
        return pvCourants == 0;
    }

    public void equiper(Objet.ObjetTenu objet) {
        this.objetTenu = objet;
    }

    public Optional<Objet.ObjetTenu> getObjetTenu() {
        return Optional.ofNullable(objetTenu);
    }

    public String getNom() {
        return nom;
    }

    public List<Type> getTypes() {
        return types;
    }

    public Stat getStatBase() {
        return statBase;
    }

    public int getPvCourants() {
        return pvCourants;
    }
}
