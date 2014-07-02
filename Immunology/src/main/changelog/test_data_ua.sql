INSERT INTO users VALUES(1, 'John', 'Doy', 'user', 'Volodymyrovuch', '$2a$10$EzVF3davuFbb0.KmKJa4B.xZA.ax7QASX97gcnuq116DZ98UyQCn.');
INSERT INTO user_roles VALUES(1, 1);

INSERT INTO patient values(1, 'Lviv', 'Ukraine', '11/11/1992', 'Andrii', '231', 'Testovui', 'Volodymyrovych', 'Lvivska', 'male', 'Djerelna');
INSERT INTO user_patient VALUES(1, 1);

INSERT INTO form VALUES(1, 'test form');
INSERT INTO medical_card_forms VALUES('Додаткова інформація', '11/11/2001', 1, 1);
INSERT INTO element(element_id, checked, name, place) VALUES(1, false, 'Генетична (вроджена) схильність до алергії', 1);
INSERT INTO panels VALUES(1,1);
INSERT INTO element VALUES(2, false, 'Хворі на алергію родичі', 1, 1);
INSERT INTO panels(element_id) VALUES(2);
INSERT INTO element VALUES(3, false, 'мати', 1, 2);
INSERT INTO element VALUES(4, false, 'батько', 2, 2);
INSERT INTO element VALUES(5, false, 'мати/батько', 3, 2);
INSERT INTO element VALUES(6, false, 'інші', 4, 2);
INSERT INTO element VALUES(7, false, 'брат/сестра', 5, 2);
INSERT INTO text_boxes VALUES('', 3);
INSERT INTO text_boxes VALUES('', 4);
INSERT INTO text_boxes VALUES('', 5);
INSERT INTO text_boxes VALUES('', 6);
INSERT INTO text_boxes VALUES('', 7);

INSERT INTO element(element_id, checked, name, place) VALUES(8, false, 'Особливості анамнезу в дитячому віці', 2);
INSERT INTO panels VALUES(8,1);
INSERT INTO element VALUES(9, false, 'Грудне вигодовування', 1, 8);
INSERT INTO dropdowns VALUES(0, '', 9);
INSERT INTO dropdown_values VALUES(9, 0, 'До 3 місяців');
INSERT INTO dropdown_values VALUES(9, 0, 'До 6 місяців');
INSERT INTO dropdown_values VALUES(9, 0, 'До 12 місяців');

INSERT INTO element VALUES(10, false, 'Наявність алергії в дитячому віці', 2, 8);
INSERT INTO dropdowns VALUES(0, '', 10);
INSERT INTO dropdown_values VALUES(10, 0, 'Так');
INSERT INTO dropdown_values VALUES(10, 0, 'Ні');

INSERT INTO element(element_id, checked, name, place) VALUES(11, false, 'Умови проживання', 3);
INSERT INTO panels VALUES(11,1);
INSERT INTO element VALUES(12, false, 'Важкість умов проживання', 1, 11);
INSERT INTO dropdowns VALUES(0, '', 12);
INSERT INTO dropdown_values VALUES(12, 0, '0');
INSERT INTO dropdown_values VALUES(12, 0, '1');
INSERT INTO dropdown_values VALUES(12, 0, '2');
INSERT INTO dropdown_values VALUES(12, 0, '3');
INSERT INTO dropdown_values VALUES(12, 0, '4');
INSERT INTO dropdown_values VALUES(12, 0, '5');