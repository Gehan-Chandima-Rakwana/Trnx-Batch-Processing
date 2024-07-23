CREATE SEQUENCE  IF NOT EXISTS r_status_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS t_transaction_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE  IF NOT EXISTS t_report_seq START WITH 1 INCREMENT BY 1;


CREATE TABLE r_status (
  status_id INTEGER NOT NULL,
   status_code VARCHAR(10) NOT NULL,
   description VARCHAR(150),
   is_active BOOLEAN,
   CONSTRAINT pk_r_status PRIMARY KEY (status_id)
);

CREATE TABLE t_transaction (
  transaction_id INTEGER NOT NULL,
   amount_local DECIMAL,
   authorized VARCHAR(255),
   comments VARCHAR(255),
   date_posting date,
   date_transaction date,
   goods_services VARCHAR(255),
   internal_ref_number VARCHAR(255),
   is_active BOOLEAN,
   late_deposit BOOLEAN,
   teller VARCHAR(255),
   trx_no VARCHAR(50),
   rpt_code VARCHAR(50),
   transaction_description VARCHAR(255),
   transaction_location VARCHAR(255),
   transaction_number VARCHAR(255),
   transmode_comment VARCHAR(255),
   value_date date,
   cust_id VARCHAR(9),
   acid VARCHAR(11),
   status_id INTEGER NOT NULL,
   report_id INTEGER NOT NULL,
   CONSTRAINT pk_t_transaction PRIMARY KEY (transaction_id)
);

CREATE TABLE t_report (
  report_id INTEGER NOT NULL,
   action VARCHAR(255),
   currency_code_local VARCHAR(255),
   entity_reference VARCHAR(255),
   fiu_ref_number VARCHAR(255),
   is_active BOOLEAN,
   location VARCHAR(255),
   reason VARCHAR(255),
   rentity_branch VARCHAR(255),
   rentity_id INTEGER,
   report_code VARCHAR(255),
   reporting_person VARCHAR(255),
   submission_code VARCHAR(255),
   submission_date TIMESTAMP WITHOUT TIME ZONE,
   status_id INTEGER NOT NULL,
   CONSTRAINT pk_t_report PRIMARY KEY (report_id)
);



ALTER TABLE t_transaction ADD CONSTRAINT FK_T_TRANSACTION_ON_REPORT FOREIGN KEY (report_id) REFERENCES t_report (report_id);

CREATE INDEX T_TRANSACTION_T_REPORT1_idx ON t_transaction(report_id);

ALTER TABLE t_transaction ADD CONSTRAINT FK_T_TRANSACTION_ON_STATUS FOREIGN KEY (status_id) REFERENCES r_status (status_id);


ALTER TABLE t_report ADD CONSTRAINT FK_T_REPORT_ON_STATUS FOREIGN KEY (status_id) REFERENCES r_status (status_id);

CREATE INDEX T_REPORT_R_STATUS1_idx ON t_report(status_id);