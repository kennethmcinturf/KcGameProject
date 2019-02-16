generateRandoms = (numberOfCards) => {
    randomArray = [];
    do {
        for (let i = 0; i < numberOfCards + 1; i++){
            number = Math.floor((Math.random() * numberOfCards) + 1);
            if (randomArray.indexOf(number) === -1){
                randomArray.push(number);
            }
        }
    }while (randomArray.length < numberOfCards);
    return randomArray;
};

let switchToPics = false;

addPicture = (numberOfCards) => {
    generateRandoms(numberOfCards);
    if(switchToPics === true){
        getPicture(`${$("#-1").val()}`,".img-one");
        getPicture(`${$("#-2").val()}`,".img-two");
        getPicture(`${$("#-3").val()}`,".img-three");
        getPicture(`${$("#-4").val()}`,".img-four");
        getPicture(`${$("#-5").val()}`,".img-five");
        getPicture(`${$("#-6").val()}`,".img-six");
    }
    for (let i = 0; i <= randomArray.length - 1; i++){
        if (randomArray[i] === 1 || randomArray[i] === 2){
            $(`#${i}`).addClass("img-one")
        }else if (randomArray[i] === 3 || randomArray[i] === 4){
            $(`#${i}`).addClass("img-two")
        }else if (randomArray[i] === 6 || randomArray[i] === 5){
            $(`#${i}`).addClass("img-three")
        }else if (randomArray[i] === 7 || randomArray[i] === 8){
            $(`#${i}`).addClass("img-four")
        }else if (randomArray[i] === 9 || randomArray[i] === 10){
            $(`#${i}`).addClass("img-five")
        }else if (randomArray[i] === 11 || randomArray[i] === 12){
            $(`#${i}`).addClass("img-six")
        }
    }
};

addPicture(12);

if (localStorage.highscoretwelve === "1000"){
    $('#highScore').val(0);
}else {
    $('#highScore').val(localStorage.highscoretwelve);
    $('#highScoreName').text(localStorage.highscoretwelveName);
}

let clickCounter = 0;
let roundCounter = 0;
let score = $('#round-counter').val();
let numberCorrect = $('#container .correct').length;




resetHighScoreInfo = () =>{
    if (localStorage.getItem("highscoretwelve") === null){
        localStorage.setItem("highscoretwelve", "1000");
    }else if (localStorage.getItem("highscoreten") === null){
        localStorage.setItem("highscoreten", "1000")
    }else if (localStorage.getItem("highscoreeight") === null){
        localStorage.setItem("highscoreeight", "1000")
    }else if (localStorage.getItem("highscoresix") === null){
        localStorage.setItem("highscoresix", "1000")
    }else if (localStorage.getItem("highscorefour") === null){
        localStorage.setItem("highscorefour", "1000")
    }else if(localStorage.getItem("highscoretwelveName") === null){
        localStorage.setItem("highscoretwelveName", "Current High-Score: None");
    }else if(localStorage.getItem("highscoretenName") === null){
        localStorage.setItem("highscoretenName", "Current High-Score: None");
    }else if(localStorage.getItem("highscoreeightName") === null){
        localStorage.setItem("highscoreeightName", "Current High-Score: None");
    }else if(localStorage.getItem("highscoresixName") === null){
        localStorage.setItem("highscoresixName", "Current High-Score: None");
    }else if(localStorage.getItem("highscorefourName") === null){
        localStorage.setItem("highscorefourName", "Current High-Score: None");
    }
};

resetHighScoreInfo();

whichHighScore = (numberOfCards, score) => {
    if (numberOfCards === 12){
        if (score < parseInt(localStorage.getItem("highscoretwelve"))){
            let highScore = prompt("New High Score! Please enter your name");
            localStorage.setItem("highscoretwelve", score);
            localStorage.setItem("highscoretwelveName", `Current High Score: ${highScore}`);
            $('#highScore').val(localStorage.highscoretwelve);
            $('#highScoreName').text(localStorage.highscoretwelveName);
        }
    }else if (numberOfCards === 10){
        if (score < parseInt(localStorage.getItem("highscoreten"))){
            let highScore = prompt("New High Score! Please enter your name");
            localStorage.setItem("highscoreten", score);
            localStorage.setItem("highscoretenName", `Current High Score: ${highScore}`);
            $('#highScore').val(localStorage.highscoreten);
            $('#highScoreName').text(localStorage.highscoretenName);
        }
    }else if (numberOfCards === 8){
        if (score < parseInt(localStorage.getItem("highscoreeight"))){
            let highScore = prompt("New High Score! Please enter your name");
            localStorage.setItem("highscoreeight", score);
            localStorage.setItem("highscoreeightName", `Current High Score: ${highScore}`);
            $('#highScore').val(localStorage.highscoreeight);
            $('#highScoreName').text(localStorage.highscoreeightName);
        }
    }else if (numberOfCards === 6){
        if (score < parseInt(localStorage.getItem("highscoresix"))){
            let highScore = prompt("New High Score! Please enter your name");
            localStorage.setItem("highscoresix", score);
            localStorage.setItem("highscoresixName", `Current High Score: ${highScore}`);
            $('#highScore').val(localStorage.highscoresix);
            $('#highScoreName').text(localStorage.highscoresixName);
        }
    }else if (numberOfCards === 4){
        if (score < parseInt(localStorage.getItem("highscorefour"))){
            let highScore = prompt("New HighScore! Please enter your name");
            localStorage.setItem("highscorefour", score);
            localStorage.setItem("highscorefourName", `Current High Score: ${highScore}`);
            $('#highScore').val(localStorage.highscorefour);
            $('#highScoreName').text(localStorage.highscorefourName);
        }
    }
};


getPicture = (picture, target) => {
    $.getJSON(`https://api.themoviedb.org/3/search/movie?api_key=15d2ea6d0dc1d476efbca3eba2b9bbfb&query=${picture}&callback=?`, function(json) {
        if (json != "Nothing found.") {
            console.log(json.results[0]);
            console.log(json.results[0].poster_path);
            $(target).css('background-image', `url('http://image.tmdb.org/t/p/w500${json.results[0].poster_path}')`)
        }else {
            $("#movieText").css("color","red");
            $("#movieText").css("font-size","25px");
            return;
        }});
};

checkIfMatch = (background) => {
    if($(".clickedOne").css(background) === $(".clickedTwo").css(background)){
        $(".clickedOne").addClass("correct");
        $(".clickedTwo").addClass("correct");
    }else {
        $(".clickedOne").addClass("hide-background-img").removeClass("disabled");
        $(".clickedTwo").addClass("hide-background-img").removeClass("disabled");
    }
    $("section").each(function () {
        $(this).removeClass("clickedOne").removeClass("clickedTwo");
    });
    clickCounter = 0;
    roundCounter++;
    $('#round-counter').val(roundCounter);
    numberCorrect = $('#container .correct').length;
    let amountOfCards = parseInt($("#amountOfCards").val());
    if (numberCorrect === amountOfCards){
        whichHighScore(amountOfCards, roundCounter);
    }
};

$('#round-counter').val(roundCounter);


let resetGame = (numberOfCards) => {
    $('section').removeClass("img-one img-two img-three img-four" +
        " img-five img-six correct clickedOne clickedTwo disabled")
        .addClass("hide-background-img click-event");
    clickCounter = 0;
    roundCounter = 0;
    $('#round-counter').val(roundCounter);
    addPicture(numberOfCards);
};

$("#resetGame").click(function (e) {
    e.preventDefault();
    amountOfCards = parseInt($("#amountOfCards").val());
    resetGame(amountOfCards);
});

$("#resetHighScore").click(function (e) {
    e.preventDefault();
    localStorage.setItem("highscoretwelve", "1000");
    localStorage.setItem("highscoreten", "1000");
    localStorage.setItem("highscoreeight", "1000");
    localStorage.setItem("highscoresix", "1000");
    localStorage.setItem("highscorefour", "1000");
    $('#highScore').val(0);
    $('#highScoreName').text("Current High Score is: None");
    amountOfCards = parseInt($("#amountOfCards").val());
});


$(".click-event").click(function () {
    if($(this).hasClass('disabled')){
        return;
    }
    clickCounter++;
    if (clickCounter === 1){
        $(this).removeClass("hide-background-img click-event").addClass("clickedOne disabled");
    }else if (clickCounter === 2){
        $(this).removeClass("hide-background-img click-event").addClass("clickedTwo disabled");
        setTimeout(function () {
            if (switchToPics === false){
                checkIfMatch("background");
            }else{
                checkIfMatch("background-image");
            }
        }, 500)
    }
});

$("#enterMovie").click(function () {
    $(".addMovie").removeClass("hide");
});

$("#addMovie").click(function () {
    if ($("#-1").val().length === 0 ||
        $("#-2").val().length === 0 ||
        $("#-3").val().length === 0 ||
        $("#-4").val().length === 0 ||
        $("#-5").val().length === 0 ||
        $("#-6").val().length === 0){
        $("#movieText").css("color","red");
        $("#movieText").css("font-size","25px");
        return;
    }
    $(".addMovie").addClass("hide");
    getPicture(`${$("#-1").val()}`,".img-one");
    getPicture(`${$("#-2").val()}`,".img-two");
    getPicture(`${$("#-3").val()}`,".img-three");
    getPicture(`${$("#-4").val()}`,".img-four");
    getPicture(`${$("#-5").val()}`,".img-five");
    getPicture(`${$("#-6").val()}`,".img-six");
    switchToPics = true;
});

$("#resetCards").click(function (e) {
    e.preventDefault();
    let theAmountOfCards = $("#amountOfCards").val();
    if (theAmountOfCards === "12"){
        $("#card-twelve").show();
        $("#card-eleven").show();
        $("#card-ten").show();
        $("#card-nine").show();
        $("#card-eight").show();
        $("#card-seven").show();
        $("#card-six").show();
        $("#card-five").show();
        if (localStorage.highscoretwelve === "1000"){
            $('#highScore').val(0);
            $('#highScoreName').text('Current High-Score: None');
        }else {
            $('#highScore').val(localStorage.highscoretwelve);
            $('#highScoreName').text(localStorage.highscoretwelveName);
        }
    }else if(theAmountOfCards === "10"){
        $("#card-twelve").hide();
        $("#card-eleven").hide();
        $("#card-ten").show()
        $("#card-nine").show();
        $("#card-eight").show();
        $("#card-seven").show();
        $("#card-six").show();
        $("#card-five").show();
        if (localStorage.highscoreten === "1000"){
            $('#highScore').val(0);
            $('#highScoreName').text('Current High-Score: None');
        }else {
            $('#highScore').val(localStorage.highscoreten);
            $('#highScoreName').text(localStorage.highscoretenName);
        }
    }else if(theAmountOfCards === "8"){
        $("#card-twelve").hide();
        $("#card-eleven").hide();
        $("#card-ten").hide();
        $("#card-nine").hide();
        $("#card-eight").show();
        $("#card-seven").show();
        $("#card-six").show();
        $("#card-five").show();
        if (localStorage.highscoreeight === "1000"){
            $('#highScore').val(0);
            $('#highScoreName').text('Current High-Score: None');
        }else {
            $('#highScore').val(localStorage.highscoreeight);
            $('#highScoreName').text(localStorage.highscoreeightName);
        }
    }else if(theAmountOfCards === "6"){
        $("#card-twelve").hide();
        $("#card-eleven").hide();
        $("#card-ten").hide();
        $("#card-nine").hide();
        $("#card-eight").hide();
        $("#card-seven").hide();
        $("#card-six").show();
        $("#card-five").show();
        if (localStorage.highscoresix === "1000"){
            $('#highScore').val(0);
            $('#highScoreName').text('Current High-Score: None');
        }else {
            $('#highScore').val(localStorage.highscoresix);
            $('#highScoreName').text(localStorage.highscoresixName);
        }
    }else if(theAmountOfCards === "4"){
        $("#card-twelve").hide();
        $("#card-eleven").hide();
        $("#card-ten").hide();
        $("#card-nine").hide();
        $("#card-eight").hide();
        $("#card-seven").hide();
        $("#card-six").hide();
        $("#card-five").hide();
        if (localStorage.highscorefour === "1000"){
            $('#highScore').val(0);
            $('#highScoreName').text('Current High-Score: None');
        }else {
            $('#highScore').val(localStorage.highscorefour);
            $('#highScoreName').text(localStorage.highscorefourName);
        }
    }
    resetGame(parseInt(theAmountOfCards));
});