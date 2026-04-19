package attacks.question;

import attacks.question.strategies.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
    private static QuestionBank instance = new QuestionBank();
    private final Map<Subject, Question[]> subjectData;
    private final Map<Subject, List<Question>> remainingQuestions;

    private QuestionBank() {
        subjectData = new HashMap<>();
        remainingQuestions = new HashMap<>();

        subjectData.put(Subject.CALCULUS_I, new Question[] {
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
            new Question(new TrueFalseQuestionStrategy(), "True or False: Integration is the inverse process of differentiation.", "True"),
            
            //Written
            new Question(new WrittenQuestionStrategy(), "What is the derivative of sin(x)?", "cos(x)"),
            new Question(new WrittenQuestionStrategy(), "What is the limit of 1/x as x approaches infinity?", "0"),
            new Question(new WrittenQuestionStrategy(), "What rule is used to find the derivative of f(g(x))?", "Chain Rule"),
            new Question(new WrittenQuestionStrategy(), "What is the derivative of any constant value?", "0"),
            new Question(new WrittenQuestionStrategy(), "If f'(x) is positive, is the function increasing or decreasing?", "Increasing")
        });

        subjectData.put(Subject.PHYSICS_I, new Question[] {
            // --- PHYSICS I COMPLETE DATASET (50 QUESTIONS) ---

            // KINEMATICS & NEWTON'S LAWS
            new Question(new TrueFalseQuestionStrategy(), "True or False: An object can have a velocity of zero while still accelerating.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What does the slope of a Velocity vs. Time graph represent?", new String[] {"Position", "Acceleration", "Force", "Displacement"}, "Acceleration"),
            new Question(new MultipleChoiceQuestionStrategy(), "In a vacuum, if a hammer and a feather are dropped simultaneously, which hits first?", new String[] {"Hammer", "Feather", "Both at once", "Neither"}, "Both at once"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A bug hitting a bus windshield experiences a greater force than the bus.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "What property of an object resists any change in its state of motion?", new String[] {"Gravity", "Velocity", "Inertia", "Weight"}, "Inertia"),
            new Question(new MultipleChoiceQuestionStrategy(), "An object is moving at a constant velocity. What is the net force acting on it?", new String[] {"Zero", "Equal to mass", "Gravity", "Constant force"}, "Zero"),
            new Question(new MultipleChoiceQuestionStrategy(), "At the peak of a projectile's flight, its vertical acceleration is:", new String[] {"0", "9.8 m/s^2 downward", "9.8 m/s^2 upward", "Changing"}, "9.8 m/s^2 downward"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An object in free fall is technically in a state of weightlessness.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If a ball is thrown upward, its acceleration on the way down is:", new String[] {"Greater than 9.8", "Less than 9.8", "Exactly 9.8", "Zero"}, "Exactly 9.8"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Mass is a measure of an object's inertia.", "True"),

            // FORCES & FRICTION
            new Question(new MultipleChoiceQuestionStrategy(), "Which force always acts perpendicular to the surface of contact?", new String[] {"Friction", "Tension", "Normal Force", "Gravity"}, "Normal Force"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Kinetic friction is typically higher than static friction for the same surfaces.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The coefficient of friction depends primarily on:", new String[] {"The surface area", "The speed of motion", "The nature of the materials", "The weight"}, "The nature of the materials"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the net force on an object in terminal velocity?", new String[] {"9.8 N", "Equal to its weight", "0", "Dependent on height"}, "0"),

            // CIRCULAR MOTION & GRAVITY
            new Question(new MultipleChoiceQuestionStrategy(), "In which direction does centripetal force always point?", new String[] {"Tangential to path", "Away from center", "Toward the center", "Downwards"}, "Toward the center"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If the distance between two planets doubles, the gravitational force quadruples.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the distance between two masses doubles, the gravity between them drops by a factor of:", new String[] {"2", "4", "8", "16"}, "4"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If you go to the Moon, your mass remains the same.", "True"),

            // WORK, POWER & ENERGY
            new Question(new MultipleChoiceQuestionStrategy(), "How much work is done by a person holding a 50kg barbell perfectly still?", new String[] {"50 Joules", "9.8 Joules", "Zero", "2500 Joules"}, "Zero"),
            new Question(new MultipleChoiceQuestionStrategy(), "If you triple the speed of an object, its Kinetic Energy increases by a factor of:", new String[] {"3", "6", "9", "27"}, "9"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Total mechanical energy is conserved even when friction is present.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "If you push a wall with 100N of force but it doesn't move, the work done is:", new String[] {"100J", "10J", "Zero", "Dependent on time"}, "Zero"),
            new Question(new MultipleChoiceQuestionStrategy(), "Power is defined as the rate at which what is done?", new String[] {"Force", "Work", "Velocity", "Acceleration"}, "Work"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Gravitational potential energy depends on the choice of a reference level.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "A total of 100J of energy enters a machine. If 20J is lost to heat, the efficiency is:", new String[] {"20%", "50%", "80%", "100%"}, "80%"),

            // MOMENTUM & COLLISIONS
            new Question(new MultipleChoiceQuestionStrategy(), "In an inelastic collision, what happens to the objects?", new String[] {"They bounce away", "They stick together", "They explode", "They vanish"}, "Stick together"),
            new Question(new MultipleChoiceQuestionStrategy(), "Crumple zones in cars protect passengers by increasing:", new String[] {"Velocity", "Force", "Collision Time", "Mass"}, "Collision Time"),
            new Question(new MultipleChoiceQuestionStrategy(), "Impulse is equivalent to the change in an object's:", new String[] {"Velocity", "Mass", "Kinetic Energy", "Momentum"}, "Momentum"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In an elastic collision, both momentum and kinetic energy are conserved.", "True"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a closed system, total momentum is always conserved.", "True"),

            // ROTATION & TORQUE
            new Question(new MultipleChoiceQuestionStrategy(), "A figure skater pulls their arms in to spin faster. This effectively:", new String[] {"Increases Torque", "Decreases Mass", "Decreases Moment of Inertia", "Increases Friction"}, "Decreases Moment of Inertia"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The center of mass of an object must always be located within the physical material.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The center of mass of a uniform donut is located:", new String[] {"On the outer rim", "Inside the dough", "In the hole", "On the bottom"}, "In the hole"),
            new Question(new MultipleChoiceQuestionStrategy(), "To maximize torque on a wrench, you should apply force:", new String[] {"Near the bolt", "At the end of the handle", "Parallel to the handle", "At a 45 degree angle"}, "At the end of the handle"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An object can be in translational equilibrium but not rotational equilibrium.", "True"),

            // FLUIDS
            new Question(new MultipleChoiceQuestionStrategy(), "According to Bernoulli, as the speed of a moving fluid increases, its pressure:", new String[] {"Increases", "Decreases", "Stays the same", "Becomes zero"}, "Decreases"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An object floats if it is less dense than the fluid it is in.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Archimedes' Principle states the buoyant force equals the weight of the:", new String[] {"Object", "Fluid displaced", "Entire container", "Atmosphere"}, "Fluid displaced"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Pressure in a fluid increases with depth.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Hydraulic systems operate based on which principle?", new String[] {"Bernoulli's", "Newton's", "Pascal's", "Archimedes'"}, "Pascal's"),

            // WAVES & SOUND
            new Question(new MultipleChoiceQuestionStrategy(), "Which property of a wave determines the pitch of a sound?", new String[] {"Amplitude", "Velocity", "Frequency", "Phase"}, "Frequency"),
            new Question(new MultipleChoiceQuestionStrategy(), "What type of wave is a sound wave?", new String[] {"Transverse", "Longitudinal", "Electromagnetic", "Surface"}, "Longitudinal"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Sound waves can travel through a vacuum.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The time it takes for one complete cycle of motion is called the:", new String[] {"Frequency", "Amplitude", "Wavelength", "Period"}, "Period"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a transverse wave, the particles move parallel to the wave direction.", "False"),

            // THERMODYNAMICS
            new Question(new MultipleChoiceQuestionStrategy(), "Temperature is a measure of the molecules' average:", new String[] {"Potential Energy", "Kinetic Energy", "Mass", "Volume"}, "Kinetic Energy"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Second Law of Thermodynamics states that the entropy of the universe always increases.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which method of heat transfer involves the movement of fluids?", new String[] {"Conduction", "Radiation", "Convection", "Insulation"}, "Convection"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Absolute Zero is the temperature where molecular motion reaches its minimum.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The process of a gas turning directly into a solid is called:", new String[] {"Melting", "Sublimation", "Deposition", "Evaporation"}, "Deposition"),
            new Question(new WrittenQuestionStrategy(), "What is the standard unit of Force?", "Newton"),

            //Written
            new Question(new WrittenQuestionStrategy(), "Energy due to motion is called _____ energy.", "Kinetic"),
            new Question(new WrittenQuestionStrategy(), "Which of Newton's laws is also known as the Law of Inertia?", "First"),
            new Question(new WrittenQuestionStrategy(), "What is the numerical value of acceleration due to gravity on Earth (m/s^2)?", "9.8"),
            new Question(new WrittenQuestionStrategy(), "What is the product of mass and velocity?", "Momentum")
        });

        subjectData.put(Subject.CALCULUS_II, new Question[] {
            // --- CALCULUS II COMPLETE DATASET (50 QUESTIONS) ---

            // INTEGRATION TECHNIQUES (U-SUB, PARTS, TRIG)
            new Question(new TrueFalseQuestionStrategy(), "True or False: Integration by Parts is essentially the reverse of the Product Rule.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "When using Integration by Parts on 'x * sin(x)', which is the best choice for 'u'?", new String[] {"sin(x)", "x", "cos(x)", "1"}, "x"),
            new Question(new MultipleChoiceQuestionStrategy(), "The integral of 1/x dx is:", new String[] {"x^2/2", "ln|x|", "e^x", "-1/x^2"}, "ln|x|"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: U-substitution is the inverse process of the Chain Rule.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which technique is best for integrating (x^2 + 1) / (x - 1)(x + 2)?", new String[] {"Parts", "U-Sub", "Partial Fractions", "Trig Sub"}, "Partial Fractions"),
            new Question(new MultipleChoiceQuestionStrategy(), "To solve the integral of sqrt(a^2 - x^2), which trig substitution is used?", new String[] {"x = a*tan(t)", "x = a*sec(t)", "x = a*sin(t)", "x = a*cos(t)"}, "x = a*sin(t)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The integral of sec^2(x) is tan(x).", "True"),

            // IMPROPER INTEGRALS & APPLICATIONS
            new Question(new MultipleChoiceQuestionStrategy(), "An integral is 'improper' if:", new String[] {"It has a jump", "An interval limit is infinity", "It is negative", "The function is linear"}, "An interval limit is infinity"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If an improper integral equals a finite number, it is said to 'diverge'.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Disk Method for volume revolves a region around an axis. What is the cross-section shape?", new String[] {"Square", "Triangle", "Circle", "Trapezoid"}, "Circle"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which method is better when the rectangle of a region is parallel to the axis of revolution?", new String[] {"Disk Method", "Washer Method", "Shell Method", "Arc Length"}, "Shell Method"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Arc length can be found by integrating the square root of (1 + [f'(x)]^2).", "True"),

            // SEQUENCES & SERIES (THE DREADED CHAPTER)
            new Question(new MultipleChoiceQuestionStrategy(), "A geometric series converges if the absolute value of the ratio 'r' is:", new String[] {"Greater than 1", "Less than 1", "Equal to 0", "Negative"}, "Less than 1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If the limit of the terms of a series is NOT zero, the series must diverge.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The p-series 1/n^p converges if:", new String[] {"p < 1", "p = 1", "p > 1", "p is negative"}, "p > 1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Harmonic Series (1/n) converges.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which test is most effective for series involving factorials?", new String[] {"Integral Test", "Ratio Test", "Root Test", "P-series Test"}, "Ratio Test"),
            new Question(new MultipleChoiceQuestionStrategy(), "An alternating series converges if the terms decrease to:", new String[] {"Infinity", "One", "Zero", "The first term"}, "Zero"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Absolute convergence implies conditional convergence.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Taylor Series centered at x = 0 is specifically called a:", new String[] {"Power Series", "Fourier Series", "Maclaurin Series", "Newton Series"}, "Maclaurin Series"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A power series always converges at its center.", "True"),

            // POWER SERIES & ERROR
            new Question(new MultipleChoiceQuestionStrategy(), "What is the Maclaurin series for e^x?", new String[] {"Sum of x^n", "Sum of x^n / n!", "Sum of (-1)^n x^n", "Sum of 1/n"}, "Sum of x^n / n!"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Ratio Test results in '1' means the test is inconclusive.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The distance from the center to the edge of convergence for a power series is the:", new String[] {"Interval", "Diameter", "Radius of Convergence", "Midpoint"}, "Radius of Convergence"),

            // PARAMETRIC, POLAR & VECTORS
            new Question(new MultipleChoiceQuestionStrategy(), "In Polar coordinates, the equation r = 3 represents a:", new String[] {"Line", "Point", "Circle", "Spiral"}, "Circle"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The polar point (r, theta) is the same as (-r, theta + pi).", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "To convert Polar to Cartesian, x equals:", new String[] {"r * sin(theta)", "r * cos(theta)", "r / tan(theta)", "theta"}, "r * cos(theta)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Parametric equations allow a curve to fail the Vertical Line Test.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The area of a polar region is found using the integral of:", new String[] {"r^2", "1/2 * r^2", "2 * pi * r", "sqrt(r)"}, "1/2 * r^2"),

            // MISCELLANEOUS CONCEPTS
            new Question(new MultipleChoiceQuestionStrategy(), "What is the derivative of the integral from 'a' to 'x' of f(t) dt?", new String[] {"f(x)", "F(x)", "f'(x)", "0"}, "f(x)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Every continuous function has an antiderivative.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of these series is absolutely convergent?", new String[] {"1/n", "(-1)^n / n", "(-1)^n / n^2", "1/sqrt(n)"}, "(-1)^n / n^2"),
            new Question(new MultipleChoiceQuestionStrategy(), "In trig sub, if you see sqrt(x^2 - a^2), you use:", new String[] {"Sine", "Tangent", "Secant", "Cosine"}, "Secant"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The integral of an odd function over [-a, a] is always zero.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The limit of (sin x)/x as x approaches 0 is:", new String[] {"0", "Infinity", "1", "Undefined"}, "1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A sequence that is monotonic and bounded must converge.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The interval of convergence for a series is (-1, 1). Does it converge at x=2?", new String[] {"Yes", "No", "Maybe", "Only if alternating"}, "No"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which test compares a series to an easier known series?", new String[] {"Ratio Test", "Limit Comparison Test", "Divergence Test", "Integral Test"}, "Limit Comparison Test"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: L'Hopital's Rule can be used for the limit of a sequence.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the sum of the geometric series 1 + 1/2 + 1/4 + 1/8...?", new String[] {"1", "2", "1.5", "Infinity"}, "2"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Integration by parts can be used multiple times on one problem.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The integral of tan(x) dx is:", new String[] {"sec^2(x)", "ln|sec x|", "-ln|cos x|", "Both B and C"}, "Both B and C"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Alternating Harmonic Series converges.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The 'n-th term test' can prove:", new String[] {"Convergence", "Divergence", "Both", "Neither"}, "Divergence"),
            new Question(new MultipleChoiceQuestionStrategy(), "A series with all positive terms can:", new String[] {"Converge conditionally", "Converge absolutely", "Both", "Neither"}, "Converge absolutely"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Partial fraction decomposition requires the degree of the numerator to be less than the denominator.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The derivative of ln(u) is:", new String[] {"1/u", "u'/u", "e^u", "1"}, "u'/u"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which series represents the Alternating Harmonic series?", new String[] {"Sum 1/n", "Sum (-1)^n / n", "Sum (-1)^n / n!", "Sum 1/n^2"}, "Sum (-1)^n / n"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If the radius of convergence is infinity, the series converges for all real x.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The error in an alternating series is always less than the:", new String[] {"First term", "Last term", "Next term", "Total sum"}, "Next term"),
            
            //Written
            new Question(new WrittenQuestionStrategy(), "What is the integral of 1/x dx?", "ln|x|"),
            new Question(new WrittenQuestionStrategy(), "Integration by ____ is the reverse of the product rule.", "Parts"),
            new Question(new WrittenQuestionStrategy(), "A Taylor series centered at x = 0 is called a ____ series.", "Maclaurin"),
            new Question(new WrittenQuestionStrategy(), "Does the harmonic series (1/n) converge or diverge?", "Diverge"),
            new Question(new WrittenQuestionStrategy(), "What is the integral of e^x dx?", "e^x")
            });

        subjectData.put(Subject.PHYSICS_II, new Question[] {
            // --- PHYSICS II COMPLETE DATASET (50 QUESTIONS) ---

            // ELECTRIC CHARGE & FIELDS
            new Question(new TrueFalseQuestionStrategy(), "True or False: Electric field lines always point away from positive charges.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the distance between two charges triples, the electric force between them becomes:", new String[] {"1/3", "1/6", "1/9", "3 times stronger"}, "1/9"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the net electric charge inside a conductor in electrostatic equilibrium?", new String[] {"Positive", "Negative", "Zero", "Dependent on shape"}, "Zero"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Excess charge on a conductor resides entirely on its outer surface.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The unit of Electric Field strength is:", new String[] {"Volts", "Newtons per Coulomb", "Joules", "Amperes"}, "Newtons per Coulomb"),

            // ELECTRIC POTENTIAL & CAPACITANCE
            new Question(new MultipleChoiceQuestionStrategy(), "Electric potential (Voltage) is defined as electric potential energy per unit of:", new String[] {"Distance", "Time", "Charge", "Mass"}, "Charge"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Equipotential surfaces are always perpendicular to electric field lines.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Adding a dielectric material between the plates of a capacitor always:", new String[] {"Decreases capacitance", "Increases capacitance", "Discharges it", "Zeroes the voltage"}, "Increases capacitance"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Capacitors in parallel all share the same voltage.", "True"),

            // CURRENT & DC CIRCUITS
            new Question(new MultipleChoiceQuestionStrategy(), "According to Ohm's Law, if resistance increases while voltage is constant, current:", new String[] {"Increases", "Decreases", "Stays the same", "Doubles"}, "Decreases"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a series circuit, the current is the same through every resistor.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of Kirchhoff's laws is a statement of Conservation of Charge?", new String[] {"Loop Rule", "Junction Rule", "Ohm's Law", "Faraday's Law"}, "Junction Rule"),
            new Question(new MultipleChoiceQuestionStrategy(), "What device is used to measure the electric current in a circuit?", new String[] {"Voltmeter", "Ohmmeter", "Ammeter", "Galvanometer"}, "Ammeter"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A voltmeter should be connected in parallel with the component being measured.", "True"),

            // MAGNETISM & ELECTROMAGNETISM
            new Question(new MultipleChoiceQuestionStrategy(), "Magnetic field lines always form closed loops from:", new String[] {"North to South", "South to North", "Positive to Negative", "Inward to Outward"}, "North to South"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A stationary electric charge creates a magnetic field.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The force on a moving charge in a magnetic field is zero if the velocity is:", new String[] {"Perpendicular to the field", "Parallel to the field", "Circular", "Very fast"}, "Parallel to the field"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Magnetic monopoles (a single North or South pole) have never been observed.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which principle states that an induced current opposes the change that created it?", new String[] {"Ampere's Law", "Lenz's Law", "Gauss's Law", "Ohm's Law"}, "Lenz's Law"),

            // ELECTROMAGNETIC WAVES & LIGHT
            new Question(new MultipleChoiceQuestionStrategy(), "Electromagnetic waves consist of oscillating electric and magnetic fields that are:", new String[] {"Parallel", "Perpendicular", "Circular", "Random"}, "Perpendicular"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: All electromagnetic waves travel at the speed of light in a vacuum.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which part of the EM spectrum has the highest frequency?", new String[] {"Radio waves", "Visible light", "Gamma rays", "Infrared"}, "Gamma rays"),
            new Question(new MultipleChoiceQuestionStrategy(), "The bending of light as it passes from one medium to another is called:", new String[] {"Reflection", "Refraction", "Diffraction", "Polarization"}, "Refraction"),

            // OPTICS (MIRRORS & LENSES)
            new Question(new TrueFalseQuestionStrategy(), "True or False: A convex mirror always produces a virtual, upright, and smaller image.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "When light reflects off a surface, the angle of incidence is always:", new String[] {"Greater than reflection", "Smaller than reflection", "Equal to reflection", "90 degrees"}, "Equal to reflection"),
            new Question(new MultipleChoiceQuestionStrategy(), "A 'converging' lens is also known as a:", new String[] {"Concave lens", "Convex lens", "Planar lens", "Diverging lens"}, "Convex lens"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Total Internal Reflection can only occur when moving from a denser to a less dense medium.", "True"),

            // INTERFERENCE & DIFFRACTION
            new Question(new MultipleChoiceQuestionStrategy(), "Young's Double Slit experiment provided evidence that light is a:", new String[] {"Particle", "Wave", "Fluid", "Solid"}, "Wave"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Blue light has a shorter wavelength than red light.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The spreading of waves as they pass through an opening is called:", new String[] {"Refraction", "Dispersion", "Diffraction", "Reflection"}, "Diffraction"),

            // MODERN PHYSICS & QUANTUM
            new Question(new MultipleChoiceQuestionStrategy(), "The Photoelectric Effect demonstrates that light can behave as a:", new String[] {"Wave", "Particle (Photon)", "Magnetic field", "Sound wave"}, "Particle (Photon)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: According to Special Relativity, the speed of light is constant for all observers.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the primary evidence for the expanding universe?", new String[] {"Blue shift", "Red shift", "Gravity waves", "Static electricity"}, "Red shift"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Atoms consist mostly of empty space.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which particle is responsible for the identity of a chemical element?", new String[] {"Electron", "Neutron", "Proton", "Photon"}, "Proton"),

            // THERMAL & SEMICONDUCTORS (ADDITIONAL)
            new Question(new MultipleChoiceQuestionStrategy(), "Materials that have no electrical resistance at very low temperatures are:", new String[] {"Insulators", "Semiconductors", "Superconductors", "Ohmic conductors"}, "Superconductors"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: N-type semiconductors have an excess of positive 'holes'.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "A P-N junction that emits light when current flows through it is a:", new String[] {"Transistor", "Resistor", "LED", "Capacitor"}, "LED"),

            // FINAL ROUND CONCEPTS
            new Question(new MultipleChoiceQuestionStrategy(), "The 'Work Function' in the photoelectric effect is the minimum energy to:", new String[] {"Stop a photon", "Eject an electron", "Create a magnetic field", "Heat a metal"}, "Eject an electron"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Gamma radiation is the most penetrating type of nuclear radiation.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What happens to the wavelength of light as it enters a medium with a higher refractive index?", new String[] {"Increases", "Decreases", "Stays the same", "Becomes infinite"}, "Decreases"),
            new Question(new MultipleChoiceQuestionStrategy(), "The process by which a nucleus splits into smaller parts is called:", new String[] {"Fusion", "Fission", "Ionization", "Excitation"}, "Fission"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Time dilation means time moves slower for an object moving at high speeds.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which force is responsible for holding the nucleus together?", new String[] {"Gravity", "Electromagnetic", "Strong Nuclear Force", "Weak Nuclear Force"}, "Strong Nuclear Force"),
            new Question(new MultipleChoiceQuestionStrategy(), "What does an step-up transformer increase?", new String[] {"Current", "Power", "Voltage", "Resistance"}, "Voltage"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In an AC circuit, the current periodically reverses direction.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If you cut a bar magnet in half, you get:", new String[] {"One North and one South magnet", "Two smaller magnets each with N and S", "Two non-magnetic bars", "Two North poles"}, "Two smaller magnets each with N and S"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Dispersion is what causes a prism to separate white light into colors.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which constant relates the energy of a photon to its frequency?", new String[] {"Boltzmann", "Planck", "Coulomb", "Newton"}, "Planck"),
            new Question(new MultipleChoiceQuestionStrategy(), "A region where no electric or magnetic fields can enter due to a conductive shell is a:", new String[] {"Black hole", "Faraday cage", "Vacuum", "Insulator"}, "Faraday cage"),

            //Written
            new Question(new WrittenQuestionStrategy(), "What is the unit of electrical resistance?", "Ohm"),
            new Question(new WrittenQuestionStrategy(), "What type of mirror always forms a virtual, upright, and smaller image?", "Convex"),
            new Question(new WrittenQuestionStrategy(), "In a ____ circuit, the current is the same through all components.", "Series"),
            new Question(new WrittenQuestionStrategy(), "What particles are found in the nucleus of an atom besides neutrons?", "Protons"),
            new Question(new WrittenQuestionStrategy(), "The bending of light as it passes between mediums is called ____.", "Refraction")
        });

        subjectData.put(Subject.COMP_PROG, new Question[] {
            // --- COMPUTER PROGRAMMING ---

            // --- BASICS & SYNTAX ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which of the following is the correct way to start a function in Python?", new String[] {"function myFunc():", "def myFunc():", "void myFunc():", "func myFunc():"}, "def myFunc():"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python uses indentation to define code blocks instead of curly braces.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "How do you create a variable with the numeric value 5 in Python?", new String[] {"x = int(5)", "x = 5", "Both A and B", "num x = 5"}, "Both A and B"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which data type is used for a sequence of characters in Python?", new String[] {"char", "String", "str", "text"}, "str"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In Python, '3' + '3' results in '33'.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the correct syntax to output 'Hello World' in Python?", new String[] {"p('Hello World')", "echo 'Hello World'", "print('Hello World')", "printf('Hello World')"}, "print('Hello World')"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python is an interpreted language.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which operator is used for 'Floor Division' in Python?", new String[] {"/", "//", "%", "div"}, "//"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the correct way to write a single-line comment in Python?", new String[] {"// comment", "/* comment */", "# comment", "-- comment"}, "# comment"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python variable names are case-sensitive.", "True"),

            // --- DATA TYPES & COLLECTIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which collection is ordered, changeable, and allows duplicate members?", new String[] {"List", "Tuple", "Set", "Dictionary"}, "List"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A Python tuple can be changed after it is created.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which collection in Python stores key-value pairs?", new String[] {"List", "Set", "Dictionary", "Tuple"}, "Dictionary"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which method is used to add an element to the end of a list?", new String[] {"add()", "insert()", "append()", "push()"}, "append()"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A Set in Python is unordered and does not allow duplicate items.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the result of len(['apple', 'banana', 'cherry'])?", new String[] {"1", "2", "3", "18"}, "3"),
            new Question(new MultipleChoiceQuestionStrategy(), "How do you start a multi-line string in Python?", new String[] {"///", "\"\"\"", "###", "&&&"}, "\"\"\""),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The bool() function returns False for an empty list [].", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which operator is used to check if a value exists within a list?", new String[] {"exists", "in", "has", "contains"}, "in"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the value of 10 % 3 in Python?", new String[] {"3", "1", "0", "3.33"}, "1"),

            // --- LOGIC & LOOPS ---
            new Question(new MultipleChoiceQuestionStrategy(), "To exit a loop prematurely in Python, you use the keyword:", new String[] {"exit", "stop", "break", "return"}, "break"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A 'while' loop will execute at least once even if the condition is False.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to skip the current iteration of a loop?", new String[] {"skip", "pass", "continue", "next"}, "continue"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the output of: print(2 ** 3)?", new String[] {"5", "6", "8", "9"}, "8"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python supports 'switch' statements natively (before version 3.10).", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which logical operator represents 'AND' in Python?", new String[] {"&&", "and", "&", "amp"}, "and"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The 'range(5)' function generates numbers from 0 to 5 (inclusive).", "False"),

            // --- FUNCTIONS & SCOPE ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to return a value from a function?", new String[] {"get", "give", "return", "output"}, "return"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A function in Python can return multiple values separated by commas.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What keyword allows you to modify a variable outside the current function scope?", new String[] {"outer", "global", "extern", "this"}, "global"),
            new Question(new MultipleChoiceQuestionStrategy(), "An 'anonymous' function in Python is created using which keyword?", new String[] {"anon", "def", "lambda", "inline"}, "lambda"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python functions must always have a return statement.", "False"),

            // --- ERRORS & EXCEPTIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "In Python, which keyword is used to handle potential errors?", new String[] {"catch", "except", "error", "handle"}, "except"),
            new Question(new MultipleChoiceQuestionStrategy(), "The block of code that runs regardless of whether an exception occurred is:", new String[] {"finally", "always", "else", "end"}, "finally"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: You can raise your own exceptions using the 'raise' keyword.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which error occurs if you try to divide by zero?", new String[] {"MathError", "ZeroDivisionError", "NullError", "ValueError"}, "ZeroDivisionError"),

            // --- OBJECT ORIENTED PROGRAMMING (OOP) ---
            new Question(new MultipleChoiceQuestionStrategy(), "What is the name of the special method used to initialize a Python class?", new String[] {"__start__", "__init__", "__class__", "__new__"}, "__init__"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python supports multiple inheritance.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The 'self' parameter in a class method refers to:", new String[] {"The class itself", "The parent class", "The specific instance of the class", "The global scope"}, "The specific instance of the class"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: You can create a class without any methods in Python.", "True"),

            // --- MISCELLANEOUS & BUILT-INS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which function is used to convert a string to an integer?", new String[] {"str()", "float()", "int()", "num()"}, "int()"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Strings in Python are immutable.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "How do you open a file for 'reading' in Python?", new String[] {"open('file.txt', 'w')", "open('file.txt', 'r')", "open('file.txt', 'a')", "open('file.txt', 'x')"}, "open('file.txt', 'r')"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the default value returned by a function that doesn't have a return statement?", new String[] {"0", "False", "None", "Null"}, "None"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python 3 and Python 2 are fully compatible with each other.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which module is used for generating random numbers in Python?", new String[] {"math", "rand", "random", "seed"}, "random"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: List comprehensions are a concise way to create lists.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the output of print(type(10))?", new String[] {"<class 'num'>", "<class 'float'>", "<class 'int'>", "<class 'str'>"}, "<class 'int'>"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to import a library in Python?", new String[] {"using", "include", "import", "require"}, "import"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: PEP 8 is the official style guide for Python code.", "True"),

            //Written
            new Question(new WrittenQuestionStrategy(), "Which keyword is used to define a function in Python?", "def"),
            new Question(new WrittenQuestionStrategy(), "What data type is used to store key-value pairs?", "dict"),
            new Question(new WrittenQuestionStrategy(), "What function is used to get the length of a list?", "len()"),
            new Question(new WrittenQuestionStrategy(), "Is a Python Tuple mutable or immutable?", "Immutable"),
            new Question(new WrittenQuestionStrategy(), "Which keyword is used to skip to the next iteration of a loop?", "continue")
        });

        subjectData.put(Subject.ADV_COMP_PROG, new Question[] {
            // --- ADVANCED COMPUTER PROGRAMMING ---

            // --- OBJECT-ORIENTED PRINCIPLES ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which concept allows a subclass to provide a specific implementation of a method already defined in its superclass?", new String[] {"Overloading", "Overriding", "Encapsulation", "Abstraction"}, "Overriding"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A constructor can be inherited by a subclass.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the primary purpose of an 'Interface' in Java?", new String[] {"To store data", "To define a contract of behavior", "To prevent inheritance", "To speed up execution"}, "To define a contract of behavior"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which access modifier makes a member visible only within its own class?", new String[] {"public", "protected", "default", "private"}, "private"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An abstract class can be instantiated using the 'new' keyword.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is 'Polymorphism' in Java?", new String[] {"Hiding data", "A class with many constructors", "One interface, multiple implementations", "Copying objects"}, "One interface, multiple implementations"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Java supports multiple inheritance through classes.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to call the constructor of the parent class?", new String[] {"this", "parent", "super", "base"}, "super"),

            // --- MEMORY & KEYWORDS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Where are objects stored in Java memory?", new String[] {"Stack", "Heap", "Register", "Cache"}, "Heap"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The 'final' keyword on a class prevents it from being subclassed.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What does the 'static' keyword imply about a variable?", new String[] {"It changes constantly", "It belongs to the class, not an instance", "It is thread-safe", "It cannot be modified"}, "It belongs to the class, not an instance"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Primitive types (like int) are stored on the Stack.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The process of the JVM automatically reclaiming unused memory is called:", new String[] {"Memory Swapping", "Defragmentation", "Garbage Collection", "Caching"}, "Garbage Collection"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the result of using '==' to compare two String objects?", new String[] {"Compares their content", "Compares their memory addresses", "Throws an error", "Returns the length"}, "Compares their memory addresses"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Java is strictly 'Pass-by-Value'.", "True"),

            // --- EXCEPTIONS & ERRORS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which block is used to enclose code that might throw an exception?", new String[] {"catch", "finally", "try", "throw"}, "try"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The 'finally' block executes even if no exception is caught.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of these is a 'Checked' exception?", new String[] {"NullPointerException", "ArithmeticException", "IOException", "ArrayIndexOutOfBoundsException"}, "IOException"),
            new Question(new MultipleChoiceQuestionStrategy(), "What keyword is used in a method signature to declare that it might throw an exception?", new String[] {"throw", "throws", "catch", "assert"}, "throws"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: 'Error' and 'Exception' are both subclasses of 'Throwable'.", "True"),

            // --- STRATEGY & DESIGN ---
            new Question(new MultipleChoiceQuestionStrategy(), "The Singleton pattern ensures that:", new String[] {"A class has only one instance", "A class is thread-safe", "Methods are static", "Memory is cleared"}, "A class has only one instance"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Strategy Pattern involves defining a family of algorithms and making them interchangeable.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword prevents a variable from being serialized?", new String[] {"volatile", "transient", "synchronized", "native"}, "transient"),
            new Question(new MultipleChoiceQuestionStrategy(), "The 'synchronized' keyword is used to achieve:", new String[] {"Polymorphism", "Thread Safety", "Faster loops", "Data Compression"}, "Thread Safety"),

            // --- WRAPPING UP THE CONCEPTS ---
            new Question(new TrueFalseQuestionStrategy(), "True or False: Java Strings are immutable.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which method must you override to ensure objects work correctly in a HashMap?", new String[] {"toString()", "equals() and hashCode()", "clone()", "finalize()"}, "equals() and hashCode()"),
            new Question(new MultipleChoiceQuestionStrategy(), "The 'diamond operator' (<>) was introduced to:", new String[] {"Make code look pretty", "Type inference for generics", "Support bitwise math", "Mark private classes"}, "Type inference for generics"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A 'static' method can access non-static instance variables directly.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the base class of all classes in Java?", new String[] {"Main", "Base", "Object", "System"}, "Object"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An Inner Class can access private members of the Outer Class.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which stream method is used to transform elements in Java Streams?", new String[] {"filter()", "map()", "collect()", "reduce()"}, "map()"),
            new Question(new MultipleChoiceQuestionStrategy(), "The 'volatile' keyword ensures that a variable is always read from:", new String[] {"The CPU cache", "Main memory", "The hard drive", "The stack"}, "Main memory"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: 'super()' must be the first statement in a constructor.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of these is NOT a wrapper class?", new String[] {"Integer", "Boolean", "Double", "string"}, "string"),
            new Question(new MultipleChoiceQuestionStrategy(), "What happens if a thread calls 'wait()'?", new String[] {"It stops forever", "It releases the lock and waits", "It busy-waits", "It crashes"}, "It releases the lock and waits"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Java Reflection allows you to inspect classes at runtime.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the default value of a boolean instance variable?", new String[] {"true", "false", "null", "0"}, "false"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to implement an interface?", new String[] {"extends", "implements", "uses", "requires"}, "implements"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The '@Override' annotation is mandatory for the code to compile.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "What does the 'break' statement do in a switch-case?", new String[] {"Restarts the program", "Exits the switch block", "Skips the next case", "Throws an error"}, "Exits the switch block"),

            //Written
            new Question(new WrittenQuestionStrategy(), "What keyword is used to inherit a class in Java?", "extends"),
            new Question(new WrittenQuestionStrategy(), "What is the root class of all classes in Java?", "Object"),
            new Question(new WrittenQuestionStrategy(), "Which keyword is used to create a constant variable?", "final"),
            new Question(new WrittenQuestionStrategy(), "What is the default value of a boolean instance variable?", "false"),
            new Question(new WrittenQuestionStrategy(), "Which access modifier allows access only within the same class?", "private")
        });

        subjectData.put(Subject.PROB_STAT_DATA, new Question[] {
            // --- PROBABILITY AND STATISTICS COMPLETE DATASET (50 QUESTIONS) ---

            // --- CENTRAL TENDENCY & DISPERSION ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which measure of central tendency is most affected by extreme outliers?", new String[] {"Median", "Mean", "Mode", "Range"}, "Mean"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The sum of the deviations of all data points from the mean is always zero.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which value represents the 'middle' of a sorted data set?", new String[] {"Mean", "Mode", "Median", "Standard Deviation"}, "Median"),
            new Question(new MultipleChoiceQuestionStrategy(), "Standard deviation is the square root of what?", new String[] {"Mean", "Variance", "Range", "Expected Value"}, "Variance"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If the variance of a data set is 0, all data points are identical.", "True"),

            // --- PROBABILITY BASICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The probability of an event that is certain to occur is:", new String[] {"0", "0.5", "1", "100"}, "1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Two events are mutually exclusive if they cannot happen at the same time.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If you flip a fair coin twice, what is the probability of getting two heads?", new String[] {"0.5", "0.25", "0.75", "1"}, "0.25"),
            new Question(new MultipleChoiceQuestionStrategy(), "What rule is used to find the probability of Event A OR Event B occurring?", new String[] {"Multiplication Rule", "Addition Rule", "Bayes' Theorem", "Power Rule"}, "Addition Rule"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The probability of an event and its complement always sum to 1.", "True"),

            // --- DISTRIBUTIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "In a perfectly Normal Distribution, which of the following is true?", new String[] {"Mean > Median", "Mean < Mode", "Mean = Median = Mode", "Standard Deviation = 0"}, "Mean = Median = Mode"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a skewed-right distribution, the tail is on the right side.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The '68-95-99.7 Rule' applies to which type of distribution?", new String[] {"Binomial", "Poisson", "Normal", "Uniform"}, "Normal"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the total area under a probability density function curve?", new String[] {"0.5", "1", "Depends on data", "100"}, "1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A Z-score tells you how many standard deviations a value is from the mean.", "True"),

            // --- SAMPLING & ESTIMATION ---
            new Question(new MultipleChoiceQuestionStrategy(), "The Central Limit Theorem states that as sample size increases, the sampling distribution of the mean becomes:", new String[] {"Skewed", "Normal", "Uniform", "Bimodal"}, "Normal"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A larger sample size generally leads to a smaller margin of error.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which type of bias occurs when some members of a population are less likely to be chosen?", new String[] {"Response Bias", "Undercoverage Bias", "Non-response Bias", "Measurement Bias"}, "Undercoverage Bias"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A parameter describes a population, while a statistic describes a sample.", "True"),

            // --- HYPOTHESIS TESTING ---
            new Question(new MultipleChoiceQuestionStrategy(), "The probability of rejecting the Null Hypothesis when it is actually true is called:", new String[] {"Type I Error", "Type II Error", "Power", "Confidence Level"}, "Type I Error"),
            new Question(new MultipleChoiceQuestionStrategy(), "In hypothesis testing, we reject the Null Hypothesis if the P-value is:", new String[] {"Less than alpha", "Greater than alpha", "Equal to 1", "Negative"}, "Less than alpha"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Null Hypothesis usually represents 'no effect' or 'no difference'.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which error occurs when we fail to reject a false Null Hypothesis?", new String[] {"Type I Error", "Type II Error", "Standard Error", "Margin of Error"}, "Type II Error"),

            // --- CORRELATION & REGRESSION ---
            new Question(new MultipleChoiceQuestionStrategy(), "A correlation coefficient (r) of -1 indicates:", new String[] {"No relationship", "Weak positive relationship", "Perfect negative relationship", "Perfect positive relationship"}, "Perfect negative relationship"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Correlation implies causation.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "In a linear regression equation (y = mx + b), what does 'm' represent?", new String[] {"Y-intercept", "Slope", "Correlation", "Residual"}, "Slope"),
            new Question(new MultipleChoiceQuestionStrategy(), "The difference between an observed value and the value predicted by a regression model is the:", new String[] {"Outlier", "Residual", "Variance", "Standard Error"}, "Residual"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: R-squared (coefficient of determination) measures how well the model fits the data.", "True"),

            // --- ADVANCED CONCEPTS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which distribution is best for modeling the number of events occurring in a fixed interval of time?", new String[] {"Normal", "Binomial", "Poisson", "Exponential"}, "Poisson"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which theorem relates current probability to prior knowledge or conditions?", new String[] {"Chebyshev's Theorem", "Bayes' Theorem", "Binomial Theorem", "Law of Large Numbers"}, "Bayes' Theorem"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Discrete variables can only take on a countable number of values.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "A 'Double-Blind' study is used primarily to reduce:", new String[] {"Calculation errors", "Experimenter and participant bias", "Sample size", "Variance"}, "Experimenter and participant bias"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The median is a more robust statistic than the mean.", "True"),

            // --- RANDOM WRAP-UP ---
            new Question(new MultipleChoiceQuestionStrategy(), "What is the probability of an event that is impossible?", new String[] {"0", "0.01", "-1", "Null"}, "0"),
            new Question(new MultipleChoiceQuestionStrategy(), "The set of all possible outcomes of an experiment is called the:", new String[] {"Population", "Sample Space", "Event Set", "Data Range"}, "Sample Space"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Quantitative data can be either discrete or continuous.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which plot is best for showing the distribution of a single quantitative variable?", new String[] {"Scatterplot", "Pie Chart", "Histogram", "Bar Chart"}, "Histogram"),
            new Question(new MultipleChoiceQuestionStrategy(), "If A and B are independent, P(A and B) equals:", new String[] {"P(A) + P(B)", "P(A) / P(B)", "P(A) * P(B)", "P(A|B)"}, "P(A) * P(B)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A boxplot displays the 5-number summary of a data set.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the Z-score of the mean in any normal distribution?", new String[] {"1", "0", "-1", "95"}, "0"),
            new Question(new MultipleChoiceQuestionStrategy(), "A coin is flipped 10 times and shows heads every time. The probability the next flip is heads is:", new String[] {"Higher than 0.5", "Lower than 0.5", "Exactly 0.5", "1.0"}, "Exactly 0.5"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Sensitivity and Specificity are measures of a test's performance.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which distribution describes the number of successes in a fixed number of independent trials?", new String[] {"Normal", "Binomial", "Geometric", "Uniform"}, "Binomial"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The law of large numbers says averages settle down as trials increase.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the term for a value that is significantly far from the rest of the data?", new String[] {"Mean", "Standard Deviation", "Outlier", "Mode"}, "Outlier"),
            new Question(new MultipleChoiceQuestionStrategy(), "A 95% confidence interval means:", new String[] {"The mean is 95", "95% of data is in the interval", "We are 95% confident the interval contains the parameter", "There is a 5% chance the mean is 0"}, "We are 95% confident the interval contains the parameter"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Ordinal data is a type of qualitative data with a specific order.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The IQR (Interquartile Range) is calculated as:", new String[] {"Q3 - Q1", "Q4 - Q0", "Mean - Median", "Max - Min"}, "Q3 - Q1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Nominal data has a natural order.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of these is NOT a measure of spread?", new String[] {"Variance", "Range", "Mode", "Standard Deviation"}, "Mode"),

            //Written
            new Question(new WrittenQuestionStrategy(), "What is the square root of Variance?", "Standard Deviation"),
            new Question(new WrittenQuestionStrategy(), "What is the most frequent value in a data set called?", "Mode"),
            new Question(new WrittenQuestionStrategy(), "A correlation of -1 indicates a perfect ____ relationship.", "Negative"),
            new Question(new WrittenQuestionStrategy(), "The probability of an impossible event is ____.", "0"),
            new Question(new WrittenQuestionStrategy(), "A bell-shaped curve represents a ____ distribution.", "Normal")
        });
    }

    public static QuestionBank getInstance() {
        return instance;
    }

    public Question[] getQuestionsBySubject(Subject subject) {
        return subjectData.getOrDefault(subject, new Question[0]);
    }

    public Question getRandomQuestion(Subject subject) {
        Question[] questions = getQuestionsBySubject(subject);
        if (questions.length == 0) return null;
        return questions[(int) (Math.random() * questions.length)];
    }
    
    public void resetSubjectDeck(Subject subject) {
        Question[] original = subjectData.get(subject);
        if (original != null) {
            List<Question> shuffledList = new ArrayList<>(Arrays.asList(original));
            Collections.shuffle(shuffledList); // Randomize the order
            remainingQuestions.put(subject, shuffledList);
        }
    }

    // UPDATED: Get a question without repeats
    public Question getUniqueQuestion(Subject subject) {
        // If the deck doesn't exist or is empty, refill and shuffle it
        if (!remainingQuestions.containsKey(subject) || remainingQuestions.get(subject).isEmpty()) {
            resetSubjectDeck(subject);
        }

        // Pull the top question off the "deck"
        List<Question> deck = remainingQuestions.get(subject);
        return deck.remove(0); // Removes and returns the first question
    }
}