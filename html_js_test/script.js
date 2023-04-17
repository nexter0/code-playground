var randomNumber = Math.floor(Math.random() * 100) + 1;
var input = document.getElementById("input");
var result = document.getElementById("result");
var counterText = document.getElementById("counter");
var counter = 0;

function checkGuess() {
    counter++;
    var userGuess = parseInt(input.value);
    if (userGuess == randomNumber) {
        result.textContent = "Congrats! You got it right!";
        if (counter == 1) {
            var tryText = " try.";
        }
        else if (counter > 1) {
            var tryText = " tries.";
        };
        counterText.textContent = "It took you: " + counter + tryText;
        result.style.color = "green";
    }
    else if (userGuess < randomNumber) {
        result.textContent = "Too low, guess again.";
        counterText.textContent = "Number of tries: " + counter;
        result.style.color = "red";
    } else {
        result.textContent = "Too high, guess again.";
        counterText.textContent = "Number of tries: " + counter;
        result.style.color = "red";
    }
}

function resetGame() {
    randomNumber = Math.floor(Math.random() * 100) + 1;
    input.value = "";
    result.textContent = "";
    counter = 0;
}