import java.util.Scanner;
public class QuizApp {
    private static int score=0;
    public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    String[][]questions={
        {"What is the largest planet in our solar system?","1.Earth","2.Mars","3.Jupiter","4.Venus","3"},
{"Who painted the Monolisa?","1.Vincent van graph","2.leonardo da vinci","Pablo pisacco","3.Claude monet","2"},
{"What is the chemical symbol for water?","1.CO2","2.H2O","3.O2","H2","2"}
};
System.out.println("Welcome to the quiz!");
System.out.println("You have to answer each question.Good luck!\n");
for(String[]question:questions){
    askQuestions(question,scanner);
}
System.out.println("\nQuiz Over! your final score is:"+score);
scanner.close();

    }
    private static void askQuestions(String[]question,Scanner scanner){
        System.out.println(question[0]);
        System.out.println("1."+question[1]);
        System.out.println("2"+question[2]);
        System.out.println("3"+question[3]);
        System.out.println("4"+question[4]);
        System.out.println("Enter your choice(1-4):");
        int userAnswer=scanner.nextInt();
        if(String.valueOf(userAnswer).equals(question[5]))
        {
            System.out.println("correct!\n");
            score++;
        }else{
            System.out.println("wrong! the correct answer option"+question[5]+".\n");
        }
    
        }
    }
