app.controller('viewDetailsController',[ '$scope', '$http', '$location', '$routeParams','$window','$rootScope' , function($scope, $http, $location, $routeParams, $window, $rootScope)
                                          
    {		
				
				$scope.userId = $routeParams.userId;
				$rootScope.Username = $window.sessionStorage.userName;
				
				if($location.path()!= '/homepage' )
				{
				 $rootScope.logoutHide = false;
				}else
				{
					$rootScope.logoutHide = true;
				}
				
			
				$http.post('viewuserdetails', $scope.userId ).success(function(response)
						{
						 $scope.detailsforuser = response;
						}).error(function(error)
						{
						 alert(error);
						});
		
			    $scope.viewdetails =function(id)
				{
				 $location.url('/userwelcome/'+id);
				};
						
				$scope.AnotherService = function()
				{	
				 $location.url('/details/'+$scope.userId);
				}
						
				$scope.Logout = function()
				{	
				 $http.post('logout', $scope.userId ).success(function(response)	
					{
					 $location.url('/homepage');
					});
							
				}
						
						
						
	}]);
