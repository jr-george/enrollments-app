DELIMITER $$

CREATE PROCEDURE InsertStudent (
    IN p_Name VARCHAR(100),
    IN p_Age INT,
    IN p_Major VARCHAR(50),
    IN p_GPA DECIMAL(3,2),
    OUT p_NewStudentID INT
)
BEGIN
INSERT INTO Students (Name, Age, Major, GPA)
VALUES (p_Name, p_Age, p_Major, p_GPA);

SET p_NewStudentID = LAST_INSERT_ID();
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE GetStudentCourseEnrollments (
    IN p_Limit INT,
    IN p_Offset INT,
    OUT p_RecordCount INT
)
BEGIN
    -- Devolver los resultados paginados
SELECT
    s.StudentID,
    s.Name AS StudentName,
    s.Age,
    s.Major,
    s.GPA,
    c.CourseID,
    c.CourseName,
    c.Department,
    c.Credits,
    e.EnrollmentDate
FROM Enrollments e
         INNER JOIN Students s ON e.StudentID = s.StudentID
         INNER JOIN Courses c ON e.CourseID = c.CourseID
ORDER BY s.StudentID, e.EnrollmentDate
    LIMIT p_Limit OFFSET p_Offset;

-- Total de registros sin paginación
SELECT COUNT(*) INTO p_RecordCount
FROM Enrollments;
END $$

DELIMITER ;
