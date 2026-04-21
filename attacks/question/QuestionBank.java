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
            // --- 1. LIMITS & CONTINUITY ---
            new Question(new MultipleChoiceQuestionStrategy(), "If the left-hand limit and right-hand limit at x=c exist but are not equal, what exists at c?", new String[] {"A jump discontinuity", "A removable discontinuity", "An infinite discontinuity", "A vertical asymptote"}, "A jump discontinuity"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If a function is continuous at x=c, it must be differentiable at x=c.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the limit of f(x) as x approaches c is L, what must be true about f(c)?", new String[] {"f(c) = L", "f(c) must exist", "f(c) is undefined", "Nothing necessarily"}, "Nothing necessarily"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which theorem guarantees a continuous function takes on every value between f(a) and f(b)?", new String[] {"Mean Value Theorem", "Intermediate Value Theorem", "Rolle's Theorem", "Extreme Value Theorem"}, "Intermediate Value Theorem"),
            
            // --- 2. DERIVATIVES ---
            new Question(new MultipleChoiceQuestionStrategy(), "The derivative of a function at a point represents the:", new String[] {"Area under the curve", "Slope of the tangent line", "Y-intercept", "Length of the curve"}, "Slope of the tangent line"),
            new Question(new MultipleChoiceQuestionStrategy(), "The limit definition of a derivative uses the slope of a _____ line to find the slope of a _____ line.", new String[] {"Tangent, Secant", "Secant, Tangent", "Horizontal, Vertical", "Normal, Tangent"}, "Secant, Tangent"),
            new Question(new MultipleChoiceQuestionStrategy(), "What rule is used to find the derivative of a composite function f(g(x))?", new String[] {"Power Rule", "Product Rule", "Quotient Rule", "Chain Rule"}, "Chain Rule"),
            new Question(new MultipleChoiceQuestionStrategy(), "The differential dy of a function y = f(x) is defined as:", new String[] {"f'(x) dx", "f(x) dx", "f'(x) / dx", "f(x+dx) - f(x)"}, "f'(x) dx"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The derivative of a sum is the sum of the derivatives.", "True"),

            // --- 3. INTEGRATIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The Fundamental Theorem of Calculus relates which two concepts?", new String[] {"Limits and Derivatives", "Differentiation and Integration", "Slope and Concavity", "Area and Volume"}, "Differentiation and Integration"),
            new Question(new MultipleChoiceQuestionStrategy(), "A Riemann sum with an infinite number of subintervals evaluates to:", new String[] {"A derivative", "A limit of a sequence", "A definite integral", "A tangent line"}, "A definite integral"),
            new Question(new MultipleChoiceQuestionStrategy(), "The '+ C' in an indefinite integral represents:", new String[] {"A specific constant", "An arbitrary constant of integration", "The limit of integration", "The derivative"}, "An arbitrary constant of integration"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The definite integral of a function can represent a negative value.", "True"),

            // --- 4. TRANSCENDENTAL FUNCTIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "What is the derivative of the natural logarithmic function, ln(x)?", new String[] {"1/x", "e^x", "x", "ln(x)"}, "1/x"),
            new Question(new MultipleChoiceQuestionStrategy(), "The antiderivative of the exponential function e^x is:", new String[] {"e^x + C", "x*e^(x-1) + C", "ln(x) + C", "e^(x+1)/(x+1) + C"}, "e^x + C"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The derivative of sin(x) is cos(x), and the derivative of cos(x) is sin(x).", "False"),

            // --- 5. APPLICATIONS OF DIFFERENTIATION ---
            new Question(new MultipleChoiceQuestionStrategy(), "Where can the absolute extremum of a continuous function on a closed interval occur?", new String[] {"Only at critical points", "Only at endpoints", "Critical points or endpoints", "Only where f'(x)=0"}, "Critical points or endpoints"),
            new Question(new MultipleChoiceQuestionStrategy(), "If f''(x) changes sign at x=c, then the point (c, f(c)) on the curve is:", new String[] {"A critical point", "A cusp", "An inflection point", "A local maximum"}, "An inflection point"),
            new Question(new MultipleChoiceQuestionStrategy(), "A limit of the indeterminate form 0/0 or ∞/∞ can often be evaluated using:", new String[] {"The Chain Rule", "L'Hôpital's Rule", "Integration by parts", "Partial fractions"}, "L'Hôpital's Rule"),
            new Question(new MultipleChoiceQuestionStrategy(), "Related rates problems are typically solved using which differentiation technique?", new String[] {"Integration by parts", "Implicit differentiation", "Logarithmic differentiation", "Partial fractions"}, "Implicit differentiation"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If f'(x) > 0 for all x in an interval, the function is decreasing on that interval.", "False"),

            // --- 6. TECHNIQUES OF INTEGRATION ---
            new Question(new MultipleChoiceQuestionStrategy(), "The integration by parts formula is mathematically derived from which differentiation rule?", new String[] {"The Chain Rule", "The Product Rule", "The Quotient Rule", "The Power Rule"}, "The Product Rule"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which technique is best suited for integrating a rational function where the denominator can be factored?", new String[] {"Trigonometric substitution", "Integration by parts", "Partial fractions", "L'Hôpital's rule"}, "Partial fractions"),
            new Question(new MultipleChoiceQuestionStrategy(), "To evaluate the integral of √(a^2 - x^2), which trigonometric substitution is generally used?", new String[] {"x = a tan(θ)", "x = a sec(θ)", "x = a sin(θ)", "x = a cos(θ)"}, "x = a sin(θ)"),
            
            // --- 7. APPLICATIONS OF THE INTEGRATIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "When calculating the volume of a solid of revolution using the cylindrical shells method, the representative rectangle is taken:", new String[] {"Parallel to the axis of revolution", "Perpendicular to the axis of revolution", "Tangent to the curve", "Diagonal to the axis"}, "Parallel to the axis of revolution"),
            new Question(new MultipleChoiceQuestionStrategy(), "When using the disk/washer method for a solid rotated around the x-axis, you integrate with respect to:", new String[] {"x", "y", "The radius", "The circumference"}, "x"),
            
            // --- 8. IMPROPER INTEGRALS ---
            new Question(new MultipleChoiceQuestionStrategy(), "An improper integral of Type I is characterized by having:", new String[] {"An infinite limit of integration", "An infinite discontinuity in the integrand", "A bounded continuous domain", "Complex roots"}, "An infinite limit of integration"),
            new Question(new MultipleChoiceQuestionStrategy(), "If an improper integral evaluates to a finite real number, the integral is said to:", new String[] {"Diverge", "Converge", "Oscillate", "Asymptote"}, "Converge"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An improper integral of Type II contains an infinite discontinuity (vertical asymptote) within its interval of integration.", "True"),

            // --- WRITTEN CONCEPTS ---
            new Question(new WrittenQuestionStrategy(), "What is the derivative of sin(x)?", "cos(x)"),
            new Question(new WrittenQuestionStrategy(), "What is the limit of 1/x as x approaches infinity?", "0"),
            new Question(new WrittenQuestionStrategy(), "What is the derivative of any constant value?", "0"),
            new Question(new WrittenQuestionStrategy(), "If f'(x) is positive on an interval, is the function increasing or decreasing?", "Increasing"),
            new Question(new WrittenQuestionStrategy(), "What rule is used to find the limit of an indeterminate form like 0/0?", "L'Hopital's Rule")
        });

        subjectData.put(Subject.PHYSICS_I, new Question[] {
            // --- 1. DIMENSIONAL ANALYSIS & 1D MOTION ---
            new Question(new MultipleChoiceQuestionStrategy(), "What are the base SI dimensions for Force?", new String[] {"kg * m/s", "kg * m^2/s^2", "kg * m/s^2", "kg / (m*s)"}, "kg * m/s^2"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An object can have a velocity of zero while still having a non-zero acceleration.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What does the area under a Velocity vs. Time graph represent?", new String[] {"Position", "Acceleration", "Force", "Displacement"}, "Displacement"),
            new Question(new MultipleChoiceQuestionStrategy(), "In one-dimensional kinematics, if a car is moving in the negative x-direction and braking, its acceleration is:", new String[] {"Positive", "Negative", "Zero", "Undefined"}, "Positive"),

            // --- 2. VECTORS & 2D/3D MOTION ---
            new Question(new MultipleChoiceQuestionStrategy(), "The dot product of two mutually perpendicular vectors is always:", new String[] {"1", "-1", "0", "Equal to their cross product"}, "0"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The horizontal and vertical components of a projectile's motion are completely independent of each other.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "At the peak of a projectile's flight (ignoring air resistance), its vertical velocity is:", new String[] {"9.8 m/s", "0 m/s", "Equal to its initial vertical velocity", "Undefined"}, "0 m/s"),

            // --- 3. NEWTON'S LAWS & CIRCULAR MOTION ---
            new Question(new MultipleChoiceQuestionStrategy(), "What property of an object resists any change in its state of motion?", new String[] {"Gravity", "Velocity", "Inertia", "Weight"}, "Inertia"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A bug hitting a bus windshield experiences a greater magnitude of force than the bus experiences.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "In uniform circular motion, the centripetal acceleration vector always points:", new String[] {"Tangential to the path", "Away from the center", "Toward the center", "In the direction of velocity"}, "Toward the center"),

            // --- 4. ENERGY & CONSERVATION ---
            new Question(new MultipleChoiceQuestionStrategy(), "How much work is done by the normal force on a block sliding horizontally across a flat table?", new String[] {"Depends on friction", "Zero", "mg * distance", "Negative work"}, "Zero"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Non-conservative forces, like friction, change the total mechanical energy of a system.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If you triple the speed of an object, its Kinetic Energy increases by a factor of:", new String[] {"3", "6", "9", "27"}, "9"),

            // --- 5. LINEAR MOMENTUM, IMPULSE & COLLISIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Impulse is mathematically equivalent to the change in an object's:", new String[] {"Velocity", "Mass", "Kinetic Energy", "Momentum"}, "Momentum"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a perfectly elastic collision, both total momentum and total kinetic energy are conserved.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "In an inelastic collision, the objects involved typically:", new String[] {"Bounce off with equal speeds", "Deform and lose kinetic energy", "Gain kinetic energy", "Convert all mass to energy"}, "Deform and lose kinetic energy"),

            // --- 6. ROTATION & 7. TORQUE/ANGULAR MOMENTUM ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which quantity is the rotational equivalent of mass?", new String[] {"Torque", "Angular Velocity", "Moment of Inertia", "Angular Momentum"}, "Moment of Inertia"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A solid sphere and a hollow sphere of the same mass and radius will roll down an incline at the exact same speed.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "A figure skater pulls their arms in to spin faster. This demonstrates the conservation of:", new String[] {"Linear Momentum", "Rotational Kinetic Energy", "Angular Momentum", "Torque"}, "Angular Momentum"),
            new Question(new MultipleChoiceQuestionStrategy(), "To maximize torque on a wrench, you should apply force:", new String[] {"Near the bolt", "Perpendicular to the handle at the end", "Parallel to the handle", "At the center of mass"}, "Perpendicular to the handle at the end"),

            // --- 8. FLUID MECHANICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "According to Bernoulli's principle, as the speed of a moving fluid increases, its internal pressure:", new String[] {"Increases", "Decreases", "Stays the same", "Fluctuates"}, "Decreases"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Archimedes' Principle states the buoyant force equals the weight of the fluid displaced by the object.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Hydraulic lifts operate primarily based on which principle?", new String[] {"Bernoulli's Principle", "Newton's Third Law", "Pascal's Principle", "Archimedes' Principle"}, "Pascal's Principle"),

            // --- 9. OSCILLATORY MOTION ---
            new Question(new MultipleChoiceQuestionStrategy(), "In Simple Harmonic Motion (SHM), acceleration is directly proportional to:", new String[] {"Velocity", "Mass", "Displacement from equilibrium", "Time"}, "Displacement from equilibrium"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The period of a simple pendulum depends heavily on the mass of the bob.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The restoring force of an ideal spring is described by:", new String[] {"Newton's Law of Gravitation", "Hooke's Law", "Faraday's Law", "Boyle's Law"}, "Hooke's Law"),

            // --- 10. WAVE MOTION & 11. SOUND WAVES ---
            new Question(new MultipleChoiceQuestionStrategy(), "What type of wave is a sound wave traveling through air?", new String[] {"Transverse", "Longitudinal", "Electromagnetic", "Surface"}, "Longitudinal"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a standing wave, the points that remain completely stationary are called antinodes.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "When two waves overlap and their amplitudes add together to create a larger wave, this is called:", new String[] {"Destructive interference", "Diffraction", "Constructive interference", "Refraction"}, "Constructive interference"),

            // --- 12. KINETIC THEORY OF GASES ---
            new Question(new MultipleChoiceQuestionStrategy(), "The Kinetic Theory of Gases assumes that collisions between ideal gas molecules are:", new String[] {"Perfectly inelastic", "Perfectly elastic", "Non-existent", "Friction-heavy"}, "Perfectly elastic"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The absolute temperature of an ideal gas is directly proportional to the average kinetic energy of its molecules.", "True"),

            // --- 13. TEMPERATURE & 1ST LAW OF THERMODYNAMICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The First Law of Thermodynamics is essentially a restatement of:", new String[] {"Newton's First Law", "Conservation of Momentum", "Conservation of Energy", "The Ideal Gas Law"}, "Conservation of Energy"),
            new Question(new MultipleChoiceQuestionStrategy(), "An isothermal process is one in which the system's:", new String[] {"Pressure remains constant", "Volume remains constant", "Temperature remains constant", "Heat exchange is zero"}, "Temperature remains constant"),

            // --- 14. ENTROPY & 2ND LAW OF THERMODYNAMICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The Second Law of Thermodynamics states that for any spontaneous process, the total entropy of the universe:", new String[] {"Decreases", "Increases", "Remains constant", "Reaches absolute zero"}, "Increases"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Entropy can be thought of as a measure of the disorder or randomness in a system.", "True"),

            // --- 15. HEAT ENGINES ---
            new Question(new MultipleChoiceQuestionStrategy(), "What idealized cycle provides the maximum possible efficiency for a heat engine operating between two temperatures?", new String[] {"Otto Cycle", "Diesel Cycle", "Carnot Cycle", "Brayton Cycle"}, "Carnot Cycle"),
            new Question(new MultipleChoiceQuestionStrategy(), "Why can a real heat engine never be 100% efficient?", new String[] {"Friction is unavoidable", "Some heat is always expelled to a cold reservoir", "Metals melt at high heat", "Engines are too heavy"}, "Some heat is always expelled to a cold reservoir"),

            // --- WRITTEN CONCEPTS ---
            new Question(new WrittenQuestionStrategy(), "Energy due to motion is called _____ energy.", "Kinetic"),
            new Question(new WrittenQuestionStrategy(), "Which of Newton's laws is also known as the Law of Inertia?", "First"),
            new Question(new WrittenQuestionStrategy(), "What is the standard SI unit for measuring Energy and Work?", "Joule"),
            new Question(new WrittenQuestionStrategy(), "What is the numerical value of acceleration due to gravity on Earth (in m/s^2)?", "9.8"),
            new Question(new WrittenQuestionStrategy(), "What thermodynamic state variable is a measure of a system's thermal energy per molecule?", "Temperature")
        });

        subjectData.put(Subject.CALCULUS_II, new Question[] {
            // --- WEEK 1-3: SEQUENCES, SERIES & FUNCTION APPROXIMATION ---
            new Question(new MultipleChoiceQuestionStrategy(), "In mathematical induction, what is the step where you assume the statement is true for n = k?", new String[] {"Base Step", "Inductive Hypothesis", "Inductive Step", "Conclusion"}, "Inductive Hypothesis"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If the limit of the terms of a sequence approaches a specific number, the sequence converges.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "A geometric series converges if the absolute value of the common ratio 'r' is:", new String[] {"Greater than 1", "Less than 1", "Equal to 0", "Negative"}, "Less than 1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Divergence Test can prove that a series converges.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The p-series 1/n^p converges if:", new String[] {"p < 1", "p = 1", "p > 1", "p is negative"}, "p > 1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Harmonic Series (1/n) converges.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which test is most effective for series involving factorials, such as n!?", new String[] {"Integral Test", "Ratio Test", "Root Test", "P-series Test"}, "Ratio Test"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Absolute convergence of a series implies conditional convergence.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Taylor Series centered specifically at x = 0 is called a:", new String[] {"Power Series", "Fourier Series", "Maclaurin Series", "Newton Series"}, "Maclaurin Series"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the Maclaurin series representation for e^x?", new String[] {"Sum of x^n", "Sum of x^n / n!", "Sum of (-1)^n x^n", "Sum of 1/n"}, "Sum of x^n / n!"),

            // --- WEEK 4-5: 3D SPACE & VECTOR FUNCTIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The dot product of two orthogonal (perpendicular) vectors is always:", new String[] {"1", "0", "-1", "Infinity"}, "0"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The cross product of two vectors results in a scalar quantity.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "To determine the equation of a plane, you need a point on the plane and a:", new String[] {"Parallel vector", "Unit vector", "Normal vector", "Tangent vector"}, "Normal vector"),
            new Question(new MultipleChoiceQuestionStrategy(), "The cross product of a vector with itself (v x v) is:", new String[] {"|v|^2", "1", "0 (the zero vector)", "2v"}, "0 (the zero vector)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The derivative of a vector function is found by differentiating each of its component functions.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The integral of a vector function produces a result that includes an arbitrary:", new String[] {"Scalar constant", "Vector constant", "Function", "Matrix"}, "Vector constant"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The curvature of a straight line in space is always zero.", "True"),

            // --- WEEK 6-8: FUNCTIONS OF SEVERAL VARIABLES ---
            new Question(new MultipleChoiceQuestionStrategy(), "For a limit of a function f(x,y) to exist at a point, it must approach the same value along:", new String[] {"The x-axis only", "The y-axis only", "Two specific paths", "Every possible path"}, "Every possible path"),
            new Question(new MultipleChoiceQuestionStrategy(), "When computing the partial derivative of f(x,y) with respect to x, you treat y as:", new String[] {"A variable", "Zero", "A constant", "Infinity"}, "A constant"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Clairaut's Theorem states that if mixed partial derivatives are continuous, then f_xy = f_yx.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Gradient vector of a function points in the direction of:", new String[] {"Zero change", "Maximum rate of increase", "Maximum rate of decrease", "The origin"}, "Maximum rate of increase"),
            new Question(new MultipleChoiceQuestionStrategy(), "To find the directional derivative of f in the direction of vector u, 'u' must be:", new String[] {"A unit vector", "A zero vector", "An orthogonal vector", "A normal vector"}, "A unit vector"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The chain rule for z = f(x,y) where x = g(t) and y = h(t) involves both partial and ordinary derivatives.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "To find the critical points of a function f(x,y), you must set:", new String[] {"f(x,y) = 0", "f_x = 0 and f_y = 0", "f_xx = 0 and f_yy = 0", "The gradient to 1"}, "f_x = 0 and f_y = 0"),

            // --- WEEK 9: DOUBLE INTEGRALS ---
            new Question(new TrueFalseQuestionStrategy(), "True or False: Fubini's Theorem states that for continuous functions, the order of integration in an iterated integral does not matter.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The double integral of the function f(x,y) = 1 over a general region D represents the:", new String[] {"Volume of D", "Area of D", "Perimeter of D", "Center of mass of D"}, "Area of D"),
            new Question(new MultipleChoiceQuestionStrategy(), "When changing the order of integration from dy dx to dx dy, what must you do first?", new String[] {"Invert the function", "Multiply by -1", "Sketch the region of integration", "Take the derivative"}, "Sketch the region of integration"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A Type I region in a double integral is bounded by vertical lines on the left and right.", "True"),

            // --- WEEK 10: FIRST-ORDER DIFFERENTIAL EQUATIONS ---
            new Question(new MultipleChoiceQuestionStrategy(), "A differential equation is called 'separable' if it can be written in the form:", new String[] {"dy/dx = f(x)g(y)", "dy/dx = f(x) + g(y)", "dy/dx = x/y", "dy/dx = f(y)"}, "dy/dx = f(x)g(y)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A differential equation M(x,y)dx + N(x,y)dy = 0 is Exact if the partial derivative M_y equals N_x.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "To solve a first-order linear differential equation, you typically multiply the entire equation by an:", new String[] {"Exponential factor", "Integrating factor", "Eigenvalue", "Inverse function"}, "Integrating factor"),
            new Question(new MultipleChoiceQuestionStrategy(), "The substitution v = y/x is typically used to solve which type of differential equation?", new String[] {"Linear", "Exact", "Homogeneous", "Bernoulli"}, "Homogeneous"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A Bernoulli differential equation can be transformed into a linear differential equation using a specific substitution.", "True"),

            // --- WRITTEN QUESTIONS ---
            new Question(new WrittenQuestionStrategy(), "What test compares the limit of the ratio of a series' consecutive terms to 1?", "Ratio"),
            new Question(new WrittenQuestionStrategy(), "A Taylor series centered at x = 0 is called a ____ series.", "Maclaurin"),
            new Question(new WrittenQuestionStrategy(), "What vector operation between two 3D vectors results in a scalar?", "Dot Product"),
            new Question(new WrittenQuestionStrategy(), "What vector denotes the direction of the maximum rate of change for a function of two variables?", "Gradient"),
            new Question(new WrittenQuestionStrategy(), "If f_xy and f_yx are continuous, what theorem states they are equal?", "Clairaut")
            });

        subjectData.put(Subject.PHYSICS_II, new Question[] {
            // --- 1. ELECTROSTATICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "According to Gauss's Law, the total electric flux through a closed surface is proportional to:", new String[] {"The surface area", "The enclosed charge", "The electric potential", "The volume"}, "The enclosed charge"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The electric field inside a solid conducting sphere in electrostatic equilibrium is zero.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What happens to the electric potential energy of a system if two like charges are brought closer together?", new String[] {"It increases", "It decreases", "It becomes zero", "It remains constant"}, "It increases"),
            new Question(new MultipleChoiceQuestionStrategy(), "The unit of electric potential is the Volt, which is equivalent to:", new String[] {"Coulombs per Newton", "Joules per Coulomb", "Amperes per Ohm", "Newtons per meter"}, "Joules per Coulomb"),

            // --- 2. ELECTRODYNAMICS (DC CIRCUITS) ---
            new Question(new MultipleChoiceQuestionStrategy(), "Kirchhoff's Junction Rule is a direct consequence of the conservation of:", new String[] {"Energy", "Momentum", "Mass", "Charge"}, "Charge"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Kirchhoff's Loop Rule states that the sum of potential differences around any closed loop in a circuit must be zero.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the voltage across a standard ohmic resistor is doubled, the current flowing through it:", new String[] {"Halves", "Stays the same", "Doubles", "Quadruples"}, "Doubles"),

            // --- 3. MAGNETIC FIELDS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The magnetic force on a moving charge is maximized when the charge's velocity is:", new String[] {"Parallel to the magnetic field", "Anti-parallel to the magnetic field", "Perpendicular to the magnetic field", "Zero"}, "Perpendicular to the magnetic field"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which law states that an induced electromotive force (EMF) always gives rise to a current whose magnetic field opposes the change in original magnetic flux?", new String[] {"Faraday's Law", "Ampere's Law", "Lenz's Law", "Biot-Savart Law"}, "Lenz's Law"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A stationary electron placed in a uniform magnetic field will experience a magnetic force.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Ampere's Law relates the magnetic field along a closed loop to the:", new String[] {"Electric flux", "Enclosed electric charge", "Enclosed current", "Change in magnetic flux"}, "Enclosed current"),

            // --- 4. INDUCTANCE & AC CIRCUITS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The energy in an inductor is stored in its:", new String[] {"Electric field", "Magnetic field", "Voltage", "Resistance"}, "Magnetic field"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a purely inductive AC circuit, the current lags the voltage by 90 degrees.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "At the resonant frequency of an RLC series circuit, the total impedance is purely:", new String[] {"Capacitive", "Inductive", "Resistive", "Infinite"}, "Resistive"),

            // --- 5. ELECTROMAGNETIC WAVES ---
            new Question(new MultipleChoiceQuestionStrategy(), "In an electromagnetic wave, the Poynting vector represents the:", new String[] {"Direction of the electric field", "Direction of the magnetic field", "Rate of energy transport per unit area", "Wavelength"}, "Rate of energy transport per unit area"),
            new Question(new MultipleChoiceQuestionStrategy(), "If an electromagnetic wave is traveling in the +x direction and the electric field is in the +y direction, the magnetic field must be in the:", new String[] {"+x direction", "-y direction", "+z direction", "-z direction"}, "+z direction"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The intensity of an electromagnetic wave is directly proportional to the square of its electric field amplitude.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of the following electromagnetic waves has the highest frequency?", new String[] {"Microwaves", "X-rays", "Visible Light", "Radio Waves"}, "X-rays"),

            // --- 6. OPTICS (INTERFERENCE, DIFFRACTION, POLARIZATION) ---
            new Question(new MultipleChoiceQuestionStrategy(), "In Young's double-slit experiment, a dark fringe (destructive interference) occurs when the path difference is:", new String[] {"An integer multiple of the wavelength", "A half-integer multiple of the wavelength", "Zero", "Equal to the slit separation"}, "A half-integer multiple of the wavelength"),
            new Question(new MultipleChoiceQuestionStrategy(), "If the width of a single slit is decreased, the central bright fringe of the diffraction pattern will:", new String[] {"Become narrower", "Become wider", "Stay the same width", "Disappear completely"}, "Become wider"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Unpolarized light passing through an ideal polarizing filter loses exactly half of its intensity.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "When unpolarized light reflects off a surface at Brewster's angle, the reflected light is:", new String[] {"Unpolarized", "Completely linearly polarized", "Circularly polarized", "Absorbed completely"}, "Completely linearly polarized"),
            new Question(new MultipleChoiceQuestionStrategy(), "According to Malus's Law, the intensity of polarized light transmitted through a polarizer depends on the cosine squared of the:", new String[] {"Wavelength", "Frequency", "Angle between polarization axes", "Index of refraction"}, "Angle between polarization axes"),

            // --- 7. SPECIAL RELATIVITY ---
            new Question(new MultipleChoiceQuestionStrategy(), "According to the Special Theory of Relativity, which of the following is constant for all inertial observers?", new String[] {"Time intervals", "Lengths of objects", "The speed of light in a vacuum", "Momentum"}, "The speed of light in a vacuum"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An observer on Earth will measure a moving clock ticking slower than a clock at rest on Earth.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If an object moves at a significant fraction of the speed of light, its measured length in the direction of motion will:", new String[] {"Increase", "Decrease (Length Contraction)", "Remain unchanged", "Become infinite"}, "Decrease (Length Contraction)"),
            new Question(new MultipleChoiceQuestionStrategy(), "The rest energy of a particle with mass m is given by the famous equation:", new String[] {"E = 1/2 mv^2", "E = mc^2", "E = hf", "E = p^2 / 2m"}, "E = mc^2"),

            // --- 8. INTRODUCTORY QUANTUM MECHANICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "In the photoelectric effect, the minimum energy required to eject an electron from a metal surface is called the:", new String[] {"Kinetic energy", "Stopping potential", "Work function", "Threshold wavelength"}, "Work function"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In the photoelectric effect, increasing the intensity of the incident light (while keeping frequency constant) increases the maximum kinetic energy of the ejected electrons.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "The energy of a photon is directly proportional to its:", new String[] {"Wavelength", "Mass", "Frequency", "Amplitude"}, "Frequency"),
            new Question(new MultipleChoiceQuestionStrategy(), "The de Broglie wavelength of a particle is inversely proportional to its:", new String[] {"Mass only", "Velocity only", "Momentum", "Kinetic energy"}, "Momentum"),
            new Question(new MultipleChoiceQuestionStrategy(), "For a particle confined in a 1D infinite potential well, if the width of the well is doubled, the ground state energy:", new String[] {"Doubles", "Halves", "Becomes four times larger", "Becomes one-fourth as large"}, "Becomes one-fourth as large"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The lowest possible energy state (ground state) for a particle in an infinite potential well is zero.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "To jump from the ground state (n=1) to the first excited state (n=2) in an infinite well, an electron must absorb a photon with energy equal to:", new String[] {"E_1", "2*E_1", "3*E_1", "4*E_1"}, "3*E_1"),

            // --- 9. NUCLEAR PHYSICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Alpha decay involves the emission of an alpha particle, which is identical to the nucleus of:", new String[] {"Hydrogen", "Helium", "Lithium", "Carbon"}, "Helium"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: After two half-lives have passed, exactly one-quarter (25%) of the original radioactive sample remains undecayed.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The difference between the mass of an intact nucleus and the sum of the masses of its individual nucleons is called the:", new String[] {"Atomic mass", "Mass defect", "Binding energy", "Isotope gap"}, "Mass defect"),
            new Question(new MultipleChoiceQuestionStrategy(), "In beta minus (β-) decay, a neutron in the nucleus transforms into a proton and emits:", new String[] {"An alpha particle", "A photon", "An electron", "A positron"}, "An electron"),

            // --- SUPPLEMENTARY / MIXED PHYSICS II CONCEPTS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The unit of Capacitance is the:", new String[] {"Henry", "Farad", "Tesla", "Weber"}, "Farad"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The magnetic flux through a loop is maximum when the plane of the loop is parallel to the magnetic field.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of the following determines the stopping potential in a photoelectric effect experiment?", new String[] {"The intensity of light", "The frequency of incident light", "The angle of incidence", "The area of the metal plate"}, "The frequency of incident light"),
            new Question(new MultipleChoiceQuestionStrategy(), "Isotopes of the same element have the same number of protons but a different number of:", new String[] {"Electrons", "Neutrons", "Positrons", "Quarks"}, "Neutrons"),
            new Question(new MultipleChoiceQuestionStrategy(), "The total energy of an electron moving at relativistic speeds is the sum of its kinetic energy and its:", new String[] {"Potential energy", "Thermal energy", "Rest energy", "Rotational energy"}, "Rest energy"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Photons have zero rest mass.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "When light transitions from a medium with a lower refractive index to one with a higher refractive index, its speed:", new String[] {"Increases", "Decreases", "Stays the same", "Becomes c"}, "Decreases"),

            // --- WRITTEN CONCEPTS ---
            new Question(new WrittenQuestionStrategy(), "What is the SI unit of magnetic field strength?", "Tesla"),
            new Question(new WrittenQuestionStrategy(), "What term describes the minimum frequency of light required to cause the photoelectric effect?", "Threshold frequency"),
            new Question(new WrittenQuestionStrategy(), "In a vacuum, what is the speed of an electromagnetic wave in m/s (approximate to 3x10^X)?", "3x10^8"),
            new Question(new WrittenQuestionStrategy(), "What name is given to the time required for half of the atoms in a radioactive sample to decay?", "Half-life"),
            new Question(new WrittenQuestionStrategy(), "According to Einstein, mass and energy are equivalent. What is the formula?", "E=mc^2")
        });

        subjectData.put(Subject.COMP_PROG, new Question[] {
            // --- CHAPTER 0 & 1: GETTING STARTED, DATA TYPES & EXPRESSIONS ---
            new Question(new TrueFalseQuestionStrategy(), "True or False: Python uses indentation to define code blocks instead of curly braces.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the correct syntax to output 'Hello World' in Python?", new String[] {"p('Hello World')", "echo 'Hello World'", "print('Hello World')", "printf('Hello World')"}, "print('Hello World')"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which operator is used for 'Floor Division' in Python?", new String[] {"/", "//", "%", "div"}, "//"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the correct way to write a single-line comment in Python?", new String[] {"// comment", "/* comment */", "# comment", "-- comment"}, "# comment"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Floating-point calculations in computer programs can sometimes suffer from imprecision.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which compound assignment operator correctly adds 5 to the variable x?", new String[] {"x ++ 5", "x =+ 5", "x += 5", "x + 5 = x"}, "x += 5"),

            // --- CHAPTER 2 & 8: STRINGS & STRING PROCESSING ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which data type is used for a sequence of characters in Python?", new String[] {"char", "String", "str", "text"}, "str"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In Python, the expression '3' + '3' results in '33'.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "How do you start a multi-line string in Python?", new String[] {"///", "\"\"\"", "###", "&&&"}, "\"\"\""),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Strings in Python are immutable, meaning they cannot be changed after creation.", "True"),

            // --- CHAPTER 3: SELECTION (IF-ELSE) ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which logical operator represents 'AND' in Python?", new String[] {"&&", "and", "&", "amp"}, "and"),
            new Question(new MultipleChoiceQuestionStrategy(), "What operator is used to perform equality testing between two primitive values?", new String[] {"=", "==", "===", "equals"}, "=="),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to represent an alternative condition in Python if the initial 'if' fails?", new String[] {"else if", "elseif", "elif", "otherwise"}, "elif"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A nested if statement is an if statement placed entirely inside another if statement.", "True"),

            // --- CHAPTER 4 & 9: REPETITION & NESTED STRUCTURES ---
            new Question(new MultipleChoiceQuestionStrategy(), "To exit a loop prematurely in Python, you use the keyword:", new String[] {"exit", "stop", "break", "return"}, "break"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A 'while' loop will execute at least once even if its initial condition is False.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to skip the current iteration of a loop and proceed to the next one?", new String[] {"skip", "pass", "continue", "next"}, "continue"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A nested loop is a loop inside the body of another loop.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "To simulate a generic 'do-while' loop in Python (which doesn't exist natively), you generally use:", new String[] {"A for loop", "A while True loop with a break condition at the end", "A switch statement", "A recursive function"}, "A while True loop with a break condition at the end"),

            // --- CHAPTER 5 & 6: LIST PROCESSING, FUNCTIONS & RECURSION ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which method is used to add an element to the end of a list?", new String[] {"add()", "insert()", "append()", "push()"}, "append()"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to define a new function in Python?", new String[] {"function", "def", "void", "func"}, "def"),
            new Question(new MultipleChoiceQuestionStrategy(), "What does a recursive function do?", new String[] {"Loops indefinitely", "Calls itself to solve a smaller instance of the same problem", "Returns multiple values", "Deletes data from an array"}, "Calls itself to solve a smaller instance of the same problem"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Arrays or lists can be passed as parameters to functions.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which built-in Python method sorts a list in place?", new String[] {"order()", "arrange()", "sort()", "sorted()"}, "sort()"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which operator easily checks if a specific element exists within a list (linear search)?", new String[] {"exists", "in", "has", "contains"}, "in"),

            // --- CHAPTER 10 & 11: TUPLE, SET, DICT & NUMPY ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which collection is ordered, changeable, and allows duplicate members?", new String[] {"List", "Tuple", "Set", "Dictionary"}, "List"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A Python tuple can be changed (mutated) after it is created.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which collection in Python stores key-value pairs?", new String[] {"List", "Set", "Dictionary", "Tuple"}, "Dictionary"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A Set in Python is unordered and does not allow duplicate items.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "NumPy arrays differ from standard Python lists primarily because they:", new String[] {"Cannot store numbers", "Are significantly faster and optimized for numerical operations", "Can only hold strings", "Are immutable"}, "Are significantly faster and optimized for numerical operations"),

            // --- CHAPTER 12: CLASSES, OBJECTS & INHERITANCE ---
            new Question(new MultipleChoiceQuestionStrategy(), "What is the name of the constructor method used to initialize an object's state in a Python class?", new String[] {"__start__", "__init__", "__class__", "__new__"}, "__init__"),
            new Question(new MultipleChoiceQuestionStrategy(), "The 'self' parameter in a class method refers to:", new String[] {"The class itself", "The parent class", "The specific instance (object) of the class", "The global scope"}, "The specific instance (object) of the class"),
            new Question(new MultipleChoiceQuestionStrategy(), "Inheritance in Object-Oriented Programming allows a new class to:", new String[] {"Delete an existing class", "Acquire the properties and methods of an existing class", "Prevent instance creation", "Bypass memory allocation"}, "Acquire the properties and methods of an existing class"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A child class can override a method defined in its parent class.", "True"),

            // --- WRITTEN CONCEPTS ---
            new Question(new WrittenQuestionStrategy(), "Which Python function gets user input from the keyboard?", "input()"),
            new Question(new WrittenQuestionStrategy(), "What data type is used to store key-value pairs in Python?", "dict"),
            new Question(new WrittenQuestionStrategy(), "What function is used to get the number of elements in a list?", "len()"),
            new Question(new WrittenQuestionStrategy(), "If a function calls itself during execution, what programming concept is being used?", "Recursion"),
            new Question(new WrittenQuestionStrategy(), "In Object-Oriented Programming, what term describes a blueprint used to create objects?", "Class")
        });

        subjectData.put(Subject.ADV_COMP_PROG, new Question[] {
            // --- ADVANCED COMPUTER PROGRAMMING ---

            // --- WEEK 2-4: OOP FOUNDATIONS, INHERITANCE, POLYMORPHISM & COMPOSITION ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which concept allows a subclass to provide a specific implementation of a method already defined in its superclass?", new String[] {"Overloading", "Overriding", "Encapsulation", "Abstraction"}, "Overriding"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A constructor can be inherited by a subclass.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which access modifier makes a member visible only within its own class?", new String[] {"public", "protected", "default", "private"}, "private"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: An abstract class can be instantiated using the 'new' keyword.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is 'Polymorphism' in Object-Oriented Programming?", new String[] {"Hiding data", "A class with many constructors", "One interface, multiple implementations", "Copying objects"}, "One interface, multiple implementations"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to call the constructor of the parent class?", new String[] {"this", "parent", "super", "base"}, "super"),
            new Question(new MultipleChoiceQuestionStrategy(), "Composition is generally used to model which type of relationship between classes?", new String[] {"Is-a", "Has-a", "Works-with", "Becomes-a"}, "Has-a"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Composition provides better encapsulation and looser coupling compared to class inheritance.", "True"),

            // --- WEEK 5: INTERFACE & EXCEPTION HANDLING ---
            new Question(new MultipleChoiceQuestionStrategy(), "What is the primary purpose of an 'Interface' in OOP?", new String[] {"To store data", "To define a contract of behavior", "To prevent inheritance", "To speed up execution"}, "To define a contract of behavior"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which keyword is used to implement an interface?", new String[] {"extends", "implements", "uses", "requires"}, "implements"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which block is used to enclose code that might throw an exception?", new String[] {"catch", "finally", "try", "throw"}, "try"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The 'finally' block executes even if no exception is caught.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of these is a 'Checked' exception?", new String[] {"NullPointerException", "ArithmeticException", "IOException", "ArrayIndexOutOfBoundsException"}, "IOException"),
            new Question(new MultipleChoiceQuestionStrategy(), "What keyword is used in a method signature to declare that it might throw an exception?", new String[] {"throw", "throws", "catch", "assert"}, "throws"),

            // --- WEEK 6: OO DESIGN PRINCIPLES (SRP, OCP) ---
            new Question(new MultipleChoiceQuestionStrategy(), "What does the Single Responsibility Principle (SRP) state?", new String[] {"A class should have multiple ways to be modified", "A class should only have one reason to change", "Every class must inherit from a single parent", "Classes must have single-line methods"}, "A class should only have one reason to change"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Open/Closed Principle (OCP) states that software entities should be open for ________ but closed for ________.", new String[] {"reading, writing", "testing, deployment", "extension, modification", "modification, extension"}, "extension, modification"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Applying the Open/Closed Principle often involves using polymorphism and abstract interfaces.", "True"),

            // --- WEEK 9-10: CONCURRENT (THREADING) & SOCKET PROGRAMMING ---
            new Question(new MultipleChoiceQuestionStrategy(), "The 'synchronized' keyword is used to achieve:", new String[] {"Polymorphism", "Thread Safety", "Faster loops", "Data Compression"}, "Thread Safety"),
            new Question(new MultipleChoiceQuestionStrategy(), "What happens if a thread calls 'wait()'?", new String[] {"It stops forever", "It releases the lock and waits", "It busy-waits", "It crashes"}, "It releases the lock and waits"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In concurrent programming, multiple threads share the same heap memory space.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "In Java Socket Programming, which class is used by the server to listen for incoming client connections?", new String[] {"Socket", "ClientSocket", "ServerSocket", "DatagramSocket"}, "ServerSocket"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is required to establish a TCP socket connection between a client and a server?", new String[] {"IP Address and Port Number", "MAC Address", "File Path", "Router Password"}, "IP Address and Port Number"),

            // --- WEEK 11-14: DESIGN PATTERNS ---
            new Question(new MultipleChoiceQuestionStrategy(), "The Singleton pattern ensures that:", new String[] {"A class has only one instance", "A class is thread-safe", "Methods are static", "Objects are immutable"}, "A class has only one instance"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Strategy Pattern involves defining a family of algorithms, encapsulating each one, and making them interchangeable.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which design pattern defines a one-to-many dependency so that when one object changes state, all its dependents are notified?", new String[] {"Factory", "Observer", "Decorator", "Iterator"}, "Observer"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which pattern allows behavior to be added to an individual object dynamically, without affecting the behavior of other objects from the same class?", new String[] {"Composite", "Strategy", "Decorator", "Singleton"}, "Decorator"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which design pattern is used to create objects without specifying the exact class of the object that will be created?", new String[] {"Factory Pattern", "Composite Pattern", "Iterator Pattern", "Observer Pattern"}, "Factory Pattern"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which pattern lets clients treat individual objects and compositions of objects uniformly (often used for tree structures)?", new String[] {"Strategy", "Composite", "Decorator", "Factory"}, "Composite"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.", "True"),

            // --- WRITTEN QUESTIONS ---
            new Question(new WrittenQuestionStrategy(), "What keyword is used to inherit a class in Java?", "extends"),
            new Question(new WrittenQuestionStrategy(), "What design principle acronym stands for classes having only one reason to change?", "SRP"),
            new Question(new WrittenQuestionStrategy(), "Which keyword is used to create a constant variable or prevent method overriding?", "final"),
            new Question(new WrittenQuestionStrategy(), "What pattern encapsulates algorithms into their own interchangeable classes?", "Strategy"),
            new Question(new WrittenQuestionStrategy(), "Which access modifier allows access only within the same class?", "private")
        });

        subjectData.put(Subject.PROB_STAT_DATA, new Question[] {
            // --- WEEKS 1-3: BASIC PROBABILITY, COUNTING & BAYES' THEOREM ---
            new Question(new MultipleChoiceQuestionStrategy(), "The set of all possible outcomes of an experiment is called the:", new String[] {"Population", "Sample Space", "Event Set", "Data Range"}, "Sample Space"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which counting technique is used when the order of selection matters?", new String[] {"Combination", "Permutation", "Intersection", "Union"}, "Permutation"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If two events are mutually exclusive, the probability of both occurring at the same time is 0.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "If events A and B are independent, what does P(A and B) equal?", new String[] {"P(A) + P(B)", "P(A) / P(B)", "P(A) * P(B)", "P(A|B)"}, "P(A) * P(B)"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which theorem is used to update the probability for a hypothesis as more evidence or information becomes available?", new String[] {"Chebyshev's Theorem", "Bayes' Theorem", "Binomial Theorem", "Law of Total Probability"}, "Bayes' Theorem"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The probability of an event and its complement must always sum to 1.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The formula P(A|B) = P(A and B) / P(B) is the definition of:", new String[] {"Total Probability", "Joint Probability", "Conditional Probability", "Marginal Probability"}, "Conditional Probability"),

            // --- WEEKS 4-7: DISCRETE & CONTINUOUS RANDOM VARIABLES ---
            new Question(new MultipleChoiceQuestionStrategy(), "A function that maps the outcomes of a random process to numerical values is called a:", new String[] {"Sample space", "Random variable", "Parameter", "Statistic"}, "Random variable"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The number of defective items in a batch of 50 is an example of a continuous random variable.", "False"),
            new Question(new MultipleChoiceQuestionStrategy(), "For a discrete random variable, what is the equivalent of the probability density function (PDF)?", new String[] {"Cumulative Distribution Function", "Probability Mass Function", "Expected Value", "Variance"}, "Probability Mass Function"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which distribution is typically used to model the number of events occurring in a fixed interval of time?", new String[] {"Normal", "Binomial", "Poisson", "Exponential"}, "Poisson"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the total area under a probability density function (PDF) curve for a continuous random variable?", new String[] {"0.5", "1", "Depends on the data", "100"}, "1"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: For a continuous random variable X, the probability that X equals any single exact value is 0.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The '68-95-99.7 Rule' applies to which type of distribution?", new String[] {"Binomial", "Poisson", "Normal", "Uniform"}, "Normal"),

            // --- WEEKS 9-10: JOINT DISTRIBUTIONS, COVARIANCE & FUNCTIONS OF RV ---
            new Question(new MultipleChoiceQuestionStrategy(), "A probability distribution that gives the probability of two or more random variables occurring simultaneously is a:", new String[] {"Marginal distribution", "Joint distribution", "Conditional distribution", "Normal distribution"}, "Joint distribution"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which metric measures the directional linear relationship between two random variables?", new String[] {"Variance", "Standard Deviation", "Covariance", "Expected Value"}, "Covariance"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If two random variables are independent, their covariance is strictly zero.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "For a random variable X and constants a and b, what is the Expected Value E[aX + b]?", new String[] {"aE[X] + b", "aE[X]", "E[X] + b", "a^2E[X] + b"}, "aE[X] + b"),
            new Question(new MultipleChoiceQuestionStrategy(), "For a random variable X and a constant 'a', what is the Variance Var(aX)?", new String[] {"a * Var(X)", "a^2 * Var(X)", "Var(X) / a", "a + Var(X)"}, "a^2 * Var(X)"),

            // --- WEEK 11: DESCRIPTIVE STATISTICS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Which measure of central tendency is most heavily affected by extreme outliers?", new String[] {"Median", "Mean", "Mode", "Interquartile Range"}, "Mean"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: If the variance of a data set is 0, all data points in that set must be identical.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Interquartile Range (IQR) is calculated as:", new String[] {"Q3 - Q1", "Q4 - Q0", "Mean - Median", "Maximum - Minimum"}, "Q3 - Q1"),
            new Question(new MultipleChoiceQuestionStrategy(), "Which of the following plots is best for visualizing the 5-number summary of a dataset?", new String[] {"Scatterplot", "Pie Chart", "Histogram", "Boxplot"}, "Boxplot"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: In a skewed-right distribution, the mean is typically greater than the median.", "True"),

            // --- WEEKS 13-14: POINT ESTIMATION & CONFIDENCE INTERVALS ---
            new Question(new MultipleChoiceQuestionStrategy(), "Using the sample mean to estimate the population mean is an example of:", new String[] {"Hypothesis testing", "Point estimation", "Linear regression", "Interval estimation"}, "Point estimation"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: A larger sample size generally leads to a narrower confidence interval (smaller margin of error).", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "What does a 95% confidence interval indicate?", new String[] {"The sample mean is 95", "95% of the data falls within this range", "We are 95% confident the true population parameter lies in this interval", "There is a 95% chance the population mean is 0"}, "We are 95% confident the true population parameter lies in this interval"),
            new Question(new MultipleChoiceQuestionStrategy(), "The Central Limit Theorem states that as sample size increases, the sampling distribution of the mean approaches a:", new String[] {"Skewed distribution", "Normal distribution", "Uniform distribution", "Bimodal distribution"}, "Normal distribution"),

            // --- WEEK 15: HYPOTHESIS TESTING I ---
            new Question(new MultipleChoiceQuestionStrategy(), "In hypothesis testing, the probability of rejecting the Null Hypothesis when it is actually true is known as:", new String[] {"Type I Error", "Type II Error", "Statistical Power", "Confidence Level"}, "Type I Error"),
            new Question(new MultipleChoiceQuestionStrategy(), "In a standard test, we reject the Null Hypothesis if the calculated P-value is:", new String[] {"Greater than the significance level (alpha)", "Less than the significance level (alpha)", "Equal to 1", "Negative"}, "Less than the significance level (alpha)"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The Null Hypothesis typically represents a position of 'no effect', 'no difference', or 'status quo'.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "Failing to reject a false Null Hypothesis is defined as a:", new String[] {"Type I Error", "Type II Error", "Standard Error", "Margin of Error"}, "Type II Error"),

            // --- WEEK 16: LINEAR REGRESSION ---
            new Question(new MultipleChoiceQuestionStrategy(), "In a simple linear regression equation (y = b0 + b1x), what does 'b1' represent?", new String[] {"Y-intercept", "Slope", "Correlation coefficient", "Residual"}, "Slope"),
            new Question(new MultipleChoiceQuestionStrategy(), "The difference between an observed value and the value predicted by a regression model is called the:", new String[] {"Outlier", "Residual", "Variance", "Standard Error"}, "Residual"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: The method of Ordinary Least Squares (OLS) fits a line by minimizing the sum of the squared residuals.", "True"),
            new Question(new MultipleChoiceQuestionStrategy(), "A correlation coefficient (r) of -1 indicates:", new String[] {"No relationship", "A weak positive relationship", "A perfect negative linear relationship", "A perfect positive linear relationship"}, "A perfect negative linear relationship"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: R-squared (the coefficient of determination) represents the proportion of the variance in the dependent variable that is predictable from the independent variable.", "True"),

            // --- WRITTEN CONCEPTS ---
            new Question(new WrittenQuestionStrategy(), "What is the square root of Variance?", "Standard Deviation"),
            new Question(new WrittenQuestionStrategy(), "What is the most frequent value in a given dataset called?", "Mode"),
            new Question(new WrittenQuestionStrategy(), "What rule determines the probability of Event A AND Event B occurring if they are independent?", "Multiplication Rule"),
            new Question(new WrittenQuestionStrategy(), "The probability of an impossible event is exactly what number?", "0"),
            new Question(new WrittenQuestionStrategy(), "What shape does a standard Normal Distribution curve have?", "Bell")
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