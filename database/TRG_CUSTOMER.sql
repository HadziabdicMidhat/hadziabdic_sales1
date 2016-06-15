create or replace 
trigger TRG_CUSTOMER
BEFORE INSERT OR UPDATE
ON CUSTOMER
REFERENCING NEW as newROW OLD AS oldROW
FOR EACH ROW
DECLARE
BEGIN

  IF (:newROW.CREDIT < :newROW.CREDIT) THEN
    raise_application_error (-20999, 'The balance ' || :newROW.CREDIT || ' is over the credit limit ' || :newROW.CREDIT);
  END IF;
    
    IF (abs(:newROW.CREDIT - :oldROW.CREDIT) > 10000) THEN
      raise_application_error (-20998, 'Transactions over 10000 are not allowed!');
    END IF;


END TRG_BANKACCOUNT;