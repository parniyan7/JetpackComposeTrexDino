# T-Rex Dino 2D Jetpack Compose Game


https://github.com/user-attachments/assets/62ec0b19-82ce-44c0-9002-fcacadfda10c


## Introduction
The T-Rex Dino 2D Jetpack Compose Game is a simple and engaging 2D game built using the Jetpack Compose framework. In this game, the player controls a T-Rex character and jumps through a path filled with obstacles.

## Features
1. **2D Scrolling Environment**: The game features a 2D scrolling environment where the player can move the T-Rex character.
2. **Obstacle Avoidance**: The player must avoid obstacles, such as trees, by jumping over them.
3. **Scoring System**: The game keeps track of the player's score, which increases as the player successfully navigates through the obstacles.
4. **Game Over**: The game ends when the T-Rex collides with an obstacle.

## Technical Details

The game is implemented using the following Jetpack Compose components and functions:

1. `@Composable`: The `TRexGame` function is a composable function that defines the game's UI and logic.
2. `Canvas`: The `Canvas` composable is used to draw the game elements, such as the T-Rex, obstacles, and the game score.
3. `Drawable`: The `Drawable` objects are used to represent the T-Rex and obstacle images.
4. `Bitmap`: The `Bitmap` objects are created from the `Drawable` objects to be used for rendering the game elements.
5. `Modifier`: The `Modifier` is used to set the size and interaction behavior of the game canvas.
6. `StateFlow`: The game state, such as the T-Rex's position, obstacle position, and game score, are managed using `StateFlow` objects.
7. `DetectTapGestures`: The `DetectTapGestures` function is used to handle user input, such as tapping the screen to make the T-Rex jump.

## Game Logic

The game logic is implemented in the `TRexGame` function. The function handles the following aspects of the game:

1. **T-Rex Movement**: The T-Rex's position is updated based on user input (tapping the screen) and the application of gravity.
2. **Obstacle Movement**: The obstacles move across the screen at a constant speed.
3. **Collision Detection**: The game checks for collisions between the T-Rex and the obstacles, triggering the "Game Over" state when a collision occurs.
4. **Score Tracking**: The player's score is incremented as the T-Rex successfully navigates through the obstacles.
5. **Game State Management**: The game state is managed using the `GameState` sealed class, which represents the "Running" and "Game Over" states.

## Usage
To use the T-Rex Dino 2D Jetpack Compose Game, you can include the `TRexGame` composable function in your Jetpack Compose application, passing in the required parameters:

```kotlin
@Composable
fun MyApp() {
    TRexGame(
        trexDrawable = yourTRexDrawable,
        obstacleDrawable = yourObstacleDrawable
    )
}
```

Make sure to provide the `Drawable` objects for the T-Rex and the obstacle images.

## Future Enhancements
Some potential future enhancements for the T-Rex Dino 2D Jetpack Compose Game include:

1. **Power-ups and Obstacles**: Introduce different types of obstacles and power-ups to enhance the gameplay experience.
2. **High Score Tracking**: Implement a high score system to allow players to compete against their previous best scores.
3. **Sound Effects and Music**: Add sound effects and background music to create a more immersive gaming experience.
4. **Responsive Design**: Optimize the game to work well on different screen sizes and resolutions.
5. **Multiplayer Support**: Develop a multiplayer mode to allow players to compete against each other.

## Conclusion
The T-Rex Dino 2D Jetpack Compose Game is a fun and challenging 2D game that showcases the power of the Jetpack Compose framework. The game's simple yet addictive gameplay, combined with the flexibility of the Jetpack Compose library, make it a great starting point for building more complex and engaging mobile applications.
