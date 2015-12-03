              
app.controller('signUpController',[ '$scope', '$http', '$location', '$log', '$window', '$rootScope', function($scope, $http, $location, $log, $window, $rootScope) {
              
       if($location.path()!= '/homepage' )
       {
        $scope.logoutHide = false;
       }
       else
       {
        $scope.logoutHide = true;
       }      
       
       $scope.invalidUser=true;
       $scope.pwdDonotMatch = false;
       
       $scope.checkUser = function()
       {
        $scope.invalidUser= true;
       }
       
       $scope.doPwdMatch=function()
       {
    	if(($scope.password2 !=='' || $scope.password2==undefined ) && $scope.passwordd !== $scope.password2)
    	{
		 $scope.pwdDonotMatch = true;
		}else
		{
		 $scope.pwdDonotMatch = false;
		}
	   }
       
       
              
       $scope.submit = function()
       {
		$scope.submitted= false;
		if($scope.passwordd == $scope.password2)
		{
		 var formData = {
						email : $scope.email,
						userName : $scope.userName,
						password : $scope.password2	
						};
		 $http.post('signup', formData ).success(function(response)
				 {
			 	  if(response.userName==undefined)
			 	  {
			 	   $scope.invalidUser=false;
			 	  }
			 	  else
			 	  {
			 	   $('#myModal').modal('hide');
			 	   $scope.submitted=true;
			 	   $location.url('/homepage');
			 	  }
				 }).error(function(error)
				 {
				  $('#myModal').modal('hide');
				 });
		 }
		else
		 {
		  return $scope.pwdDonotMatch = true;
		 }
       };
       
       $scope.options = [
                         { id : '1', name: 'Admin' },
                         { id : '2', name: 'User' }
                        ];
       
       $scope.onLogin = function()
       {
        $scope.submitted= false;
        $scope.loger= false;
        $scope.Error= false;
              
                     
        var formData1 = {	
                           userName : $scope.userName1,
                           password : $scope.password1,
                           role   : {roleId:$scope.role, roleName:''}
              			};
                     
        $http.post('login', formData1 ).success(function(data)
        		{
                 /*$rootScope.obj = data;*/
        	
                   $window.sessionStorage.userId = data.userId;
                   $window.sessionStorage.userName = data.userName;
                   
                
                   $rootScope.userName = data.userName;
                   
                
                    	 
                   if (data.userId == undefined)
                    {      
                     $location.url('/homepage');
                     $scope.loger= true;
                    }
                   else if(data.userstatus.userstatusId == 1)
                    {
                     $location.url('/homepage');
                     $scope.Error= true;
                    }
                   else if(data.role.roleId == 1)
                    {
                     $location.url('/admin');
                    }
                   else
                    {
                     $http.post('checkforId',data).success(function(response)
                      {
                       if(response.id != null)
                        {
                         $location.url('/showdetailsforuser/'+ data.userId);
                        }
                       else 
                        {
                         $location.url('/details/'+ data.userId);
                        }
                      });
                    }
              });
       };
       
       $scope.checkId = function(id)
       {
              
              $http.get('userdetails').then(function(response)
              {
                     
              });
       };
       
       
       

       $scope.forgot = function()
       {
        var formData2 = {
        				  userName	: $scope.userName,
                          email 	: $scope.email1
              			};
        
      
        
        $http.post('forgetPassword',formData2).success(function(data1)
        		{ 
        			
        			if (data1.userName == undefined)
        				{
        				
        				$scope.invalidUserName = true;
        				
        				}
        			else{
        				
        				//$scope.invalidUserName = false;
        				$('#urModal').modal('hide');   
        		        $scope.psswdsent = true;
        				
        			}
        	
        		}).error(function(error)
       				 {
        			alert(error);
        			});
                     
      
              
       };
}]);

