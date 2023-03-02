-- -----------------------------------------------------
-- Schema DBPESSOA
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DBPESSOA` DEFAULT CHARACTER SET utf8 ;
USE `DBPESSOA` ;

-- -----------------------------------------------------
-- Table `DBPESSOA`.`tPessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DBPESSOA`.`tPessoa` (
  `BDCPF` BIGINT NOT NULL,
  `BDNOME` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`BDCPF`))
ENGINE = InnoDB;

-- INSERT INTO `dbpessoa`.`tpessoa` (`BDCPF`, `BDNOME`) VALUES (?,?);