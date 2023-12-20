USE master;
GO

IF NOT EXISTS (SELECT 1 FROM sys.databases WHERE name = 'Mangment_Clinc_Sysyem')
BEGIN
    CREATE DATABASE Mangment_Clinc_Sysyem
    ON
    (
        NAME = Datafile,
        FILENAME = 'D:\Project\Datafile.mdf',
        SIZE = 10,
        MAXSIZE = 500,
        FILEGROWTH = 10
    )
    LOG ON
    (
        NAME = system_log,
        FILENAME = 'D:\Project\systemlog.ldf',
        SIZE = 10,
        MAXSIZE = 500,
        FILEGROWTH = 10
    );
END
GO

-- Use the created database
USE master;
GO

-- Check if the 'patients' table exists; if not, create it
IF NOT EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'patients')
BEGIN
    CREATE TABLE patients (
        SSN VARCHAR(14) NOT NULL,
        firstname VARCHAR(20) NOT NULL,
        secondname VARCHAR(20) NOT NULL,
        phone VARCHAR(20) NOT NULL UNIQUE,
        CONSTRAINT Patient_SSN_pk PRIMARY KEY (SSN)
    );
END
GO
create table reports(
	report_id int not null identity (1,1)  , 
	SSN varchar(14) not null , 
	doctor_id int not null ,
    constraint report_id_pk primary key (report_id)
);
create table medcine_reports(
	report_id int not null   , 
	medicines varchar(20) not null  ,
    constraint report_medcine_pk primary key (report_id , medicines)
);
create table doctors (
	doctor_id int not null identity (1,1)  ,
	dep_id int not null , 
	firstname varchar(20) not null  , 
	secondname varchar(20) not null  ,
	specialization varchar(20) not null  ,
    constraint doctor_id_pk primary key (doctor_id)
);

create table appoiment(
    app_id int not null identity (1,1)  , 
	SSN varchar(14) not null ,  
	datatime date not null  , 
	price  decimal not null , 
    constraint appoiment_id_pk primary key (app_id)
);
create table department (
    dep_id int not null identity (1,1)  , 
	dep_name varchar(20) not null unique   , 
	midical varchar(20) not null  ,
    constraint department_id_pk primary key ( dep_id)
);
create table assigned(
    app_id int not null   ,
    doc_id int not null   , 
	SSN varchar(14) not null ,  
	datatime date not null  ,  
    constraint assigned_pk primary key (app_id ,doc_id ,SSN)
);
alter table patients
add constraint check_len check(len(SSN)=14) 
alter table reports
add constraint doc_fk foreign key (doctor_id) references doctors(doctor_id)

alter table reports
add constraint patient_fk foreign key (SSN) references patients(SSN)

alter table medcine_reports
add constraint medcine_reports_fk foreign key (report_id) references reports(report_id)

alter table doctors
add constraint dep_fk foreign key (dep_id) references department(dep_id)

alter table appoiment
add constraint patient_appoiment_fk foreign key (SSN) references patients(SSN)

alter table assigned
add constraint patient_assigned_fk foreign key (SSN) references patients(SSN)
alter table assigned
add constraint doc_assigned_fk foreign key (doc_id) references doctors(doctor_id)
alter table assigned
add constraint app_assigned_fk foreign key (app_id) references appoiment(app_id)