SET SQL_SAFE_UPDATES=0;

# Question 1
UPDATE phone
SET phone = '333-444-5555'
WHERE `primary` = TRUE;

# Question 2
UPDATE widget wg, (SELECT page_id FROM widget WHERE name = 'head345') pg_id
SET wg.`order` = 
(CASE wg.`name`
 WHEN 'head345' THEN 3
 ELSE wg.`order` - 1
 END)
WHERE 
wg.page_id = pg_id.page_id;

# Question 3
UPDATE page pg, website w
SET pg.title = CONCAT('CNET-',pg.title)
WHERE
w.name = 'CNET' and
pg.website_id = w.id;

# Question 4
SELECT @bob_origin :=  p_r.role 
FROM page_role p_r, website w, page pg
WHERE
w.name = 'CNET' and
pg.website_id = w.id and
pg.title = 'CNET-Home' and
p_r.page_id = pg.id and
p_r.developer_id = 23;

SELECT @charlie_origin := p_r.role
FROM page_role p_r, website w, page pg
WHERE
w.name = 'CNET' and
pg.website_id = w.id and
pg.title = 'CNET-Home' and
p_r.page_id = pg.id and
p_r.developer_id = 34;

UPDATE page_role p_r,website w, page pg
SET p_r.role =  @charlie_origin
WHERE
w.name = 'CNET' and 
pg.website_id = w.id and
pg.title = 'CNET-Home' and 
p_r.page_id = pg.id and
p_r.developer_id = 23;

UPDATE page_role p_r,website w, page pg
SET p_r.role =  @bob_origin
WHERE
w.name = 'CNET' and 
pg.website_id = w.id and
pg.title = 'CNET-Home' and 
p_r.page_id = pg.id and
p_r.developer_id = 34;

