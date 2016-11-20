var app = angular.module('app', ['ngRoute','ngResource','orderControllers', 'blockUI']);
app.config(function($routeProvider){
    $routeProvider
        .when('/pending',{
            templateUrl: '/views/pending.html',
            controller: 'pendingController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

