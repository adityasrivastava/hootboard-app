SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hootboard
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hootboard` ;

-- -----------------------------------------------------
-- Schema hootboard
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hootboard` DEFAULT CHARACTER SET utf8 ;
USE `hootboard` ;

-- -----------------------------------------------------
-- Table `hootboard`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hootboard`.`Address` ;

CREATE TABLE IF NOT EXISTS `hootboard`.`Address` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `streetAddress1` VARCHAR(200) NULL,
  `streetAddress2` VARCHAR(200) NULL,
  `country` VARCHAR(100) NULL,
  `state` VARCHAR(100) NULL,
  `city` VARCHAR(100) NULL,
  `postalCode` VARCHAR(100) NULL,
  `created` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `createdBy` VARCHAR(300) NULL,
  `updatedBy` VARCHAR(300) NULL,
  `deleted` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hootboard`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hootboard`.`User` ;

CREATE TABLE IF NOT EXISTS `hootboard`.`User` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `username` VARCHAR(200) NULL UNIQUE,
  `password` VARCHAR(500) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `address` BIGINT(10) NULL,
  `created` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `createdBy` VARCHAR(300) NULL,
  `updatedBy` VARCHAR(300) NULL,
  `enabled` TINYINT(1) NULL,
  `deleted` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `addressIds_FK_idx` (`address` ASC),
  CONSTRAINT `user_address_FK`
    FOREIGN KEY (`address`)
    REFERENCES `hootboard`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hootboard`.`Email`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hootboard`.`Email` ;

CREATE TABLE IF NOT EXISTS `hootboard`.`Email` (
  `id` BIGINT(30) NOT NULL AUTO_INCREMENT,
  `emailAddress` VARCHAR(100) NULL,
  `status` INT NULL,
  `created` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `createdBy` VARCHAR(300) NULL,
  `updatedBy` VARCHAR(300) NULL,
  `deleted` TINYINT(1) NULL,
  `user` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  INDEX `email_user_FK_idx` (`user` ASC),
  CONSTRAINT `email_user_FK`
    FOREIGN KEY (`user`)
    REFERENCES `hootboard`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hootboard`.`UserRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hootboard`.`UserRole` ;

CREATE TABLE IF NOT EXISTS `hootboard`.`UserRole` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(200) NULL,
  `created` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `createdBy` VARCHAR(300) NULL,
  `updatedBy` VARCHAR(300) NULL,
  `deleted` TINYINT(1) NULL,
  `user` BIGINT(10) NULL,
  PRIMARY KEY (`id`),
  INDEX `userRole_user_FK_idx` (`user` ASC),
  CONSTRAINT `userrole_user_FK`
    FOREIGN KEY (`user`)
    REFERENCES `hootboard`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
