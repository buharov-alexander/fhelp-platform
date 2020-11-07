-- Create test account states
INSERT INTO account_states (id, balance, modified, comment) VALUES ('b5607d38-8fc1-43ef-b44e-34967083c80a', 1000, '2019-01-01', 'Init state');
INSERT INTO account_states (id, balance, modified, comment) VALUES ('e33962a0-d841-48b1-8f43-caf98116f3ee', 150000, '2019-01-02', 'Init state');

-- Create test accounts
INSERT INTO accounts (id, name, type, valuta, state_id) VALUES ('2305e3e4-7aca-4e5f-ad14-68bf64281a0e', 'Cash rubs', 'CASH', 'RUB', 'b5607d38-8fc1-43ef-b44e-34967083c80a');
INSERT INTO accounts (id, name, type, valuta, state_id) VALUES ('517441e1-928b-4405-92ee-abe645347df8', 'Alfa card rubs', 'BANK_ACCOUNT', 'RUB', 'e33962a0-d841-48b1-8f43-caf98116f3ee');
