-- Script de création pour MySQL de la base EmplDept
--
-- Encodage UTF-8
--
-- Peter DAEHNE, 11.02.2017
--
-- Base de données: EmplDept
--
DROP DATABASE IF EXISTS EmplDept;
CREATE DATABASE EmplDept;
USE EmplDept;

-- Table Fonction
DROP TABLE IF EXISTS Fonction;
CREATE TABLE Fonction
(
  NoFonc INT AUTO_INCREMENT NOT NULL COMMENT 'No de fonction',
  NomFonc VARCHAR(50) COMMENT 'Libellé de la fonction',
  PRIMARY KEY (NoFonc)
);
INSERT INTO Fonction (NoFonc, NomFonc) VALUES (1, 'Président');
INSERT INTO Fonction (NoFonc, NomFonc) VALUES (2, 'Directeur');
INSERT INTO Fonction (NoFonc, NomFonc) VALUES (3, 'Analyste');
INSERT INTO Fonction (NoFonc, NomFonc) VALUES (4, 'Secrétaire');
INSERT INTO Fonction (NoFonc, NomFonc) VALUES (5, 'Vendeur');

-- Table Lieu
DROP TABLE IF EXISTS Lieu;
CREATE TABLE Lieu
(
  NoLieu INT AUTO_INCREMENT NOT NULL COMMENT 'Numéro du lieu',
  NomLieu VARCHAR(50) COMMENT 'Nom du lieu',
  PRIMARY KEY (NoLieu)
);
INSERT INTO Lieu (NoLieu, NomLieu) VALUES (1, 'Lausanne');
INSERT INTO Lieu (NoLieu, NomLieu) VALUES (2, 'Yverdon');
INSERT INTO Lieu (NoLieu, NomLieu) VALUES (3, 'Genève');
INSERT INTO Lieu (NoLieu, NomLieu) VALUES (4, 'Zurich');

-- Table Departement
DROP TABLE IF EXISTS Departement;
CREATE TABLE Departement
(
  NoDept INT AUTO_INCREMENT NOT NULL COMMENT 'Numéro du département',
  NomDept VARCHAR(14) COMMENT 'Nom du département',
  NoLieu INT COMMENT 'Lieu du département',
  PRIMARY KEY (NoDept),
  FOREIGN KEY (NoLieu) REFERENCES Lieu (NoLieu)
);
INSERT INTO Departement (NoDept, NomDept, NoLieu) VALUES (1, 'Comptabilité', 1);
INSERT INTO Departement (NoDept, NomDept, NoLieu) VALUES (2, 'Recherche', 2);
INSERT INTO Departement (NoDept, NomDept, NoLieu) VALUES (3, 'Ventes', 3);
INSERT INTO Departement (NoDept, NomDept, NoLieu) VALUES (4, 'Opérations', 4);

-- Table Employe
DROP TABLE IF EXISTS Employe;
CREATE TABLE Employe
(
  NoEmpl INT AUTO_INCREMENT NOT NULL COMMENT 'Numéro d''employé',
  NomEmpl VARCHAR(50) COMMENT 'Nom de l''employé',
  PrenomEmpl VARCHAR(30) COMMENT 'Prénom de l''employé',
  NoFonc INT COMMENT 'Numéro de la fonction',
  DateEmpl DATE COMMENT 'Date d''entrée dans l''entreprise',
  NoChef INT COMMENT 'Numéro de l''employé qui est le chef',
  NoDept INT COMMENT 'Numéro du département',
  PRIMARY KEY (NoEmpl),
  FOREIGN KEY (NoFonc) REFERENCES Fonction (NoFonc),
  FOREIGN KEY (NoDept) REFERENCES Departement (NoDept)
);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (1, 'SIMON', 'Pierre', 4, '1980-12-17', 11, 2);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (2, 'ANDREY', 'Charles', 5, '1981-02-20', 6, 3);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (3, 'WYSS', 'Jack', 5, '1981-02-22', 6, 3);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (4, 'JAQUET', 'Jean-Pierre', 2, '1981-04-02', 1, 2);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (5, 'MARTINI', 'Gérald', 5, '1981-09-28', 6, 3);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (6, 'BAGNOUD', 'Jean-François', 2, '1981-05-01', 3, 3);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (7, 'COLLET', 'Edith', 2, '1981-06-09', 3, 1);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (8, 'THEVOZ', 'Jules', 5, '1981-09-08', 6, 3);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (9, 'AUBRY', 'Charlotte', 4, '2000-03-26', 11, 2);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (10, 'JATON', 'Alexandra', 4, '1981-12-03', 6, 3);
INSERT INTO Employe (NoEmpl, NomEmpl, PrenomEmpl, NoFonc, DateEmpl, NoChef, NoDept) VALUES (11, 'FAVRE', 'Jean-Luc', 3, '1981-12-03', 4, 2);
