-- changement des mots de passe
alter user ccas_adm with password 'ccasadm';
alter user ccas_usr with password 'ccasusr';
alter user ccas_read with password 'ccasread';

-- mise en place des synonymes
ALTER USER ccas_usr SET search_path to 'ccas_adm';
ALTER USER ccas_read SET search_path to 'ccas_adm';
GRANT USAGE ON SCHEMA ccas_adm TO ccas_usr;
GRANT USAGE ON SCHEMA ccas_adm TO ccas_read;

