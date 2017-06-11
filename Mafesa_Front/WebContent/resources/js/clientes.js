var appUsuarios = angular.module('Clientes', [ 'ngRoute','ngCookies']);

var URL_SERVICIO_VALIDAR_USUARIO = 'http://localhost:8080/Mafesa_WS/rest/Usuario/login';
var URL_SERVICIO_LISTA_ORDENES = 'http://localhost:8080/Mafesa_WS/rest/OrdenCompra/list';
var URL_SERVICIO_GUARDAR_ORDENES = 'http://localhost:8080/Mafesa_WS/rest/OrdenCompra';
var URL_SERVICIO_ELIMINAR_ORDENES = 'http://localhost:8080/Mafesa_WS/rest/OrdenCompra/delete';
var URL_SERVICIO_UPDATE_ORDENES = 'http://localhost:8080/Mafesa_WS/rest/OrdenCompra/update';
var URL_SERVICIO_LISTA_FACTURAS = 'http://localhost:8080/Mafesa_WS/rest/Factura/list';
var URL_SERVICIO_GUARDAR_FACTURA = 'http://localhost:8080/Mafesa_WS/rest/Factura';
var URL_SERVICIO_UPDATE_FACTURA = 'http://localhost:8080/Mafesa_WS/rest/Factura/update';

appUsuarios.factory('auth', function($cookies, $location){
		return{
			login : function(usuario)
			{
				$cookies.nombreUsuario = usuario,
				$location.url('/dash');
			},
			
			validarEstado : function(){
				
				if(typeof($cookies.nombreUsuario) == 'undefined'){
					$location.url('/');
				}
				
				if(typeof($cookies.nombreUsuario) != 'undefined' && $location.url() == '/'){
					$location.url('/dash');
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
				login : usuario,
				pws : contrasena
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
	
	this.guardar = function(ordenCompra, usuario){
		return $http({
			method : 'POST',
			url : URL_SERVICIO_GUARDAR_ORDENES,
			params : {
				
				numOrdenCompra : ordenCompra.numOrdenCompra,
				cliente : ordenCompra.cliente,
				formaPago : ordenCompra.formaPago,
				plazoEntrega : ordenCompra.plazoEntrega,
				fechaEntrega : ordenCompra.fechaEntrega,
				direccionEntrega : ordenCompra.direccionEntrega,
				valorTotal : ordenCompra.valorTotal,
				usuarioCrea : usuario
			}
		});
	};
	
	this.eliminar = function(orden, usuario){
		return $http({
			method : 'DELETE',
			url : URL_SERVICIO_ELIMINAR_ORDENES,
			params : {
				numOrdenCompra : orden,
				usuarioEliminado : usuario
			}
		});
	};
	
	this.modificar = function(orden, usuario){
		return $http({
			method : 'UPDATE',
			url : URL_SERVICIO_UPDATE_ORDENES,
			params : {
				numOrdenCompra : ordenCompra.numOrdenCompra,
				cliente : ordenCompra.cliente,
				formaPago : ordenCompra.formaPago,
				plazoEntrega : ordenCompra.plazoEntrega,
				fechaEntrega : ordenCompra.fechaEntrega,
				direccionEntrega : ordenCompra.direccionEntrega,
				valorTotal : ordenCompra.valorTotal,
				usuarioModifica : usuario
			}
		});
	};
});

appUsuarios.service('Facturas', function($http){
	this.listaFacturas = function(){
		return $http({
			method : 'GET',
			url : URL_SERVICIO_LISTA_FACTURAS
		});
	};
	
	this.guardar = function(factura){
		return $http({
			method : 'POST',
			url : URL_SERVICIO_GUARDAR_FACTURA,
			params : {
				numFactura : factura.numFactura,
				fechaVencimiento : factura.fechaVencimiento,
				numOrdenCompra : factura.numOrdenCompra,
				valorImpuestos : factura.valorImpuestos,
				valorDescuentos : factura.valorDescuentos,
				observaciones : factura.observaciones
			}
		});
	};
	
	this.modificar = function(orden){
		return $http({
			method : 'UPDATE',
			url : URL_SERVICIO_UPDATE_FACTURA,
			params : {
				numFactura : factura.numFactura,
				fechaVencimiento : factura.fechaVencimiento,
				numOrdenCompra : factura.numOrdenCompra,
				valorImpuestos : factura.valorImpuestos,
				valorDescuentos : factura.valorDescuentos,
				observaciones : factura.observaciones
			}
		});
	};
});


appUsuarios.config([ '$routeProvider', function($routeProvider){
	$routeProvider.when('/', {
		templateUrl : 'login.html',
		controller : 'contLogin'
	});
	
	$routeProvider.when('/dash', {
		templateUrl : 'dash.html',
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
	
	$routeProvider.when('/facturas', {
		templateUrl : 'facturas/listaFacturas.html',
		controller : 'contFacturas'
	});
	
	$routeProvider.when('/factura', {
		templateUrl : 'facturas/factura.html',
		controller : 'contFactura'
	});
	
} ]);

appUsuarios.controller('contLogin', function($scope, auth, Usuarios){
	
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

appUsuarios.controller("contDash", function contDash($scope, $location,  $cookies){
	$scope.toOrden = function(){
		$location.url("/ordenes");
	};
	
	$scope.toFactura = function(){
		$location.url("/facturas");
	};
});

appUsuarios.controller('contOrdenes', function($scope, $location, Ordenes,  $cookies){
	Ordenes.listaOrdenes().success(function(data){
		alert(data);
		$scope.ordenesCompra = data.ordenCompra;
	});
	
	$scope.agregar = function(){
		$location.url('/ordenes/ordenCompra');
	};
	
	$scope.mostrarDetalle = function(orden) {
		$location.url('/ordenes/ordenCompra');
	    $scope.current = orden;

	    $ionicModal.fromTemplateUrl('ordenes/detalleOrdenCompra.html', {
	        scope: $scope,
	        animation: 'slide-in-up'
	    }).then(function(modal) {
	        $scope.modal = modal;
	    });
	};
	
	$scope.eliminar = function(orden){
		Ordenes.eliminar($scope.orden, $cookies.nombreUsuario).success(function(data){
			$location.url('/ordenes');
		});
	};
	
	$scope.modificar = function(orden){
		$location.url('/ordenes/ordenCompra');
		Ordenes.modificar($scope.orden).success(function(data){
			$location.url('/ordenes');
		});
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
			valorTotal : ''
	};
	
	$scope.guardar = function(){
		Ordenes.guardar($scope.ordenCompra, $cookies.nombreUsuario).success(function(data){
			$location.url('/ordenes');
		});
	};
	
	$scope.eliminar = function(){
		Ordenes.eliminar($scope.orden).success(function(data){
			$location.url('/ordenes');
		});
	};
	
	$scope.modificar = function(){
		Ordenes.guardar($scope.ordenCompra, $cookies.nombreUsuario).success(function(data){
			$location.url('/ordenes');
		});
	};
	
});

appUsuarios.controller('contFacturas', function($scope, $location, Facturas){
	Facturas.listaFacturas().success(function(data){
		alert(data);
		$scope.facturas = data.factura;
	});
	
	$scope.agregar = function(){
		$location.url('/facturas/factura');
	};
	
	
	
	
	
});

appUsuarios.controller('contFactura', function($scope, $location, Facturas){
	$scope.factura = {
			numFactura : '',
			fechaVencimiento : '',
			numOrdenCompra : '',
			valorImpuestos : '',
			valorDescuentos : '',
			observaciones : ''
	};
	
	$scope.guardar = function(){
		Facturas.guardar($scope.numFactura).success(function(data){
			$location.url('/facturas');
		});
	};
	
	$scope.modificar = function(){
		Facturas.guardar($scope.numero).success(function(data){
			$location.url('/facturas');
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


