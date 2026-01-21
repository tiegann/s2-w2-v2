import java.util.ArrayList;

public class AnalyzeRain {
    //TASK #1: initialize an arraylist called year containing Day objects
    ArrayList<Day> year; // = ....

    public AnalyzeRain(){
        for(int d = 1; d <= 365; d++){
            year.add(new Day(d, (int)(Math.random()*2) == 1));
        }
        System.out.println(this.numRunsOf(2));
        System.out.println(this.findLastDayOfRain());
        System.out.println(this.firstTimeTwoOrMoreDaysRainInARow());
    }

    //TASK #2: return the total number of days it rains.
    public int totalDaysRain(){
        int count = 0;
        

        return count;
    }

    //TASK #3
    //returns the day number of the last day it rained
    //in the year. What does the -1 indicate?
    public int findLastDayOfRain(){
        // for(//complete this  ){
        //     Day d = year.get(x);
        //     if(d.didRain())
        //         return x;
        // }
        return -1;
    }

    //TASK #4
    //using a process neighbors algorithm return the first
    //day of the year where there are two days in a row(or more)
    //of rain. 
    public int firstTimeTwoOrMoreDaysRainInARow(){
        int countDaysInRow = 1;
        
        return -1;
    }

    //TASK #5
    //this method intends to count the number of times it
    //rains daysInRow times
    //it is almost right. Fix it.
    public int numRunsOfNeighbors(int daysInRow){
        int count = 0;
        int countDaysInRow = 1;
        for(int x = 0; x < year.size() - 1; x++){
            if(year.get(x).didRain() == year.get(x+1).didRain()){
                countDaysInRow++;
                if(countDaysInRow == daysInRow)
                    count++;
            } else {
                countDaysInRow = 1;
            }
        }
        return count;
    }

    //TASK #6
    //WITHOUT processing neighbors and using the 
    //enhanced for loop ==> for(Day d: year)
    //return the number of times in a year that rains
    //the parameter daysInRow times:
    // numRunsOf(2) --> How many times did it rain 2 days in row?
    // numRunsOf(4) --> How many times did it rain 4 days in row?
    public int numRunsOf(int daysInRow){
        int count = 0;
        int countDaysInRow = 0;

        return count;
    }

}
