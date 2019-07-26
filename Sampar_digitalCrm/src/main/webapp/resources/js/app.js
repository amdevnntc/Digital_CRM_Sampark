var app = angular.module("app", [ 'ui.router', 'gm' ]);

var image11;
app.directive('fileModel1', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					image11 = element[0].files[0];
					alert(element[0].files[0]);

				});
			});
		}
	};
} ]);

var image1;
app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					image = element[0].files;
					image1 = element[0].files[0];
					console.log(element[0].files);

				});
			});
		}
	};
} ]);

// Service used to share data across controllers
app.service('sharedProperties', function() {
	var hashtable = {};
	return {
		setValue : function(key, value) {
			hashtable[key] = value;
		},
		getValue : function(key) {
			return hashtable[key];
		}
	}
});

app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/main');

	$stateProvider.state('main', {
		url : '/main',
		templateUrl : 'main',
		controller : 'mainController'
	})

	.state('user', {
		url : '/user',
		templateUrl : 'user',
		controller : 'userController'
	})

	.state('client', {
		url : '/client',
		templateUrl : 'client',
		controller : 'ClientController'
	})

	.state('client_bulk', {
		url : '/client_bulk',
		templateUrl : 'client_bulk',
		controller : 'ClientBulkController'
	})

	.state('view_client', {
		url : '/view_client',
		templateUrl : 'view_client',
		controller : 'viewClientController'
	})

	.state('meeting', {
		url : '/meeting',
		templateUrl : 'meeting',
		controller : 'meetingController'
	})

	.state('view_meeting', {
		url : '/view_meeting',
		templateUrl : 'view_meeting',
		controller : 'viewmeetingController'
	})

	.state('edit_meeting', {
		url : '/edit_meeting',
		templateUrl : 'edit_meeting',
		controller : 'editmeetingController'
	})

	.state('view_notes', {
		url : '/view_notes',
		templateUrl : 'view_notes',
		controller : 'notesController'
	})

	.state('bulk_sms', {
		url : '/bulk_sms',
		templateUrl : 'bulk_sms',
		controller : 'bulksmsController'
	})

	.state('device.map', {
		url : '/map',
		templateUrl : 'map',
		controller : 'mapController'
	})

	.state('device.history', {
		url : '/history',
		templateUrl : 'history',
		controller : 'historyController'
	})

	.state('employee', {
		url : '/employee',
		templateUrl : 'employee',
		controller : 'employeeController'
	})

	.state('add_inventory', {
		url : '/add_inventory',
		templateUrl : 'add_inventory',
		controller : 'addinventoryController'
	})

	.state('view_inventory', {
		url : '/view_inventory',
		templateUrl : 'view_inventory',
		controller : 'viewinventoryController'
	})

	.state('view_inventory_em', {
		url : '/view_inventory_em',
		templateUrl : 'view_inventory_em',
		controller : 'viewinventoryController'
	})

	.state('view_mail', {
		url : '/view_mail',
		templateUrl : 'view_mail',
		controller : 'viewmailController'
	})

	.state('enquiry', {
		url : '/enquiry',
		templateUrl : 'enquiry',
		controller : 'enquiryController'
	})

	.state('project', {
		url : '/project',
		templateUrl : 'project',
		controller : 'projectController'
	})

	.state('view_project', {
		url : '/view_project',
		templateUrl : 'view_project',
		controller : 'viewprojectController'
	})
	
	.state('edit_project', {
		url : '/edit_project',
		templateUrl : 'edit_project',
		controller : 'editprojectController'
	})

	.state('commercial', {
		url : '/commercial',
		templateUrl : 'commercial',
		controller : 'commercialController'
	})

	.state('view_commercial', {
		url : '/view_commercial',
		templateUrl : 'view_commercial',
		controller : 'viewcommercialController'
	})
	
	.state('edit_commercial', {
		url : '/edit_commercial',
		templateUrl : 'edit_commercial',
		controller : 'editcommercialController'
	})

	
	.state('residential', {
		url : '/residential',
		templateUrl : 'residential',
		controller : 'residentialController'
	})

	.state('view_residential', {
		url : '/view_residential',
		templateUrl : 'view_residential',
		controller : 'viewresidentialController'
	})
	
	.state('edit_residential', {
		url : '/edit_residential',
		templateUrl : 'edit_residential',
		controller : 'editresidentialController'
	})

	.state('campaign', {
		url : '/campaign',
		templateUrl : 'campaign',
		controller : 'campaignController'
	})

		.state('template', {
		url : '/template',
		templateUrl : 'template',
		controller : 'templateController'
	})
	
	.state('enquiry_meeting', {
		url : '/enquiry_meeting',
		templateUrl : 'enquiry_meeting',
		controller : 'enquirymeetingController'
	})
	.state('view_enqMeeting', {
		url : '/view_enqMeeting',
		templateUrl : 'view_enqMeeting',
		controller : 'viewenquirymeetingController'
	})
	
	.state('sector', {
		url : '/sector',
		templateUrl : 'sector',
		controller : 'sectorController'
	})
	
	.state('society', {
		url : '/society',
		templateUrl : 'society',
		controller : 'societyController'
	})
	
	.state('city', {
		url : '/city',
		templateUrl : 'city',
		controller : 'cityController'
	})

	.state('locality', {
		url : '/locality',
		templateUrl : 'locality',
		controller : 'localityController'
	})
	
});

/* controller for city and locality */
app.controller("cityController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	
	$scope.reset = function() {
		$scope.city = null;
	}

	$scope.getDataOnLoad=function()
	
	{
		$scope.pageloader=true;
		$http({
			method : "POST",
			url : "/digitalCrm/city/list"
		}).then(function mySuccess(response) {
			$scope.pageloader=false;
			$scope.cityList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}
	
	$scope.save = function() {
		
		var data1 = $scope.city;

		$http({
			method : "POST",
			url : "/digitalCrm/city/register",
			data : data1
		}).then(function mySuccess(response) {
			$scope.registerstatus = response.data;
			if ($scope.registerstatus.status) {
				$scope.message = $scope.registerstatus.message
				$scope.cityList = response.data.object;
				
				
				$scope.city = null;
				swal("Success","City  Added Successfully", "success");
			
			} else if ($scope.registerstatus.message == 'user Already Exist') {
				$scope.message = "City Already Exist"
				$scope.pageloader=false;
				swal("Existing city",$scope.message, "success");
			} else {
				$scope.pageloader=false;
				$scope.message = "Something Went Wrong"
					swal("failed",$scope.message, "error");
			}

		}, function myError(response) {
			$scope.pageloader=false;
			$scope.myWelcome = response.statusText;
		});
		
	}
	
	$scope.deleteCity = function(cityData) {
		swal({
			  title: "Are you sure?",
			  text: "Once delete, you will not be able to recover this Sector",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
			
					var data=cityData;
					$http({
						method : "POST",
						url : "/digitalCrm/city/delete",
						data : cityData
					}).then(function mySuccess(response) {
						$scope.cityList = response.data.object;
					
						  swal("success! city deleted successfully !", {
						      icon: "success",
						    });
					}, function myError(response) {
					
						$scope.myWelcome = response.statusText;
					});

			  } else {
			    swal("Your Details are safe!");
			  }
			  
			  
			});
		
	}


	$scope.saveLocality = function() {
		$scope.pageloader=true;
		var data1 = $scope.locality;

		$http({
			method : "POST",
			url : "/digitalCrm/locality/register",
			data : data1
		}).then(function mySuccess(response) {
			$scope.localitystatus = response.data;
			$scope.localityList = response.data.object;
			if ($scope.localitystatus.status) {
				$scope.message = $scope.localitystatus.message
				
				$scope.pageloader=false;
				$scope.city = null;
				swal("Success","locality Added Successfully", "success");
			
			} else if ($scope.registerstatus.message == 'user Already Exist') {
				$scope.message = "locality Already Exist"
				$scope.pageloader=false;
				swal("Existing locality",$scope.message, "success");
			} else {
				$scope.pageloader=false;
				$scope.message = "Something Went Wrong"
					swal("failed",$scope.message, "error");
			}

		}, function myError(response) {
			$scope.pageloader=false;
			$scope.myWelcome = response.statusText;
		});
		
	}
	

	$scope.resetlocality = function() {
		$scope.locality = null;
	}
	
	
	
	$scope.changeCity=function()
	{

		var data1={
				"cityid":$scope.locality.cityid
		}
		$http({
			method : "POST",
			url : "/digitalCrm/locality/list",
			params: data1
		}).then(function mySuccess(response) {
			$scope.localityList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	
	}
	
	
	
	
	
	
	
	$scope.editCity=function(cityData)
	{
		$scope.city=cityData;
	}
	
	
	$scope.deleteLocality = function(localityData) {
		swal({
			  title: "Are you sure?",
			  text: "Once delete, you will not be able to recover this Society",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
			
					var data=localityData;
					$http({
						method : "POST",
						url : "/digitalCrm/locality/delete",
						data : localityData
					}).then(function mySuccess(response) {
						$scope.localityList = response.data.object;
					
						  swal("success! Society delete successfully !", {
						      icon: "success",
						    });
					}, function myError(response) {
					
						$scope.myWelcome = response.statusText;
					});

			  } else {
			    swal("Locality is safe!");
			  }
			});
		
	}
	
	$scope.editLocality=function(localityData)
	{
		$scope.locality=localityData;
	}
	
});

app.controller("viewenquirymeetingController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	
	$scope.enqMeetingInit=function()
	{
		$http({
			method : "POST",
			url : "/digitalCrm/enquiry/list/enquiryMeeting"
		}).then(function mySuccess(response) {
			$scope.enquiryMeetingList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}
	
});

/*-------------------------sectorController---------------------------------------*/

app.controller("sectorController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.reset = function() {
		$scope.sector = null;
	}

	$scope.getDataOnLoad=function()
	
	{
		$scope.pageloader=true;
		$http({
			method : "POST",
			url : "/digitalCrm/sector/list"
		}).then(function mySuccess(response) {
			$scope.pageloader=false;
			$scope.sectorList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}
	
	$scope.save = function() {
		
		var data1 = $scope.sector;

		$http({
			method : "POST",
			url : "/digitalCrm/sector/register",
			data : data1
		}).then(function mySuccess(response) {
			$scope.registerstatus = response.data;
			if ($scope.registerstatus.status) {
				$scope.message = $scope.registerstatus.message
				$scope.sectorList = response.data.object;
				
				
				$scope.sector = null;
				swal("Success","Sector Added Successfully", "success");
			
			} else if ($scope.registerstatus.message == 'user Already Exist') {
				$scope.message = "Sector Already Exist"
				$scope.pageloader=false;
				swal("Existing Sector",$scope.message, "success");
			} else {
				$scope.pageloader=false;
				$scope.message = "Something Went Wrong"
					swal("failed",$scope.message, "error");
			}

		}, function myError(response) {
			$scope.pageloader=false;
			$scope.myWelcome = response.statusText;
		});
		
	}
	
	$scope.deleteSector = function(sectorData) {
		swal({
			  title: "Are you sure?",
			  text: "Once delete, you will not be able to recover this Sector",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
			
					var data=sectorData;
					$http({
						method : "POST",
						url : "/digitalCrm/sector/delete",
						data : sectorData
					}).then(function mySuccess(response) {
						$scope.sectorList = response.data.object;
					
						  swal("success! Sector delete successfully !", {
						      icon: "success",
						    });
					}, function myError(response) {
					
						$scope.myWelcome = response.statusText;
					});

			  } else {
			    swal("sector is safe!");
			  }	
			});
		
	}


	$scope.saveSociety = function() {
		$scope.pageloader=true;
		var data1 = $scope.society;

		$http({
			method : "POST",
			url : "/digitalCrm/society/register",
			data : data1
		}).then(function mySuccess(response) {
			$scope.societystatus = response.data;
			$scope.societyList = response.data.object;
			if ($scope.societystatus.status) {
				$scope.message = $scope.societystatus.message
				$scope.pageloader=false;
				$scope.sector = null;
				swal("Success","Society Added Successfully", "success");
			
			} else if ($scope.registerstatus.message == 'user Already Exist') {
				$scope.message = "Society Already Exist"
				$scope.pageloader=false;
				swal("Existing Sector",$scope.message, "success");
			} else {
				$scope.pageloader=false;
				$scope.message = "Something Went Wrong"
					swal("failed",$scope.message, "error");
			}

		}, function myError(response) {
			$scope.pageloader=false;
			$scope.myWelcome = response.statusText;
		});
		
	}
	

	$scope.resetSociety = function() {
		$scope.society = null;
	}
	
	
	
	$scope.changeSector=function()
	{

		var data1={
				"sectorId":$scope.society.sectorId
		}
		$http({
			method : "POST",
			url : "/digitalCrm/society/list",
			params: data1
		}).then(function mySuccess(response) {
			$scope.societyList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	
	}
	
	
	
	$scope.editSector=function(sectorData)
	{
		$scope.sector=sectorData;
	}
	
	
	$scope.deleteSociety = function(societyData) {
		swal({
			  title: "Are you sure?",
			  text: "Once delete, you will not be able to recover this Society",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
			
					var data=societyData;
					$http({
						method : "POST",
						url : "/digitalCrm/society/delete",
						data : societyData
					}).then(function mySuccess(response) {
						$scope.societyList = response.data.object;
					
						  swal("success! Society delete successfully !", {
						      icon: "success",
						    });
					}, function myError(response) {
					
						$scope.myWelcome = response.statusText;
					});

			  } else {
			    swal("society is safe!");
			  }
			});
		
	}
	
	$scope.editSociety=function(societyData)
	{
		$scope.society=societyData;
	}
	
});

app.controller("viewenquirymeetingController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	
	$scope.enqMeetingInit=function()
	{
		$http({
			method : "POST",
			url : "/digitalCrm/enquiry/list/enquiryMeeting"
		}).then(function mySuccess(response) {
			$scope.enquiryMeetingList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}
	
});
app.controller("enquirymeetingController", function($scope, $http, $timeout,sharedProperties,$window,$interval) {
	
	
	
	$scope.meetingDate=new Date();
	 $scope.reminder=function(remindertime)
	 {
		 $scope.today = new Date();
		 $scope.today.setHours($scope.today.getHours() + remindertime);
	 }
	 
	 
	 
	 
	 
	$scope.enquiryMeetingData = sharedProperties.getValue("enquiryMeetingData");
	
	if($scope.enquiryMeetingData==undefined)
		{
		$window.location.href = '#/enquiry';
		}
	else
		{
		
		}
	
	$scope.saveenqMeeting=function()
	{
		var data1=$scope.meetingenq;
		data1.meetingDate=$('#meetingDate').val();
		data1.fromTime=$('#fromTime').val();
		data1.toTime=$('#toTime').val();
		data1.enquiryId=$scope.enquiryMeetingData.id
		$http({
			method : "POST",
			url : "/digitalCrm/enquiry/save/enquiryMeeting",
			data:data1
		}).then(function mySuccess(response) {
			$scope.enqMeetingStatus = response.data;
			if($scope.enqMeetingStatus.status)
				{
				swal("Success","Meeting Created Successfully", "success");
				$window.location.href = '#/enquiry';
				}
			else
				{
				swal("Error","Something Went Wrong", "error");
				$window.location.href = '#/enquiry';
				}
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}
	
	
})


app.controller("templateController", function($scope, $http, $timeout) {
	$scope.templatview=false;
	$scope.savetemplate = function() {
		$scope.templatview=false;
		$scope.loader = true;
		var formdata = new FormData();
		formdata.append("name", $scope.name);
		formdata.append("startdate", $('#startdate').val());
		formdata.append("enddate", $('#enddate').val());
		formdata.append("description", $scope.description);
        formdata.append("signature",$scope.signature);
		formdata.append("file1", image11);
		$http.post("/digitalCrm/template/save", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.templateData = response.data.object;
			$scope.project = response.data;
			if ($scope.project.status) {
				$('#tttttt').html(response.data.object.template);
				$scope.message = "Success"
				$scope.loader = false;
				$scope.success = true;
		
				$scope.templatview=true;
				$timeout(function() {
					$scope.success = false;
				}, 2000);
			}

			else {
				$scope.message = "Something Went Wrong"
				$scope.error = true;
				$timeout(function() {
					$scope.error = false;
				}, 2000);
			}

		}, function myError(response) {
			$scope.listerror = response.statusText;
			console.log($scope.listerror)
		});

	}
	
	
	
});


app.controller("bodyController", function($scope, $http, $timeout) {
	
	$http({
		method : "POST",
		url : "/digitalCrm/employee/profile"
	}).then(function mySuccess(response) {
		$scope.profiledetails = response.data.object;
	}, function myError(response) {
		$scope.myWelcome = response.statusText;
	});

	
});


// Home controller
app.controller("addinventoryController", function($scope, $http, $timeout) {
	$scope.Title = "addinventoryController";
	$scope.area = true;

	$scope.select = function(aaas) {
		$scope.action = aaas;
	}

	$scope.clientlist = function() {
		$http({
			method : "POST",
			url : "/digitalCrm/client/list"
		}).then(function mySuccess(response) {
			$scope.memberslist = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}

	$scope.projecttype = function() {
		if ($scope.pro.projectype == "Residential") {
			$scope.Propertytype = [ "Builder Floor", "House/Villa",
					"Residential Land", "Residential Apartment",
					"Studio Apartment", "Farm House", "Serviced Apartments",
					"Plot", "Other" ];
		} else {
			$scope.Propertytype = [ "Commercial Shops", "Commercial Showrooms",
					"Commercial Office/Space", "Industrial Lands/Plots",
					"Hotel/Resorts", "Cold Storage", "Other" ];
			$scope.bhk = false;
		}
	}

	$scope.propertytype = function() {
		if ($scope.pro.propertytype == "House/Villa") {
			$scope.area = true;
			$scope.bhk = true;
		} else if ($scope.pro.propertytype == "Farm House") {
			$scope.area = true;
			$scope.bhk = true;
		} else {
			$scope.area = true;
			$scope.bhk = false;
		}
	}
	$scope.reset = function() {
		$scope.pro = null;
	}

	$scope.save = function() {
		$scope.pro.price = $scope.pro.price + " " + $scope.pro.priceunit
		$scope.pro.area = $scope.pro.area + " " + $scope.pro.areaunit
		var data1 = $scope.pro;
		$http({
			method : "POST",
			url : "/digitalCrm/property/save",
			data : data1
		}).then(function mySuccess(response) {
			$scope.employeestatus = response.data;
			if ($scope.employeestatus.message == 'success') {
				$scope.message = "Property Added Successfully"
				$scope.success = true;
				$scope.pro = null;
				$timeout(function() {
					$scope.success = false;
				}, 2000);
			}

			else {
				$scope.message = "Something Went Wrong"
				$scope.error = true;
				$timeout(function() {
					$scope.error = false;
				}, 2000);
			}

		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}
});

app.controller("viewinventoryController", function($scope, $http) {
	$scope.Title = "viewinventoryController";
	 $scope.selectedRow = null;
	$scope.paginationcount=[];
	$scope.activeMenu = $scope.paginationcount[0];
	
	$scope.propertylist1 = function() {
		$scope.pageloader = true;
		document.getElementById("main_body").className = "loading";
		$http({
			method : "POST",
			url : "/digitalCrm/property/list/1"
		}).then(function mySuccess(response) {
			$scope.propertylist = response.data.object;
			if ($scope.propertylist.length == 0) {
				$scope.pageloader = false;
				$scope.nodata = true;
				document.getElementById("main_body").className = "";
			}
			else
				{
				$scope.propertyCount = response.data.count;
				var y = 8;
				var result=($scope.propertyCount/y).toFixed(0);
				var result1 = parseInt(result);
				var remainder=$scope.propertyCount/y
				
				if(remainder>0)
				{
					var finalcount=result1+1;
					for (i = 0; i < finalcount; i++) { 
						$scope.paginationcount.push(i);
						console.log($scope.paginationcount.length)
					}
				}
				}
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		});
	}

	$scope.searchby = function() {
		if ($scope.by == "Residential") {
			$scope.Propertytype = [ "Builder Floor", "House/Villa",
					"Residential Land", "Residential Apartment",
					"Studio Apartment", "Farm House", "Serviced Apartments",
					"Plot", "Other" ];
		} else if ($scope.by == "Commercial") {
			$scope.Propertytype = [ "Commercial Shops", "Commercial Showrooms",
					"Commercial Office/Space", "Industrial Lands/Plots",
					"Hotel/Resorts", "Cold Storage", "Other" ];

		} else {
			$scope.Propertytype = [ "1", "2", "3", "4", "5" ]
		}
	}

	$scope.search = function() {
		$scope.nodata = false;
		$scope.pageloader = true;
		document.getElementById("main_body").className = "loading";
		$http({
			method : "POST",
			url : "/digitalCrm/property/search/list",
			params : data1
		}).then(function mySuccess(response) {
			$scope.propertylist = response.data.object;
			if ($scope.propertylist.length == 0) {
				$scope.pageloader = false;
				$scope.nodata = true;
				document.getElementById("main_body").className = "";
			}
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		});

	}
	
	
	
	
	$scope.pagedata=function(pageno)
	{
		 $scope.selectedRow = pageno;
		 
		$scope.pageloader = true;
		document.getElementById("main_body").className = "loading";
		$http({
			method : "POST",
			url : "/digitalCrm/property/list/"+pageno
		}).then(function mySuccess(response) {
			$scope.propertylist = response.data.object;
			$scope.activeMenu = $scope.propertylist[0];
			if ($scope.propertylist.length == 0) {
				$scope.pageloader = false;
				$scope.nodata = true;
				document.getElementById("main_body").className = "";
			}
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		});
	}
	
	
	
	
});

app.controller('NavigationController', function($scope, $http) {

	$http.get('/digitalCrm/get-menu-items').success(function(data) {
		$scope.items = data;
	});

});

app.controller("meetingController", function($scope, sharedProperties, $http,
		$timeout, $window) {

	$http({
		method : "POST",
		url : "/digitalCrm/employee/list"
	}).then(function mySuccess(response) {
		$scope.employeelist = response.data.object;
	}, function myError(response) {
		$scope.myWelcome = response.statusText;
	});
	$(function() {

		$('.select2').select2()

	})

	$scope.clientids = sharedProperties.getValue("clientid");
	$scope.saveMeeting = function() {
		$scope.meeting.fromtime = $('#fromtime').val();// document.getElementById("fromtime").value;
		$scope.meeting.totime = $('#totime').val();// document.getElementById("totime").value;
		$scope.meeting.clientid = $scope.clientids;
		$scope.meeting.employeeids = $('#employeeids').val()
		var data1 = $scope.meeting;
		data1.meetingdate=$('#meetingdate').val();
		$http({
			method : "POST",
			url : "/digitalCrm/meeting/save",
			data : data1
		}).then(function mySuccess(response) {
			$scope.meetingtatus = response.data;
			if ($scope.meetingtatus.message == 'success') {
				$scope.message = "Meeting Created Successfully"
					swal("Good job!",$scope.message, "success");
				$scope.client = null;
				$timeout(function() {
					
					$window.location.href = '#/view_client';
				}, 2000);

			} else {
				$scope.message = "Something Went Wrong"
					swal("Error",$scope.message, "error");
				$timeout(function() {
					
				}, 2000);
			}

		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}

	$scope.reset = function() {
		$scope.meeting = null;
	}

});

app.controller("viewmeetingController",function($scope, $http, sharedProperties, $window)
		{
					$scope.Title = "viewmeeting";
					document.getElementById("main_body").className = "loading";
					$scope.pageloader = true;
					$scope.init = function() {
						$http({
							method : "POST",
							url : "/digitalCrm/meeting/list"
						})
								.then(
										function mySuccess(response) {
											$scope.meetingList = response.data.object;
											$scope.pageloader = false;
											document.getElementById("main_body").className = "";
										},
										function myError(response) {
											document.getElementById("main_body").className = "";
											$scope.myWelcome = response.statusText;
										});
					}

					
					
					
					$scope.reschedule = function(meetingdata) {
						
						
						swal({
							  title: "Are you sure?",
							  text: "you want to reschedule this meeting!",
							  icon: "warning",
							  buttons: true,
							  dangerMode: true,
							})
							.then((willDelete) => {
							  if (willDelete) {
									$window.location.href = '#/edit_meeting';
									sharedProperties.setValue("meetingdata", meetingdata);
							  } else {
							    swal("Your meeting is safe!");
							  }
							});
							
					}
				

					$scope.cancleMeeting = function(meetingid) {
						swal({
							  title: "Are you sure?",
							  text: "Once Cancle, you will not be able to recover this meeting",
							  icon: "warning",
							  buttons: true,
							  dangerMode: true,
							})
							.then((willDelete) => {
							  if (willDelete) {
								  document.getElementById("main_body").className = "";
									$scope.pageloader = true;
									var data1 = {
										meetingid : meetingid
									}
									$http({
										method : "POST",
										url : "/digitalCrm/meeting/cancle",
										params : data1
									}).then(function mySuccess(response) {
										$scope.meetingList = response.data.object;
										$scope.pageloader = false;
										  swal("success! Your meeting cancle successfully !", {
										      icon: "success",
										    });
										document.getElementById("main_body").className = "";
										$scope.table.destroy();
										$scope.init();
									}, function myError(response) {
										document.getElementById("main_body").className = "";
										$scope.myWelcome = response.statusText;
									});

							  } else {
							    swal("Your meeting  is safe!");
							  }
							});
						
					}

				});

app.controller("editmeetingController", function($scope, $http,
		sharedProperties, $window, $timeout) {
	$scope.Title = "Edit Meeting";
	$scope.meeting = sharedProperties.getValue("meetingdata");
	if ($scope.meeting == undefined) {
		$window.location.href = '#/view_meeting';
	} else {
		$scope.meeting.meetingdate = new Date($scope.meeting.meetingdate)
		$('#fromtime').val($scope.meeting.fromtime)
		$('#totime').val($scope.meeting.totime)
	}

	$scope.editMeeting = function() {
		$scope.meeting.fromtime = $('#fromtime').val();// document.getElementById("fromtime").value;
		$scope.meeting.totime = $('#totime').val()// document.getElementById("totime").value;
		var data1 = $scope.meeting;
		$http({
			method : "POST",
			url : "/digitalCrm/meeting/save",
			data : data1
		}).then(function mySuccess(response) {
			$scope.meetingtatus = response.data;
			if ($scope.meetingtatus.message == 'success') {
				$scope.message = "Meeting Reschedule Successfully"
				$scope.success = true;
				$scope.client = null;
				$timeout(function() {
					$scope.success = false;
					$window.location.href = '#/view_meeting';
				}, 2000);
			} else {
				$scope.message = "Something Went Wrong"
				$scope.error = true;
				$timeout(function() {
					$scope.error = false;
				}, 2000);
			}

		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}

});
app.controller("notesController", function($scope, $http) {
	$scope.Title = "Notes";

	$scope.init = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/client/list"
		}).then(function mySuccess(response) {
			$scope.clientList = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});

	}

	$scope.getnotes = function(clientid) {
		document.getElementById("main_body").className = "loading";
		$scope.nodata = false;
		$scope.pageloader = true;
		var data1 = {
			clientid : clientid
		}

		$http({
			method : "POST",
			url : "/digitalCrm/client/notes/list",
			params : data1
		}).then(function mySuccess(response) {
			$scope.notesList = response.data.object;
			if ($scope.notesList.length == 0) {
				$scope.nodata = true;
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			}
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
			$(function() {
				$('.scroll-notes').slimScroll({
					height : "160px",
					size : '6px',
					railVisible : true,
					railColor : '#fff',
					railOpacity : 1,
					alwaysVisible : true,
					color : "#303b77"
				});
			});
		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}

});
app.controller("employeeController", function($scope, $http, $timeout) {
	$scope.Title = "employeeController";

	
	$scope.reset=function()
	{
		$scope.employee = null;
	}
	
	$scope.save = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		var data1 = $scope.employee;
		$http({
			method : "POST",
			url : "/digitalCrm/employee/register",
			data : data1
		}).then(function mySuccess(response) {
			$scope.employeestatus = response.data;
			if ($scope.employeestatus.status) {
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
				if($scope.employeestatus.message=="success")
					{
					$scope.employee = null;
					}
				
				swal("Success",$scope.employeestatus.message, "success");	
			}

			else {
				document.getElementById("main_body").className = "";
				$scope.pageloader = false;
				swal("failed","Something Went Wrong", "error");
			}

		}, function myError(response) {
			document.getElementById("main_body").className = "loading";
			$scope.myWelcome = response.statusText;
			swal("failed","Something Went Wrong", "error");
		});
	}

	$scope.viewEmployee = function() {
		$scope.pageloader = true;
		document.getElementById("main_body").className = "loading";
		$http({
			method : "POST",
			url : "/digitalCrm/employee/list"
		}).then(function mySuccess(response) {
			$scope.employeelist = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});

	}
});

app.controller("customerController", function($scope) {
	$scope.Title = "Customer";
});

app.controller("mainController", function($scope,$http) {
	

	
	$scope.Office=[];
	$scope.Shop=[];
	$scope.Land=[];
	$scope.Showroom=[];
	$scope.Agri=[];
	$scope.Industrial=[];
	$scope.Factory=[];
	$scope.Ware=[];
	$scope.other=[];
	
	$scope.Apartment=[];
	$scope.Builder=[];
	$scope.Plot=[];
	$scope.House=[];
	$scope.Studio=[];
	$scope.Farm=[];
	
	
	
/* document.getElementById("main_body").className = "loading"; */
	$scope.Title = "Main";
	$scope.pageloader = true;
	$http({
		method : "POST",
		url : "/digitalCrm/commercial/graph/data",
	}).then(function mySuccess(response) {
		$scope.commercialGraph = response.data.object;
		document.getElementById("main_body").className = "";
		var range = [];
		for(var i=0;i<$scope.commercialGraph.length;i++) {
			
			var data=$scope.commercialGraph[i];
			
			if(data=="Office")
				{
				$scope.Office.push(i);
				}
			else if(data=="Shop")
				{
				$scope.Shop.push(i)
				}
			else if(data=="Land/Inst.land")
				{
				$scope.Land.push(i)
				}
			else if(data=="Showroom")
			{
			$scope.Showroom.push(i)
			}
			else if(data=="Agri/Farm Land")
			{
			$scope.Agri.push(i)
			}
			else if(data=="Industrial Land")
			{
			$scope.Industrial.push(i)
			}
			else if(data=="Factory")
			{
			$scope.Factory.push(i)
			}
			else if(data=="Ware House")
				{
				$scope.Ware.push(i)
				}
			else
				{
				$scope.other.push(i)
				}
		}
	    // DONUT CHART
    var donut = new Morris.Donut({
      element: 'Commercial',
      resize: true,
      colors: ["#f56954","#00a65a","#f39c12","#00c0ef","#3c8dbc","#d2d6de","#4558BE","#26E480"],
      data: [
        {label: "Office", value: $scope.Office.length},
        {label: "Land/Inst.land", value: $scope.Land.length},
        {label: "Shop", value: $scope.Shop.length},
        {label: "Showroom", value: $scope.Showroom.length},
        {label: "Agri/Farm Land", value: $scope.Agri.length},
        {label: "Industrial Land", value: $scope.Industrial.length},
        {label: "other", value: $scope.other.length},
        {label: "Factory", value: $scope.Factory.length}
      ],
      hideHover: 'auto'
    });
		
	    $scope.pageloader = false;
	}, function myError(response) {
		$scope.pageloader = false;
		document.getElementById("main_body").className = "";
		$scope.myWelcome = response.statusText;
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$http({
		method : "POST",
		url : "/digitalCrm/residential/graph/data",
	}).then(function mySuccess(response) {
		$scope.residentialGraph = response.data.object;
		for(var i=0;i<$scope.residentialGraph.length;i++) {
			
			var residentialGraphdata=$scope.residentialGraph[i];
			
			if(residentialGraphdata=="Apartment")
				{
				$scope.Apartment.push(i);
				}
			else if(residentialGraphdata=="Builder_Floor")
				{
				$scope.Builder.push(i)
				}
			else if(residentialGraphdata=="Plot_Land")
				{
				$scope.Plot.push(i)
				}
			else if(residentialGraphdata=="House_Villa")
			{
			$scope.House.push(i)
			}
			else if(residentialGraphdata=="Studio_Apartment")
			{
			$scope.Studio.push(i)
			}
			else if(residentialGraphdata=="Farm_House")
			{
			$scope.Farm.push(i)
			}
		}
		
		
		
		
		 var donut = new Morris.Donut({
		      element: 'residential',
		      resize: true,
		      colors: ["#f56954","#00a65a","#f39c12","#00c0ef","#3c8dbc","#4558BE","#26E480"],
		      data: [
		        {label: "Apartment", value:$scope.Apartment.length},
		        {label: "Builder Floor", value: $scope.Builder.length},
		        {label: "Plot/Land", value: $scope.Plot.length},
		        {label: "House/Villa", value: $scope.House.length},
		        {label: "Studio Apartment", value:$scope.Studio.length},
		        {label: "Farm House", value: $scope.Farm.length}
		      
		      ],
		      hideHover: 'auto'
		    });
	    $scope.pageloader = false;
	}, function myError(response) {
		$scope.pageloader = false;
		document.getElementById("main_body").className = "";
		$scope.myWelcome = response.statusText;
	});
	 
});

app.controller("bulksmsController", function($scope, $http, $timeout) {
	$scope.Title = "bulksms";

	$(function() {

		$('.select2').select2()
		$("#checkbox22").click(function() {
			if ($("#checkbox22").is(':checked')) {
				$("#membermobile > option").prop("selected", "selected");
				$("#membermobile").trigger("change");
			} else {
				$("#membermobile > option").prop("selected", false);
				$("#membermobile").trigger("change");
			}
		});
		$("#membermobile")
				.change(
						function() {
							if ($('#membermobile > option').length == $(
									"#membermobile").val().length) {
								$('#checkbox22').prop('checked', true);

							} else {
								$('#checkbox22').prop('checked', false);
							}
						});
	});

	$scope.sms = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		var data1 = {
			"date" : new Date()
		}
		$http({
			method : "POST",
			url : "/digitalCrm/sms/list",
			params : data1
		}).then(function mySuccess(response) {
			$scope.smslist = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}

	$scope.historysms = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		var data1 = {
			"date" : $('#date').val()
		}
		$http({
			method : "POST",
			url : "/digitalCrm/sms/history/list",
			params : data1
		}).then(function mySuccess(response) {
			$scope.smslist = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}

	$scope.selectmember = function() {
		$scope.memberslist = "";
		if ($scope.members == "client") {
			$http({
				method : "POST",
				url : "/digitalCrm/client/list"
			}).then(function mySuccess(response) {
				$scope.memberslist = response.data.object;
			}, function myError(response) {
				$scope.myWelcome = response.statusText;
			});
		} else {
			$http({
				method : "POST",
				url : "/digitalCrm/employee/list"
			}).then(function mySuccess(response) {
				$scope.memberslist = response.data.object;
			}, function myError(response) {
				$scope.myWelcome = response.statusText;
			});
		}
	}

	$scope.saveSms = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$scope.smss.contacts = $('#membermobile').val();
		var data1 = $scope.smss;

		$http({
			method : "POST",
			url : "/digitalCrm/sms/save",
			data : data1
		}).then(function mySuccess(response) {
			$scope.msgstatus = response.data;
			if ($scope.msgstatus.status) {
				$scope.message = $scope.msgstatus.message;
				$scope.pageloader = false;
				$scope.success = true;
				$timeout(function() {
					$scope.success = false;
				}, 2000);
				document.getElementById("main_body").className = "";
			} else {
				$scope.message = $scope.msgstatus.message;
				document.getElementById("main_body").className = "";
				$scope.pageloader = false;
				$scope.fail = true;
				$timeout(function() {
					$scope.fail = false;
				}, 2000);
			}
		}, function myError(response) {
			document.getElementById("main_body").className = "loading";
			$scope.myWelcome = response.statusText;
		});
	}

});

app.controller("ClientController", function($scope, $http, $timeout,
		sharedProperties) {
	
	
	$scope.myVar=false;
	
	
    
	
	$scope.chnageClient=function()
	{
		if($scope.client.clientType=="Broker")
			{
			$scope.myVar=true;
			}
		else
			{
			$scope.myVar=false;
			}
	}
	
	$scope.reset=function()
	{
		$scope.client = null;
	}
	$scope.today=new Date();

	$scope.client = sharedProperties.getValue("editdata");
	if ($scope.client === undefined) {

	} else {
		$scope.client.anniversary = new Date($scope.client.anniversary);
		$scope.client.dob = new Date($scope.client.dob);
	}
	$scope.reset = function() {
		$scope.client = null;
	}

	$scope.save = function() {
		$scope.pageloader=true;
		var data1 = $scope.client;
		$http({
			method : "POST",
			url : "/digitalCrm/client/register",
			data : data1
		}).then(function mySuccess(response) {
			$scope.registerstatus = response.data;
			if ($scope.registerstatus.status) {
				$scope.message = $scope.registerstatus.message
				$scope.pageloader=false;
				$scope.client = null;
				swal("Success","Client Added Successfully", "success");
			
			} else if ($scope.registerstatus.message == 'user Already Exist') {
				$scope.message = "User Already Exist"
				$scope.pageloader=false;
				swal("Existing User",$scope.message, "success");
			} else {
				$scope.pageloader=false;
				$scope.message = "Something Went Wrong"
					swal("failed",$scope.message, "error");
			}

		}, function myError(response) {
			$scope.pageloader=false;
			$scope.myWelcome = response.statusText;
		});
	}

});

app.controller("ClientBulkController", function($scope, $http, $timeout) {

	$scope.uploadbtn = false;
	$scope.uploadspinner = false;

	$scope.uploadFiles = function() {
		$scope.pageloader=true;
		document.getElementById("main_body").className = "loading";
		$scope.uploadbtn = true;
		$scope.uploadspinner = true;
		var formdata = new FormData();
		formdata.append("file1", image1);
		$http.post("/digitalCrm/client/bulk/client", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.clientadd = response.data.status;
			if ($scope.clientadd) {
				$scope.pageloader=false;
				
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
				$scope.message = response.data.message;
				swal("Success", $scope.message , "success");
				document.getElementById("main_body").className = "";

			} else {
				document.getElementById("main_body").className = "";
				
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
				$scope.message = response.data.message;
				swal("Error", $scope.message , "error");

			}
		}, function myError(response) {
			$scope.pageloader=false;
			document.getElementById("main_body").className = "";
			$scope.listerror = response.statusText;
			console.log($scope.listerror)
		});

	}

});

app.controller("viewClientController", function($scope, $http, $window,
		sharedProperties) {
	$scope.Title = "viewClientController";

	$scope.pageloader = true;
	document.getElementById("main_body").className = "loading";
	
	
	
	$scope.randomClient = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/enquiry/list"
		}).then(function mySuccess(response) {
			$scope.enquirylist = response.data.object;

			if ($scope.enquirylist.length == 0) {
				$scope.nodata = true;
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			} else {
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			}

		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});

	}
	
	
	
	$scope.clientListInit=function()
	{
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		
		$http({
			method : "POST",
			url : "/digitalCrm/client/list"
		}).then(function mySuccess(response) {
			$scope.clientList = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";

		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}

	$scope.edit = function(editdata) {
		$window.location.href = '#/client';
		sharedProperties.setValue("editdata", editdata);
	}

	$scope.createMeeting = function(clientid) {
		$window.location.href = '#/meeting';
		sharedProperties.setValue("clientid", clientid);
	}

	$scope.notes = function() {
		$window.location.href = '#/view_notes';
	}
});

app.controller("viewmailController", function($scope, $http) {
	$scope.Title = "viewmailController";
	// iCheck for checkbox and radio inputs
	$('.mailbox-messages input[type="checkbox"]').iCheck({
		checkboxClass : 'icheckbox_flat-blue',
	});
	// Enable check and uncheck all functionality
	$(".checkbox-toggle").click(
			function() {
				var clicks = $(this).data('clicks');
				if (clicks) {
					// Uncheck all checkboxes
					$(".mailbox-messages input[type='checkbox']").iCheck(
							"uncheck");
					$(".fa", this).removeClass("fa-check-square-o").addClass(
							'fa-square-o');
				} else {
					// Check all checkboxes
					$(".mailbox-messages input[type='checkbox']").iCheck(
							"check");
					$(".fa", this).removeClass("fa-square-o").addClass(
							'fa-check-square-o');
				}
				$(this).data("clicks", !clicks);
			});

	$scope.mailinit = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/mail/list"
		}).then(function mySuccess(response) {
			$scope.maillist = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}

});
app.controller("enquiryController", function($scope, $http, $timeout,sharedProperties,$window) {
	$scope.Title = "enquiryController";
	$scope.property="Residential Type";
	$scope.enquiry={
			"enquiryFor":"Residential"
	}

	
	$scope.Propertytype = [ "Builder_Floor", "House_Villa","Apartment","Studio_Apartment", "Farm_House","Plot_Land"];
	
	$scope.enquiryInit = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/enquiry/list"
		}).then(function mySuccess(response) {
			$scope.enquirylist = response.data.object;

			if ($scope.enquirylist.length == 0) {
				$scope.nodata = true;
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			} else {
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			}

		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});

	}
	
	
	$scope.projecttype = function() {
		if ($scope.enquiry.enquiryFor == "Residential") {
			
			$scope.property="Residential Type";
			$scope.Propertytype = [ "Builder_Floor", "House_Villa","Apartment","Studio_Apartment", "Farm_House","Plot_Land"];
			
		} else {
			$scope.property="Commercial Type";
			$scope.Propertytype = [ "Office", "Shop",
					"Agri_Farm_Land", "Industrial_Lands_Plots",
					"Factory", "Ware_House"];
			$scope.bhk = false;
		}
	}


	$scope.viewDetails = function(details) {
		$scope.projectview = false;
		$scope.propertyview = false;
		$scope.residentialpropertyview=false;
		$scope.viewData = details
		$scope.modalLoader = true;

		var data1 =details
		$scope.modalLoader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/enquiry/search/list",
			data : data1
		}).then(function mySuccess(response) {
			$scope.propertylist = response.data.object;
			if ($scope.propertylist.length == 0) {
				$scope.modalLoader = false;
				$scope.nodata = true;
			} else {
				if(details.enquiryFor=="Residential")
					{
					$scope.residentialpropertyview = true;
					$scope.modalLoader = false;	
					}
				else
					{
					$scope.propertyview = true;
					$scope.modalLoader = false;
					}
				
				
				
			}

		}, function myError(response) {
			$scope.myWelcome = response.statusText;
			$scope.modalLoader = false;
		});

	
	}

	$scope.enquiryFor = function() {
		if ($scope.enquiry.enquiryFor == "project") {
			$scope.pgname = true;
		} else {
			$scope.pgname = false;
		}
	}

	$scope.save = function() {
		var data1 = $scope.enquiry;
		$http({
			method : "POST",
			url : "/digitalCrm/enquiry/save",
			data : data1
		}).then(function mySuccess(response) {
			$scope.registerstatus = response.data;
			if ($scope.registerstatus.message == 'success') {
				$scope.message = "Success"
			
				$scope.enquiry = null;
				swal("Success", "Your Enquiry Created Successfully!", "success");
				
			}

			else {
				$scope.message = "Something Went Wrong"
					swal("Failed",$scope.message, "error");
			}

		}, function myError(response) {
			swal("Failed","Something Went Wrong", "error")
			$scope.myWelcome = response.statusText;
		});
	}
	
	
	$scope.sendSms=function(property,contact)
	{
		$scope.modalLoader = true;
		var data1=property;
		
		$http({
			method : "POST",
			url : "/digitalCrm/property/notifiy/"+contact,
			data : data1
		}).then(function mySuccess(response) {
			$scope.notifiystatus = response.data.status;
			if($scope.notifiystatus)
				{
				$scope.message = "Notified Successfully"
					$scope.modalLoader = false;
					$scope.success = true;
					$timeout(function() {
						$scope.success = false;
					}, 2000);
				}
			else
				{
				$scope.modalLoader = false;
				$scope.message = "Something Went Wrong"
					$scope.error = true;
					$timeout(function() {
						$scope.error = false;
					}, 2000);
				}
		}, function myError(response) {
			$scope.modalLoader = false;
			$scope.myWelcome = response.statusText;
			
		});
		
		console.log(property,contact)
	}
	
	
	
	$scope.transfer=function(enquiry)
	{
		$scope.enquirydetails=enquiry;
		
		$http({
			method : "POST",
			url : "/digitalCrm/employee/list"
		}).then(function mySuccess(response) {
			$scope.employeelist = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
	}
	
	
	
	$scope.savetransfer=function()
	{
		console.log($scope.enquirydetails)
		swal({
			  title: "Are you sure?",
			  text: "You want to transfer your lead to someone.",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
                 var data1 = $scope.enquirydetails;
					 data1.employeeid=$scope.employeeid;
					$http({
						method : "POST",
						url : "/digitalCrm/enquiry/update",
						data : data1
					}).then(function mySuccess(response) {
						$scope.registerstatus = response.data;
						if ($scope.registerstatus.message == 'success')
						{
							$('#myModaltransfer').modal('hide');
							swal("Your lead has been successfully trasnfered.", {
							      icon: "success",
							    });
						$timeout(function() {
								$scope.success = false;
								$scope.enquiryInit();
								
							},2000);
							
						}

						else {
							$scope.message = "Something Went Wrong"
							$scope.error = true;
							$timeout(function() {
								$scope.error = false;
							}, 2000);
						}

					}, function myError(response) {
						$scope.myWelcome = response.statusText;
					});
				
				  
				  
				  
				  
				  
				  
				  
				  
			    
			  } else {
			    swal("Your lead is safe.");
			  }
			});
	}
	
	
	
	$scope.reset=function()
	{

		$scope.enquiry = null;
	}
	
	
	
	
	$scope.enquiryProductIdslist = [];
	$scope.enquirycount=0;
	$scope.enquiryProductIdlist=function(value)
	{
		
	if($scope.enquiryProductIdslist.length==0)
		{
		$scope.enquiryProductIdslist.push(value);
		console.log($scope.enquiryProductIdslist);
		$scope.enquirycount=$scope.enquiryProductIdslist.length;
		}
	else
		{
		
		if($scope.enquiryProductIdslist.includes(value))
			{
			var index1=$scope.enquiryProductIdslist.indexOf(value);
			
			if (index1 > -1) {
				$scope.enquiryProductIdslist.splice(index1, 1);
				$scope.enquirycount=$scope.enquiryProductIdslist.length;
				
	}
			
			}
		else
			{
			$scope.enquiryProductIdslist.push(value);
			$scope.enquirycount=$scope.enquiryProductIdslist.length;
			}
		
		}
	}
	
	
	
	$scope.share=function(datas,type)
	{
		var data1={
				
				"type":type,
				"residentialid":$scope.enquiryProductIdslist.toString(),
				"clientid":datas.id+",",
				"prorpertytype":datas.enquiryFor,
				"enquiryFor":"enquiry"	
		}
		
		$http({
			method : "POST",
			url : "/digitalCrm/residential/share",
			params : data1
		}).then(function mySuccess(response) {
			$scope.sharestatus = response.data;
			$scope.pageloader = false;
			if($scope.sharestatus.status)
				{
				$('#myModal').modal('hide');
				swal(" Notification has been send  successfully.", {
				      icon: "success",
				    });
				}
			else
				{
				swal(" Something Went Wrong", {
				      icon: "error",
				    });
				}
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}
	$scope.scheduleMeeting=function(meetingData)
	{
		$window.location.href = '#/enquiry_meeting';
		sharedProperties.setValue("enquiryMeetingData", meetingData);
	}
	
});

// Contact controller
app.controller("projectController", function($scope, $http, $timeout) {
	$scope.Title = "projectController";

	$scope.save = function() {
		$scope.loader = true;
		var formdata = new FormData();
		formdata.append("projectname", $scope.project.projectname);
		formdata.append("contactperson", $scope.project.personName);
		formdata.append("contactpersonmobile", $scope.project.personMobile);
		formdata.append("possessionDate", $('#possessionDate').val());
		formdata.append("area", $scope.project.area);
		formdata.append("areatype",  $scope.project.areatype);
		formdata.append("price", $scope.project.price);
		formdata.append("pricein", $scope.project.pricein);
	    formdata.append("locality", $scope.project.locality);
		formdata.append("city", $scope.project.city);
		formdata.append("description", $scope.project.description);
		formdata.append("bookingtype", $scope.project.bookingtype);
		formdata.append("projecstatus", $scope.project.projecstatus);
		formdata.append("projecttype", $scope.project.projecttype)
	    formdata.append("societyId", $scope.project.societyId)
		formdata.append("file1", image11);
		$http.post("/digitalCrm/project/save", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.project = response.data;
			
			if ($scope.project.status) {
			
				$scope.project = null;
				swal("Success", "Your Project added Successfully!", "success");
			}

			else {
				swal("Failed", "Something Went Wrong!", "error");
			}

		}, function myError(response) {
			swal("Failed", "Your Project added Successfully!", "error");
			$scope.listerror = response.statusText;
			
		});

	}
	
	
$scope.getDataOnLoad=function()
	
	{
		$scope.pageloader=true;
		$http({
			method : "POST",
			url : "/digitalCrm/sector/list"
		}).then(function mySuccess(response) {
			$scope.pageloader=false;
			$scope.sectorList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}


$scope.getSociety=function()
{
	
	$scope.societyList=null;

	var data1={
			"sectorId":$scope.society.sectorId
	}
	$http({
		method : "POST",
		url : "/digitalCrm/society/list",
		params: data1
	}).then(function mySuccess(response) {
		$scope.societyList = response.data.object;
	}, function myError(response) {
		$scope.myWelcome = response.statusText;
	});
}

});

app.controller("viewprojectController", function($scope, $http,$window,sharedProperties) {
	$scope.Title = "viewprojectController";
	
	$scope.saletype="Sell";
	$scope.locality="Delhi";
	$scope.projecttype="residential";
	$scope.pricemin="1";
	$scope.pricemax="5";
	$scope.pricein="Lacs";
	
	
	
	$scope.footer=true;
	var id = 0;
	$scope.projectpagination = [];

	$(document).ready(function() {
		
		$(document).ready(function(e){
			
			$('.select2').select2()
			$("#checkbox22").click(function() {
				if ($("#checkbox22").is(':checked')) {
					$("#membermobile > option").prop("selected", "selected");
					$("#membermobile").trigger("change");
				} else {
					$("#membermobile > option").prop("selected", false);
					$("#membermobile").trigger("change");
				}
			});
			
			$(".img-check").click(function(){
				$(this).toggleClass("check");
			});
			
			$('[data-toggle="tooltip"]').tooltip(); 
	});


	});

	$scope.projectInit = function(id) {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/client/list"
		}).then(function mySuccess(response) {
			$scope.clientList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
		$http({
			method : "POST",
			url : "/digitalCrm/project/list/1"
		}).then(function mySuccess(response) {
			$scope.projectlist = response.data.object;
			$scope.count = response.data.count;
			$scope.projectcountboard=true;

			if ($scope.projectlist.length == 0) {
				$scope.nodata = true;
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			} else {
				
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
				$scope.count = response.data.count;
				var y = 8;
				var result=($scope.count/y).toFixed(0);
				var result1 = parseInt(result);
				var remainder=$scope.count/y
				
				if(remainder>0)
				{
					var finalcount=result1+1;
					for (i = 0; i < finalcount; i++) { 
						$scope.projectpagination.push(i);
						console.log($scope.projectpagination.length)
					}
				}
				else
					{
					$scope.projectpagination.push(1);
					}
				
				
			}

		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}
	
	
	$scope.projectProductIdlist = [];
	$scope.projectcount=0;
	$scope.projectproductId=function(value)
	{
		
	if($scope.projectProductIdlist.length==0)
		{
		$scope.projectProductIdlist.push(value);
		console.log($scope.projectProductIdlist);
		$scope.projectcount=$scope.projectProductIdlist.length;
		}
	else
		{
		
		if($scope.projectProductIdlist.includes(value))
			{
			var index1=$scope.projectProductIdlist.indexOf(value);
			
			if (index1 > -1) {
				$scope.projectProductIdlist.splice(index1, 1);
				$scope.projectcount=$scope.projectProductIdlist.length;
				
	}
			
			}
		else
			{
			$scope.projectProductIdlist.push(value);
			$scope.projectcount=$scope.projectProductIdlist.length;
			}
		
		}
	}

	$scope.searchProject = function() {
		$scope.projectcount=0;
		$scope.footer=false;
		$scope.nodata = false;
		$scope.pageloader = true;
	
		var data1 = {
			"saleType" : $scope.saletype,
			"locality" : $scope.locality,
		    "projectType" : $scope.projecttype,
		    "pricemin" : $scope.pricemin,
		    "pricemax" : $scope.pricemax,
		    "pricein" : $scope.pricein
		}
		$http({
			method : "POST",
			url : "/digitalCrm/project/search",
			params : data1
		}).then(function mySuccess(response) {
			$scope.projectlist = response.data.object;
			$scope.count = $scope.projectlist.length;
			if ($scope.projectlist.length == 0) {
				$scope.nodata = true;
				$scope.pageloader = false;
			} else {
				$scope.pageloader = false;
			}

		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}
	
	
	
	
	
	$scope.editProject = function(projectdata) {
		$window.location.href = '#/edit_project';
		sharedProperties.setValue("projectdata", projectdata);
	}
	
	
	
	$scope.projectdata=function(pageno)
	{
			$scope.pageloader = true;
			document.getElementById("main_body").className = "loading";
			$http({
				method : "POST",
				url : "/digitalCrm/project/list/"+pageno
			}).then(function mySuccess(response) {
				$scope.projectlist = response.data.object;
				
				if ($scope.projectlist.length == 0) {
					$scope.pageloader = false;
					$scope.nodata = true;
					document.getElementById("main_body").className = "";
				}
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			}, function myError(response) {
				$scope.myWelcome = response.statusText;
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			});
		
		
	}
	
	
	
	$scope.share=function()
	{
		
		$scope.clientids= $('#membermobile').val();
		
		var data1={
				
				"type":$scope.type,
				"residentialid":$scope.projectProductIdlist.toString(),
				"clientid":$scope.clientids.toString(),
				"prorpertytype":"project",
				"enquiryFor":"Project"
				
		}
		
		$http({
			method : "POST",
			url : "/digitalCrm/residential/share",
			params : data1
		}).then(function mySuccess(response) {
			$scope.sharestatus = response.data;
			$scope.pageloader = false;
			if($scope.sharestatus.status)
				{
				$('#myModal').modal('hide');
				swal(" Notification has been send  successfully.", {
				      icon: "success",
				    });
				}
			else
				{
				swal(" Something Went Wrong", {
				      icon: "error",
				    });
				}
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
		
		
	}

});


app.controller("editprojectController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.doa=new Date();
	$scope.projectdata = sharedProperties.getValue("projectdata");
	if($scope.projectdata==undefined)
		{
		$window.location.href = '#/view_project';
		}
	else
		{
		$scope.project=$scope.projectdata;
	   $scope.doa=new Date($scope.projectdata.possessionDate);
	   
		}
	
	
	
	
	$scope.save = function() {
		$scope.loader = true;
		var formdata = new FormData();
		formdata.append("projectname", $scope.project.projectname);
		formdata.append("contactperson", $scope.project.personName);
		formdata.append("contactpersonmobile", $scope.project.personMobile);
		formdata.append("possessionDate", $('#possessionDate').val());
		formdata.append("area", $scope.project.area);
		formdata.append("areatype",  $scope.project.areatype);
		formdata.append("price", $scope.project.price);
		formdata.append("pricein", $scope.project.pricein);
	    formdata.append("locality", $scope.project.locality);
		formdata.append("city", $scope.project.city);
		formdata.append("description", $scope.project.description);
		formdata.append("bookingtype", $scope.project.bookingtype);
		formdata.append("projecstatus", $scope.project.projecstatus);
		formdata.append("projecttype", $scope.project.projecttype)
		formdata.append("societyId", $scope.project.societyId)
		formdata.append("id", $scope.project.id)
		formdata.append("imagename", $scope.project.imagename)
		formdata.append("file1", image11);
		$http.post("/digitalCrm/project/save", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.project = response.data;
			
			if ($scope.project.status) {
			
				$scope.project = null;
				swal("Success", "Your Project Updated Successfully!", "success");
				$window.location.href = '#/view_project';
			}

			else {
				swal("Failed", "Something Went Wrong!", "error");
			}

		}, function myError(response) {
			swal("Failed", "Something Went Wrong!", "error");
			$scope.listerror = response.statusText;
			
		});

	}
	
});
app.controller("residentialController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	
	
	 $scope.resident={
			 locality:"Gurugram, Haryana, India",
			 city:"Gurugram"
	 }
	
	
	$scope.doa=new Date();
	$scope.plus=true;
	$scope.more=false;
	// Flat red color scheme for iCheck
	$('input[type="radio"].flat-red').iCheck({
		radioClass : 'iradio_flat-green'
	})

	$scope.showmore=function()
	{
		$scope.more=true;
		$scope.minus=true;
		$scope.plus=false;
	}
	
	$scope.hidemore=function()
	{
		$scope.more=false;
		$scope.plus=true;
		$scope.minus=false;
		
		$scope.propertyname=null;
		$scope.balcony=null;
		
		$scope.ownership=null;
		$scope.floor=null;
		$scope.parking=null;
		$scope.description=null;
		document.getElementById("#doa").value="";
	}
	
	
	$scope.save = function() {
		$scope.loader = true;
		var formdata = new FormData();
		
		formdata.append("saletype", $("input[name='SellRent']:checked"). val());
        formdata.append("propertytype",$("input[name='r3']:checked"). val());
		formdata.append("priceType",$("input[name='Price']:checked"). val())
		formdata.append("owneretype",$("input[name='Owner']:checked"). val())
		formdata.append("furnishedType",$("input[name='furnished']:checked"). val())
		formdata.append("ownername", $scope.resident.ownerName);
		formdata.append("propertyname", $scope.resident.propertyname);
		formdata.append("ownermobile", $scope.resident.ownerMobile);
		formdata.append("owneremail", $scope.resident.ownerEmail);
		formdata.append("bedroom", $scope.resident.bedroom);
		formdata.append("bathroom", $scope.resident.bathroom);
		formdata.append("locality", $scope.resident.locality);
		formdata.append("price",$scope.resident.price)
		formdata.append("pricein",$scope.resident.pricein);
		formdata.append("area", $scope.resident.area)
		formdata.append("areatype",$scope.resident.areatype);
		formdata.append("city", $scope.resident.city)
		formdata.append("flatno", $scope.resident.flatNo)
		formdata.append("societyId", $scope.resident.societyId)
		formdata.append("sectorId", $scope.resident.sectorId)
		
		if($scope.more)
			{
			formdata.append("doa",$('#doa').val())
			formdata.append("floor",$scope.resident.floors)
			formdata.append("propertyname", $scope.resident.propertyname);
			formdata.append("description", $scope.resident.description);
			formdata.append("parking", $scope.resident.parking)
			formdata.append("ownership", $scope.resident.ownership)
			formdata.append("image", image11);
			formdata.append("balcony", $scope.resident.balcony)
			formdata.append("societyId", $scope.resident.societyId)
			formdata.append("sectorId", $scope.resident.sectorId)
	        	
			}
		else
			{
			formdata.append("doa",$('#doa').val())
			formdata.append("balcony", $scope.resident.balcony="")
			formdata.append("floor",$scope.resident.floors="")
			formdata.append("propertyname", $scope.resident.propertyname="");
			formdata.append("description", $scope.resident.description="");
			formdata.append("parking", $scope.resident.parking="")
			formdata.append("ownership", $scope.resident.ownership="")
			formdata.append("image", image11);
			}
		$http.post("/digitalCrm/residential/save", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.project = response.data;
			if ($scope.project.status) {	
			swal("Success", "Your Property added Successfully!", "success");
				/*
				 * $scope.success = true; $scope.enquiry = null;
				 * $timeout(function() { $scope.success = false; }, 2000);
				 */
			}

			else {
				
				swal("Failed", "Something Went Wrong!", "error");
				
				/*
				 * $scope.message = "Something Went Wrong" $scope.error = true;
				 * $timeout(function() { $scope.error = false; }, 2000);
				 */}

		}, function myError(response) {

			$scope.listerror = response.statusText;
			console.log($scope.listerror)
		});

	}
	
	
$scope.getDataOnLoad1=function()
	
	{
		$scope.pageloader=true;
		$http({
			method : "POST",
			url : "/digitalCrm/city/list"
		}).then(function mySuccess(response) {
			$scope.pageloader=false;
			$scope.cityList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}

$scope.getLocality=function()
{
	
	$scope.localityList=null;

	var data1={
			"cityid":$scope.locality.cityid
	}
	$http({
		method : "POST",
		url : "/digitalCrm/locality/list",
		params: data1
	}).then(function mySuccess(response) {
		$scope.localityList = response.data.object;
	}, function myError(response) {
		$scope.myWelcome = response.statusText;
	});
}

	
	
$scope.getDataOnLoad=function()
	
	{
		$scope.pageloader=true;
		$http({
			method : "POST",
			url : "/digitalCrm/sector/list"
		}).then(function mySuccess(response) {
			$scope.pageloader=false;
			$scope.sectorList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

	}




$scope.getSociety=function()
{
	
	$scope.societyList=null;

	var data1={
			"sectorId":$scope.society.sectorId
	}
	$http({
		method : "POST",
		url : "/digitalCrm/society/list",
		params: data1
	}).then(function mySuccess(response) {
		$scope.societyList = response.data.object;
	}, function myError(response) {
		$scope.myWelcome = response.statusText;
	});
}

});


app.controller("editresidentialController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.doa=new Date();
	$scope.residentialdata = sharedProperties.getValue("residentialdata");
	if($scope.residentialdata==undefined)
		{
		$window.location.href = '#/view_residential';
		}
	else
		{
	   $scope.resident=$scope.residentialdata;
	   $('#Property_For_'+$scope.resident.saletype).iCheck('check');
	   $('#Property_Type_'+$scope.resident.propertytype).iCheck('check');
	   $('#pricetype_'+$scope.resident.priceType).iCheck('check');
	   $('#ownertype_'+$scope.resident.ownerType).iCheck('check');
	   $('#furnishedtype_'+$scope.resident.furnishedType).iCheck('check');
	   $scope.doa=new Date($scope.resident.doa);
	   
		}
	
	// Flat red color scheme for iCheck
	$('input[type="radio"].flat-red').iCheck({
		radioClass : 'iradio_flat-green'
	})

	$scope.save = function() {
		$scope.loader = true;
		var formdata = new FormData();
		formdata.append("saletype", $("input[name='SellRent']:checked"). val());
        formdata.append("propertytype",$("input[name='r3']:checked"). val());
		formdata.append("priceType",$("input[name='Price']:checked"). val())
		formdata.append("owneretype",$("input[name='Owner']:checked"). val())
		formdata.append("furnishedType",$("input[name='furnished']:checked"). val())
		formdata.append("ownername", $scope.resident.ownerName);
		formdata.append("ownermobile", $scope.resident.ownerMobile);
		formdata.append("owneremail", $scope.resident.ownerEmail);
		formdata.append("bedroom", $scope.resident.bedroom);
		formdata.append("bathroom", $scope.resident.bathroom);
		formdata.append("locality", $scope.resident.locality);
		formdata.append("price",$scope.resident.price)
		formdata.append("pricein",$scope.resident.pricein);
		formdata.append("area", $scope.resident.area);
		formdata.append("areatype",$scope.resident.areatype);
		formdata.append("city", $scope.resident.city)
		formdata.append("flatno", $scope.resident.flatNo)
		formdata.append("doa",$('#doa').val())
		formdata.append("floor",$scope.resident.floors)
		formdata.append("propertyname", $scope.resident.propertyname);
		formdata.append("description", $scope.resident.description);
		formdata.append("parking", $scope.resident.parking)
		formdata.append("ownership", $scope.resident.ownership)
		formdata.append("societyId", $scope.resident.societyId)
		formdata.append("image", image11);
		formdata.append("balcony", $scope.resident.balcony)
		$http.post("/digitalCrm/residential/save", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.project = response.data;
			if ($scope.project.status) {
				$scope.resident=null;	
			swal("Success", "Your Property  data updated Successfully!", "success");
				/*
				 * $scope.success = true; $scope.enquiry = null;
				 * $timeout(function() { $scope.success = false; }, 2000);
				 */
			}

			else {
				
				swal("Failed", "Something Went Wrong!", "error");
				
				/*
				 * $scope.message = "Something Went Wrong" $scope.error = true;
				 * $timeout(function() { $scope.error = false; }, 2000);
				 */}

		}, function myError(response) {

			$scope.listerror = response.statusText;
			console.log($scope.listerror)
		});

	}

	
});

app.controller("viewresidentialController", function($scope, $http,$location,$window,sharedProperties) {
	
	
	 $scope.locality="Gurugram, Haryana, India";
	 $scope.pricemin=1;
	 $scope.pricemax=80;
	 $scope.pricein="Lacs";
	 $scope.bedroom="1";


	$(document).ready(function(e){
		


		$('.select2').select2()
		$("#checkbox22").click(function() {
			if ($("#checkbox22").is(':checked')) {
				$("#membermobile > option").prop("selected", "selected");
				$("#membermobile").trigger("change");
			} else {
				$("#membermobile > option").prop("selected", false);
				$("#membermobile").trigger("change");
			}
		});
		
		$(".img-check").click(function(){
			$(this).toggleClass("check");
		});
		
		$('[data-toggle="tooltip"]').tooltip(); 
});
	
	$scope.$on('gmPlacesAutocomplete::placeChanged', function(){
	      var location = $scope.autocomplete.getPlace().geometry.location;
	      $scope.lat = location.lat();
	      $scope.lng = location.lng();
	      $scope.$apply();
	  }); 
	
	$scope.albumNameArray = [];
$scope.addProrperty=function(value)
{
	
if($scope.albumNameArray.length==0)
	{
	$scope.albumNameArray.push(value);
	}
else
	{
	
	if($scope.albumNameArray.includes(value))
		{
		var index1=$scope.albumNameArray.indexOf(value);
		console.log(index1)
		if (index1 > -1) {
			$scope.albumNameArray.splice(index1, 1);
			console.log($scope.albumNameArray);
}
		
		}
	else
		{
		$scope.albumNameArray.push(value);
		console.log($scope.albumNameArray.toString());
		}
	
	}
}









$scope.getFilter = function() {
    $scope.result = $scope.albumNameArray.filter(function(item, pos) {
      return $scope.albumNameArray.indexOf(item) == pos;
    })
};








	
	$scope.residentialpagination=[];
	
	$('input[type="radio"].flat-red','input[type="checkbox"].minimal-red').iCheck({
		radioClass : 'iradio_flat-green'
	})

	$scope.addfor = "Sell Property";
	$scope.viewresidential = function() {
		$scope.pageloader = true;
		document.getElementById("main_body").className = "loading";
		$http({
			method : "POST",
			url : "/digitalCrm/client/list"
		}).then(function mySuccess(response) {
			$scope.clientList = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
		
		$http({
			method : "POST",
			url : "/digitalCrm/residential/list/1"
		}).then(function mySuccess(response) {
			$scope.residentialList = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
		/*
		 * $scope.footer=true; $scope.viewAll=false;
		 * document.getElementById("main_body").className = "loading";
		 * $scope.pageloader = true; $http({ method : "POST", url :
		 * "/digitalCrm/residential/list/1" }).then(function mySuccess(response) {
		 * $scope.residentiallist = response.data.object; $scope.total =
		 * $scope.residentiallist.length; if ($scope.residentiallist.length ==
		 * 0) { $scope.nodata = true; $scope.pageloader = false;
		 * document.getElementById("main_body").className = ""; } else {
		 * $scope.pageloader = false;
		 * document.getElementById("main_body").className = "";
		 * 
		 * $scope.count = response.data.count; var y = 9; var
		 * result=($scope.count/y).toFixed(0); var result1 = parseInt(result);
		 * var remainder=$scope.count/y
		 * 
		 * if(remainder>0) { var finalcount=result1+1; for (i = 0; i <
		 * finalcount; i++) { $scope.residentialpagination.push(i);
		 * console.log($scope.residentialpagination.length) } } else {
		 * $scope.residentialpagination.push(1); } } }, function
		 * myError(response) { document.getElementById("main_body").className =
		 * ""; $scope.myWelcome = response.statusText; });
		 * 
		 */}


	
	
	
	
	
	
	
	$scope.searchresidential = function() {
	
		$scope.nodata = false;
		$scope.pageloader = true;
		var data1 = {
			"saletype" : $("input[name='SellRent']:checked"). val(),
			"locality" : $scope.locality,
			"propertytype":$scope.albumNameArray.toString(),
			"pricemax" : $scope.pricemin+","+$scope.pricemax,
			"pricein" : $scope.pricein,
			"bedroom" : $scope.bedroom,
		}
		$http({
			method : "POST",
			url : "/digitalCrm/residential/search",
			params : data1
		}).then(function mySuccess(response) {
			$scope.tishu = [];
			$scope.residentiallistfilter = response.data.object;
			$scope.pageloader = false;
			$scope.residentcountboard=true;
			for(var i=0;i<$scope.residentiallistfilter.length;i++)
				{
				for(var j=0;j<$scope.residentiallistfilter[i].length;j++)
				{
				$scope.tishu.push($scope.residentiallistfilter[i][j]);
				$scope.totalresidential=$scope.tishu.length;
				}
				}
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}
	
	
	
	
	$scope.updateInfo=function(editinfo)
	{

		$window.location.href = '#/edit_residential';
		sharedProperties.setValue("residentialdata", editinfo);
		
	}
	
	
	
	
	
	
	$scope.residentialProductIdlist = [];
	$scope.residentcount=0;
	$scope.residentialproductId=function(value)
	{
		
	if($scope.residentialProductIdlist.length==0)
		{
		$scope.residentialProductIdlist.push(value);
		console.log($scope.residentialProductIdlist);
		$scope.residentcount=$scope.residentialProductIdlist.length;
		}
	else
		{
		
		if($scope.residentialProductIdlist.includes(value))
			{
			var index1=$scope.residentialProductIdlist.indexOf(value);
			console.log(index1)
			if (index1 > -1) {
				$scope.residentialProductIdlist.splice(index1, 1);
				$scope.residentcount=$scope.residentialProductIdlist.length;
				console.log($scope.residentialProductIdlist);
	}
			
			}
		else
			{
			$scope.residentialProductIdlist.push(value);
			console.log($scope.residentialProductIdlist.toString());
			$scope.residentcount=$scope.residentialProductIdlist.length;
			}
		
		}
	}

	
	
	
	$scope.share=function()
	{
		
		$scope.clientids= $('#membermobile').val();
		
		var data1={
				
				"type":$scope.type,
				"residentialid":$scope.residentialProductIdlist.toString(),
				"clientid":$scope.clientids.toString(),
				"prorpertytype":"residential",
					"enquiryFor":"residential"
				
		}
		
		$http({
			method : "POST",
			url : "/digitalCrm/residential/share",
			params : data1
		}).then(function mySuccess(response) {
			$scope.sharestatus = response.data;
			$scope.pageloader = false;
			if($scope.sharestatus.status)
				{
				$('#myModal').modal('hide');
				swal(" Notification has been send  successfully.", {
				      icon: "success",
				    });
				}
			else
				{
				swal(" Something Went Wrong", {
				      icon: "error",
				    });
				}
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
		
		
	}
	
	
	
	$scope.residentialdata=function(pageid)
	{
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/residential/list/"+pageid
		}).then(function mySuccess(response) {
			$scope.residentiallist = response.data.object;
			$scope.total = $scope.residentiallist.length;
			if ($scope.residentiallist.length == 0) {
				$scope.nodata = true;
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			} else {
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
				$scope.count = response.data.count;
			}

		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}

	
	
	
	$scope.deleteresidential=function(dataDelete)
	{
		
		
		swal({
			  title: "Are you sure?",
			  text: "Once deleted, you will not be able to recover this data!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  var data1=dataDelete
					$http({
						method : "POST",
						url : "/digitalCrm/residential/delete",
						data : data1
					}).then(function mySuccess(response) {
						$scope.deletestatus = response.data;
						$scope.pageloader = false;
						if($scope.deletestatus.status)
							{
							swal(" Data deleted successfully.", {
							      icon: "success",
							    });
							$scope.viewresidential();
							}
						else
							{
							swal(" Something Went Wrong", {
							      icon: "error",
							    });
							}
						
					}, function myError(response) {
						$scope.myWelcome = response.statusText;
					});
			  } else {
			    swal("Your imaginary data is safe!");
			  }
			});
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	$scope.soldresidential=function(dataDelete)
	{
		swal({
			  title: "Are you sure?",
			  text: "Once sold, you will not be able to recover this data!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  var data1=dataDelete
					$http({
						method : "POST",
						url : "/digitalCrm/residential/sold",
						data : data1
					}).then(function mySuccess(response) {
						$scope.soldstatus = response.data;
						$scope.pageloader = false;
						if($scope.soldstatus.status)
							{
							swal("Property Sold successfully.", {
							      icon: "success",
							    });
							$scope.viewresidential();
							}
						else
							{
							swal(" Something Went Wrong", {
							      icon: "error",
							    });
							}
						
					}, function myError(response) {
						$scope.myWelcome = response.statusText;
					});
			  } else {
			    swal("Your Data  is safe!");
			  }
			});
	}
	
	
});

app.controller("commercialController", function($scope, $http, $timeout) {

	$scope.plus=true;
	// Flat red color scheme for iCheck
	$('input[type="radio"].flat-red').iCheck({
		radioClass : 'iradio_flat-green'
	})
	
	
	
	
	$scope.commercial={
		locality:"Dwarka, Delhi, India",
		city:"Delhi, Delhi, India"
	}
	
		$scope.showmore=function()
	{
		$scope.more=true;
		$scope.minus=true;
		$scope.plus=false;
	}
	
	$scope.hidemore=function()
	{
		$scope.more=false;
		$scope.plus=true;
		$scope.minus=false;
	}
	
	
	

	$scope.save = function() {
		document.getElementById("main_body").className = "loading";
		$scope.loader = true;
		var formdata = new FormData();
		formdata.append("wantto",$("input[name='wantto']:checked"). val());
		formdata.append("propertytype",$("input[name='r3']:checked"). val());
		formdata.append("ownertype",$("input[name='owner']:checked"). val());
		formdata.append("pricetype",$("input[name='Price']:checked"). val());
		
		formdata.append("ownerName", $scope.commercial.ownerName);
		formdata.append("ownerMobile", $scope.commercial.ownerMobile);
		formdata.append("ownerEmail", $scope.commercial.ownerEmail);
		formdata.append("price", $scope.commercial.price);
		formdata.append("pricein", $scope.commercial.pricein);
		formdata.append("area", $scope.commercial.area);
		formdata.append("areatype", $scope.commercial.areatype);
		formdata.append("maintainence", $scope.commercial.maintenance);
		formdata.append("maintainencetype", $scope.commercial.maintenancetype);
		formdata.append("locality", $scope.commercial.locality);
		formdata.append("city", $scope.commercial.city);
		formdata.append("floors", $scope.commercial.floors);
		formdata.append("societyId", $scope.commercial.societyId)
		
		if($scope.more)
		{
			formdata.append("projectname", $scope.commercial.projectname);
			formdata.append("file1", image11);
			formdata.append("washroom", $scope.commercial.washroom)
			formdata.append("doa", $('#doa').val());
			formdata.append("ownership", $scope.commercial.ownership);
			formdata.append("parking", $scope.commercial.parking);
			formdata.append("description", $scope.commercial.description);
			formdata.append("lift",$scope.commercial.lift);
			formdata.append("societyId", $scope.commercial.societyId)

		}
		else
			{
			formdata.append("projectname", $scope.commercial.projectname="");
			formdata.append("file1", image11);
			formdata.append("washroom", $scope.commercial.washroom="")
			formdata.append("doa", $('#doa').val());
			formdata.append("ownership", $scope.commercial.ownership="");
			formdata.append("parking", $scope.commercial.parking="");
			formdata.append("description", $scope.commercial.description="");
			formdata.append("lift",$scope.commercial.lift="");
			}
		$http.post("/digitalCrm/commercial/save", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.project = response.data;
			if ($scope.project.status) {
				
				$scope.commercial = null;
				document.getElementById("main_body").className = "";
				swal("Property Addedd Successfully", {
				      icon: "success",
				    });
				
			}

			else {
				document.getElementById("main_body").className = "";
					swal("Something Went Wrong", {
					      icon: "error",
					    });
				
			}

		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.listerror = response.statusText;
			console.log($scope.listerror)
		});

	}
	
	
	$scope.getDataOnLoad=function()
		
		{
			$scope.pageloader=true;
			$http({
				method : "POST",
				url : "/digitalCrm/sector/list"
			}).then(function mySuccess(response) {
				$scope.pageloader=false;
				$scope.sectorList = response.data.object;
			}, function myError(response) {
				$scope.myWelcome = response.statusText;
			});

		}


	$scope.getSociety=function()
	{
		
		$scope.societyList=null;

		var data1={
				"sectorId":$scope.society.sectorId
		}
		$http({
			method : "POST",
			url : "/digitalCrm/society/list",
			params: data1
		}).then(function mySuccess(response) {
			$scope.societyList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}

});

app.controller("viewcommercialController", function($scope, $http,sharedProperties,$window) {
	
	
	 $scope.locality="Gurugram, Haryana, India";
	 $scope.pricemin=1;
	 $scope.pricemax=80;
	 $scope.pricein="Lacs";
	 $scope.bedroom="1";
	 $scope.areain="Sq. Ft."
	 $scope.areamin=1;
	 $scope.areamax=9876;

	
$(document).ready(function(e){
		
		$('.select2').select2()
		$("#checkbox22").click(function() {
			if ($("#checkbox22").is(':checked')) {
				$("#membermobile > option").prop("selected", "selected");
				$("#membermobile").trigger("change");
			} else {
				$("#membermobile > option").prop("selected", false);
				$("#membermobile").trigger("change");
			}
		});
		
		$(".img-check").click(function(){
			$(this).toggleClass("check");
		});
		
		$('[data-toggle="tooltip"]').tooltip(); 
});



$scope.commercialPropertyArray = [];
$scope.addProrperty=function(value)
{
	
if($scope.commercialPropertyArray.length==0)
	{
	$scope.commercialPropertyArray.push(value);
	}
else
	{
	
	if($scope.commercialPropertyArray.includes(value))
		{
		var index1=$scope.commercialPropertyArray.indexOf(value);
		console.log(index1)
		if (index1 > -1) {
			$scope.commercialPropertyArray.splice(index1, 1);
			console.log($scope.commercialPropertyArray);
}
		
		}
	else
		{
		$scope.commercialPropertyArray.push(value);
		console.log($scope.commercialPropertyArray.toString());
		}
	
	}
}

	
$scope.restCount = function() {
	$scope.commercialcount=0;
}


	
	$scope.commercialpagination=[];
	
	$scope.viewcommercial = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/client/list"
		}).then(function mySuccess(response) {
			$scope.clientList = response.data.object;
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
		$http({
			method : "POST",
			url : "/digitalCrm/commercial/list/1"
		}).then(function mySuccess(response) {
			$scope.commercialList = response.data.object;
			$scope.pageloader = false;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		/*
		 * $scope.footer=true; $scope.viewAll=false;
		 * document.getElementById("main_body").className = "loading";
		 * $scope.pageloader = true; $http({ method : "POST", url :
		 * "/digitalCrm/commercial/list/1" }).then(function mySuccess(response) {
		 * $scope.commerciallist = response.data.object;
		 * 
		 * $scope.total = $scope.commerciallist.length; if
		 * ($scope.commerciallist.length == 0) { $scope.nodata = true;
		 * $scope.pageloader = false;
		 * document.getElementById("main_body").className = ""; } else {
		 * $scope.pageloader = false;
		 * document.getElementById("main_body").className = "";
		 * 
		 * $scope.count = response.data.count; var y = 9; var
		 * result=($scope.count/y).toFixed(0); var result1 = parseInt(result);
		 * var remainder=$scope.count/y if(remainder>0) { var
		 * finalcount=result1+1; for (i = 0; i < finalcount; i++) {
		 * $scope.commercialpagination.push(i);
		 * console.log($scope.commercialpagination.length) } } else {
		 * $scope.residentialpagination.push(1); } } }, function
		 * myError(response) { $scope.pageloader = false;
		 * document.getElementById("main_body").className = ""; $scope.myWelcome =
		 * response.statusText; });
		 * 
		 */}

	

	$scope.commercialProductIdlist = [];
	$scope.commercialcount=0;
	$scope.commercialproductId=function(value)
	{
		
	if($scope.commercialProductIdlist.length==0)
		{
		$scope.commercialProductIdlist.push(value);
		
		$scope.commercialcount=$scope.commercialProductIdlist.length;
		}
	else
		{
		
		if($scope.commercialProductIdlist.includes(value))
			{
			var index1=$scope.commercialProductIdlist.indexOf(value);
			console.log(index1)
			if (index1 > -1) {
				$scope.commercialProductIdlist.splice(index1, 1);
				$scope.commercialcount=$scope.commercialProductIdlist.length;
				console.log($scope.commercialProductIdlist);
	}
			
			}
		else
			{
			$scope.commercialProductIdlist.push(value);
			console.log($scope.commercialProductIdlist.toString());
			$scope.commercialcount=$scope.commercialProductIdlist.length;
			}
		
		}
	}

	
	
	
	
	$scope.searchcommercial = function() {
		$scope.footer=false;
		$scope.nodata = false;
		$scope.viewAll=true;
		$scope.pageloader = true;
		var data1 = {
				"saletype" : $("input[name='wantto']:checked"). val(),
				"locality" : $scope.locality,
				"propertytype":$scope.commercialPropertyArray.toString(),
				"pricemax" : $scope.pricemax,
				"pricemin" : $scope.pricemin,
				"pricein" : $scope.pricein,
				"areamax" : $scope.areamax,
				"areamin" : $scope.areamin,
				"areain" : $scope.areain,
			}
		$http({
			method : "POST",
			url : "/digitalCrm/commercial/search",
			params : data1
		}).then(function mySuccess(response) {
			$scope.commercial = [];
			$scope.commercialfilter = response.data.object;
			$scope.pageloader = false;
			$scope.residentcountboard=true;
			for(var i=0;i<$scope.commercialfilter.length;i++)
				{
				for(var j=0;j<$scope.commercialfilter[i].length;j++)
				{
				$scope.commercial.push($scope.commercialfilter[i][j]);
				$scope.totalcommercial=$scope.commercial.length;
				}
				}
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}
	
	
	
	$scope.updatecommercialInfo=function(editinfo)
	{

		$window.location.href = '#/edit_commercial';
		sharedProperties.setValue("commercialdata", editinfo);
		
	}
	$scope.commercialdata=function(pageid)
	{
		document.getElementById("main_body").className = "loading";
		$scope.pageloader = true;
		$http({
			method : "POST",
			url : "/digitalCrm/commercial/list/"+pageid
		}).then(function mySuccess(response) {
			$scope.commerciallist = response.data.object;
			$scope.total = $scope.commerciallist.length;
			if ($scope.commerciallist.length == 0) {
				$scope.nodata = true;
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			} else {
				$scope.pageloader = false;
				document.getElementById("main_body").className = "";
			}

		}, function myError(response) {
			$scope.pageloader = false;
			document.getElementById("main_body").className = "";
			$scope.myWelcome = response.statusText;
		});
	}

	
	
	$scope.share=function()
	{
		
		$scope.clientids= $('#membermobile').val();
		
		var data1={
				
				"type":$scope.type,
				"residentialid":$scope.commercialProductIdlist.toString(),
				"clientid":$scope.clientids.toString(),
				"prorpertytype":"commercial",
				"enquiryFor":"commercial"
				
		}
		
		$http({
			method : "POST",
			url : "/digitalCrm/residential/share",
			params : data1
		}).then(function mySuccess(response) {
			$scope.sharestatus = response.data;
			$scope.pageloader = false;
			if($scope.sharestatus.status)
				{
				$('#myModal').modal('hide');
				swal(" Notification has been send  successfully.", {
				      icon: "success",
				    });
				}
			else
				{
				swal(" Something Went Wrong", {
				      icon: "error",
				    });
				}
			
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}
	
	
	$scope.deletecommercial=function(dataDelete)
	{
		
		
		swal({
			  title: "Are you sure?",
			  text: "Once deleted, you will not be able to recover this data!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  var data1=dataDelete
					$http({
						method : "POST",
						url : "/digitalCrm/commercial/delete",
						data : data1
					}).then(function mySuccess(response) {
						$scope.deletestatus = response.data;
						$scope.pageloader = false;
						if($scope.deletestatus.status)
							{
							swal(" Data deleted successfully.", {
							      icon: "success",
							    });
							$scope.viewcommercial();
							}
						else
							{
							swal(" Something Went Wrong", {
							      icon: "error",
							    });
							}
						
					}, function myError(response) {
						$scope.myWelcome = response.statusText;
					});
			  } else {
			    swal("Your imaginary data is safe!");
			  }
			});
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	$scope.soldcommercial=function(dataDelete)
	{
		
		
		swal({
			  title: "Are you sure?",
			  text: "Once sold, you will not be able to recover this data!",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  
				  var data1=dataDelete
					$http({
						method : "POST",
						url : "/digitalCrm/commercial/sold",
						data : data1
					}).then(function mySuccess(response) {
						$scope.soldstatus = response.data;
						$scope.pageloader = false;
						if($scope.soldstatus.status)
							{
							swal(" Property Sold successfully.", {
							      icon: "success",
							    });
							$scope.viewcommercial();
							}
						else
							{
							swal(" Something Went Wrong", {
							      icon: "error",
							    });
							}
						
					}, function myError(response) {
						$scope.myWelcome = response.statusText;
					});
			  } else {
			    swal("Your Data  is safe!");
			  }
			});
		
		
		
		
		
		
		
		
	}
});


app.controller("editcommercialController", function($scope, $http,sharedProperties,$window) {
	
	$('input[type="radio"].flat-red').iCheck({
		radioClass : 'iradio_flat-green'
	})
	
	$scope.doa=new Date();
	$scope.commercialdatas = sharedProperties.getValue("commercialdata");
	if($scope.commercialdatas==undefined)
		{
		$window.location.href = '#/view_commercial';
		}
	else
		{
	   $scope.commercial=$scope.commercialdatas;
	   $('#lift_'+$scope.commercial.lift).iCheck('check');
	   /*
		 * $('#Property_Type_'+$scope.resident.propertytype).iCheck('check');
		 * $('#pricetype_'+$scope.resident.priceType).iCheck('check');
		 * $('#ownertype_'+$scope.resident.ownerType).iCheck('check');
		 * $('#furnishedtype_'+$scope.resident.furnishedType).iCheck('check');
		 * $scope.doa=new Date($scope.commercial.doa);
		 */
	   
		}
	$scope.save = function() {
		document.getElementById("main_body").className = "loading";
		$scope.loader = true;
		var formdata = new FormData();
		formdata.append("wantto",$("input[name='wantto']:checked"). val());
		formdata.append("propertytype",$("input[name='r3']:checked"). val());
		formdata.append("ownertype",$("input[name='owner']:checked"). val());
		formdata.append("pricetype",$("input[name='Price']:checked"). val());
		formdata.append("lift",$scope.commercial.lift);
		formdata.append("ownerName", $scope.commercial.ownerName);
		formdata.append("ownerMobile", $scope.commercial.ownerMobile);
		formdata.append("ownerEmail", $scope.commercial.ownerEmail);
		formdata.append("price", $scope.commercial.price);
		formdata.append("pricein", $scope.commercial.pricein);
		formdata.append("area", $scope.commercial.area);
		formdata.append("areatype", $scope.commercial.areatype);
		formdata.append("maintainence", $scope.commercial.maintenance);
		formdata.append("maintainencetype", $scope.commercial.maintenancetype);
		formdata.append("locality", $scope.commercial.locality);
		formdata.append("city", $scope.commercial.city);
		formdata.append("floors", $scope.commercial.floors);
		formdata.append("imagename",$scope.commercial.imgUrl);
		formdata.append("id",$scope.commercial.id);
	    formdata.append("projectname", $scope.commercial.projectname);
	    formdata.append("file1", image11);
		formdata.append("washroom", $scope.commercial.washroom)
		formdata.append("doa", $('#doa').val());
		formdata.append("ownership", $scope.commercial.ownership);
		formdata.append("parking", $scope.commercial.parking);
		formdata.append("description", $scope.commercial.description);
		formdata.append("societyId", $scope.commercial.societyId)

		$http.post("/digitalCrm/commercial/save", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.project = response.data;
			if ($scope.project.status) {
				
				$scope.commercial = null;
				document.getElementById("main_body").className = "";
				swal("Property Updated Successfully", {
				      icon: "success",
				    });
				
			}

			else {
				document.getElementById("main_body").className = "";
					swal("Something Went Wrong", {
					      icon: "error",
					    });
				
			}

		}, function myError(response) {
			document.getElementById("main_body").className = "";
			$scope.listerror = response.statusText;
			console.log($scope.listerror)
		});

	}
	
	
	
});

app.controller("campaignController", function($scope, $http, $timeout,$window) {

	
	$scope.today=new Date();
	$scope.templateview=false;
$scope.templateSection=false;
	$scope.camp = {
			
			"notifiyBy":"Sms"
	};

	$(function() {

		$('input[type="radio"].flat-red').iCheck({
			radioClass : 'iradio_flat-green'
		})

		$('.select2').select2()
		$("#checkbox22").click(function() {
			if ($("#checkbox22").is(':checked')) {
				$("#membermobile > option").prop("selected", "selected");
				$("#membermobile").trigger("change");
			} else {
				$("#membermobile > option").prop("selected", false);
				$("#membermobile").trigger("change");
			}
		});
		$("#membermobile")
				.change(
						function() {
							if ($('#membermobile > option').length == $(
									"#membermobile").val().length) {
								$('#checkbox22').prop('checked', true);

							} else {
								$('#checkbox22').prop('checked', false);
							}
						});
	});

	$scope.notifiyBy = function() {
     
		$scope.noti=!$scope.noti;
		$scope.templateview=!$scope.templateview;
		
		/*
		 * if ($scope.notifiyby == "Sms") { $scope.mobile = true; $scope.email =
		 * false; } else { $scope.mobile = false; $scope.email = true; }
		 */

	}

	$scope.campaignInit = function() {
		document.getElementById("main_body").className = "loading";
		$scope.pageloader=true;
		
		$http({
			method : "POST",
			url : "/digitalCrm/client/list"
		}).then(function mySuccess(response) {
			$scope.clientList = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});

		$http({
			method : "POST",
			url : "/digitalCrm/campaign/template/list"
		}).then(function mySuccess(response) {
			$scope.templatelist = response.data.object;
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
		
		
		$http({
			method : "POST",
			url : "/digitalCrm/campaign/list"
		}).then(function mySuccess(response) {
			$scope.campaignList = response.data.object;
			$scope.pageloader=false;
			document.getElementById("main_body").className = "";
		}, function myError(response) {
			$scope.myWelcome = response.statusText;
		});
	}

	$scope.templateViews=function()
	{
		$scope.templateSection=true;
		var myJSON = JSON.parse($scope.camp.templateid)
		$('#tttttt').html(myJSON.template);
	}
	
	$scope.save = function() {
		
		$scope.pageloader=true;
		$scope.camp.mobile = $('#membermobile').val();
		$scope.camp.email = $('#memberemail').val();
		var data1 = $scope.camp;
		var myJSON = JSON.parse($scope.camp.templateid)
		data1.templateid=myJSON.id;
		data1.startDate=$('#startdate').val();
		data1.endDate=$('#enddate').val();
		$http({
			method : "POST",
			url : "/digitalCrm/campaign/save",
			data : data1
		}).then(function mySuccess(response) {
			$scope.campaignstatus = response.data;
			if ($scope.campaignstatus.status) {
				$scope.templateSection=false;
				$scope.message = "Campaign Saved Successfully"
				$scope.campaignList = response.data.object;
				$scope.pageloader=false;
				swal("Success!", $scope.message, "success");
			
				$('#membermobile').val('').trigger('change');
				$('#memberemail').val('').trigger('change');
			
			} else {
				$scope.pageloader=false;
				$scope.message = "Something Went Wrong"
					swal("Error!", $scope.message, "error");
				
			}

		}, function myError(response) {
		
			$scope.myWelcome = response.statusText;
		});
	}

});
