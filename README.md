# basic-hibernate
The objective of this project was to learn the basic entity lifecycle in Hibernate. In fact, Hibernate's EntityManager interface provides various methods for performing CRUD (Create, Read, Update, Delete). However, in this example, we will pick up persist, merge, refresh, detach, and remove to demonstrate.


## JPA’s entity lifecycle states
Before we dive deep into the way to use the operations provided by Hibernate and some code demonstrations, I would like to suggest understanding JPA’s entity lifecycle states from the picture and source below.![enter image description here](https://thorben-janssen.com/wp-content/uploads/2020/07/Lifecycle-Model-1024x576.png)

https://thorben-janssen.com/entity-lifecycle-model/

https://vladmihalcea.com/a-beginners-guide-to-jpa-hibernate-entity-state-transitions/


## Example of Hibernate's operations
As mentioned above, on this project, we will focus on four operations as shown in the picture below with descriptions.

|Operations                     |Description                  |
|-------------------------------|-----------------------------|
|`entityManager.persist`        |Convert an entity object to persist state and will save into database when commit/flush. (Create)|
|`entityManager.merge`          |Updates the state of a detached entity and synchronizes it with the database.|
|`entityManager.refresh`        |Refreshes the state of an entity from the database.|
|`entityManager.detach`			    |Detaches an entity from the persistence context, making it detached.|
|`entityManager.remove`			    |Deletes an entity from the database.|
