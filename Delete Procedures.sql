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
WHERE TEACHER_ID = @teacher_id
DELETE 
FROM ENROLLMENT
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

