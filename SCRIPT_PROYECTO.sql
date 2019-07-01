-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema PROYECTO8
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PROYECTO8
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PROYECTO8` DEFAULT CHARACTER SET utf8 ;
USE `PROYECTO8` ;

-- -----------------------------------------------------
-- Table `PROYECTO8`.`Cliente2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROYECTO8`.`Cliente2` (
  `idClie` INT NOT NULL AUTO_INCREMENT,
  `Cedula` VARCHAR(45) NULL,
  `PrimApellido` VARCHAR(45) NULL,
  `SegApellido` VARCHAR(45) NULL,
  `PrimNombre` VARCHAR(45) NULL,
  `SegNombre` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  `Direccion` VARCHAR(45) NULL,
  `eMail` VARCHAR(45) NULL,
  `Contraseña` VARCHAR(45) NULL,
  PRIMARY KEY (`idClie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PROYECTO8`.`Restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROYECTO8`.`Restaurante` (
  `idRest` INT NOT NULL AUTO_INCREMENT,
  `NombreRes` VARCHAR(45) NULL,
  `HorarioRes` VARCHAR(45) NULL,
  `HorarioHoras` VARCHAR(45) NULL,
  `CodigoRest` VARCHAR(45) NULL,
  PRIMARY KEY (`idRest`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PROYECTO8`.`Plato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROYECTO8`.`Plato` (
  `idPlat` INT NOT NULL AUTO_INCREMENT,
  `NombrePlato` VARCHAR(45) NULL,
  `Precio` DOUBLE NULL,
  `Detalle` VARCHAR(45) NULL,
  `idRest` INT NOT NULL,
  PRIMARY KEY (`idPlat`),
  INDEX `fk_Plato_Restaurante1_idx` (`idRest` ASC),
  CONSTRAINT `fk_Plato_Restaurante1`
    FOREIGN KEY (`idRest`)
    REFERENCES `PROYECTO8`.`Restaurante` (`idRest`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PROYECTO8`.`Cajera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROYECTO8`.`Cajera` (
  `idCaje` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `NumCaja` VARCHAR(45) NULL,
  `Codigo` VARCHAR(45) NULL,
  PRIMARY KEY (`idCaje`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PROYECTO8`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROYECTO8`.`Pedido` (
  `idPedi` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(45) NULL,
  `NumMesa` VARCHAR(45) NULL,
  `TiempoEspera` INT NULL,
  `idPlat` INT NOT NULL,
  `idCaje` INT NOT NULL,
  PRIMARY KEY (`idPedi`),
  INDEX `fk_Pedido_Cajera1_idx` (`idCaje` ASC),
  INDEX `fk_Pedido_Plato1_idx` (`idPlat` ASC),
  CONSTRAINT `fk_Pedido_Cajera1`
    FOREIGN KEY (`idCaje`)
    REFERENCES `PROYECTO8`.`Cajera` (`idCaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Plato1`
    FOREIGN KEY (`idPlat`)
    REFERENCES `PROYECTO8`.`Plato` (`idPlat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PROYECTO8`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROYECTO8`.`Usuario` (
  `idUsua` INT NOT NULL AUTO_INCREMENT,
  `CedulaAcc` VARCHAR(45) NULL,
  `ContraseñaAcc` VARCHAR(45) NULL,
  `idClie` INT NOT NULL,
  PRIMARY KEY (`idUsua`),
  INDEX `fk_Usuario_Cliente21_idx` (`idClie` ASC),
  CONSTRAINT `fk_Usuario_Cliente21`
    FOREIGN KEY (`idClie`)
    REFERENCES `PROYECTO8`.`Cliente2` (`idClie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
