# newsstack
ENGLISH (Polish below):
NewsStack is a Java project aimed at strengthening the knowledge acquired during a Web Technologies course on https://javastart.pl/. It is not based on popular frameworks, because I wanted to understand how all main mechanisms work underneath. The next step would be the project based on Spring and Angular, which will soon appear on my Github.

NewsStack is an application allowing you to add "discoveries" being anything from the Internet. Logged-in user can create a discovery by adding a description and a link to it. All webpage visitors can browse through discoveries and their particular categories, while logged-in users can also vote on them using up/down arrows. 

Application has been created using Maven and based on software design pattern MVC with additional layer between data access layer and controllers. View layer has been made using JSP pages, controllers layer using servlets, and model layer has been divided into services layer and data access layer. Dao classes (Data access object) are responsible for communication with database.  Then, to communicate with controllers and view Dto objects (Data transfer object) are used. Application is run on Tomcat server. Application uses MySQL database utilizing JDBC API. In order to improve legibility JSPF segments have  been created. 


POLSKI:
NewsStack jest projektem, którego głównym celem było utrwalenie wiedzy nabytej podczas kursu Technologii Webowych stworzonego przez https://javastart.pl/. Nie jest on oparty na popularnych frameworkach, ponieważ chciałem zrozumieć jak wszystie podstawowe mechanizmy działają pod spodem. Kolejnym etapem będzie projekt oparty o Springa i Angulara, który niedługo pojawi sie na moim Githubie. 

NewsStack to aplikacja pozwalająca dodawać "znaleziska" będące dowolnymi rzeczami z internetu. Zalogowany użytkownik może stworzyć znalezisko, podając opis i odpowiedni link. Wszyscy odwiedzający stronę mogą przeglądać znaleziska oraz poszczególne ich kategorie, a użytkownicy zalogowani mogą na nie także głosować za pomocą strzałek góra/dół.

Aplikacja stworzona została w oparciu o Mavena, na bazie wzorca architektonicznego MVC z dodatkową warstwą pośrednią między warstwą dostępu do danych i kontrolerami. Warstwa widoku realizowana jest za pomocą dynamicznych stron JSP, wartwa kontrolerów za pomocą serwletów, a warstwa modelu podzielona jest na warstwę usług i warstwę dostępu do danych. Klasy Dao(Data Acces Object) odpowiadają za komunikację z bazą danych. Następnie do komunikacji z kontrolerami i widokiem wykorzystywane są obiekty Dto - Data Transfer Object.
Aplikacja uruchamiana jest na kontenerze serwletów Tomcat. Aplikacja korzysta z bazy danych MySQL z użyciem JDBC API. W celu poprawienia czytelności wydzielone zostały segmenty stron JSP które powtarzają się. 
