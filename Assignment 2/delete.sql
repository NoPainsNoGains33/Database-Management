SET SQL_SAFE_UPDATES=0;
# Question 1
DELETE address.* FROM 
address, person
WHERE
person.username = 'alice' and
address.person_id = person.id and
address.primary = true;

# Question 2
SELECT @MAX_ORDER:= MAX(widget.order)
FROM widget, page
WHERE page.title = 'Contact' and
	  widget.page_id = page.id;

DELETE widget.* FROM
widget, page
WHERE
page.title = 'Contact' and 
widget.page_id = page.id and
widget.order = @MAX_ORDER;

# Question 3
SELECT @LAST_UPDATED := MAX(pg.updated) 
FROM page pg, website w
WHERE
w.name = 'Wikipedia' and
pg.website_id = w.id;

DELETE page.* 
FROM page, website
WHERE 
page.updated = @LAST_UPDATED and
website.name = 'Wikipedia' and 
page.id = website.id;

# Question 4
DELETE 
FROM website
WHERE website.name = 'CNET';


