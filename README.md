# Simple Poker Hand evaluation demo.

This program evaluates Poker Hands as per the following question sent to me by someone. (This program is tested with junit 4.12)

Write a program that allows a user to play poker. The program takes as input 7 cards and outputs which

of the

following poker hands are present (arranged in ascending order of priority):

Two Pair: Two cards have the same number.

Three of a kind:Three cards have the same number

Straight: 5 cards have numbers in a sequence

Flush: 5 cards have the same suite

Four of a kind: Four cards have the same number

​

In case more than one hand is present, print the one with the highest priority.

Assume input of each card is as follows:

First character denotes the card&quot;s rank: a/1 (for ace), k(king), q(queen),j(jack), 2-10

Second character denotes the card&quot;s suite: s(spade),c(club),d(diamond),h(heart)

If invalid inputs are present, print &quot;Invalid input&quot;

Sample Input:

7s

kd

7h

4d

6c

qh

7c

Sample output:

Three of a kind

For your Practice:

Server Test Case

Test Case 1

Input:

7s

kd

7h

4d

6c

qh

7c

Output

Three of a kind

Test Case 2:

Input:

7h

4d

6s

qs

kh

5c

8h

