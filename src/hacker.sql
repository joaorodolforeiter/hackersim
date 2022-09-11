-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hackerSimulator
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hackerSimulator
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hackerSimulator` ;
USE `hackerSimulator` ;

-- -----------------------------------------------------
-- Table `hackerSimulator`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackerSimulator`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `passwd` VARCHAR(45) NULL,
  `money` INT NULL,
  `upgrade` INT NULL,
  PRIMARY KEY (`idusers`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
