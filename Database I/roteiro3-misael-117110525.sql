// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19] //

CREATE TYPE ESTADO AS ENUM ('paraiba', 'rio grande do norte',
                            'pernambuco', 'maranhao', 'piaui',
                            'ceara', 'alagoas', 'sergipe', 'bahia'); //19º//

CREATE TABLE farmacias (nome VARCHAR(40) NOT NULL,
                        telefone CHAR(11) NOT NULL,
                        bairro VARCHAR(20) NOT NULL,
                        cidade VARCHAR(30) NOT NULL,
                        estado ESTADO NOT NULL,
                        cnpj INTEGER,
                        tipo VARCHAR(6) NOT NULL,
                        gerente CHAR(11),
                        funcao CHAR(13),
                        PRIMARY KEY (cnpj),
                        UNIQUE(bairro), //14º//
                        FOREIGN KEY (gerente, funcao) REFERENCES funcionario (cpf, funcao));

ALTER TABLE farmacias ALTER COLUMN gerente SET NOT NULL;
ALTER TABLE farmacias ALTER COLUMN funcao SET NOT NULL;
ALTER TABLE farmacias ADD CONSTRAINT telefone_valido CHECK (CHAR_LENGTH(telefone) = 11);
ALTER TABLE farmacias ADD CONSTRAINT tipo_valido CHECK (tipo = "sede" OR tipo = "filial"); //1º//
ALTER TABLE farmacias ADD CONSTRAINT sede_unica EXCLUDE USING gist (cnpj WITH =) WHERE (tipo = "sede"); //15º//
ALTER TABLE farmacias ADD CONSTRAINT genrente_valido CHECK (funcao = "administrador" OR funcao = "farmaceutico"); //4º e 16º//

CREATE TABLE funcionarios (nome VARCHAR(40) NOT NULL,
                           cpf CHAR(11),
                           local_de_trabalho INTEGER, //5º//
                           funcao VARCHAR(15) NOT NULL,
                           PRIMARY KEY (cpf), //3º//
                           FOREIGN KEY (local_de_trabalho) REFERENCES farmacia (cnpj));

ALTER TABLE funcionarios ALTER COLUMN local_de_trabalho SET NOT NULL;
ALTER TABLE funcionarios ADD CONSTRAINT cpf_valido CHECK (CHAR_LENGTH(cpf) = 11);
ALTER TABLE funcionarios ADD CONSTRAINT funcao_valida CHECK (funcao = "farmaceutico" OR
                                                             funcao = "vendedor" OR
                                                             funcao = "entregador" OR
                                                             funcao = "caixa" OR
                                                             funcao = "administrador"); //2º//

CREATE TABLE medicamentos (nome VARCHAR(40) NOT NULL,
                           codigo_de_barras CHAR(7),
                           tipo_de_venda CHAR(10) NOT NULL,
                           PRIMARY KEY (codigo_de_barras));

ALTER TABLE medicamentos ADD CONSTRAINT codigo_de_barras_valido CHECK (CHAR_LENGTH(codigo_de_barras) = 7);
ALTER TABLE medicamentos ADD CONSTRAINT tipo_de_venda_valido CHECK (tipo_de_venda = "normal" OR
                                                                    tipo_de_venda = "exclusiva"); //8º//

CREATE TABLE vendas (nota_fiscal INTEGER,
                     funcionario CHAR(11),
                     funcao VARCHAR(15),
                     medicamento CHAR(7),
                     tipo_de_venda CHAR(10),
                     cliente CHAR(11), //10º//
                     nO_cadastro INTEGER,
                     PRIMARY KEY (nota_fiscal));

ALTER TABLE vendas ADD CONSTRAINT funcionario_valido FOREIGN KEY (funcionario, funcao) REFERENCES funcionarios (cpf) ON DELETE RESTRICT; //11º//
ALTER TABLE vendas ADD CONSTRAINT medicamento_valido FOREIGN KEY (medicamento, tipo_de_venda) REFERENCES medicamentos (codigo_de_barras, tipo_de_venda) ON DELETE RESTRICT; //12º//
ALTER TABLE vendas ADD CONSTRAINT cliente_valido FOREIGN KEY (cliente, nO_cadastro) REFERENCES clientes (cpf, nO_cadastro) ON DELETE RESTRICT;

ALTER TABLE vendas ADD ALTER COLUMN cliente SET NOT NULL;
ALTER TABLE vendas ADD ALTER COLUMN nO_cadastro SET NOT NULL;
ALTER TABLE vendas ADD ALTER COLUMN medicamento SET NOT NULL;
ALTER TABLE vendas ADD ALTER COLUMN tipo_de_venda SET NOT NULL;
ALTER TABLE vendas ADD ALTER COLUMN funcionario SET NOT NULL;
ALTER TABLE vendas ADD ALTER COLUMN funcao SET NOT NULL;

ALTER TABLE vendas ADD CONSTRAINT venda_valida CHECK (tipo_de_venda = "normal" OR
                                                      (tipo_de_venda = "exclusiva" AND nO_cadastro IS NOT NULL)); //17º//

ALTER TABLE vendas ADD CONSTRAINT funcionario_de_vendas CHECK (funcao = "vendedor"); //18º//

CREATE TABLE entregas (codigo_de_rastreio CHAR(9),
                       cliente CHAR(11),
                       nO_cadastro INTEGER,
                       endereco_de_destino VARCHAR(100),
                       PRIMARY KEY (codigo_de_rastreio),
                       FOREIGN KEY (nO_cadastro) REFERENCES clientes (nO_cadastro),
                       FOREIGN KEY (cliente, endereco) REFERENCES enderecos (cliente, endereco));

ALTER TABLE entregas ADD CONSTRAINT codigo_de_rastreio_valido CHECK (CHAR_LENGTH(codigo_de_rastreio) = 9);
ALTER TABLE entregas ADD CONSTRAINT cliente_valido CHECK (nO_cadastro IS NOT NULL); //9º//
ALTER TABLE entregas ALTER COLUMN cliente SET NOT NULL;
ALTER TABLE entregas ALTER COLUMN endereco SET NOT NULL;

CREATE TABLE clientes (nome VARCHAR(40) NOT NULL,
                       data_de_nascimento DATE NOT NULL,
                       cpf CHAR(11),
                       nO_cadastro INTEGER,
                       endereco VARCHAR(100) NOT NULL,
                       PRIMARY KEY (cpf),
                       FOREIGN KEY (endereco) REFERENCES enderecos (endereco));

ALTER TABLE clientes ADD CONSTRAINT cpf_valido CHECK (CHAR_LENGTH(cpf) = 11);
ALTER TABLE clientes ADD CONSTRAINT cadastrado_maior_de_idade CHECK ((nO_cadastro IS NULL) OR
                                                                     (nO_cadastro IS NOT NULL AND
                                                                     age(timestamp data_de_nascimento) >= 18)); //13º//

ALTER TABLE clientes ALTER COLUMN endereco SET NOT NULL;

CREATE TABLE enderecos (cliente CHAR(11),
                        endereco VARCHAR(100) NOT NULL, //6º//
                        tipo CHAR(10),
                        PRIMARY KEY (endereco);
                        FOREIGN KEY (cliente) REFERENCES clientes (cpf));

ALTER TABLE enderecos ADD CONSTRAINT tipo_valido CHECK (tipo = "trabalho" OR
                                                        tipo = "residencia" OR
                                                        tipo = "outro"); //7º//

ALTER TABLE enderecos ALTER COLUMN cliente SET NOT NULL;