SET FOREIGN_KEY_CHECKS = 0;
DROP TABLES IF EXISTS `address`,`developer`,`DTYPE`,`page`,`page_priviledge`,`page_role`,`person`,`phone`,`priviledge`,`role`,`user`,`website`,`website_priviledge`,`website_role`,`widget`;
SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE `person` (
  `id` INT NOT NULL,
  `first_name` VARCHAR (45) NULL,
  `last_name` VARCHAR (45) NULL,
  `username` VARCHAR (45) NULL,
  `password` VARCHAR (45) NULL,
  `email` VARCHAR (45) NULL,
  `dob` DATE NULL,
   PRIMARY KEY (`id`));
   
CREATE TABLE `user` (
  `id` INT NOT NULL,
  `user_agreement` TINYINT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_person_generalization`
    FOREIGN KEY (`id`)
    REFERENCES `person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `developer` (
  `id` INT NOT NULL,
  `developer_key` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `developer_person_generalization`
    FOREIGN KEY (`id`)
    REFERENCES `person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `website` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `created` DATE NULL,
  `updated` DATE NULL,
  `visits` INT NULL,
  `developer_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `page` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `created` DATE NULL,
  `updated` DATE NULL,
  `views` INT NULL,
  `website_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `page_website_composition`
    FOREIGN KEY (`website_id`)
    REFERENCES `website` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE DTYPE (
 		name varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (name));
  
INSERT INTO DTYPE(name) values ('WIDGET');
INSERT INTO DTYPE(name) values ('HEADING');
INSERT INTO DTYPE(name) values ('HTML');
INSERT INTO DTYPE(name) values ('YOUTUBE');
INSERT INTO DTYPE(name) values ('IMAGE');

CREATE TABLE `widget` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `width` INT NULL,
  `height` INT NULL,
  `css_class` VARCHAR(45) NULL,
  `css_style` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `order` INT NULL,
  `DTYPE` VARCHAR(45) NULL,
  `size` INT NULL DEFAULT 2,
  `html` VARCHAR(45) NULL,
  `url` VARCHAR(45) NULL,
  `shareble` TINYINT NULL,
  `expandable` TINYINT NULL,
  `src` VARCHAR(45) NULL,
  `page_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `widget_generalization`
    FOREIGN KEY (`DTYPE`)
    REFERENCES `DTYPE` (`name`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
 CONSTRAINT `widget_page_composition`
  FOREIGN KEY (`page_id`)
  REFERENCES `page` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE);

CREATE TABLE `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street1` VARCHAR(45) NULL,
  `street2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  `primary` TINYINT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `address_person_composition`
    FOREIGN KEY (`person_id`)
    REFERENCES `person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `phone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(45) NULL,
  `primary` VARCHAR(45) NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `phone_person_composition`
    FOREIGN KEY (`person_id`)
    REFERENCES `person` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE priviledge (
 		name varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (name));
  
INSERT INTO priviledge(name) values ('create');
INSERT INTO priviledge(name) values ('read');
INSERT INTO priviledge(name) values ('update');
INSERT INTO priviledge(name) values ('delete');

CREATE TABLE role (
 		name varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (name));
  
INSERT INTO role(name) values ('owner');
INSERT INTO role(name) values ('admin');
INSERT INTO role(name) values ('writer');
INSERT INTO role(name) values ('editor');
INSERT INTO role(name) values ('reviewer');

CREATE TABLE `website_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `developer_id` INT NOT NULL,
  `website_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `websiterole_developer_association`
    FOREIGN KEY (`developer_id`)
    REFERENCES `developer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `websiterole_website_association`
    FOREIGN KEY (`website_id`)
    REFERENCES `website` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `websiterole_enumeration`
    FOREIGN KEY (`role`)
    REFERENCES `role` (`name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `page_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  `developer_id` INT NOT NULL,
  `page_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `pagerole_developer_association`
    FOREIGN KEY (`developer_id`)
    REFERENCES `developer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pagerole_page_association`
    FOREIGN KEY (`page_id`)
    REFERENCES `page` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pagerole_enumeration`
    FOREIGN KEY (`role`)
    REFERENCES `role` (`name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE website_priviledge (
  `id` INT NOT NULL AUTO_INCREMENT,
  `priviledge` VARCHAR(45) NOT NULL,
  `developer_id` INT NOT NULL,
  `website_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `websitepriviledge_developer_association`
    FOREIGN KEY (`developer_id`)
    REFERENCES `developer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `websitepriviledge_website_association`
    FOREIGN KEY (`website_id`)
    REFERENCES `website` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `websitepriviledge_enumeration`
    FOREIGN KEY (`priviledge`)
    REFERENCES `priviledge` (`name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `page_priviledge` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `priviledge` VARCHAR(45) NOT NULL,
  `developer_id` INT NOT NULL,
  `page_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `pagepriviledge_developer_association`
    FOREIGN KEY (`developer_id`)
    REFERENCES `developer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pagepriviledge_page_association`
    FOREIGN KEY (`page_id`)
    REFERENCES `page` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pagepriviledge_enumeration`
    FOREIGN KEY (`priviledge`)
    REFERENCES `priviledge` (`name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


