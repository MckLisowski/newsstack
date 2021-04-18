# newsstack
NewsStack jest projektem którego głównym celem było utrwalenie wiedzy nabytej podczas kursu Technologii Webowych stworzonego przez https://javastart.pl/. Nie jest on oparty na popularnych frameworkach, ponieważ chciałem zrozumieć jak wszystie podstawowe mechanizmy działają pod spodem. Kolejnym etapem będzie projekt oparty o Springa i Angulara, który niedługo pojawi sie na moim Githubie. 

Newstack to aplikacja pozwalająca dodawać "znaleziska" będące dowolnymi rzeczami z internetu. Zalogowany użytkownik może stworzyć znalezisko, podając opis i odpowiedni link. Wszyscy odwiedzający stronę mogą przeglądać znaleziska oraz poszczególne ich kategorie, a użytkownicy zalogowani mogą na nie także głosować za pomocą strzałek góra/dół.

Aplikacja stworzona została w oparciu o Mavena, na bazie wzorca architektonicznego MVC z dodatkową warstwą pośrednią między warstwą dostępu do danych i kontrolerami. Warstwa widoku realizowana jest za pomocą dynamicznych stron JSP, wartwa kontrolerów za pomocą serwletów, a warstwa modelu podzielona jest na warstwę usług i warstwę dostępu do danych. Klasy Dao(Data Acces Object) odpowiadają za komunikację z bazą danych. Następnie do komunikacji z kontrolerami i widokiem wykorzystywane są obiekty Dto - Data Transfer Object.
Aplikacja uruchamiana jest na kontenerze serwletów Tomcat. Aplikacja korzysta z bazy danych MySQL z użyciem JDBC API. W celu poprawienia czytelności wydzielone zostały segmenty stron JSP które powtarzają się. 

NewsStack is a Java project aimed on strenghtening the knowledge acquired during a Web Technologies course on https://javastart.pl/. It doesn't use popular frameworks, because I wanted to undestand how it all works underneath, 
