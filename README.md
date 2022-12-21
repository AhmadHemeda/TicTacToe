# <div align="center">TicTacToe</div>
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208905507-0b91a28b-8f2b-43ef-aa7c-78d5c7369033.png" width="500">
</div>

## Description of Prject:

<p>
A Tic-Tac-Toe game that consists mainly of three modes; Single player that play with computer,Two local players ,and Online Game. The Game have a nice looking user interaface.
The Application done mainliy using javafx the server has SQL-SERVER database that stores information about the players, and the games they are played.
The communication between the server and the client in this game done using string object to make it easy to send and recieve requests and responses.
</p>

## Main Features:

### <ul>
<li>  Nice looking User Interface</li>
<li>  Register to the game</li>
<li>  Provide history for Single Game</li>
<li>  Provide history for Two Local Player Game</li>
<li>  The ability to restart another game after finishing </li>
<li>  The ability to play record for saved Game </li>
<li>  Updated list of the whole single and multi mode game history </li>
<li>  Updated list of the whole single and multi mode game history </li>
</ul>

## Application Features Details:

### <ul>
<li>  Sign up and Sign in as a first time player</li>
<li>  Recording every single game information like id, player ,diffucity,winner, date ,and time in text file</li>
<li>  Recording every single game information like id, player one,player two,winner, date ,and time in text file</li>
<li>  Recording every step information if the player wants to save</li>
<li>  Displaying vedio for winner player </li>
<li>  Validation for each name </li>
<li>  Using regex for email and password </li>

</ul>

## Designs:
### <ul>

<li>  DataBase ERD for single player:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208915185-2cf28ed5-ba7b-4912-8f1a-22898996e417.PNG" width="800">
</div>

<p>
We have two main entities the game and its steps.
The values we save about each game is its date and time ,players ,difficulty and winner.
the values we save about each step is the button clicked in this step and the value this button took.
</p>
</li>

<li>  DataBase ERD for Two Local players:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208915771-0df2be88-08e5-464c-a493-d29864064cd8.PNG" width="800">
</div>

<p>
We have two main entities the game and its steps.
The values we save about each game is its date and time ,player one ,player two and winner.
the values we save about each step is the button clicked in this step and the value this button took.
</p>
</li>

<li>  DataBase ERD for Online game:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208916219-8d2140ac-cebe-45c1-a46a-66c86186415d.PNG" width="800">
</div>

<p>
We have three main entities the game, player and its steps.
The values we save about each game is its date and time ,player one ,player two and winner.
the values we save about each player is his mail, password, name and his id.
the values we save about each step is the button clicked in this step and the value this button took.
</p>
  
  
</li>

### <ul>

<li>  Mapping for single player:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208946995-edd59a1e-31f8-4dc2-85f5-e24e9c00e10e.PNG" width="800">
</div>


</li>

<li>  Mapping for Two Local game:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208947443-36f87906-e95d-4788-a3f9-5ed2dc74a548.PNG" width="800">
</div>


</li>

<li>  Mapping for Online game:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208947195-617453cb-1b3a-4414-a8c5-a289836fdb40.PNG" width="800">
</div>


</li>
<li>  Schema for single player:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208948762-e0323988-ed83-4705-b22a-d30da5788007.PNG" width="800">
</div>


</li>

<li>  Schema for Two Local game:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208949016-eb283041-5549-4e41-ac0c-c7703132f6e4.PNG" width="800">
</div>


</li>

<li>  Schema for Online game:
<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208949254-21570b74-90ec-4724-9214-d0d417cb2087.PNG" width="800">
</div>


</li>



</ul>

## In Game Process:
### Splash sreen:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208905507-0b91a28b-8f2b-43ef-aa7c-78d5c7369033.png" width="800">
</div>
<p>
Start screen that display for a specific duration.

</p>

### Choosing Mode Screen:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208919568-fdbb3115-3fa0-4935-acd9-df6dac976b9d.png" width="800">
</div>
<p>
Appear to the player to choose the mode that he likes.

</p>

### Entering player name in single mode:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208919932-05551f01-6926-485a-aaa5-2ecdc615f22d.png" width="800">
</div>
<p>
The user should enter his name to play the game.
</p>

### Board for Single player:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208920654-420ca434-2661-4b3f-9b7a-b5fd442ce8ae.png" width="800">
</div>
<p>
The screen that the user can play on.
</p>

### History for Single Game:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208921048-af029ca1-cd1e-4fd7-9e78-29fc00486906.png" width="800">
</div>
<p>
The history of player 's game.

</p>

### Records for Single Game:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208921243-2fbdbd8b-7a80-407d-aefe-bd2fb364645f.png" width="800">
</div>
<p>
The games that the user recorded.

</p>


### Entering Two players name:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208922965-d7b5487c-c283-4841-8941-152c1161ef74.png" width="800">
</div>
<p>
Two players must enter thier name to play the game.

</p>

### Board for Two Local players game:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208923381-3b0623d4-3424-4379-92f7-e5de03f995ec.png" width="800">
</div>
<p>
The screen that the two players can play on.

</p>

### Singn up screen:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208924400-473a3a1d-7e9c-4840-a1cd-3b516f17be5a.png" width="800">
</div>
<p>
If the user wants to play online game ,he must sign up before playing.

</p>


### List of Online players:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208937835-dd94a01a-f606-4ca7-942e-a42a0650a3ba.PNG" width="800">
</div>
<p>
The screen that appear when the player login to choose the player that he wants to play with.

</p>

### Winning Vedio:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208931675-884e4350-143c-4959-a3f2-833643610f32.png" width="800">
</div>
<p>
The screen that appear when the player wins.

</p>

### Losing Vedio:

<div align="center">
<img src="https://user-images.githubusercontent.com/119635557/208932291-6f1cdf4a-2e7e-4aef-90a4-44cd1843f860.png" width="800">
</div>
<p>
The screen that appear when the user loses.

</p>


### How to play:
First Clone The Project
Create the database schema

after creating the data base you have to add user to the database

<p>
After creating the database you can now build and run the server project using netbeans
you can lunch the Client App using the executable jar file or using netbeans

</p>


### Contributors:
### <ul>
<li>  Soha Ahmed Hamdy</li>
<li>  Moamen Ali Gomma</li>
<li>  Ahmad Muhammad Hemeda</li>
<li>  Yossif Mohammed </li>


</ul>



