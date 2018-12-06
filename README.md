# INFO6205_227

* Chao Yuan 
* Zexin Li

A Robot for watering trees

## Problem Description

* In this era of automation, not all work requires humans to complete. Instead, a variety of robots are able to complete these tasks. In particular, the simple and singular work of watering trees can be done using a watering robot. However, when encountering different terrains and not arranging trees one by one, the robot cannot distinguish how watering is most efficient. And if the robot is set to water one by one, the entire design process will become complicated and the entire robot process needs to be redesigned as the trees change throughout the area. Therefore, this test needs to use algorithms that tell us how the robot behaves throughout the watering process.

* In the problem of watering robots, we first need to meet the following conditions: 
Initial population value is 1000. 
Proportion of organisms that survive and breed is 0.5. 
Fecundity of mating is 2. 
The Generation to reproductive maturity is 1. 
The Maximum number of generations is 10000.

* We design a rule for the entire program. Create a 10X10 garden where trees can be planted at every point in the garden. For each experiment we randomly plant 50 trees in this garden and let a watering robot complete the watering of these trees.

* The robot has 6 actions: it moves forward, backwards, left, right and stay and watering. Besides, the robot has 5 grids of vision (feeling 5 grids) which includes forward, backwards, left, right and central. Every Grid have 3 conditions :walls, trees or nothing.

* The working pattern is based on these movements, which is written in each watering robot’s gene. Through genetic algorithms, the optimal set of gene sequences is continuously derived.


