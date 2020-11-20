DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email_address VARCHAR(250) DEFAULT NULL
);

INSERT INTO employee (first_name, last_name, email_address) VALUES
  ('Aliko', 'Dangote', 'aliko@email.com'),
  ('Bill', 'Gates', 'bill.gates@email.com'),
  ('Folrunsho', 'Alakija', 'folrunsho.alka@email.com'),
  ('Kamala', 'Harris', 'us.vp@email.com');