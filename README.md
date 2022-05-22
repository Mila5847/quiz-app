# Get-A-Hundred Java Quiz for Geniuses Only
## Project Description
### Application's purpose
The Get-A-Hundred Java Quiz provides an easy and fun way to study the basic Java concepts. When the application starts, instructions are displayed in the question box to make the application user-friendly. The application possess 30 Java questions from which three are randomly selected everytime a new quiz is started. There are four possible answers per question, but only one right answer. A "New Quiz" button allows to start a new quiz with different questions. A "Submit Quiz" button provides a summary display of the user's performance. The summary display contains the score out of 3 (because there are three questions). It also has a funny message and a Java joke that are different depending on the score obtained. 

### Technologies Used When Building The Application
This desktop application is build using _Java_, _JavaFX_, and _BootstrapFX_ to create an appealing user interface.

### Challenges and Features for Future Implementation
#### Challenges
1. Creating the user interface (UI) in the desired way was challenging. I needed to imagine the layout of the UI components such as the buttons and the label for the question. I needed to put them in multiple horizontal and vertical boxes to create the planned look. I also needed to choose the proper color scheme that will be pleasant to the human eye.
2. Reading form the file with the 30 questions was also challenging. Since one line contained a question, the four possible answers, and the correct answer, I had to seperate the components on each line of the file with ';' and store the different elements in variables or ArrayList (for the possible answers, for example).
3. The JUnit Tests were interesting to do. Since I am not used to writing them, I needed extra time to verify that every method is tested properly.

#### Features for Improvement
1. The application and its components such as buttons and the label for the question are not resizable. If the question or the answers are longer than the width of their containers (buttons or labels), the content of the String is not entirely displayed (suspension points on the UI show that the String is too long). I believe that implementing a feature which allows the user to hover over the String (in the button or the label) to see its entire content would be useful or to make the UI more responsive.
2. I would like to create a Quiz instead of a random quiz by implementing the _IQuizzable_ interface in a different way. For example, I would want the questions to be sequentially displayed (not randomly) when a new quiz starts. For example, the first time a quiz is initialized, it would display the questions from one to three. When a new quiz is started with the "New Quiz" button, I would want questions four to six to be displayed.

## Design
### Classes Structure of the Application
The application has multiple classes and interfaces. There is an abstract class called _Question_. It contains the basic information of a question which is the question itself and the answer. The Question class implements an interace called _IValidatable_ which has a method that validates if the given answer is correct or not. The _MultipleChoiceQuestion_ class extends the _Question_ class since a multiple choice question is a question. Besides a question and an answer, a multiple choice question also contains an ArrayList of possible answers and a selected answer for each question. There is a _Quiz_ class  which contains an ArrayList of multiple choice questions. The class implements the _IQuizzable_ interface which contains a method to initialize the quiz, to submit it, and to display the summary. The initialize method reads from a file and stores the different parts of a file's line in variables or ArrayList, as mentionned above. This makes the quiz application flexible to other types of quizes since the file's content could be easily changed to other questions. The _RandomQuiz_ class extends the _Quiz_ class since a random quiz is a quiz. However, the _RandomQuiz_ class implements the _IShufflable_ interface which mixes the questions in the ArrayList they are stored in. The _QuizUI_ class contains the user interface with the labels and buttons. It is the part of the application with which the user interacts. 

### UML Diagram
![UML Diagram](UML.png)

### Screenshots of the Application

## Notes
For the sake of this project, the _IQuizzable_ interface was only implemented to the _RandomQuiz_ class since the quiz's purpose is to generate random questions. The _Quiz_ class can be instantiated to other subclasses definding other specific quizes. This allows the application to be extended on multiple levels.

