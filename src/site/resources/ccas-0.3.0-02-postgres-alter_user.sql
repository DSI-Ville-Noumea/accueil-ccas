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
-- changement des mots de passe
alter user ccas_adm with password 'ccasadm';
alter user ccas_usr with password 'ccasusr';
alter user ccas_read with password 'ccasread';

-- mise en place des synonymes
ALTER USER ccas_usr SET search_path to 'ccas_adm';
ALTER USER ccas_read SET search_path to 'ccas_adm';
GRANT USAGE ON SCHEMA ccas_adm TO ccas_usr;
GRANT USAGE ON SCHEMA ccas_adm TO ccas_read;

