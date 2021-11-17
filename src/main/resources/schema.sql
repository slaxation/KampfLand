 CREATE TABLE IF NOT EXISTS obchod(
  obchod_id SERIAL PRIMARY KEY,
  nazov_obchodu VARCHAR(255)

);
 CREATE TABLE IF NOT EXISTS prevadzka (
  prev_id SERIAL PRIMARY KEY,
  adresa VARCHAR(255) NOT NULL,
  otv_hodiny TIME WITHOUT TIME ZONE DEFAULT '00:00:00',
  zatv_hodiny TIME WITHOUT TIME ZONE DEFAULT '00:00:00',
  obchod_id INTEGER REFERENCES obchod (obchod_id)

);


CREATE TABLE IF NOT EXISTS tovar (
  tovar_id SERIAL PRIMARY KEY,
  nazov VARCHAR(255),
  category VARCHAR(255),
  prevadzka_id INTEGER REFERENCES prevadzka (prev_id)


);



