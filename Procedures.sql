CREATE PROCEDURE usp_delete_student_sp
@student_id char(4)
AS
DELETE 
FROM STUDENT
WHERE STUDENT_ID = @student_id

CREATE PROCEDURE usp_delete_student
@student_id char(4)
AS
DELETE 
FROM STUDENT
WHERE STUDENT_ID = @student_id
DELETE 
FROM ENROLLMENT
WHERE STUDENT_ID = @student_id;



CREATE PROCEDURE usp_delete_teacher
@teacher_id char(4)
AS
DELETE
FROM TEACHER
WHERE TEACHER_ID = @teacher_id
DELETE
FROM COURSES
WHERE TEACHER_ID = @teacher_id;

CREATE PROCEDURE usp_delete_courses
@course_id char(4)
AS
DELETE
FROM COURSES
WHERE COURSE_ID = @course_id
DELETE
FROM ENROLLMENT
WHERE COURSE_ID = @course_id;

CREATE PROCEDURE usp_delete_enrollment
@enrollment_id char(10)
AS
DELETE 
FROM ENROLLMENT
WHERE ENROLLMENT_ID = @enrollment_id

CREATE PROCEDURE usp_update_course_name
@name char(20),
@course_id char(4)
AS
UPDATE COURSES
SET NAME = @name
WHERE COURSE_ID = @course_id;

CREATE PROCEDURE usp_chg_course_department
@department char(20),
@course_id char(4)
AS
UPDATE COURSES
SET DEPARTMENT = @department
WHERE COURSE_ID = @course_id;

CREATE PROCEDURE usp_update_course_description
@description char(30),
@course_id char(4)
AS
UPDATE COURSES
SET DESCRIPTION = @description
WHERE COURSE_ID = @course_id;


CREATE PROCEDURE usp_update_course_teacher_id
@teacher_id char(4),
@course_id char(4)
AS
UPDATE COURSES
SET TEACHER_ID = @teacher_id
WHERE COURSE_ID = @course_id;
UPDATE ENROLLMENT
SET TEACHER_ID = @teacher_id
WHERE COURSE_ID = @course_id;

CREATE PROCEDURE usp_chg_teacher_last_name
@last_name char(15),
@teacher_id char(4)
AS
UPDATE TEACHER
SET LAST_NAME = @last_name
WHERE TEACHER_ID = @teacher_id;

CREATE PROCEDURE usp_chg_teacher_first_name
@first_name char(15),
@teacher_id char(4)
AS
UPDATE TEACHER
SET FIRST_NAME = @first_name
WHERE TEACHER_ID = @teacher_id;

CREATE PROCEDURE usp_chg_teacher_address
@address char(20),
@teacher_id char(4)
AS
UPDATE TEACHER
SET ADDRESS = @address
WHERE TEACHER_ID = @teacher_id;

CREATE PROCEDURE usp_chg_teacher_state
@state char(2),
@teacher_id char(4)
AS
UPDATE TEACHER
SET STATE = @state
WHERE TEACHER_ID = @teacher_id;

CREATE PROCEDURE usp_chg_teacher_email
@email char(20),
@teacher_id char(4)
AS
UPDATE TEACHER
SET EMAIL = @email
WHERE TEACHER_ID = @teacher_id;


CREATE PROCEDURE usp_chg_teacher_phone
@phone char(10),
@teacher_id char(4)
AS
UPDATE TEACHER
SET PHONE = @phone
WHERE TEACHER_ID = @teacher_id;

CREATE PROCEDURE usp_insert_student
@student_id char(4),
@last_name char(20),
@first_name char(20),
@address char(20),
@state char(2),
@phone char(10),
@average_grade char(3)
AS
INSERT INTO STUDENT
VALUES(@student_id, @last_name, @first_name, @address, @state, @phone, @average_grade);



CREATE PROCEDURE usp_insert_teacher
@teacher_id char(4),
@last_name char(20),
@first_name char(20),
@address char(20),
@state char(2),
@email char(20),
@phone char(10)
AS
INSERT INTO TEACHER
VALUES(@teacher_id, @last_name, @first_name, @address, @state, @email, @phone);

CREATE PROCEDURE usp_insert_courses
@course_id char(4),
@name char(20),
@department char(20),
@description char(30),
@teacher_id char(4)
AS
INSERT INTO COURSES
VALUES(@course_id, @name, @department, @description, @teacher_id);

CREATE PROCEDURE usp_insert_enrollment
@enrollment_id char(10),
@student_id char(4),
@course_id char(4),
@teacher_id char(4)
AS
INSERT INTO ENROLLMENT
VALUES(@enrollment_id,@student_id, @course_id, @teacher_id);
