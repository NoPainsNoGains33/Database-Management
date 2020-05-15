SET SQL_SAFE_UPDATES=0;
DELETE FROM person;
DELETE FROM developer;
DELETE FROM user;
DELETE FROM website;
DELETE FROM website_role;
DELETE FROM page;
DELETE FROM page_role;
DELETE FROM widget;
DELETE FROM phone;
DELETE FROM address;
SET SQL_SAFE_UPDATES=1;

# Question 1
INSERT INTO 
	person (`id`, `username`, `password`, `first_name`, `last_name`, `email`)
VALUES
	(12, 'alice', 'alice', 'Alice', 'Wonder', 'alice@wonder.com'),
    (23, 'bob', 'bob', 'Bob', 'Marley', 'bob@marley.com'),
    (34, 'charlie', 'charlie', 'Charles', 'Garcia', 'chuch@garcia.com'),
    (45, 'dan', 'dan', 'Dan', 'Martin', 'dan@martin.com'),
    (56, 'ed', 'ed', 'Ed', 'Karaz', 'ed@kar.com');

INSERT INTO
	developer (`id`, `developer_key`)
VALUES
	(12, '4321rewq'),
    (23, '5432trew'),
    (34, '6543ytre');

INSERT INTO
	user (`id`)
VALUES
	(45),
    (56);

# Question 2
INSERT INTO 
	website (`id`, `name`, `description`, `created`, `updated`, `visits`)
VALUES
	(123, 'Facebook', 'an online social media and social networking service', curdate(), curdate(), 1234234),
	(234, 'Twitter', 'an online news and social networking service', curdate(), curdate(), 4321543),
	(345, 'Wikipedia', 'a free online encyclopedia', curdate(), curdate(), 3456654),
	(456, 'CNN', 'an American basic cable and satellite television news channel', curdate(), curdate(), 6543345),
	(567, 'CNET', 'an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics', curdate(), curdate(), 5433455),
	(678, 'Gizmodo', 'a design, technology, science and science fiction website that also writes articles on politics', curdate(), curdate(), 4322345);
    
INSERT INTO 
	website_role (`role`, `developer_id`, `website_id`)
VALUES
	('owner', 12, 123),
    ('owner', 23, 234),
    ('owner', 34, 345),
    ('owner', 12, 456),
    ('owner', 23, 567),
    ('owner', 34, 678),
    ('editor', 23, 123),
    ('editor', 34, 234),
    ('editor', 12, 345),
    ('editor', 23, 456),
    ('editor', 34, 567),
    ('editor', 12, 678),
    ('admin', 34, 123),
    ('admin', 12, 234),
    ('admin', 23, 345),
    ('admin', 34, 456),
    ('admin', 12, 567),
    ('admin', 23, 678);

# Question 3
INSERT INTO
	page (`id`, `title`, `description`, `website_id`, `created`, `updated`, `views`)
VALUES
	(123, 'Home', 'Landing page', 567, '2020-01-06', curdate(), 123434),
	(234, 'About', 'Website description', 678, '2020-01-06', curdate(), 234545),
	(345, 'Contact', 'Addresses, phones, and contact info', 345, '2020-01-06', curdate(), 345656),
	(456, 'Preferences', 'Where users can configure their preferences', 456, '2020-01-06', curdate(), 456776),
	(567, 'Profile', 'Users can configure their personal information', 567, '2020-01-06', curdate(), 567878);

 
    
INSERT INTO
	page_role (`role`, `developer_id`, `page_id`)
VALUES
	('editor', 12, 123),
    ('editor', 23, 234),
    ('editor', 34, 345),
    ('editor', 12, 456),
    ('editor', 23, 567),
    ('reviewer', 23, 123),
    ('reviewer', 34, 234),
    ('reviewer', 12, 345),
    ('reviewer', 23, 456),
    ('reviewer', 34, 567),
    ('writer', 34, 123),
    ('writer', 12, 234),
    ('writer', 23, 345),
    ('writer', 34, 456),
    ('writer', 12, 567);
    
# Question 4
INSERT INTO 
	widget (`id`, `name`, `DTYPE`, `text`, `order`, `width`, `height`, `url`, `page_id`)
VALUES
	(123, 'head123', 'HEADING', 'Welcome', 0, NULL, NULL, NULL, 123),
    (234, 'post234', 'HTML', '<p>Lorem</p>', 0, NULL, NULL, NULL, 234),
    (345, 'head345', 'HEADING', 'Hi', 1, NULL, NULL, NULL, 345),
    (456, 'intro456', 'HTML', '<h1>Hi</h1>', 2, NULL, NULL, NULL, 345),
    (567, 'image345', 'IMAGE', NULL, 3, 50, 100, '/img/567.png', 345),
    (678, 'video456', 'YOUTUBE', NULL, 0, 400, 300, 'https://youtu.be/h6 7VX51QXiQ', 456);

# Question 5
INSERT INTO 
	phone (`person_id`, `phone`, `primary`)
VALUES
	(12, '123-234-3456', TRUE),
	(12, '234-345-4566', FALSE),
	(23, '345-456-5677', TRUE),
	(34, '321-432-5435', TRUE),
	(34, '432-432-5433', FALSE),
	(34, '543-543-6544', FALSE);

INSERT INTO 
	address (`person_id`,`street1`,`city`, `zip`,`primary`)
VALUES
	(12, '123 Adam St.', 'Alton', '01234', TRUE),
	(12, '234 Birch St.', 'Boston', '02345', FALSE),
	(23, '345 Charles St.', 'Chelms', '03455', TRUE),
	(23, '456 Down St.', 'Dalton', '04566', FALSE),
	(23, '543 East St.', 'Everett', '01112', FALSE),
	(34, '654 Frank St.', 'Foulton', '04322', TRUE);




    