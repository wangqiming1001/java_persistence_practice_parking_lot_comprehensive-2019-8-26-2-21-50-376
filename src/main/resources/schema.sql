CREATE TABLE employee (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
);

CREATE TABLE parkingboy (
  parkingboy_id varchar(64) PRIMARY KEY,
  parkingboy_name VARCHAR(64) NOT NULL,
);

CREATE TABLE parkinglot (
  parkinglot_id VARCHAR(64) PRIMARY KEY,
  capacity INTEGER NOT NULL,
  available_position_count INTEGER NOT NULL,
  parkinglot_id VARCHAR(64) NOT NULL,
);
