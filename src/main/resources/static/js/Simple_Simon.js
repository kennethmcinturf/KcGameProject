"use strict";
//input variable for solution
var solutionArray = [];
//input variable for user
var userInputArray = [];
//Variable to keep count of score
var myScore = document.getElementById("round-counter");
let topRight = $("#top-right > img");
let topLeft = $("#top-left > img");
let bottomLeft = $("#bottom-left > img");
let bottomRight = $("#bottom-right> img");


    $("#playSimon").click(function () {
        $(this).attr("disabled", true);
        function randomMovement() {
            var random = Math.floor((Math.random() * 4) + 1);
            solutionArray.push(random);
            myScore.innerHTML = solutionArray.length;
            solutionArray.forEach(function (element,index) {
                setTimeout(function(){
                    if (element === 1){
                        topLeft.fadeIn().fadeOut();
                    }else if (element === 2){
                        topRight.fadeIn().fadeOut();
                    }else if (element === 3) {
                        bottomLeft.fadeIn().fadeOut();
                    }else {
                        bottomRight.fadeIn().fadeOut();
                    }
                }, 1000 * index);
            })
        }
        randomMovement();
        function checkForWinner(input) {
            var isWinner = true;
            if (input.length === solutionArray.length){
                input.forEach(function (element,index) {
                    if (element !== solutionArray[index]){
                        isWinner = false;
                    }
                });
                if (isWinner === true){
                    alert("Great job, lets add one more input");
                    userInputArray = [];
                    randomMovement();
                }else {
                    alert('Sorry, but please try again');
                    $("#playSimon").off('click');

                }
            }
        }
        $('#top-left').click(function () {
            userInputArray.push(1);
            checkForWinner(userInputArray);
        });
        $('#top-right').click(function () {
            userInputArray.push(2);
            checkForWinner(userInputArray);
        });
        $('#bottom-left').click(function () {
            userInputArray.push(3);
            checkForWinner(userInputArray);
        });
        $('#bottom-right').click(function () {
            userInputArray.push(4);
            checkForWinner(userInputArray);
        });
    });
    $('#restart').click(function () {
        location.reload();
});