CREATE TABLE IF NOT EXISTS contacts_info (
   id INT NOT NULL,
   firstName VARCHAR(50) NOT NULL,
   lastname VARCHAR(50) NOT NULL,
   address VARCHAR(256) NOT NULL,
   postcode VARCHAR(20) NOT NULL,
   city VARCHAR(50) NOT NULL,
   phonenumber VARCHAR(50) NOT NULL
);