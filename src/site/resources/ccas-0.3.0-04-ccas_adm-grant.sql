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
-- Grants de lecture pour faire du reporting
GRANT SELECT ON accueil TO ccas_read;
GRANT SELECT ON attributcategorie TO ccas_read;
GRANT SELECT ON categorie TO ccas_read;
GRANT SELECT ON groupe TO ccas_read;
GRANT SELECT ON puser TO ccas_read;       
GRANT SELECT ON rapports TO ccas_read;
GRANT SELECT ON typepublic TO ccas_read;
GRANT SELECT ON typereception TO ccas_read;

-- Grants de lecture/ecriture pour l'application (a configurer dans le datasource du serveur d'appli)
GRANT SELECT, INSERT, UPDATE, DELETE ON accueil TO ccas_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON attributcategorie TO ccas_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON categorie TO ccas_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON groupe TO ccas_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON puser TO ccas_usr;       
GRANT SELECT, INSERT, UPDATE, DELETE ON rapports TO ccas_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON typepublic TO ccas_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON typereception TO ccas_usr;

GRANT SELECT, UPDATE ON hibernate_sequence TO ccas_usr;
GRANT SELECT, UPDATE ON s_accueil TO ccas_usr;
GRANT SELECT, UPDATE ON s_attributcategorie TO ccas_usr;
GRANT SELECT, UPDATE ON s_categorie TO ccas_usr;
GRANT SELECT, UPDATE ON s_groupe TO ccas_usr;
GRANT SELECT, UPDATE ON s_rapports TO ccas_usr;
GRANT SELECT, UPDATE ON s_typepublic TO ccas_usr;
GRANT SELECT, UPDATE ON s_typereception TO ccas_usr;
GRANT SELECT, UPDATE ON s_user TO ccas_usr;
