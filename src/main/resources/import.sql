--BEACH INSERTS
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(1, 'Copacabana', -22971000, -43182000, 'LOW', TO_DATE('2024-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(2, 'Ipanema', -22984000, -43205000, 'MEDIUM', TO_DATE('2024-01-02', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(3, 'Leblon', -22987000, -43222000, 'HIGH', TO_DATE('2024-01-03', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(4, 'Praia do Forte', -12576000, -38682000, 'LOW', TO_DATE('2024-01-04', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(5, 'Porto de Galinhas', -8514000, -35009000, 'MEDIUM', TO_DATE('2024-01-05', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(6, 'Praia da Barra', -22985000, -43185000, 'LOW', TO_DATE('2024-01-06', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(7, 'Praia de Botafogo', -22970000, -43170000, 'MEDIUM', TO_DATE('2024-01-07', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(8, 'Praia Vermelha', -22968000, -43169000, 'HIGH', TO_DATE('2024-01-08', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(9, 'Praia de Grumari', -22990000, -43190000, 'LOW', TO_DATE('2024-01-09', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_BEACH (beach_id, name, latitude, longitude, pollution_level, created_at, updated_at) VALUES
(10, 'Praia da Reserva', -22995000, -43195000, 'MEDIUM', TO_DATE('2024-01-10', 'YYYY-MM-DD'), NULL);

--USER INSERTS
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(1, 'John Doe', 'john.doe@example.com', 'password123', 'CITIZEN', TO_DATE('2024-01-01', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(2, 'Jane Smith', 'jane.smith@example.com', 'password456', 'VOLUNTEER', TO_DATE('2024-01-02', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(3, 'Alice Johnson', 'alice.johnson@example.com', 'password789', 'CITIZEN', TO_DATE('2024-01-03', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(4, 'Bob Brown', 'bob.brown@example.com', 'password101', 'CITIZEN', TO_DATE('2024-01-04', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(5, 'Charlie Davis', 'charlie.davis@example.com', 'password102', 'VOLUNTEER', TO_DATE('2024-01-05', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(6, 'David Harris', 'david.harris@example.com', 'password103', 'VOLUNTEER', TO_DATE('2024-01-06', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(7, 'Eva Jackson', 'eva.jackson@example.com', 'password104', 'CITIZEN', TO_DATE('2024-01-07', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(8, 'Franklin Lee', 'franklin.lee@example.com', 'password105', 'VOLUNTEER', TO_DATE('2024-01-08', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(9, 'Grace Moore', 'grace.moore@example.com', 'password106', 'CITIZEN', TO_DATE('2024-01-09', 'YYYY-MM-DD'), NULL);
INSERT INTO GS_2TDSS_USER (user_id, name, email, password, user_type, created_at, updated_at) VALUES
(10, 'Henry Nelson', 'henry.nelson@example.com', 'password107', 'VOLUNTEER', TO_DATE('2024-01-10', 'YYYY-MM-DD'), NULL);

--EVENT INSERTS
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(1, 'Beach Cleanup', TO_TIMESTAMP('2024-06-15 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Join us for a beach cleanup event.', 'PLANNED', TO_DATE('2024-01-01', 'YYYY-MM-DD'), NULL, 1, 1);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(2, 'Surf Competition', TO_TIMESTAMP('2024-07-20 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Annual surf competition.', 'PLANNED', TO_DATE('2024-01-02', 'YYYY-MM-DD'), NULL, 2, 2);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(3, 'Beach Volleyball', TO_TIMESTAMP('2024-08-10 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Friendly beach volleyball tournament.', 'PLANNED', TO_DATE('2024-01-03', 'YYYY-MM-DD'), NULL, 3, 3);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(4, 'Sandcastle Contest', TO_TIMESTAMP('2024-09-05 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Build the best sandcastle.', 'PLANNED', TO_DATE('2024-01-04', 'YYYY-MM-DD'), NULL, 4, 4);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(5, 'Yoga on the Beach', TO_TIMESTAMP('2024-10-01 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Morning yoga session.', 'PLANNED', TO_DATE('2024-01-05', 'YYYY-MM-DD'), NULL, 5, 5);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(6, 'Beach Cleanup - Barra', TO_TIMESTAMP('2024-07-01 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Community beach cleanup at Barra', 'PLANNED', TO_DATE('2024-01-06', 'YYYY-MM-DD'), NULL, 1, 6);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(7, 'Recycling Workshop - Botafogo', TO_TIMESTAMP('2024-07-02 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Recycling workshop at Botafogo beach', 'PLANNED', TO_DATE('2024-01-07', 'YYYY-MM-DD'), NULL, 2, 7);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(8, 'Marine Life Protection - Vermelha', TO_TIMESTAMP('2024-07-03 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Marine life protection event at Vermelha beach', 'PLANNED', TO_DATE('2024-01-08', 'YYYY-MM-DD'), NULL, 3, 8);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(9, 'Awareness Campaign - Grumari', TO_TIMESTAMP('2024-07-04 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Environmental awareness campaign at Grumari', 'PLANNED', TO_DATE('2024-01-09', 'YYYY-MM-DD'), NULL, 4, 9);
INSERT INTO GS_2TDSS_EVENT (event_id, name, event_date, description, status, created_at, updated_at, user_id, beach_id) VALUES
(10, 'Beach Art Festival - Reserva', TO_TIMESTAMP('2024-07-05 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Art festival at Reserva beach', 'PLANNED', TO_DATE('2024-01-10', 'YYYY-MM-DD'), NULL, 5, 10);

--PARTICIPATION INSERTS
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(1, TO_DATE('2024-06-01', 'YYYY-MM-DD'), TO_DATE('2024-01-01', 'YYYY-MM-DD'), 1, 1);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(2, TO_DATE('2024-06-02', 'YYYY-MM-DD'), TO_DATE('2024-01-02', 'YYYY-MM-DD'), 2, 2);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(3, TO_DATE('2024-06-03', 'YYYY-MM-DD'), TO_DATE('2024-01-03', 'YYYY-MM-DD'), 3, 3);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(4, TO_DATE('2024-06-04', 'YYYY-MM-DD'), TO_DATE('2024-01-04', 'YYYY-MM-DD'), 4, 4);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(5, TO_DATE('2024-06-05', 'YYYY-MM-DD'), TO_DATE('2024-01-05', 'YYYY-MM-DD'), 5, 5);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(6, TO_DATE('2024-06-06', 'YYYY-MM-DD'), TO_DATE('2024-01-06', 'YYYY-MM-DD'), 6, 6);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(7, TO_DATE('2024-06-07', 'YYYY-MM-DD'), TO_DATE('2024-01-07', 'YYYY-MM-DD'), 7, 7);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(8, TO_DATE('2024-06-08', 'YYYY-MM-DD'), TO_DATE('2024-01-08', 'YYYY-MM-DD'), 8, 8);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(9, TO_DATE('2024-06-09', 'YYYY-MM-DD'), TO_DATE('2024-01-09', 'YYYY-MM-DD'), 9, 9);
INSERT INTO GS_2TDSS_PARTICIPATION (participation_id, participarion_date, created_at, user_id, event_id) VALUES
(10, TO_DATE('2024-06-10', 'YYYY-MM-DD'), TO_DATE('2024-01-10', 'YYYY-MM-DD'), 10, 10);

--PHOTO INSERTS
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(1, 'http://example.com/photo1.jpg', 'PLASTIC', TO_DATE('2024-01-01', 'YYYY-MM-DD'), 1, 1);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(2, 'http://example.com/photo2.jpg', 'OIL', TO_DATE('2024-01-02', 'YYYY-MM-DD'), 2, 2);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(3, 'http://example.com/photo3.jpg', 'MARINE_PLANTS', TO_DATE('2024-01-03', 'YYYY-MM-DD'), 3, 3);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(4, 'http://example.com/photo4.jpg', 'MARINE_LIFE', TO_DATE('2024-01-04', 'YYYY-MM-DD'), 4, 4);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(5, 'http://example.com/photo5.jpg', 'ORGANIC_WASTE', TO_DATE('2024-01-05', 'YYYY-MM-DD'), 5, 5);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(6, 'http://example.com/photo6.jpg', 'CONSTRUCTION_DEBRIS', TO_DATE('2024-01-06', 'YYYY-MM-DD'), 6, 6);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(7, 'http://example.com/photo7.jpg', 'OTHER', TO_DATE('2024-01-07', 'YYYY-MM-DD'), 7, 7);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(8, 'http://example.com/photo8.jpg', 'PLASTIC', TO_DATE('2024-01-08', 'YYYY-MM-DD'), 8, 8);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(9, 'http://example.com/photo9.jpg', 'OIL', TO_DATE('2024-01-09', 'YYYY-MM-DD'), 9, 9);
INSERT INTO GS_2TDSS_PHOTO (photo_id, url, classification, uploaded_date, user_id, beach_id) VALUES
(10, 'http://example.com/photo10.jpg', 'MARINE_LIFE', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 10, 10);

