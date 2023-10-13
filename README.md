# jmoordbcore
Jmoordbcore
* Framework Java para NoSQL
  
  **Soporta:**
  
* Embebidos
* Embebidos con referencias
* Referencias
* Vistas
* JakartaEE/Eclipse Microprofile

Ejecute MongoDB

```shell
mongo

use testdb

```

Configure el archivo microprofile-config.properties

```
mongodb.uri=mongodb://localhost:27017
#-- Database de configuración
mongodb.jmoordb= configurationjmoordbdb

#-- Database History
mongodb.databasehistory=historydb

#-- Database
mongodb.database=accreditation
mongodb.database1=sft
mongodb.database2=practicadb

```


Defina una entidad
```java
@Entity
public class Persona {
@Id
private String id;
@Column
private String name;
}

```
Defina un repositorio

```
@Repository(entity = Persona.class)
public interface PersonaRepository extends CrudRepository<Persona, Long> {
}
```

Integrelo en su controller

```java
@Path("persona")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class PersonaController {
  @Inject
  PersonaRepository personaRepository;

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<User> findAll() {

        return personaRepository.findAll();
    }
}


```



## Libros


[Framework Java para bases de datos NoSQL.](https://leanpub.com/jmoordbcore)

[Building Modern Web Applications With Jakarta EE, NoSQL Databases and Microservices: Create Web Applications Jakarta EE with Microservices, JNoSQL](https://www.amazon.co.uk/Building-Applications-Jakarta-Databases-Microservices/dp/9389423341)
