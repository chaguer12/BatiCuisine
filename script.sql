CREATE DATABASE BATICUISINE
       /*creating devis table*/
Create table devis (
                       id serial Primary key not null,
                       MontantEstime double precision,
                       Date_Emmission date,
                       Date_Expiration date,
                       Accept boolean default false
);
