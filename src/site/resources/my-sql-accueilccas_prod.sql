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
-- phpMyAdmin SQL Dump
-- version 2.9.1.1-Debian-11
-- http://www.phpmyadmin.net
-- 
-- Serveur: localhost
-- Généré le : Mardi 25 Septembre 2012 à 12:00
-- Version du serveur: 5.0.32
-- Version de PHP: 5.2.0-8+etch13
-- 
-- Base de données: `accueilccas_prod`
-- 

-- --------------------------------------------------------

-- 
-- Structure de la table `Accueil`
-- 

CREATE TABLE `Accueil` (
  `acc_id` int(11) NOT NULL auto_increment,
  `acc_date` datetime NOT NULL,
  `id_agent` int(11) NOT NULL,
  `acc_commentaire` varchar(255) default NULL,
  `acc_typereception` int(11) NOT NULL,
  `acc_typepublic` int(11) NOT NULL,
  `acc_typereponse` int(11) NOT NULL,
  PRIMARY KEY  (`acc_id`),
  KEY `FK1D0E9F94DCBB4116` (`acc_typereception`),
  KEY `FK1D0E9F9424C8556E` (`acc_typereponse`),
  KEY `FK1D0E9F94D0D9D45A` (`acc_typepublic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

-- 
-- Structure de la table `AttributCategorie`
-- 

CREATE TABLE `AttributCategorie` (
  `att_id` int(11) NOT NULL auto_increment,
  `att_libelle` varchar(255) default NULL,
  `att_position` int(11) default NULL,
  `att_categorie` int(11) NOT NULL,
  `att_enabled` tinyint(1) NOT NULL,
  PRIMARY KEY  (`att_id`),
  KEY `FK55BCC42E4432421A` (`att_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

-- 
-- Contenu de la table `AttributCategorie`
-- 

INSERT INTO `AttributCategorie` (`att_id`, `att_libelle`, `att_position`, `att_categorie`, `att_enabled`) VALUES 
(1, 'Remise dossier d''aide', 2, 2, 1),
(2, 'Prise de RDV', 3, 2, 1),
(3, '1er niveau d''instruction', 1, 1, 1),
(4, '2e niveau d''instruction', 2, 1, 1),
(5, '3e niveau : évaluation', 3, 1, 1),
(6, 'Services ville/Logement', 1, 3, 1),
(7, 'MDEE/Espace Insertion', 3, 3, 1),
(8, 'Conseil Général/CVS', 2, 3, 1),
(9, 'Sécurité sociale', 5, 3, 1),
(10, 'Autre', 8, 3, 1),
(11, 'CLIC', 6, 3, 1),
(12, 'Aide à la rédaction', 7, 3, 1),
(13, 'Remise du courrier', 4, 2, 1),
(14, 'Remise de carte handicap', 5, 2, 1),
(15, 'Information/documentation', 1, 2, 1),
(16, 'Régie', 4, 1, 1),
(17, 'Associations', 4, 3, 1);

-- --------------------------------------------------------

-- 
-- Structure de la table `Categorie`
-- 

CREATE TABLE `Categorie` (
  `cat_id` int(11) NOT NULL auto_increment,
  `cat_libelle` varchar(255) default NULL,
  `cat_position` int(11) default NULL,
  `groupe_id` int(11) default NULL,
  `cat_enabled` tinyint(1) NOT NULL,
  PRIMARY KEY  (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- 
-- Contenu de la table `Categorie`
-- 

INSERT INTO `Categorie` (`cat_id`, `cat_libelle`, `cat_position`, `groupe_id`, `cat_enabled`) VALUES 
(1, 'CCAS', 1, 1, 1),
(2, 'Informations', 1, 2, 1),
(3, 'Partenaires', 2, 1, 1);

-- --------------------------------------------------------

-- 
-- Structure de la table `Groupe`
-- 

CREATE TABLE `Groupe` (
  `group_id` bigint(20) NOT NULL auto_increment,
  `nom_groupe` varchar(255) default NULL,
  `position_groupe` int(11) default NULL,
  `groupe_enabled` tinyint(1) NOT NULL,
  PRIMARY KEY  (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- 
-- Contenu de la table `Groupe`
-- 

INSERT INTO `Groupe` (`group_id`, `nom_groupe`, `position_groupe`, `groupe_enabled`) VALUES 
(1, 'Orientation', 2, 1),
(2, 'Information', 1, 1);

-- --------------------------------------------------------

-- 
-- Structure de la table `Rapports`
-- 

CREATE TABLE `Rapports` (
  `id_rapport` int(11) NOT NULL auto_increment,
  `titre` varchar(50) NOT NULL,
  `desc` varchar(250) default NULL,
  `url` varchar(100) NOT NULL,
  PRIMARY KEY  (`id_rapport`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;


-- 
-- Structure de la table `TypePublic`
-- 

CREATE TABLE `TypePublic` (
  `pub_id` int(11) NOT NULL auto_increment,
  `pub_libelle` varchar(255) default NULL,
  `pub_position` int(11) default NULL,
  `pub_enabled` tinyint(1) NOT NULL,
  PRIMARY KEY  (`pub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

-- 
-- Contenu de la table `TypePublic`
-- 

INSERT INTO `TypePublic` (`pub_id`, `pub_libelle`, `pub_position`, `pub_enabled`) VALUES 
(1, 'Personne handicapée', 2, 1),
(2, 'Personne agée', 1, 1),
(3, 'Ménage en difficulté', 3, 1),
(4, 'Domicilié / SDF', 4, 1),
(5, 'Autres', 6, 1),
(8, 'Partenaires', 5, 1);

-- --------------------------------------------------------

-- 
-- Structure de la table `TypeReception`
-- 

CREATE TABLE `TypeReception` (
  `rec_id` int(11) NOT NULL auto_increment,
  `rec_libelle` varchar(255) default NULL,
  `rec_position` int(11) default NULL,
  `rec_enabled` tinyint(1) NOT NULL,
  PRIMARY KEY  (`rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- 
-- Contenu de la table `TypeReception`
-- 

INSERT INTO `TypeReception` (`rec_id`, `rec_libelle`, `rec_position`, `rec_enabled`) VALUES 
(1, 'Physique', 1, 1),
(2, 'Téléphonique', 2, 1);

-- --------------------------------------------------------

-- 
-- Structure de la table `User`
-- 

CREATE TABLE `User` (
  `id` int(11) NOT NULL auto_increment,
  `login` varchar(30) NOT NULL,
  `css` text,
  `admin` tinyint(1) NOT NULL default '0',
  `visible` tinyint(4) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- 
-- Contenu de la table `User`
-- 

INSERT INTO `User` (`id`, `login`, `css`, `admin`, `visible`) VALUES 
(3, 'Dessault', 'Magenta', 1, 1)
;

-- 
-- Contraintes pour les tables exportées
-- 

-- 
-- Contraintes pour la table `Accueil`
-- 
ALTER TABLE `Accueil`
  ADD CONSTRAINT `FK1D0E9F9424C8556E` FOREIGN KEY (`acc_typereponse`) REFERENCES `AttributCategorie` (`att_id`),
  ADD CONSTRAINT `FK1D0E9F94D0D9D45A` FOREIGN KEY (`acc_typepublic`) REFERENCES `TypePublic` (`pub_id`),
  ADD CONSTRAINT `FK1D0E9F94DCBB4116` FOREIGN KEY (`acc_typereception`) REFERENCES `TypeReception` (`rec_id`);

-- 
-- Contraintes pour la table `AttributCategorie`
-- 
ALTER TABLE `AttributCategorie`
  ADD CONSTRAINT `FK55BCC42E4432421A` FOREIGN KEY (`att_categorie`) REFERENCES `Categorie` (`cat_id`);
