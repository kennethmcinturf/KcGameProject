"use strict";


var upperLeft = document.getElementById('top-left');
var upperCenter= document.getElementById('top-center');
var upperRight = document.getElementById('top-right');
var centerLeft = document.getElementById('center-left');
var centerCenter = document.getElementById('center-center');
var centerRight = document.getElementById('center-right');
var lowerLeft = document.getElementById('bottom-left');
var lowerCenter = document.getElementById('bottom-center');
var lowerRight = document.getElementById('bottom-right');

upperLeft = 3;
upperCenter = 4;
upperRight = 5;
centerLeft = 6;
centerCenter = 7;
centerRight = 7;
lowerLeft = 8;
lowerCenter = 9;
lowerRight = 10;



var clickCounter = 0;
var continueGame = true;


$(document).ready(function () {
    function gameOver (){
        if (gameOver = true){
            $('#playerX').css("display",'none');
            $('#playerO').css("display",'none');
        }
    }
    $('.box').click(function () {
        clickCounter = clickCounter + 1;
        if (clickCounter % 2 === 1){
            $(this).find('.Xs').css("display",'inline-block');
            $('#playerO').css("display",'initial');
            $('#playerX').css("display",'none');
            $(this).off();
        } else {
            $(this).find('.Ys').css("display",'inline-block');
            $('#playerX').css("display",'initial');
            $('#playerO').css("display",'none');
            $(this).off();
        }
    });
    $('#top-left').click(function () {
        if (clickCounter % 2 === 1){
            upperLeft = 1;
        } else {
            upperLeft = 2;
        }
    });
    $('#top-right').click(function () {
        if (clickCounter % 2 === 1){
            upperRight = 1;
        } else {
            upperRight = 2;
        }
    });
    $('#top-center').click(function () {
        if (clickCounter % 2 === 1){
            upperCenter = 1;
        } else {
            upperCenter = 2;
        }
    });
    $('#center-left').click(function () {
        if (clickCounter % 2 === 1){
            centerLeft = 1;
        } else {
            centerLeft = 2;
        }
    });
    $('#center-center').click(function () {
        if (clickCounter % 2 === 1){
            centerCenter = 1;
        } else {
            centerCenter = 2;
        }
    });
    $('#center-right').click(function () {
        if (clickCounter % 2 === 1){
            centerRight = 1;
        } else {
            centerRight = 2;
        }
    });
    $('#bottom-left').click(function () {
        if (clickCounter % 2 === 1){
            lowerLeft = 1;
        } else {
            lowerLeft = 2;
        }
    });
    $('#bottom-center').click(function () {
        if (clickCounter % 2 === 1){
            lowerCenter = 1;
        } else {
            lowerCenter = 2;
        }
    });
    $('#bottom-right').click(function () {
        if (clickCounter % 2 === 1){
            lowerRight = 1;
        } else {
            lowerRight = 2;
        }
    });
    function checkForWinner() {
        var X = "Player X is the winner!";
        var Y = "Player O is the winner!";
        if ((upperLeft === upperCenter) && (upperCenter === upperRight)){
            if (upperLeft === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else if (upperLeft === 2){
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((upperLeft === centerLeft) && (centerLeft === lowerLeft)){
            if (upperLeft === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((upperCenter === centerCenter) && (centerCenter === lowerCenter)){
            if (upperCenter === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((upperRight === centerRight) && (centerRight === lowerRight)){
            if (upperRight === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((upperCenter === centerCenter) && (centerCenter === lowerCenter)){
            if (upperCenter === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((centerLeft === centerCenter) && (centerCenter === centerRight)){
            if (centerLeft === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((lowerLeft === lowerCenter) && (lowerCenter === lowerRight)){
            if (lowerLeft === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((upperLeft === centerCenter) && (centerCenter === lowerRight)){
            if (upperLeft === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }else if ((upperRight === centerCenter) && (centerCenter === lowerLeft)){
            if (upperRight === 1){
                alert(X);
                $('#playerXWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerO').hide();
                continueGame = false;
            } else {
                alert(Y);
                $('#playerOWinner').css("display",'initial');
                $('.box').off('click');
                $('#playerX').hide();
                continueGame = false;
            }
        }
    }
    function restartGame (){
        if (clickCounter === 9 && continueGame === true){
            alert("No One Wins!!");
            alert("Game is Restarting...");
            location.reload();
        }
    }
    $('.col-3').click(function () {
        checkForWinner();
        setTimeout(function () {
            restartGame();
        }, 100)
    });
    $('.restartButton').click(function () {
        location.reload();
    })
});