There are two kinds of regions, which we call the green region and the red region. Therefore, trains and reindeers can be classified as those going to the green region and the red region.
Our gifts are in the bags, and we should distribute them to trains and reindeers according to the properties of the bag. You can consider that the same type of gifts is in the same bag, and we want to distribute them properly.
Properties of bags are as follow, remark that one bag has more than one property
a. Each of the gifts in this bag type should be distributed through different vehicles, i.e. there are no 2 gifts from the same bag on the same train or reindeer.
b. Each of the gifts in this bag type should only be distributed to green regions.
c. Each of the gifts in this bag type should only be distributed to red regions.
d. Each of the gifts in this bag type should only be distributed by train.
e. Each of the gifts in this bag type should only be distributed by reindeer.
If it?s not specified, assume that gifts can be distributed to all regions, and both by train and reindeer.
Let?s look at some examples of bag types.
o bd can be distributed only by trains which go to green regions
o ace can be distributed only by reindeers which go to red regions and there are no 2 gifts from this bag on the same reindeer
o c can be distributed only to red regions, both by trains and reindeers
o d can be distributed only by trains, to both the red and the green regions
o a only constraint is that there are no 2 gifts from this bag on the same vehicle
o bc invalid, it won?t be given as an input to you because it is a contradictory
o de invalid, it won?t be given as an input to you because it is a contradictory

Input
? The first line represents the number of Santa Claus Expresses that are going to the green region.
? The second line will give the capacities of each of these trains.
? The third line represents the number of Santa Claus Expresses that are going to the red region.
? The fourth line will give the capacities of each of these trains.
? The fifth line represents the number of Santa Claus?s reindeers that are going to the green region.
? The sixth line will give the capacities of each of these reindeers.
? The seventh line represents the number of Santa Claus?s reindeers that are going to the red region.
? The eighth line will give the capacities of each of these reindeers.
? The ninth line represents the number of bags.
? The tenth line will give the type of bags and number of gifts in it.

Output
? For each test case, there will be one line output that gives the minimum possible number of gifts that can?t be distributed.

program will be run with the below command:
java project4main <inputfile> <outputfile>

Sample input
1 
3 
2 
1 9 
0 

1 
2 
4 ac 6 be 3 cd 4 ad 8

Sample OutPut File
12