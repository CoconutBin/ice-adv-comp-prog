package attacks.question;

import attacks.question.strategies.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
    private static QuestionBank instance;
    private final Map<Integer, Question[]> subjectData;
    private final Map<Integer, String> subjectNames;
    private final Map<Integer, List<Question>> remainingQuestions;

    private QuestionBank() {
        subjectData = new HashMap<>();
        subjectNames = new HashMap<>();
        remainingQuestions = new HashMap<>();

        subjectNames.put(1, "Calculus I");
        subjectData.put(1, new Question[] {
            // --- LIMITS & CONTINUITY ---
            new Question(new MultipleChoiceQuestionStrategy(), "If the left-hand limit and right-hand limit at x=c exist but are not equal, what exists at c?", new String[] {"A jump discontinuity", "A removable discontinuity", "An infinite discontinuity", "A vertical asymptote"}, "A jump discontinuity"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If a function is continuous at x=c, it must be differentiable at x=c.", "False"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If a function is differentiable at x=c, it must be continuous at x=c.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which theorem guarantees a function takes on every value between f(a) and f(b)?", new String[] {"Mean Value Theorem", "Intermediate Value Theorem", "Rolle's Theorem", "Extreme Value Theorem"}, "Intermediate Value Theorem"),
            new Question(new MultipleChoiceQuestionStrategy(), "A limit of the form 0/0 is called:", new String[] {"Undefined", "An indeterminate form", "Infinity", "Zero"}, "An indeterminate form"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the limit of f(x) as x approaches c is L, what must be true about f(c)?", new String[] {"f(c) = L", "f(c) must exist", "f(c) is undefined", "Nothing necessarily"}, "Nothing necessarily"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A function can have more than two horizontal asymptotes.", "False"),
            
            // --- DERIVATIVES ---
            new Question(new MultipleChoiceQuestionStrategy(), "The derivative of a function at a point represents the:", new String[] {"Area under the curve", "Slope of the tangent line", "Y-intercept", "Length of the curve"}, "Slope of the tangent line"),
            new Question(new MultipleChoiceQuestionStrategy(), "Where can the absolute extremum of a continuous function on a closed interval occur?", new String[] {"Only at critical points", "Only at endpoints", "Critical points or endpoints", "Only where f'(x)=0"}, "Critical points or endpoints"),
            new Question(new MultipleChoiceQuestionStrategy(), "If f'(c) = 0 and f''(c) > 0, then at x=c there is a:", new String[] {"Local Maximum", "Local Minimum", "Inflection Point", "Vertical Tangent"}, "Local Minimum"),
            new Question(new MultipleChoiceQuestionStrategy(), "If f''(x) changes sign at x=c, then (c, f(c)) is:", new String[] {"A critical point", "A cusp", "An inflection point", "A hole"}, "An inflection point"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which theorem requires f(a) to equal f(b) and a derivative of zero to exist between them?", new String[] {"Mean Value Theorem", "Squeeze Theorem", "Rolle's Theorem", "Taylor's Theorem"}, "Rolle's Theorem"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If f'(x) > 0 for all x in an interval, the function is increasing on that interval.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "A function has a 'sharp corner' or 'cusp' at x=c. The derivative f'(c) is:", new String[] {"Zero", "Positive", "Negative", "Undefined"}, "Undefined"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the velocity of a particle is constant, its acceleration is:", new String[] {"Positive", "Negative", "Zero", "Increasing"}, "Zero"),
            new Question(new MultipleChoiceQuestionStrategy(), "The derivative of an even function is always:", new String[] {"Even", "Odd", "Constant", "Positive"}, "Odd"),
            
            // --- INTEGRATION ---
            new Question(new MultipleChoiceQuestionStrategy(), "The Fundamental Theorem of Calculus relates which two concepts?", new String[] {"Limits and Derivatives", "Differentiation and Integration", "Slope and Concavity", "Area and Volume"}, "Differentiation and Integration"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The definite integral can represent a negative value.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The '+ C' in an indefinite integral represents:", new String[] {"A specific constant", "An arbitrary constant of integration", "The speed of light", "The slope"}, "An arbitrary constant of integration"),
            new Question(new MultipleChoiceQuestionStrategy(), "The area under a velocity-time graph represents:", new String[] {"Acceleration", "Position", "Displacement", "Jerk"}, "Displacement"),
            new Question(new MultipleChoiceQuestionStrategy(), "If f(x) is an odd function, the integral from -a to a of f(x) dx is:", new String[] {"2 * f(a)", "a^2", "Zero", "Undefined"}, "Zero"),
            new Question(new MultipleChoiceQuestionStrategy(), "A Riemann sum with an infinite number of subintervals is equivalent to:", new String[] {"A derivative", "A limit of a sequence", "A definite integral", "A tangent line"}, "A definite integral"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Every continuous function has an antiderivative.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Integration by substitution is essentially the reverse of:", new String[] {"The Power Rule", "The Product Rule", "The Chain Rule", "The Quotient Rule"}, "The Chain Rule"),
            
            // --- GENERAL CONCEPTS ---
            new Question(new MultipleChoiceQuestionStrategy(), "If f(x) is concave up, then its derivative f'(x) is:", new String[] {"Negative", "Zero", "Increasing", "Decreasing"}, "Increasing"),
            new Question(new MultipleChoiceQuestionStrategy(), "Linearization is the process of approximating a curve using a:", new String[] {"Parabola", "Tangent line", "Horizontal line", "Secant line"}, "Tangent line"),
            new Question(new MultipleChoiceQuestionStrategy(), "L'Hopital's Rule is used to evaluate:", new String[] {"Complex derivatives", "Indeterminate limits", "Area under curves", "Volume of solids"}, "Indeterminate limits"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: All critical points are local extrema.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "If a function is increasing and concave down, its slope is:", new String[] {"Positive and increasing", "Positive and decreasing", "Negative and increasing", "Negative and decreasing"}, "Positive and decreasing"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Mean Value Theorem states there is at least one point where the instantaneous rate of change equals the:", new String[] {"Initial rate of change", "Average rate of change", "Final rate of change", "Zero rate of change"}, "Average rate of change"),
            // --- OPTIMIZATION & RELATED RATES ---
            new Question(new MultipleChoiceQuestionStrategy(), "In an optimization problem, if the domain of the primary equation is a closed interval, you must check:", new String[] {"Only critical points", "Only endpoints", "Both critical points and endpoints", "The y-intercept"}, "Both critical points and endpoints"),
            new Question(new MultipleChoiceQuestionStrategy(), "Related rates problems are typically solved using which technique?", new String[] {"Integration by parts", "Implicit differentiation", "Logarithmic differentiation", "Partial fractions"}, "Implicit differentiation"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If the volume of a sphere is increasing at a constant rate, its radius is also increasing at a constant rate.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "When minimizing the distance from a point to a curve, it is mathematically easier to minimize the:", new String[] {"Square root of the distance", "Square of the distance", "Slope of the distance", "Reciprocal of the distance"}, "Square of the distance"),
            new Question(new MultipleChoiceQuestionStrategy(), "If a searchlight rotates at a constant rate, the speed of the light beam along a wall:", new String[] {"Is constant", "Increases as it moves further from the light", "Decreases as it moves further", "Is always zero"}, "Increases as it moves further from the light"),

            // --- THEOREMS & DEFINITIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The limit definition of a derivative uses the slope of a _____ line to find the slope of a _____ line.", new String[] {"Tangent, Secant", "Secant, Tangent", "Horizontal, Vertical", "Normal, Tangent"}, "Secant, Tangent"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If a function is continuous on a closed interval [a, b], it must have an absolute maximum and minimum.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the derivative of any constant value?", new String[] {"1", "The constant itself", "Zero", "Undefined"}, "Zero"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Power Rule states that the derivative of x^n is:", new String[] {"n*x^n", "n*x^(n-1)", "x^(n+1)/(n+1)", "n^x"}, "n*x^(n-1)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The derivative of a sum is the sum of the derivatives.", "True"),

            // --- GRAPHICAL ANALYSIS ---
            new Question(new MultipleChoiceQuestionStrategy(), "If f'(x) is decreasing, then the graph of f(x) is:", new String[] {"Increasing", "Concave Up", "Concave Down", "Linear"}, "Concave Down"),
            new Question(new MultipleChoiceQuestionStrategy(), "A point where the graph has a tangent line but f'(x) is infinite is called a:", new String[] {"Horizontal tangent", "Vertical tangent", "Hole", "Asymptote"}, "Vertical tangent"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the graph of f(x) has a horizontal asymptote y = L, then the limit as x approaches infinity of f(x) is:", new String[] {"Infinity", "Zero", "L", "Undefined"}, "L"),
            new Question(new MultipleChoiceQuestionStrategy(), "If f(x) has a vertical asymptote at x = c, then f(c) is:", new String[] {"Zero", "Positive", "Negative", "Undefined"}, "Undefined"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A function can cross its own horizontal asymptote.", "True"),

            // --- INTEGRATION CONCEPTS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The 'Net Change Theorem' states that the integral of a rate of change is the:", new String[] {"Total accumulation", "Net change in the original function", "Average value", "Derivative of the function"}, "Net change in the original function"),
            new Question(new MultipleChoiceQuestionStrategy(), "The process of finding a function given its derivative is called:", new String[] {"Differentiation", "Antidifferentiation", "Simplification", "Linearization"}, "Antidifferentiation"),
            new Question(new MultipleChoiceQuestionStrategy(), "The 'Average Value' of a function f(x) on [a, b] involves dividing the integral by:", new String[] {"f(b) - f(a)", "b - a", "a + b", "2"}, "b - a"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the upper and lower limits of a definite integral are the same, the integral equals:", new String[] {"1", "The value of the function", "Zero", "Infinity"}, "Zero"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Integration is the inverse process of differentiation.", "True")
        });

        subjectNames.put(2, "Physics I");
        subjectData.put(2, new Question[] {
            new Question(new MultipleChoiceQuestionStrategy(), "What is the acceleration due to gravity on Earth (m/s^2)?", new String[] {"9.8", "10", "8.9", "11"}, "9.8")
        });

        subjectNames.put(3, "Calculus II");
        subjectData.put(3, new Question[] {
            new Question(new WrittenQuestionStrategy(), "What is the integral of 1/x dx?", "ln|x|"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Integration is the inverse process of differentiation.", "True")
        });

        subjectNames.put(4, "Physics II");
        subjectData.put(4, new Question[] {
            new Question(new MultipleChoiceQuestionStrategy(), "What is the unit of electric capacitance?", new String[] {"Ohm", "Farad", "Tesla", "Volt"}, "Farad")
        });

        subjectNames.put(5, "Computer Programming");
        subjectData.put(5, new Question[] {
            new Question(new MultipleChoiceQuestionStrategy(), "Which of these is used to define a function in Python?", new String[] {"func", "define", "def", "function"}, "def"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which symbol is used for comments in Python?", new String[] {"//", "/*", "#", "--"}, "#")
        });

        subjectNames.put(6, "Advance Computer Programming");
        subjectData.put(6, new Question[] {
            new Question(new WrittenQuestionStrategy(), "Assuming an interface called Loggable, fill in the blank:\nclass Player ______ Loggable", "implements"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of these is NOT a primitive type in Java?", new String[] {"int", "double", "String", "boolean"}, "String")
        });

        subjectNames.put(7, "Probability and Statistics for Data Analysis");
        subjectData.put(7, new Question[] {
            new Question(new MultipleChoiceQuestionStrategy(), "What is the probability of flipping a coin and getting heads?", new String[] {"0", "0.5", "1", "0.25"}, "0.5")
        });
    }

    public static QuestionBank getInstance() {
        if (instance == null) {
            instance = new QuestionBank();
        }
        return instance;
    }

    public Question[] getQuestionsByNumber(int subjectNumber) {
        return subjectData.getOrDefault(subjectNumber, new Question[0]);
    }

    public String getSubjectName(int subjectNumber) {
        return subjectNames.getOrDefault(subjectNumber, "Unknown Subject");
    }

    public Question getRandomQuestion(int subjectNumber) {
        Question[] questions = getQuestionsByNumber(subjectNumber);
        if (questions.length == 0) return null;
        return questions[(int) (Math.random() * questions.length)];
    }
    
    public void resetSubjectDeck(int subjectNumber) {
        Question[] original = subjectData.get(subjectNumber);
        if (original != null) {
            List<Question> shuffledList = new ArrayList<>(Arrays.asList(original));
            Collections.shuffle(shuffledList); // Randomize the order
            remainingQuestions.put(subjectNumber, shuffledList);
        }
    }

    // UPDATED: Get a question without repeats
    public Question getUniqueQuestion(int subjectNumber) {
        // If the deck doesn't exist or is empty, refill and shuffle it
        if (!remainingQuestions.containsKey(subjectNumber) || remainingQuestions.get(subjectNumber).isEmpty()) {
            resetSubjectDeck(subjectNumber);
        }

        // Pull the top question off the "deck"
        List<Question> deck = remainingQuestions.get(subjectNumber);
        return deck.remove(0); // Removes and returns the first question
    }
}