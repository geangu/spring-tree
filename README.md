# Prueba Técnica

Dado un árbol binario, encuentre el ancestro común más cercano entre dos nodos.

**Input :**

    70,84,85
    70,84,78,80
    70,84,78,76
    70,49,54,51
    70,49,37,40
    70,49,37,22

El árbol correspondiente a estos datos es el siguiente:

![](https://i.imgur.com/qEINMlt.png)

**Output**:

    ancestor(40,78) = 70
    ancestor(51,37) = 49
    ancestor(76,85) = 84

### Diseñe un API REST que permita:

1.  Crear un árbol.    
2.  Dado un árbol y dos nodos, retorne el ancestro común más cercano.

### Solución

Se implementa la solución del problema expuesto usando SpringBoot para exponer un API REST que permita crear el árbol, añadir nodos y buscar el ancestro de común mas cercano de dos nodos.

### Requerimientos

- [Docker](https://www.docker.com/)
- [Docker compose](https://docs.docker.com/compose/)

### Iniciando la aplicación

Para hacer uso del API creado se debe ejecutar el siguiente comando en la raíz del proyecto:

	$ docker-compose up

Para comprobar que la aplicación se encuentra funcionando puede ingresar a: 

http://localhost:5000/api/v1/ 

Se mostrará un mensaje como el siguiente:

	API version 1.0.0

### Endpoints

**Crear árbol**

	[POST]
	http://localhost:5000/api/v1/trees
	{
		"id":"1",
		"content": "70,84,85\n70,84,78,80\n70,84,78,76\n70,49,54,51\n70,49,37,40\n70,49,37,22\n"
	}

**Añadir nodos al árbol**

	[PUT]
	http://localhost:5000/api/v1/trees?id=1&content=70,87

**Buscar ancestro**

	[GET]
	http://localhost:5000/api/v1/ancestor?id=1&node1=85&node2=76

**Mostrar árboles**

	[GET]
	http://localhost:5000/api/v1/trees