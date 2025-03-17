package queue;

/*
 * CS112 Queue Lab - azra bano
 * 
 * Implement enqueue(), dequeue() using a linked-list based queue of strings
 * to represent a line of people waiting for a theme park attraction.
 * 
 * This Queue uses two pointers, one to store the front of the line and one to store the back. 
 * Each person is represented by a node called a Rider, which holds a string. 
 * 
 * The Rider at the front of the line is dequeued first, and that Rider has a "next" attribute
 * which points to the person behind them. Riders are enqueued at the end of the line.
 * 
 * i.e.
 * frontOfLine -> Rider -> Rider -> endOfLine ->
 *      ^                                       ^
 * dequeue from here                     enqueue here
 * 
 * @author Colin Sullivan
 */
public class ThemeParkQueue {
    private Rider frontOfLine;
    private Rider endOfLine;
    private int lineLength;

    /*
     * Constructor which initializes the linked list queue as empty.
     */
    public ThemeParkQueue() {
        // DO NOT MODIFY
        frontOfLine = null;
        endOfLine = null;
        lineLength = 0;
    }

    /**
     * Enqueue method which adds a rider at the end of the line
     * and increments the number of riders attribute.
     * 
     * Remember, each Rider points to the one behind them. So endOfLine.next should
     * always be null.
     * If there are no Riders in line, both frontOfLine and endOfLine will be null.
     * 
     * To enqueue, add a new Rider behind the current endOfLine, then mark that
     * rider as the new end of the line. Finally, increment the lineLength attribute by one.
     * 
     * @param toAdd String value to enqueue in a Rider node.
     */
    public void enqueue(String toAdd) {
        // Create a new rider
        Rider newRider = new Rider();
        newRider.name = toAdd; // Assign the name
        newRider.next = null; // Ensure the new rider is the last one

        // If the queue is empty, set frontOfLine and endOfLine to the new rider
        if (frontOfLine == null) {
            frontOfLine = newRider;
            endOfLine = newRider;
        } else {
            // Add the new rider to the end and update endOfLine
            endOfLine.next = newRider;
            endOfLine = newRider;
        }

        // Increment the queue length
        lineLength++;
    }

    /**
     * Dequeue method which removes the rider at the front of the line and
     * decrements the number of riders attribute.
     * 
     * Remember, each Rider points to the one behind them. So frontOfLine.next will
     * be the second rider in line (or null if there is only one Rider).
     * If there are no Riders in line, both frontOfLine and endOfLine will be null.
     * 
     * To dequeue, first store the name of the frontOfLine Rider in a String variable.
     * Then, set frontOfLine = frontOfLine.next. Finally, decrement the lineLength
     * attribute by 1 and return the String name you stored.
     * 
     * @return Rider which was at the front of the queue.
     */
    public String dequeue() {
        // If queue is empty
        if (frontOfLine == null) {
            return null;
        }

        // If there's only 1 rider in the queue
        if (frontOfLine == endOfLine) {
            String riderName = frontOfLine.name;
            frontOfLine = null;
            endOfLine = null;
            lineLength--; // Decrement queue length
            return riderName; // Return the name of the removed rider
        }

        // Store the name of the front rider and move frontOfLine to the next rider
        String riderName = frontOfLine.name;
        frontOfLine = frontOfLine.next;

        // Decrement queue length
        lineLength--;

        // Return removed name
        return riderName;
    }

    /*
     * Getter method for length of line.
     * 
     * @return number of riders in line (lineLength).
     */
    public int getLineLength() {
        // DO NOT EDIT
        return lineLength;
    }

    /*
     * Getter method for front of the line.
     * 
     * @return frontOfLine.
     */
    public Rider getFront() {
        // DO NOT EDIT
        return frontOfLine;
    }
}
