INSERT INTO users VALUES(1, 'John', 'Doy', 'user', 'Volodymyrovuch', '$2a$10$EzVF3davuFbb0.KmKJa4B.xZA.ax7QASX97gcnuq116DZ98UyQCn.');
INSERT INTO user_roles VALUES(1, 1);

INSERT INTO patient values(1, 'Lviv', 'Ukraine', '11-11-1992', 'Andrii', '231', 'Testovui', 'Volodymyrovych', 'Lvivska', 'male', 'Djerelna', 1);
INSERT INTO form VALUES(1, 'test form', 1);
INSERT INTO medical_forms VALUES('additional information', null, 1);
INSERT INTO element(element_id, checked, name, place) VALUES(1, false, 'panel1', 1);
INSERT INTO panels VALUES(1,1);
INSERT INTO element VALUES(2, false, 'text_box', 1, 1);
INSERT INTO text_boxes VALUES('teeeeeeext', 2);
INSERT INTO element VALUES(3, false, 'sub_panel', 2, 1);
INSERT INTO panels(element_id) VALUES(3);