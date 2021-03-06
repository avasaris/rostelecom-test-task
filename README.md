# Особенности реализации первой части задания.

* Ссылка на WAR файл [скачать](https://github.com/avasaris/rostelecom-test-task/blob/master/target/rostelecom-1.0-SNAPSHOT.war)
  

* Используется БД Postgres вместо Oracle, как более привычная и доступная в данный момент.
* Параметры подключения к БД прописаны в файле config/rostelecom.properties.
* Создать базу и заполнить ее можно, используя файлы  config/init_PG_DB.sql и config/populate_PG_DB.sql
* В методе **ColorRepository.getAllSorted()** будет проведена принудительная инициализация коллекции, если от БД не получены значения.
* Использована IDE IntelliJ IDEA, как более привычная.
* Проект собран с использованием Maven. Зависимости
```xml
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.2.18</version>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.6</version>
        </dependency>
```
* Во фронтенд части используются библиотеки [jquery](https://jquery.com/) и [json2html](https://json2html.com/). Обе подгружаются через CDN.

# Ответ на вторую часть зададания.
Исходя из документации 
- [Calling Stored Procedures in Java DB and MySQL](https://docs.oracle.com/javase/tutorial/jdbc/basics/storedprocedures.html#calling_javadb_mysql)
- [Calling PL/SQL from Java](https://docs.oracle.com/cd/E11882_01/java.112/e10588/chseven.htm#JJDEV13295)
  
код будет следующим:
```java
   Java.sql.Connection conn = ...
   
   String inputString = "Hello, Oracle!";
   
   CallableStatement cstmt = conn.prepareCall("{? = CALL get_info(?)}");
   cstmt.registerOutParameter(1, Types.VARCHAR);
   cstmt.setString(2, inputString);
   cstmt.executeUpdate();
   
   String resultString = cstmt.getString(1);
```

# Тестовое задание.

1. Основное задание:

1.1.  Дана таблица из 7 цветов c названием «TSVETA» в БД Oracle в виде:
      Поля таблицы:
```
        id              NUMBER NOT NULL
        color_number    VARCHAR2(2)
        name            VARCHAR2(50)
```

Значения в таблице:
```
id	color_number	name
1	01	Red
2	02	Orange
3	03	Yellow
4	04	Green
5	05	Blue
6	06	Dark blue
7	07	Violet
```
Нужно на java используя JDBC получить данные 2-й и 3-й колонок и заполнить ими любую java-коллекцию значениями объектов.

Далее вернуть эту коллекцию в jsp-страницу в виде JSON (org.json.JSONArray): [{“color_number”:”01”, “name”:”Red”}, …]

Отобразите в jsp-странице информацию из JSON в виде таблицы (color_number, name). Можно с pagination или «бесконечным» скроллингом.

1.2. При выборе (наведении и нажатии мышкой) на ячейку таблицы с названием цвета «name» из ранее выведенных на экран строк из JSON в виде таблицы, в отдельном поле выше таблицы должны появляться/отображаться данные из всей строки «выбранной мышкой» через запятую, а цвет фона строки должен быть как написано в поле «name». Сделать эту часть задачи используя Javascript конструкцию.

2. Предположим, у вас есть:
   - Oracle процедура ”get_info” c одним входным параметром (строка) и с одним выходным параметром (строка);
   - Есть уже полученная коннекция к БД Java.sql.Connection conn myConnection.

   Нужно на java, используя JDBC, написать код вызова процедуры get_info. Оформить вызов в виде метода, в котором входной и выходной параметры строки. Метод возвращает выходной параметр процедуры “get_info”.


3. Требования к реализации:
   - Тестовое задание необходимо выполнить на бесплатном IDE NetBeans лучше на версии 8.2, на Java версии 7/8 без фреймворков на контейнере JVM Tomcat (можно скачать из интернета в свободном доступе).
   - Результат тестового задания в виде компилируемого исходного кода и war файла нужно выложить на github и прислать ссылку.
   - Для ускорения проверки, если вы выполняете тестовое задание с какими-то своими «библиотеками» и особенностями, то загрузите их на github и напишите об этом в комментариях к проекту readme, так как это так же показывает ваши навыки работы в команде и понятность выполненной работы.
