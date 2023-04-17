var randomNumber = Math.floor(Math.random() * 100) + 1;
var input = document.getElementById("input");
var result = document.getElementById("result");

function checkGuess() {
    var userGuess = parseInt(input.value);
    if (userGuess == randomNumber) {
        result.textContent = "Congrats! You got it right!";
        result.style.color = "green";
    }
    else if (userGuess < randomNumber) {
        result.textContent = "Too low, guess again.";
        result.style.color = "red";
    } else {
        result.textContent = "Too high, guess again.";
        result.style.color = "red";
    }
}

function resetGame() {
    randomNumber = Math.floor(Math.random() * 100) + 1;
    input.value = "";
    result.textContent = "";
}