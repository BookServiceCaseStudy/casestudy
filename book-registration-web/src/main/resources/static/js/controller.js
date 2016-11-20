var bookControllers = angular.module('bookControllers', ['bookServices','getById', 'alertsService']);

bookControllers.controller('registerationController', function($scope,bookService,alertsService) {
	$scope.headingTitle = "New Book Registration";
	$scope.register = function() {
		bookService.register($scope.formData,$scope.addBookCompleted,$scope.addBookError);
	};
	
	$scope.addBookCompleted = function(response) {
		$scope.result = response;
	};

	$scope.addBookError = function(response) {
		alertsService.RenderErrorMessage("error in request");
	};
});

bookControllers.controller('searchController', function($scope, bookService,getByIdFilter,alertsService) {
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
		$scope.formData.selectedBook = {id:bookId,name:name,author:author,quantity:quantity-1,searchString:$scope.formData.bookName};
		var found = getByIdFilter($scope.result, bookId);
		found.quantity = found.quantity - 1; 
		bookService.purchase($scope.formData.selectedBook,$scope.purchaseCompleted,$scope.findpropsError);
	};
});
