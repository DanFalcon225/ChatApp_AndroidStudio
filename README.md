# ChatApp_AndroidStudio
A chat application in Android Studio using Firestore and Firebase Cloud Messaging

Prerequisites:

1) Enable Firestore and Could Messaging in Android Studio IDE

  1.1) Since Android Studio IDE is constantly gets updated the manual of the set up which is given in Firebase website is outdated in particular aspects. For instance, 
  configuration of Firebase files and corresponding SDK requires less coding now but on Firebase website users are still advised to follow the old steps.
  Therefore, it is advisable to set up Firebase through Android Studio IDE.
  
2) Set up service key for the push notification feature:

On Firebase go to the project setting -> open Cloud Messaging tab -> copy a server key -> Open Utilities folder in a project (in Android Studio IDE) ->
pasted copied key in Constants.java (make sure "key=" is written at the beginning)

<img width="1437" alt="image" src="https://user-images.githubusercontent.com/93957570/171539694-7bf0c7ef-1f5f-488b-a522-99c0f9f6ff56.png">


<img width="1061" alt="image" src="https://user-images.githubusercontent.com/93957570/171539586-c8d84239-9be3-4ba7-b566-a031ab21e3b4.png">

PS

Please note that push notification works on Android version up to 11.
So, make sure you are installing emulator with appropriate version.
