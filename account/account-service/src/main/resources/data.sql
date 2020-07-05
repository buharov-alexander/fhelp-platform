-- Create test account states
INSERT INTO account_states (id, balance, modified, comment) VALUES (10, 1000, '2019-01-01', 'Init state');
INSERT INTO account_states (id, balance, modified, comment) VALUES (11, 150000, '2019-01-02', 'Init state');

-- Create test accounts
INSERT INTO accounts (name, type, valuta, owner, state_id) VALUES ('Cash rubs', 'CASH', 'RUB', 'root', 10);
INSERT INTO accounts (name, type, valuta, owner, state_id) VALUES ('Alfa card rubs', 'BANK_ACCOUNT', 'RUB', 'root', 11);
