var app = angular.module('myApp', ['ngRoute', 'ngFileUpload', 'ui.bootstrap', 'ngMessages']);

app.config(function($routeProvider) {
       
       $routeProvider
       
        .when('/homepage', {
              controller: 'signUpController',
            templateUrl: 'html/homepage.html'
            
              
        })
               
        .when('/details/:userId', {
               templateUrl: 'html/details.html',
             controller: 'detailsController'
              
        })
        
        .when('/admin', {
              controller: 'adminController',
            templateUrl: 'html/admin.html'
            
              
        })
        
        .when('/editUser/:id', {
              controller: 'adminEditController',
            templateUrl: 'html/editUser.html'
            
              
        })
        
         .when('/showdetailsforuser/:userId',   
                     {
                            templateUrl: 'html/showdetails.html',
                            controller: 'viewDetailsController'
              
                     })
        
        .when('/userwelcome/:id', 
                     {
                            templateUrl: 'html/userwelcome.html',
                            controller: 'welcomeController'
              
                     })
       
        .otherwise({
            redirectTo: '/homepage'
              
        });
       
});

app.factory("myFactory", function() {
    return "a value";
});

app.controller('LogoutCtrl',['$scope', '$http', '$location', '$window','$rootScope', function($scope, $http, $location,  $window, $rootScope)          
       {  
		  $rootScope.Username = $window.sessionStorage.userName;
		  $scope.Logout = function()
          {
        	  $http.post('logout', $window.sessionStorage.userId ).success(function(response)          	  
              {
                delete $window.sessionStorage.userName;
                delete $window.sessionStorage.userId;
                $rootScope.logoutHide= true;
                $location.url('/homepage');
              });
          }
                                         
                            
          if($location.path()=='/homepage' )
              {  
        	    $rootScope.logoutHide= true;
              }
       }                    

]);       

