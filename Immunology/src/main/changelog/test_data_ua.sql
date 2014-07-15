INSERT INTO form VALUES(1, 'test form');
INSERT INTO medical_card_forms VALUES('Додаткова інформація', 1);
INSERT INTO panels(id, checked, name, place, form_id) VALUES(1, false, 'Генетична (вроджена) схильність до алергії', 1, 1);
INSERT INTO panels VALUES(2, false, 'Хворі на алергію родичі', 1, 1, 1);
INSERT INTO element VALUES(1, false, 'мати', 1, 2);
INSERT INTO element VALUES(2, false, 'батько', 2, 2);
INSERT INTO element VALUES(3, false, 'мати/батько', 3, 2);
INSERT INTO element VALUES(4, false, 'інші', 4, 2);
INSERT INTO element VALUES(5, false, 'брат/сестра', 5, 2);
INSERT INTO text_boxes VALUES('', 1);
INSERT INTO text_boxes VALUES('', 2);
INSERT INTO text_boxes VALUES('', 3);
INSERT INTO text_boxes VALUES('', 4);
INSERT INTO text_boxes VALUES('', 5);

INSERT INTO panels VALUES(3, false, 'Особливості анамнезу в дитячому віці', 1, 1, 1);
INSERT INTO element VALUES(6, false, 'Грудне вигодовування', 1, 3);
INSERT INTO dropdowns VALUES(0, '', 6);
INSERT INTO dropdown_values VALUES(6, 0, 'До 3 місяців');
INSERT INTO dropdown_values VALUES(6, 0, 'До 6 місяців');
INSERT INTO dropdown_values VALUES(6, 0, 'До 12 місяців');

INSERT INTO element VALUES(7, false, 'Наявність алергії в дитячому віці', 2, 3);
INSERT INTO dropdowns VALUES(0, '', 7);
INSERT INTO dropdown_values VALUES(7, 0, 'Так');
INSERT INTO dropdown_values VALUES(7, 0, 'Ні');

INSERT INTO panels VALUES(4, false, 'Умови проживання', 3, 1, 1);
INSERT INTO element VALUES(8, false, 'Важкість умов проживання', 1, 4);
INSERT INTO dropdowns VALUES(0, '', 8);
INSERT INTO dropdown_values VALUES(8, 0, '0');
INSERT INTO dropdown_values VALUES(8, 0, '1');
INSERT INTO dropdown_values VALUES(8, 0, '2');
INSERT INTO dropdown_values VALUES(8, 0, '3');
INSERT INTO dropdown_values VALUES(8, 0, '4');
INSERT INTO dropdown_values VALUES(8, 0, '5');

INSERT INTO users VALUES(1, 'John', 'Doy', 'user', 'Volodymyrovuch', '$2a$10$EzVF3davuFbb0.KmKJa4B.xZA.ax7QASX97gcnuq116DZ98UyQCn.');
INSERT INTO user_roles VALUES(1, 1);

INSERT INTO patient values(1, 'Lviv', 'Ukraine', '11/11/1992', 'Andrii', '231', 'Testovui', 'Volodymyrovych', 'Lvivska', 'male', 'Djerelna', 1);
INSERT INTO user_patient VALUES(1, 1);