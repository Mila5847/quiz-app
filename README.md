# Get-A-Hundred Java Quiz for Geniuses Only
## Project Description
### Application's purpose
The Get-A-Hundred Java Quiz provides an easy and fun way to study the basic Java concepts. When the application starts, instructions are displayed in the question box to make the application user-friendly. The application possess 30 Java questions from which three are selected everytime a new quiz is started. There are four possible answers per question, but only one right answer. A "New Quiz" button allows to start a new quiz with different questions. A "Submit Quiz" button provides a summary display of the user's performance. The summary display contains the score out of 3 (because there are three questions). It also has a funny message and a Java joke which are different depending on the score obtained. 

### Technologies Used When Building The Application
The application is build using an IDE called _IntelliJ IDEA_. It is written in _Java_. The _BootstrapFX_ dependency is used to create an appealing user interface. The quiz is made of classes and interfaces. 

### Challenges and Features for Future Implementation
#### Challenges
1. Creating the user interface (UI) in the desired way was challenging. I needed to imagine the layout of the UI components such as the buttons and the label for the question. I needed to put them in multiple horizontal and vertical boxes to create the wanted layout. I also needed to choose the proper color scheme that will be pleasant to the human eye.
2. Reading form the file with the 30 questions was also challenging. Since one line contained a question, the four possible answers, and the correct answer, I had to seperate the components of a file's line with ';' and store the different elements of the file in variables or ArrayList (for the possible answers).
3. The JUnit Tests were interesting to do. Since I am not used to writing them, I needed extra time to verify that every method is tested properly.

#### Features for Improvement
1. The application and its components such as buttons and the label for the question are not resizable. If the question or the answers are longer than the width of their containers (buttons or labels), the content of the String is not entirely displayed (suspension points shows that the String is too long). I believe that implementing a feature which allows the user to hover over the String (in the button or the label) to see its entire content would be useful.
2. If someone decides to create a Quiz, instead of a RandomQuiz, the _IQuizzable_ interface must be implemented in the desired way.
## Design
### Classes Structure of the Application
The application has multiple classes and interfaces. There is an abstract class called _Question_. It contains the basic information of a question which is the question itself and the answer. The Question class implements an interace called _IValidatable_ which has a method that validates if the answer selected by the user is correct or not. The _MultipleChoiceQuestion_ class extends the _Question_ class since a multiple choice question is a question. Besides a question and an answer, a multiple choice question also contains an ArrayList of possible answers and a selected answer for each question. There is a _Quiz_ class  which contains an ArrayList of multiple choice questions. The class implements the _IQuizzable_ interface which contains a method to initialize the quiz, to submit it, and to display the summary display. The initialize method reads from a file and stores the different parts of a file's line in variables or ArrayList, as mentionned above. This makes the quiz application flexible to other types of quiz by chnaging the file's content to different questions. The _RandomQuiz_ class extends the _Quiz_ class since a random quiz is a quiz. However, the _RandomQuiz_ class implements the _IShufflable_ interface which mix the questions in the ArrayList they are stored. By doing this, the random questions have less chance of being repeated when a new quiz is initialized. The _QuizUI_ class contains the user interface wiht the labels and buttons. It is the part of the application with which the user interact.  

## Notes
For the sake of this project, the _IQuizzable_ interface was only implemented to the _RandomQuiz_ class since the quiz's purpose is to generate random questions. The _Quiz_ class can be instantiated to other subclasses definding specific quizes, like the _RandomQuestion_ class. This allows the application to  be extended on multiple levels.

### UML Diagram

