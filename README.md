# <span style="color: green;">Payment API</span>

Este proyecto contiene una API REST para gestionar el registro de pagos, dividida en tres módulos: dominio, infraestructura y aplicación.

___

## <span style="color: green;">Docker Compose</span>

Comando para compilar el proyecto:
```bash
docker-compose build
```

Comando para levantar el proyecto:
```bash
docker-compose up -d
```

Comando para parar el proyecto:
```bash
docker compose down
```
___

## <span style="color: green;">Swagger</span>

[URL de Swagger](http://localhost:8080/swagger-ui/index.html)

En dicha url se podrá comprobar el funcionamiento de los endpoints:

| Tipo de método | End point |
|----------------|-----------|
| POST           | /payment  |
| GET            | /payment  |

___

## <span style="color: green;">Conexión con la base de datos Postgres</span>

Información necesaria para conectarse a la base de datos de Postgres mediante alguna herramienta similar a DBeaver:

| Campo         | Valor                                    |
|---------------|------------------------------------------|
| url           | jdbc:postgresql://localhost:5432/payment |
| host          | localhost                                |
| puerto        | 5432                                     |
| base de datos | payment                                  |
| usuario       | root                                     |
| contraseña    | root                                     |

___

## <span style="color: green;">Informe Cobertura y mutaciones</span>

Se agrega el informe generado mediante la herramienta PIT para obtener la cobertura del proyecto y mutaciones.
Las mutaciones son cambios generados en nuestro código por dicha herramienta que deben ser detectados por nuestros tests.

[Informe de PIT](./report/index.html)

| Paquete                                      | Número de clases | Cobertura de líneas | Cobertura de mutaciones | Calidad de los tests |
|----------------------------------------------|------------------|---------------------|-------------------------|----------------------|
| com.ntt.payment.application.controller       | 2                | 100% (7/7)          | 100% (4/4)              | 100% (4/4)           |
| com.ntt.payment.application.controller.api   | 2                | 0%   (0/30)         | 0%   (0/13)             | 100% (0/0)           |
| com.ntt.payment.application.controller.model | 3                | 46%  (37/81)        | 41%  (18/44)            | 82%  (18/22)         |
| com.ntt.payment.application.mapper           | 3                | 100% (42/42)        | 100% (21/21)            | 100% (21/21)         |
| com.ntt.payment.domain.model                 | 2                | 100% (34/34)        | 45%  (35/77)            | 58%  (35/60)         |
| com.ntt.payment.domain.service               | 1                | 100% (3/3)          | 100% (2/2)              | 100% (2/2)           |
| com.ntt.payment.infrastructure.adapter       | 1                | 100% (3/3)          | 100% (2/2)              | 100% (2/2)           |
| com.ntt.payment.infrastructure.entity        | 1                | 100% (9/9)          | 100% (6/6)              | 100% (6/6)           |
| com.ntt.payment.infrastructure.mapper        | 2                | 100% (40/40)        | 100% (14/14)            | 100% (14/14)         |
