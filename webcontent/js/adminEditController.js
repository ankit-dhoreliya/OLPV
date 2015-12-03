
app.controller('adminEditController',[ '$scope', '$http', '$location', '$routeParams', '$rootScope',function($scope, $http, $location, $routeParams, $rootScope) {
    
	 $scope.status  = 'Waiting';

	 $scope.options = [
	                   { id : '1', name: 'Open' },
	                   { id : '2', name: 'In-Progress' },
	                   { id : '3', name: 'Rejected' },
	                   { id : '4', name: 'Verified' },
	                   { id : '5', name: 'Closed' }
	                   ];
	 

	if($location.path()!= '/homepage' )
	{
		$rootScope.logoutHide = false;
	}else
	{
		$rootScope.logoutHide = true;
	}
     
	$scope.id = $routeParams.id;
      
       $http.post('editUserdetails', $scope.id).success(function(response)
       {
              $scope.data = response;
             
 
       }).error(function(error)
            {
        alert(error);
    });
       
       
       
       $http.post('viewDoc', $scope.id).success(function(re){
      	  
       	 
      	  $scope.doc = re;
      	
      	  
        }).error(function(error)
                {
            alert(error);
        });
       
       
       $scope.statusChange = function()
       {
    	   $scope.data.status.statusId = $scope.status;
    	   
    	   if($scope.data.status.statusId == 3)
    	   {	
    	   		
 			   $scope.isRejected=true;
    	   		
    	   		
    	   } else {
    		  
    		   $scope.isRejected=false;
    	   }
       };
       
       
       
       
       
       
       $scope.submit = function(){
       $scope.data.comment = $scope.comment;
    	
           
           $scope.data.status.statusId = $scope.status;
          
           $http.post('userdetails', $scope.data).success(function(data)
        	      {	
        	   
        	   			$location.url('/admin');
        	   		  
        	  			
        	      }).error(function(error)
        	              {
        	          alert(error);
        	      });
         
          
       };
       
       
       $scope.comeback = function(){
    	   $location.url('/admin');
    	   
       }
       
      
}]);
