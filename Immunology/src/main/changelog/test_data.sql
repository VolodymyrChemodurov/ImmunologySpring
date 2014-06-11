INSERT INTO users VALUES(1, 'John', 'Doy', 'user', 'Volodymyrovuch', '$2a$10$EzVF3davuFbb0.KmKJa4B.xZA.ax7QASX97gcnuq116DZ98UyQCn.');
INSERT INTO user_roles VALUES(1, 1);

INSERT INTO patient values(1, 'Lviv', 'Ukraine', '11/11/1992', 'Andrii', '231', 'Testovui', 'Volodymyrovych', 'Lvivska', 'male', 'Djerelna', 1);
INSERT INTO form VALUES(1, 'test form', 1);
INSERT INTO medical_forms VALUES('additional information', '11/11/2001', 1);
INSERT INTO element(element_id, checked, name, place) VALUES(1, false, 'Genetic (congenital) predisposition to allergies', 1);
INSERT INTO panels VALUES(1,1);
INSERT INTO element VALUES(2, false, 'Patients with allergic relatives', 1, 1);
INSERT INTO panels(element_id) VALUES(2);
INSERT INTO element VALUES(3, false, 'Mother', 1, 2);
INSERT INTO element VALUES(4, false, 'Father', 2, 2);
INSERT INTO element VALUES(5, false, 'Mother/Father', 3, 2);
INSERT INTO element VALUES(6, false, 'Other', 4, 2);
INSERT INTO element VALUES(7, false, 'Brother/Sister', 5, 2);
INSERT INTO text_boxes VALUES('', 3);
INSERT INTO text_boxes VALUES('', 4);
INSERT INTO text_boxes VALUES('', 5);
INSERT INTO text_boxes VALUES('', 6);
INSERT INTO text_boxes VALUES('', 7);

INSERT INTO element(element_id, checked, name, place) VALUES(8, false, 'Features a history of childhood', 2);
INSERT INTO panels VALUES(8,1);
INSERT INTO element VALUES(9, false, 'Breastfeeding', 1, 8);
INSERT INTO dropdowns VALUES(0, '', 9);
INSERT INTO dropdown_values VALUES(9, 0, 'Less than 3 months');
INSERT INTO dropdown_values VALUES(9, 0, 'Less than 6 months');
INSERT INTO dropdown_values VALUES(9, 0, 'Less than 12 months');

INSERT INTO element VALUES(10, false, 'Having allergies in childhood', 2, 8);
INSERT INTO dropdowns VALUES(0, '', 10);
INSERT INTO dropdown_values VALUES(10, 0, 'Yes');
INSERT INTO dropdown_values VALUES(10, 0, 'No');

INSERT INTO element(element_id, checked, name, place) VALUES(11, false, 'Accommodation', 3);
INSERT INTO panels VALUES(11,1);
INSERT INTO element VALUES(12, false, 'The severity of living conditions', 1, 11);
INSERT INTO dropdowns VALUES(0, '', 12);
INSERT INTO dropdown_values VALUES(12, 0, '0');
INSERT INTO dropdown_values VALUES(12, 0, '1');
INSERT INTO dropdown_values VALUES(12, 0, '2');
INSERT INTO dropdown_values VALUES(12, 0, '3');
INSERT INTO dropdown_values VALUES(12, 0, '4');
INSERT INTO dropdown_values VALUES(12, 0, '5');
