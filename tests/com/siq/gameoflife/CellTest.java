package com.siq.gameoflife;

import org.junit.*;

import static org.junit.Assert.*;

public class CellTest
{
    @Test
    public void deadCellWithNoNeighborsRemainsDead()
    {
        Cell cell = new Cell(0, 0);
        cell.makeDead();
        cell.liveNeighbors = 0;

        assertFalse(cell.isAlive());
    }

    @Test
    public void deadCellWithThreeLiveNeighborsComesAlive()
    {
        Cell cell = new Cell(0, 0);
        cell.makeDead();
        cell.liveNeighbors = 3;

        assertTrue(cell.isAlive());
    }

    @Test
    public void liveCellWithOneNeighborDies()
    {
        Cell cell = new Cell(0, 0);
        cell.makeAlive();
        cell.liveNeighbors = 1;

        assertFalse(cell.isAlive());
    }

    @Test
    public void cellCanDetectNeighbor1()
    {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(1, 0);

        assertTrue(cell1.isNeighborTo(cell2));
    }

    @Test
    public void cellCanDetectNeighbor2()
    {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(1, 1);

        assertTrue(cell1.isNeighborTo(cell2));
    }

    @Test
    public void cellCanDetectNeighbor3()
    {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);

        assertTrue(cell1.isNeighborTo(cell2));
    }

    @Test
    public void cellCanDetectNonNeighbor()
    {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(2, 0);

        assertFalse(cell1.isNeighborTo(cell2));
    }
}