package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAdd() {
        ImmutableList immutableArrayList1 = new ImmutableArrayList();
        ImmutableList immutableArrayList2 = immutableArrayList1.add(5);
        assertSame(5, immutableArrayList2.get(0));
        immutableArrayList1 = immutableArrayList2.add(6);
        assertSame(5, immutableArrayList1.get(0));
        assertSame(6, immutableArrayList1.get(1));
        immutableArrayList2 = immutableArrayList1.add(7);
        assertSame(5, immutableArrayList2.get(0));
        assertSame(6, immutableArrayList2.get(1));
        assertSame(7, immutableArrayList2.get(2));
        immutableArrayList1 = immutableArrayList2.add(1, 10);
        assertSame(10, immutableArrayList1.get(1));
    }

    @Test
    public void testAddAll() {
        ImmutableList immutableArrayList1 = new ImmutableArrayList();

        Object[] array_to_add = {1, 2, 3};
        ImmutableList immutableArrayList2 = immutableArrayList1.addAll(array_to_add);

        assertSame(1, immutableArrayList2.get(0));
        assertSame(2, immutableArrayList2.get(1));
        assertSame(3, immutableArrayList2.get(2));

        array_to_add = new Object[]{5, 6, 7};
        immutableArrayList1 = immutableArrayList2.addAll(1, array_to_add);
        assertSame(1, immutableArrayList1.get(0));
        assertSame(5, immutableArrayList1.get(1));
        assertSame(6, immutableArrayList1.get(2));
        assertSame(7, immutableArrayList1.get(3));

    }

    @Test
    public void testRemove() {
        ImmutableList immutableArrayList1 = new ImmutableArrayList();

        Object[] array_to_add = {1, 2, 3};
        ImmutableList immutableArrayList2 = immutableArrayList1.addAll(array_to_add);
        immutableArrayList1 = immutableArrayList2.remove(1);

        assertSame(1, immutableArrayList1.get(0));
        assertSame(3, immutableArrayList1.get(1));
        immutableArrayList2 = immutableArrayList1.remove(0);

        assertSame(3, immutableArrayList2.get(0));
        immutableArrayList1 = immutableArrayList2.remove(0);

        assertEquals(true, immutableArrayList1.isEmpty());

    }

    @Test
    public void testSet() {
        ImmutableList immutableArrayList1 = new ImmutableArrayList();

        Object[] array_to_add = {1, 2, 3};
        ImmutableList immutableArrayList2 = immutableArrayList1.addAll(array_to_add);
        immutableArrayList1 = immutableArrayList2.set(0, 9);

        assertSame(9, immutableArrayList1.get(0));
        assertSame(2, immutableArrayList1.get(1));
        assertSame(3, immutableArrayList1.get(2));

        immutableArrayList2 = immutableArrayList1.set(1, 9);

        assertSame(9, immutableArrayList2.get(0));
        assertSame(9, immutableArrayList2.get(1));
        assertSame(3, immutableArrayList2.get(2));

        immutableArrayList1 = immutableArrayList2.set(2, 9);
        assertSame(9, immutableArrayList1.get(0));
        assertSame(9, immutableArrayList1.get(1));
        assertSame(9, immutableArrayList1.get(2));

    }

    @Test
    public void testIndex() {
        ImmutableList immutableArrayList1 = new ImmutableArrayList();

        Object[] array_to_add = {1, 2, 3, 1};
        ImmutableList immutableArrayList2 = immutableArrayList1.addAll(array_to_add);

        assertSame(0, immutableArrayList2.indexOf(1));
        assertSame(1, immutableArrayList2.indexOf(2));
        assertSame(2, immutableArrayList2.indexOf(3));
        assertSame(-1, immutableArrayList2.indexOf(4));
        immutableArrayList1 = immutableArrayList2.remove(0);
        assertSame(2, immutableArrayList1.indexOf(1));

    }

    @Test
    public void testClear() {
        ImmutableList immutableArrayList1 = new ImmutableArrayList();

        Object[] array_to_add = {1, 2, 3, 1};
        ImmutableList immutableArrayList2 = immutableArrayList1.addAll(array_to_add);

        immutableArrayList1 = immutableArrayList2.clear();
        assertSame(0, immutableArrayList1.size());

    }

    @Test
    public void testToArray() {
        ImmutableList immutableArrayList1 = new ImmutableArrayList();

        Object[] array_to_add = {1, 2, 3, 1};
        ImmutableList immutableArrayList2 = immutableArrayList1.addAll(array_to_add);
        Object arr[] = immutableArrayList2.toArray();

        assertArrayEquals(arr, array_to_add);

    }

}
