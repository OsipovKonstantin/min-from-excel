# Сервис расчёта n-ого минимального числа из excel-файла

[![Java](https://img.shields.io/badge/-Java%2017-F29111?style=for-the-badge&logo=java&logoColor=e38873)](https://www.oracle.com/java/)
[![Spring](https://img.shields.io/badge/-Spring%20Boot%202.7-6AAD3D?style=for-the-badge&logo=spring-boot&logoColor=90fd87)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/-Maven-7D2675?style=for-the-badge&logo=apache&logoColor=e38873)](https://maven.apache.org/)
[![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)](https://editor-next.swagger.io/)
[![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![RestAPI](https://img.shields.io/badge/-rest%20api-007EC0?style=for-the-badge&logo=restapi&logoColor=275ecf)](https://restfulapi.net/)

## Описание

Создание эндпоинта для расчёта n-ого минимального числа из excel-файла (формата xlsx) на основе следующих данных: 
1. путь к файлу, 
2. число n
Числа в excel располагаются в первом столбце таблицы начиная с 1-ой строки

## Архитектура

API представлено в виде эндпоинта GET /api для n-ого минимально числа из excel-файла

## Как запустить и использовать

Для локального запуска бекенд-приложения установите и откройте программу
[Docker Desktop](https://www.docker.com/products/docker-desktop/).
<br>Затем в командной строке cmd выполните следующие команды

   ```
git clone git@github.com:OsipovKonstantin/min-from-excel.git
cd ~/min-from-excel
mvn clean package
docker-compose up
   ```

Приложение готово к использованию! Документация Swagger доступна по адресу 
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
