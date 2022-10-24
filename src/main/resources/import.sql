INSERT INTO utilisateurs (email, nom, prenom) VALUES ('e@mail.xom', 'mail', 'e');
INSERT INTO utilisateurs (email, nom, prenom) VALUES ('arrow@post.tom', 'post', 'arrow');
INSERT INTO utilisateurs (email, nom, prenom) VALUES ('borrow@book.lom', 'book', 'borrow');

INSERT INTO objets (titre, quantite, date_parution) VALUES ('cd1', 4, '2001-04-15');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('cd2', 0, '1965-07-02');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('cd3', 7, '1977-07-17');

INSERT INTO cds (id, artiste, duree, nombre_titres) VALUES (1, 'Lou', 120, 12);
INSERT INTO cds (id, artiste, duree, nombre_titres) VALUES (2, 'Hector Burn', 240, 25);
INSERT INTO cds (id, artiste, duree, nombre_titres) VALUES (3, 'Ken Plastic', 5, 2);

INSERT INTO objets (titre, quantite, date_parution) VALUES ('dvd1', 5, '2020-05-12');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('dvd2', 1, '1958-09-22');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('dvd3', 12, '2012-12-12');

INSERT INTO dvds (id, realisateur, duree, dvd_type) VALUES (4,'Martin Matin', 120.5, 'BLUE_RAY');
INSERT INTO dvds (id, realisateur, duree, dvd_type) VALUES (5,'Hector Burn', 75, 'NORMAL');
INSERT INTO dvds (id, realisateur, duree, dvd_type) VALUES (6,'Marlyne Bobine', 87, 'BLUE_RAY');

INSERT INTO objets (titre, quantite, date_parution) VALUES ('livre1', 1, '2002-03-17');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('livre2', 2, '1842-10-01');
INSERT INTO objets (titre, quantite, date_parution) VALUES ('livre3', 3, '2022-05-12');

INSERT INTO livres (id, auteur, numero_ISBN) VALUES (7,'Ronnie Anxious','123-4-5678-9101-1');
INSERT INTO livres (id, auteur, numero_ISBN) VALUES (8,'Barrabel Boubel','111-0-9876-5432-1');
INSERT INTO livres (id, auteur, numero_ISBN) VALUES (9,'Rechine DeLonesh','111-2-1039-4857-6');

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




