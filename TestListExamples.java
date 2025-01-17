import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}
class Tester implements StringChecker {
  public boolean checkString(String s) {
    if(s.length() < 10) {
      return true;
    }
    return false;
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  @Test
    public void testFilter() {
        List<String> testList= new ArrayList<>();
        testList.add("hellooooooooo");
        testList.add("world");
        testList.add("!");
        StringChecker a = new Tester();
        

        
        List<String> expected  = new ArrayList<>();
        expected.add("world");
        expected.add("!");

        assertEquals(expected,ListExamples.filter(testList,a));

    }
    @Test
    public void testMerge() {
        List<String> testList = new ArrayList<>();
        testList.add("a");
        testList.add("b");

        List<String> testList1 = new ArrayList<>();
        testList1.add("c");
        testList1.add("d");

        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("a");
        expectedOutput.add("b");
        expectedOutput.add("c");
        expectedOutput.add("d");

        List<String> gottenOutput = ListExamples.merge(testList,testList1);
        
        assertEquals(expectedOutput,gottenOutput);

    }
    @Test
   public void filterTest() {
       List<String> inputList = Arrays.asList("apple", "bbaannaannaa", "cherry", "daaatteeee");
       List<String> expectedResult = Arrays.asList("apple", "cherry");
       StringChecker a = new Tester();


       List<String> result = ListExamples.filter(inputList, a);
      
       assertEquals(expectedResult, result);
   }


   @Test
   public void mergeTest() {
       List<String> list1 = Arrays.asList("apple", "banana", "cherry");
       List<String> list2 = Arrays.asList("date", "fig", "grape");
       List<String> expectedResult = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");


       List<String> result = ListExamples.merge(list1, list2);


       assertEquals(expectedResult, result);
   }


   @Test
   public void mergeTestWithEmptyList() {
       List<String> list1 = Arrays.asList("apple", "banana", "cherry");
       List<String> list2 = new ArrayList<>();
       List<String> expectedResult = Arrays.asList("apple", "banana", "cherry");


       List<String> result = ListExamples.merge(list1, list2);


       assertEquals(expectedResult, result);
   }


   @Test
   public void mergeTestWithEmptyLists() {
       List<String> list1 = new ArrayList<>();
       List<String> list2 = new ArrayList<>();
       List<String> expectedResult = new ArrayList<>();


       List<String> result = ListExamples.merge(list1, list2);


       assertEquals(expectedResult, result);
   }

  
}
