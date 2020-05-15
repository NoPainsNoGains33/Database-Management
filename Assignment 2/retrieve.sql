# Question 1
# a
	SELECT d.*
	FROM person p, developer d 
	WHERE p.id = d.id;
# b
	SELECT d.*
    FROM person p, developer d 
	WHERE p.id = d.id and d.id = 34;
# c
	SELECT d.* 
	FROM person p, developer d, website w, website_role w_r 
	WHERE 
    p.id = d.id and 
    w.name = 'Twitter' and 
    w_r.website_id = w.id and
    w_r.developer_id = d.id and 
    w_r.role <> 'owner';
# d 
	SELECT d.* 
	FROM person p, developer d, page pg, page_role p_r 
	WHERE 
    p.id = d.id and 
    p_r.role = 'reviewer' and
    p_r.developer_id = d.id and
    p_r.page_id = pg.id and
    pg.views < 300000;
# e
	SELECT d.* 
	FROM person p, developer d, website w, page pg, page_role p_r, widget wg
	WHERE 
    p.id = d.id and 
    w.name = 'CNET' and
    pg.website_id = w.id and
    pg.title = 'HOME' and
    p_r.role = 'writer' and
    p_r.developer_id = d.id and
    p_r.page_id = pg.id and
    wg.page_id = pg.id and 
    wg.DTYPE = 'HEADING';

# Question 2
# a
	SELECT w.* 
    FROM website w
    WHERE visits = 
    (SELECT MIN(visits) FROM website);

#b 
	SELECT w.* 
    FROM website w
    WHERE id = 678;
    
#c
	SELECT w.* 
    FROM developer d, website w, website_role w_r, person p, widget wg, page pg, page_role p_r
    WHERE
    p.username = 'bob' and 
    p.id = w_r.developer_id and
    p.id = d.id and
    w_r.website_id = w.id and 
    pg.website_id = w.id and 
    p_r.role = 'reviewer' and
    p_r.developer_id = p.id and 
    p_r.page_id = pg.id and
    wg.page_id = pg.id and 
    wg.DTYPE = 'YOUTUBE';
    
#d
	SELECT w.*
    FROM person p, developer d, website w, website_role w_r
    WHERE
    p.id = d.id and 
    w_r.role = 'owner' and 
    w_r.developer_id = d.id and 
    w_r.website_id = w.id and
    p.username = 'alice';

#e
	SELECT w.*
    FROM person p, developer d, website w, website_role w_r
    WHERE
    p.id = d.id and 
    w_r.role = 'admin' and 
    w_r.developer_id = d.id and 
    w_r.website_id = w.id and
    w.visits > 6000000 and
    p.username = 'charlie';
	
# Question 3
#a
	SELECT pg.*
    FROM page pg
    WHERE
    views = 
    (SELECT MAX(views) FROM page pg);

#b
	SELECT pg.*
    FROM page pg
    WHERE
    id = 234;	

#c 
	SELECT pg.*
    FROM page pg, page_role p_r
    WHERE
	p_r.page_id = pg.id and
    p_r.developer_id = 12 and
    p_r.role = 'editor';

#d
    SELECT SUM(pg.views) AS `TOTAL NUMBER OF PAGEVIEWS`
    FROM page pg, website w
    WHERE
    pg.website_id = w.id and 
    w.name = 'CNET';
    
#e
	SELECT AVG(pg.views) AS `AVERAGE NUMBER OF PAGEVIEWS`
    FROM page pg, website w
    WHERE
    pg.website_id = w.id and 
    w.name = 'Wikipedia';

# Question 4
#a
	SELECT wg.*
    FROM widget wg, page pg, website w
    WHERE
    w.name = 'CNET' and
    pg.website_id = w.id and
    pg.title = 'HOME' and
    wg.page_id = pg.id;
    
#b
	SELECT wg.*
    FROM widget wg, page pg, website w
    WHERE
    w.name = 'CNN' and
    pg.website_id = w.id and
    wg.page_id = pg.id and
    wg.DTYPE = 'YOUTUBE';
    
#c 
	SELECT wg.*
    FROM widget wg, page pg, page_role p_r
    WHERE
    p_r.developer_id = 12 and
    p_r.role = 'reviewer' and 
    p_r.page_id = pg.id and
    pg.id = wg.page_id and
    wg.DTYPE = 'IMAGE';
    
#d
	SELECT COUNT(*) AS `NUMBER OF WIDGETS IN WIKIPEDIA`
    FROM website w, page pg, widget wg
    WHERE
    w.name = 'Wikipedia' and
    pg.website_id = w.id and
    wg.page_id = pg.id;
    
# Question 5
#a 
	SELECT w.name 
    FROM website w, website_priviledge w_p
    WHERE
    w_p.developer_id = 23 and 
    w_p.priviledge = 'DELETE' and
    w_p.website_id = w.id;
    
#b
	SELECT pg.title 
    FROM page pg, page_priviledge p_p
    WHERE
    p_p.developer_id = 34 and 
    p_p.priviledge = 'CREATE' and
    p_p.page_id = pg.id;
