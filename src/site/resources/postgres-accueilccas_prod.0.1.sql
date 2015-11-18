---
-- #%L
-- Accueil CCAS
-- %%
-- Copyright (C) 2012 - 2015 Mairie de Nouméa
-- %%
-- This program is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as
-- published by the Free Software Foundation, either version 3 of the
-- License, or (at your option) any later version.
-- 
-- This program is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU General Public License for more details.
-- 
-- You should have received a copy of the GNU General Public
-- License along with this program.  If not, see
-- <http://www.gnu.org/licenses/gpl-3.0.html>.
-- #L%
---
﻿-- phpMyAdmin SQL Dump
-- version 2.9.1.1-Debian-11
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- G�n�r� le : Mardi 25 Septembre 2012 � 12:00
-- Version du serveur: 5.0.32
-- Version de PHP: 5.2.0-8+etch13
--
-- Base de donn�es: accueilccas_prod
--

-- --------------------------------------------------------

createdb -E UTF8 ccas
createuser -D -E -R -S ccas
psql -d ccas
create schema ccas AUTHORIZATION ccas;
alter user ccas with password 'ccas';

--
-- Structure de la table Accueil
--
create sequence s_accueil;

CREATE TABLE accueil (
  acc_id integer NOT NULL default nextval('s_accueil'),
  acc_date date NOT NULL,
  id_agent integer NOT NULL,
  acc_commentaire varchar(255) default NULL,
  acc_typereception integer NOT NULL,
  acc_typepublic integer NOT NULL,
  acc_typereponse integer NOT NULL,
  PRIMARY KEY  (acc_id)
  );

-- --------------------------------------------------------

--
-- Structure de la table AttributCategorie
--

create sequence s_attributcategorie start 18;

CREATE TABLE attributcategorie (
  att_id integer NOT NULL default nextval('s_attributcategorie'),
  att_libelle varchar(255) default NULL,
  att_position integer default NULL,
  att_categorie integer NOT NULL,
  att_enabled boolean NOT NULL,
  PRIMARY KEY  (att_id)
);

--
-- Contenu de la table attributcategorie
--

INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (1, 'Remise dossier d''aide', 2, 2, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (2, 'Prise de RDV', 3, 2, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (3, '1er niveau d''instruction', 1, 1, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (4, '2e niveau d''instruction', 2, 1, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (5, '3e niveau : Evaluation', 3, 1, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (6, 'Services ville/Logement', 1, 3, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (7, 'MDEE/Espace Insertion', 3, 3, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (8, 'Conseil General/CVS', 2, 3, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (9, 'Securite sociale', 5, 3, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (10, 'Autre', 8, 3, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (11, 'CLIC', 6, 3, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (12, 'Aide a la redaction', 7, 3, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (13, 'Remise du courrier', 4, 2, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (14, 'Remise de carte handicap', 5, 2, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (15, 'Information/documentation', 1, 2, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (16, 'Regie', 4, 1, true);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (17, 'Associations', 4, 3, true);

select * from attributcategorie ;



-- --------------------------------------------------------

--
-- Structure de la table Categorie
--

CREATE sequence s_categorie start 4;


CREATE TABLE categorie (
  cat_id integer NOT NULL default nextval('s_categorie'),
  cat_libelle varchar(255) default NULL,
  cat_position integer default NULL,
  groupe_id integer default NULL,
  cat_enabled smallint NOT NULL,
  PRIMARY KEY  (cat_id)
);

--
-- Contenu de la table Categorie
--

INSERT INTO categorie (cat_id, cat_libelle, cat_position, groupe_id, cat_enabled) VALUES (1, 'CCAS', 1, 1, 1);
INSERT INTO categorie (cat_id, cat_libelle, cat_position, groupe_id, cat_enabled) VALUES (2, 'Informations', 1, 2, 1);
INSERT INTO categorie (cat_id, cat_libelle, cat_position, groupe_id, cat_enabled) VALUES (3, 'Partenaires', 2, 1, 1);

select * from categorie;

-- --------------------------------------------------------

--
-- Structure de la table Groupe
--

CREATE sequence s_groupe start 3;
CREATE TABLE groupe (
  group_id bigint NOT NULL default nextval('s_groupe'),
  nom_groupe varchar(255) default NULL,
  position_groupe integer default NULL,
  groupe_enabled smallint NOT NULL,
  PRIMARY KEY  (group_id)
);

--
-- Contenu de la table Groupe
--

INSERT INTO groupe (group_id, nom_groupe, position_groupe, groupe_enabled) VALUES (1, 'Orientation', 2, 1);
INSERT INTO groupe (group_id, nom_groupe, position_groupe, groupe_enabled) VALUES (2, 'Information', 1, 1);

select * from groupe ;



-- --------------------------------------------------------

--
-- Structure de la table Rapports
--

CREATE sequence s_rapports start 14;
CREATE TABLE rapports (
  id_rapport  integer NOT NULL default nextval('s_rapports'),
  titre varchar(50) NOT NULL,
  "desc" varchar(250) default NULL,
  url varchar(100) NOT NULL,
  PRIMARY KEY  (id_rapport)
);


--
-- Structure de la table TypePublic
--

CREATE sequence s_typepublic start 9;
CREATE TABLE typepublic (
  pub_id integer NOT NULL default nextval('s_typepublic'),
  pub_libelle varchar(255) default NULL,
  pub_position integer default NULL,
  pub_enabled smallint NOT NULL,
  PRIMARY KEY  (pub_id)
);

--
-- Contenu de la table TypePublic
--

INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (1, 'Personne handicapee', 2, 1);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (2, 'Personne agee', 1, 1);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (3, 'Menage en difficulte', 3, 1);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (4, 'Domicilie / SDF', 4, 1);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (5, 'Autres', 6, 1);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (8, 'Partenaires', 5, 1);

select * from typepublic ;
-- --------------------------------------------------------

--
-- Structure de la table TypeReception
--

CREATE sequence  s_typereception start 3;
CREATE TABLE typereception (
  rec_id integer NOT NULL default nextval('s_typereception'),
  rec_libelle varchar(255) default NULL,
  rec_position integer default NULL,
  rec_enabled smallint NOT NULL,
  PRIMARY KEY  (rec_id)
);

--
-- Contenu de la table TypeReception
--

INSERT INTO typereception (rec_id, rec_libelle, rec_position, rec_enabled) VALUES (1, 'Physique', 1, 1);
INSERT INTO typereception (rec_id, rec_libelle, rec_position, rec_enabled) VALUES (2, 'Telephonique', 2, 1);

 select * from typereception;

-- --------------------------------------------------------

--
-- Structure de la table User
--

CREATE sequence s_user  start 2;
CREATE TABLE puser (
  id integer NOT NULL default nextval('s_user'),
  login varchar(255) NOT NULL,
  css varchar(255),
  admin smallint NOT NULL default 0,
  visible smallint NOT NULL,
  PRIMARY KEY  (id)
);

--
-- Contenu de la table User
--

INSERT INTO puser (id, login, css, admin, visible) VALUES (3, 'barmi83', 'Magenta', 1, 1);
INSERT INTO puser (id, login, css, admin, visible) VALUES (4, 'salad74', 'Magenta', 1, 1);

select * from puser;


--
-- Contraintes pour les tables exportees
--

--
-- Contraintes pour la table Accueil
--
ALTER TABLE Accueil ADD CONSTRAINT FK1D0E9F9424C8556E FOREIGN KEY (acc_typereponse) REFERENCES AttributCategorie (att_id);
ALTER TABLE Accueil ADD CONSTRAINT FK1D0E9F94D0D9D45A FOREIGN KEY (acc_typepublic) REFERENCES TypePublic (pub_id);
ALTER TABLE Accueil ADD CONSTRAINT FK1D0E9F94DCBB4116 FOREIGN KEY (acc_typereception) REFERENCES TypeReception (rec_id);

--
-- Contraintes pour la table AttributCategorie
--
ALTER TABLE AttributCategorie ADD CONSTRAINT FK55BCC42E4432421A FOREIGN KEY (att_categorie) REFERENCES Categorie (cat_id);
