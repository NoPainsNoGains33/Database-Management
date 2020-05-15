# Website part
DROP TRIGGER IF EXISTS after_websiterole_insert; # For debugging
DROP TRIGGER IF EXISTS after_pagerole_insert; # For debugging
DROP TRIGGER IF EXISTS after_websiterole_update; # For debugging
DROP TRIGGER IF EXISTS after_pagerole_update; # For debugging
DROP TRIGGER IF EXISTS after_websiterole_delete; # For debugging
DROP TRIGGER IF EXISTS after_pagerole_delete; # For debugging
DELIMITER $$
CREATE TRIGGER after_websiterole_insert
	AFTER INSERT ON website_role
    FOR EACH ROW 
BEGIN
    IF new.role = 'owner' or new.role = 'admin' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'create'),
    (new.developer_id, new.website_id, 'read'),
    (new.developer_id, new.website_id, 'update'),
    (new.developer_id, new.website_id, 'delete');
    ELSEIF new.role = 'writer' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'create'),
    (new.developer_id, new.website_id, 'read'),
    (new.developer_id, new.website_id, 'update');
    ELSEIF new.role = 'editor' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'read'),
    (new.developer_id, new.website_id, 'update');
    ELSEIF new.role = 'reviewer' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'read');
    END IF;
END $$

CREATE TRIGGER after_websiterole_update
	AFTER UPDATE ON website_role
    FOR EACH ROW 
BEGIN
	DELETE FROM website_priviledge 
    WHERE 
    new.website_id = website_id AND new.developer_id = developer_id;
    IF new.role = 'owner' or new.role = 'admin' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'create'),
    (new.developer_id, new.website_id, 'read'),
    (new.developer_id, new.website_id, 'update'),
    (new.developer_id, new.website_id, 'delete');
    ELSEIF new.role = 'writer' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'create'),
    (new.developer_id, new.website_id, 'read'),
    (new.developer_id, new.website_id, 'update');
    ELSEIF new.role = 'editor' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'read'),
    (new.developer_id, new.website_id, 'update');
    ELSEIF new.role = 'reviewer' THEN
    INSERT INTO website_priviledge (developer_id, website_id, priviledge) VALUES
    (new.developer_id, new.website_id, 'read');
    END IF;
END $$

CREATE TRIGGER after_websiterole_delete
	BEFORE DELETE ON website_role
    FOR EACH ROW 
BEGIN
	DELETE FROM website_priviledge 
    WHERE 
    old.website_id = website_id AND old.developer_id = developer_id;
END $$

# Page part
CREATE TRIGGER after_pagerole_insert
	AFTER INSERT ON page_role
    FOR EACH ROW 
BEGIN
    IF new.role = 'owner' or new.role = 'admin' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'create'),
    (new.developer_id, new.page_id, 'read'),
    (new.developer_id, new.page_id, 'update'),
    (new.developer_id, new.page_id, 'delete');
    ELSEIF new.role = 'writer' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'create'),
    (new.developer_id, new.page_id, 'read'),
    (new.developer_id, new.page_id, 'update');
    ELSEIF new.role = 'editor' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'read'),
    (new.developer_id, new.page_id, 'update');
    ELSEIF new.role = 'reviewer' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'read');
    END IF;
END $$

CREATE TRIGGER after_pagerole_update
	AFTER UPDATE ON page_role
    FOR EACH ROW 
BEGIN
	DELETE FROM page_priviledge 
    WHERE 
    new.page_id = page_id AND new.developer_id = developer_id;
    IF new.role = 'owner' or new.role = 'admin' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'create'),
    (new.developer_id, new.page_id, 'read'),
    (new.developer_id, new.page_id, 'update'),
    (new.developer_id, new.page_id, 'delete');
    ELSEIF new.role = 'writer' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'create'),
    (new.developer_id, new.page_id, 'read'),
    (new.developer_id, new.page_id, 'update');
    ELSEIF new.role = 'editor' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'read'),
    (new.developer_id, new.page_id, 'update');
    ELSEIF new.role = 'reviewer' THEN
    INSERT INTO page_priviledge (developer_id, page_id, priviledge) VALUES
    (new.developer_id, new.page_id, 'read');
    END IF;
END $$

CREATE TRIGGER after_pagerole_delete
	BEFORE DELETE ON page_role
    FOR EACH ROW 
BEGIN
	DELETE FROM page_priviledge 
    WHERE 
    old.page_id = page_id AND old.developer_id = developer_id;
END $$

DELIMITER ;
