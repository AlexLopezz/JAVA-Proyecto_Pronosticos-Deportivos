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
(1, 'Argentina', 'Ganador', 1),
(2, 'Mexico', 'Ganador', 1),
(3, 'Polonia', 'Ganador', 1),
(4, 'Argentina', 'Ganador', 1),
(5, 'Polonia', 'Ganador', 1),
(6, 'Arabia Saudita', 'Ganador', 1),
-- Octavos de final
(7, 'Paises Bajos', 'Ganador', 1),
(8, 'Argentina', 'Empate', 1),
(9, 'Japon', 'Empate', 1),
(10, 'Brasil', 'Empate', 1),
(11, 'Inglaterra', 'Empate', 1),
(12, 'Francia', 'Empate', 1),
(13, 'Marruecos', 'Empate', 1),
(14, 'Portugal', 'Empate', 1),
-- Cuartos de final
(15, 'Paises Bajos', 'Empate', 1),
(16, 'Croacia', 'Empate', 1),
(17, 'Inglaterra', 'Empate', 1),
(18, 'Marruecos', 'Empate', 1),
-- Semifinal
(19, 'Argentina', 'Perdedor', 1),
(20, 'Francia', 'Empate', 1),
-- Tercer puesto
(21, 'Croacia', 'Empate', 1),
-- Final
(22, 'Argentina', 'Empate', 1),

-- Fase de grupos
(1, 'Argentina', 'Ganador', 2),
(2, 'Mexico', 'Ganador', 2),
(3, 'Polonia', 'Ganador', 2),
(4, 'Argentina', 'Ganador', 2),
(5, 'Polonia', 'Ganador', 2),
(6, 'Arabia Saudita', 'Ganador', 2),
-- Octavos de final
(7, 'Paises Bajos', 'Ganador', 2),
(8, 'Argentina', 'Empate', 2),
(9, 'Japon', 'Empate', 2),
(10, 'Brasil', 'Empate', 2),
(11, 'Inglaterra', 'Empate', 2),
(12, 'Francia', 'Empate', 2),
(13, 'Marruecos', 'Empate', 2),
(14, 'Portugal', 'Empate', 2),
-- Cuartos de final
(15, 'Paises Bajos', 'Empate', 2),
(16, 'Croacia', 'Empate', 2),
(17, 'Inglaterra', 'Empate', 2),
(18, 'Marruecos', 'Empate', 2),
-- Semifinal
(19, 'Argentina', 'Perdedor', 2),
(20, 'Francia', 'Empate', 2),
-- Tercer puesto
(21, 'Croacia', 'Empate', 2),
-- Final
(22, 'Argentina', 'Empate', 2),

-- Fase de grupos
(1, 'Argentina', 'Ganador', 3),
(2, 'Mexico', 'Ganador', 3),
(3, 'Polonia', 'Ganador', 3),
(4, 'Argentina', 'Ganador', 3),
(5, 'Polonia', 'Ganador', 3),
(6, 'Arabia Saudita', 'Ganador', 3),
-- Octavos de final
(7, 'Paises Bajos', 'Ganador', 3),
(8, 'Argentina', 'Empate', 3),
(9, 'Japon', 'Empate', 3),
(10, 'Brasil', 'Empate', 3),
(11, 'Inglaterra', 'Empate', 3),
(12, 'Francia', 'Empate', 3),
(13, 'Marruecos', 'Empate', 3),
(14, 'Portugal', 'Empate', 3),
-- Cuartos de final
(15, 'Paises Bajos', 'Empate', 3),
(16, 'Croacia', 'Empate', 3),
(17, 'Inglaterra', 'Empate', 3),
(18, 'Marruecos', 'Empate', 3),
-- Semifinal
(19, 'Argentina', 'Perdedor', 3),
(20, 'Francia', 'Empate', 3),
-- Tercer puesto
(21, 'Croacia', 'Empate', 3),
-- Final
(22, 'Argentina', 'Empate', 3);