CREATE SCHEMA IF NOT EXISTS `hackerSimulator` ;
USE `hackerSimulator` ;

CREATE TABLE IF NOT EXISTS `hackerSimulator`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `passwd` VARCHAR(45) NULL,
  `money` INT NULL,
  `upgrade` INT NULL,
  PRIMARY KEY (`idusers`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;