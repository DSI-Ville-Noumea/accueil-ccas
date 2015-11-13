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
