# Browser Navigation Project - DSA Assingment 1

Tamanna Khurana
Txk220058
CS 3345.005
8:30 Section - Professor Omar Hamdy 

# List of operations and explainations of implementations and time complexity
## Browser Linked List
### Node<T> 
    - inner class that only exists to help create the list and is not really used elsewhere, it is made public because stack iterator needs to acess the prev and next nodes to traverse from tail to head

### return new Iterator<T>() 
    - made an internal class because its only used for iterating over browserlinkedlist
    - has access to private variables of outer class so no getters needed
    - anonymous class used instead of private because less code and specifications needed so it makes program more concise to read

    add
    - creats a new node and assigns it the inputed url 
    - checks if list is empty, if not then it adds a node and increments size
    - only basic pointer assignment, no recursion or loops so it is O(1) time complexity


    remove
    - checks if list is empty, if so throws exception
    - checks if there is only one node, if so it assigns null to it
    - checks if the list is more than one node, then assigns null to head removing it
    - only basic pointer assignment, no recursion or loops so it is O(1) time complexity

    peek
    - checks if list is empty, if not it returns the data stores in head node
    - memory access, no recursion or loops so it is O(1) time complexity

    isempty
    - returning variable, no recursion or loops so it is O(1) time complexity

    getsize
    - getter method
    - memory access, no recursion or loops so it is O(1) time complexity

## Browser Array List
    enqueue
    - checks if list is full, if so executed expandcapacity method to make array dynamic
    - calculating index through modulus and assigning rear index the given data
    - memory access and assignment, no recursion or loops so it is O(1) time complexity
    - increments size
    - expandCapacity() is O(n) because it creates new arrays and copies elements which is a loop

    dequeue
    - checks if list is empty
    - calculates and assigns front index null through modulus operations thereby removing it
    - decrements size
    - memory access and assignment, no recursion or loops so it is O(1) time complexity

    isempty
    size
    - O(1) time complexity because just returns values 

## Browser Stack
    push
    - add method has O(1) time complexity

    pop
    - remove method has O(1) time complexity

    peek
    - checks if stack empty, if so throws empty stack exception 
    - else returns peek which is O(1)

    cleanList
    - reintialize linkedlist so O(1)

## Browser Queue
    enqueue
    - enqeueue is O(1) unless capacity is expanded

    dequeue
    - checks if empty, exception thrown if it is 
    - returns dequeue which is O(1)

## Browser Navigation 
    visitwebsite
    - checks if there is a url visited, if so, pushes onto backstack
    - adds url to the history queueu and then clears forwards stack before returning 
    - memory access and assignment, no recursion or loops so it is O(1) time complexity


    goback
    - checks if there is previous pages visited in the backstack
    - pushes the current website url to forward stack and then removes the same url from backstack 
    - assigns that to current url so it is able to access and output
    - memory access and assignment, no recursion or loops so it is O(1) time complexity

    goforward
    - checks if there is next page visited in the forwardstack 
    - pushes current url to backstack, and pops the next url from forward stack to access it
    - assigns to current url to access it 
    - returns string url 
    - memory access and assignment, no recursion or loops so it is O(1) time complexity

    clearhistory
    - cleansqueue method is O(1) time complexity and just returns a string

    printstate
    - checks if there is a current url, if so it outputs it 
    - otherwise states theres no current page
    - prints forward stack, back stack, queue
    - to print it must loop through those data structures
    - time complexity is O(n) because of loop executing n times

    close browser  
    - clears all stacks backstack forward stack and the history queue  
    - resets the current url to null  
    - the operations involve clearing data structures which is on time complexity due to the need to iterate through and remove each element  

    restorelastsession  
    - restores the last session by reinitializing the backstack forward stack and history queue from a saved file  
    - if the saved state is stored in a file or memory reading and reconstructing the data structures would take  O(n) time complexity where n is the number of elements in the saved state  

## Stack Iterator 
    next  
    - checks if there is a next element in the stack  
    - if there is it returns the next element and moves the iterator forward  
    - memory access and assignment, no recursion or loops so it is O(1) time complexity  

    traversal from tail to head  
    - iterates through the stack starting from the tail bottom to the head top  
    - uses a loop to traverse each element so the time complexity is O(n) where n is the number of elements in the stack  

