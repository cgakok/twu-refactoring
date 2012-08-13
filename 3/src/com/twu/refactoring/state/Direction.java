package com.twu.refactoring.state;

import java.util.HashMap;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    static HashMap<Character, Direction> directionsForRight = new HashMap<Character, Direction>();
    static HashMap<Character, Direction> directionsForLeft = new HashMap<Character, Direction>();

    static {
        directionsForRight.put('N', new Direction('E'));
        directionsForRight.put('S', new Direction('W'));
        directionsForRight.put('E', new Direction('S'));
        directionsForRight.put('W', new Direction('N'));
        directionsForLeft.put('N', new Direction('W'));
        directionsForLeft.put('S', new Direction('E'));
        directionsForLeft.put('E', new Direction('N'));
        directionsForLeft.put('W', new Direction('S'));
    }

    public Direction turnRight() {
        return directionsForRight.get(direction);

    }

    public Direction turnLeft() {
        return directionsForLeft.get(direction);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        if (direction != direction1.direction) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

}
