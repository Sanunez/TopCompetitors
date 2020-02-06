## Problem
Given a list of competitors, and a list of reviews, and a desired N number of most mentioned, return a  n sized list sorted from most mentioned to least mentioned

## Approach
I created a Hashmap that will keep track of all competitors and their mention count. After initiating the hashmap by iterating thorugh the given list of competitors and setting all initial counts to 0, I begin work on the Reviews. For easier manipulation and faster run time I make sure I do the following in a single pass per review:

First, I remove all punctuation from current review.

Second, I split the reivew based on spaces, Lastly I itterate through each word and checking the previous hash table to see if it is present, if it is I increment it's value by one and proceed.

Lastly, once all mentions have been added to the hashmap, I reverse sort it using Java 1.8 Comparator class and add individual items to desired ArrayList output.

## Complexity
Creating the Hashmap is done in O(Competitors) time, since we must iterate through the list and check what we are keeping track of. 

We then Iterate through the reviews linearly to log any mentions and this get's done in O(Reviews) time.

Lastly we have to sort our output which costs us O(nLog(n)) as Collection.sort() uses a merge sort approach, but regardless of what sort you use sorting is universally bounded to nLogn.

These factors put together gives us a runtime of: 
#### O(competitors + reviews + nlog(n)) 
#### O(C+R+NLog(N))

## Hindsight
I should mention that we could keep our output arrayList sorted if we implement an update function that linearly traverses and keeps items in sorted order as they are being added. Effectively bringing us down to an overall O(Competitors + Reviews + N) runtime.
