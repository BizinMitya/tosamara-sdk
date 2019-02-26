# SDK для работы с API портала [tosamara.ru](http://tosamara.ru/api)
Проект является библиотекой, написанной на Java, которая предназначена для работы с данными об общественном транспорте города Самара.

Для работы с API используются 2 класса: `ClassifierRequestImpl` и `APIRequestImpl`.
Класс `ClassifierRequestImpl` используется для получения справочников, поэтому не требует _clientId_ и _key_.
Класс `APIRequestImpl` используется для вызова методов API. Конструктор класса `APIRequestImpl(String clientId, String key, String os)` принимает _clientId_ и _key_, выданные порталом, и _os_ - указание ОС, с которой выполняются запросы.
