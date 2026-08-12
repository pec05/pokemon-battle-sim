package com.peccio.pokemon.domain.model;

public record Stat(
        int pvMax,
        int attaque,
        int defense,
        int attaqueSpeciale,
        int defenseSpeciale,
        int vitesse
) {
    public Stat {
        if (pvMax <= 0 || attaque < 0 || defense < 0 || attaqueSpeciale < 0 || defenseSpeciale < 0 || vitesse < 0) {
            throw new IllegalArgumentException("Les statistiques doivent être  positives.");
        }
    }
}
