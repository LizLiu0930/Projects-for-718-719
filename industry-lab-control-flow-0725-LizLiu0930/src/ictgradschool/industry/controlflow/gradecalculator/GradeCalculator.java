package ictgradschool.industry.controlflow.gradecalculator;

import ictgradschool.Keyboard;

public class GradeCalculator {

    public char getLetterGrade(double percentageScore){
        char letterGrade = '0';
        // TODO: write your code here to set the letter grade based on the percentage
        /*
         * The grades should be determined as follow:
         * 85% - 100% = A; 70% - 84% = B; 50% - 69% = C; 0% - 49% = D
         * */

        return letterGrade;
    }

    public double getPercentageScore(){
        System.out.println("Please input your percentage score from zero to one hundred");
        // TODO: Modify the contents of this method so that the prompt will repeat if the user does enter a number from 0 - 100
        return Double.parseDouble(Keyboard.readInput());
    }

    public void start(){
        double percentageScore = getPercentageScore();
        char letterGrade = getLetterGrade(percentageScore);
        System.out.println("Your grade is: " + letterGrade);
    }



    public static void main(String[] args) {
        GradeCalculator gradeCalculator = new GradeCalculator();
        gradeCalculator.start();
    }

}
