# FireChat
FireChat is a chat app integrated with Firebase and Google translate API created for a code workshop hosted by the The Assembly. Users can enter their name, choose their preferred language and join a chat room. No matter what language other users use, the text will be translated to the users selected language enabling a multi-lingual platform.

# Setting up firebase

1. Go to firebase.google.com and click on go to console 

<img width="1440" alt="screen shot 2018-06-09 at 11 11 38 pm" src="https://user-images.githubusercontent.com/33552991/41195435-8e4e5e76-6c3e-11e8-84b0-85a7e8350063.png">

2. Click on add project in the console and create a new project

<img width="1440" alt="screen shot 2018-06-09 at 11 11 53 pm" src="https://user-images.githubusercontent.com/33552991/41195457-dbc162ac-6c3e-11e8-9262-f6be02577cbe.png">

3. After being redirected, go to database from the nav bar and click on get started with real time database.<b>Start in test mode</b>

<img width="1440" alt="screen shot 2018-06-09 at 11 12 46 pm" src="https://user-images.githubusercontent.com/33552991/41195475-167ce89e-6c3f-11e8-8185-96bbe8017b94.png">

4. Go to project overview from the nav bar and select add firebase to your android app

<img width="1440" alt="screen shot 2018-06-09 at 11 13 15 pm" src="https://user-images.githubusercontent.com/33552991/41195501-6d49dcae-6c3f-11e8-8b5d-67fac535fa6b.png">

5. Enter your android package name which is available in AndroidManifest.xml

<img width="1440" alt="screen shot 2018-06-09 at 11 17 48 pm" src="https://user-images.githubusercontent.com/33552991/41195516-b54c2c0a-6c3f-11e8-90a3-8ae2ae540a47.png">

<img width="1440" alt="screen shot 2018-06-09 at 11 16 21 pm" src="https://user-images.githubusercontent.com/33552991/41195515-b1cfd0a4-6c3f-11e8-812d-ad86b7c16408.png">

6. Download the google-services.json file and place it in your app directory

<img width="1440" alt="screen shot 2018-06-09 at 11 18 10 pm" src="https://user-images.githubusercontent.com/33552991/41195529-edaec490-6c3f-11e8-9052-e8f4b8c148f8.png">

<img width="692" alt="screen shot 2018-06-09 at 11 20 15 pm" src="https://user-images.githubusercontent.com/33552991/41195539-27bcbb6a-6c40-11e8-8238-9532c1f11e72.png">

For more info check out - https://firebase.google.com/docs/android/setup

# Setting up Google Translate API

1. Go to cloud.google.com and click on go to console

2. Create a new project and select API & Services from the sliding navigation bar

<img width="1440" alt="screen shot 2018-06-09 at 11 21 24 pm" src="https://user-images.githubusercontent.com/33552991/41195558-b97c2518-6c40-11e8-92b9-568d20c0d710.png">

3. Click on Enable Services and API

<img width="1440" alt="screen shot 2018-06-09 at 11 21 43 pm" src="https://user-images.githubusercontent.com/33552991/41195571-fd6414fc-6c40-11e8-8b1a-e21ea898add6.png">

4. Search for Google Translate API and enable it

<img width="1440" alt="screen shot 2018-06-09 at 11 23 29 pm" src="https://user-images.githubusercontent.com/33552991/41195578-2e1f53ea-6c41-11e8-88ad-9271b08f311c.png">

5. Go back and go to credentials

<img width="1440" alt="screen shot 2018-06-09 at 11 21 43 pm copy" src="https://user-images.githubusercontent.com/33552991/41195596-735699fa-6c41-11e8-8ca9-5271563295e5.png">

6) Click on create credentials and click on API key

<img width="420" alt="screen shot 2018-06-06 at 2 21 04 am" src="https://user-images.githubusercontent.com/33552991/41005875-4d175180-6930-11e8-8aae-969e90f00b12.png">

7) Replace the generated API key for the API_KEY placeholder in MenuActivity.java on Line 27 and in ChatActivity.java on Line 34

For more info check out - https://cloud.google.com/translate/

