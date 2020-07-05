-- Create test account states
INSERT INTO account_states (id, balance, modified, comment) VALUES ('b5607d38-8fc1-43ef-b44e-34967083c80a', 1000, '2019-01-01', 'Init state');
INSERT INTO account_states (id, balance, modified, comment) VALUES ('e33962a0-d841-48b1-8f43-caf98116f3ee', 150000, '2019-01-02', 'Init state');

-- Create test accounts
INSERT INTO accounts (name, type, valuta, owner, state_id) VALUES ('Cash rubs', 'CASH', 'RUB', 'root', 'b5607d38-8fc1-43ef-b44e-34967083c80a');
INSERT INTO accounts (name, type, valuta, owner, state_id) VALUES ('Alfa card rubs', 'BANK_ACCOUNT', 'RUB', 'root', 'e33962a0-d841-48b1-8f43-caf98116f3ee');
