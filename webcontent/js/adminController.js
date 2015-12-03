app.controller('adminController',[ '$scope', '$http', '$location', '$rootScope', '$window', function($scope, $http, $location, $rootScope, $window) {
		
$rootScope.Username = $window.sessionStorage.userName;
var totaldata=[];
	
	if($location.path()!= '/homepage' ){
		
		$rootScope.logoutHide = false;
	}else{
		$rootScope.logoutHide = true;
	}
	
	$scope.$watch('status', function()
			{
				var array =[];
				
				if($scope.status!=undefined)
				{
					totaldata.forEach(function(value, arr)
						{
							
							if(value.status.status==$scope.status)
								{
									array.push(value);
									
								}
							console.log($scope.status);
							
						})
						$scope.data = array;		
						$scope.totalItems = array.length;
						console.log(array.length);
						
						
				}
				else{
					$scope.data = totaldata;		
					$scope.totalItems = totaldata.length;
					console.log(totaldata.length);
				}
						
				
			})		
		
	$http.get('getAlldetails').success(function(response)
    	 	{
		$scope.blocked = true;
				$scope.data = response;
				totaldata=response;
				$scope.totalItems = response.length;
		        $scope.currentPage = 1;
		        $scope.itemsPerPage = 9;
		        $scope.maxSize = 5; 
		        
		        
		        
		        
		        $scope.setPage = function (pageNo) {
		            $scope.currentPage = pageNo;
		        };

				
				}).error(function(error)
                    {
					console.log(error);
            });
	
	
	$scope.editUser = function(id)
	{
		
		$location.url('/editUser/'+ id);
	}


}]);


