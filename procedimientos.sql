use umaiDB;
drop procedure ProcInsertarProducto;

delimiter //

CREATE PROCEDURE  ProcInsertarProducto
(   
    nombreProd  varchar(30),
    descripcionProd varchar(150),
    unidadMedidadProd varchar(30)
)
BEGIN
	insert into Productos(nombreProd,descripcionProd,unidadMedidadProd)
		values(NombreProd,descripcionProd,unidadMedidadProd);
END
//

#drop procedure ProcInsertarUsuario;

delimiter //
 
CREATE PROCEDURE  ProcInsertarUsuario
(  	 
   
    nombreUsu varchar(30) ,
    contraseñaUsu varchar(30) ,
    calleUsu varchar(50),
    coloUsu varchar(50),
    ciudUsu varchar(50),
    codigoPostal varchar(20),
    telefonoUsu varchar(20),
   sueldoUsu int,
    puntosUsu int,
    tipoPermiso int 
    

    
)
BEGIN
	insert into usuarios(nombreUsu,contraseñaUsu,calleUsu,coloUsu,ciudUsu,codigoPostal,telefonoUsu,sueldoUsu,puntosUsu,tipoPermiso,estadoContrato)
		values(nombreUsu,contraseñaUsu,calleUsu ,coloUsu,ciudUsu,codigoPostal,telefonoUsu,sueldoUsu, puntosUsu,tipoPermiso,'Activo');
END
//
#DROP PROCEDURE IF EXISTS ProcInsertarUsuario;
/*
 delimiter //
 CREATE PROCEDURE  ProcActualizarProducto
 (  in idProduc int,
	in nombreProduc  varchar(20) ,
    in descripcionProduc varchar(30),
    in cantidadProduc int,
    in precioUnitarioProduc  int,
    in unidadMedidaProduc varchar(10),
    in idProve  int
)
BEGIN
update Productos set nombreProd=nombreProduc,descripcionProd=descripcionProduc,cantidadProd=cantidadProduc,precioUnitario=precioUnitarioProduc,unidadMedida=unidadMedidaProduc,idProv=idProve  
where idProd=idProduc;
END
//
*/
#drop procedure ProcActualizarUsuario;


delimiter //
 CREATE PROCEDURE  ProcActualizarUsuario
 (  idUsu int,
    nombreUsu varchar(30) ,
    contraseñaUsu varchar(20) ,
    calleUsu varchar(30),
    coloUsu varchar(30),
    ciudUsu varchar(30),
    codigoPostal varchar(20),
    telefonoUsu varchar(20),
    sueldoUsu int,
    puntosUsu int,
    tipoPermiso int,
    estadoContrato varchar(30)
)
BEGIN
update Usuarios set nombreUsu=nombreUsu,contraseñaUsu=contraseñaUsu,calleUsu=calleUsu,coloUsu=coloUsu,ciudUsu=ciudUsu,codigoPostal=codigoPostal
,telefonoUsu=telefonoUsu,sueldoUsu=sueldoUsu,puntosUsu=puntosUsu,tipoPermiso=tipoPermiso,estadoContrato=estadoContrato
where idUsu=idUsu;
END
//



