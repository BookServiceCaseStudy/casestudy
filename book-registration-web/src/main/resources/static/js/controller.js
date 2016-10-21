var bookControllers = angular.module('bookControllers', ['bookServices','getById']);

bookControllers.controller('registerationController', function($scope) {
	$scope.headingTitle = "New Book Registration";
});

bookControllers.controller('searchController', function($scope, bookService,getByIdFilter) {
	$scope.headingTitle = "Search Book";
	$scope.find = function() {
		bookService.find($scope.formData,$scope.findPropsCompleted,$scope.findpropsError);
	};

	$scope.findPropsCompleted = function(response) {
		$scope.result = response;
	};

	$scope.findpropsError = function(response) {
		alertsService.RenderErrorMessage("error in request");
	};
	
	$scope.purchaseCompleted = function(response) {
		$scope.result = response; 
	};
	
	$scope.purchase = function (bookId,name,author,quantity)
	{
		$scope.formData.selectedBook = {id:bookId,name:name,author:author,quantity:quantity-1};
		var found = getByIdFilter($scope.result, bookId);
		found.quantity = found.quantity - 1; 
		bookService.purchase($scope.formData.selectedBook,$scope.purchaseCompleted,$scope.findpropsError);
	};
});
