CREATE TABLE Courses (
                         CourseID INT PRIMARY KEY AUTO_INCREMENT,
                         CourseName VARCHAR(100) NOT NULL,
                         Department VARCHAR(50),
                         Credits INT CHECK (Credits > 0) -- Ensuring credit hours are positive
);

CREATE TABLE Students (
                          StudentID INT PRIMARY KEY AUTO_INCREMENT,
                          Name VARCHAR(100) NOT NULL,
                          Age INT,
                          Major VARCHAR(50),
                          GPA DECIMAL(3,2)
);

CREATE TABLE Enrollments (
                             EnrollmentID INT PRIMARY KEY AUTO_INCREMENT,
                             StudentID INT,
                             CourseID INT,
                             EnrollmentDate DATE NOT NULL,
                             FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
                             FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);