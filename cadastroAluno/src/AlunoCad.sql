/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.8-MariaDB : Database - db_exercicio_java
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_exercicio_java` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `db_exercicio_java`;

/*Table structure for table `cad_aluno` */

DROP TABLE IF EXISTS `cad_aluno`;

CREATE TABLE `cad_aluno` (
  `ALUNO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ALUNO_NOME` varchar(60) NOT NULL,
  `ALUNO_DT_NASC` date NOT NULL,
  `ALUNO_CPF` char(11) NOT NULL,
  `ALUNO_EMAIL` varchar(100) NOT NULL,
  `ALUNO_END` varchar(100) NOT NULL,
  `ALUNO_MUNIC` varchar(40) NOT NULL,
  `ALUNO_UF` char(2) NOT NULL,
  `ALUNO_CEL` bigint(14) NOT NULL,
  PRIMARY KEY (`ALUNO_ID`),
  UNIQUE KEY `ALUNO_CPF` (`ALUNO_CPF`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_aluno` */

insert  into `cad_aluno`(`ALUNO_ID`,`ALUNO_NOME`,`ALUNO_DT_NASC`,`ALUNO_CPF`,`ALUNO_EMAIL`,`ALUNO_END`,`ALUNO_MUNIC`,`ALUNO_UF`,`ALUNO_CEL`) values (13,'JOAO CLAUDIO RIBEIRO','1997-07-12','22222222222','JOAOCLAUDIODIVA@GMAIL.COM','RUA DA MOCA 1736','SP','SP',11111111116),(18,'MARIA DAS NEVES','1998-09-18','55555555555','MARIA@GMAIL.COM','AV SAPOPEMBA 13304','SAO PAULO','SP',44444444444);

/*Table structure for table `cad_campus` */

DROP TABLE IF EXISTS `cad_campus`;

CREATE TABLE `cad_campus` (
  `CAMPUS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAMPUS_NOME` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CAMPUS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_campus` */

insert  into `cad_campus`(`CAMPUS_ID`,`CAMPUS_NOME`) values (1,'TATUAPE'),(2,'PINHEIROS');

/*Table structure for table `cad_curso` */

DROP TABLE IF EXISTS `cad_curso`;

CREATE TABLE `cad_curso` (
  `CURSO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CURSO_DESC` varchar(40) NOT NULL,
  PRIMARY KEY (`CURSO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_curso` */

insert  into `cad_curso`(`CURSO_ID`,`CURSO_DESC`) values (1,'ANALISE E DESENVOLVIMENTO DE SISTEMA'),(2,'CIENCIAS DA COMPUTACAO'),(3,'ENGENHARIA DE SOFTWARE'),(4,'BANCO DE DADOS'),(5,'REDES DE COMPUTADORES');

/*Table structure for table `cad_disciplina` */

DROP TABLE IF EXISTS `cad_disciplina`;

CREATE TABLE `cad_disciplina` (
  `DISCIPLINA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DISCIPLINA_DESC` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`DISCIPLINA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_disciplina` */

insert  into `cad_disciplina`(`DISCIPLINA_ID`,`DISCIPLINA_DESC`) values (1,'MODELAGEM DE DADOS'),(2,'ESTRUTURA DE DADOS'),(3,'TECNICAS DE PROGRAMACAO'),(4,'BANCO DE DADOS'),(5,'LOGICA DE PROGRAMACAO'),(6,'REDES DE COMPUTADORES'),(7,'ANALISE DE PROJETO');

/*Table structure for table `cad_disciplina_curso` */

DROP TABLE IF EXISTS `cad_disciplina_curso`;

CREATE TABLE `cad_disciplina_curso` (
  `DISCIPLINA_ID` int(11) NOT NULL,
  `CURSO_ID` int(11) NOT NULL,
  PRIMARY KEY (`DISCIPLINA_ID`,`CURSO_ID`),
  KEY `FK_CAD_DISCIPLINA_CURSO_CURSO` (`CURSO_ID`),
  CONSTRAINT `FK_CAD_DISCIPLINA_CURSO_CURSO` FOREIGN KEY (`CURSO_ID`) REFERENCES `cad_curso` (`CURSO_ID`),
  CONSTRAINT `FK_CAD_DISCIPLINA_CURSO_DISCIPLINA` FOREIGN KEY (`DISCIPLINA_ID`) REFERENCES `cad_disciplina` (`DISCIPLINA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_disciplina_curso` */

insert  into `cad_disciplina_curso`(`DISCIPLINA_ID`,`CURSO_ID`) values (1,1),(1,2),(1,3),(1,4),(1,5),(2,1),(2,2),(2,3),(2,4),(2,5),(3,1),(3,2),(3,3),(3,4),(3,5),(4,1),(4,2),(4,3),(4,4),(4,5),(5,1),(5,2),(5,3),(5,4),(5,5),(6,1),(6,2),(6,3),(6,4),(6,5),(7,1),(7,2),(7,3),(7,4),(7,5);

/*Table structure for table `cad_matricula` */

DROP TABLE IF EXISTS `cad_matricula`;

CREATE TABLE `cad_matricula` (
  `MATRICULA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ALUNO_ID` int(11) NOT NULL,
  `CURSO_ID` int(11) NOT NULL,
  `CAMPUS_ID` int(11) NOT NULL,
  `PERIODO_ID` int(11) NOT NULL,
  PRIMARY KEY (`MATRICULA_ID`),
  KEY `FK_CAD_MATRICULA_CAD_ALUNO` (`ALUNO_ID`),
  KEY `FK_CAD_MATRICULA_CAD_CURSO` (`CURSO_ID`),
  KEY `FK_CAD_MATRICULA_CAD_CAMPUS` (`CAMPUS_ID`),
  KEY `FK_CAD_MATRICULA_CAD_PERI0DO` (`PERIODO_ID`),
  CONSTRAINT `FK_CAD_MATRICULA_CAD_ALUNO` FOREIGN KEY (`ALUNO_ID`) REFERENCES `cad_aluno` (`ALUNO_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_CAD_MATRICULA_CAD_CAMPUS` FOREIGN KEY (`CAMPUS_ID`) REFERENCES `cad_campus` (`CAMPUS_ID`),
  CONSTRAINT `FK_CAD_MATRICULA_CAD_CURSO` FOREIGN KEY (`CURSO_ID`) REFERENCES `cad_curso` (`CURSO_ID`),
  CONSTRAINT `FK_CAD_MATRICULA_CAD_PERI0DO` FOREIGN KEY (`PERIODO_ID`) REFERENCES `cad_periodo` (`PERIODO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22110130 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_matricula` */

insert  into `cad_matricula`(`MATRICULA_ID`,`ALUNO_ID`,`CURSO_ID`,`CAMPUS_ID`,`PERIODO_ID`) values (22110127,13,1,1,3),(22110128,18,1,1,3);

/*Table structure for table `cad_periodo` */

DROP TABLE IF EXISTS `cad_periodo`;

CREATE TABLE `cad_periodo` (
  `PERIODO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PERIODO_DESC` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`PERIODO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_periodo` */

insert  into `cad_periodo`(`PERIODO_ID`,`PERIODO_DESC`) values (1,'MATUTINO'),(2,'VESPERTINO'),(3,'NOTURNO');

/*Table structure for table `cad_ponderado` */

DROP TABLE IF EXISTS `cad_ponderado`;

CREATE TABLE `cad_ponderado` (
  `DISCIPLINA_ID` int(11) NOT NULL,
  `MATRICULA_ID` int(11) NOT NULL,
  `PONDERADO_NOTA` varchar(4) DEFAULT NULL,
  `PONDERADO_FALTAS` int(3) DEFAULT NULL,
  `PONDERADO_SEMEST` varchar(6) NOT NULL,
  PRIMARY KEY (`DISCIPLINA_ID`,`MATRICULA_ID`),
  KEY `FK_CAD_PONDERADO_CAD_MATRICULA` (`MATRICULA_ID`),
  CONSTRAINT `FK_CAD_PONDERADO_CAD_DISCIPLINA` FOREIGN KEY (`DISCIPLINA_ID`) REFERENCES `cad_disciplina` (`DISCIPLINA_ID`),
  CONSTRAINT `FK_CAD_PONDERADO_CAD_MATRICULA` FOREIGN KEY (`MATRICULA_ID`) REFERENCES `cad_matricula` (`MATRICULA_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `cad_ponderado` */

insert  into `cad_ponderado`(`DISCIPLINA_ID`,`MATRICULA_ID`,`PONDERADO_NOTA`,`PONDERADO_FALTAS`,`PONDERADO_SEMEST`) values (1,22110127,'07.9',2,'2019-1'),(1,22110128,'03.0',3,'2019-1'),(2,22110127,'07.9',2,'2019-1'),(2,22110128,'01.5',0,'2019-1'),(3,22110127,'09.0',3,'2019-1'),(3,22110128,'03.0',4,'2019-1'),(4,22110127,'03.0',2,'2019-1'),(5,22110127,'07.9',2,'2019-1'),(6,22110127,'07.9',2,'2019-1'),(7,22110127,'03.5',1,'2019-1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
