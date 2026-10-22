# Morpion (Tic-Tac-Toe)

[![CI](https://github.com/LaCobble/Morpion/actions/workflows/ci.yml/badge.svg)](https://github.com/LaCobble/Morpion/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
![Java 17](https://img.shields.io/badge/Java-17-orange.svg)
![Console](https://img.shields.io/badge/UI-console-lightgrey.svg)

A console Tic-Tac-Toe ("morpion" in French) in Java, where the computer picks its moves with the **Minimax** algorithm.

## What it does

- Displays a 3 x 3 board in the terminal.
- You play `0`: enter the row (`X`) then the column (`Y`) of your move, each between 0 and 2.
- The computer plays `X` and answers with the best move found by Minimax.
- The game stops when a player aligns three symbols (row, column or diagonal) or the board is full.

<p align="center">
<img src="docs/images/morpion-run.webp" width="360" alt="Terminal session: the player enters 1,1 then 0,0 then 2,1; the computer, playing X, completes the top row and wins">
</p>

*A real game, rendered from the program's console output (the player's input is shown in green): the player entered 1,1, then 0,0, which was already taken and therefore ignored, then 2,1, and lost.*

<details>
<summary>Same session as text</summary>

```text
|_|_|_|
|_|_|_|
|_|_|_|

Turn P1
Please enter the coord X:
Please enter the coord Y:
Turn IA

|X|_|_|
|_|0|_|
|_|_|_|

Turn P1
Please enter the coord X:
Please enter the coord Y:
Turn IA

|X|X|_|
|_|0|_|
|_|_|_|

Turn P1
Please enter the coord X:
Please enter the coord Y:
Turn IA

|X|X|X|
|_|0|_|
|_|0|_|

FINI
```

</details>

## Requirements

- A JDK (tested with JDK 17).

## Build and run

```bash
git clone https://github.com/LaCobble/Morpion.git
cd Morpion
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

## Project structure

```
src/
├── Main.java                  # Game loop: player turn, then computer turn
├── Board.java                 # Board, win detection, player input, Minimax
├── PointsAndScores.java       # A candidate move and its Minimax score
├── ApplicationException.java  # Coordinate out of range
└── IntException.java          # Input is not an integer
```

## What it demonstrates

- The **Minimax** algorithm: a recursive exploration of every possible continuation, scoring wins (+1), losses (-1) and draws (0), to choose the best move for the computer.
- Game-state modelling on a 2D array, with row, column and diagonal win detection.
- Custom checked exceptions for input validation.

## Known limitations

Kept as written for the assignment:

- An invalid input (out-of-range coordinate or non-integer) stops the program with an exception instead of asking again.
- Choosing a cell that is already taken is silently ignored, and the turn passes to the computer.

## Context

School project (2022), algorithms course. The comments and some identifiers are in French.

## Contributing

This is an archived learning project, but issues and pull requests are welcome: see [CONTRIBUTING.md](CONTRIBUTING.md) and the [Code of Conduct](CODE_OF_CONDUCT.md).

## License

[MIT](LICENSE) © LaCobble
