Create database sysPredial;
use sysPredial;

create table Conjunto(
	id int primary key auto_increment
	,nrConjunto varchar(255)
	,andar varchar(255)
	,alugel double
	,tamanho int
	,ocupado boolean
);

create table Empresa(
	id int primary key auto_increment
    ,razaosocial varchar(255)
    ,cnpj varchar(255)
    ,horarioAbertura Time
    ,horarioFechamento Time
	,temperaturaPadrao int
	,horaIniAr Time
	,horaFimAr Time
	,conjuntoId int null
	,constraint FK_Conjunto_Empresa foreign key (conjuntoId) references Conjunto(id)
);

create table Usuario(
	id int primary key auto_increment
    ,login varchar(255)
   ,senha varchar(255)
   ,perfil varchar(255)
   ,CPF varchar(255)
   ,nome varchar(255)
   ,horaAcesso Time
   ,horaSaida Time
    ,empresaId int 
    ,constraint FK_Usuario_Empresa foreign key (empresaId) references Empresa(id)
);

INSERT INTO `syspredial`.`empresa`
(
`razaosocial`,
`cnpj`,
`horarioAbertura`,
`horarioFechamento`,
`temperaturaPadrao`,
`horaIniAr`,
`horaFimAr`)
VALUES
(
'Teste',
'123',
'08:30',
'16:00',
24,
'08:30',
'16:00');