'use strict';
var bookServices = angular.module('orderServices', ['ajaxService']);

bookServices.service('orderService', ['ajaxService', function userService(ajaxService) {
  var self = this;

  self.pendingOrders = function(successFunction, errorFunction) {
    ajaxService.AjaxGet('/pending', successFunction, errorFunction);
  };
  
  self.completedOrder = function(formData, successFunction, errorFunction) {
	    ajaxService.AjaxPost(formData,'/completed', successFunction, errorFunction);
	  };
	  
}]);
