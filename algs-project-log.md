# Project Log

**May 22, 2023**
- Completed LeetCode 15: 3Sum.
  - Re-watched the NeetCode video and was able to put together my own variation of the solution.
  - I am still a bit uncertain about what this problem. I think I am misunderstanding what qualifies as a duplicate and how we handle this case. I'm at maybe 85% understanding on this one.
- Completed LeetCode 110: Balanced Binary Tree.
  - Was able to do this one without any help.
- Completed LeetCode 100: Same Tree.
  - I managed to do this without help and was able to get a solution with the optimal time complexity.
  - However, my solution was verbose - it could have been cleaner and more concise.
- Completed LeetCode 572: Subtree of Another Tree.
  - I figured out a valid conceptual solution, but really struggled to implement it.
  - Outlining and pseudo-coding the solution didn't help. But I eventually got a working implementation.
  - It is also possible that my solution is not the most optimal. My best evaluation says that my time complexity is between O(NlogN) and O(N^2), but this might be an inaccurate evaluation.
    - I also don't know if this is the best possible runtime for this problem.
    - The BCR is O(N) - we should only need to visit each node once in theory.
    - The time complexity is actually O(N * M), where N is the number of nodes in the root and M is the number of nodes in the subRoot.
  - I reworked part of my solution after watching the NeetCode video to make my solution more concise.
    - Additionally, this improvement uses O(1) memory instead of O(N) memory.

**May 19, 2023**
- Just realized that the Iterative BFS solution I wrote yesterday was actually an Iterative DFS.
- Completed LeetCode 104: Maximum Depth of Binary Tree (Iterative BFS).
  - This took a minute as I got myself tripped up on how to do BFS instead of DFS.
  - Iterative DFS uses a stack and Iterative BFS uses a queue.
- Completed LeetCode 543: Diameter of Binary Tree
  - Was not able to arrive at a solution on my own.
  - Watched the entire NeetCode video and implemented a variation of his solution.
  - Had to look up some stuff on how scope works as well.
- Completed LeetCode 981: Time Based Key-Value Store.
  - This one took a while, but I was able to get a working solution without any help.
- Completed LeetCode 15: 3Sum
  - Attempted this problem, but misread the question (and misunderstood the NeetCode conceptual explanation), which resulted in me failing to get a working solution.
- Some notes on scope:
  - Built In - Always available anywhere. Ex. True/False, break, if, etc.
  - Global - File-wide accessibility.
    - The `global` keyword can be used to specify that the specified variable is a global variable. This tells Python to use global version of that variable and not to make a new local variable of the same name.
  - Scope works its way out.
    - This means that if you declare a variable in local scope and in global scope (using the same name) and then call it in a local scope, python will start its search for the variable with that name in the local scope and work its way out. Thus, it will find the local declaration first and use that one.
  - We can use the `nonlocal` keyword to tell Python that a variable in a nested function is not declared in that function but instead declared in a parent function. This will tell Python to search up through the parent functions to find the declaration for the function.
    - Note that this does mean that if we want to use a variable in a function but that variable is declared elsewhere, we have to "re-declare" (but not re-initialize) it using either the `global` or `nonlocal` keyword inside the function where we are going to be using it.

**May 18, 2023**
- Continued working on LeetCode 146: LRU Cache.
  - Was not able to solve it and didn't like the solutions I found online.
  - Decided to skip this problem for now.
- Completed LeetCode 226: Invert Binary Tree.
  - Redone as part of NeetCode 150.
  - Was able to solve this problem in less than 30 minutes without help.
- Completed LeetCode 104: Maximum Depth of Binary Tree (Iterative BFS)
  - Redone as part of NeetCode 150.
  - Was able to solve this problem in less than 20 minutes without help.
- Completed LeetCode 104: Maximum Depth of Binary Tree (Recursive DFS)
  - Was not able to get a working recursive solution on my own.
  - Watched the conceptual portion of the NeetCode video to figure out how to do this one.

**May 17, 2023**
- Completed LeetCode 2: Add Two Numbers
  - I was able to do this one without looking at any solutions.
  - However, I got overly confident and didn't write as thorough of an outline as a should have. As a result, I made a lot of small errors due to oversight of edge-cases that wasted a lot of time.
  - I need to be better about following a recursive outline process: write a high-level explanation, then write a rough outline of the steps, then break those steps down into pseudo-code, then test it on paper. Repeat the last two steps until a working algorithm is reached. Then code it.
- Completed LeetCode 141: Linked List Cycle
  - This one should have been a very easy, done in five minutes kind of problem. But I wasn't able to understand a couple of edge cases quickly.
  - I need to follow the system I outlined above (LeetCode 2) even for very easy problems like this. At least for now - I clearly have a lot that I still need to learn.
- Completed LeetCode 287: Find the Duplicate Number
  - This one tricked me. The wording on the problem made it look like it was simpler than it really was. I was able to solve the simpler version (as far as I can tell), but was unable to solve the actual problem.
  - The trick here is that there may be more than two copies of the duplicate number, this rendered my math-based solution invalid.
  - The solution to the real problem is to treat the input array as a linked list and use Floyd's alg to find the duplicate value (which will always be situated at the point in the list where a cycle begins - this is what Floyd's finds).
- Started working on LeetCode 146: LRU Cache
  - Wasn't able to work out a solution on my own. Watched the conceptual part of the NeetCode video and began implementing a solution to match the conceptual solution.

**May 16, 2023**
- Completed LeetCode 138: Copy List with Random Pointer
  -  I managed to complete this one on my own without having to look up any solutions or conceptual explanations.

**May 15, 2023**
- Attempted LeetCode 33: Search in Rotated Sorted Array
  - I was not able to come up with a solution or understand the one provided by NeetCode.
  - This is one I should come back to later.
- Completed LeetCode 19: Remove Nth Node From End of List.
  - This was a redo was done as part of NeetCode 150.
  - Took me longer than it should have. But I now have a better understanding of the solution.
  - I did not need to look up a solution to complete this.

**May 12, 2023**
- Redid LeetCode 206: Reverse Linked List using an iterative solution.
  - This was easy since the recursive solution is basically the same as the iterative solution.
- Completed LeetCode 21: Merge Two Sorted Lists
  - I've done this one before, but it's been a while.
  - I managed to get a working solution without any help. However, my solution was verbose and non-optimal. After watching the NeetCode video, I was able to significantly improve my implementation.
- Completed LeetCode 143: Reorder List
  - I was able to implement the extra space solution, but unable to come up with the in-place solution.

**May 11, 2023**
- Completed LeetCode 875: Koko Eating Bananas
  - Started this one yesterday and didn't manage to finish.
  - This was a tricky one, but I managed to complete it without looking at solution code. I did, however, have to watch the conceptual part of the NeetCode video.
- Completed LeetCode 153: Find Minimum in Rotated Sorted Array.
  - This one is giving me the run-around.
  - I wasn't able to arrive at a conceptual solution; the conceptual solution from the NeetCode video mostly made sense, but I think some of the finer details went over my head; and finally, I had trouble implementing a solution even after watching the implementation portion of the NeetCode video. Basically, I don't really feel like I've got a good understanding of this problem.
- Completed LeetCode 206: Reverse Linked List
  - I redid this problem as part of the NeetCode 150 list. I definitely needed to.
  - I was unable to do this without watching both the conceptual and implementation portions of the NeetCode video.
  - I implemented the iterative solution.

**May 10, 2023**
- Completed LeetCode 704: Binary Search.
  - I got very close, but missed a few of the important small details and had to look at a solution to get to a working implementation.
  - However, I didn't have to look up a conceptual explanation, which is good - that's the hard part.
- Completed LeetCode 74: Search a 2D Matrix.
  - Was able to solve it without looking at a solution. But it took quite a while.
  - My solution isn't half bad though. And my code is relatively clean.

**May 9, 2023**
- Completed LeetCode 739: Daily Temperatures
  - Had to watch the NeetCode video to get the concept, but was able to implement the solution without looking at the solution code.
  - NeetCode's implementation was cleaner, however, and my solution had some redundant work.
- Completed LeetCode 853: Car Fleet
  - Had to watch the NeetCode video to get the concept, but was able to implement the solution without looking at the solution code.

**May 8, 2023**
- Completed LeetCode 150: Evaluate Reverse Polish Notation
  - Was able to complete the entire problem without looking up a solution.
- Completed LeetCode 22: Generate Parentheses
  - Was unable to come up with, or even get close to, a solution for this one.
  - Watched NeetCode video on how to solve this one.

**May 4, 2023**
- Completed LeetCode 20: Valid Parentheses
  - Didn't need to look up a solution.
- Completed LeetCode 155: Min Stack
  - Needed a hint, but was able to do it without looking at a solution.

**May 1, 2023**
- Completed LeetCode 567: Permutation in String.
  - Did this one without looking at any solutions.
  - However, while my solution is running in optimal time (BCR), it does include a poorly formatted loop that does not correctly check all conditions. This required the addition of an explicit check after the loop that would be unnecessary if the loop was implemented correctly.

**April 30, 2023**
- Completed LeetCode 424: Longest Repeating Character Replacement
  - Had to watch the NeetCode solution and implement a version of his solution to get it to work.
  - I very much overcomplicated the implementation of this problem. It didn't need to be as involved as I made it.
  - As far as I can tell, I focused too much on explicitly handling many of the cases that were handled implicitly. This resulted in overly complex code that was difficult to get to work.

**April 24, 2023**
- Attempted to pseudo-code the solution to LeetCode 424.
  - Didn't make much progress.
  - Re-watched the conceptual portion of the NeetCode video.
  - Tried to pseudo-code a new solution.
  - Need to break the pseudo-code down a bit more, then try to implement my solution.

**April 23, 2022**
- Watched the conceptual part of the NeetCode video for LeetCode 424: Longest Repeating Character Replacement.
  - Wrote out how the solution in my own words.
  - Next, I need to outline the pseudo-code and then implement it.
- Started pseudo coding solution to LeetCode 424.
  - Wrote out the valid window condition in a confusing way and got myself mixed up.
  - Come back tomorrow and write it down better (don't look at the old version) so it isn't as confusing. Because it's not confusing, I just over complicated it.

**April 22, 2023**
- Started LeetCode 424: Longest Repeating Character Replacement
  - Came up with a promising idea, but it has a few clear limitations (unhandled edge cases).
  - This solution does not use a sliding window, and I know this is a sliding window problem. I need to either come up with a super clever solution (never a good idea) or try to work out a sliding window solution.

**April 19, 2023**
- Completed LeetCode 3: Longest Substring Without Repeating Characters
  - Managed to complete it without looking at an existing solution.
  - Did have to watch the NeetCode conceptual explanation to find my error however (this was done yesterday).

**April 18, 2023**
- Continued to work on LeetCode 3: Longest Substring Without Repeating Characters
  - Watched the conceptual part of the NeetCode video, but was still unable to implement a working solution.
  - I should outline my solution manually again to see where my error is. I don't think I need to see the worked solution in the NeetCode video to get this one.

**April 17, 2023**
- Attempted LeetCode 3: Longest Substring Without Repeating Characters.
  - Got very close to a working solution, but had one small oversight in my solution.
  - #TIP: I need to be better about coming up with test cases before coming up with a solution. I might have caught that one if I'd paid close attention to my test cases.

**April 16, 2023**
- Completed LeetCode 121: Best Time to Buy and Sell Stock
  - Redid this problem as part of NeetCode 150.

**April 15, 2023**
- Completed LeetCode 11: Container With Most Water

**April 14, 2023**
- Started working through LeetCode 11: Container With Most Water.
  - Just got a basic idea for the problem and started outlining the problem.