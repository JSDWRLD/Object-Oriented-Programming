/*
    Write a method splitStack that takes a stack of integers as a parameter
    and splits it into negatives and non-negatives. The numbers in the stack
    should be rearranged so that all the negatives appear on the bottom of the 
    stack and all the non-negatives appear on the top. In other words, if after this 
    method is called you were to pop numbers off the stack, you would first get 
    all the nonnegative numbers and then get all the negative numbers. It does not 
    matter what order the numbers appear in as long as all the negatives appear lower in 
    the stack than all the non-negatives. You may use a single queue as auxiliary storage. 
 */
 
public static void splitStack (Stack<Integer> stack){
    
    Queue<Integer> queue = new LinkedList<Integer>(); //Copy all stack data
    while(!stack.isEmpty()){
        queue.add(stack.pop());
    }
    
    // at this point the original stack is empty
    // all we have to do is add to the original stack
    int size = queue.size();
    for(int i = 0; i < size; i++){
        int current = queue.remove(); // gets from the bottom cause FIFO
        if(current < 0){
            stack.push(current); // if negative puts it into stack first, bottom
        } else {
            queue.add(current); // adds positive numbers back into queue
        }
    }
    
    // pushes all the positive numbers in queue to stack
    while(!queue.isEmpty()){
        stack.push(queue.remove());
    }
}