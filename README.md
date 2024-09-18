# Bati-Cuisine

## Application d'estimation des coûts de construction des cuisines

### Description
**Bati-Cuisine** est une application Java destinée aux professionnels de la construction et de la rénovation de cuisines. Elle permet de calculer le coût total des travaux en tenant compte des matériaux utilisés et du coût de la main-d'œuvre, facturée à l'heure. L'application inclut des fonctionnalités avancées telles que la gestion des clients, la génération de devis personnalisés, et une vue d'ensemble sur les aspects financiers et logistiques des projets de rénovation.

### Contexte
Ce projet vise à offrir aux professionnels un outil puissant et pratique pour estimer avec précision les coûts et gérer efficacement les projets de rénovation de cuisines.

### Table des Matières
- [Fonctionnalités](#fonctionnalités)
  - [Gestion des Projets](#gestion-des-projets)
  - [Gestion des Composants](#gestion-des-composants)
  - [Gestion des Clients](#gestion-des-clients)
  - [Création de Devis](#création-de-devis)
  - [Calcul des Coûts](#calcul-des-coûts)
  - [Affichage des Détails et Résultats](#affichage-des-détails-et-résultats)
- [User Stories](#user-stories)
- [Exemple d’Utilisation](#exemple-dutilisation)
- [Exigences Techniques](#exigences-techniques)
- [Compétences Visées](#compétences-visées)
  - [Compétences Techniques](#compétences-techniques-visées)
  - [Compétences Transversales](#compétences-transversales-visées)
- [Modalités Pédagogiques](#modalités-pédagogiques)
- [Modalités d'Évaluation](#modalités-dévaluation)
- [Livrables](#livrables)
- [Critères de Performance](#critères-de-performance)
- [Soutenance](#soutenance)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Contribution](#contribution)
- [Licence](#licence)

## Fonctionnalités

### Gestion des Projets
- **Ajouter un client associé au projet.**
- **Ajouter et gérer des composants** (matériaux, main-d'œuvre).
- **Associer un devis au projet** pour estimer les coûts avant les travaux.
- **Caractéristiques d’un projet :**
  - `nomProjet` (String): Nom du projet de construction ou de rénovation.
  - `margeBeneficiaire` (double): Marge bénéficiaire appliquée au coût total.
  - `coutTotal` (double): Coût total calculé pour le projet.
  - `etatProjet` (Enum): Statut du projet (En cours, Terminé, Annulé).

### Gestion des Composants
- **Matériaux :** Gestion des coûts des matériaux.
  - `nom` (String): Nom du composant.
  - `coutUnitaire` (double): Coût unitaire du composant.
  - `quantite` (double): Quantité de composants utilisée.
  - `typeComposant` (String): Type de composant (Matériel ou Main-d'œuvre).
  - `tauxTVA` (double): Taux de TVA applicable au composant.
  - `coutTransport` (double): Coût du transport du matériau.
  - `coefficientQualite` (double): Coefficient reflétant la qualité du matériau.
- **Main-d'œuvre :** Calcul des coûts basés sur le taux horaire, les heures travaillées, et la productivité des ouvriers.
  - `nom` (String): Nom du composant.
  - `typeComposant` (String): Type de composant (Matériel ou Main-d'œuvre).
  - `tauxTVA` (double): Taux de TVA applicable au composant.
  - `tauxHoraire` (double): Taux horaire de la main-d'œuvre.
  - `heuresTravail` (double): Nombre d'heures travaillées.
  - `productiviteOuvrier` (double): Facteur de productivité des ouvriers.

### Gestion des Clients
- Enregistrer les informations de base d’un client.
- Différencier les clients professionnels et particuliers, influençant les remises ou les taxes appliquées.
- Calculer et appliquer des remises spécifiques selon le type de client.
- **Informations enregistrées :**
  - `nom` (String): Nom du client.
  - `adresse` (String): Adresse du client.
  - `telephone` (String): Numéro de téléphone du client.
  - `estProfessionnel` (boolean): Indique si le client est un professionnel.

### Création de Devis
- Générer un devis avant le début des travaux, incluant une estimation des coûts des matériaux, de la main-d'œuvre, des équipements, et des taxes.
- Inclure une date d’émission et une date de validité du devis.
- Indiquer si le devis a été accepté par le client.
- **Caractéristiques d’un devis :**
  - `montantEstime` (double): Montant estimé du projet sur la base des devis.
  - `dateEmission` (Date): Date d'émission du devis.
  - `dateValidite` (Date): Date de validité du devis.
  - `accepte` (boolean): Indique si le devis a été accepté par le client.

### Calcul des Coûts
- Intégrer les coûts des composants (matériaux, main-d'œuvre) dans le calcul du coût total du projet.
- Appliquer une marge bénéficiaire pour obtenir le coût final du projet.
- Tenir compte des taxes (TVA) et des remises applicables.
- Gérer les ajustements des coûts basés sur la qualité des matériaux ou la productivité de la main-d'œuvre.

### Affichage des Détails et Résultats
- Afficher les détails complets du projet (client, composants, coût total).
- Afficher les informations d'un client, d'un devis.
- Générer un récapitulatif détaillé du coût total incluant la main-d'œuvre, les matériaux, les taxes, et la marge bénéficiaire.

## User Stories
1. **En tant que professionnel de la construction**, je veux créer un nouveau projet de rénovation ou de construction, afin que je puisse suivre tous les détails du projet et les coûts associés.
2. **En tant que professionnel**, je veux associer un client à chaque projet, afin que je puisse garder une trace des informations client pour la facturation et les devis.
3. **En tant qu'utilisateur**, je veux ajouter des matériaux à un projet avec leur coût unitaire, leur quantité et leur transport, afin que je puisse estimer précisément les coûts des matériaux pour ce projet.
4. **En tant que professionnel**, je veux enregistrer les heures de travail des ouvriers avec leur taux horaire et leur productivité, afin que je puisse calculer le coût total de la main-d'œuvre.
5. **En tant que chef de projet**, je veux pouvoir gérer plusieurs types de matériaux et travailleurs spécialisés, afin que je puisse calculer précisément les coûts selon le niveau de qualité ou d'expertise requis.
6. **En tant que professionnel**, je veux générer un devis basé sur les coûts estimés des matériaux, de la main-d'œuvre, et des équipements, afin que je puisse fournir une estimation claire et transparente au client.
7. **En tant qu’utilisateur**, je veux indiquer une date d'émission et une date de validité du devis, afin que le client sache jusqu'à quand l'offre est valable.
8. **En tant que client**, je veux pouvoir accepter ou refuser un devis, afin que le projet puisse avancer selon mon accord.
9. **En tant que professionnel**, je veux enregistrer les informations de mes clients afin que je puisse les contacter facilement pour le suivi des projets et la facturation.
10. **En tant qu'utilisateur**, je veux différencier les clients professionnels et particuliers, afin que je puisse appliquer des remises ou des conditions spécifiques selon le type de client.
11. **En tant que professionnel**, je veux calculer le coût total du projet en incluant les matériaux, la main-d'œuvre, les équipements, et les taxes, afin que je puisse avoir une vision claire des coûts avant et après la marge bénéficiaire.
12. **En tant que gestionnaire**, je veux pouvoir ajuster les coûts selon la qualité des matériaux ou la productivité des ouvriers, afin que je puisse refléter avec précision les variations dans l'estimation finale.
13. **En tant que professionnel**, je veux voir les taxes appliquées à chaque composant du projet, afin que je puisse inclure la TVA et autres charges dans l’estimation finale.

