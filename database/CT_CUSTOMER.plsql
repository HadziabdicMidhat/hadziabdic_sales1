create or replace 
PROCEDURE CT_CUSTOMER IS
  v_tabcnt NUMBER;
BEGIN
  SELECT count(*) INTO v_tabcnt
  FROM   ALL_TABLES
  WHERE  TABLE_NAME = 'CUSTOMER' and
         OWNER = USER;

  if v_tabcnt = 0 then
    EXECUTE IMMEDIATE 'CREATE TABLE CUSTOMER 
                              (
                                    CUSTOMER_ID INT,
                                    FIRST_NAME VARCHAR(20),
                                    CREDIT DECIMAL(10,2),
                                    PRIMARY KEY(CUSTOMER_ID)
                              )';
    COMMIT;
  end if;
  SELECT count(*) into v_tabcnt
  FROM   ALL_SEQUENCES
  WHERE  SEQUENCE_NAME = 'SEQ_ACCOUNTNUMBER' and
         SEQUENCE_OWNER = USER;

  if v_tabcnt = 0 then
    EXECUTE IMMEDIATE 'CREATE SEQUENCE SEQ_ACCOUNTNUMBER
                          START WITH 100000
                          INCREMENT BY 1
                          CACHE 20';
    COMMIT;
  end if;
END CT_CUSTOMER;
