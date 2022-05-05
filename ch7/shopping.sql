-- MySQL Script generated by MySQL Workbench
-- Thu May  5 14:09:57 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema shopping
-- -----------------------------------------------------
-- 一个示例用的购物系统

-- -----------------------------------------------------
-- Schema shopping
--
-- 一个示例用的购物系统
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopping` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `shopping` ;

-- -----------------------------------------------------
-- Table `shopping`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping`.`users` ;

CREATE TABLE IF NOT EXISTS `shopping`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shopping`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping`.`item` ;

CREATE TABLE IF NOT EXISTS `shopping`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `store` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shopping`.`cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping`.`cart` ;

CREATE TABLE IF NOT EXISTS `shopping`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `num` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shopping`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping`.`order` ;

CREATE TABLE IF NOT EXISTS `shopping`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  `add_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `shopping`.`order_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopping`.`order_item` ;

CREATE TABLE IF NOT EXISTS `shopping`.`order_item` (
  `id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `num` INT NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
