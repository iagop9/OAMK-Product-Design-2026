# Game Architecture – Teleko Final Battle

## 1. Project Overview
Teleko Final Battle is an Android turn-based fighting game inspired by Pokémon, featuring Dragon Ball characters.

## 2. Technologies
- Android Studio
- Kotlin and Java
- Jetpack Compose
- Gradle

## 3. Architecture

### User Interface
- MainActivity.kt: Game screens and user interactions.
- SoundManager.kt: Music and sound effects.
- ui/theme/: Visual styles and themes.

### Game Management
- GameViewModel.kt: Game state, turns and combat coordination.

### Game Logic
- Personaje.java: Character model and attributes.
- GuerreroZ.java: Dragon Ball character definitions.
- Ataque.java: Attack mechanics.
- TipoAtaque.java: Attack categories.

### Artificial Intelligence
- IAHeuristica.java: Rule-based opponent AI.
- AgenteRL.java: Reinforcement learning agent.
- ReplayBuffer.java: Experience storage.
- Transicion.java: Learning transitions.

## 4. Game Flow
1. Start the application.
2. Select difficulty.
3. Choose a team of characters.
4. Start turn-based combat.
5. Perform attacks and manage resources.
6. Display the battle results.

## 5. Development Workflow
- GitHub for version control.
- Feature branches for development.
- Pull requests and peer reviews.
- GitHub Kanban for task management.
- Discord for progress updates.
