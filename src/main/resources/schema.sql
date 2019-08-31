CREATE TABLE employee (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
);

CREATE TABLE parkingboy (
  parkingBoyID varchar(100) PRIMARY KEY,
  parkingBoyName VARCHAR(100) NOT NULL
);

CREATE TABLE parkinglot (
  parkingLotID VARCHAR(100) PRIMARY KEY,
  capacity INTEGER NOT NULL,
  availablePositionCount INTEGER NOT NULL,
  parkingBoyID VARCHAR(100) NOT NULL
);
