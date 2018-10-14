DROP TABLE IF EXISTS `tb_produto`;
CREATE TABLE `tb_produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `descricao` varchar(300) NOT NULL,
  `categoria` varchar(200) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valor` double NOT NULL,
  `imagem` blob,
  PRIMARY KEY (`id_produto`),
  UNIQUE KEY `ID_PRODUTO_UNIQUE` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

