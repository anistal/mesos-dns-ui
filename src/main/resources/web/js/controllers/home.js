angular.module('controllers').controller('PageCtrl', function ($scope, $http, $interval, VisDataSet) {
    $scope.data = {};

    $http({
            method: 'GET',
            url: '/status'
        }).then(function successCallback(response) {
            $scope.data = response.data
        }, function errorCallback(response) {
            console.log(response);
    });

    $scope.onSelect = function(items) {
          // debugger;
          alert('select');
        };

        $scope.onClick = function(props) {
          //debugger;
          alert('Click');
        };

        $scope.onDoubleClick = function(props) {
          // debugger;
          alert('DoubleClick');
        };

        $scope.rightClick = function(props) {
          alert('Right click!');
          props.event.preventDefault();
        };

        $scope.options = {
          autoResize: true,
          height: '800',
          width: '100%'
        };

});