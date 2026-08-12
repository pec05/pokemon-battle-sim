package com.peccio.pokemon.domain.model;

import java.util.Map;
import java.util.Set;

public enum Type {
    NORMAL, FEU, EAU, PLANTE, ELECTRIQUE, GLACE,
    COMBAT, POISON, SOL, VOL, PSY, INSECTE,
    ROCHE, SPECTRE, DRAGON, TENEBRES, ACIER, FEE;

    private static final Map<Type, Set<Type>> SUPER_EFFICACE = Map.ofEntries(
            Map.entry(FEU, Set.of(PLANTE, GLACE, INSECTE, ACIER)),
            Map.entry(EAU, Set.of(FEU, SOL, ROCHE)),
            Map.entry(PLANTE, Set.of(EAU, SOL, ROCHE)),
            Map.entry(ELECTRIQUE, Set.of(EAU, VOL)),
            Map.entry(GLACE, Set.of(PLANTE, SOL, VOL, DRAGON)),
            Map.entry(COMBAT, Set.of(NORMAL, GLACE, ROCHE, TENEBRES, ACIER)),
            Map.entry(POISON, Set.of(PLANTE, FEE)),
            Map.entry(SOL, Set.of(FEU, ELECTRIQUE, POISON, ROCHE, ACIER)),
            Map.entry(VOL, Set.of(PLANTE, COMBAT, INSECTE)),
            Map.entry(PSY, Set.of(COMBAT, POISON)),
            Map.entry(INSECTE, Set.of(PLANTE, PSY, TENEBRES)),
            Map.entry(ROCHE, Set.of(INSECTE, VOL, FEU, GLACE)),
            Map.entry(SPECTRE, Set.of(PSY, SPECTRE)),
            Map.entry(DRAGON, Set.of(DRAGON)),
            Map.entry(TENEBRES, Set.of(PSY, SPECTRE)),
            Map.entry(ACIER, Set.of(ROCHE, GLACE, FEE)),
            Map.entry(FEE, Set.of(COMBAT, DRAGON, TENEBRES))
    );

    private static final Map<Type, Set<Type>> PAS_EFFICACE = Map.ofEntries(
            Map.entry(FEU, Set.of(PLANTE, GLACE, INSECTE, ACIER)),
            Map.entry(EAU, Set.of(FEU, SOL, ROCHE)),
            Map.entry(PLANTE, Set.of(EAU, SOL, ROCHE)),
            Map.entry(ELECTRIQUE, Set.of(EAU, VOL)),
            Map.entry(GLACE, Set.of(PLANTE, SOL, VOL, DRAGON)),
            Map.entry(COMBAT, Set.of(NORMAL, GLACE, ROCHE, TENEBRES, ACIER)),
            Map.entry(POISON, Set.of(PLANTE, FEE)),
            Map.entry(SOL, Set.of(FEU, ELECTRIQUE, POISON, ROCHE, ACIER)),
            Map.entry(VOL, Set.of(PLANTE, COMBAT, INSECTE)),
            Map.entry(PSY, Set.of(COMBAT, POISON)),
            Map.entry(INSECTE, Set.of(PLANTE, PSY, TENEBRES)),
            Map.entry(ROCHE, Set.of(INSECTE, VOL, FEU, GLACE)),
            Map.entry(SPECTRE, Set.of(PSY, SPECTRE)),
            Map.entry(DRAGON, Set.of(DRAGON)),
            Map.entry(TENEBRES, Set.of(PSY, SPECTRE)),
            Map.entry(ACIER, Set.of(ROCHE, GLACE, FEE)),
            Map.entry(FEE, Set.of(COMBAT, DRAGON, TENEBRES))
    );

    private static final Map<Type, Set<Type>> IMMUNITE = Map.ofEntries(
            Map.entry(ELECTRIQUE, Set.of(SOL))
    );

    public double multiplicateurContre(Type typeDefenseur) {
        if (IMMUNITE.getOrDefault(this, Set.of()).contains(typeDefenseur)) {
            return 0.0;
        } else if (SUPER_EFFICACE.getOrDefault(this, Set.of()).contains(typeDefenseur)) {
            return 2.0;
        } else if (PAS_EFFICACE.getOrDefault(this, Set.of()).contains(typeDefenseur)) {
            return 0.5;
        } else {
            return 1.0;
        }
    }


}
