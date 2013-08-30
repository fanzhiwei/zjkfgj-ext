USE `kika`;
-- ----------------------------------------------------
-- Table `kika`.`T_MENU`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kika`.`T_MENU` (
            `id` BIGINT NOT NULL AUTO_INCREMENT,
            `name` VARCHAR(100) NULL ,
            `image` VARCHAR(100) NULL ,
            `url` VARCHAR(100) NULL ,
            `qtip` VARCHAR(100) NULL ,
            `sort_num` INT NULL ,
            `parent_id` BIGINT NULL ,
            `description` VARCHAR(200) NULL ,
            PRIMARY KEY (`id`) ,
            INDEX `FK_MENU_PARENT` (`parent_id` ASC) ,
            CONSTRAINT `FK_MENU_PARENT`
              FOREIGN KEY (`parent_id` )
              REFERENCES `kika`.`T_MENU` (`id` )
              ON DELETE NO ACTION
              ON UPDATE NO ACTION
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kika`.`T_ROLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kika`.`T_ROLE` (
              `id` BIGINT NOT NULL AUTO_INCREMENT,
              `name` VARCHAR(50) NULL ,
              `description` VARCHAR(200) NULL ,
              PRIMARY KEY (`id`) 
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kika`.`T_USER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kika`.`T_USER` (
                `id` BIGINT NOT NULL AUTO_INCREMENT,
                `name` VARCHAR(50) NULL ,
                `password` VARCHAR(50) NULL ,
                `create_date` DATETIME NULL ,
                PRIMARY KEY (`id`)
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kika`.`T_MENU_ROLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kika`.`T_MENU_ROLE` (
                  `menu_id` BIGINT NOT NULL ,
                  `role_id` BIGINT NOT NULL ,
                  PRIMARY KEY (`menu_id`, `role_id`) ,
                  INDEX `FK_MR_MENU` (`menu_id` ASC) ,
                  INDEX `FK_MR_ROLE` (`role_id` ASC) ,
                  CONSTRAINT `FK_MR_MENU`
                    FOREIGN KEY (`menu_id` )
                    REFERENCES `kika`.`T_MENU` (`id` )
                    ON DELETE NO ACTION
                    ON UPDATE NO ACTION,
                  CONSTRAINT `FK_MR_ROLE`
                    FOREIGN KEY (`role_id` )
                    REFERENCES `kika`.`T_ROLE` (`id` )
                    ON DELETE NO ACTION
                    ON UPDATE NO ACTION
)ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kika`.`T_USER_ROLE`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kika`.`T_USER_ROLE` (
                    `user_id` BIGINT NOT NULL ,
                    `role_id` BIGINT NOT NULL ,
                    PRIMARY KEY (`user_id`, `role_id`) ,
                    INDEX `FK_UR_USER` (`user_id` ASC) ,
                    INDEX `FK_UR_ROLE` (`role_id` ASC) ,
                    CONSTRAINT `FK_UR_USER`
                      FOREIGN KEY (`user_id` )
                      REFERENCES `kika`.`T_USER` (`id` )
                      ON DELETE NO ACTION
                      ON UPDATE NO ACTION,
                    CONSTRAINT `FK_UR_ROLE`
                      FOREIGN KEY (`role_id` )
                      REFERENCES `kika`.`T_ROLE` (`id` )
                      ON DELETE NO ACTION
                      ON UPDATE NO ACTION
)ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `kika`.`T_MONEY`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kika`.`T_MONEY` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `create_time` DATETIME NULL ,
  `operator` VARCHAR(50) NULL ,
  `total` FLOAT NULL ,
  PRIMARY KEY (`id`)
)ENGINE = INNODB;

-- -----------------------------------------------------
-- Table `kika`.`T_MONEY_LIST`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kika`.`T_MONEY_LIST` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `money_id` BIGINT NULL ,
    `name` VARCHAR(200) NULL ,
    `price` FLOAT NULL ,
    PRIMARY KEY (`id`) ,
    INDEX `FK_MONEY` (`money_id` ASC) ,
    CONSTRAINT `FK_MONEY`
      FOREIGN KEY (`money_id` )
      REFERENCES `kika`.`T_MONEY` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)ENGINE = INNODB;
