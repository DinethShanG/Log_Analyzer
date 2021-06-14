# Log_Analyzer 
Software Construction Final Project

Hacktoberfest 2020

SENG 21222 - Software Construction
Group Project
Log Analyze Notifier
September 08, 2020
Overview
According to SENG 21222 Software Construction final group project we have to create a log analyzer program which is if there is an errors program has to send a mail to the users with details of the errors. 
Goals
Read a log file using a given path: At the beginning of the program user input file path and read the log file with given file path if it exists.
Send mails for user: If there exists errors program has to send mail to the user with details of the errors.
Specifications
In this program, First User has to give the file path of the log file. Then the program has to read through the log file and scan for errors. If there are errors the program should retrieve the user mails from the database and the program has to send mail to the users. At the end of the program after sending mails, the program has to save the last timestamp that accesses the log file. Then at the next execution of the program , it has to  read the log file after the previous accessed timestamp.

Milestones
Read Log File, Read Last Access Date Time File, Write the Last Access Date Time File
My job is return divided error log statement from given log file.my first challenge was divide log statement then i was use 'split' function for it but I think 'substring' was effective than the 'split' function then I used substring for it.After that i used genetics for return those.Second challenge was compare the time in log file and time in the lastAccess file .I can find 'after' keyword in the DATE datatype.If lastAccess file was empty ,it had nullpointerexception,  for that I used if condition for check the null value.i got nullpointerexception because log file path was been wrong. I caught the null point exception and put the exit point to remove that error.
Database Connection and Retrieve User Data
When we got a task first we studied individually and then we discussed about task and what we do, what is the requirement of final output with our team members. As well as I referred some key points especially such as what is the log file, timestamp like vise because before we didn’t heard that words. When we got a real idea about that task then we divided the whole task into sub parts and also I got the database connection part. Here my archive task was to create a database for store a set of emails and retrieve all the emails from the database when we found error log lines and return those emails to the next excitable class.
First I set up all the necessary software tools correctly (XAMPP, JDBC driver like vise) and next I referred some reference materials and I built a code step by step. Another main thing is solid principles. Because normal code writing wasn’t suitable here we wanted to apply solid principles in our code so that again study about that principles and then complete my part quickly.
As well as, I faced some challenges when we were doing tasks. Main one is I don't have much practice to control the github. I have some knowledge but I didn’t do this project within github before. So then I asked my friends and worked together with my team. As well as I faced some problems when set up the requirement tools. At that moment I referee youtube videos as well. Then I could find solutions to those problems.
When we completed my part I studied other parts also and finally I got an overall idea about the full task and what are the other principles, theories which applied when completing the full task. As well as finally we held a discussion with all the team members and we discussed our mistakes, errors and here all members got ideas about whole parts of the project. So this is the best experience for me and we learned lots of theoretical parts and improved our soft skills mainly how to work with a team together. So exactly this project was a good experience for me to understand how we work in the real world industry as a team and how to succeed as a team.

Send mails using Mailgun API
In this project my part is creating the mail sending part. First challenge that I faced was I have not worked with API or SMTP mail sending before this project. so I have read some articles about java API mail sending including the documentation in mailgun. After that I selected the SMTP method to create my part. When I was coding, I saw that some libraries are needed for this code so I searched about that and I downloaded and imported two libraries “mail.jar” and “activation.jar”. Then my code part is done no errors but not working. Then I found that I should verify other emails that I hope to send. After verifying them my code is done. Then I push it into my branch in GitHub. But I notice that SMTP methods take some time to send emails. So, I started to try the API method.
Then I started my cording with that libraries and code is done when I was running the code I have to face a another problem there was an error “class not define”. So, I start to search about that error. I asked some of my friends about this error and finally I found that this error was occurred because of some problems in libraries. Then I read again to find what are the libraries that want to import. There are some libraries to import so I used maven dependency type to import the libraries. After importing that all libraries the code was worked without errors. Then I push it in to the GitHub branch to merge.

Monitor OOP Concepts and Maintain Best Coding Practices
In this project my responsibility is to maintain best coding practices and to add Object Oriented Concepts to the project and Maintain the code base in a structured and understandable way. When other team members push their contribution to their branches in the github repository and after receiving pull requests from each of them I had to face a lot of problems at the time of merging their request , Because there are some conflicts with the Main class. So Before Starting my part in the project first of all I have to merge the pull request by comparing both master and each branch then have to do changes and merge successfully.
After that I have to face a big Challenge Because after merging all branches to the master there were only 8 classes. To maintain the Solid principle I have to give one responsible to each class. Mainly, I have divided the program into 5 packages representing Database, File handling, EmailSending, User Interface, All Data models. In Database Package I have Created interface for CRUD operators then created class for MySQL database configuration. 
Then for the File Handling I have created interfaces for the File Reader and File Writer. Then the Emailing part has divided into an interface and 2 classes which is for Mailgun API and Email body Creator. 
The main part is to create classes for data models that are used in the programm. Error data and user details to communicate among the classes.After Creating all the classes when connecting them together I have to face some exceptions like null pointer exceptions,Class not found exception and etc. Null pointer exception has been resolved by doing some debugging steps and it causes due to empty objects, empty data sets. Class not found exception is occurred due to the import of wrong libraries like maven dependencies. Finally created UI class for user interaction and Execution class for all the executes. 
Unit Testing - I
In this project I did unit testing for some classes i.e. EmailBodyCreatorTest, FileReaderBufferedTest, FileWriterBufferedTest,  LogFileReaderTest, LastAccessFileReaderTest, LastAccessFileWriterTest, ExecutionTest. 
During the process of unit testing I faced some problems related to unit testing but rather than that I faced non-functional problems also i.e. I haven’t many experiences with GitHub handling so I struggled with push, pull, commit, merge, maintain branches etc. But I overcame that problem with the IntelliJ IDEA, this IDE offers me some Interfaces to ease my work.
When I tested, mostly I checked whether the expected and the actual values are equal and checked whether the return object is an instanceOf a class or not using assertThat(), assertEquals(). For EmailBodyCreatorTest I didn’t faced any problems, but when testing classes of FileRepository Package the test fails, the reader methods always returned null, because at first our team created a class called BufferedReader for read characters from files but BufferedReader is a class of java.io so it always returned null. We overcome that issue by implementing FileReaderBuffered and FileWriterBuffered classes. 
While testing LogFileReader and Execution I create mock objects to test i.e. create mocks while testing with databases, files etc. When I tested the Execution class I faced a problem with testing the stimulation of  System.in. I overcame that issue by referring to some stack overflow solutions. I used the SystemRules library and  created systemInMock and manually parse input values.
All time I commit to git from my IDE so I think there are some issues in verifying GitHub  accounts with IntelliJ IDEA. Because of that Git repository is not showing my contribution to the project. But it shows in the Insights tab.

Unit Testing - II
In this project my responsibility is testing some classes ( DateTimeTest , ErrorDataCollectorTest ,ErrorDataModelCreatorTest,ErrorDataTest, UserTest , UITest ).When I do unit testing for DateTimeTest i have face some issues in getting possible outputs.In my testing i want to get CurrentDateTime from my PC but when i do this i realize that  the test can’t pass the test. Because the time and date of my PC changing dynamically so that method didn’t return  the expected result.
When I do unit testing for ErrorDataCollectorTest using  should_collect_error_data() method errorDataList(Array List) save the error data. I have the basic knowledge on this by referring to stack overflow so i easily do that. But when i doing UITest i faced many problems regarding Testing system.in then i search articles on  JUnit How to simulate System.in testing (https://stackoverflow.com/questions/1647907/junit-how-to-simulate-system-in-testing) and i get to know about System Rules library and implement that one to solve my problem. 
When i doing testing for  ErrorDataTest, UserTest ,ErrorDataModelCreatorTest these classes i can able to get possible results because i earn lot of knowledge on those testing by referring solutions for my previous testing classes.




Team Members and Contribution
Thilina Madushan SE/2017/033 - MileStone 1
Randi Ayeshani SE/2017/025 - MileStone 2
Chinthaka Chathuranga SE/2017/003 - MileStone 3
Dineth Shan Gimhana SE/2017/013 - Milestone 4
Gnanasegaram Mangalan SE/2017/028 - Milestone 5
Prathaban Josiah SE/2017/022 - Milestone 6


