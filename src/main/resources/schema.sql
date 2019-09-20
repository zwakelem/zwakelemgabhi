CREATE TABLE node (
 name VARCHAR(10) NOT NULL,
 PRIMARY KEY (name)
);

CREATE TABLE edge (
 a VARCHAR(10) NOT NULL REFERENCES node(name),
 b VARCHAR(10) NOT NULL REFERENCES node(name)
);

CREATE INDEX a_idx ON edge (a);
CREATE INDEX b_idx ON edge (b);

ALTER TABLE edge ADD CONSTRAINT no_self_loop CHECK (a <> b);
