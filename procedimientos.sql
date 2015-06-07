use umaiDB;

#drop procedure ProcInsertarProducto;

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


#drop procedure ProcActualizarUsuario;


delimiter //
 CREATE PROCEDURE  ProcActualizarUsuario
 (  
 
	idUsu2 int ,
    nombreUsu2 varchar(30),
    contraseñaUsu2 varchar(30) ,
    calleUsu2 varchar(50),
    coloUsu2 varchar(50),
    ciudUsu2 varchar(50),
    codigoPostal2 varchar(20),
    telefonoUsu2 varchar(20),
    
    sueldoUsu2 int,
    puntosUsu2 int,
    tipoPermiso2 int  ,
    estadoContrato2 varchar(30)
 )
BEGIN
update Usuarios set nombreUsu=nombreUsu2,contraseñaUsu=contraseñaUsu2,calleUsu=calleUsu2,coloUsu=coloUsu2,ciudUsu=ciudUsu2,codigoPostal=codigoPostal2
,telefonoUsu=telefonoUsu2,sueldoUsu=sueldoUsu2,puntosUsu=puntosUsu2,tipoPermiso=tipoPermiso2,estadoContrato=estadoContrato2
where idUsu=idUsu2;
END
//

delimiter //
 CREATE PROCEDURE  ProcActualizarProducto
 (  idProd2 int,
     nombreProd2  varchar(30),
    descripcionProd2 varchar(150),
    unidadMedidadProd2 varchar(30)
)
BEGIN
update Productos set nombreProd=nombreProd2,descripcionProd=descripcionProd2,unidadMedidadProd=unidadMedidadProd2
where idProd=idProd2;
END
//

#drop procedure ProcActualizarProducto;

#call ProcActualizarProducto(11,'leche','de vaca','Litro');
#drop procedure ProcActualizarproveedor;
delimiter //
 CREATE PROCEDURE  ProcActualizarProveedor
 (  idProv2 int ,
    nombreProv2 varchar(30),
    codigoPostal2 varchar(20),
    ciudadProv2 varchar(30),
    coloniaProv2 varchar(50),
    calleProv2 varchar(50),
    telefonoProv2  varchar(20),
    emailProv2 varchar(50),
    estadoContrato2 varchar(30)
)
BEGIN
update proveedor set nombreProv=nombreProv2,CodigoPostal=codigoPostal2,ciudadProv=ciudadProv2,coloniaProv=coloniaProv2,
calleProv=calleProv2,telefonoProv=telefonoProv2,emailProv=emailProv2,estadoContrato=estadoContrato2 where idProv=idProv2;
END
//


#drop procedure consultaCodigoPostal
delimiter //
 CREATE PROCEDURE consultaCodigoPostal()
 begin
	select CodigoPostal from CodigosPostales where Estado='Jalisco';
    
END
//

delimiter //
 CREATE PROCEDURE consultaMunicipios(codigoPostal2 varchar(20))
 begin
	Select Municipio from CodigosPostales where CodigoPostal=codigoPostal2;
    
    
END
//
drop procedure consultaColonias;
delimiter //
 CREATE PROCEDURE consultaColonias(muni2 varchar(30))
 begin
	Select Colonia from CodigosPostales where Municipio=muni2   COLLATE utf8_unicode_ci;
   
    
    
END
//

#drop procedure consultaUsuariosID;
#call consultaUsuariosID(1);
#select *  from usuarios;
delimiter //
 CREATE PROCEDURE consultaUsuariosID(param int)
 begin
 
   select * from usuarios where idUsu like  param;
    
    
END
//



#call consultaUsuariosIDEliminar(1);
delimiter //
 CREATE PROCEDURE consultaUsuariosIDEliminar(param int)
 begin
	
   
    select * from usuarios where idUsu like param  and estadoContrato='Activo';
    
END
//

#drop procedure consultaUsuariosNombre;
#call consultaUsuariosNombre('c');

delimiter //
CREATE  PROCEDURE consultaUsuariosNombre(param char(30))
 
 begin
 
    set param=CONCAT('%',param);
    set param=CONCAT(param,'%');
	
        select * from usuarios where nombreUsu like param;
END
//
#drop procedure consultaUsuariosNombreEliminar;
delimiter //
CREATE  PROCEDURE consultaUsuariosNombreEliminar(param char(30))
 
 begin
 
    set param=CONCAT('%',param);
    set param=CONCAT(param,'%');
	
        select * from usuarios where nombreUsu like param and estadoContrato='Activo';
END
//

delimiter //
CREATE PROCEDURE EliminarUsuario(id int)
 begin
	
	update usuarios set estadoContrato='Terminado' where idUsu=id;
END
//


/*
-----------------------Proveedor--------------------------------
*/
#drop procedure ProcInsertarProv

delimiter //
 
CREATE PROCEDURE ProcInsertarProv
(  	 
    nombreProv varchar(30),
    telefonoProv varchar(20),
    emailProv varchar(50),
    codigoProv varchar(20),
    ciudadProv varchar(50), 
    coloniaProv varchar(30),
    calleProv varchar(50)
  
    
)
BEGIN
	insert into proveedor(nombreProv,telefonoProv,emailProv,codigoPostal,ciudadProv,coloniaProv,calleProv, estadoContrato)
		values(nombreProv,telefonoProv,emailProv,codigoProv,ciudadProv,coloniaProv,calleProv,'Activo');
END
//

#call ProcInsertarProv ('Erikona','7418529635','Erikona@hotmail','49058','Guzmán','centro','Coloritos #15','Activo');
#select * from proveedor;

delimiter //
 CREATE PROCEDURE consultaProveedorID(param int)
 begin
 
  
    select * from proveedor where idProv like param;
    
END
//


delimiter //
 CREATE PROCEDURE consultaProveedorIDEliminar(param int)
 begin
 
	select * from proveedor where idProv like param  and estadoContrato='Activo';
END
//

delimiter //
CREATE  PROCEDURE consultaProveedorNombre(param char(30))
 
 begin
 
    set param=CONCAT('%',param);
    set param=CONCAT(param,'%');
	
        
        select * from proveedor where nombreProv like param;
END
//

delimiter //
CREATE  PROCEDURE consultaProveedorNombreEliminar(param char(30))
 
 begin
 
    set param=CONCAT('%',param);
    set param=CONCAT(param,'%');
	
        
        select * from proveedor where nombreProv like param and estadoContrato='Activo';
END
//

delimiter //
CREATE PROCEDURE EliminarProveedor(id int)
 begin
		update proveedor set estadoContrato='Terminado' where idProv=id;
END
//
/*
* -----------------------------------productos----------------------------
*/


delimiter //
 CREATE PROCEDURE consultaProductoID(param int)
 begin
 
    select * from Productos where idProd like param;
END
//



delimiter //
CREATE  PROCEDURE consultaProductoNombre(param char(30))
 
 begin
 
    set param=CONCAT('%',param);
    set param=CONCAT(param,'%');
	
        select * from Productos where nombreProd like param;
END
//


delimiter //
CREATE PROCEDURE EliminarProducto(id int)
 begin
		
        delete from Productos where idProd=id;
END
//