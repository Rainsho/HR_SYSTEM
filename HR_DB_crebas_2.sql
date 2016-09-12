/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2000                    */
/* Created on:     2016/9/12 17:15:07                           */
/*==============================================================*/


if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Attendance') and o.name = 'FK_ATTENDAN_RELATIONS_ATTMARK')
alter table Attendance
   drop constraint FK_ATTENDAN_RELATIONS_ATTMARK
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Attendance') and o.name = 'FK_ATTENDAN_RELATIONS_EMPLOYEE')
alter table Attendance
   drop constraint FK_ATTENDAN_RELATIONS_EMPLOYEE
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Candidates') and o.name = 'FK_CANDIDAT_RELATIONS_RECRUITM')
alter table Candidates
   drop constraint FK_CANDIDAT_RELATIONS_RECRUITM
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Contract') and o.name = 'FK_CONTRACT_RELATIONS_EMPLOYEE')
alter table Contract
   drop constraint FK_CONTRACT_RELATIONS_EMPLOYEE
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Employee') and o.name = 'FK_EMPLOYEE_RELATIONS_DEPARTME')
alter table Employee
   drop constraint FK_EMPLOYEE_RELATIONS_DEPARTME
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Employee') and o.name = 'FK_EMPLOYEE_RELATIONS_RANK')
alter table Employee
   drop constraint FK_EMPLOYEE_RELATIONS_RANK
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Employee') and o.name = 'FK_EMPLOYEE_RELATIONS_PERMISSI')
alter table Employee
   drop constraint FK_EMPLOYEE_RELATIONS_PERMISSI
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Info') and o.name = 'FK_INFO_RELATIONS_EMPLOYEE')
alter table Info
   drop constraint FK_INFO_RELATIONS_EMPLOYEE
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('RecruitmentInfo') and o.name = 'FK_RECRUITM_RELATIONS_DEPARTME')
alter table RecruitmentInfo
   drop constraint FK_RECRUITM_RELATIONS_DEPARTME
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('RecruitmentInfo') and o.name = 'FK_RECRUITM_RELATIONS_RANK')
alter table RecruitmentInfo
   drop constraint FK_RECRUITM_RELATIONS_RANK
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Salary') and o.name = 'FK_SALARY_RELATIONS_APPLYSTA')
alter table Salary
   drop constraint FK_SALARY_RELATIONS_APPLYSTA
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Salary') and o.name = 'FK_SALARY_RELATIONS_EMPLOYEE')
alter table Salary
   drop constraint FK_SALARY_RELATIONS_EMPLOYEE
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingApply') and o.name = 'FK_TRAINING_RELATIONS_TRAINING6')
alter table TrainingApply
   drop constraint FK_TRAINING_RELATIONS_TRAINING6
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingApply') and o.name = 'FK_TRAINING_RELATIONS_APPLYSTA')
alter table TrainingApply
   drop constraint FK_TRAINING_RELATIONS_APPLYSTA
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingApply') and o.name = 'FK_TRAINING_RELATIONS_EMPLOYEE1')
alter table TrainingApply
   drop constraint FK_TRAINING_RELATIONS_EMPLOYEE1
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingEvaluate') and o.name = 'FK_TRAINING_RELATIONS_TRAINING5')
alter table TrainingEvaluate
   drop constraint FK_TRAINING_RELATIONS_TRAINING5
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingEvaluate') and o.name = 'FK_TRAINING_RELATIONS_EMPLOYEE4')
alter table TrainingEvaluate
   drop constraint FK_TRAINING_RELATIONS_EMPLOYEE4
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingFeedback') and o.name = 'FK_TRAINING_RELATIONS_TRAINING3')
alter table TrainingFeedback
   drop constraint FK_TRAINING_RELATIONS_TRAINING3
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingFeedback') and o.name = 'FK_TRAINING_RELATIONS_EMPLOYEE2')
alter table TrainingFeedback
   drop constraint FK_TRAINING_RELATIONS_EMPLOYEE2
go

if exists (select 1
   from dbo.sysreferences r join dbo.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('TrainingPlan') and o.name = 'FK_TRAINING_RELATIONS_DEPARTME')
alter table TrainingPlan
   drop constraint FK_TRAINING_RELATIONS_DEPARTME
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ApplyState')
            and   type = 'U')
   drop table ApplyState
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AttMark')
            and   type = 'U')
   drop table AttMark
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Attendance')
            and   name  = 'Attendance_FK2'
            and   indid > 0
            and   indid < 255)
   drop index Attendance.Attendance_FK2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Attendance')
            and   name  = 'Attendance_FK'
            and   indid > 0
            and   indid < 255)
   drop index Attendance.Attendance_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Attendance')
            and   type = 'U')
   drop table Attendance
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Candidates')
            and   name  = 'Candidates_FK'
            and   indid > 0
            and   indid < 255)
   drop index Candidates.Candidates_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Candidates')
            and   type = 'U')
   drop table Candidates
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Contract')
            and   name  = 'Contract_FK'
            and   indid > 0
            and   indid < 255)
   drop index Contract.Contract_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Contract')
            and   type = 'U')
   drop table Contract
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Department')
            and   type = 'U')
   drop table Department
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Employee')
            and   name  = 'Employee_FK3'
            and   indid > 0
            and   indid < 255)
   drop index Employee.Employee_FK3
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Employee')
            and   name  = 'Employee_FK2'
            and   indid > 0
            and   indid < 255)
   drop index Employee.Employee_FK2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Employee')
            and   name  = 'Employee_FK'
            and   indid > 0
            and   indid < 255)
   drop index Employee.Employee_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Employee')
            and   type = 'U')
   drop table Employee
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Info')
            and   name  = 'Info_FK'
            and   indid > 0
            and   indid < 255)
   drop index Info.Info_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Info')
            and   type = 'U')
   drop table Info
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Permission')
            and   type = 'U')
   drop table Permission
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Rank')
            and   type = 'U')
   drop table Rank
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('RecruitmentInfo')
            and   name  = 'RecruitmentInfo_FK2'
            and   indid > 0
            and   indid < 255)
   drop index RecruitmentInfo.RecruitmentInfo_FK2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('RecruitmentInfo')
            and   name  = 'RecruitmentInfo_FK'
            and   indid > 0
            and   indid < 255)
   drop index RecruitmentInfo.RecruitmentInfo_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('RecruitmentInfo')
            and   type = 'U')
   drop table RecruitmentInfo
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Salary')
            and   name  = 'Salary_FK2'
            and   indid > 0
            and   indid < 255)
   drop index Salary.Salary_FK2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('Salary')
            and   name  = 'Salary_FK'
            and   indid > 0
            and   indid < 255)
   drop index Salary.Salary_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Salary')
            and   type = 'U')
   drop table Salary
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingApply')
            and   name  = 'TrainingApply_FK3'
            and   indid > 0
            and   indid < 255)
   drop index TrainingApply.TrainingApply_FK3
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingApply')
            and   name  = 'TrainingApply_FK2'
            and   indid > 0
            and   indid < 255)
   drop index TrainingApply.TrainingApply_FK2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingApply')
            and   name  = 'TrainingApply_FK'
            and   indid > 0
            and   indid < 255)
   drop index TrainingApply.TrainingApply_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TrainingApply')
            and   type = 'U')
   drop table TrainingApply
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingEvaluate')
            and   name  = 'TrainingEvaluate_FK2'
            and   indid > 0
            and   indid < 255)
   drop index TrainingEvaluate.TrainingEvaluate_FK2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingEvaluate')
            and   name  = 'TrainingEvaluate_FK'
            and   indid > 0
            and   indid < 255)
   drop index TrainingEvaluate.TrainingEvaluate_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TrainingEvaluate')
            and   type = 'U')
   drop table TrainingEvaluate
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingFeedback')
            and   name  = 'TrainingFeedback_FK2'
            and   indid > 0
            and   indid < 255)
   drop index TrainingFeedback.TrainingFeedback_FK2
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingFeedback')
            and   name  = 'TrainingFeedback_FK'
            and   indid > 0
            and   indid < 255)
   drop index TrainingFeedback.TrainingFeedback_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TrainingFeedback')
            and   type = 'U')
   drop table TrainingFeedback
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('TrainingPlan')
            and   name  = 'TrainingPlan_FK'
            and   indid > 0
            and   indid < 255)
   drop index TrainingPlan.TrainingPlan_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TrainingPlan')
            and   type = 'U')
   drop table TrainingPlan
go

/*==============================================================*/
/* Table: ApplyState                                            */
/*==============================================================*/
create table ApplyState (
   AppID                int                  identity,
   AppName              varchar(50)          not null,
   constraint PK_APPLYSTATE primary key nonclustered (AppID)
)
go

/*==============================================================*/
/* Table: AttMark                                               */
/*==============================================================*/
create table AttMark (
   AttMarkID            int                  identity,
   AttMark              varchar(50)          not null,
   constraint PK_ATTMARK primary key nonclustered (AttMarkID)
)
go

/*==============================================================*/
/* Table: Attendance                                            */
/*==============================================================*/
create table Attendance (
   AttID                int                  identity,
   AttMarkID            int                  null,
   UID                  int                  null,
   AttTime              datetime             not null,
   constraint PK_ATTENDANCE primary key nonclustered (AttID)
)
go

/*==============================================================*/
/* Index: Attendance_FK                                         */
/*==============================================================*/
create index Attendance_FK on Attendance (
AttMarkID ASC
)
go

/*==============================================================*/
/* Index: Attendance_FK2                                        */
/*==============================================================*/
create index Attendance_FK2 on Attendance (
UID ASC
)
go

/*==============================================================*/
/* Table: Candidates                                            */
/*==============================================================*/
create table Candidates (
   CanID                int                  identity,
   RecID                int                  null,
   CanName              varchar(50)          not null,
   CanTelphone          varchar(50)          not null,
   CanInfo              varchar(1000)        not null,
   constraint PK_CANDIDATES primary key nonclustered (CanID)
)
go

/*==============================================================*/
/* Index: Candidates_FK                                         */
/*==============================================================*/
create index Candidates_FK on Candidates (
RecID ASC
)
go

/*==============================================================*/
/* Table: Contract                                              */
/*==============================================================*/
create table Contract (
   ConID                int                  identity,
   UID                  int                  null,
   ConName              varchar(50)          not null,
   ConDate              datetime             not null,
   ConYear              int                  not null,
   ConType              varchar(50)          not null,
   ConInfo              varchar(1000)        not null,
   constraint PK_CONTRACT primary key nonclustered (ConID)
)
go

/*==============================================================*/
/* Index: Contract_FK                                           */
/*==============================================================*/
create index Contract_FK on Contract (
UID ASC
)
go

/*==============================================================*/
/* Table: Department                                            */
/*==============================================================*/
create table Department (
   DepID                int                  identity,
   DepName              varchar(50)          not null,
   constraint PK_DEPARTMENT primary key nonclustered (DepID)
)
go

/*==============================================================*/
/* Table: Employee                                              */
/*==============================================================*/
create table Employee (
   UID                  int                  identity,
   DepID                int                  null,
   RankID               int                  null,
   PerID                int                  null,
   UName                varchar(50)          not null,
   UPassword            varchar(50)          not null,
   UGender              varchar(50)          not null,
   UTelphone            varchar(50)          not null,
   constraint PK_EMPLOYEE primary key nonclustered (UID)
)
go

/*==============================================================*/
/* Index: Employee_FK                                           */
/*==============================================================*/
create index Employee_FK on Employee (
DepID ASC
)
go

/*==============================================================*/
/* Index: Employee_FK2                                          */
/*==============================================================*/
create index Employee_FK2 on Employee (
RankID ASC
)
go

/*==============================================================*/
/* Index: Employee_FK3                                          */
/*==============================================================*/
create index Employee_FK3 on Employee (
PerID ASC
)
go

/*==============================================================*/
/* Table: Info                                                  */
/*==============================================================*/
create table Info (
   InfoID               int                  identity,
   UID                  int                  null,
   InfoTitle            varchar(200)         not null,
   InfoContent          varchar(1000)        not null,
   InfoDate             datetime             not null,
   constraint PK_INFO primary key nonclustered (InfoID)
)
go

/*==============================================================*/
/* Index: Info_FK                                               */
/*==============================================================*/
create index Info_FK on Info (
UID ASC
)
go

/*==============================================================*/
/* Table: Permission                                            */
/*==============================================================*/
create table Permission (
   PerID                int                  identity,
   PerName              varchar(50)          not null,
   constraint PK_PERMISSION primary key nonclustered (PerID)
)
go

/*==============================================================*/
/* Table: Rank                                                  */
/*==============================================================*/
create table Rank (
   RankID               int                  identity,
   RankName             varchar(50)          not null,
   constraint PK_RANK primary key nonclustered (RankID)
)
go

/*==============================================================*/
/* Table: RecruitmentInfo                                       */
/*==============================================================*/
create table RecruitmentInfo (
   RecID                int                  identity,
   DepID                int                  null,
   RankID               int                  null,
   RecName              varchar(50)          not null,
   RecQuant             int                  not null,
   RecStartDate         datetime             not null,
   RecStopDate          datetime             null,
   RecInfo              varchar(1000)        null,
   constraint PK_RECRUITMENTINFO primary key nonclustered (RecID)
)
go

/*==============================================================*/
/* Index: RecruitmentInfo_FK                                    */
/*==============================================================*/
create index RecruitmentInfo_FK on RecruitmentInfo (
DepID ASC
)
go

/*==============================================================*/
/* Index: RecruitmentInfo_FK2                                   */
/*==============================================================*/
create index RecruitmentInfo_FK2 on RecruitmentInfo (
RankID ASC
)
go

/*==============================================================*/
/* Table: Salary                                                */
/*==============================================================*/
create table Salary (
   SalID                int                  identity,
   UID                  int                  null,
   AppID                int                  null,
   SalBasic             int                  not null,
   SalHouse             int                  not null,
   SalOld               int                  not null,
   SalHealth            int                  not null,
   SalEmp               int                  not null,
   SalRefund            int                  not null,
   SalPerformance       int                  not null,
   SalDate              datetime             not null,
   constraint PK_SALARY primary key nonclustered (SalID)
)
go

/*==============================================================*/
/* Index: Salary_FK                                             */
/*==============================================================*/
create index Salary_FK on Salary (
UID ASC
)
go

/*==============================================================*/
/* Index: Salary_FK2                                            */
/*==============================================================*/
create index Salary_FK2 on Salary (
AppID ASC
)
go

/*==============================================================*/
/* Table: TrainingApply                                         */
/*==============================================================*/
create table TrainingApply (
   TraID                int                  identity,
   UID                  int                  null,
   TrpID                int                  null,
   AppID                int                  null,
   constraint PK_TRAININGAPPLY primary key nonclustered (TraID)
)
go

/*==============================================================*/
/* Index: TrainingApply_FK                                      */
/*==============================================================*/
create index TrainingApply_FK on TrainingApply (
UID ASC
)
go

/*==============================================================*/
/* Index: TrainingApply_FK2                                     */
/*==============================================================*/
create index TrainingApply_FK2 on TrainingApply (
TrpID ASC
)
go

/*==============================================================*/
/* Index: TrainingApply_FK3                                     */
/*==============================================================*/
create index TrainingApply_FK3 on TrainingApply (
AppID ASC
)
go

/*==============================================================*/
/* Table: TrainingEvaluate                                      */
/*==============================================================*/
create table TrainingEvaluate (
   TreID                int                  identity,
   UID                  int                  null,
   TrpID                int                  null,
   TreText              varchar(1000)        not null,
   constraint PK_TRAININGEVALUATE primary key nonclustered (TreID)
)
go

/*==============================================================*/
/* Index: TrainingEvaluate_FK                                   */
/*==============================================================*/
create index TrainingEvaluate_FK on TrainingEvaluate (
TrpID ASC
)
go

/*==============================================================*/
/* Index: TrainingEvaluate_FK2                                  */
/*==============================================================*/
create index TrainingEvaluate_FK2 on TrainingEvaluate (
UID ASC
)
go

/*==============================================================*/
/* Table: TrainingFeedback                                      */
/*==============================================================*/
create table TrainingFeedback (
   TrfID                int                  identity,
   UID                  int                  null,
   TrpID                int                  null,
   TrfText              varchar(1000)        not null,
   constraint PK_TRAININGFEEDBACK primary key nonclustered (TrfID)
)
go

/*==============================================================*/
/* Index: TrainingFeedback_FK                                   */
/*==============================================================*/
create index TrainingFeedback_FK on TrainingFeedback (
TrpID ASC
)
go

/*==============================================================*/
/* Index: TrainingFeedback_FK2                                  */
/*==============================================================*/
create index TrainingFeedback_FK2 on TrainingFeedback (
UID ASC
)
go

/*==============================================================*/
/* Table: TrainingPlan                                          */
/*==============================================================*/
create table TrainingPlan (
   TrpID                int                  identity,
   DepID                int                  null,
   TrpPeople            varchar(50)          not null,
   TrpName              varchar(50)          not null,
   TrpInfo              varchar(1000)        not null,
   TrpAdmin             varchar(50)          not null,
   TrpPlace             varchar(200)         not null,
   TrpFee               int                  not null,
   TrpDate              datetime             not null,
   TrpMonth             int                  not null,
   constraint PK_TRAININGPLAN primary key nonclustered (TrpID)
)
go

/*==============================================================*/
/* Index: TrainingPlan_FK                                       */
/*==============================================================*/
create index TrainingPlan_FK on TrainingPlan (
DepID ASC
)
go

alter table Attendance
   add constraint FK_ATTENDAN_RELATIONS_ATTMARK foreign key (AttMarkID)
      references AttMark (AttMarkID)
go

alter table Attendance
   add constraint FK_ATTENDAN_RELATIONS_EMPLOYEE foreign key (UID)
      references Employee (UID)
go

alter table Candidates
   add constraint FK_CANDIDAT_RELATIONS_RECRUITM foreign key (RecID)
      references RecruitmentInfo (RecID)
go

alter table Contract
   add constraint FK_CONTRACT_RELATIONS_EMPLOYEE foreign key (UID)
      references Employee (UID)
go

alter table Employee
   add constraint FK_EMPLOYEE_RELATIONS_DEPARTME foreign key (DepID)
      references Department (DepID)
go

alter table Employee
   add constraint FK_EMPLOYEE_RELATIONS_RANK foreign key (RankID)
      references Rank (RankID)
go

alter table Employee
   add constraint FK_EMPLOYEE_RELATIONS_PERMISSI foreign key (PerID)
      references Permission (PerID)
go

alter table Info
   add constraint FK_INFO_RELATIONS_EMPLOYEE foreign key (UID)
      references Employee (UID)
go

alter table RecruitmentInfo
   add constraint FK_RECRUITM_RELATIONS_DEPARTME foreign key (DepID)
      references Department (DepID)
go

alter table RecruitmentInfo
   add constraint FK_RECRUITM_RELATIONS_RANK foreign key (RankID)
      references Rank (RankID)
go

alter table Salary
   add constraint FK_SALARY_RELATIONS_APPLYSTA foreign key (AppID)
      references ApplyState (AppID)
go

alter table Salary
   add constraint FK_SALARY_RELATIONS_EMPLOYEE foreign key (UID)
      references Employee (UID)
go

alter table TrainingApply
   add constraint FK_TRAINING_RELATIONS_TRAINING6 foreign key (TrpID)
      references TrainingPlan (TrpID)
go

alter table TrainingApply
   add constraint FK_TRAINING_RELATIONS_APPLYSTA foreign key (AppID)
      references ApplyState (AppID)
go

alter table TrainingApply
   add constraint FK_TRAINING_RELATIONS_EMPLOYEE1 foreign key (UID)
      references Employee (UID)
go

alter table TrainingEvaluate
   add constraint FK_TRAINING_RELATIONS_TRAINING5 foreign key (TrpID)
      references TrainingPlan (TrpID)
go

alter table TrainingEvaluate
   add constraint FK_TRAINING_RELATIONS_EMPLOYEE4 foreign key (UID)
      references Employee (UID)
go

alter table TrainingFeedback
   add constraint FK_TRAINING_RELATIONS_TRAINING3 foreign key (TrpID)
      references TrainingPlan (TrpID)
go

alter table TrainingFeedback
   add constraint FK_TRAINING_RELATIONS_EMPLOYEE2 foreign key (UID)
      references Employee (UID)
go

alter table TrainingPlan
   add constraint FK_TRAINING_RELATIONS_DEPARTME foreign key (DepID)
      references Department (DepID)
go

