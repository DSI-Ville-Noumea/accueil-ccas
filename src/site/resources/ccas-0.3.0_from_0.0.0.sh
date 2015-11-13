#!/bin/sh

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
