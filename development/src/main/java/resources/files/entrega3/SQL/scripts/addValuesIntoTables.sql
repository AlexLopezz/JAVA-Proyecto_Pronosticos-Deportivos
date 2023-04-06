use dev_railway;

insert into Persona (nombre)
values 
('Tino'),
('Alex'),
('Juan');

insert into Equipo (nombre)
values 
('Argentina'),
('Arabia Saudita'),
('Mexico'),
('Polonia'),
('Paises Bajos'),
('Estados Unidos'),
('Australia'),
('Croacia'),
('Brasil'),
('Francia'),
('Marruecos');


insert into Fase (descripcion)
values
('Fase de grupos'),
('Fase eliminatoria');

insert into Ronda (fase_fk, descripcion)
values 
(1, 'Primera fecha'),
(1, 'Segundo fecha'),
(1, 'Tercer fecha'),
(2, 'Octavos de final'),
(2, 'Cuartos de final'),
(2, 'Semifinal'),
(2, 'Final y Tercer puesto');

insert into Partido(equipo1_FK, equipo2_FK, golesEquipo1, golesEquipo2, ronda_FK)
values
('Argentina', 'Arabia Saudita', 1, 2, 1),
('Mexico', 'Polonia', 0, 0, 1),
('Polonia', 'Arabia Saudita', 2, 0, 2),
('Argentina', 'Mexico', 2, 0, 2),
('Polonia', 'Argentina', 0, 2, 3),
('Arabia Saudita', 'Mexico', 1, 2, 3),
('Paises Bajos', 'Estados Unidos', 3, 1, 4),
('Argentina', 'Australia', 2, 1, 4),
('Paises Bajos', 'Argentina', 3, 4, 5),
('Croacia', 'Brasil', 4, 2, 5),
('Argentina', 'Croacia', 3, 0, 6),
('Francia', 'Marruecos', 2, 0, 6),
('Argentina', 'Francia', 4, 2, 7),
('Croacia', 'Marruecos', 2, 1, 7);

insert into Pronostico(partido_FK, equipo_FK, resultado, persona_FK)
values
(1, 'Argentina', 'Ganador', 1),
(2, 'Mexico', 'Ganador', 1),
(3, 'Polonia', 'Ganador', 1),
(4, 'Argentina', 'Ganador', 1),
(5, 'Polonia', 'Ganador', 1),
(6, 'Arabia Saudita', 'Ganador', 1),
(7, 'Paises Bajos', 'Ganador', 1),
(8, 'Argentina', 'Empate', 1),
(9, 'Paises Bajos', 'Empate', 1),
(10, 'Croacia', 'Empate', 1),
(11, 'Argentina', 'Perdedor', 1),
(12, 'Francia', 'Empate', 1),
(13, 'Argentina', 'Empate', 1),
(14, 'Croacia', 'Empate', 1),
(1, 'Argentina', 'Empate', 2),
(2, 'Mexico', 'Empate', 2),
(3, 'Polonia', 'Perdedor', 2),
(4, 'Argentina', 'Empate', 2),
(5, 'Polonia', 'Empate', 2),
(6, 'Arabia Saudita', 'Empate', 2),
(7, 'Paises Bajos', 'Ganador', 2),
(8, 'Argentina', 'Perdedor', 2),
(9, 'Paises Bajos', 'Empate', 2),
(10, 'Croacia', 'Ganador', 2),
(11, 'Argentina', 'Perdedor', 2),
(12, 'Francia', 'Empate', 2),
(13, 'Argentina', 'Ganador', 2),
(14, 'Croacia', 'Empate', 2),
(1, 'Argentina', 'Perdedor', 3),
(2, 'Mexico', 'Perdedor', 3),
(3, 'Polonia', 'Perdedor', 3),
(4, 'Argentina', 'Perdedor', 3),
(5, 'Polonia', 'Ganador', 3),
(6, 'Arabia Saudita', 'Ganador', 3),
(7, 'Paises Bajos', 'Ganador', 3),
(8, 'Argentina', 'Ganador', 3),
(9, 'Paises Bajos', 'Ganador', 3),
(10, 'Croacia', 'Ganador', 3),
(11, 'Argentina', 'Empate', 3),
(12, 'Francia', 'Ganador', 3),
(13, 'Argentina', 'Ganador', 3),
(14, 'Croacia', 'Ganador', 3);

insert into PuntajeRonda(idRonda, idPersona)
values
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(7, 2),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(5, 3),
(6, 3),
(7, 3);