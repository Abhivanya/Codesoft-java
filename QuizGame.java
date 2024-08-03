import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizGame {
    static Question[] questions = new Question[] {
        new Question("What is the capital of France?", new String[] {"Paris", "London", "Berlin", "Rome"}, 0),
        new Question("What is the largest planet in our solar system?", new String[] {"Earth", "Saturn", "Jupiter", "Uranus"}, 2),
        new Question("Who painted the Mona Lisa?", new String[] {"Leonardo da Vinci", "Michelangelo", "Raphael", "Caravaggio"}, 0),
        new Question("What is the chemical symbol for gold?", new String[] {"Ag", "Au", "Hg", "Pb"}, 1),
        new Question("Who wrote Romeo and Juliet?", new String[] {"William Shakespeare", "Jane Austen", "Charles Dickens", "J.K. Rowling"}, 0)
    };

    static int score = 0;
    static int currentQuestion = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        while (currentQuestion < questions.length) {
            Question question = questions[currentQuestion];
            System.out.println("\nQuestion " + (currentQuestion + 1) + ": " + question.question);
            for (int i = 0; i < question.options.length; i++) {
                System.out.println((i + 1) + ". " + question.options[i]);
            }

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    currentQuestion++;
                    if (currentQuestion < questions.length) {
                        System.out.println("Moving on to the next question...");
                    } else {
                        System.out.println("Quiz over! Let's see your results...");
                        displayResults();
                    }
                }
            };
            timer.schedule(task, 10 * 1000); // 10 seconds

            System.out.print("Enter your answer (1-" + question.options.length + "): ");
            int answer = scanner.nextInt();
            timer.cancel();

            if (answer == question.correctAnswer + 1) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + question.options[question.correctAnswer]);
            }

            currentQuestion++;
        }

        displayResults();
    }

    static void displayResults() {
        System.out.println("\nQuiz Results:");
        System.out.println("Score: " + score + "/" + questions.length);
        System.out.println("Summary:");
        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            System.out.println("Question " + (i + 1) + ": " + (score > i ? "Correct" : "Incorrect"));
        }
    }
}