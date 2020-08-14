CREATE TABLE automovel ( placa VARCHAR(9),
                         marca VARCHAR(20),
                         modelo VARCHAR(20),
                         ano INTEGER
                       );

CREATE TABLE seguro ( empresa VARCHAR(20),
                      codigo VARCHAR(8),
                      valor NUMERIC
                    );

CREATE TABLE segurado ( nome VARCHAR(40),
                        FOREIGN KEY (automovel) REFERENCES automovel (placa),
                        FOREIGN KEY (seguro) REFERENCES seguro (codigo) 
                      );

CREATE TABLE perito ( nome VARCHAR(40), 
                      RG_de_perito VARCHAR(8)
                    );

CREATE TABLE pericia ( id INTEGER,
                       FOREIGN KEY (sinistro) REFERENCES sinistro (automovel),
                       FOREIGN KEY (perito) REFERENCES perito (RG_de_perito)
                     );

CREATE TABLE sinistro ( nome_da_seguradora VARCHAR(20),
                        FOREIGN KEY (automovel) REFERENCES automovel (placa),
                        tipo VARCHAR(15)
                      );

CREATE TABLE oficina ( nome VARCHAR(20),
                       cnpj VARCHAR(14),
                       endereco VARCHAR(100)
                     );

CREATE TABLE reparo ( FOREIGN KEY (oficina) REFERENCES oficina (cnpj),
                      FOREIGN KEY (automovel) REFERENCES automovel (placa),
                      valor NUMERIC
                    );
