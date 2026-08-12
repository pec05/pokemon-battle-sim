# Pokemon Battle Sim

Simulateur de combat Pokémon en Java 25 pur (sans framework), pensé comme
exercice de modélisation d'un domaine métier complexe avec les nouveautés
récentes du langage : `sealed interface`, `record`, pattern matching exhaustif.

## Fonctionnalités

- Moteur de calcul de dégâts basé sur les types, avec table d'efficacité
- Capacités physiques, spéciales et de statut (`sealed interface Move`)
- Ordre des tours basé sur la priorité de capacité puis la vitesse
- Objets : soins et objets tenus (bonus de dégâts par type)
- IA adverse simple (choix de la capacité la plus puissante)
- Combat jouable en CLI

## Choix techniques

- **Java 25**, aucune dépendance runtime (JUnit 5 en test uniquement)
- Domaine modélisé avec `sealed interface` + pattern matching exhaustif
  (`Move`, `Objet`) : le compilateur garantit qu'aucun cas n'est oublié
- `record` pour les données immuables (`Stat`, `Move`, `ResultatAction`),
  classes classiques pour les entités avec état (`Pokemon`)
- Architecture en couches : `domain` (règles pures, sans dépendance) /
  `application` / `cli` (point d'entrée console)

## Lancer le projet

\`\`\`bash
mvn test          # exécuter les tests
mvn compile exec:java -Dexec.mainClass=com.peccio.pokemon.cli.Main
\`\`\`

## Structure

\`\`\`
src/main/java/com/peccio/pokemon/
├── domain/
│   ├── model/    # Type, Stat, Pokemon, Move, Objet, EffetStatut
│   └── engine/   # BattleEngine, TourDeCombat, IAAdversaire
├── application/
└── cli/          # Main
\`\`\`

## Pistes d'évolution

- Table de types complète (18 types) et effets de statut appliqués en combat
- Coups critiques, STAB (bonus même-type), variance aléatoire des dégâts
- IA plus élaborée (prise en compte des PV restants, prédiction)
- Combats en équipe (6 vs 6) avec changement de Pokémon
