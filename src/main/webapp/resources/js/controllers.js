var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function($scope, $http){
    $scope.refreshCart = function(){
        $http.get('/OnLineHotelReservationSystemWAA/rest/booking/'+$scope.cartId)
                .success(function(data){ 
                    
                    $scope.cart = data;
                   alert("refresh");
        });
    };
    
    $scope.clearCart = function(){
        $http.delete('/OnLineHotelReservationSystemWAA/rest/booking/'+$scope.cartId)
                .sucess($scope.refreshCart());
    };
    
    $scope.initCartId = function(cartId){     
        
        
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };
    
    
//      $scope.addToProduct = function (productId){
//        $http.put('/edu.mum.waa.onlinehotelreservationsystem/add/'+productId)
//                .success(function (){
//                    alert ("Product Successfully added to the Cart!");
//                });
//    };


      $scope.addToCart = function (productId){
        $http.put('/OnLineHotelReservationSystemWAA/rest/booking/add/'+productId)
                .success(function (){
                     $scope.refreshCart();
                    alert ("Product Successfully added to the Cart!");
                });
    };

    
   $scope.getFreeRooms = function(){
        $http.get('/OnLineHotelReservationSystemWAA/booking/freeRooms/'+"HH1")
                .success(function(data){ 
                    
                    $scope.rooms = data;
                   alert("Get the Rooms");
        });
    };
    
    $scope.removeFromCart = function(productId){
        $http.put('/OnLineHotelReservationSystemWAA/rest/booking/remove/'+productId)
                .success(function (){
                   
                    $scope.refreshCart();
                    alert("done");
        });
    };
});