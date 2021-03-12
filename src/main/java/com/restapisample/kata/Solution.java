package com.restapisample.kata;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class Point {
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static String[] superStreetFighterize(String[][] allFighters, int[] position, String[] moves) {
        Point curPoint = new Point(position[0], position[1]);
        List<String> resultFighters = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            String move = moves[i];
            curPoint = advance(allFighters, curPoint, move);
            resultFighters.add(allFighters[curPoint.x][curPoint.y]);
        }

        return resultFighters.toArray(new String[0]);
    }

    private static Point advance(String[][] allFighters, Point curPoint, String move) {
        if (isHorizontalMove(move)){
            return traverseHorizontal(allFighters, curPoint, move);
        }
        return traverseVertical(allFighters, curPoint, move);
    }

    private static boolean isHorizontalMove(String move) {
        return move == "right" || move == "left";
    }

    private static Point traverseHorizontal(String[][] allFighters, Point curPoint, String move) {
        int length = allFighters[0].length;
        int horizontalMovement = move == "left" ? -1 : 1;

        int newHorizontalPosition = curPoint.y + horizontalMovement;
        newHorizontalPosition = advanceHorizontal(length, newHorizontalPosition);

        while (!isValid(allFighters, curPoint.x, newHorizontalPosition)) {
            newHorizontalPosition += horizontalMovement;
            newHorizontalPosition = advanceHorizontal(length, newHorizontalPosition);
        }

        return new Point(curPoint.x, newHorizontalPosition);
    }

    private static int advanceHorizontal(int length, int newHorizontalPosition) {
        if (newHorizontalPosition >= length) {
            newHorizontalPosition %= length;
        } else if (newHorizontalPosition < 0) {
            newHorizontalPosition += length;
        }
        return newHorizontalPosition;
    }

    private static Point traverseVertical(String[][] allFighters, Point curPoint, String move) {

        int verticalMovement = move == "up" ? -1 : 1;
        int newVerticalPosition = curPoint.x + verticalMovement;

        if (newVerticalPosition >= 0 && newVerticalPosition < allFighters.length && isValid(allFighters, newVerticalPosition, curPoint.y)){
            return new Point(newVerticalPosition, curPoint.y);
        }

        return new Point(curPoint.x, curPoint.y);
    }

    private static boolean isValid(String[][] allFighters, int x, int y) {
        return allFighters[x][y] != "";
    }
}
