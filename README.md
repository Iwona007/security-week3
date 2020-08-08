# security-week3

Podstawowa
Stwórz formularz rejestracyjny z całą jego obsługą w ramach którego będzie możliwe zarejestrowanie nowego użytkownika 
z rolą User lub Admin. Rejestrujący sam wybiera czy chce mieć role User lub Admin. Zawsze wymagane jest, aby użytkownik 
potwierdził swój mail. Kiedy użytkownik w formularzu rejestracyjnym wybierze rolę Administratora, to do głównego 
administratora aplikacji idzie mailowo taka informacja. Dopóki główny admin nie kliknie linku aktywacyjnego to 
użytkownik ubiegający się o rolę Admin będzie miał tylko rolę User.
Stwórz kilka przykładowych endpointów pozwalających na przetestowanie wszystkich scenariuszy. Zadbaj o to, aby w
bazie danych nie pozostawały śmieci po aktywowanych tokenach. Uwzględnij również walidację danych zabezpieczając 
ją od strony przekazywania błędnych wartości użytkownika – niech będzie nie do złamania!😊

Jeśli zrobisz podstawową i należysz do ambitnych:
Stwórz formularz rejestracyjny z całą jego obsługą w ramach którego będzie możliwe zarejestrowanie nowego użytkownika. 
Zadbaj o to, aby użytkownik zweryfikował swój adres mail. W formularzu logowania daj możliwość wyboru na 
jak długo ma zostać zapamiętana jego sesja – 7 dni / 21 dni / 28 dni. Informacje na temat remember-me przechowuj po 
stronie bazy danych.

#####
Kindly please:
1: add datasource.
2: Add user and password for gmail-sender.

Technology:
java 11,
Spring Boot
Spring Security,
GUI: Thymeleaf
SQL: MySql
AOP: exception

images for registration page:
![img](https://github.com/Iwona007/security-week3/blob/master/src/main/resources/img/registration.PNG)

images for login page:
![img](https://github.com/Iwona007/security-week3/blob/master/src/main/resources/img/login-page.PNG)

images for verification token
![img](https://github.com/Iwona007/security-week3/blob/master/src/main/resources/img/verificationToken.PNG)

server port: 8081
