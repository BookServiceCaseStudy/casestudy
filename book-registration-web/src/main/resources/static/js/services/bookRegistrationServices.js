'use strict';
var bookServices = angular.module('bookServices', ['ajaxService']);

bookServices.service('bookService', ['ajaxService', function userService(ajaxService) {
  var self = this;

  self.find = function(formData,successFunction, errorFunction) {
    name = formData.bookName;
    ajaxService.AjaxGet('/find/' + name, successFunction, errorFunction);
  };

  self.register = function(formData, successFunction, errorFunction) {
    ajaxService.AjaxPost(formData, '/register', successFunction, errorFunction);
  };

  self.purchase = function(formData,successFunction, errorFunction) {
	    ajaxService.AjaxPost(formData,'/purchase/', successFunction, errorFunction);
	  };
	  
}]);
