use ayinfo;
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
	`employee_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`employee_name` varchar(8),
	`gender` varchar(1),
	`birthday` date,
	`age` double,
	`zodiac` varchar(1),
	`height` double,
	`weight` double,
	`province` varchar(8),
	`id_no` varchar(32),
	`mobile_no` varchar(32),
	`education` varchar(32),
	`tag` varchar(128),
	`work_type` varchar(128),
	`working_age` double,
	`certification` varchar(128),
	`expected_pay` double,
	`picture_id` varchar(64),
	`added_date` datetime default current_timestamp,
	`added_by` varchar(32),
	`updated_date` datetime default current_timestamp,
	`updated_by` varchar(32),
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- working_history
DROP TABLE IF EXISTS `working_history`;
CREATE TABLE `working_history` (
	`employee_id` INT UNSIGNED,
	`des` varchar(200),
	`start_date` date,
	`end_date` date,
	`added_date` datetime default current_timestamp,
	`added_by` varchar(32),
	`updated_date` datetime default current_timestamp,
	`updated_by` varchar(32)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- certification_picture
DROP TABLE IF EXISTS `certification_picture`;
CREATE TABLE `certification_picture` (
	`employee_id` INT UNSIGNED,
	`picture_type` varchar(16),
	`picture_id` varchar(64),
	`added_date` datetime default current_timestamp,
	`added_by` varchar(32),
	`updated_date` datetime default current_timestamp,
	`updated_by` varchar(32)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;