CREATE TABLE departamento (
    idDept INT AUTO_INCREMENT,          
    nombreDept VARCHAR(255) UNIQUE,    
    PRIMARY KEY (idDept)             
);
CREATE TABLE empleado (
    idEmpleado INT AUTO_INCREMENT,       
    rut int not null,            
    nombreEmpleado varchar(40) not null,
    appaterno varchar(40) not null,
    apmaterno varchar(40),
    fechanac DATE ,
    fechaContrato DATE ,
    sueldo INT not null,                     
    nombreDept VARCHAR(255),           
    PRIMARY KEY (idEmpleado),           
    CONSTRAINT fk_nombreDept FOREIGN KEY (nombreDept) 
        REFERENCES departamento(nombreDept)   
);