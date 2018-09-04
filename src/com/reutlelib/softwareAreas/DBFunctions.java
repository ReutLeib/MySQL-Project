package com.reutlelib.softwareAreas;

import com.reutleib.GUI.*;

public class DBFunctions {

	// sql quaries:
	public static final String createTable_Project = "CREATE TABLE `db_reutleib`.`project` ("
			+ "`project_number` INT NOT NULL," + "`project_name` VARCHAR(45) NOT NULL,"
			+ "`customer_name` VARCHAR(45) NOT NULL," + "`start date` DATE NOT NULL,"
			+ "`description` VARCHAR(80) NULL," + "`development tools` TEXT(200) NULL," + "`grade` INT UNSIGNED NULL,"
			+ "PRIMARY KEY (`project_number`));";

	public static final String craeteTable_Engineer = "CREATE TABLE `db_reutleib`.`engineer` ("
			+ "`engineer_id` INT NOT NULL," + "`first name` VARCHAR(45) NULL," + "`last name` VARCHAR(45) NULL,"
			+ "`birthday` DATE NULL," + "`age` INT UNSIGNED NULL," + "`city` VARCHAR(45) NULL,"
			+ "`street` VARCHAR(45) NULL," + "`number` VARCHAR(45) NULL," + "PRIMARY KEY (`engineer_id`));";

	public static final String createTable_SoftwareArea = "CREATE TABLE `db_reutleib`.`software_area` ("
			+ "`area_number` INT NOT NULL," + "`name` VARCHAR(45) NULL," + "`expertise` VARCHAR(45) NULL,"
			+ "PRIMARY KEY (`area_number`));";

	public static final String createTable_ProjectMilestones = "CREATE TABLE `db_reutleib`.`project_milestones` ("
			+ " `project_milestones_number` INT NOT NULL," + " `milestones_number` INT NOT NULL," + " `date` DATE NULL,"
			+ " `submossion` VARCHAR(200) NULL," + " `amount_of_muny` DOUBLE UNSIGNED NULL,"
			+ "  PRIMARY KEY (`project_milestones_number`, `milestones_number`),"
			+ " CONSTRAINT `project_milestones_number`" + "   FOREIGN KEY (`project_milestones_number`)"
			+ "  REFERENCES `db_reutleib`.`project` (`project_number`)" + "  ON DELETE CASCADE"
			+ "  ON UPDATE NO ACTION);";

	public static final String createTable_DevelopmentStages = "CREATE TABLE `db_reutleib`.`development_stages` ("
			+ "  `project_stage_number` INT NOT NULL," + "  `stage_name` VARCHAR(45) NULL,"
			+ " `tools` VARCHAR(200) NULL," + " PRIMARY KEY (`project_stage_number`),"
			+ " CONSTRAINT `project_stage_number`" + "  FOREIGN KEY (`project_stage_number`)"
			+ " REFERENCES `db_reutleib`.`project` (`project_number`)" + " ON DELETE CASCADE"
			+ " ON UPDATE NO ACTION);";

	public static final String createTable_Grades = "CREATE TABLE `db_reutleib`.`grades` ( "
			+ "  `projectNumber` INT NOT NULL," + "   `engineerID` INT NOT NULL," + "   `grade` INT NOT NULL,"
			+ "   `month` INT ," + "   PRIMARY KEY (`projectNumber`, `engineerID`),"
			+ "   INDEX `engineerID_idx` (`engineerID` ASC)," + "   CONSTRAINT `projectNumber`"
			+ "     FOREIGN KEY (`projectNumber`)" + "   REFERENCES `db_reutleib`.`project` (`project_number`)"
			+ "     ON DELETE CASCADE" + "   ON UPDATE NO ACTION," + "  CONSTRAINT `engineerID`"
			+ "   FOREIGN KEY (`engineerID`)" + "  REFERENCES `db_reutleib`.`engineer` (`engineer_id`)"
			+ "  ON DELETE CASCADE" + "   ON UPDATE NO ACTION);";

	public static final String createTable_EngineerPhoneNumber = "CREATE TABLE `db_reutleib`.`engineer_phone_number` (\n"
			+ "`engineer_phone_id` INT NOT NULL,\n" + "`phone_number` VARCHAR(45) NOT NULL,\n"
			+ "PRIMARY KEY (`engineer_phone_id`, `phone_number`),\n" + "CONSTRAINT `engineer_id`\n"
			+ " FOREIGN KEY (`engineer_phone_id`)\n" + " REFERENCES `db_reutleib`.`engineer` (`engineer_id`)\n"
			+ " ON DELETE CASCADE\n" + " ON UPDATE NO ACTION);\n";

	public static final String createRelationTable_WorkingOn = "CREATE TABLE `db_reutleib`.`working_on` ("
			+ " `number_project` INT NOT NULL," + " `id_engineer` INT NOT NULL,"
			+ " PRIMARY KEY (`number_project`, `id_engineer`)," + " INDEX `id_engineer_idx` (`id_engineer` ASC),"
			+ " CONSTRAINT `number_project`" + " FOREIGN KEY (`number_project`)"
			+ " REFERENCES `db_reutleib`.`project` (`project_number`)" + " ON DELETE CASCADE" + " ON UPDATE NO ACTION,"
			+ " CONSTRAINT `id_engineer`" + " FOREIGN KEY (`id_engineer`)"
			+ " REFERENCES `db_reutleib`.`engineer` (`engineer_id`)" + " ON DELETE CASCADE" + " ON UPDATE NO ACTION);";

	public static final String createRelationTable_WorkingAt = "CREATE TABLE `db_reutleib`.`working_at` ("
			+ " `number-area` INT NOT NULL," + " `id_of_engineer` INT NOT NULL,"
			+ " PRIMARY KEY (`number-area`, `id_of_engineer`)," + " INDEX `id_of_engineer_idx` (`id_of_engineer` ASC),"
			+ " CONSTRAINT `number_area`" + "   FOREIGN KEY (`number-area`)"
			+ "  REFERENCES `db_reutleib`.`software_area` (`area_number`)" + "   ON DELETE CASCADE"
			+ "  ON UPDATE NO ACTION," + " CONSTRAINT `id_of_engineer`" + "  FOREIGN KEY (`id_of_engineer`)"
			+ "   REFERENCES `db_reutleib`.`engineer` (`engineer_id`)" + "  ON DELETE CASCADE"
			+ "  ON UPDATE NO ACTION);";

	public static final String createView_TotalMunyOfProjects = "create view totalMunyOfProjects as ("
			+ "	select * , (select sum(amount_of_muny) "
			+ "			from project_milestones where project_number = project_milestones_number) "
			+ "			as totalMuny from project order by totalMuny) ";
	// insert + update + delete to all tables:

	// insert:
	public static final String insert_Engineer = "INSERT INTO `db_reutleib`.`engineer`" + "(`engineer_id`,"
			+ "`first name`," + "`last name`," + "`birthday`," + "`age`," + "`city`," + "`street`," + "`number`)"
			+ "VALUES" + "(?,?,?,?,?,?,?,?);";
	public static final String insert_Project = "INSERT INTO `db_reutleib`.`project`" + "	(`project_number`,"
			+ "			`project_name`," + "		`customer_name`," + "	`start date`," + "	`description`,"
			+ "	`development tools`)" + "	VALUES" + "	(?,?,?,?,?,?);";
	public static final String insert_SoftwareArea = "INSERT INTO `db_reutleib`.`software_area`"
			+ "	 (`area_number`," + "	`name`	," + "		`expertise`)" + "		VALUES" + "		(?,?,?);";

	public static final String insert_DevelopmentStages = "INSERT INTO `db_reutleib`.`development_stages`"
			+ "	(`project_stage_number`," + "				`stage_name`," + "				`tools`)"
			+ "				VALUES" + "				(?,?,?);";
	public static final String insert_projectMilestones = "INSERT INTO `db_reutleib`.`project_milestones`"
			+ "	(`project_milestones_number`," + "				`milestones_number`," + "				`date`,"
			+ "				`submossion`," + "				`amount_of_muny`)" + "				VALUES"
			+ "				(?,?,?,?,?);";
	public static final String insert_phoneNumber = "INSERT INTO `db_reutleib`.`engineer_phone_number`"
			+ "	(`engineer_phone_id`," + "				`phone_number`)" + "				VALUES"
			+ "				(?,?);";
	public static final String insert_grade = "INSERT INTO `db_reutleib`.`grades` "
			+ "	(`projectNumber`,`engineerID`,`grade`) VALUES (?,?,?);";

	// update:
	public static final String update_Engineer = "UPDATE `db_reutleib`.`engineer`" + " SET" + " `engineer_id` = ?,"
			+ " `first name` = ?," + " `last name` = ?," + " `birthday` = ?," + " `age` = ?," + " `city` = ?,"
			+ " `street` = ?," + " `number` = ?" + " WHERE `engineer_id` = ?;";
	public static final String update_Project = "UPDATE `db_reutleib`.`project`" + " SET" + " `project_number` = ?,"
			+ " `project_name` = ?," + " `customer_name` = ?," + " `start date` = ?," + " `description` = ?,"
			+ " `development tools` = ?" + " WHERE `project_number` = ?;";
	public static final String update_SoftwareArea = "UPDATE `db_reutleib`.`software_area`" + " SET"
			+ " `area_number` = ?," + " `expertise` = ?," + " `name` = ?" + " WHERE `area_number` = ?;";
	public static final String update_DevelopmentStages = " UPDATE `db_reutleib`.`development_stages`" + " SET"
			+ " 	`project_stage_number` = ?, " + " 	`stage_name` = ?, " + " 	`tools` = ? "
			+ " 	WHERE `project_stage_number` = ?; ";
	public static final String update_milestones = "UPDATE `db_reutleib`.`project_milestones`" + " SET"
			+ " 	`project_milestones_number` = ?, " + " 	`milestones_number` = ?, " + " 	`date` = ?, "
			+ " 	`submossion` = ?, " + " 	`amount_of_muny` = ? "
			+ " 	WHERE `project_milestones_number` = ? AND `milestones_number` = ?; ";
	public static final String update_workingOn = "UPDATE `db_reutleib`.`working_on` " + " SET "
			+ " `number_project` = ?," + " `id_engineer` = ? " + "WHERE `number_project` = ? AND `id_engineer` = ?;";
	public static final String update_grade = "UPDATE `db_reutleib`.`grades` " + " SET" + " 	`projectNumber` = ?,"
			+ " 	`engineerID` = ?," + " 	`grade` = ?" 
			+ " 	WHERE `projectNumber` = ? AND `engineerID` = ?;";

	// delete:
	public static final String delete_Engineer = "DELETE FROM `db_reutleib`.`engineer`" + " WHERE engineer_id = ?;";

	public static final String delete_Project = "DELETE FROM `db_reutleib`.`project`" + " WHERE project_number = ? ;";

	public static final String delete_SoftwareArea = "DELETE FROM `db_reutleib`.`software_area`"
			+ " WHERE area_number = ? ;";
	public static final String delete_phone = "DELETE FROM `db_reutleib`.`engineer_phone_number` WHERE phone_number = ?; ";

	public static final String delete_phoneById = "DELETE FROM `db_reutleib`.`engineer_phone_number` WHERE engineer_phone_id = ?; ";

	public static final String delete_milestonesTwo = "DELETE FROM `db_reutleib`.`project_milestones`"
			+ " WHERE project_milestones_number = ? AND milestones_number = ?; ";
	public static final String delete_milestonesOne = "DELETE FROM `db_reutleib`.`project_milestones`"
			+ " WHERE project_milestones_number = ?;";
	public static final String delete_DevelopmentStagesOne = "DELETE FROM `db_reutleib`.`development_stages`"
			+ " WHERE project_stage_number = ?; ";
	public static final String delete_DevelopmentStagesTwo = "DELETE FROM `db_reutleib`.`development_stages`"
			+ " WHERE project_stage_number = ? AND stage_number = ?; ";
	public static final String delete_workingAt = "DELETE FROM `db_reutleib`.`working_at`"
			+ " WHERE id_of_engineer = ?;";

	public static final String delete_byArea_workingAt = "DELETE FROM `db_reutleib`.`working_at` " + "WHERE `number-area` = ?;";

	public static final String delete_workingOn = "DELETE FROM `db_reutleib`.`working_on` WHERE id_engineer = ?;";

	// working at + working in:
	public static final String quaryWorkingAt = "INSERT INTO `db_reutleib`.`working_at` " + "(`number-area`, "
			+ " `id_of_engineer`)" + " VALUES" + " (?, " + " ?);";

	public static final String quaryWorkingOn = "INSERT INTO `db_reutleib`.`working_on`" + " (`number_project`,"
			+ " `id_engineer`)" + " VALUES" + " (?,?); ";

	// QUERY:
	// three most interested
	public static final String project_threeMostInterested = "select project_number,project_name , (select sum(amount_of_muny)"
			+ " from project_milestones where project_number = project_milestones_number) "
			+ " as totalMuny from project order by totalMuny DESC LIMIT 3";
	// three least interested
	public static final String project_threeLastInterested = "select project_number,project_name , (select sum(amount_of_muny) from "
			+ " project_milestones where project_number = project_milestones_number) as"
			+ " totalMuny from project order by totalMuny asc LIMIT 3";

	// מה אבני הדרך הצפויים בחודש הקרוב
	public static final String milestones_totalMunyAndSubmission = "select submossion,amount_of_muny from project_milestones where month(`date`) = month(curdate())";
	// וכמה סהכ כסף אמור להתקבל
	public static final String milestones_totalMuny = "select sum(totalMuny) as total from totalMunyOfProjects";
	
	// עבור פרוייקט מסויים - מי המהנדסים העובדים בו
	// nested
	public static final String query_fatchProjectEngineersByArea = "select `number-area`,`engineer_id` from working_at,engineer where exists ("
			+ "			select * from working_on where `number_project` = ? AND `id_engineer` = engineer.engineer_id)"
			+ "			AND (`engineer_id` = `id_of_engineer`) order by `number-area`;";
	// עבור שלב פיתוח מסוייים באילו כלי פיתוח משתמשים
	public static final String query_toolsAtCompany = "select project_stage_number,("
			+ "select project_name from project where project_stage_number = project_number) as project_Name,"
			+ "stage_name,tools from development_stages where stage_name = ?;";
	// busy Engineers:
	// correlated
	public static final String query_busyEngineers = "select distinct id_engineer, (select `first name` from "
			+ " engineer where id_engineer = engineer_id) as firstName,  "
			+ " (select `last name` from engineer where id_engineer = engineer_id) as lastName from working_on ";
	
	// trigger:
	public static final String trigger_gradeMonth = "	CREATE DEFINER=`root`@`localhost` TRIGGER `db_reutleib`.`grades_BEFORE_INSERT` BEFORE INSERT ON `grades` FOR EACH ROW"
			+ "	BEGIN " + "		SET new.month = month(curdate());" + "		END";

	public static final String dropTrigger = "DROP TRIGGER IF EXISTS `db_reutleib`.`grades_BEFORE_INSERT`;\n";

	public static final String selectFrom = "select * from ";
}
