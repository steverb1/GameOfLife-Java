package com.siq.gameoflife;

public class Cell
{
    private boolean alive = false;
    private int xPosition;
    private int yPosition;

    public int liveNeighbors = 0;

    public Cell(int xPosition, int yPosition)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public boolean isAlive()
    {
        if (liveNeighbors == 3)
        {
            alive = true;
        }

        if (alive && liveNeighbors == 1)
        {
            alive = false;
        }

        return alive;
    }

    public void makeDead()
    {
        alive = false;
    }

    public void makeAlive()
    {
        alive = true;
    }

    public boolean isNeighborTo(Cell otherCell)
    {
        int xDelta = Math.abs(xPosition - otherCell.xPosition);
        int yDelta = Math.abs(yPosition - otherCell.yPosition);

        return xDelta <= 1 && yDelta <= 1;
    }
}