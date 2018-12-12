--Тип документа
CREATE TABLE IF NOT EXISTS Doc_type (
	id               INTEGER AUTO_INCREMENT (10000, 1) PRIMARY KEY,
	code             VARCHAR(10) ,
	name             VARCHAR(255)
);
COMMENT ON TABLE Doc_type IS 'Справочник: Тип документа';
CREATE UNIQUE INDEX IF NOT EXISTS doc_type_unique_code ON Doc_type (code);

--Страна
CREATE TABLE IF NOT EXISTS Country (
	id               INTEGER AUTO_INCREMENT (10000, 1) PRIMARY KEY,
	code             VARCHAR(10),
	name             VARCHAR(255)
);
COMMENT ON TABLE Country IS 'Справочник: Страна';
CREATE UNIQUE INDEX IF NOT EXISTS country_unique_code ON Country (code);

--Организация
CREATE TABLE IF NOT EXISTS Organization (
	id               INTEGER AUTO_INCREMENT (10000, 1) PRIMARY KEY,
	name             VARCHAR(255) NOT NULL,
	full_name        VARCHAR(255) NOT NULL,
	inn              VARCHAR(10) NOT NULL,
	kpp              VARCHAR(9) NOT NULL,
	address          VARCHAR(255) NOT NULL,
	phone            VARCHAR(20),
	is_active        BOOLEAN DEFAULT TRUE
);
COMMENT ON TABLE Organization IS 'Организация';
CREATE INDEX IF NOT EXISTS organization_name_index ON Organization (name);
CREATE UNIQUE INDEX IF NOT EXISTS organization_name_inn_unique_index ON Organization (name, inn);

--Офис
CREATE TABLE IF NOT EXISTS Office (
	id               INTEGER AUTO_INCREMENT (10000, 1) PRIMARY KEY ,
	name             VARCHAR(255) NOT NULL,
	address          VARCHAR(255) NOT NULL,
	phone            VARCHAR(20),
	is_active        BOOLEAN,
	organization_id  INTEGER,
	FOREIGN KEY (organization_id) REFERENCES organization (id) ON DELETE CASCADE
);
COMMENT ON TABLE Office IS 'Офис организации';
CREATE INDEX IF NOT EXISTS office_name_index ON Office (name);

--Документ, удостоверяющий личность
CREATE TABLE IF NOT EXISTS Document (
	id               INTEGER AUTO_INCREMENT (10000, 1) PRIMARY KEY,
	doc_type_id      INTEGER,
	doc_number       VARCHAR(20),
	issue_date       DATE,
	FOREIGN KEY (doc_type_id) REFERENCES Doc_type (id) ON DELETE SET NULL
);
COMMENT ON TABLE Document IS 'Документ, удостоверяющий личность';
CREATE INDEX IF NOT EXISTS document_number_index ON Document (doc_number);

--Пользователь
CREATE TABLE IF NOT EXISTS User (
	id					     INTEGER AUTO_INCREMENT (10000, 1) PRIMARY KEY,
	first_name			 VARCHAR(100) NOT NULL,
	second_name			 VARCHAR(100),
	middle_name			 VARCHAR(100),
	position			   VARCHAR(255) NOT NULL,
	phone				     VARCHAR(20),
  doc_id           INTEGER,
	country_id       INTEGER,
	is_identified    BOOLEAN NOT NULL,
	office_id			   INTEGER,
	FOREIGN KEY (doc_id) REFERENCES Document (id) ON DELETE SET NULL,
	FOREIGN KEY (country_id) REFERENCES Country (id) ON DELETE SET NULL,
	FOREIGN KEY (office_id) REFERENCES Office (id) ON DELETE SET NULL
);
COMMENT ON TABLE User IS 'Пользователь';
CREATE INDEX IF NOT EXISTS user_first_name_index ON User (first_name);