INSERT INTO utilisateurs (email, nom, prenom) VALUES ('bluelion@voltron.com', 'Alvarez', 'Lance');
INSERT INTO utilisateurs (email, nom, prenom) VALUES ('pinkarrow@dnd.alt', 'Castle', 'Allura');
INSERT INTO utilisateurs (email, nom, prenom) VALUES ('greengremlins@book.lom', 'Guderson', 'Pidge');

INSERT INTO objets (titre, quantite, date_parution) VALUES ('Kid Krow', 2, '2020-03-20');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('No Pads, No Helmets...Just Balls', 0, '2002-03-19');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('Barbara chante Jacques Brel', 1, '1961-01-17');

INSERT INTO cds (id, artiste, duree, nombre_titres) VALUES (1, 'Conan Gray', 34, 12);
INSERT INTO cds (id, artiste, duree, nombre_titres) VALUES (2, 'Simple Plan', 40, 12);
INSERT INTO cds (id, artiste, duree, nombre_titres) VALUES (3, 'Barbara', 20, 9);

INSERT INTO objets (titre, quantite, date_parution) VALUES ('La Momie', 5, '1999-05-12');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('Voyage au centre de la Terre', 1, '2008-09-22');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('La Fontaine', 6, '2006-12-12');

INSERT INTO dvds (id, realisateur, duree, dvd_type) VALUES (4,'Stephen Sommers', 125, 'BLUE_RAY');
INSERT INTO dvds (id, realisateur, duree, dvd_type) VALUES (5,'Eric Brevig', 92, 'NORMAL');
INSERT INTO dvds (id, realisateur, duree, dvd_type) VALUES (6,'Darren Aronofsky', 96, 'BLUE_RAY');

INSERT INTO objets (titre, quantite, date_parution) VALUES ('De bons presages', 4, '1990-05-01');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('Des fleurs pour Algernon', 2, '1966-03-01');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('Le Livre sans nom', 3, '2006-07-08');

INSERT INTO livres (id, auteur, numero_ISBN) VALUES (7,'Terry Pratchett & Neil Gaiman','2-277-23892-9');
INSERT INTO livres (id, auteur, numero_ISBN) VALUES (8,'Daniel Keyes','0-15-131510-8');
INSERT INTO livres (id, auteur, numero_ISBN) VALUES (9,'Anonyme','978-2-35584-043-2');

INSERT INTO emprunts (date_emprunt, date_retour, utilisateur_id) VALUES ('2021-05-30', '2021-06-12', 1);
INSERT INTO emprunts (date_emprunt, date_retour, utilisateur_id) VALUES ('2021-12-15', '2022-01-05', 3);
INSERT INTO emprunts (date_emprunt, date_retour, utilisateur_id) VALUES ('2022-09-05', '2022-09-30', 2);


INSERT INTO objets_emprunter (emprunt_id, objet_id) VALUES(2, 4);
INSERT INTO objets_emprunter (emprunt_id, objet_id) VALUES(2, 1);
INSERT INTO objets_emprunter (emprunt_id, objet_id) VALUES(2, 6);

INSERT INTO objets_emprunter (emprunt_id, objet_id) VALUES(3, 8);
INSERT INTO objets_emprunter (emprunt_id, objet_id) VALUES(3, 9);
INSERT INTO objets_emprunter (emprunt_id, objet_id) VALUES(3, 7);
INSERT INTO objets_emprunter (emprunt_id, objet_id) VALUES(1, 6);




