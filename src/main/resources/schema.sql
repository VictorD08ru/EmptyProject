CREATE TABLE IF NOT EXISTS Docs (
	code				      INTEGER			PRIMARY KEY,
	name				      VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Countries (
	code				      INTEGER			PRIMARY KEY,
	name				      VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Organizations (
	id					      INTEGER			AUTO_INCREMENT (10000, 1) PRIMARY KEY ,
	name				      VARCHAR(255)	NOT NULL,
	full_name		      VARCHAR(255)	NOT NULL,
	inn					      VARCHAR(10)		NOT NULL,
	kpp					      VARCHAR(9)		NOT NULL,
	address			      VARCHAR(255)	NOT NULL,
	phone				      VARCHAR(20),
	is_active		      BOOLEAN 		DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS Offices (
	id					      INTEGER			  AUTO_INCREMENT (10000, 1) PRIMARY KEY ,
	name				      VARCHAR(255)	NOT NULL,
	address			      VARCHAR(255)	NOT NULL,
	phone				      VARCHAR(20),
	is_active		      BOOLEAN,
	organization_id		INTEGER,
	FOREIGN KEY (organization_id) REFERENCES organizations (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Users (
	id					      INTEGER			AUTO_INCREMENT (10000, 1) PRIMARY KEY ,
	first_name			  VARCHAR(100)	NOT NULL,
	second_name			  VARCHAR(100),
	middle_name			  VARCHAR(100),
	position			    VARCHAR(100)	NOT NULL,
	phone				      VARCHAR(20),
	doc_code			    INTEGER,
	doc_number			  VARCHAR(100),
	doc_date			    DATE,
	citizenship_code	INTEGER,
	is_identified		  BOOLEAN,
	FOREIGN KEY (doc_code) REFERENCES Docs (code) ON DELETE SET NULL,
	FOREIGN KEY (citizenship_code) REFERENCES Countries (code) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS Offices_Users (
	user_id				    INTEGER			NOT NULL,
	office_id			    INTEGER,
	CONSTRAINT user_office_idx UNIQUE (user_id),
	FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE,
	FOREIGN KEY (office_id) REFERENCES Offices (id) ON DELETE SET NULL
);