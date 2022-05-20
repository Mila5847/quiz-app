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
2. If someone decides to create a Quiz, instead of a RandomQuiz, the questions from the Quiz would not be shuffled, since they are not selected randomly. However, everytime a new quiz is started, the three questions would always be the same since they do not get shuffled. ..........


