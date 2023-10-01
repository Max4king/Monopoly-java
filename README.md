# Assignment 1 Task no. 4 
# for Programming Theory 2023 Autumn Semester
### By Ryan Supawarapong

## Common requirements:
1. Use a Collection to store the objects of classes derived from the same super class.
2. Use foreach to process the elements of a Collection.
3. Validate the data what you get from the user; throw Exception for invalid data, and handle the thrown Exceptions.
4. The documentation should contain:
	* the description of the exercise,
	* the class diagram,
	* the short description of each methods,
	* and the testing (white box / black box)

## Summary of the task:
Make a simplified monopoly game.
Things to have:
###  1. Players
	* Money
		init == 10000
	* type/Strategies
		* Greedy player: Buy everything possible when have enough money
		* Careful player: Spend no more than half of the money each round
		* Tactical player: Skip second buy chance
### 2. MainBoard
	Contains the collection of player and fields
### 3. field
	* property
	* service
	* lucky field
### 4. price field
	* property    == 1000
	* service     == 
	* lucky field ==
### 5. house price
	* build house == 4000
### 6. Payment
	* step on property without house == -500
	* step on property with house    == -2000
	* service field == -TBA
	* lucky field   == +TBA

## Tools

### Apache Net BeansIDE 19
Mandatory used.

### PlantUML/ ~~yUML~~
For a more programmatic way of making a diagram.
NOTE: use "skinparam classAttributeIconSize 0" in plantuml to change the symbol of visibility from geometric shape(triangle,square and circle) to the classic(#,-,+).

### Git
For version control and easy to traceback.

## Original Explanation(With format):
Simulate a simplified Capitaly(aka Monopoly) game. There are some players with different strategies, and a
cyclical board with several fields. Players can move around the board, by moving forward with
the amount they rolled with a dice. 

### Field
A field can be a property, service, or lucky field.
A property can be bought for 1000, and stepping on it the next time the player can build a house
on it for 4000. If a player steps on a property field which is owned by somebody else, the player
should pay to the owner 500, if there is no house on the field, or 2000, if there is a house on it.
Stepping on a service field, the player should pay to the bank (the amount of money is a
parameter of the field). Stepping on a lucky field, the player gets some money (the amount is
defined as a parameter of the field). 

### There are three different kind of strategies exist. 
Initially, every player has 10,000.

Greedy player: If he steps on an unowned property, or his own property without a house, he
starts buying it, if he has enough money for it.

Careful player: he buys in a round only for at most half the amount of his money.

Tactical player: he skips each second chance when he could buy.

### Condition
If a player has to pay, but he runs out of money because of this, he loses. In this case, his
properties are lost, and become free to buy.

### Input
Read the parameters of the game from a text file. This file defines the number of fields, and then
defines them. We know about all fields: the type. If a field is a service or lucky field, the cost of it
is also defined. After the these parameters, the file tells the number of the players, and then
enumerates the players with their names and strategies.
In order to prepare the program for testing, make it possible to the program to read the roll dices
from the file.

### Output
Print out which player won the game, and how rich he is (balance, owned properties).

### input.txt file(Probably):
	4(Number of fields)
	property
	property
	lucky field 2000
	service 1000
	3 (Number of player)
	Bob greed
	Bill careful
	John tactical

### diceroll.txt(Simulation of Diceroll for testing):
	3
	4
	5
	7
	10
	3
	2
	1