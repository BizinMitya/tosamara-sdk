# SDK для работы с API портала [tosamara.ru](http://tosamara.ru/api)
Проект является библиотекой, написанной на Java, которая предназначена для работы с данными об общественном транспорте города Самара.

Для работы с API используются 2 класса: `Classifiers` и `ToSamaraAPI`.
Класс `Classifiers` используется для получения справочников, поэтому не требует _clientId_ и _key_.
Класс `ToSamaraAPI` используется для вызова методов API. Конструктор класса `ToSamaraAPI(String clientId, String key, String os)` принимает _clientId_ и _key_, выданные порталом, и _os_ - указание ОС, с которой будут выполняться запросы.

[![Maven Central](https://img.shields.io/maven-central/v/com.github.useful-solutions/tosamara-sdk.svg?color=green)](https://search.maven.org/artifact/com.github.useful-solutions/tosamara-sdk/1.4/jar)
![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.github.useful-solutions/tosamara-sdk.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=useful-solutions_tosamara-sdk&metric=alert_status)](https://sonarcloud.io/dashboard?id=useful-solutions_tosamara-sdk)

Для подключения библиотеки через Maven, нужно добавить зависимость:

```xml
<dependency>
    <groupId>com.github.useful-solutions</groupId>
    <artifactId>tosamara-sdk</artifactId>
    <version>1.4</version>
</dependency>
```

Для подключения библиотеки через Gradle, нужно добавить зависимость:

```implementation 'com.github.useful-solutions:tosamara-sdk:1.4'```
