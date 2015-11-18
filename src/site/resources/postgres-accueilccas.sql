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
﻿-- --------------------------------------------------------
--
-- Création de la base de données pour
-- l'application Accueil CCAS
--
-- --------------------------------------------------------


-- depuis le shell, connecte en postgres
createdb -E UTF8 ccas
createuser -D -E -R -S ccas
psql -d ccas
create schema ccas AUTHORIZATION ccas;
alter schema ccas owner to ccas;
alter user ccas with password 'ccas';

--
-- Structure de la table Accueil
--
create sequence s_accueil;
CREATE TABLE accueil (
    acc_id integer NOT NULL NOT NULL default nextval('s_accueil'),
    acc_date timestamp without time zone NOT NULL,
    acc_commentaire character varying(255),
    acc_typereception integer NOT NULL,
    acc_typepublic integer NOT NULL,
    acc_typereponse integer NOT NULL,
    id_agent integer NOT NULL
);

-- --------------------------------------------------------

--
-- Structure de la table AttributCategorie
--

create sequence s_attributcategorie start 18;

CREATE TABLE attributcategorie (
    att_id integer NOT NULL default nextval('s_attributcategorie'),
    att_libelle character varying(255),
    att_position integer,
	att_categorie integer,
    att_enabled boolean
);


--
-- Contenu de la table attributcategorie
--

INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (1, 'Remise dossier d''aide', 2, 2, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (2, 'Prise de RDV', 3, 2, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (3, '1er niveau d''instruction', 1, 1, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (4, '2e niveau d''instruction', 2, 1, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (5, '3e niveau : Evaluation', 3, 1, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (6, 'Services ville/Logement', 1, 3, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (7, 'MDEE/Espace Insertion', 3, 3, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (8, 'Conseil General/CVS', 2, 3, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (9, 'Securite sociale', 5, 3, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (10, 'Autre', 8, 3, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (11, 'CLIC', 6, 3, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (12, 'Aide a la redaction', 7, 3, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (13, 'Remise du courrier', 4, 2, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (14, 'Remise de carte handicap', 5, 2, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (15, 'Information/documentation', 1, 2, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (16, 'Regie', 4, 1, TRUE);
INSERT INTO attributcategorie (att_id, att_libelle, att_position, att_categorie, att_enabled) VALUES (17, 'Associations', 4, 3, TRUE);

select * from attributcategorie ;



-- --------------------------------------------------------

--
-- Structure de la table Categorie
--

CREATE sequence s_categorie start 4;

CREATE TABLE categorie (
    cat_id integer NOT NULL default nextval('s_categorie'),
    cat_libelle character varying(255),
    cat_position integer,
	groupe_id integer,
    cat_enabled boolean,
    PRIMARY KEY  (cat_id)
);



--
-- Contenu de la table Categorie
--

INSERT INTO categorie (cat_id, cat_libelle, cat_position, groupe_id, cat_enabled) VALUES (1, 'CCAS', 1, 1, TRUE);
INSERT INTO categorie (cat_id, cat_libelle, cat_position, groupe_id, cat_enabled) VALUES (2, 'Informations', 1, 2, TRUE);
INSERT INTO categorie (cat_id, cat_libelle, cat_position, groupe_id, cat_enabled) VALUES (3, 'Partenaires', 2, 1, TRUE);

select * from categorie;

-- --------------------------------------------------------

--
-- Structure de la table Groupe
--

CREATE sequence s_groupe start 3;

CREATE TABLE groupe (
    group_id integer NOT NULL default nextval('s_groupe'),
    nom_groupe character varying(255),
    position_groupe integer,
    groupe_enabled boolean
);



--
-- Contenu de la table Groupe
--

INSERT INTO groupe (group_id, nom_groupe, position_groupe, groupe_enabled) VALUES (1, 'Orientation', 2, TRUE);
INSERT INTO groupe (group_id, nom_groupe, position_groupe, groupe_enabled) VALUES (2, 'Information', 1, TRUE);

select * from groupe ;



-- --------------------------------------------------------

--
-- Structure de la table Rapports
--

CREATE sequence s_rapports start 14;
CREATE TABLE rapports (
  id_rapport  bigint NOT NULL default nextval('s_rapports'),
  titre varchar(50) NOT NULL,
  "desc" varchar(250) default NULL,
  url varchar(100) NOT NULL
);


--
-- Structure de la table TypePublic
--

CREATE sequence s_typepublic start 9;

CREATE TABLE typepublic (
    pub_id integer NOT NULL default nextval('s_typepublic'),
    pub_libelle character varying(255),
    pub_position integer,
    pub_enabled boolean
);




--
-- Contenu de la table TypePublic
--

INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (1, 'Personne handicapee', 2, TRUE);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (2, 'Personne agee', 1, TRUE);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (3, 'Menage en difficulte', 3, TRUE);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (4, 'Domicilie / SDF', 4, TRUE);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (5, 'Autres', 6, TRUE);
INSERT INTO typepublic (pub_id, pub_libelle, pub_position, pub_enabled) VALUES (8, 'Partenaires', 5, TRUE);

select * from typepublic ;
-- --------------------------------------------------------

--
-- Structure de la table TypeReception
--

CREATE sequence  s_typereception start 3;

CREATE TABLE typereception (
    rec_id integer NOT NULL default nextval('s_typereception'),
    rec_libelle character varying(255),
    rec_position integer,
    rec_enabled boolean
);




--
-- Contenu de la table TypeReception
--

INSERT INTO typereception (rec_id, rec_libelle, rec_position, rec_enabled) VALUES (1, 'Physique', 1, TRUE);
INSERT INTO typereception (rec_id, rec_libelle, rec_position, rec_enabled) VALUES (2, 'Telephonique', 2, TRUE);

 select * from typereception;

-- --------------------------------------------------------

--
-- Structure de la table User
--

CREATE sequence s_user  start 2;

CREATE TABLE puser (
    id integer NOT NULL default nextval('s_user'),
    login character varying(255),
    css character varying(255),
    admin boolean,
    visible boolean
);


--
-- Contenu de la table User
-- 

INSERT INTO puser (id, login, css, admin, visible) VALUES (3, 'barmi83', 'Magenta', TRUE, TRUE);
INSERT INTO puser (id, login, css, admin, visible) VALUES (4, 'salad74', 'Magenta', TRUE, TRUE);

select * from puser;

CREATE sequence s_rapports start 14;
CREATE TABLE rapports (
  id_rapport  bigint NOT NULL default nextval('s_rapports'),
  titre varchar(50) NOT NULL,
  "desc" varchar(250) default NULL,
  url varchar(100) NOT NULL,
  PRIMARY KEY  (id_rapport)
);




--
-- Contraintes pour les tables exportees
--

--
-- Contraintes pour la table Accueil
--
ALTER TABLE Accueil ADD CONSTRAINT FK1D0E9F9424C8556E FOREIGN KEY (acc_typereponse) REFERENCES AttributCategorie (att_id);
ALTER TABLE Accueil ADD CONSTRAINT FK1D0E9F94D0D9D45A FOREIGN KEY (acc_typepublic) REFERENCES TypePublic (pub_id);
ALTER TABLE Accueil ADD CONSTRAINT FK1D0E9F94DCBB4116 FOREIGN KEY (acc_typereception) REFERENCES TypeReception (rec_id);

create sequence hibernate_sequence;

--
-- Contraintes pour la table AttributCategorie
--
ALTER TABLE AttributCategorie ADD CONSTRAINT FK55BCC42E4432421A FOREIGN KEY (att_categorie) REFERENCES Categorie (cat_id);


ALTER TABLE ONLY accueil
    ADD CONSTRAINT accueil_pkey PRIMARY KEY (acc_id);


--
-- Name: attributcategorie_pkey; Type: CONSTRAINT; Schema: ccas; Owner: ccas; Tablespace:
--

ALTER TABLE ONLY attributcategorie
    ADD CONSTRAINT attributcategorie_pkey PRIMARY KEY (att_id);


--
-- Name: categorie_pkey; Type: CONSTRAINT; Schema: ccas; Owner: ccas; Tablespace:
--

ALTER TABLE ONLY categorie
    ADD CONSTRAINT categorie_pkey PRIMARY KEY (cat_id);


--
-- Name: groupe_pkey; Type: CONSTRAINT; Schema: ccas; Owner: ccas; Tablespace:
--

ALTER TABLE ONLY groupe
    ADD CONSTRAINT groupe_pkey PRIMARY KEY (group_id);


--
-- Name: puser_pkey; Type: CONSTRAINT; Schema: ccas; Owner: ccas; Tablespace:
--

ALTER TABLE ONLY puser
    ADD CONSTRAINT puser_pkey PRIMARY KEY (id);


--
-- Name: typepublic_pkey; Type: CONSTRAINT; Schema: ccas; Owner: ccas; Tablespace:
--

ALTER TABLE ONLY typepublic
    ADD CONSTRAINT typepublic_pkey PRIMARY KEY (pub_id);


--
-- Name: typereception_pkey; Type: CONSTRAINT; Schema: ccas; Owner: ccas; Tablespace:
--

ALTER TABLE ONLY typereception
    ADD CONSTRAINT typereception_pkey PRIMARY KEY (rec_id);
