angular.module('mesosdns', [
  'ngRoute',
  'controllers',
  'ngVis'
]);

angular.module('controllers', []);

angular.module('mesosdns')
    .config(['$routeProvider', function ($routeProvider) {
      $routeProvider
        .when("/", {templateUrl: "partials/home.html", controller: "PageCtrl"})
        .otherwise("/404", {templateUrl: "partials/404.html", controller: "PageCtrl"});
    }]).run(function($rootScope, $window, $http, $location) {
});