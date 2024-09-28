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

| Paquete                                 | Número de clases | Cobertura de líneas | Cobertura de mutaciones | Calidad de los tests |
|-----------------------------------------|------------------|---------------------|-------------------------|----------------------|
