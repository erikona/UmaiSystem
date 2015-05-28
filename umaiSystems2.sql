create database umaiDB;
use umaiDB;

create table usuarios(
	idUsu int auto_increment primary key,
    nombreUsu varchar(30) not null,
    contraseñaUsu varchar(30) not null,
    calleUsu varchar(50),
    coloUsu varchar(50),
    ciudUsu varchar(50),
    codigoPostal varchar(20),
    telefonoUsu varchar(20),
    avatarUsu varchar(50),
    sueldoUsu int not null,
    puntosUsu int,
    tipoPermiso int not null ,
    estadoContrato varchar(30)
);

create table piso(
	idPiso int auto_increment primary key,
    idUsu int ,
    mesa int not null,
    estado varchar(10),
    foreign key(idUsu) references usuarios(idUsu) 
    
);

create table reservaciones(
	idReser int auto_increment primary key,
    nombreReser varchar(20) not null,
    fechaReser  varchar(15) not null,
    horaReser   varchar(10),
    numPersonas int not null,
    anticipo int not null,
    comentarios varchar(50)
    
);

create table clientes(
	idCli int auto_increment primary key,
    nombreCli varchar(20) not null,
    contraseñaCli varchar(20) not null,
    nombreUsuarioCli varchar(20) not null,
    telefonoCli  varchar(20),
    emailCli   varchar(50),
    avatarCli  varchar(30),
    puntosCli  int not null
    
);




create table ventas(
idVenta int auto_increment primary key,
idUsu int , 
idCli int,
descuento int, 

foreign key(idUsu) references usuarios(idUsu),
foreign key(idCli) references clientes(idCli) 

);


create table receta(
	idRec int auto_increment primary key,
    nombreRec varchar(30) not null,
    tipoRec   varchar(20),
    tamañoPorcion  varchar(10),
    numeroPorcion  varchar(10),
    tiempoPreparacion varchar(10),
    difucultad varchar(10),
    
    porcientoPerdida  varchar(10)
    
    
);
create table proveedor(
	idProv int auto_increment primary key,
    nombreProv varchar(30) not null,
    ciudadProv varchar(30),
    telefonoProv  varchar(20),
    emailProv varchar(50)
);


create table Productos(
	idProd int auto_increment primary key,
    nombreProd  varchar(30) not null,
    descripcionProd varchar(150),
    unidadMedidadProd varchar(30)
    
);


create table detalleReceta(
	idDetalleRec int ,
    idRec int ,
    idProd int ,
    cantidadProd  int not null,
    foreign key (idProd) references Productos(idProd),
    foreign key(idRec) references receta(idRec) ,
	primary key(idRec,idDetalleRec)
);



#DROP PROCEDURE IF EXISTS ProcInsertarUsuario;

#drop procedure ProcActualizarUsuario;




