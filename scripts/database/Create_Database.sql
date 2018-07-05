CREATE TABLE "user" (UUID varchar(30) NOT NULL, UserName varchar(20) NOT NULL UNIQUE, IconUrl varchar(255), FirstName varchar(50), LastName varchar(50) NOT NULL, Email varchar(50) NOT NULL UNIQUE, GeneralTaCAccepted bool NOT NULL, DeveloperTaCAccepted bool NOT NULL, Active bool NOT NULL, CreatedAt date NOT NULL, Company varchar(20), GeneralInfo varchar(500), PCLoginToken varchar(100) NOT NULL, PRIMARY KEY (UUID));
CREATE TABLE App (id BIGSERIAL NOT NULL, UserUUID varchar(30) NOT NULL, Name varchar(100) NOT NULL, IconUrl varchar(255), Description varchar(1000), Price numeric(10, 2) NOT NULL, Active bool NOT NULL, Version varchar(20) NOT NULL, WhatIsNew varchar(500), LastUpdate date NOT NULL, NumberOfDownloads int4 NOT NULL, Certified bool NOT NULL, PRIMARY KEY (id), CONSTRAINT AppName UNIQUE (UserUUID, Name));
CREATE TABLE Rating (AppId int8 NOT NULL, UserUUID varchar(30) NOT NULL, RatingValue int2 NOT NULL, Review varchar(1000), "Date" date NOT NULL, CONSTRAINT Const_AppAttribute_1 UNIQUE (AppId, UserUUID));
COMMENT ON COLUMN Rating.RatingValue IS 'Stars. 0 - 5';
CREATE TABLE QAConversation (Id BIGSERIAL NOT NULL, AppId int8 NOT NULL, PRIMARY KEY (Id));
CREATE TABLE QuestionAnswer (QAConversationId int8 NOT NULL, UserUUID varchar(30) NOT NULL, Type varchar(12) NOT NULL, Text varchar(1000) NOT NULL, "Date" date NOT NULL);
CREATE TABLE AppAttachment (AppId int8 NOT NULL, LocationUrl varchar(255) NOT NULL, Description varchar(255), Type int2 NOT NULL);
COMMENT ON COLUMN AppAttachment.Type IS 'Possible Values:
- TechnicalDocument (=1)
- Picture/Video/Usecase (=2)
- Binary (=3)';
CREATE TABLE Device (UUID varchar(30) NOT NULL, DeviceTypeId int8 NOT NULL, Name varchar(50) NOT NULL, IconUrl varchar(255), Description varchar(100), Model varchar(20) NOT NULL, PRIMARY KEY (UUID));
CREATE TABLE UserDevice (UserUUID varchar(30) NOT NULL, DeviceUUID varchar(30) NOT NULL, PRIMARY KEY (UserUUID, DeviceUUID));
CREATE TABLE "order" (Id BIGSERIAL NOT NULL, AppId int8 NOT NULL, BuyerUUID varchar(30) NOT NULL, OrderNumber int8 NOT NULL UNIQUE, OrderDate date NOT NULL, UnitPrice numeric(10, 2) NOT NULL, Amount int4 NOT NULL, Description varchar(500) NOT NULL, TotalPrice numeric(10, 2) NOT NULL, PRIMARY KEY (Id));
CREATE TABLE BillingAddres (UserUUID varchar(30) NOT NULL, Country varchar(30) NOT NULL, City varchar(30) NOT NULL, PostalCode varchar(10) NOT NULL, Street varchar(30) NOT NULL, Region varchar(30) NOT NULL);
CREATE TABLE TechnicalDetails (AppId int8 NOT NULL, AttributeName varchar(100) NOT NULL, AttributeValue varchar(100) NOT NULL);
CREATE TABLE AppLicense (AppId int8 NOT NULL, DeviceUUID varchar(30), Version varchar(10) NOT NULL, Status int2 NOT NULL, UpdateAvailable bool NOT NULL);
COMMENT ON COLUMN AppLicense.Status IS 'Possible values:
- Uninstalled (=0)
- Installing (=1)
- Installed (=2)
- Uninstalling (=3)
- Installed (Free Trial) (=4)
- Expired (Free Trial) (=5)';
CREATE TABLE Role (id BIGSERIAL NOT NULL, Name varchar(20), PRIMARY KEY (id));
CREATE TABLE User_Role (UserUUID varchar(30) NOT NULL, RoleId int8 NOT NULL, PRIMARY KEY (UserUUID, RoleId));
CREATE TABLE DeviceType (Id BIGSERIAL NOT NULL, Name varchar(20), PRIMARY KEY (Id));
CREATE TABLE DeviceType_App (DeviceTypeId int8 NOT NULL, AppId int8 NOT NULL, PRIMARY KEY (DeviceTypeId, AppId));
ALTER TABLE Rating ADD CONSTRAINT FKRating454146 FOREIGN KEY (AppId) REFERENCES App (id);
ALTER TABLE QAConversation ADD CONSTRAINT FKQAConversa118783 FOREIGN KEY (AppId) REFERENCES App (id);
ALTER TABLE AppAttachment ADD CONSTRAINT FKAppAttachm693886 FOREIGN KEY (AppId) REFERENCES App (id);
ALTER TABLE QuestionAnswer ADD CONSTRAINT FKQuestionAn637332 FOREIGN KEY (UserUUID) REFERENCES "user" (UUID);
ALTER TABLE QuestionAnswer ADD CONSTRAINT FKQuestionAn287605 FOREIGN KEY (QAConversationId) REFERENCES QAConversation (Id);
ALTER TABLE UserDevice ADD CONSTRAINT FKUserDevice569967 FOREIGN KEY (DeviceUUID) REFERENCES Device (UUID);
ALTER TABLE UserDevice ADD CONSTRAINT FKUserDevice111128 FOREIGN KEY (UserUUID) REFERENCES "user" (UUID);
ALTER TABLE App ADD CONSTRAINT FKApp836197 FOREIGN KEY (UserUUID) REFERENCES "user" (UUID);
ALTER TABLE "order" ADD CONSTRAINT FKOrder391350 FOREIGN KEY (BuyerUUID) REFERENCES "user" (UUID);
ALTER TABLE "order" ADD CONSTRAINT FKOrder998673 FOREIGN KEY (AppId) REFERENCES App (id);
ALTER TABLE Rating ADD CONSTRAINT FKRating801785 FOREIGN KEY (UserUUID) REFERENCES "user" (UUID);
ALTER TABLE TechnicalDetails ADD CONSTRAINT FKTechnicalD509142 FOREIGN KEY (AppId) REFERENCES App (id);
ALTER TABLE BillingAddres ADD CONSTRAINT FKBillingAdd996485 FOREIGN KEY (UserUUID) REFERENCES "user" (UUID);
ALTER TABLE AppLicense ADD CONSTRAINT FKAppLicense696338 FOREIGN KEY (AppId) REFERENCES App (id);
ALTER TABLE AppLicense ADD CONSTRAINT U FOREIGN KEY (DeviceUUID) REFERENCES Device (UUID);
ALTER TABLE User_Role ADD CONSTRAINT FKUser_Role925783 FOREIGN KEY (UserUUID) REFERENCES "user" (UUID);
ALTER TABLE User_Role ADD CONSTRAINT FKUser_Role496771 FOREIGN KEY (Roleid) REFERENCES Role (id);
ALTER TABLE Device ADD CONSTRAINT FKDevice196739 FOREIGN KEY (DeviceTypeId) REFERENCES DeviceType (Id);
ALTER TABLE DeviceType_App ADD CONSTRAINT FKDeviceType810395 FOREIGN KEY (DeviceTypeId) REFERENCES DeviceType (Id);
ALTER TABLE DeviceType_App ADD CONSTRAINT FKDeviceType740190 FOREIGN KEY (AppId) REFERENCES App (id);
