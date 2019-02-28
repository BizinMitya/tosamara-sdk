# SDK для работы с API портала [tosamara.ru](http://tosamara.ru/api)
Проект является библиотекой, написанной на Java, которая предназначена для работы с данными об общественном транспорте города Самара.

Для работы с API используются 2 класса: `ClassifierRequestImpl` и `APIRequestImpl`.
Класс `ClassifierRequestImpl` используется для получения справочников, поэтому не требует _clientId_ и _key_.
Класс `APIRequestImpl` используется для вызова методов API. Конструктор класса `APIRequestImpl(String clientId, String key, String os)` принимает _clientId_ и _key_, выданные порталом, и _os_ - указание ОС, с которой будут выполняться запросы.

Библиотека выложена в центральный репозиторий Maven.

Для подключения библиотеки через Maven, нужно добавить зависимость:

```xml
<dependency>
    <groupId>com.github.useful-solutions</groupId>
    <artifactId>tosamara-sdk</artifactId>
    <version>1.0</version>
</dependency>
```

Для подключения библиотеки через Gradle, нужно добавить зависимость:

```implementation 'com.github.useful-solutions:tosamara-sdk:1.0'```
