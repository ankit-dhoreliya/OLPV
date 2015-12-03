app.controller('welcomeController',[ '$scope', '$http', '$location', '$routeParams',  '$rootScope',function($scope, $http, $location, $routeParams, $rootScope)
                                     
 {		
	
		if($location.path()!= '/homepage' )
		{
			$rootScope.logoutHide = false;
		}else
		{
			$rootScope.logoutHide = true;
		}
		
		$scope.id = $routeParams.id;
		$http.post('recordforid', $scope.id ).success(function(response)
		{
			
			$scope.res=response;
			
			$http.post('viewDoc', $scope.id).success(function(re){
		     	  
		     	 
		     	  $scope.doc = re;
		     	
		     	  
		       }).error(function(error)
		               {
		           alert(error);
		       });
		      
			
		});
		
		
		$scope.Logout = function()
		{	
		
			$http.post('logout', $scope.res.userId ).success(function(response)	
					{
						alert(response.userId);
						$location.url('/homepage');
					});
			
		}
		
		  $scope.Back = function(){
			
	    	   $location.url('/showdetailsforuser/' + $scope.res.userId );
	    	   
	       }
		
}]);
