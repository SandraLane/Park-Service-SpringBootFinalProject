DROP TABLE IF EXISTS park_ranger;
DROP TABLE IF EXISTS camper;
DROP TABLE IF EXISTS park_service;
DROP TABLE IF EXISTS park_camper;


CREATE TABLE park_service (
  park_service_id INT AUTO_INCREMENT NOT NULL,
  park_service_name VARCHAR(128) NOT NULL,
  park_service_address VARCHAR(128),
  park_service_city VARCHAR(64),
  park_service_state VARCHAR(64),
  park_service_zip INT,
  park_service_phone INT,
  park_service_current_events VARCHAR(128),
  PRIMARY KEY (park_service_id)
);

CREATE TABLE camper (
camper_id INT AUTO_INCREMENT NOT NULL,
camper_first_name VARCHAR(64) NOT NULL,
camper_last_name VARCHAR(64) NOT NULL,
camper_email VARCHAR(64),
PRIMARY KEY (camper_id)
);

CREATE TABLE parkRranger (
park_ranger_id INT AUTO_INCREMENT NOT NULL,
park_ranger_first_name VARCHAR(64),
park_ranger_last_name VARCHAR(64),
park_ranger_phone INT,
park_ranger_job_title VARCHAR(64),
PRIMARY KEY (park_ranger_id),
FOREIGN KEY (park_service_id)
	REFERENCES park_service (park_service_id)
	ON DELETE CASCADE
);
