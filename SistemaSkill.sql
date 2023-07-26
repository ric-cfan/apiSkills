CREATE TABLE Usuario(
	id_usuario serial primary key,
	login varchar(20) NOT NULL UNIQUE,
	senha varchar(255) NOT NULL
);

create table Skill(
	id_skill serial primary key,
	nome varchar(50) NOT NULL UNIQUE,
	descricao varchar(255) NOT NULL,
	url_imagem varchar(255) NOT NULL
);
	
create table Usuario_Skill(
	id_usuario_skill serial primary key,
	id_usuario int NOT NULL REFERENCES Usuario(id_usuario),
	id_skill int NOT NULL REFERENCES Skill(id_skill),
	lvl int NOT NULL
);

INSERT INTO Skill (nome, descricao, url_imagem) VALUES
	('Dano físico', 'Causa dano físico a um alvo', 'https://iili.io/HQLmYx4.png'),
	('Dano mágico', 'Causa dano mágico a todos os alvos em uma área', 'https://iili.io/HQLm5bf.png'),
	('Buff', 'Garante um efeito positivo a alvo', 'https://iili.io/HQLmIUX.png'),
	('Debuff', 'Garante um efeito negativo a alvo', 'https://iili.io/HQLmuJn.png'),
	('Cura', 'Recupera a saude de um alvo', 'https://iili.io/HQLmROG.png'),
	('Reviver', 'Recupera metade da saude de um alvo incapacitado', 'https://iili.io/HQLmARs.png');