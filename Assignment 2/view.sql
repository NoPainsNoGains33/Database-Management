DROP VIEW IF EXISTS developer_roles_and_priviledges;

CREATE VIEW developer_roles_and_priviledges AS
	SELECT 
    p.first_name AS 'first name',
    p.last_name AS 'last name',
    p.username,
    p.email,
    w.name,
    w.visits,
    w.updated AS 'website last updated',
    w_r.role AS 'website role',
    w_p.priviledge As 'website priviledge',
    pg.title,
    pg.views,
    pg.updated AS 'page last updated',
    p_r.role AS 'page role',
    p_p.priviledge AS 'page priviledge'
	FROM 
    developer d, 
    person p, 
    website w, 
    website_role w_r, 
    website_priviledge w_p, 
    page pg, 
    page_role p_r, 
    page_priviledge p_p
	WHERE 
    d.id = p.id AND 
    w_r.developer_id = d.id AND w_r.website_id = w.id AND 
    w_p.developer_id = d.id AND w_p.website_id = w.id AND
    pg.website_id = w.id AND
    p_r.developer_id = d.id AND p_r.page_id = pg.id AND
    p_p.developer_id = d.id AND p_p.page_id = pg.id;

SELECT * FROM developer_roles_and_priviledges;
