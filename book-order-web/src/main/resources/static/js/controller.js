var bookControllers = angular.module('orderControllers', ['orderServices','getById', 'alertsService']);

bookControllers.controller('pendingController', function($scope,orderService,alertsService) {
	$scope.headingTitle = "All Pending Orders";
	$scope.find = function() {
		orderService.pendingOrders($scope.findPendingOrdersCompleted,$scope.pendingOrdersError);
	};
	
	$scope.completedOrder = function(orderId, bookXref, clientName, number) {
		var data = {id:orderId, externaBookXref:bookXref, clientId:clientName, numberOfBooksRequired:number};
		orderService.completedOrder(data,$scope.ordersCompleted,$scope.ordersCompletedError);
	};
	
	$scope.findPendingOrdersCompleted = function(response) {
		$scope.result = response;
	};

	$scope.pendingOrdersError = function(response) {
		alertsService.RenderErrorMessage("error in request");
	};
	
	$scope.ordersCompleted = function(response) {
		$scope.result = response;
	};

	$scope.ordersCompletedError = function(response) {
		alertsService.RenderErrorMessage("error in request");
	};
});


