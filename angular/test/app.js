var listaApp = angular.module('listaApp', []);

listaApp.controller('listaController', function PhoneListController($scope) {
  $scope.phones = [
    {
      name: 'juan',
      snippet: 'no'
    }, {
      name: 'pedro',
      snippet: 'soy'
    }, {
      name: 'cristian',
      snippet: 'te'
    }
  ];
  
  $scope.query_me = function(){
    console.log("query me"+$scope.query);
    $scope.phones.push({name:'pop',snippet:'sni'});
    
    var cadena = $scope.query;
    
    var ESTADO_INICIO = 0;
    var ESTADO_INSERT = 1;
    var ESTADO_INTO = 2;
    var ESTADO_ESQUEMA = 3;
    var ESTADO_PUNTO1 = 4;
    var ESTADO_NOMBRE_TABLA = 5;
    var ESTADO_LINK = 6;
    var ESTADO_PARENTESIS_ABIERTO_CAMPO = 7;
    var ESTADO_CAMPO = 8;
    var ESTADO_COMA1 = 9;
    var ESTADO_PARENTESIS_CERRADO_CAMPO = 10;
    var ESTADO_VALUES = 11;
    var ESTADO_PARENTESIS_ABIERTO_VALOR = 7;
    var ESTADO_VALOR = 12;
    var ESTADO_COMA2 = 13;
    var ESTADO_
    var ESTADO_PARENTESIS_ABIERTO_VALOR = 7;
    /*
     * INSERT INTO nombre_tabla VALUES (lista_valores);
     * o
     * INSERT INTO nombre_tabla(lista_campos) VALUES (lista_valores);
     * */
    for(var i = 0; i < cadena.length; i++){
		//console.log(cadena[i]);
	}
  }
});
