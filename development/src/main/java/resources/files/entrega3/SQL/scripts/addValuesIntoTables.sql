use dev_railway;

insert into Persona (nombre)
values 
('Tino'),
('Alex'),
('Ezequiel');

insert into Equipo (nombre)
values 
('Argentina'),
('Mexico'),
('Polonia'),
('Arabia Saudita'),
('Paises Bajos'),
('Estados Unidos'),
('Australia'),
('Japon'),
('Croacia'),
('Brasil'),
('Corea del Sur'),
('Inglaterra'),
('Senegal'),
('España'),
('Portugal'),
('Suiza'),
('Francia'),
('Marruecos');


insert into Fase (descripcion)
values
('Fase de grupos'),
('Octavos de final'),
('Cuartos de final'),
('Semifinal'),
('Tercer puesto'),
('Final');

insert into Ronda (fase_fk, descripcion)
values 
(1, 'Primera fecha - Fase de grupos'),
(1, 'Segundo fecha - Fase de grupos'),
(1, 'Tercer fecha - Fase de grupos'),
(2, 'Octavos de final - 8 equipos finalistas.'),
(3, 'Cuartos de final - 4 equipos finalistas.'),
(4, 'Semifinal - 2 equipos finalistas. Se define quien juega la final'),
(5, 'Tercer puesto - Se juega para saber el 3er mejor equipo.'),
(6, 'Final - 1 Equipo finalista. Se define Campeon');

insert into Partido(equipo1_FK, equipo2_FK, golesEquipo1, golesEquipo2, ronda_FK)
values
-- Fase de grupos
('Argentina', 'Arabia Saudita', 1, 2, 1),
('Mexico', 'Polonia', 0, 0, 1),
('Polonia', 'Arabia Saudita', 2, 0, 2),
('Argentina', 'Mexico', 2, 0, 2),
('Polonia', 'Argentina', 0, 2, 3),
('Arabia Saudita', 'Mexico', 1, 2, 3),
-- Octavos de final
('Paises Bajos', 'Estados Unidos', 3, 1, 4),
('Argentina', 'Australia', 2, 1, 4),
('Japon', 'Croacia', 1, 3, 4),
('Brasil', 'Corea del Sur', 4, 1, 4),
('Inglaterra', 'Senegal', 4, 1, 4),
('Francia', 'Polonia', 3, 1, 4),
('Marruecos', 'España', 3, 1, 4),
('Portugal', 'Suiza', 6, 1, 4),
-- Cuartos de final
('Paises Bajos', 'Argentina', 3, 4, 5),
('Croacia', 'Brasil', 4, 2, 5),
('Inglaterra', 'Francia', 1, 2, 5),
('Marruecos', 'Portugal', 1, 0, 5),
-- Semifinal
('Argentina', 'Croacia', 3, 0, 6),
('Francia', 'Marruecos', 2, 0, 6),
-- Tercer puesto
('Croacia', 'Marruecos', 2, 1, 7),
-- Final
('Argentina', 'Francia', 4, 2, 8);


insert into Pronostico(partido_FK, equipo_FK, resultado, persona_FK)
values
-- Fase de grupos
(1, 'Argentina', 'Perdedor', 1),
(2, 'Mexico', 'Empate', 1),
(3, 'Polonia', 'Ganador', 1),
(4, 'Argentina', 'Perdedor', 1),
(5, 'Polonia', 'Empate', 1),
(6, 'Arabia Saudita', 'Empate', 1),
-- Octavos de final
(7, 'Paises Bajos', 'Ganador', 1),
(8, 'Argentina', 'Ganador', 1),
(9, 'Japon', 'Ganador', 1),
(10, 'Brasil', 'Ganador', 1),
(11, 'Inglaterra', 'Ganador', 1),
(12, 'Francia', 'Perdedor', 1),
(13, 'Marruecos', 'Ganador', 1),
(14, 'Portugal', 'Perdedor', 1),
-- Cuartos de final
(15, 'Paises Bajos', 'Perdedor', 1),
(16, 'Croacia', 'Ganador', 1),
(17, 'Inglaterra', 'Ganador', 1),
(18, 'Marruecos', 'Perdedor', 1),
-- Semifinal
(19, 'Argentina', 'Ganador', 1),
(20, 'Francia', 'Perdedor', 1),
-- Tercer puesto
(21, 'Croacia', 'Ganador', 1),
-- Final
(22, 'Argentina', 'Ganador', 1),


-- Fase de grupos
(1, 'Argentina', 'Empate', 2),
(2, 'Mexico', 'Empate', 2),
(3, 'Polonia', 'Ganador', 2),
(4, 'Argentina', 'Perdedor', 2),
(5, 'Polonia', 'Perdedor', 2),
(6, 'Arabia Saudita', 'Ganador', 2),
-- Octavos de final
(7, 'Paises Bajos', 'Ganador', 2),
(8, 'Argentina', 'Ganador', 2),
(9, 'Japon', 'Perdedor', 2),
(10, 'Brasil', 'Ganador', 2),
(11, 'Inglaterra', 'Ganador', 2),
(12, 'Francia', 'Perdedor', 2),
(13, 'Marruecos', 'Perdedor', 2),
(14, 'Portugal', 'Ganador', 2),
-- Cuartos de final
(15, 'Paises Bajos', 'Ganador', 2),
(16, 'Croacia', 'Ganador', 2),
(17, 'Inglaterra', 'Perdedor', 2),
(18, 'Marruecos', 'Ganador', 2),
-- Semifinal
(19, 'Argentina', 'Perdedor', 2),
(20, 'Francia', 'Perdedor', 2),
-- Tercer puesto
(21, 'Croacia', 'Perdedor', 2),
-- Final
(22, 'Argentina', 'Ganador', 2),


-- Fase de grupos
(1, 'Argentina', 'Ganador', 3),
(2, 'Mexico', 'Empate', 3),
(3, 'Polonia', 'Empate', 3),
(4, 'Argentina', 'Perdedor', 3),
(5, 'Polonia', 'Ganador', 3),
(6, 'Arabia Saudita', 'Ganador', 3),
-- Octavos de final
(7, 'Paises Bajos', 'Ganador', 3),
(8, 'Argentina', 'Perdedor', 3),
(9, 'Japon', 'Ganador', 3),
(10, 'Brasil', 'Ganador', 3),
(11, 'Inglaterra', 'Ganador', 3),
(12, 'Francia', 'Ganador', 3),
(13, 'Marruecos', 'Ganador', 3),
(14, 'Portugal', 'Ganador', 3),
-- Cuartos de final
(15, 'Paises Bajos', 'Perdedor', 3),
(16, 'Croacia', 'Perdedor', 3),
(17, 'Inglaterra', 'Ganador', 3),
(18, 'Marruecos', 'Perdedor', 3),
-- Semifinal
(19, 'Argentina', 'Ganador', 3),
(20, 'Francia', 'Ganador', 3),
-- Tercer puesto
(21, 'Croacia', 'Ganador', 3),
-- Final
(22, 'Argentina', 'Ganador', 3);