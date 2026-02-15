# Paperflite Assessment — DSA Problems

This repo contains my solutions for the three coding problems given in the Paperflite assessment. Each problem is in its own Java file under the `src/` folder.

## Prerequisites

- Java JDK 8 or above installed
- A terminal / command prompt

## How to Compile and Run

Open a terminal, navigate to the project folder, and follow the steps below.

### 1. Single Number

**Problem:** Given an array where every element appears twice except one, find that single element.

**Compile and run:**
```
cd src
javac SingleNumber.java
java SingleNumber
```

**Sample input/output:**
```
Enter the elements (space separated):
4 1 2 1 2
Single number is: 4
```

**Approach:**
I used the XOR bitwise operator here. The key insight is that XOR of a number with itself is 0, and XOR of a number with 0 is the number itself. So if we XOR all elements together, the duplicates cancel out and we're left with the unique one.

**Time Complexity:** O(n) — single pass through the array
**Space Complexity:** O(1) — no extra data structures needed

---

### 2. Remove K Digits

**Problem:** Given a number as a string and an integer k, remove k digits to get the smallest possible number.

**Compile and run:**
```
cd src
javac RemoveKDigits.java
java RemoveKDigits
```

**Sample input/output:**
```
Enter number: 1432219
Enter k: 3
Smallest number: 1219
```

**Approach:**
I used a stack-based greedy approach. The idea is to iterate through each digit and whenever the current digit is smaller than the top of the stack, we pop the stack (which counts as removing a digit). This way we always try to keep smaller digits towards the left, which gives us the smallest number. After processing, if we still have removals left, we trim from the end. Finally, we strip any leading zeros.

**Time Complexity:** O(n) — each digit is pushed and popped at most once
**Space Complexity:** O(n) — for the stack

---

### 3. Word Pattern

**Problem:** Check if a string follows a given pattern, where each letter maps to exactly one unique word and vice versa (bijection).

**Compile and run:**
```
cd src
javac WordPattern.java
java WordPattern
```

**Sample input/output:**
```
Enter pattern: abba
Enter string: dog cat cat dog
Output: true
```

**Approach:**
I maintained two hash maps — one mapping characters to words and another mapping words back to characters. For each position, I check both directions to make sure the mapping is consistent. If at any point a character maps to a different word than expected (or a word maps to a different character), we return false. This ensures the bijection property holds.

**Time Complexity:** O(n) — where n is the number of words/characters in the pattern
**Space Complexity:** O(n) — for the two hash maps
