Springfox mediatype override bug demo
=====================================

A demo project that demonstrates a bug in Springfox where the docket level consumes and produces media-types can't be overriden on a resource level.
The global consumes and produces are always added to them.

Demo and bug explanation
=================

 - Execute: mvn spring-boot:run
 - Open the browser to: http://localhost:8080/swagger-ui.html
 - Open 'docket-level-consumes-produces-resource'
 - Open PUT /docket-level/consumes
 - Notice that under 'data' the 'Parameter content type:' selectbox contains `application/xml`, `application/json` and `text/plain`. 
 - See the method `DocketLevelConsumesProducesResource.produces` and notice that the @GetMapping produces field only contains `text/plain`.
 - See the `Application.docketLevelConsumesProducesApi` method and see that we define 'produces' and 'consumes' on the docket level. These contain the 
   `application/json` and `application/xml` mediatypes.
   What happens is that these two media-types are merged with the resource level media-type from the `DocketLevelConsumesProducesResource.produces` method.
   These should not be merged however. The docket level produces and consumes should only be declared on a global level and shouldn't be merged with the 
   resource media-types.
 - When you define the produces and consumes only on a controller level then the correct behaviour is shown. See the '2-controller-level' docket group with
   the corresponding `ControllerLevelConsumesProducesResource` class.

