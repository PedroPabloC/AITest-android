# Introducción a Dialogflow
Reconocimiento de voz mediante inteligencia artificial



**URL de las diapositivas**

[Diapositivas](https://drive.google.com/file/d/1R7PvqGCNkM9r_C0RJ2qzHiW6l0o1zsi1/view?usp=sharing)

**URL del vídeo**
https://youtu.be/zhYC7kEh7KM



## Intruducción

### ¿Qué es Dialogflow? 

El asistente de este proyecto se basa en Dialogflow, que es una plataforma con comprensión del lenguaje natural que facilita el diseño de una interfaz de usuario de conversación y su integración a una aplicación para dispositivos móviles, aplicaciones web, dispositivos, bots, sistemas de respuesta de voz interactiva, entre otros. Dialogflow da lugar a nuevas y atractivas formas para que los usuarios interactúen con tu producto. Resumiendo los pasos que sigue esta herramienta de google, tenemos que primero el usuario ingresa información, se hace una consulta de esta información, se determina el intent y se manda a este, el intent entra en proceso y hace sus acciones y respuestas necesaria, se envían parámetros al proyecto para finalizar con datos que determinan alguna acción y mandarlos como respuesta.


### Conceptos básicos:
  - Agente: Es un módulo de comprensión del lenguaje natural que comprende los matices del lenguaje humano. Dialogflow traduce el texto o el audio del usuario final durante una conversación a datos estructurados que tus apps y servicios pueden comprender mientras éste los organiza (maneja las conversaciones con los usuarios finales). Un agente de Dialogflow es similar a un agente de un centro de llamadas humano. Debes entrenarlos para que se encarguen de las situaciones de conversación esperadas, y el entrenamiento no tiene que ser demasiado explícito. Manejará todos los procesos: intents, acciones, entidades, parámetros, etcétera. 

  - Intent: Un intent clasifica la intención del usuario final para un turno de conversación. Para cada agente defines muchos intents; tus intents combinados pueden manejar una conversación completa. Cuando un usuario final escribe o dice algo, lo que se denomina expresión de usuario final, Dialogflow hace coincidir la expresión del usuario final con el mejor intent en tu agente. La coincidencia de un intent también se conoce como clasificación de intent. Resumiendo lo anterior, se puede entender a un intent como una expresión del usuario final clasificada en cierto ámbito.
  
  - Acción: El campo de acción, que se encuentra en el apartado de "intents", es un campo de conveniencia sencillo que ayuda a ejecutar la lógica en el servicio. Cuando un intent coincide en el tiempo de ejecución, Dialogflow proporciona el valor de acción a la solicitud de webhook de entregas o la respuesta de interacción de la API. Se puede utilizar para activar lógica específica en tu servicio.
  
  - Parámetros: Cuando un intent coincide en el entorno de ejecución, Dialogflow proporciona los valores extraídos de la expresión del usuario final como parámetros. Cada parámetro tiene un tipo, llamado tipo de entidad, que dicta cómo se extraen los datos. La configuración de las frases para los parámetros es tan fácil como darle una selección a ciertas partes que se repiten y un mismo tipo de entidad.
  
  - Entidad: Cada parámetro de intent tiene un tipo, denominado tipo de entidad, que determina de forma exacta cómo se extraen los datos de una expresión de usuario final. Dialogflow proporciona entidades del sistema predefinidas que pueden coincidir con muchos tipos comunes de datos. Por ejemplo, hay entidades del sistema que coinciden con fechas, horas, colores, direcciones de correo electrónico, etcétera. También puedes crear tus propias entidades personalizadas para detectar coincidencias en datos personalizados. Por ejemplo, podrías definir una nueva entidad que haga referencia a algún tipo de comida típica o cierta expresión que solo se utiliza en tu zona, solo hace falta declararla y darle sinónimos.
  
  - Respuestas: Los intents tienen un controlador de respuestas integrado que puede mostrar respuestas después de la coincidencia del intent. Esta característica solo admite respuestas estáticas, aunque puedes usar referencias del parámetro en estas respuestas para volverlas dinámicas en algún sentido. Esto es útil para resumir la información proporcionada por el usuario final. Por ejemplo, la respuesta de tu intent podría ser: “De acuerdo, reservé una habitación para ti el $date”.
  
  - Contextos: Los contextos de Dialogflow son similares al contexto del lenguaje natural. Si una persona te dice “son naranjas”, necesitas contexto para entender a qué se refieren. Del mismo modo, para que Dialogflow maneje una expresión de usuario final como esa, debe proporcionarse un contexto con el fin de que coincida de forma correcta con un intent. Mediante los contextos, puedes controlar el flujo de una conversación. Si quieres configurar contextos para un intent, debes establecer contextos de entrada y salida, que se identifican mediante nombres de strings.
  
  - Eventos: En condiciones normales, se detecta una coincidencia con un intent cuando una expresión de usuario final coincide con una frase de entrenamiento del intent. Sin embargo, también puedes activar intents mediante eventos. Los eventos se pueden invocar de muchas maneras: por que un usuario: alertas, eventos específicos de la plataforma, eventos personalizados, etc.

## Creación de un agente:

1. Para empezar ingresamos con una cuenta de Google a la [plataforma](https://dialogflow.cloud.google.com/). Para configurar el reconocimiento de voz necesitamos primeramente un agente, para crearlo: 
   - Ir a la consola de Dialogflow. 

   - Si se solicita, acceder a la consola de Dialogflow. 

   - Hacer clic en Create agent, en el menú de la barra lateral izquierda. . 

   - Ingresa el nombre del agente, y el idioma y la zona horaria predeterminados. (Importante)

2. Luego necesitamos clasificar las expresiones del usuario en ciertos casos, para esto necesitamos un intent. Para crearlo nos dirigimos a la parte izquiera de la pantalla en el apartado "intents" y seleccionamos CREATE INTENT. Nos dirigirá a una nueva pantalla, en el principio de ésta está la opción para darle un nombre. Se le proporciona entonces un nombre que vaya de acuerdo a la función que realizará, después se le ingresan las frases de entrenamiento pensando en lo que el usuario final podría decir mientras se buscaba no ser repetitivos. Se recomienda dar al menos 10 frases de entrenamiento. Por ejemplo, para para un intent que programe citas en un dentista podría ponersele los siguientes: "Quiero una cita para el día 20 de noviembre", "Programa una cita el domingo 15 de octubre", "Ingresa una nueva cita para el 13 de enero".

3. Para poder obtener los parámetros de una expresión, es necesario que se configuren como una entidad que se quiere. Para el ejemplo anterior, es necesario que se señalen las palabras "día 20 de noviembre", "domingo 15 de octubre", "13 de enero" como una entidad $date.

4. En la misma pantalla del intent se le da un nombre a la acción para verificar que el intent se activó, tomando el mismo ejemplo se le puede poner "programarCitaFecha"

5. Nos dirigimos al final de la pantalla para configurar una respuesta respecto al intent en cuestión. Esta será la réplica que el sistema dará al verificarse el intent. Regresando al ejemplo anterior, se podría configurar como una respuesta "Programando una cita el día 20 de noviembre" o "He reservado una cita el día 13 de enero".

*Así de fácil es crear un agente en Dialogflow, puedes probar tu proyecto en la consola que está en el apartado derecho (con texto o voz)*

**En la siguiente [dirección](https://youtu.be/zhYC7kEh7KM) puedes encontrar un tutorial de una de las muchas implementaciones posibles para esta plataforma de Google, es el caso de Android Studio.**


#### Los datos y recursos de este repositorio fueron obtenidos de las siguientes fuentes:
- https://dialogflow.cloud.google.com/
- https://cloud.google.com/dialogflow/es/docs
- https://www.youtube.com/channel/UCUjFwZ-SEMK5k-i24VzRu0w
- https://github.com/veeyaarVR/dialogflowdemo







