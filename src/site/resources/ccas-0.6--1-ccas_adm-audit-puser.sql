
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

