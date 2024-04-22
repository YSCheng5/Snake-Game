/*
 * Created on 2024-04-08
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.ArrayList;

public class Snake {
    private SnakeSegment head;
    private boolean grow;
    private Direction direction = Direction.RIGHT; // Default direction

    public Snake() {
        // You may change this code for extra credit (implement some fancy stuff!)
        // Feel free to make the starting position random
        Position startingPosition = new Position(10, 10);
        head = new SnakeSegment(startingPosition);
    }

    
    public void grow() {
        grow = true;
    
    }

    private void removeTail() {
        if(head.getNext() == null){
            return;
        }
        SnakeSegment current = head;
        while(current.getNext().getNext() != null){
            current = current.getNext();
        }
        current.setNext(null);
        
    }

    // Returns true if the snake is colliding with itself
    public boolean isColliding() {
        if (isInSnake(head.getPosition())) {
            return true;
        }
        return false;
    }

    // TODO: Implement isInSnake
    // Returns true if the specified position is inside the body of the snake
    public boolean isInSnake(Position position) {
        SnakeSegment current = head.getNext();
        while(current != null){
            if(current.getPosition().equals(position)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Sets the direction the snake will move in
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
 
    public int getLength() {
        int count = 0;
        SnakeSegment current = head;
        while (current != null){
            count ++;
            current = current.getNext();
        }

        return count;
    }

    // Moves the snake by one in the next direction
    public void move() {
        // HINT: You may add and remove nodes here
        Position newPosition = head.getPosition().add(direction.deltaPosition());
        SnakeSegment newHead = new SnakeSegment(newPosition);
        newHead.setNext(head);
        head = newHead;
        
         if (!grow) {
            removeTail();
         } else {
            grow = false;
         }
    }

   
    public SnakeSegment getHead() {
        return this.head;
    }

    public SnakeSegment getBody() {
        return head.getNext();
    }

    public void pause() {
        // OPTIONAL: Pause/unpause the snake
    }

    public Direction getMove(ArrayList<Food> food) {
        // OPTIONAL: Implement an algorithm that moves the food for us!
        return null;
    }

    public boolean isPositionOutOfBounds() {
        Position position = head.getPosition();
        if (position.x < 0 || position.x > 800 || position.y < 0 || position.y > 600) {
            System.out.println("Out of bounds");
            return true;
        } 
        return false;
    }


}

class SnakeSegment {
    private Position position;
    private SnakeSegment next;

    public SnakeSegment(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return this.position;
    }

    public SnakeSegment getNext() {
        return this.next;
    }

    public void setNext(SnakeSegment next) {
        this.next = next;
    }

}
