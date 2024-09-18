CREATE DATABASE BATICUISINE
    /*creating devis table*/
Create table devis (
                       id serial Primary key not null,
                       MontantEstime double precision,
                       Date_Emmission date,
                       Date_Expiration date,
                       Accept boolean default false
);
    /*creating projets table*/
create table projets (
                         id serial primary key not null,
                         nom varchar(255),
                         marge_bénèfique double precision,
                         cout_total double precision,
                         etat varchar(255)
);
    /*creating clients table*/
create table client (
                        id serial primary key not null,
                        nom_complet varchar(255),
                        adresse varchar(255),
                        telephone varchar(13),
                        est_pro boolean default false
);
    /*creating composants table*/
create table composants (
                            id serial primary key not null,
                            nom varchar(255),
                            Type_composant varchar(255)
);
    /*Adding constraint for projets and devis tables*/
alter table devis add column projet_id integer references projets (id);
    /*Adding constraint for projets and clients tables*/
alter table projets add column client_id integer references clients(id);
    /*Adding constraint for projets and composants tables*/
alter table composants add column projet_id integer references projets (id);
    /*Inherited tables*/
create table main_ouevre(
                            taux_horaire double precision,
                            heures_travail double precision,
                            coeff_productivite double precision) inherits (composants);
create table materiaux (
                           cout_unitaire double precision,
                           quantite double precision,
                           cout_transport double precision,
                           coeff_qualite double precision
);



