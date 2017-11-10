create database GradeOneSchema;
USE `GradeOneSchema`;
		            
CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`school` (
  `id` INT NOT NULL,
  `name` VARCHAR(60) NOT NULL,
  `division` VARCHAR(45) NOT NULL,
  `district` VARCHAR(30) NOT NULL,
  `province` VARCHAR(20) NOT NULL,
  `eligible_count` INT NOT NULL,
  PRIMARY KEY (`id`))
;
CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`parent` (
  `id` CHAR(10) NOT NULL,
  `first_name` VARCHAR(30) NOT NULL,
  `second_name` VARCHAR(30) NOT NULL,
  `initials` VARCHAR(10) NOT NULL,
  `occupation` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(5) NOT NULL,
  `telephone_no` BIGINT(10) NOT NULL,
  `email` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
;

CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE  IF NOT EXISTS `GradeOneSchema`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`activity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `activity` VARCHAR(100) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idactivity_no_UNIQUE` (`id` ASC),
  INDEX `user id activity of user_idx` (`user_id` ASC),
  CONSTRAINT `user id activity of user`
    FOREIGN KEY (`user_id`)
    REFERENCES `GradeOneSchema`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
;

CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`applicant` (
  `application_id` INT NOT NULL,
  `first_name` VARCHAR(25) NOT NULL,
  `second_name` VARCHAR(25) NOT NULL,
  `initials` VARCHAR(20) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `gender` VARCHAR(5) NOT NULL,
  `religion` VARCHAR(30) NOT NULL,
  `age` INT(2) NOT NULL ,
  `district` VARCHAR(30) NOT NULL,
  `div_secretary` VARCHAR(45) NOT NULL,
  `div_grama` VARCHAR(45) NOT NULL,
  `result_application` DECIMAL(4,1) NOT NULL,
  PRIMARY KEY (`application_id`))
;

CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`applicant_parent` (
  `application_id` INT NOT NULL,
  `nic` CHAR(10) NOT NULL,
  PRIMARY KEY (`application_id`),
  INDEX `applicant to parent by nic_idx` (`nic` ASC),
  CONSTRAINT `applicant to parent by nic`
    FOREIGN KEY (`nic`)
    REFERENCES `GradeOneSchema`.`parent` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `applicant to parent by app`
    FOREIGN KEY (`application_id`)
    REFERENCES `GradeOneSchema`.`applicant` (`application_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
;

CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`past_pupil` (
  `id` CHAR(10) NOT NULL,
  `student_id` INT NOT NULL,
  `school_id` INT NULL,
  `no_of_classes` INT NOT NULL,
  `period` VARCHAR(20) NOT NULL,
  `achievements` VARCHAR(200) NULL,
  `past_pupil_member_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `past pupil school_idx` (`school_id` ASC),
  CONSTRAINT `past pupil school`
    FOREIGN KEY (`school_id`)
    REFERENCES `GradeOneSchema`.`school` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
;
CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`student` (
  `id` INT NOT NULL,
  `school_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `student in school_idx` (`school_id` ASC),
  CONSTRAINT `student in school`
    FOREIGN KEY (`school_id`)
    REFERENCES `GradeOneSchema`.`school` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
;


CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`selected_applicant` (
  `application_id` INT NOT NULL,
  `selected_sch_id` INT NOT NULL,
  `result_inerview` DECIMAL(4,1) NOT NULL DEFAULT 0,
  `result_total` DECIMAL(4,1) DEFAULT 0,
  `interviewer` INT NOT NULL,
  `student_id` INT NULL,
  PRIMARY KEY (`application_id`, `selected_sch_id`),
  INDEX `dataentry track_idx` (`interviewer` ASC),
  INDEX `select as a student_idx` (`student_id` ASC),
  INDEX `selected school_idx` (`selected_sch_id` ASC),
  CONSTRAINT `dataentry track`
    FOREIGN KEY (`interviewer`)
    REFERENCES `GradeOneSchema`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `select as a student`
    FOREIGN KEY (`student_id`)
    REFERENCES `GradeOneSchema`.`student` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `applicant `
    FOREIGN KEY (`application_id`)
    REFERENCES `GradeOneSchema`.`applicant` (`application_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
CONSTRAINT `selected school`
    FOREIGN KEY (`selected_sch_id`)
    REFERENCES `GradeOneSchema`.`school` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
;

CREATE TABLE IF NOT EXISTS `GradeOneSchema`.`assigned_applicant` (
  `application_id` INT NOT NULL,
  `sch_id` INT NOT NULL,
  `distance` DECIMAL(6,3) NOT NULL,
  `application_result` DECIMAL(4,1) NOT NULL,
  PRIMARY KEY (`application_id`, `sch_id`),
  INDEX `apply to school_idx`(`sch_id` ASC),
  INDEX `applicant to assign_idx`(`application_id` ASC),
  CONSTRAINT `applicant to assign`
    FOREIGN KEY (`application_id`)
    REFERENCES `GradeOneSchema`.`applicant` (`application_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `apply to school`
    FOREIGN KEY (`sch_id`)
    REFERENCES `GradeOneSchema`.`school` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
;

insert into user values('1','user001','$2a$11$EBNRlouE8xw4sj9XWhjKd.wZSXCL5xWk0YFOCNRRrRk1R.HD/ht3m','admin');
insert into role values('1','ROLE_USER');
insert into role values('2','ROLE_ADD_USER');

insert into user_role values('1','1');
insert into user_role values('1','2');

insert into role values('3','ROLE_INSERT');

ALTER TABLE `past_pupil` CHANGE `past_pupil_member_id` `past_pupil_member_id` VARCHAR(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL;







