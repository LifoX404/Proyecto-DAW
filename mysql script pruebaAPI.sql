-- Cambiar a la base de datos master
USE master;

-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS pruebaAPI;

-- Crear la base de datos
CREATE DATABASE pruebaAPI;

-- Cambiar a la base de datos recién creada
USE pruebaAPI;


-- Crear la tabla instructors
CREATE TABLE instructors (
    id INT PRIMARY KEY,
    full_name VARCHAR(100),
    email VARCHAR(100),
    specialty VARCHAR(100)
);

-- Crear la tabla trainings
CREATE TABLE trainings (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    start_date DATE,
    end_date DATE,
    modality VARCHAR(50), -- On-site, Online, Hybrid
    status VARCHAR(20) -- Planned, Ongoing, Completed
);

-- Crear la tabla sessions
CREATE TABLE sessions (
    id INT PRIMARY KEY,
    training_id INT,
    session_date DATE,
    start_time TIME,
    end_time TIME,
    topic VARCHAR(150),
    instructor_id INT,
    FOREIGN KEY (training_id) REFERENCES trainings(id),
    FOREIGN KEY (instructor_id) REFERENCES instructors(id)
);

-- Crear la tabla participants
CREATE TABLE participants (
    id INT PRIMARY KEY,
    full_name VARCHAR(100),
    email VARCHAR(100),
    department VARCHAR(100),
    position VARCHAR(100)
);

-- Crear la tabla attendance
CREATE TABLE attendance (
    id INT PRIMARY KEY,
    session_id INT,
    participant_id INT,
    attended TINYINT(1), -- Usar TINYINT para representar BIT
    FOREIGN KEY (session_id) REFERENCES sessions(id),
    FOREIGN KEY (participant_id) REFERENCES participants(id)
);

-- Crear la tabla Employee
CREATE TABLE Employee (
    idEmployee BIGINT PRIMARY KEY,
    firstName VARCHAR(20)
);

-- Crear la tabla de KPI
CREATE TABLE KPI (
    idKpi BIGINT PRIMARY KEY AUTO_INCREMENT, -- Generar ID automáticamente
    name VARCHAR(20) NOT NULL,
    description VARCHAR(150) NOT NULL,
    category VARCHAR(20) NOT NULL,
    unit VARCHAR(20) NOT NULL,
    unitValue DECIMAL(10,2) NOT NULL,
    statusKpi TINYINT(1) NOT NULL DEFAULT 1 -- Activo por defecto
);

-- Crear la tabla employee_kpi
CREATE TABLE employee_kpi (
    idEmployeeKpi BIGINT PRIMARY KEY AUTO_INCREMENT,
    idEmployee BIGINT,
    idKpi BIGINT NOT NULL,
    recordedDate DATETIME NOT NULL,
    value DECIMAL(10,2) NOT NULL,
    statusEmployeeKpi TINYINT(1) DEFAULT 1,
    FOREIGN KEY (idEmployee) REFERENCES Employee(idEmployee),
    FOREIGN KEY (idKpi) REFERENCES KPI(idKpi)
);

-- Crear la tabla de Records
CREATE TABLE Achievements (
    idAchievement BIGINT PRIMARY KEY AUTO_INCREMENT, -- ID único para cada logro
    idEmployee BIGINT NOT NULL, -- FK hacia la tabla Employees
    achievementDate datetime NOT NULL default current_timestamp, -- Fecha en que se alcanzó el logro
    category VARCHAR(50) NOT NULL, -- Categoría del logro
    description VARCHAR(255) NOT NULL, -- Descripción detallada del logro
    statusAchievement TINYINT(1) NOT NULL DEFAULT 1, -- Activo (1) o archivado (0)
    FOREIGN KEY (idEmployee) REFERENCES Employee(idEmployee)
);

-- Crear la tabla Feedback
CREATE TABLE Feedback (
    idFeedback BIGINT PRIMARY KEY AUTO_INCREMENT,
    idEmployee BIGINT NOT NULL,
    feedbackDate datetime NOT NULL default current_timestamp(),
    feedbackBy BIGINT NOT NULL,  -- FK hacia la tabla Employees que da la retroalimentación
    feedbackType ENUM('Positiva', 'Constructiva') NOT NULL,  -- Tipo de retroalimentación
    feedbackContent TEXT,  -- Contenido de la retroalimentación
    FOREIGN KEY (idEmployee) REFERENCES Employee(idEmployee),
    FOREIGN KEY (feedbackGivenBy) REFERENCES Employee(idEmployee)
);