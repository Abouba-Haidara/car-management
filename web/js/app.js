
var locationApp = angular.module('location',[]);

locationApp.controller('locationCtrl',['$scope','$http','$location',function($scope,$http){
   
      
        $scope.findClient = function(){
            $http({
                url:'/ProjetLocation/location?action=findClient&param=' +$scope.matricule,
                method:'GET',
                responseType:'json'
            }).then(function(response){ 
                if(response.data.nom === ""){
                     $scope.notexist = "ce matricule n'existe pas ";
                }else{
                 $scope.nom=response.data.nom;
                 $scope.prenom=response.data.prenom
             }
            });           
        }; 
      $scope.findByMarque = function(){
            $http({
                url:'/ProjetLocation/location?action=findModeleByMarque&param=' +$scope.type,
                method:'GET',
                responseType:'json'
            }).then(function(response){  
                  $scope.data = response.data;                
                  $scope.selectedModel = angular.copy($scope.data);
            });           
        }; 
        
        
        $scope.findLocation = function(){
            $http({
                url:'/ProjetLocation/location?action=findLocation&param=' +$scope.id,
                method:'GET',
                responseType:'json'
            }).then(function(response){ 
                if(response.data.id === ""){
                     $scope.notexist = true;
                }else{
                   $scope.dd=new Date(response.data.datedebut);
                   $scope.df= new Date(response.data.dateretour);
                   $scope.nom=response.data.idClient.nom;
                   $scope.prenom=response.data.idClient.prenom;
                   $scope.marque=response.data.idvoiture.idtype.designation;
                   $scope.modele=response.data.idvoiture.modele;
             }
            });           
        }; 
      
       $scope.findVoiture = function(){
            $http({
                url:'/ProjetLocation/location?action=findVoiture&param=' +$scope.v,
                method:'GET',
                responseType:'json'
            }).then(function(response){ 
                
                   $scope.mnt=response.data. coutparJour;
            });           
        }; 
      
        
        $scope.confirm = function(value){
            $http({
                url:'/ProjetLocation/location?action=retour&param=' +value,
                method:'GET',
                responseType:'json'
            }).then(function(response){ 
                
            });           
        };
        
        //penalite();
           
        function penalite()
        {
              $http({
                url:'/ProjetLocation/location?action=penalite',
                method:'GET'
            }).then(function(){ 
                
            }); 
        }
        
        
        function loadR(){
            $http.get("location", {params: {action: 'retour'}})
           .success(function(data, status, headers, config) {
            
          })
        .error(function(data, status, headers, config) {
          alert("failure");
        });
        }
}]);


