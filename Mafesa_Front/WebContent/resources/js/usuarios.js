var appUsuarios = angular.module('Usuarios', ['ngRoute','ngCookies']);

var URL_SERVICIO_VALIDAR_USUARIO = 'http://localhost:8080/Mafesa_WS/rest/Usuario/login';
var URL_SERVICIO_LISTA = 'http://localhost:8080/Mafesa_WS/rest/Usuario/list';
var URL_SERVICIO_GUARDAR = 'http://localhost:8080/Mafesa_WS/rest/Usuario';
var URL_SERVICIO_LISTA_ORDENES = 'http://localhost:8080/Mafesa_WS/rest/OrdenCompra/list';
var URL_SERVICIO_GUARDAR_ORDENES = 'http://localhost:8080/Mafesa_WS/rest/OrdenCompra';

appUsuarios.factory('auth', function($cookies, $location){
	return{
		login : function(usuario)
		
		{
			$cookies.nombreUsuario = usuario,
			$location.url('/inicio');
		},
		
		validarEstado : function(){
			
			if(typeof($cookies.nombreUsuario) == 'undefined'){
				$location.url('/');
			}
			
			if(typeof($cookies.nombreUsuario) != 'undefined' && $location.url() == '/'){
				$location.url('/inicio');
			}
		}

	};
});


appUsuarios.service('Usuarios', function($http){
	this.validar = function(usuario,contrasena){
		return $http({
			method : 'GET',
			url : URL_SERVICIO_VALIDAR_USUARIO,
			params : {
				nombreUsuario : usuario,
				contrasena : contrasena
			}
		});
	};
	this.listaUsuarios = function(){
		return $http({
			method : 'GET',
			url : URL_SERVICIO_LISTA
		});
	};
	
	
	
	this.guardar = function(usuario){
		return $http({
			method : 'POST',
			url : URL_SERVICIO_GUARDAR,
			params : {
				nombreUsuario : usuario.nombreUsuario,
				tipoId : usuario.tipoId,
				numeroIdentificacion : usuario.numeroIdentificacion,
				nombres :  usuario.nombres,
				apellidos : usuario.apellidos,
				direccion : usuario.direccion,
				telefono : usuario.telefono,
				email: usuario.email,
				contrasena : usuario.contrasena,
				cliente : usuario.cliente
			}
		});
	};
});

appUsuarios.service('Ordenes', function($http){
	this.listaOrdenes = function(){
		return $http({
			method : 'GET',
			url : URL_SERVICIO_LISTA_ORDENES
		});
	};
	
	
	
	this.guardar = function(usuario){
		return $http({
			method : 'POST',
			url : URL_SERVICIO_GUARDAR_ORDENES,
			params : {
				nombreUsuario : usuario.nombreUsuario,
				tipoId : usuario.tipoId,
				numeroIdentificacion : usuario.numeroIdentificacion,
				nombres :  usuario.nombres,
				apellidos : usuario.apellidos,
				direccion : usuario.direccion,
				telefono : usuario.telefono,
				email: usuario.email,
				contrasena : usuario.contrasena,
				cliente : usuario.cliente
			}
		});
	};
});

appUsuarios.config([ '$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl : 'usuarios/login.html',
		controller : 'contLogin'
	});
	
	$routeProvider.when('/usuario', {
		templateUrl : 'usuarios/usuario.html',
		controller : 'contUsuario'
	});
	
	$routeProvider.when('/inicio', {
		templateUrl : 'usuarios/dash.html',
		controller : 'contDash'
	});
	
	$routeProvider.when('/ordenes', {
		templateUrl : 'ordenes/listaOrdenCompra.html',
		controller : 'contOrdenes'
	});
	
	$routeProvider.when('/ordenes/ordenCompra', {
		templateUrl : 'ordenes/ordenCompra.html',
		controller : 'contOrden'
	});

} ]);

//Controlador para manejar el formulario de autenticación
appUsuarios.controller('contLogin', function($scope,auth, Usuarios) {
		    //la función login que llamamos en la vista llama a la función
		    //login de la factoria auth pasando lo que contiene el campo
		    //de texto del formulario
		    $scope.login = function(){
		    	
		    	Usuarios.validar($scope.nombreUsuario, $scope.pws).success(function(data){
		    		if(data != ''){
		    			alert(data);
		    			$scope.nombreUsuario = '';
		    			$scope.pws = '';
		    			return;
		    		}else{
		    			auth.login($scope.nombreUsuario);
		    		}
		    	});
		    };
		 
		});



appUsuarios.controller('contUsuario', function($scope, $location, $cookies, Usuarios){
	$scope.usuario = {
			nombreUsuario : '',
			tipoId : '',
			numeroIdentificacion : '',
			nombres :  '',
			apellidos : '',
			direccion : '',
			telefono : '',
			email: '',
			contrasena : '',
			cliente : ''
			
	};
	
	$scope.guardar = function(){
		Usuarios.guardar($scope.usuario, $cookies.nombreUsuario).success(function(data){
			$location.url('/inicio');
		});
	};
});



appUsuarios.controller("contDash", function contDash($scope, $location,  $cookies){
	$scope.toOrden = function(){
		$location.url("/ordenes");
	};
});

appUsuarios.controller('contOrdenes', function($scope, $location, $cookies, Ordenes){
	Ordenes.listaOrdenes().success(function(data){
		alert(data);
		$scope.ordenesCompra = data.OrdenCompra;
	});
	
	$scope.agregar = function(){
		$location.url('/ordenes/ordenCompra');
	};
	
});

appUsuarios.controller('contOrden', function($scope, $location, $cookies, Ordenes){
	$scope.ordenCompra = {
			numOrdenCompra : '',
			cliente : '',
			formaPago : '',
			plazoEntrega : '',
			fechaEntrega : '', 
			direccionEntrega : '',
			valorTotal : '',
		    usuarioCrea : ''
	};
	
	$scope.guardar = function(){
		Usuarios.guardar($scope.ordenCompra, $cookies.nombreUsuario).success(function(data){
			$location.url('/ordenes');
		});
	};
});
appUsuarios.run(function($rootScope, auth)
	{
		$rootScope.$on('$rootChangeStart', function()
				{
					auth.validarEstado();
				});
				
	
	});


