CREATE TABLE IF NOT EXISTS customers (
    CustomerID int NOT NULL,
    CustomerName varchar(200) DEFAULT NULL,
    CustomerEmail varchar(200) DEFAULT NULL,
    CustomerType varchar(200) DEFAULT NULL,
    CustomerContact varchar(200) DEFAULT NULL,
    PRIMARY KEY (CustomerID)
  );
  
  CREATE TABLE IF NOT EXISTS roles (
    role_id INT NOT NULL,
    role_name varchar(200) DEFAULT NULL,
    role_description varchar(400) DEFAULT NULL,
    PRIMARY KEY(role_id)
  );
  
  CREATE TABLE IF NOT EXISTS interruption_schedule (
    intpr_id INT NOT NULL,
    intpr_time varchar(200) DEFAULT NULL,
    intpr_day varchar(200) DEFAULT NULL,
    intpr_zone varchar(200) DEFAULT NULL,
    PRIMARY KEY(intpr_id)
  );
  
  CREATE TABLE IF NOT EXISTS bill (
    bill_id INT NOT NULL,
    bill_cus_id varchar(200) DEFAULT NULL,
    payment_date varchar(200) DEFAULT NULL,
    invoice_no varchar(200) DEFAULT NULL,
    units varchar(200) DEFAULT NULL,
    total_amount varchar(200) DEFAULT NULL,
	PRIMARY KEY(bill_id)
  );
  