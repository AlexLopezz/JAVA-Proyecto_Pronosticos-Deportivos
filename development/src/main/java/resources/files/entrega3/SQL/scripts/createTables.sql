use railway;

CREATE TABLE Persona(
idPersona int AUTO_INCREMENT primary key,
nombre varchar(20) not null,
puntaje int default 0
);

CREATE TABLE Fase(
idFase int AUTO_INCREMENT primary key,
descripcion varchar(30)
);

CREATE TABLE Ronda(
idRonda int AUTO_INCREMENT primary key,
fase_fk int not null,
descripcion varchar(30),
FOREIGN KEY (fase_fk) references Fase(idFase)
);

CREATE TABLE Equipo(
Nombre varchar(30) PRIMARY KEY,
descripcion varchar(50) DEFAULT ''
);

CREATE TABLE Partido(
idPartido int auto_increment primary key,
equipo1_FK varchar(30) not null,
equipo2_FK varchar(30) not null,
golesEquipo1 int default 0,
golesEquipo2 int default 0,
ronda_FK int not null,
FOREIGN KEY (equipo1_FK) references Equipo(Nombre),
FOREIGN KEY (equipo2_FK) references Equipo(Nombre),
FOREIGN KEY (ronda_FK) references Ronda(idRonda)
);

CREATE TABLE Pronostico(
idPronostico int auto_increment primary key,
partido_FK int not null,
equipo_FK varchar(30) not null,
resultado enum('Ganador', 'Empate', 'Perdedor') not null,
persona_FK int not null,
FOREIGN KEY (partido_FK) references Partido(idPartido),
FOREIGN KEY (equipo_FK) references Equipo(Nombre),
FOREIGN KEY (persona_FK) references Persona(idPersona)
);

CREATE TABLE PuntajeRonda(
idRonda int not null,
idPersona int not null,
puntaje int default 0,
primary key(idRonda, idPersona),
FOREIGN KEY (idRonda) references Ronda(idRonda),
FOREIGN KEY (idPersona) references Persona(idPersona)
);