# Ehliyet Cepte - Android/Kotlin
---
Ehliyet Cepte is an app created for people who prepares driving licence written exam. This app will be the revised version of the <a href="https://play.google.com/store/apps/details?id=com.bzkndev.cepparagraf" target="_blank">Cep Paragrafi</a>.

## Description
---
The application will basically provide exams in different categories to the users. Besides these exams will contain various features such as solving questions that answered wrong, most popular questions that has been seen on recent exams, displaying solved exams, notes & tips for some traffic topic, actual driving exam instructions, a function to track remaining time for the exam etc.

This app will revise the <a href="https://play.google.com/store/apps/details?id=com.bzkndev.cepparagraf" target="_blank">Cep Paragrafi</a> as coming it with completely different topic. New app will be revise the Cep Paragrafi in the meaning of the old technologies, libraries that has been used 2 years ago. The application is using some of the most current Android Libraries such as <a href="https://developer.android.com/topic/libraries/architecture/datastore?gclid=EAIaIQobChMIv-zh_rSF9wIVU5nVCh2MCwW7EAAYASAAEgKoofD_BwE&gclsrc=aw.ds" target="_blank">Jetpack DataStore</a>, <a href="https://developer.android.com/kotlin/coroutines?gclid=EAIaIQobChMI7Me-lrWF9wIV1PhRCh1OOwC_EAAYASAAEgJk9_D_BwE&gclsrc=aw.ds" target="_blank">Kotlin Coroutines</a>, <a href="https://developer.android.com/training/dependency-injection/hilt-android" target="_blank">Hilt for DI</a>, <a href="https://developer.android.com/training/data-storage/room" target="_blank">Room Database</a> etc. 
</br></br>
The application is not fully finished and still in the development process. Also the application will eventually be released on Play Store and it will contain ads so I'm planning to make some revenues as I'm planning and actively learning new topics, technologies, developing my coding skills and knowledges from this app. 

## Architecture
---
This application is developed with following the <a href="https://developer.android.com/jetpack/guide?gclid=EAIaIQobChMImePW5LiF9wIVEdN3Ch2kgg1OEAAYASAAEgJ2-vD_BwE&gclsrc=aw.ds" target="_blank">Model-View-ViewModel (MVVM)</a> and Clean Architecture methodologies to create clean, maintainable code and lifecycle aware structure. Application is following the Single-Activity pattern as it also does not contain much screens. 
</br></br>
The questions in this application are not coming from any remote web server and application does not contain any web service communication tools/libraries like retrofit, volley, okhttp etc. All the words in the application is are prepared in a json format and stored in local database (Room). The exams.json file is used to <a href="https://developer.android.google.cn/training/data-storage/room/prepopulate?hl=en" target="_blank">Prepopulate</a> the Room database single time when the app is first installed with using <a href="https://developer.android.com/reference/android/arch/persistence/room/RoomDatabase.Callback" target="_blank">RoomDatabase.Callback</a>. These database operations and other long running operations are executed asynchronously with using <a href="https://developer.android.com/kotlin/coroutines?gclid=EAIaIQobChMI7Me-lrWF9wIV1PhRCh1OOwC_EAAYASAAEgJk9_D_BwE&gclsrc=aw.ds" target="_blank">Kotlin Coroutines</a> for protecting UI from blocked by these long operations. Other than Room database, <a href="https://developer.android.com/topic/libraries/architecture/datastore?gclid=EAIaIQobChMIv-zh_rSF9wIVU5nVCh2MCwW7EAAYASAAEgKoofD_BwE&gclsrc=aw.ds" target="_blank">Jetpack DataStore</a> is used to store small amount of data like User settings (app language, theme etc.) as key-value pairs in thread-safe way with of course Kotlin Coroutines. Also application uses <a href="https://developer.android.com/guide/navigation/navigation-getting-started" target="_blank">Navigation Components</a> to handle navigation between fragments.
</br></br>

### Technologies, Tools & Libraries Used
---
- <a href="https://developer.android.com/jetpack/guide" target="_blank">Architecture</a>
  - <a href="https://developer.android.com/guide/navigation?gclid=Cj0KCQiAj9iBBhCJARIsAE9qRtB8q19xWrOMU0xmUn61XdeIv8N7920hIVv1NtWswr5ZegovD3HwUYsaAm2IEALw_wcB&gclsrc=aw.ds" target="_blank">Jetpack Navigation</a> - To handle in-app navigation.
  - <a href="https://developer.android.com/training/data-storage/room" target="_blank">Room Database</a> - To store large amount of data such as they are exams and questions in this app's case (The application will contain more than 50 exams).
  - <a href="https://developer.android.com/topic/libraries/architecture/livedata" target="_blank">LiveData</a> - To build a lifecycle-aware dataset and notify the UI immediately when related data changes.
  - <a href="https://developer.android.com/jetpack/guide" target="_blank">Model-View-ViewModel</a> - To have much more maintainable and clean code, lifecycle-aware structure.
  - <a href="https://developer.android.com/training/dependency-injection/hilt-android" target="_blank">Dagger-Hilt</a> - For dependency injection.
  - <a href="https://developer.android.com/topic/libraries/architecture/datastore?gclid=EAIaIQobChMIv-zh_rSF9wIVU5nVCh2MCwW7EAAYASAAEgKoofD_BwE&gclsrc=aw.ds" target="_blank">Jetpack DataStore</a> - To store small sized data with key-value pairs.
  - <a href="https://developer.android.com/jetpack/androidx/releases/lifecycle" target="_blank">Lifecycle SDK</a> - To access and use most recent functionalities of the lifecycle components like fragments, viewmodels etc.

---
Although the application will be released on the Google Play Store, this repository and all the files of the app will be stay as public & open source so anyone can access, contribute and declare issues & problems and provide solutions. It's all open!
