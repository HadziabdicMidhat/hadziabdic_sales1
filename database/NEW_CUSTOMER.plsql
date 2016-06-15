create or replace 
PROCEDURE
PROC_NEW_CUSTOMER (CUSTOMER_ID   out    NUMBER,
                   FIRSTNAME     in     VARCHAR2,
                   CREDIT        in out NUMBER) IS
BEGIN
  SELECT seq_customernummer.nextval INTO customer_id
  FROM   dual;

  IF CREDIT is null THEN
    SELECT 100 INTO CREDIT
    FROM   dual;
  END IF;
  
  INSERT INTO CUSTOMER VALUES (CUSTOMER_ID,
       FIRSTNAME,CREDIT);
END PROC_NEW_CUSTOMER;