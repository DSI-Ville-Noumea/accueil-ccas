#!/bin/sh

###
# #%L
# Accueil CCAS
# %%
# Copyright (C) 2012 - 2015 Mairie de Nouméa
# %%
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
# 
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
# 
# You should have received a copy of the GNU General Public
# License along with this program.  If not, see
# <http://www.gnu.org/licenses/gpl-3.0.html>.
# #L%
###

# source de l'instance
source /etc/sysconfig/pgsql/pgsql0

createuser --no-createdb --encrypted --no-createrole --no-superuser ccas_adm
createuser --no-createdb --encrypted --no-createrole --no-superuser ccas_usr
createuser --no-createdb --encrypted --no-createrole --no-superuser ccas_read
createdb --encoding=UTF8 ccas
psql --dbname=ccas -f ./ccas-0.3.0-01-postgres-create_schema.sql
psql --dbname=ccas -f ./ccas-0.3.0-02-postgres-alter_user.sql
psql --dbname=ccas --username=ccas_adm -f ./ccas-0.3.0-03-ccas_adm-create_table.sql
psql --dbname=ccas --username=ccas_adm -f ./ccas-0.3.0-04-ccas_adm-grant.sql
