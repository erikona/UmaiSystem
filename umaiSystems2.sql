create database umaiDB;
use umaiDB;

create table usuarios(
	idUsu int auto_increment primary key,
    nombreUsu varchar(30) not null,
    contraseñaUsu varchar(20) not null,
    calleUsu varchar(30),
    coloUsu varchar(30),
    ciudUsu varchar(30),
    codigoPostal varchar(20),
    telefonoUsu varchar(20),
    avatarUsu varchar(20),
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
    nombreProd  varchar(20) not null,
    descripcionProd varchar(30),
    cantidadProd int not null,
    precioUnitario  int not null,
    unidadMedida varchar(10),
    idProv  int,
    foreign key (idProv) references proveedor(idPRov) 
    
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


delimiter //
 
CREATE PROCEDURE  ProcInsertarProducto
(   in nombreProd  varchar(20) ,
    in descripcionProd varchar(30),
    in cantidadProd int,
    in precioUnitario  int,
    in unidadMedida varchar(10),
    in idProv  int
)
BEGIN
	insert into Productos(nombreProd,descripcionProd,cantidadProd,precioUnitario,unidadMedida,idProv)
		values(NombreProd,descripcionProd,cantidadProd,precioUnitario,unidadMedida,idProv);
END
//

 





