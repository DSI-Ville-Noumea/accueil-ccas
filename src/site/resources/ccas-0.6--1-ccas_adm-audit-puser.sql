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

create sequence s_puser_audit;

create table puser_audit(
	id_audit integer NOT NULL default nextval('s_puser_audit') primary key,
	operation         char(1)   NOT NULL,
    stamp             timestamp NOT NULL,
    userid            text      NOT NULL,
	--
	id integer,
    login character varying(255),
    css character varying(255),
    admin boolean,
    visible boolean
);



CREATE OR REPLACE FUNCTION process_puser_audit() RETURNS TRIGGER AS $puser_audit$
    BEGIN
        --
        -- Create a row in puser_audit to reflect the operation performed on puser,
        -- make use of the special variable TG_OP to work out the operation.
        --
        IF (TG_OP = 'DELETE') THEN
            INSERT INTO puser_audit SELECT nextval('s_puser_audit'), 'D', now(), user, OLD.*;
            RETURN OLD;
        ELSIF (TG_OP = 'UPDATE') THEN
            INSERT INTO puser_audit SELECT nextval('s_puser_audit'), 'U', now(), user, NEW.*;
            RETURN NEW;
        ELSIF (TG_OP = 'INSERT') THEN
            INSERT INTO puser_audit SELECT nextval('s_puser_audit'), 'I', now(), user, NEW.*;
            RETURN NEW;
        END IF;
        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$puser_audit$ LANGUAGE plpgsql;



drop trigger if exists puser_audit on puser;
CREATE TRIGGER puser_audit
AFTER INSERT OR UPDATE OR DELETE ON puser FOR EACH ROW EXECUTE PROCEDURE process_puser_audit();

