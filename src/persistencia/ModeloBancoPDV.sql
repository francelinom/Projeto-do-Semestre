-- -----------------------------------------------------
-- Table produtos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS produtos (
  	id SERIAL NOT NULL,
  	nome_produto VARCHAR(45) NULL,
  	cod_barras NUMERIC NULL,
  	preco DECIMAL NULL,
  quantidade INT NULL,
  und_medida VARCHAR(10) NULL,
  PRIMARY KEY (id));

-- -----------------------------------------------------
-- Table vendas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS vendas (
  idvendas SERIAL NOT NULL ,
  total_venda DECIMAL NULL,
  PRIMARY KEY (idvendas));

-- -----------------------------------------------------
-- Table itens
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS itens (
  iditens SERIAL NOT NULL ,
  vendas_idvendas INT NOT NULL,
  iddoproduto INT NOT NULL,
  nomeproduto VARCHAR(45) NOT NULL,
  undproduto VARCHAR(45) NOT NULL,
  precoproduto VARCHAR(45) NOT NULL,
  quantproduto INT NOT NULL,
  totaldoiten VARCHAR(45) NOT NULL,
  PRIMARY KEY (iditens),
  CONSTRAINT fk_itens_vendas1
    FOREIGN KEY (vendas_idvendas)
    REFERENCES vendas (idvendas)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);