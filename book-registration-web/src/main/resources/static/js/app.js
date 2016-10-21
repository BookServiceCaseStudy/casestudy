var app = angular.module('app', ['ngRoute','ngResource','bookControllers', 'blockUI']);
app.config(function($routeProvider){
    $routeProvider
        .when('/register',{
            templateUrl: '/views/register.html',
            controller: 'registerationController'
        })
        .when('/find',{
            templateUrl: '/views/find.html',
            controller: 'searchController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

